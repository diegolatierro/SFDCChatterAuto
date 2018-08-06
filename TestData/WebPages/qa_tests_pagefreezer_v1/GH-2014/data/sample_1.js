function AnalyzeTarget() {
    var anchor = document.getElementById("myAnchor");
    var message = "";
    message += "hash: " + anchor.hash + "\n";
    message += "host: " + anchor.host + "\n";
    message += "hostname: " + anchor.hostname + "\n";
    message += "href: " + anchor.href + "\n";
    message += "pathname: " + anchor.pathname + "\n";
    message += "port: " + anchor.port + "\n";
    message += "protocol: " + anchor.protocol + "\n";
    message += "protocolLong: " + anchor.protocolLong + "\n";
    message += "search: " + anchor.search + "\n";
    alert(message);
}
