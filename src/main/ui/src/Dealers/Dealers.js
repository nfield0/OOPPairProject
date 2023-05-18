import "./Dealers.css"
import axios from "axios";
import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";

function Dealers() {
    const navigate = useNavigate();
    const [dealers, setDealers] = useState([]);

    async function getData() {
        try {
            const response = await axios.get("http://localhost:8080/api/dealers");
            setDealers(response.data);
        } catch (error) {
            alert('error')
        }
    }
    useEffect(() => {
        getData()
    }, []);
    return (
        <div className="dealersContent">
            <div className="infos">
                Here are all the dealers working for us :
            </div>
            <table className="responstable">
                <tr>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Adress</th>
                </tr>
                {dealers.map(a =>
                    <tr className="eachDealer">
                        <td>{a.name}</td>
                        <td>{a.phoneNumber}</td>
                        <td>{a.address}</td>


                    </tr>
                )}
            </table>
        </div>
    );
}

export default Dealers;