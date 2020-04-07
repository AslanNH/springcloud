package com.nh.procdef;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 3.读取BPMN文件
 * 从 ACT_GE_BYTEARRY表读取资源文件
 * 将资源文件保存/root/图片
 * 注意:bmpn文件要与png文件在一个目录下，不然procdef表中将没有png名字
 */
public class BpmnFileQuery {
    public static void main(String[] args) throws Exception{
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.流程定义信息查询其
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置查询条件
        processDefinitionQuery.processDefinitionKey("请假流程");
        //5.查询bpmn信息
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        //6.通过流程定义信息，获得部署id
        String deploymentId = processDefinition.getDeploymentId();
        //7.通过repositoryervice方法实现读取图片信息
        InputStream picIs = repositoryService.getResourceAsStream(deploymentId,processDefinition.getDiagramResourceName());
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId,processDefinition.getResourceName());
        //8.构造outputstream
        OutputStream picOs = new FileOutputStream("/root/图片/"+processDefinition.getDiagramResourceName());
        OutputStream bpmnOs = new FileOutputStream("/root/图片/"+processDefinition.getResourceName());
        //9.实现输入流转输出流
        IOUtils.copy(picIs,picOs);
        IOUtils.copy(bpmnIs,bpmnOs);
        //10.关闭流
        picIs.close();
        bpmnIs.close();
        picOs.close();
        bpmnOs.close();
    }
}
