const express = require('express');
 const db = require('../db');
const router = express.Router();

// get all
router.get('/', async (req, res, next) =>{
    try {
        let results = await db.all();
        res.json(results);
    } catch(e) {
        console.log(e);
        res.sendStatus(500);
    }
});

// router for id
router.get('/:id', async (req, res, next) =>{
    try {
        let results = await db.one(req.params.id);
        res.json(results);
    } catch(e) {
        console.log(e);
        res.sendStatus(500);
    }
});

// // router for bikeName
// router.get('/name/:bikeName', async (req, res, next) =>{
//     try {
//         let bikeresults = await db.name(req.params.bikeName);
//         res.json(bikeresults);
//     } catch(e) {
//         console.log(e);
//         res.sendStatus(500);
//     }
// });


module.exports = router;
