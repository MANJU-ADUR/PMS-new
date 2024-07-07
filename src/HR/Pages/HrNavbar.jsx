import React from 'react';
import { Link } from 'react-router-dom';
import { CgProfile } from 'react-icons/cg';
import "../CSS/HrNavbar.css"

const HrNavbar = () => {
    const user = JSON.parse(localStorage.getItem("User"));
    const handleLogout = () => {
        localStorage.removeItem('User');
    };

    return (
        <div className="hr_navbar">
            <div className="nav">
                <div className="options">
                    <Link to="/hr-dash/goals">EMP Goals</Link>
                </div>
                <div className="name">
                    <h1>PMS</h1>
                </div>
                <div className="user">
                    <CgProfile />
                    <p>{user.firstname} {user.lastname}</p>
                    <Link to="/">
                        <button onClick={handleLogout}>Logout</button>
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default HrNavbar;
