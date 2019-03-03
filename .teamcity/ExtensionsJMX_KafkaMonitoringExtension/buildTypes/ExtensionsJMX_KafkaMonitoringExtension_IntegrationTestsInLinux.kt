package ExtensionsJMX_KafkaMonitoringExtension.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs
import ExtensionsJMX_KafkaMonitoringExtension.vcsRoots.kafkamonitoringextensionci
import ExtensionsJMX_KafkaMonitoringExtension.buildTypes.*;

object ExtensionsJMX_KafkaMonitoringExtension_IntegrationTestsInLinux : BuildType({
    uuid = "7BE210AD-581F-42A3-9938-FD5482212236"
    name = "IntegrationTests In Linux"

    vcs {
        root(kafkamonitoringextensionci)
    }

    steps {
        maven {

            goals = "clean install"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }


    }

    dependencies {
        dependency(ExtensionsJMX_KafkaMonitoringExtension_SetupKafka) {
            snapshot {

            }
        }
    }

    triggers {
        vcs {
        }
    }
})
