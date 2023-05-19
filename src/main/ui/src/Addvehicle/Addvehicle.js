import {useCookies} from "react-cookie";
import {Link, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";


function Addvehicle() {
    const [cookies, setCookie] = useCookies(['name']);
    const navigate = useNavigate();
    const [loading, setLoading] = useState(true);
    const [person, setPerson] = useState("");
    const [vehicle, setVehicle] = useState([]);
    const [type, setType] = useState('');


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

    function handleChange(e, label) {
        setType(e.target.value);
        setVehicle({...vehicle, [label]: e.target.value})
        console.log(vehicle)
    }

    async function handleSubmit(e) {
        e.preventDefault()
        console.log(vehicle);
        console.log(vehicle.type)

        switch (vehicle.type) {
            case "boat":
                        console.log("is boat")
                            const boat = {
                                type: type,
                                make: vehicle.make,
                                model: vehicle.model,
                                engine: vehicle.engine,
                                registration: vehicle.registration,
                                color: vehicle.color,
                                weight_tonnes: vehicle.weight_tonnes,
                                number_passengers: vehicle.number_passengers,
                                mileage: vehicle.mileage,
                                price: vehicle.price,
                                fuel_type: vehicle.fuel_type,
                                dealer_id: vehicle.dealer_id,
                                img_url: vehicle.img_url,
                                num_life_boats: vehicle.num_life_boats,
                                max_speed_knots: vehicle.max_speed_knots,

                              };
                            await axios.post("http://localhost:8080/api/vehicle/boat", boat)
                                .then(response => {
                                    console.log(response)
                                })
                                .catch(error => {
                                    alert('error');
                                });
                            break

            case "car":
            console.log("is car")
                const car = {
                    type: type,
                    make: vehicle.make,
                    model: vehicle.model,
                    engine: vehicle.engine,
                    registration: vehicle.registration,
                    color: vehicle.color,
                    weight_tonnes: vehicle.weight_tonnes,
                    number_passengers: vehicle.number_passengers,
                    mileage: vehicle.mileage,
                    price: vehicle.price,
                    fuel_type: vehicle.fuel_type,
                    dealer_id: vehicle.dealer_id,
                    img_url: vehicle.img_url,
                    number_doors: vehicle.number_doors,
                  };
                console.log(car)
                await axios.post("http://localhost:8080/api/vehicle/car", car)
                    .then(response => {
                        console.log(response)
                    })
                    .catch(error => {
                        alert('error');
                    });
                break

            case "truck":
                const trucks = {vehicle}
                await axios.post("http://localhost:8080/api/vehicle", trucks)
                    .then(response => {
                        console.log(response)
                    })
                    .catch(error => {
                        alert('error');
                    });
                break

            case "airplane":
                const airplanes = {vehicle}
                await axios.post("http://localhost:8080/api/vehicle", airplanes)
                    .then(response => {
                        console.log(response)
                    })
                    .catch(error => {
                        alert('error');
                    });
                break
        }

    }

    useEffect(() => {
        getData().then(() => {
            setLoading(false);
        });
    }, []);


    return (
        <>
            <button className={"backBtn"} onClick={() => navigate(-1)}><span>Go back</span></button>
            {person && person.admin === 1 && (
                <form className="form" className="login-form" method="post" onSubmit={handleSubmit}>

                    <select name="type" className="selectType" onChange={e => handleChange(e, "type")} required>
                        <option value="car">car</option>
                        <option value="truck">truck</option>
                        <option value="boat">boat</option>
                        <option value="airplane">airplane</option>
                    </select>
                    <div className="form-div">
                        <label htmlFor="make">Make: </label>
                        <input type="text" name="make" id="make" required
                               onChange={e => handleChange(e, "make")}></input>
                    </div>
                    <div className="form-div">
                        <label htmlFor="model">Model: </label>
                        <input type="text" name="model" id="model" required
                               onChange={e => handleChange(e, "model")}></input>
                    </div>
                    <div className="form-div">
                        <label htmlFor="engine">Engine: </label>
                        <input type="text" name="engine" id="engine" required
                               onChange={e => handleChange(e, "engine")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="registration">Registration: </label>
                        <input type="text" name="registration" id="registration" required
                               onChange={e => handleChange(e, "registration")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="color">Color: </label>
                        <input type="text" name="color" id="color" required
                               onChange={e => handleChange(e, "color")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="weight_tonnes">Weight(tonnes): </label>
                        <input type="number" name="weight_tonnes" id="weight_tonnes" required
                               onChange={e => handleChange(e, "weight_tonnes")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="number_passengers">Number of passengers: </label>
                        <input type="number" name="number_passengers" id="number_passengers" required
                               onChange={e => handleChange(e, "number_passengers")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="mileage">Mileage: </label>
                        <input type="number" name="mileage" id="mileage" required
                               onChange={e => handleChange(e, "mileage")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="price">Price: </label>
                        <input type="number" name="price" id="price" required
                               onChange={e => handleChange(e, "price")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="fuel_type">Fuel type: </label>
                        <input type="text" name="fuel_type" id="fuel_type" required
                               onChange={e => handleChange(e, "fuel_type")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="dealer_id">dealer_id: </label>
                        <input type="number" name="dealer_id" id="dealer_id" required
                               onChange={e => handleChange(e, "dealer_id")}></input>
                    </div>

                    <div className="form-div">
                        <label htmlFor="img_url">Image url: </label>
                        <input type="url" name="img_url" id="img_url" required
                               onChange={e => handleChange(e, "img_url")}></input>
                    </div>

                    {vehicle.type == "car" && (
                    <div className="form-div">
                        <label htmlFor="number_doors">Number of doors: </label>
                        <input type="number" name="number_doors" id="number_doors" required
                               onChange={e => handleChange(e, "number_doors")}></input>
                    </div>
                    )}
                    {vehicle.type == "boat" && (
                                        <div className="form-div">
                                            <label htmlFor="num_life_boats">Number of lifeboats: </label>
                                            <input type="number" name="num_life_boats" id="num_life_boats" required
                                                   onChange={e => handleChange(e, "num_life_boats")}></input>

                                              <label htmlFor="max_speed_knots">Max speed knots: </label>
                                                    <input type="number" name="max_speed_knots" id="max_speed_knots" required
                                                   onChange={e => handleChange(e, "max_speed_knots")}></input>
                                                      </div>
                                       )}


                    <div className="form-div">
                        <input type="submit" value="Upload the vehicle"></input>
                    </div>
                </form>
            )}
        </>
    );
}

export default Addvehicle;