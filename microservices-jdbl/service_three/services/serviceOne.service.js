const axios = require("axios");

const serviceOneApiConfig = axios.create({
  baseURL: "http://localhost:7070",
});

const getFirstName = async () => {
  const {
    data: { firstName },
  } = await serviceOneApiConfig.get("/first_name");
  console.log(firstName);
  return firstName;
};

module.exports = { getFirstName };
