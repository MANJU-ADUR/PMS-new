import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { Rate, Button, Input, message } from 'antd'; // Importing Ant Design components
import "../CSS/GoalDetail.css";

const GoalDetail = () => {
  const { id } = useParams(); // Get the goal ID from URL params
  const [goal, setGoal] = useState(null);
  const [employee, setEmployee] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [feedbackText, setFeedbackText] = useState('');
  const [rating, setRating] = useState(0); // State to store the selected rating

  useEffect(() => {
    const fetchGoalAndEmployeeDetails = async () => {
      try {
        // Fetch goal details
        const goalResponse = await axios.get(`http://localhost:7410/goals/${id}`);
        console.log('Goal detail response:', goalResponse.data);
        setGoal(goalResponse.data.data); // Assuming response.data.data contains goal details

        // Fetch employee details associated with the goal
        const employeeResponse = await axios.get(`http://localhost:7410/goals/find-emp/${id}`);
        console.log('Employee detail response:', employeeResponse.data);
        setEmployee(employeeResponse.data.data); // Assuming response.data.data contains employee details

        setLoading(false);
        setError(null);
      } catch (error) {
        console.error('Error fetching goal and employee details:', error);
        setError('Failed to fetch goal and employee details.');
        setLoading(false);
      }
    };

    fetchGoalAndEmployeeDetails();
  }, [id]); // Fetch data whenever the `id` changes

  const handleFeedbackSubmit = async () => {
    try {
      // Assuming you have an API endpoint to submit feedback
      const response = await axios.post(`http://localhost:7410/goals/submit-feedback`, {
        goalId: id,
        rating: rating,
        feedback: feedbackText
      });

      // Assuming successful submission
      console.log('Feedback submitted:', response.data);
      message.success('Feedback submitted successfully!');
    } catch (error) {
      console.error('Error submitting feedback:', error);
      message.error('Failed to submit feedback. Please try again later.');
    }
  };

  return (
    <div className="goal-detail-container">
      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p>Error: {error}</p>
      ) : goal && employee ? (
        <div className="goal-details">
          <h2>Goal Detail</h2>
          <p>This goal was prepared by {employee.firstname} {employee.lastname}</p>
          <p><strong>Title:</strong> {goal.title}</p>
          <p><strong>Description:</strong> {goal.description}</p>
          <p><strong>Start Date:</strong> {goal.startdate}</p>
          <p><strong>End Date:</strong> {goal.enddate}</p>
          <p><strong>Status:</strong> {goal.status}</p>

          <h2>Employee Detail</h2>
          <p><strong>Email:</strong> {employee.email}</p>
          <p><strong>Mobile Number:</strong> {employee.mobilenumber}</p>
          <p><strong>Gender:</strong> {employee.gender}</p>
          <p><strong>Designation:</strong> {employee.designation}</p>

          <h2>Feedback</h2>
          <div className="feedback-section">
            <p>Rate this goal:</p>
            <Rate value={rating} onChange={value => setRating(value)} /> {/* Displaying the rate (star) structure */}
            <Input.TextArea
              placeholder="Enter your feedback..."
              value={feedbackText}
              onChange={e => setFeedbackText(e.target.value)}
              style={{ marginTop: '1rem' }}
            />
            <Button type="primary" onClick={handleFeedbackSubmit} style={{ marginTop: '1rem' }}>Submit Feedback</Button>
          </div>
        </div>
      ) : (
        <p>No goal details found for ID: {id}</p>
      )}
    </div>
  );
};

export default GoalDetail;
