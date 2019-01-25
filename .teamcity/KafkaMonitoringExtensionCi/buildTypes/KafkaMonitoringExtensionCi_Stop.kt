package KafkaMonitoringExtensionCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs


import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs


object KafkaMonitoringExtensionCi_Stop : BuildType({
    uuid = "adc25bd3-02fb-4561-b335-2d344494f9d2"
    name = "SetupKafka"

    vcs {
        root(KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)
    }

    steps {
        exec {
            path = "make"
            arguments = "dockerStop"
        }

    }

    triggers {
        vcs {
        }
    }
})
