package com.nh.businessKey;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 *启动流程实例时，添加businesskey
 */
public class BusinessKeyAdd {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.启动流程实例时，同时指定业务表示businesskey，本身是业务表的请假单id
        //第一个参数：流程定义key
        //第二个参数:业务表的id-businesskey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("请假流程","1001");
        //4.输出流程实例信息
        System.out.println("businessKey："+processInstance.getBusinessKey());
    }
}
