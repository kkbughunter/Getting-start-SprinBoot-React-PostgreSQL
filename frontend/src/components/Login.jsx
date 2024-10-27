// src/components/Login.jsx
import React, { useState } from 'react';

const Login = ({ onLogin }) => {
    const [idNumber, setIdNumber] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        const loginData = {
            idNumber,
            password
        };

        try {
            const response = await fetch('http://localhost:8081/api/users/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(loginData)
            });

            if (response.ok) {
                const data = await response.json();
                console.log('Login successful:', data);
                onLogin(data.fullName); // Call onLogin with the user's full name
                // Optionally, redirect to home page
            } else {
                console.error('Login failed:', response.statusText);
            }
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="ID Number" onChange={(e) => setIdNumber(e.target.value)} required /> <br/>
            <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} required /><br/>
            <button type="submit">Login</button><br/>
        </form>
    );
};


export default Login;
