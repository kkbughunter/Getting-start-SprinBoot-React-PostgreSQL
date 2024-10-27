// src/components/Register.jsx
import React, { useState } from 'react';

const Register = () => {
    const [fullName, setFullName] = useState('');
    const [idNumber, setIdNumber] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('STUDENT'); // Default role

    const handleSubmit = async (e) => {
        e.preventDefault();

        const userData = {
            fullName,
            idNumber,
            password,
            role
        };

        try {
            const response = await fetch('http://localhost:8081/api/users/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });

            if (response.ok) {
                const data = await response.json();
                console.log('Registration successful:', data);
                // Optionally, redirect to login or home page
            } else {
                console.error('Registration failed:', response.statusText);
            }
        } catch (error) {
            console.error('Error during registration:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Full Name" onChange={(e) => setFullName(e.target.value)} required /><br/>
            <input type="text" placeholder="ID Number" onChange={(e) => setIdNumber(e.target.value)} required /><br/>
            <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} required /><br/>
            <select onChange={(e) => setRole(e.target.value)}>
                <option value="STUDENT">Student</option>
                <option value="TEACHER">Teacher</option>
                <option value="MANAGEMENT">Management</option>
                <option value="ADMIN">Admin</option>
            </select><br/>
            <button type="submit">Register</button>
        </form>
    );
};


export default Register;
