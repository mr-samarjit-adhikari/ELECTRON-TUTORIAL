const request = require('request');

function quoteCallback(req){
    request('https://quotesondesign.com/wp-json/wp/v2/posts/?orderby=rand&page=1',(er,response,body)=>{
        body = JSON.parse(body);
        with(Math){            
            var index = ceil(random()*10);
        }
        document.getElementById('dailyQuote').innerHTML = body[index]['content']['rendered'];
    });
}

quoteCallback(request);
setInterval(()=>{
    quoteCallback(request);
},5000);

// console.log("From index.js");