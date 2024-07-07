import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Rate } from 'antd'; // Import Rate component from Ant Design
import "../CSS/EmpGoals.css";
import { useNavigate } from 'react-router-dom';

const EmpGoals = () => {
    const [goals, setGoals] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const hr = JSON.parse(localStorage.getItem("Hr"));
    const hrId = hr.id;

    useEffect(() => {
        const fetchGoals = async () => {
            try {
                const response = await axios.get(`http://localhost:7410/hrgoals/find-by-hr-id/${hrId}`);
                console.log('Goals response:', response.data);
                setGoals(response.data.data);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching goals:', error);
                setError('Failed to fetch goals.');
                setLoading(false);
            }
        };

        fetchGoals();
    }, [hrId]); // Dependency on hrId to refetch goals when it changes

    const navigate = useNavigate();

    const displayGoal = (goal_id) => {
        navigate(`/hr-dash/goal-detail/${goal_id}`);
    };

    return (
        <div className="emp-goals-container">
            <h2>Employee Goals</h2>
            {loading ? (
                <p>Loading...</p>
            ) : error ? (
                <p>Error: {error}</p>
            ) : goals.length === 0 ? (
                <p>No goals found.</p>
            ) : (
                <div className="goals-list">
                    {goals.map(goal => (
                        <div key={goal.id} className="goal-card">
                            <h3>{goal.title}</h3>
                            <p><strong>Description:</strong> {goal.description}</p>
                            <p><strong>Start Date:</strong> {goal.startdate}</p>
                            <p><strong>End Date:</strong> {goal.enddate}</p>
                            <p><strong>Status:</strong> {goal.status}</p>
                            <p><strong>Manager Ratings:</strong> {goal.manager_ratings === 1 ? "1 out of 5 stars" : <Rate disabled defaultValue={goal.manager_ratings} />} </p>
                            <p><strong>Manager Feedback:</strong> {goal.manager_feedback}</p>
                            {goal.hr_ratings !== 1 && <p><strong>HR Ratings:</strong> {goal.hr_ratings}</p>}
                            <button onClick={() => { displayGoal(goal.goal_id) }} >
                                View Goal
                            </button>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default EmpGoals;
