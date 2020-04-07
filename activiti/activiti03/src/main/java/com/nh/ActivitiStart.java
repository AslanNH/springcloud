package com.nh;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动流程实例
 */
public class ActivitiStart {

    public static void main(String[] args) {
	    	Holiday holiday = new Holiday();
	    	holiday.setNum(4f);
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //定义流程变量，设置assignee
        Map<String,Object> map = new HashMap<>();
        map.put("holiday",holiday);
        //3.创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday_variable",map);
        //4.输出流程实例信息
        System.out.println("流程部署ID："+processInstance.getDeploymentId());
        System.out.println("流程定义ID："+processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID："+processInstance.getId());
        System.out.println("活动ID："+processInstance.getActivityId());
    }
}
