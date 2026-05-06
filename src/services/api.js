import axios from "axios";

const BASE_URL = "http://localhost:8080";

export const fetchRules = async () => {
  const res = await axios.get(`${BASE_URL}/rules`);
  return res.data;
};

export const deployRules = async (rules) => {
  await axios.post(`${BASE_URL}/deploy`, rules);
};
