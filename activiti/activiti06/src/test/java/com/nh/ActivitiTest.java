package com.nh;

import com.nh.util.SecurityUtil;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {
    @Autowired
    private ProcessRuntime processRuntime;//实现流程定义相关操作

    @Autowired
    private TaskRuntime taskRuntime;//任务相关操作

    @Autowired
    private SecurityUtil securityUtil;//security相关工具类

    /**
     * 分页查询已经部署的流程
     * 部署是自动的
     */
    @Test
    public void testDefinition(){
        securityUtil.logInAs("ryandawsonuk");
        Page processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0,10));
        System.out.println("已部署的流程有："+processDefinitionPage.getTotalItems()+"条");
        for (Object pd :processDefinitionPage.getContent()) {
            System.out.println(pd);
        }
    }

    /**
     * 启动流程实例
     */
    @Test
    public void testStartProcess(){
        securityUtil.logInAs("salaboy");
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("team01").build());
        System.out.println("流程实例ID： "+processInstance.getId());
    }

    /**
     * 查询任务
     * 完成任务
     */
    @Test
    public void testQueryProcess(){
        securityUtil.logInAs("salaboy");
        Page<Task> page = taskRuntime.tasks(Pageable.of(0, 10));
        if(page.getTotalItems()>0){
            for(Task task:page.getContent()){
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
                System.out.println("任务1："+task);
                taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
            }
        }
        Page<Task> page1 = taskRuntime.tasks(Pageable.of(0, 10));
        if(page.getTotalItems()>0){
            for(Task task:page1.getContent()){

                System.out.println("任务2："+task);
            }
        }
    }
}
