package KafkaMonitoringExtensionCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object KafkaMonitoringExtensionCi_Build1 : BuildType({
    uuid = "56057a63-d3c7-47b3-8895-ebf77e94ae65"
    name = "Build (1)"

    vcs {
        root(KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)
    }

    steps {
        dockerCommand {
            commandType = build {
                source = path {
                    path = "Dockerfile"
                }
            }
        }
        dockerCompose {
            file = "docker-compose.yml"
        }
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }
        script {
            scriptContent = "./broker-list.sh"
        }
        script {
            scriptContent = "./create-topics.sh"
        }
        script {
            scriptContent = "./download-kafka.sh"
        }
        script {
            scriptContent = "./start-kafka-shell.sh"
        }
        script {
            scriptContent = "./start-kafka.sh"
        }
        script {
            scriptContent = "./versions.sh"
        }
    }

    triggers {
        vcs {
        }
    }
})
