// import React, { useState } from "react";
// import Login from "./components/Login";
// import ValidationList from "./components/ValidationList";
// import Controls from "./components/Controls";

// function App() {
//   const [rules, setRules] = useState([]);
//   const [isLoggedIn, setIsLoggedIn] = useState(false);

//   return (
//     <div style={{ padding: "20px" }}>
//       <h2>Salesforce Validation Rule Manager</h2>

//       {!isLoggedIn && <Login setIsLoggedIn={setIsLoggedIn} />}

//       {isLoggedIn && (
//         <>
//           <Controls rules={rules} setRules={setRules} />
//           <ValidationList rules={rules} setRules={setRules} />
//         </>
//       )}
//     </div>
//   );
// }

// export default App;



import React, { useState } from "react";
import Login from "./components/Login";
import ValidationList from "./components/ValidationList";
import Controls from "./components/Controls";
import "./App.css";

function App() {
  const [rules, setRules] = useState([]);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div className="container">
      <h2>Salesforce Validation Rule Manager</h2>

      {!isLoggedIn ? (
        <div style={{ textAlign: "center" }}>
          <Login setIsLoggedIn={setIsLoggedIn} />
        </div>
      ) : (
        <>
          <Controls rules={rules} setRules={setRules} />
          <ValidationList rules={rules} setRules={setRules} />
        </>
      )}
    </div>
  );
}

export default App;