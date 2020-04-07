package com.nh.procdef;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * 2.删除流程定义信息
 *
 */
public class ProcessDefineDelete {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.删除流程定义,
        //repositoryService.deleteDeployment("1");//删除完成的流程
        repositoryService.deleteDeployment("157501",true);//删除未完成的流程 true代表级连删除
    }
}
