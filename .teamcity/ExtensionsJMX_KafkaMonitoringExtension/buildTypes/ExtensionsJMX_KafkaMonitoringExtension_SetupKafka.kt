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


    params {
        param("env.APPDYNAMICS_AGENT_ACCOUNT_ACCESS_KEY", "zxx907bb5f174b083cd4f6413203c259a5679287fefe33795f54430a4d0d6b0e47849de9b58c4b8a733")
        param("env.ENCRYPTION_KEY", "zxxc041dd7c481f14d0a252bd2c5d0100862acc6edf255b1ab7d553e0b306a6b630")
        param("env.PLAINTEXT_PWD", "zxx79a66a8da8b18181")
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
