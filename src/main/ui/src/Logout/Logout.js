import {Link, redirect} from "react-router-dom"
import {useCookies} from "react-cookie";
import { useNavigate } from "react-router-dom";
import {useEffect} from "react";


function Logout(props) {
    const [cookies, setCookie, removeCookie] = useCookies(['name']);
    const navigate = useNavigate();

    removeCookie("email")
    removeCookie("password")
    useEffect(() => {
        window.location.reload(false);
        navigate("/");
    }, []);

    return (
        <>
        </>
    );
}

export default Logout;