package ExtensionsJMX_KafkaMonitoringExtension.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs


import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.exec
import ExtensionsJMX_KafkaMonitoringExtension.vcsRoots.kafkamonitoringextensionci



object ExtensionsJMX_KafkaMonitoringExtension_SetupKafka : BuildType({
    uuid = "129f1153-3e0f-4794-a46b-8a1600da7692"
    name = "SetupKafka"

    vcs {
        root(kafkamonitoringextensionci)
    }


    steps {
        exec {
            path = "make"
            arguments = "dockerRun"
        }

        //Waits for 5 minutes to send metrics to the controller
        exec {
            path = "make"
            arguments = "sleep"
        }

    }

    dependencies {
        dependency(ExtensionsJMX_KafkaMonitoringExtension_Build) {
            snapshot {


            }
        }
    }

    triggers {
        vcs {
        }
    }
})
