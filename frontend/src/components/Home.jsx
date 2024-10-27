// src/components/Home.jsx
import React from 'react';

const Home = ({ user }) => {
    return (
        <div>
            <h1>Hello, {user.fullName}!</h1>
        </div>
    );
};

export default Home;
