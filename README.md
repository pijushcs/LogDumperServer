#### `LogDumper Server:`
The LogDumper Server is a multithreaded TCP server that can accept multiple LogDumper clients and the print the logs accordingly.

<b>Usage:</b> java -jar LogDumperServer [port-to-bind]

---

#### `Note`:
The server can accept multiple LogDumper clients and starts each of them in a separate thread defined in the class <b>LogDumperClientCon</b>

---
