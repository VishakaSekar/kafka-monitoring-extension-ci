package KafkaMonitoringExtensionCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object KafkaMonitoringExtensionCi_Build : BuildType({
    uuid = "77b6ab4e-8914-49f1-a725-7e6743b43114"
    name = "Build"

    vcs {
        root(KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)
    }

    triggers {
        vcs {
        }
    }
})
