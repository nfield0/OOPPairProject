import "./Vehicle.css"
import {useEffect, useState} from "react";
import axios from "axios";

function Home() {

    const [vehicle, setVehicle] = useState([])
    const [cars, setCars] = useState([])
    const [trucks, setTrucks] = useState([])
    const [boats, setBoats] = useState([])
    const [planes, setPlanes] = useState([])

    async function getVehicle() {
        const vehicle = (await axios.get('http://localhost:8080/api/vehicles')).data
        setVehicle(vehicle)
        vehicle.forEach(function (elt) {
            if (elt.type == 'Car') {
                let test = 0
                cars.forEach(function (item) {
                    if (item.id == elt.id) {
                        test = 1;
                    }
                })
                if (test == 0) {
                    const tmp = cars;
                    tmp.push(elt)
                    setCars(tmp);
                }
            }

            if (elt.type == 'Truck') {
                let test = 0
                trucks.forEach(function (item) {
                    if (item.id == elt.id) {
                        test = 1;
                    }
                })
                if (test == 0) {
                    const tmp = trucks;
                    tmp.push(elt)
                    setTrucks(tmp);
                }
            }

            if (elt.type == 'Boat') {
                let test = 0
                boats.forEach(function (item) {
                    if (item.id == elt.id) {
                        test = 1;
                    }
                })
                if (test == 0) {
                    const tmp = boats;
                    tmp.push(elt)
                    setBoats(tmp);
                }
            }
            if (elt.type == 'Airplane') {
                let test = 0
                planes.forEach(function (item) {
                    if (item.id == elt.id) {
                        test = 1;
                    }
                })
                if (test == 0) {
                    const tmp = planes;
                    tmp.push(elt)
                    setPlanes(tmp);
                }
            }
            console.log(boats)
        })
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
                    {boats.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/" + a.id}>
                                <img src={a.imgUrl} alt="test"/>
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
                    {cars.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/" + a.id}>
                                <img src={a.imgUrl} alt="test"/>
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
                    {planes.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/" + a.id}>
                                <img src={a.imgUrl} alt="test"/>
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
                    {trucks.map(a =>
                        <div className={vehicle}>
                            <a className="preview" href={"single/" + a.id}>
                                <img src={a.imgUrl} alt="test"/>
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

