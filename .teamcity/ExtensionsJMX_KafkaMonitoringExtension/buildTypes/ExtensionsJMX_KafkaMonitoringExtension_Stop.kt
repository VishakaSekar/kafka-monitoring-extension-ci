package ExtensionsJMX_KafkaMonitoringExtension.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs


import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.exec
import ExtensionsJMX_KafkaMonitoringExtension.vcsRoots.kafkamonitoringextensionci
import ExtensionsJMX_KafkaMonitoringExtension.buildTypes.*


object ExtensionsJMX_KafkaMonitoringExtension_Stop : BuildType({
    uuid = "adc25bd3-02fb-4561-b335-2d344494f9d2"
    name = "Stop"

    vcs {
        root(kafkamonitoringextensionci)
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
