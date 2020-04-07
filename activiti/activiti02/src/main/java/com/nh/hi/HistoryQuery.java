package com.nh.hi;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * 查询历史记录表
 */
public class HistoryQuery {
    public static void main(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到HistoryService
        HistoryService historyService = processEngine.getHistoryService();
        //3.得到HistoryActivitiInstanceQuery
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
        //4.执行查询操作
        historicActivityInstanceQuery.processInstanceId("2501");
        historicActivityInstanceQuery.orderByHistoricActivityInstanceStartTime().desc();
        List<HistoricActivityInstance> list = historicActivityInstanceQuery.list();
        //5.遍历查询结果
        for (HistoricActivityInstance bean:list) {
            System.out.println(bean.getActivityId());
            System.out.println(bean.getActivityName());
            System.out.println(bean.getAssignee());
            System.out.println("========================");
        }
    }
}
