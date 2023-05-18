import {useCookies} from "react-cookie";
import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";


function AdminUsers() {
    const [cookies, setCookie] = useCookies(['name']);
    const [allUsers, setAllUsers] = useState([]);
    const navigate = useNavigate();
    const [loading, setLoading] = useState(true);
    const [person, setPerson] = useState("");


    if (!cookies.email && !cookies.password) {
        navigate('/login');
    }
    console.log("test")
    async function getData() {
        try {
            const response = await axios.get("http://localhost:8080/api/user/" + cookies.email + '/' + cookies.password);
            setPerson(response.data);
        } catch (error) {
            navigate("/login");
        }
    }

    async function AdminData() {
        try {
            const response = await axios.get("http://localhost:8080/api/users");
            setAllUsers(response.data);
            console.log(response.data)
        } catch (error) {
            console.error(error);
        }
    }

    async function handleUser(id) {
        await axios.get("http://localhost:8080/api/deluser/" + id);
        AdminData()
    }

    useEffect(() => {
        getData().then(() => {
            setLoading(false);
        });
    }, []);
    useEffect(() => {
        if (person && person.admin === 1) {
            AdminData();
            console.log(allUsers)
        }
    }, [person]);

    return (
        <>
            <button className={"backBtn"} onClick={() => navigate(-1)}><span>Go back</span></button>
            {person && person.admin === 1 && (
                <table className="responstable">
                    <tr>
                        <th>id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Delete</th>
                    </tr>
                    {allUsers.map(a =>
                        <tr className="each">
                            <td>{a.id}</td>
                            <td>{a.name}</td>
                            <td>{a.email}</td>
                            <td>{a.password}</td>

                            <td>
                                <button onClick={event => handleUser(a.id)}>❌</button>
                            </td>
                        </tr>
                    )}
                </table>
            )}
        </>
    );
}

export default AdminUsers;