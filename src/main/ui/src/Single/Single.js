import './Single.css'
import {useParams } from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";


function Single() {
    let {id} = useParams();

    const [vehicle, setVehicle] = useState([])
    async function getVehicle() {

        const vehicle = (await axios.get('http://localhost:8080/api/vehicle/'+id)).data
        setVehicle(vehicle)
    }
    console.log(vehicle)
    useEffect(() => {
        getVehicle()
    }, []);
    return (
        <>

            <div className="vehicle">
                <div className="general">
                    <img src={'../../'+vehicle.imgUrl} alt="vehicle photo"/>
                    <div className="informations">
                        <p>Type of the vehicle : {vehicle.type}</p>
                        <p>Engine : {vehicle.engine}</p>
                        <p>Fuel : {vehicle.fuelType}</p>


                    </div>
                </div>
            </div>

        </>
    );
}

export default Single;