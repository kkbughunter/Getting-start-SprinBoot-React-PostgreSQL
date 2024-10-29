// src/components/Home.jsx
import React from 'react';
import Cookies from 'js-cookie';

const Home = () => {
    const fullName = Cookies.get('fullName');
    const role = Cookies.get('role');

    return (
        <div>
            <h1>Hello, {fullName}!</h1>
            <p>Your role: {role}</p>
        </div>
    );
};

export default Home;
