const axios = require("axios");

const serviceOneApiConfig = axios.create({
  baseURL: "http://localhost:9090",
});

const getLastName = async () => {
  const {
    data: { lastName },
  } = await serviceOneApiConfig.get("/last_name");
  console.log(lastName);
  return lastName;
};

module.exports = { getLastName };
