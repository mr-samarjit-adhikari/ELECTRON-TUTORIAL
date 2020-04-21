console.log("Main process working");
const electron = require("electron");
const app = electron.app;
const BrowserWindow = electron.BrowserWindow;
const path = require("path");
const url = require("url");

let win,dimWindow,colorWindow,frmlessWindow;
let parentWindow, childWindow;

function createWindow(){
    // win = new BrowserWindow();
    // dimWindow = new BrowserWindow({width:400, height:400 , maxWidth: 600, maxHeight: 600});
    // colorWindow = new BrowserWindow({backgroundColor: '#800240'});
    // frmlessWindow = new BrowserWindow({frame: false, backgroundColor: '#500000'});
    parentWindow = new BrowserWindow({title: 'Parent Window'});
    childWindow = new BrowserWindow({parent:parentWindow, title: 'Child Window',modal:true,show:false});

    childWindow.loadURL('https://github.com');

    childWindow.on('ready-to-show',function(){
        childWindow.show();
    });

}

app.allowRendererProcessReuse=false;
app.on('ready',createWindow);