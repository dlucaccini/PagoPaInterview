const net = require('net');

const sockets = [];
const port = 10000;

let userId = 0;

const server = net.createServer(function (socket) {

    socket.user = "User-" + (++userId);

    sockets.push(socket);

    console.log(socket.user + ' è entrato in chat');

    socket.write("---------------------------------\n");
    socket.write("Benvenuto nella chat room, " + socket.user + "!\n");
    socket.write("---------------------------------\n");

    broadcastToConnectedUsers(socket.user, socket.user + ' è entrato in chat.\n');

    setupSocketListeners(socket);

});

function broadcastToConnectedUsers(sender, message) {
    if (sockets.length === 0) {
        process.stdout.write("Non c'è più nessuno in chat :(");
        return;
    }
    sockets.forEach(function(socket){
        if(socket.user === sender) return;
        socket.write(message);
    });
}

function removeSocket(socket) {
    sockets.splice(sockets.indexOf(socket), 1);
}

function setupSocketListeners(socket) {
    socket.on('data', function (data) {
        if(data.toString().trim() !== "" && data.toString().trim().charCodeAt(0) !== 4) {
            const message = socket.user + ' > ' + data.toString();
            broadcastToConnectedUsers(socket.user, message);
            process.stdout.write(message);
        }
    });
    socket.on('end', function () {
        const message = socket.user + ' ha lasciato la chatroom\n';
        process.stdout.write(message);
        removeSocket(socket);
        broadcastToConnectedUsers(socket.user, message);
    });
}

server.listen(port, function() {
    console.log("Server in ascolto, localhost:" + port);
});