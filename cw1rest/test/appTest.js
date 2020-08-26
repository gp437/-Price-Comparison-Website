const assert = require('chai').assert;
const servertest = require('../server/server.js').servertest;
const routes = require('../server/routes').idtest;

let chai = require('chai');
let chaiHttp = require ('chai-http');
let should = chai.should();
chai.use(chaiHttp);

describe('SERVERTEST', function(){
    it('app should return Server is running on port: 3000', function (){
        assert.equal(servertest(), console.log('Server is running on port: 3000'));
    })
});




