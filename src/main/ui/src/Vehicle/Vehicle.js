import "./Vehicle.css"
import {useEffect, useState} from "react";
import axios from "axios";

function Home() {

    const [vehicle, setVehicle] = useState([])

    async function getVehicle() {


        const vehicle = (await axios.post('http://localhost:8000/api/vehicles')).data
        setVehicle(vehicle)
    }

    useEffect(() => {
        getVehicle()
    }, []);

    return (
        <>
            <div className="container">

            </div>
            <div className="results">
                <h1>Boats</h1>

                <div className="boats">
                    {vehicle.boats?.[0]?.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/boats/"+ a.vehicle_id}>
                                <img src={a.img_url} alt="test"/>
                                <div className="infos">
                                    <h3>{a.make} - {a.model}</h3>
                                    <p></p>
                                </div>
                            </a>
                        </div>
                    )}
                </div>

                <h1>Cars</h1>
                <div className="cars">
                    {vehicle.cars?.[0]?.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/car/"+ a.vehicle_id}>
                                <img src={a.img_url} alt="test"/>
                                <div className="infos">
                                    <h3>{a.make} - {a.model}</h3>
                                    <p></p>
                                </div>
                            </a>
                        </div>
                    )}
                </div>

                <h1>Planes</h1>

                <div className="airplanes">
                    {vehicle.airplanes?.[0]?.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/airplane/"+ a.vehicle_id}>
                                <img src={a.img_url} alt="test"/>
                                <div className="infos">
                                    <h3>{a.make} - {a.model}</h3>
                                    <p></p>
                                </div>
                            </a>
                        </div>
                    )}
                </div>

                <h1>Trucks</h1>
                <div className="trucks">
                    {vehicle.trucks?.[0]?.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/trucks/"+ a.vehicle_id}>
                                <img src={a.img_url} alt="test"/>
                                <div className="infos">
                                    <h3>{a.make} - {a.model}</h3>
                                    <p></p>
                                </div>
                            </a>
                        </div>
                    )}
                </div>
            </div>
        </>
    );
}

export default Home;

