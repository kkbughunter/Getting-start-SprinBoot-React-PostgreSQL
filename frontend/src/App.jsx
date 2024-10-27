// src/App.jsx
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';

const App = () => {
    const [user, setUser] = useState(null);

    const handleLogin = (userData) => {
        setUser(userData);
    };

    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={user ? <Home user={user} /> : <Login onLogin={handleLogin} />} />
                    <Route path="/register" element={<Register />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
