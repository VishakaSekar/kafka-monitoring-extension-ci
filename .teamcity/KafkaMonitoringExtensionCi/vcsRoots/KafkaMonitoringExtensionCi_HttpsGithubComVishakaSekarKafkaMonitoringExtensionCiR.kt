package KafkaMonitoringExtensionCi.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR : GitVcsRoot({
    uuid = "c3248a67-d397-4669-93c8-0a4760e6c6f4"
    name = "https://github.com/VishakaSekar/kafka-monitoring-extension-ci#refs/heads/master"
    url = "https://github.com/VishakaSekar/kafka-monitoring-extension-ci"
    authMethod = password {
        userName = "VishakaSekar"
        password = "credentialsJSON:78342c0a-6fdf-422a-b3ee-8ab94b77b18d"
    }
})
