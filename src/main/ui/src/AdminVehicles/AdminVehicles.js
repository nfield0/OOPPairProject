import {useCookies} from "react-cookie";
import axios from "axios";
import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";

function AdminVehciles() {
    const [cookies, setCookie] = useCookies(['name']);
    const [allvehicle, setAllVehicle] = useState([]);
    const navigate = useNavigate();
    const [loading, setLoading] = useState(true);
    const [person, setPerson] = useState("");


    if (!cookies.email && !cookies.password) {
        navigate('/login');
    }

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
            const vehiclesResponse = await axios.get("http://localhost:8080/api/vehicles/");
            setAllVehicle(vehiclesResponse.data);
        } catch (error) {
            console.error(error);
        }
    }

    async function handleChange(id, type) {
        await axios.get("http://localhost:8080/api/delVehicle/" + id + "/" + type + "s");
        console.log('deleting' + id + type)
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
        }
    }, [person]);

    return (
        <>
            <button className={"backBtn"} onClick={() => navigate(-1)}><span>Go back</span></button>
            {person && person.admin === 1 && (
                <table className="responstable">
                    <tr>
                        <th>id</th>
                        <th>Model</th>
                        <th>Make</th>
                        <th>Color</th>
                        <th>Type</th>
                        <th>Delete</th>
                    </tr>
                    {allvehicle.map(a =>
                        <tr className="each">
                            <td>{a.id}</td>
                            <td>{a.model}</td>
                            <td>{a.make}</td>
                            <td>{a.color}</td>
                            <td>{a.type}</td>
                            <td>
                                <button onClick={event => handleChange(a.id, a.type)}>❌</button>
                            </td>
                        </tr>
                    )}
                </table>
            )}
        </>
    );
}

export default AdminVehciles;