import './Login.css'
import {Link} from "react-router-dom"
import {useState} from "react";
import {useCookies} from "react-cookie";
import axios from "axios";
import { useNavigate } from "react-router-dom";


function Login(props) {
    const [person,setPerson]=useState("");
    const [cookies, setCookie] = useCookies(['name']);
    const navigate = useNavigate();

    function handleChange(e, label){
        setPerson({...person,[label]: e.target.value })

    }

    async function handleSubmit(e){
        e.preventDefault()
        await axios.get("http://localhost:8080/api/user/"+person.email+'/'+person.password).then(response => {
            console.log('working')
            setCookie('email', person.email, { path: '/' });
            setCookie('password', person.password, { path: '/' });
            navigate("/profile");

        })
            .catch(error => {
                alert('error');
            });


    }
    return (
        <form className="form" className="login-form" onSubmit={handleSubmit}>
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
                <input type="submit" value="Login"></input>
            </div>
            <div className="form-div">
                <Link to="/register"><input type="button" value="Don't have an account ?"></input></Link>
            </div>


        </form>
    );
}

export default Login;