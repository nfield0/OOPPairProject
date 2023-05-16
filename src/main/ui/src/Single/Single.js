import './Single.css'
import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";


function Single() {
    let {type} = useParams();
    let {id} = useParams();

    const [vehicle, setVehicle] = useState([])

    async function getVehicle() {

        const vehicle = (await axios.post('http://localhost:8000/api/single/' + type + '/' + id)).data[0]
        setVehicle(vehicle)
    }

    useEffect(() => {
        getVehicle()
    }, []);
    console.log(vehicle)
    return (
        <>

            <div className="vehicle">
                <div className="general">
                    <img src={'../../'+vehicle.img_url} alt="vehicle photo"/>
                    <div className="informations">
                        <p>Type of the vehicle : {vehicle.type}</p>
                        <p>Engine : {vehicle.engine}</p>
                        <p>Fuel : {vehicle.fuel_type}</p>


                    </div>
                </div>
            </div>

        </>
    );
}

export default Single;