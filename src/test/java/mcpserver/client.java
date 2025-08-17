package mcpserver;

import java.util.Map;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.Content;
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;

public class client {
	public static void main(String[] args) {
		var stdioParams = ServerParameters.builder("java")
				.args("-jar",
						"C:\\Users\\Mohan\\eclipse-workspace\\mcpserver\\target\\mcpserver-0.0.1-SNAPSHOT.jar")
				.build();
		
			var transport = new StdioClientTransport(stdioParams);
			var client = McpClient.sync(transport).build();

			client.initialize();
 
			// List and demonstrate tools
			ListToolsResult toolsList = client.listTools();
			//System.out.println("Available Tools = " + toolsList);

			CallToolResult weatherForcastResult = client.callTool(new CallToolRequest("add",
					Map.of("a", "5", "b", "5")));
			Content content = weatherForcastResult.content().get(0);
			System.out.println("math: " + weatherForcastResult.content().get(0));

			client.closeGracefully();
	}
}
