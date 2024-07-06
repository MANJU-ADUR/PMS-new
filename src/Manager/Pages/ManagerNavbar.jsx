import React from 'react';
import { Link } from 'react-router-dom';
import { CgProfile } from 'react-icons/cg';
import Login from '../../Landing_Components/Pages/Login';

const ManagerNavbar = () => {
    const manager = JSON.parse(localStorage.getItem('User'));

    // Conditionally render based on user data
    if (!manager || !manager.firstname || !manager.lastname) {
        // Render a placeholder or redirect to login
        return (
            <div className="emp_navbar">
                <Login />
            </div>
        );
    }

    // User data is valid, construct username
    const managername = `${manager.firstname} ${manager.lastname}`;

    const handleLogout = () => {
        // Clear localStorage
        localStorage.removeItem('User');
        // Redirect to login page or perform other actions after logout
        // Example: window.location.href = '/login';
    };

    return (
        <div className="emp_navbar">
            <div className="nav">
                <div className="logo">XYZ Technologies</div>
                <nav>
                    <Link to="/manager-dash/employee-goals">Goals by emp</Link>
                    {/* <Link to="/">----</Link> */}
                    {/* <Link to="/">----</Link> */}
                </nav>
                <div className="username">
                    <CgProfile />
                    {managername} {/* Render the employee's name */}
                    <Link to="/">
                        <button onClick={handleLogout}>Logout</button>
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default ManagerNavbar;
