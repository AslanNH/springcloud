package com.nh.genDB;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 1.生成activiti所需的表到指定的数据库
 *
 */

public class GenActivitiDB
{
    public static void main(String[] args) {
        //1.创建ProcessEngineConfiguration对象  第一个参数:配置文件名称  第二个参数是配置文件processEngineConfiguration的bean的id

        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml","processEngineConfiguration");

        //2.创建ProcesEngine对象

        ProcessEngine processEngine = configuration.buildProcessEngine();

        //3.输出processEngine对象

        System.out.println(processEngine);

    }

}
