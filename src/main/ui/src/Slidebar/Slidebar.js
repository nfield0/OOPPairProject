import './Slidebar.css'
import { slide as Menu } from 'react-burger-menu'
import { Link } from "react-router-dom"
import { BsSearch } from "react-icons/bs";
import {useCookies} from "react-cookie";




function Slidebar(props) {
    const [cookies, setCookie] = useCookies(['name']);

    let loginbutton;
    if (cookies.email === undefined){
        loginbutton = <Link to="/login" id="login"><a className="menu-item" href="/login">Login</a></Link>;
    }else{
        loginbutton = <div class="loged">
            <Link to="/profile" id="profile"><a className="menu-item " href="/profile">Profile</a></Link> <br/>
            <Link to="/logout" id="logout"><a className="menu-item " href="/logout">Logout</a></Link>
        </div>
        ;
    }
    return (
        <>
            <div className="outer_container">
                <Menu right>
                    <div className="icons_bar">
                        <Link to="/search" id="search"><a className="menu-item" href="/"> <BsSearch /></a></Link>
                    </div>
                    <Link to="/"><a id="home" className="menu-item" href="/home">Home</a></Link>
                    <Link to="/vehicle" id="vehicle"><a className="menu-item" href="/vehicle">Vehicle</a></Link>
                    <Link to="/dealers"><a id="home" className="menu-item" href="/dealers">Dealers</a></Link>
                    {loginbutton}
                </Menu>
            </div>
        </>
    );
}

export default Slidebar
