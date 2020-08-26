var express = require('express');
var mysql = require('mysql');
var app = express();

var connection = mysql.createPool({
    connectionLimit: 50,
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'cw1price'
});



app.get('/', function(req, resp){

connection.getConnection(function(error, tempCont) {
    if(!!error) {
        tempCont.release();
        console.log('Error');
    } else {
        console.log('Connected!');
        tempCont.query("SELECT * FROM bikes", function(error,rows, fields) {
            tempCont.release();
            if(!!error) {
                console.log('error in the query');
            } else{
                resp.json(rows);
            }
        } )
    
    }
});
})

app.listen(1337);