package com.nh;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 2.将流程部署到数据库表中
 */
public class ActivitiDeployment {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday_include.bpmn")
                .addClasspathResource("diagram/holiday_include.png")
                .name("请假流程网关")
                .deploy();
        //4.输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
        System.out.println(deployment.getKey());
    }
}
