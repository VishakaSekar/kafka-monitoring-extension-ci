/*
 * Copyright 2018. AppDynamics LLC and its affiliates.
 * All Rights Reserved.
 * This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 * The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extensions.kafka;

import com.appdynamics.extensions.ABaseMonitor;
import com.appdynamics.extensions.TasksExecutionServiceProvider;
import com.appdynamics.extensions.kafka.utils.Constants;
import com.appdynamics.extensions.kafka.utils.SslUtils;
import com.appdynamics.extensions.util.AssertUtils;
import com.google.common.collect.Maps;
import com.singularity.ee.agent.systemagent.api.exception.TaskExecutionException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.appdynamics.extensions.kafka.utils.Constants.DEFAULT_METRIC_PREFIX;

public class KafkaMonitor extends ABaseMonitor {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(KafkaMonitor.class);

    @Override
    protected void onConfigReload (File file) {
        Map<String, ?> configMap = this.getContextConfiguration().getConfigYml();
        //#TODO We need to find a better way to handle SSL in JMX.
        SslUtils sslUtils = new SslUtils();
        sslUtils.setSslProperties(configMap);
    }

    protected String getDefaultMetricPrefix () {
        return DEFAULT_METRIC_PREFIX;
    }

    public String getMonitorName () {
        return Constants.KAFKA_MONITOR;
    }

    protected void doRun (TasksExecutionServiceProvider tasksExecutionServiceProvider) {
        List<Map<String, String>> kafkaServers = (List<Map<String, String>>)
                this.getContextConfiguration().getConfigYml().get(Constants.SERVERS);
        logger.info("The size of servers section is: "+kafkaServers);
        for (Map<String, String> kafkaServer : kafkaServers) {
            KafkaMonitorTask task = new KafkaMonitorTask(tasksExecutionServiceProvider,
                    this.getContextConfiguration(), kafkaServer);
            AssertUtils.assertNotNull(kafkaServer.get(Constants.DISPLAY_NAME),
                    "The displayName can not be null");
            tasksExecutionServiceProvider.submit(kafkaServer.get(Constants.DISPLAY_NAME), task);
        }
    }

//    protected int getTaskCount () {
//        List<Map<String, String>> servers = (List<Map<String, String>>) getContextConfiguration().
//                getConfigYml().get(Constants.SERVERS);
//        AssertUtils.assertNotNull(servers, "The 'servers' section in config.yml is not initialized");
//        return servers.size();
//    }

    @Override
    protected List<Map<String, ?>> getServers () {
        return (List<Map<String, ?>>) getContextConfiguration().
                getConfigYml().get(Constants.SERVERS);
    }

    public static void main(String[] args) throws TaskExecutionException, IOException {

        ConsoleAppender ca = new ConsoleAppender();
        ca.setWriter(new OutputStreamWriter(System.out));
        ca.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
        ca.setThreshold(Level.DEBUG);
        org.apache.log4j.Logger.getRootLogger().addAppender(ca);


        KafkaMonitor monitor = new KafkaMonitor();
        final Map<String, String> taskArgs = Maps.newHashMap();
        taskArgs.put("config-file", "/Users/vishaka.sekar/AppDynamics/kafka-monitoring-extension-ci/src/main/resources/conf/config.yml");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    monitor.execute(taskArgs, null);
                } catch (Exception e) {
                    logger.error("Error while running the task", e);
                }
            }
        }, 2, 60, TimeUnit.SECONDS);

    }
}