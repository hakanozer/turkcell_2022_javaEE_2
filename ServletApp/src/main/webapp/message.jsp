
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <jsp:include page="inc/navbar.jsp"></jsp:include>

<script type="text/javascript">

    var wsUrl = "ws://localhost:8080/ServletApp_war/ws";

var webSocket;
function init() {
webSocket = new WebSocket(wsUrl);
webSocket.onopen = function(evt) {
onOpen(event)
};
webSocket.onclose = function(evt) {
onClose(event)
};
webSocket.onmessage = function(evt) {
onMessage(event)
};
webSocket.onerror = function(evt) {
onError(event)
};
}

function onOpen(event){
console.log("OnOpen Event");
}
function onClose(event) {
console.log("OnClose Event");
}
function onError(event) {
console.log("OnError Event");
}
function sendMessage() {
webSocket.send(textBox.value);
}
function onMessage(event) {
alert(event.data);
}
window.addEventListener("load", init, true);
</script>
<textarea id="textBox" rows="5" cols="20"></textarea>
<button onclick="sendMessage();">Send Message</button>


</div>
</body>
</html>
