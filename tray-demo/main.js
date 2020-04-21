console.log("Main process working");
const electron = require("electron");
const app = electron.app;
const BrowserWindow = electron.BrowserWindow;
const path = require("path");
const url = require("url");
const Tray = electron.Tray;
const Menu = electron.Menu;
const iconPath = path.join(__dirname,'ytlogo.jpg');

let win,appTray;

function createWindow(){
    win = new BrowserWindow();
    win.loadURL(url.format({
        pathname: path.join(__dirname,"index.html"),
        protocol: 'file',
        slashes: true,
    }));

    var contextMenu = Menu.buildFromTemplate([
        {
            label: 'Show App',
            click: function(){
                win.show();
            }
        },
        {
            label: 'Quit',
            role: 'quit'
        }

    ]);
    
    appTray = new Tray(iconPath);
    appTray.setContextMenu(contextMenu);
    appTray.setToolTip("Tray-Demo");

    win.on('minimize',function(event){
        event.preventDefault();
        win.hide();
    });

    win.on('closed',()=>{
        win = null;
    });
}

app.allowRendererProcessReuse=false;
app.on('ready',createWindow);