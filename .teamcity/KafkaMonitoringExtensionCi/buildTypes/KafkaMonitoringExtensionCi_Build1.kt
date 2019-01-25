package KafkaMonitoringExtensionCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object KafkaMonitoringExtensionCi_Build1 : BuildType({
    uuid = "56057a63-d3c7-47b3-8895-ebf77e94ae65"
    name = "Build (1)"

    vcs {
        root(KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)
    }

    triggers {
        vcs {
        }
    }
})
