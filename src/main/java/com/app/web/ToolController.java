package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.tool.annotation.Tool;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/application/v1")
// configure cors
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ToolController {
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/tools")
    public List<Map<String, String>> getAllMcpTools() {
        List<Map<String, String>> tools = new ArrayList<>();
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = applicationContext.getBean(beanName);
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Tool.class)) {
                    Tool tool = method.getAnnotation(Tool.class);
                    Map<String, String> toolInfo = new HashMap<>();
                    toolInfo.put("bean", bean.getClass().getSimpleName());
                    toolInfo.put("method", method.getName());
                    toolInfo.put("name", tool.name());
                    toolInfo.put("description", tool.description());
                    tools.add(toolInfo);
                }
            }
        }
        return tools;
    }
}