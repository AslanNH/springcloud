package com.nh.suspand;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

/**
 * 单个流程实例的挂起
 */
public class SuspandProcessInstance {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.runtimeService
       RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.得到当前流程实例状态
        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
        processInstanceQuery.processDefinitionKey("请假流程");
        ProcessInstance processInstance = processInstanceQuery.singleResult();
        //4.获取流程实例挂起状态
        Boolean  suspand = processInstance.isSuspended();
        //如果挂起，则激活
        if(suspand){
            runtimeService.activateProcessInstanceById(processInstance.getId());
            System.out.println("流程实例："+processInstance.getId()+"被激活");
        }else{
            runtimeService.suspendProcessInstanceById(processInstance.getId());
            System.out.println("流程实例："+processInstance.getId()+"被挂起");
        }
    }
}
