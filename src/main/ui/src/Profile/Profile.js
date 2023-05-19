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
            console.log(person.id)
        } catch (error) {
        }
    }

    useEffect(() => {
        getData().then(() => {
            setLoading(false);
        });
    }, []);
    useEffect(() => {
        if (person && person.admin === 1) {
            getRental();
        }
    }, [person]);


    return (
        <>
            {person && person.admin === 1 && (
                <div className="admincontent">
                    <button className={'panelBtn'} onClick={() => navigate('/adminvehicles')}>Admin Vehicle panel
                    </button>
                    <button className={'panelBtn'} onClick={() => navigate("/adminusers")}>Admin Users panel</button>
                    <button className={'panelBtn'} onClick={() => navigate("/addvehicle")}>Add Vehicle</button>

                </div>
            )}
            <div className="profile">
                <p><strong> Name: </strong>{person.name}</p>
                <p><strong> E-mail: </strong>{person.email}</p>
            </div>
            {rentals.length > 0 && (
                <div>
                    <h2 className={"rentalTitle"}>My rentals :</h2>
                    <table className={'table-fill'}>
                        <tr>
                            <th>Vehicle</th>
                            <th>Start date</th>
                            <th>Dureation in days</th>
                            <th>Name of the dealer</th>
                            <th>Address of the dealer</th>
                        </tr>
                        {rentals.map(a =>
                            <tr>
                                <td>{a.vehicle.make} - {a.vehicle.model}</td>
                                <td>{a.startDate}</td>
                                <td>{a.durationInDays}</td>
                                <td>{a.dealer.name}</td>
                                <td>{a.dealer.address}</td>
                            </tr>
                        )}
                    </table>
                </div>
            )}
            {rentals.length == 0 && (
                <div>
                    <h2 className={"rentalTitle"}>
                        You haven't rented any car for the moment !
                    </h2>
                </div>
            )}

        </>
    );
}

export default Login;