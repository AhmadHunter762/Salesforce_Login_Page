import React from "react";

const ValidationList = ({ rules, setRules }) => {

  const toggleRule = (id) => {
    const updated = rules.map(rule =>
      rule.id === id
        ? { ...rule, active: !rule.active }
        : rule
    );
    setRules(updated);
  };

  if (!rules || rules.length === 0) {
    return <p>No Validation Rules Found</p>;
  }

  return (
    <div>
      <h3>Validation Rules</h3>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Name</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {rules.map((rule) => (
            <tr key={rule.id}>
              <td>{rule.name}</td>
              <td>
                {rule.active ? "Active" : "Inactive"}
              </td>
              <td>
                <button onClick={() => toggleRule(rule.id)}>
                  Toggle
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ValidationList;