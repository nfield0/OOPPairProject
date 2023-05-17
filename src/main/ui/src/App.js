import { Route, Link, Routes } from "react-router-dom"
import './App.css';
import Home from "./Home/Home";
import Vehicle from "./Vehicle/Vehicle";
import Slidebar from "./Slidebar/Slidebar";
import Login from "./Login/Login";
import Register from "./Register/Register";
import { useCookies } from 'react-cookie';
import Single from "./Single/Single";
import Profile from "./Profile/Profile";
function App() {

    const [cookies, setCookie, removeCookie] = useCookies(['mycookie']);

  return (
    <>
       <Slidebar cookies={cookies}/>

      <nav>
        <Link to="/" className='home'><p>Car Website</p></Link>
      </nav>


      <Routes>
        <Route exact={true} path="/" element={<Home />} />
          <Route exact={true} path="/vehicle" element={<Vehicle />} />
          <Route exact={true} path="/single/:id" element={<Single />} />
          <Route exact={true} path="/login" element={<Login />} />
          <Route exact={true} path="/register" element={<Register />} />
          <Route exact={true} path="/profile" element={<Profile />} />

        <Route path="*" element={() => <p>Page Not Found</p>} />
      </Routes>

    </>
  );
}

export default App;