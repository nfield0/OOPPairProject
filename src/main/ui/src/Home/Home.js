import "./Home.css"
import {Link} from "react-router-dom";

function Home() {


    return (
        <>
            <div className="banner">

            </div>
            <div className="content">
                <h1>Welcome to our Renting company !</h1>
                <Link to="/vehicle"><input type="button" value="See our catalog"></input></Link>
            </div>
        </>
    );
}

export default Home;