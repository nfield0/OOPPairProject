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


    useEffect(() => {
        getData().then(() => {
            setLoading(false);
        });
    }, []);


    return (
        <>
            <div className="profile">
                <p> <strong> Name: </strong>{person.name}</p>
                <p><strong> E-mail: </strong>{person.email}</p>

            </div>
            {person && person.admin === 1 && (
                <div className="admincontent">
                    <button className={'panelBtn'} onClick={() => navigate('/adminvehicles')}>Admin Vehicle panel</button>
                    <button className={'panelBtn'} onClick={() => navigate("/adminusers")}>Admin Users panel</button>

                </div>
            )}
        </>
    );
}

export default Login;