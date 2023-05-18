import './Profile.css'
import {Link} from "react-router-dom"
import {useEffect, useState} from "react";
import {useCookies} from "react-cookie";
import axios from "axios";
import {useNavigate} from "react-router-dom";


function Login(props) {
    const [cookies, setCookie] = useCookies(['name']);
    const navigate = useNavigate();
    const [person,setPerson]=useState("");

    if(!cookies.email && !cookies.password){
        navigate('/login')
    }

    async function getData() {

        await axios.get("http://localhost:8080/api/user/" + cookies.email + '/' + cookies.password)
            .then(response => {
            setPerson(response.data)
            })
            .catch(error => {
                navigate("/login");
            });
    }
    console.log(person)
    useEffect(() => {
        getData()
    }, []);

    return (
        <>
            <p>{person.email} </p>
        </>
    );
}

export default Login;