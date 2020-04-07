package com.nh;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 5.处理当前用户任务
 */
public class ActivitiCompleteGroup {

    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.处理任务
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday_group")
                .taskCandidateUser("xiumubaizai")//指定候选人
                .list();
        //4.任务列表展示
        for (Task task:list) {
    				taskService.claim(task.getId(), "xiumubaizai");//拾取任务
    				System.out.println("拾取组任务");
    			/*	taskService.setAssignee(task.getId(),null);//归还任务
    				System.out.println("归还任务");*/
            System.out.println("任务ID："+task.getId());
            System.out.println("候选人："+task.getAssignee());
        }
//        //查询任务负责人
//        List<Task> list2 = taskService.createTaskQuery()
//                .processDefinitionKey("holiday_group")
//                .taskAssignee("xiumubaizai")
//                .list();
//        //4.完成任务
//        for (Task task:list2) {
//            System.out.println("任务ID："+task.getId());
//            System.out.println("候选人："+task.getAssignee());
//            /*taskService.complete(task.getId());
//            System.out.println("任务处理完成");*/
//        }
    }
}
