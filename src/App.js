import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./Landing_Components/Pages/Login";
import Register from "./Landing_Components/Pages/Register";
import EmployeeDashboard from "./Employee/Pages/EmployeeDashboard";
import ManagerDashboard from "./Manager/Pages/ManagerDashboard";
import HrDashboard from "./HR/Pages/HrDashboard";

function App() {
  return (
    <div className="App">

      <BrowserRouter>

        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/employee-dash/*" element={<EmployeeDashboard />} />
          <Route path="/manager-dash/*" element={<ManagerDashboard />} />
          <Route path="/hr-dash" element={<HrDashboard />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
