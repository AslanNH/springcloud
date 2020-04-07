package com.nh;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 5.处理当前用户任务
 */
public class ActivitiComplete {

    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.处理任务
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday_group")
                .taskAssignee("lisi")
                .list();
        //4.任务列表展示
        for (Task task:list) {
            System.out.println("任务ID："+task.getId());
            taskService.complete(task.getId());
            System.out.println("任务处理完成");
        }
    }
}
