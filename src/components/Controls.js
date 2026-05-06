import React from "react";
import { fetchRules, deployRules } from "../services/api";

const Controls = ({ rules, setRules }) => {

  const handleFetch = async () => {
    const data = await fetchRules();
    setRules(data);
  };

  const toggleAll = () => {
    const updated = rules.map(rule => ({
      ...rule,
      active: !rule.active
    }));
    setRules(updated);
  };

  const handleDeploy = async () => {
    await deployRules(rules);
    alert("Changes deployed to Salesforce!");
  };

  return (
    <div style={{ margin: "20px 0" }}>
      <button onClick={handleFetch}>Get Validation Rules</button>
      <button onClick={toggleAll}>Toggle All</button>
      <button onClick={handleDeploy}>Deploy Changes</button>
    </div>
  );
};

export default Controls;
