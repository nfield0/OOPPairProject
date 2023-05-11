import "./Home.css"
import banner from './banner.jpg';

function Home() {


    return (
        <>
            <div className="bannerContainer">
                <img src={banner} alt="banner" className='banner'/>
            </div>
        </>
    );
}

export default Home;