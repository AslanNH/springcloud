package com.nh.procdef;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 1.流程定义查询
 */
public class ProcessDefineQuery {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.得到ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置条件，并查询出当前所有的流程定义
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("请假流程")
                              .orderByProcessDefinitionVersion()
                              .desc()
                              .list();
        //5.输出流程定义信息
        for (ProcessDefinition p : list) {
            System.out.println("流程定义ID："+p.getId());
            System.out.println("流程定义名称："+p.getName());
            System.out.println("流程定义Key："+p.getKey());
            System.out.println("流程定义版本号："+p.getVersion());
            System.out.println("流程部署ID："+p.getDeploymentId());
        }
    }
}
