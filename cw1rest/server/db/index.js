const mysql =require('mysql');

const pool = mysql.createPool({
    connectionLimit: 10,    
    password: '',
    user: 'root',
    database: 'price_comparison',
    host: 'localhost',
    port: '3306'
});

let bikesdb = {};

// get all
bikesdb.all = () => {
return new Promise((resolve, reject) => {
    pool.query(`SELECT * FROM bikes`, (err, results) => {
    if(err) {
        return reject(err);
    }
    return resolve(results);

});
});
};

//get id
bikesdb.one = (id) => {
    return new Promise((resolve, reject) => {
        pool.query(`SELECT * FROM bikes WHERE id = ?`, [id], (err, results) => {
            if(err) {
                return reject(err);
            }
            return resolve(results[0]);
            
        });
    });
};

// bikesdb.name = (bikeName) => {
//     return new Promise((resolve, reject) => {
//         pool.query(`SELECT * FROM bikes WHERE bikeName = ?`, [bikeName], (err, bikeresults) => {
//             if(err) {
//                 return reject(err);
//             }
//             return resolve(bikeresults[5]);
//         });
//     });
// };

// module.exports = {
//     getID: function(){
//     return (resolve(results));
// },
// bikesdb
// };




//search
// var connection = mysql.createConnection({
//     host: 'localhost',
//     user: 'root',
//     password: '',
//     database: 'price_comparison',
//     "scripts": {
//       "dev": "npx nodemon server.js -w Server"
//     },
//   });
  
//   connection.connect();
// const express = require ('express');
// const app = express();
// app.set('views',__dirname + '/views');
// app.use(express.static(__dirname + '/JS'));
// app.set('view engine', 'ejs');
// app.engine('html', require('ejs').renderFile);

// app.get('/',function(req,res){
// res.render('index.html');
// });

// app.get('/search',function(req,res){
// connection.query('SELECT bikeName from bikes where bikeName like "%'+req.query.key+'%"', function(err, rows, fields) {
//       if (err) throw err;
//     var data=[];
//     for(i=0;i<rows.length;i++)
//       {
//         data.push(rows[i].bikeName);
//       }
//       res.end(JSON.stringify(data));
//     });
// });








module.exports = bikesdb;
