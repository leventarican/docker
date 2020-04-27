const http = require("http"), os = require("os");

http.createServer((req, res) => {
    const dateTime = new Date(),
        load = os.loadavg(),
        doc = `<!DOCTYPE html>
<html>
  <body align="center">
    <h1>Node.js - Docker</h1>
    server time:: ${dateTime}<br />
    server load: ${load[0]}
  </body>
</html>`
    res.setHeader('Content-Type', 'text/html');
    res.end(doc);
}).listen(8080);