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
        setVehicle({...vehicle, [label]: e.target.value})
        console.log(vehicle)
    }

    async function handleSubmit(e) {
        e.preventDefault()
        console.log(vehicle);
        switch (vehicle.type) {
            case "boats":
                const boats = {vehicle}
                await axios.post("http://localhost:8080/api/vehicle", boats)
                    .then(response => {
                        console.log(response)
                    })
                    .catch(error => {
                        alert('error');
                    });
                break

            case "cars":
                const cars = {vehicle}
                await axios.post("http://localhost:8080/api/vehicle", cars)
                    .then(response => {
                        console.log(response)
                    })
                    .catch(error => {
                        alert('error');
                    });
                break

            case "trucks":
                const trucks = {vehicle}
                await axios.post("http://localhost:8080/api/vehicle", trucks)
                    .then(response => {
                        console.log(response)
                    })
                    .catch(error => {
                        alert('error');
                    });
                break

            case "airplanes":
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
                        <option value="cars">car</option>
                        <option value="trucks">truck</option>
                        <option value="boats">boat</option>
                        <option value="airplanes">airplane</option>
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

                    <div className="form-div">
                        <label htmlFor="number_doors">Number of doors: </label>
                        <input type="number" name="number_doors" id="number_doors" required
                               onChange={e => handleChange(e, "number_doors")}></input>
                    </div>
                    <div className="form-div">
                        <input type="submit" value="Upload the vehicle"></input>
                    </div>
                </form>
            )}
        </>
    );
}

export default Addvehicle;