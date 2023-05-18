import './Profile.css'
import {Link} from "react-router-dom"
import {useEffect, useState} from "react";
import {useCookies} from "react-cookie";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {render} from "@testing-library/react";
import {wait} from "@testing-library/user-event/dist/utils";


function Login(props) {
    const [cookies, setCookie] = useCookies(['name']);
    const navigate = useNavigate();
    const [person, setPerson] = useState("");
    const [allvehicle, setAllVehicle] = useState([]);
    const [allUsers, setAllUsers] = useState([]);
    const [rentals, setRentals] = useState([]);
    const [loading, setLoading] = useState(true);

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

    async function getRental() {
        try {
            const response = await axios.get("http://localhost:8080/api/userRentals/" + person.id);
            setRentals(response.data);
        } catch (error) {
            navigate("/login");
        }
    }

    console.log(rentals)

async function handleChange(id, type) {
    await axios.get("http://localhost:8080/api/delVehicle/" + id + "/" + type + "s");
    console.log('deleting' + id + type)
    AdminData()
}

async function handleUser(id) {
    //await axios.get("http://localhost:8080/api/delVehicle/" + id);
    AdminData()
}

async function AdminData() {
    try {
        const usersResponse = await axios.get("http://localhost:8080/api/users");
        setAllUsers(usersResponse.data);

        const vehiclesResponse = await axios.get("http://localhost:8080/api/vehicles/");
        setAllVehicle(vehiclesResponse.data);
    } catch (error) {
        console.error(error);
    }
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
}, [person]); // Run this effect whenever 'person' changes
if (loading) {
    return <p>Loading...</p>;
}

return (
    <>
        <p>{person.email}</p>
        {person && person.admin === 1 && (
            <div>
                <div className="admincontent">
                    <table className="vehicleList">
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

                    <table className="usersList">
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
                </div>
            </div>
        )}
    </>
);
}

export default Login;