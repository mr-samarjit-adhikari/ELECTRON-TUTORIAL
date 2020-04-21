console.log("Main process working");
const electron = require("electron");
const app = electron.app;
const BrowserWindow = electron.BrowserWindow;
const path = require("path");
const url = require("url");

let win;

function createWindow(){
    win = new BrowserWindow({width:400,height:200,frame:false,webPreferences: { nodeIntegration: true}});
    win.loadURL(url.format({
        pathname: path.join(__dirname,"index.html"),
        protocol: 'file',
        slashes: false
    }))
    //win.webContents.openDevTools();
    win.on('closed',()=>{
        win = null;
    });
}

app.allowRendererProcessReuse=false;
app.on('ready',createWindow);