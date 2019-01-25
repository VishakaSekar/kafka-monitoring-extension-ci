package KafkaMonitoringExtensionCi.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionC_2 : GitVcsRoot({
    uuid = "614aeda1-40d1-499e-9d0b-85806fccbfb0"
    name = "https://github.com/VishakaSekar/kafka-monitoring-extension-ci#refs/heads/master (1)"
    url = "https://github.com/VishakaSekar/kafka-monitoring-extension-ci"
    authMethod = password {
        userName = "VishakaSekar"
        password = "credentialsJSON:78342c0a-6fdf-422a-b3ee-8ab94b77b18d"
    }
})
