
$(function(){
    let socket = io.connect('http://localhost:3000');

    let message = $("#message");
    let username = $("#username");
    let send_message = $("#send_message");
    let send_username = $("#send_username");
    let chatroom = $("#chatroom");
    let feedback = $("#feedback");

    send_message.click(function(){
        socket.emit('new_message', {message : message.val()})
    });

    socket.on("new_message", (data) => {
        feedback.html('');
        message.val('');
        chatroom.append("<p class='message'>" + data.username + ": " + data.message + "</p>")
    });

    send_username.click(function(){
        socket.emit('change_username', {username : username.val()})
    });

    message.bind("keypress", () => {
        socket.emit('typing')
    });

    socket.on('typing', (data) => {
        feedback.html("<p><i>" + data.username + " is typing a message..." + "</i></p>")
    })
});

