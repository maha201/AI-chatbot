function sendMessage() {
    var userInput = document.getElementById("user-input").value;

    if (userInput.trim() !== "") {
        var request = new XMLHttpRequest();
        request.open("POST", "/api/chat", true);
        request.setRequestHeader("Content-Type", "application/json");

        request.onreadystatechange = function () {
            if (request.readyState === XMLHttpRequest.DONE && request.status === 200) {
                var response = JSON.parse(request.responseText);
                displayMessage(userInput, "user");
                displayMessage(response, "chatbot");
                document.getElementById("user-input").value = "";
            }
        };

        request.send(JSON.stringify({ userInput: userInput }));
    }
}

function displayMessage(message, sender) {
    var chatMessages = document.getElementById("chat-messages");
    var messageElement = document.createElement("div");
    messageElement.className = "message " + sender;
    messageElement.innerHTML = message;
    chatMessages.appendChild(messageElement);
}
