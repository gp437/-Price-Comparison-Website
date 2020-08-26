const express = require('express');
const apiRouter = require('./routes');

const app = express();
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  next();
});
app.use(express.json());
app.use('/api/bikes', apiRouter);

// start listening on port 3000
app.listen(process.env.PORT || '3000', () => {
  console.log(`Server is running on port: ${process.env.PORT || '3000'}`);
});

testresult = console.log(`Server is running on port: ${process.env.PORT || '3000'}`);

module.exports = {
  servertest: function () {
    return testresult;
  }
}