// src/components/Login.jsx
import React, { useState } from 'react';
import Cookies from 'js-cookie';
import { useNavigate } from 'react-router-dom';

const Login = ({ onLogin }) => {
    const [idNumber, setIdNumber] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const loginData = {
            idNumber,
            password
        };

        try {
            const response = await fetch('http://localhost:8081/api/users/getin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(loginData)
            });

            if (response.ok) {
                const data = await response.json();
                Cookies.set('fullName', data.fullName);  // Store name in cookies
                Cookies.set('role', data.role);          // Store role in cookies

                console.log('Login successful:', data);
                onLogin(data.fullName);
                navigate('/home'); // Redirect to home page
            } else {
                console.error('Login failed:', response.statusText);
            }
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="ID Number" value={idNumber} onChange={(e) => setIdNumber(e.target.value)} required /> <br/>
            <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required /><br/>
            <button type="submit">Login</button><br/>
        </form>
    );
};

export default Login;
