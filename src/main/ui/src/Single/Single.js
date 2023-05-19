import './Single.css'
import {useParams } from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";


function Single() {
    let {id} = useParams();
    const [vehicle, setVehicle] = useState([])
    const [rental, setRental] = useState([])
    async function getVehicle() {

        const vehicle = (await axios.get('http://localhost:8080/api/vehicle/'+id)).data
        setVehicle(vehicle)

        const rental = (await axios.get('http://localhost:8080/api/vehicleRentals/'+id)).data
        setRental(rental)
    }
    useEffect(() => {
        getVehicle()
    }, []);
    return (
        <>

            <div className="vehicle">
                <div className="general">
                    <img src={vehicle.imgUrl} alt="vehicle photo"/>
                    <div className="informations">
                        <p>Type of the vehicle : {vehicle.type}</p>
                        <p>Engine : {vehicle.engine}</p>
                        <p>Fuel : {vehicle.fuelType}</p>
                        <p>Registration : {vehicle.registration}</p>
                    </div>
                </div>
                <h2 className={"rentalTitle"}>This vehicle rentals :</h2>
                <table className={'table-fill'}>
                    <tr>
                        <th>Start date</th>
                        <th>Dureation in days</th>
                        <th>Name of the dealer</th>
                        <th>Address of the dealer</th>
                    </tr>
                    {rental.map(a =>
                        <tr>
                            <td>{a.startDate}</td>
                            <td>{a.durationInDays}</td>
                            <td>{a.dealer.name}</td>
                            <td>{a.dealer.address}</td>
                        </tr>
                    )}
                </table>
            </div>

        </>
    );
}

export default Single;