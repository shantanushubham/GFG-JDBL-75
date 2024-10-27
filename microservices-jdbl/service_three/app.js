const express = require("express");
const { getFullName } = require("./controller/serviceThree.controller");
const app = express();

const PORT = 8080

app.use("/full_name", getFullName)

app.listen(PORT || 8080, ()=> {
  console.log(`Server is running on ${PORT}`)
})