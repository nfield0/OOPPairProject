import './Register.css'
import { Link } from "react-router-dom"


function Register(props) {


    return (
        <form className="form" className="login-form" >
            <div className="form-div">
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" required ></input>
            </div>
            <div className="form-div">
                <label for="email">Email: </label>
                <input type="email" name="email" id="email" required  ></input>
            </div>
            <div className="form-div">
                <label for="password">Password: </label>
                <input type="password" name="password" id="password" required></input>
            </div>
            <div className="form-div">
                <input type="submit" value="Register" ></input>
            </div>
            <div className="form-div">
                <Link to="/login"><input type="button" value="Already have an account ?"></input></Link>
            </div>


        </form>
    );
}

export default Register;