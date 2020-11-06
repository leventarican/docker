from http.server import BaseHTTPRequestHandler, HTTPServer
import os, datetime

class TheServer(BaseHTTPRequestHandler):
    def do_GET(self):
        load = os.getloadavg();
        html = """<!DOCTYPE html>
<html>
<head>
    <title>a python server</title>
    <meta charset="utf-8" />
</head>
<body>
    <code>a python server</code>
    server time: {now}<br/>
    server load: {load}
</body>
</html>
        """.format(now=datetime.datetime.now().astimezone(), load=load[0])
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(bytes(html, "utf8"))
        return
    
def run():
    addr = ("", 8080)
    httpd = HTTPServer(addr, TheServer)
    print(f"running local server with port: {addr[1]}. close with CTRL+C. check with curl -i localhost:8080")
    httpd.serve_forever()

if __name__ == "__main__":
    run()
