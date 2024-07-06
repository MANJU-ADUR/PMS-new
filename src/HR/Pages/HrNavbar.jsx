import React from 'react'
import { json } from 'react-router-dom'

const HrNavbar = () => {
    const user = JSON.parse(localStorage.getItem("User"))

    return (
        <div className="hr_navbar">
            <h1>HR</h1>
        </div>
    )
}

export default HrNavbar