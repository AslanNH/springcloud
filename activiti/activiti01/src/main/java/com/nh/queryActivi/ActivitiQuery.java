package com.nh.queryActivi;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 4.查询当前用户任务
 */
public class ActivitiQuery {

    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.根据流程定义key以及负责人查询
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("请假流程")
                .taskAssignee("lisi")
                .list();
        //4.任务列表展示
        for (Task task:list
             ) {
            System.out.println("流程实例ID："+task.getProcessInstanceId());
            System.out.println("任务ID："+task.getId());
            System.out.println("任务名称："+task.getName());
            System.out.println("任务负责人："+task.getAssignee());
        }
    }
}
