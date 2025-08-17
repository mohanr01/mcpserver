/**
 * 
 * This file is part of the MCPServer project.
 */
const body = document.body;

const panel = document.createElement("div");
panel.setAttribute("class", "msgBox");
body.appendChild(panel);

const msg = document.createElement("p");
msg.textContent = "This is a message box";
panel.appendChild(msg);

const closeBtn = document.createElement("button");
closeBtn.textContent = "x";
panel.appendChild(closeBtn);

closeBtn.addEventListener("click", () =>
  panel.parentNode.removeChild(panel),
);

const button = document.querySelector("button");

button.addEventListener("click", async () => {
  // Fetch all MCP tools from local MCP server
  try {
    const response = await fetch("http://localhost:8000/application/v1/tools");
    const tools = await response.json();
    if (Array.isArray(tools) && tools.length > 0) {
      msg.textContent = tools.map(tool =>
        `Tool: ${tool.name}\nDescription: ${tool.description}\nBean: ${tool.bean}\nMethod: ${tool.method}\n`
      ).join("\n-------------------\n");
    } else {
      msg.textContent = "No MCP tools found.";
    }
    panel.style.display = "block";
  } catch (e) {
    msg.textContent = "Error connecting to MCP server.";
    panel.style.display = "block";
  }
});

// Hide panel by default
panel.style.display = "none";