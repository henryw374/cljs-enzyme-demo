var page = require('webpage').create();
page.open('http://localhost:3449', function(status) {
  console.log("Status: " + status);

  //phantom.exit();
});