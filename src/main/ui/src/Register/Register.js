import './Register.css'
import {Link, useNavigate} from "react-router-dom"
import {useState} from "react";
import {useCookies} from "react-cookie";
import axios from "axios";


function Register(props) {

    const [person, setPerson] = useState("");
    const [cookies, setCookie] = useCookies(['name']);
    const navigate = useNavigate();

    function handleChange(e, label) {
        setPerson({...person, [label]: e.target.value})

    }

    async function handleSubmit(e) {
        e.preventDefault()
        await axios.post("http://localhost:8080/api/user/"+ person.name+'/'+ person.email+'/'+ person.password)
            .then(response => {
            setCookie('email', person.email, {path: '/'});
            setCookie('password', person.password, {path: '/'});
            navigate("/profile");
        })
            .catch(error => {
                alert('error');
            });
    }

    return (
        <form className="form" className="login-form" method="post" onSubmit={handleSubmit}>
            <div className="form-div">
                <label htmlFor="name">Name: </label>
                <input type="text" name="name" id="name" required onChange={e => handleChange(e, "name")}></input>
            </div>
            <div className="form-div">
                <label htmlFor="email">Email: </label>
                <input type="email" name="email" id="email" required onChange={e => handleChange(e, "email")}></input>
            </div>
            <div className="form-div">
                <label htmlFor="password">Password: </label>
                <input type="password" name="password" id="password" required
                       onChange={e => handleChange(e, "password")}></input>
            </div>
            <div className="form-div">
                <input type="submit" value="Register"></input>
            </div>
            <div className="form-div">
                <Link to="/login"><input type="button" value="Already have an account ?"></input></Link>
            </div>


        </form>
    );
}

export default Register;