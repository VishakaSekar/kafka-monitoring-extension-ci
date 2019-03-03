package ExtensionsJMX_KafkaMonitoringExtension.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs
import ExtensionsJMX_KafkaMonitoringExtension.vcsRoots.kafkamonitoringextensionci


import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs


object ExtensionsJMX_KafkaMonitoringExtension_Build : BuildType({
    uuid = "8d38ea0b-5554-4d51-9ca2-aa3897610fdb"
    name = "Build"

    vcs {
        root(kafkamonitoringextensionci)
    }

    steps {
        maven {
            goals = "clean install -Pno-integration-tests"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }


    }

    triggers {
        vcs {
        }
    }

    artifactRules = """
       target/KafkaMonitor-*.zip
    """.trimIndent()
})
