package com.nh.startActiviti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.启动流程实例
 */
public class ActivitiStart {

    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //定义流程变量，设置assignee
        Map<String,Object> map = new HashMap<>();
        map.put("assignee0","黑琦一户");
        map.put("assignee1","朽木白哉");
        map.put("assignee2","总队长");
        //3.创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("请假流程",map);
        //4.输出流程实例信息
        System.out.println("流程部署ID："+processInstance.getDeploymentId());
        System.out.println("流程定义ID："+processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID："+processInstance.getId());
        System.out.println("活动ID："+processInstance.getActivityId());
    }
}
