const express = require('express');
const soap = require('soap');
const { port, wsdl } = require('./config');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(express.static('public'));

app.get('/logs', (req, res) => {
  soap.createClient(wsdl, (err, client) => {
    if (err) console.log(err)
    if (!err) {
      client.ping((err, result) => {
        console.log(result);
        res.json({ status: 200, msg: result.return })
      })
    }
  })
})

app.post('/logs', (req, res) => {
  const { description, logType, moduleName, statusCode, platform } = req.body;
  soap.createClient(wsdl, (err, client) => {
    if (err) console.log(err)
    if (!err) {
      client.add({ description, logType, moduleName, statusCode, platform }, (err, result) => {
        console.log(result);
        res.json({ status: 200, msg: result.return })
      })
    }
  })
})

app.get('/logs/:date', (req, res) => {
  const queryDate = req.params.date;
  const date = queryDate.substr(0, 4) + '/' + queryDate.substr(4, 2) + '/' + queryDate.substr(6, 2);
  soap.createClient(wsdl, (err, client) => {
    if (err) console.log(err)
    if (!err) {
      client.getLog({ date }, (err, result) => {
        console.log(result);
        res.json({ status: 200, msg: result })
      })
    }
  })
})

app.listen(port, () => console.log(`Listening on port # ${port}`));