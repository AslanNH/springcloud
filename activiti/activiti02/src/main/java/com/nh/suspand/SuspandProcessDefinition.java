package com.nh.suspand;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

/**
 * 全部流程定义的挂起激活
 * 挂起的流程定义将会是的后续无法执行流程实例
 */
public class SuspandProcessDefinition {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.repositoryService
       RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.得到当前流程定义状态
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        processDefinitionQuery.processDefinitionKey("请假流程");
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        //4.获取流程定义挂起状态
        Boolean  suspand = processDefinition.isSuspended();
        //如果挂起，则激活
        if(suspand){
            repositoryService.activateProcessDefinitionById(processDefinition.getId(),true,null);
            System.out.println("流程定义："+processDefinition.getName()+"被激活");
        }else{
            repositoryService.suspendProcessDefinitionById(processDefinition.getId(),true,null);
            System.out.println("流程定义："+processDefinition.getName()+"被挂起");
        }
    }
}
