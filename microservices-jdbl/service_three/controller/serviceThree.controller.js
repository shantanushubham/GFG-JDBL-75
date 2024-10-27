const { getFirstName } = require("../services/serviceOne.service");
const { getLastName } = require("../services/serviceTwo.service");

const getFullName = async (req, res) => {
  const firstName = await getFirstName();
  const lastName = await getLastName();
  return res.status(200).send({
    fullName: `${firstName} ${lastName}`
  })
};

module.exports = { getFullName };
