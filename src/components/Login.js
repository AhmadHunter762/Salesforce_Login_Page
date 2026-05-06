import React from "react";

const Login = ({ setIsLoggedIn }) => {

  const handleLogin = () => {
    // ❗ correct endpoint
    window.location.href = "http://localhost:8080/auth/login";
  };

  return (
    <button onClick={handleLogin}>
      Login with Salesforce
    </button>
  );
};

export default Login;