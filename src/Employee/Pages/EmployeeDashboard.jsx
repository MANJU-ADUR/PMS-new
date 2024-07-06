import React from 'react'
import EmployeeNavbar from './EmployeeNavbar'
import { Route, Routes } from 'react-router-dom'
import CreateGoal from "./CreateGoal"
import Goals from './Goals'

const EmployeeDashboard = () => {
    return (
        <div className="empdash">
            <EmployeeNavbar />
            <Routes>
                <Route path='/create' element={<CreateGoal />} />
                <Route path='/my-goals' element={<Goals />} />
            </Routes>
        </div>
    )
}

export default EmployeeDashboard