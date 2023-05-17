import './Slidebar.css'
import { slide as Menu } from 'react-burger-menu'
import { Link } from "react-router-dom"
import { BsSearch } from "react-icons/bs";




function Slidebar(props) {

    return (
        <>
            <div className="outer_container">
                <Menu right>
                    <div className="icons_bar">
                        <Link to="/search" id="search"><a className="menu-item" href="/"> <BsSearch /></a></Link>
                    </div>
                    <Link to="/"><a id="home" className="menu-item" href="/home">Home</a></Link>
                    <Link to="/vehicle" id="vehicle"><a className="menu-item" href="/vehicle">Vehicle</a></Link>
                    <Link to="/login" id="login"><a className="menu-item" href="/login">Login</a></Link>
                </Menu>
            </div>
        </>
    );
}

export default Slidebar
