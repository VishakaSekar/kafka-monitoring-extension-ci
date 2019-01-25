package KafkaMonitoringExtensionCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object KafkaMonitoringExtensionCi_Build : BuildType({
    uuid = "24861ff0-7d50-4dde-9d1b-b4dcddd74939"
    name = "Build"

    vcs {
        root(KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }
        dockerCompose {
            file = "docker-compose.yml"
        }
        dockerCommand {
            commandType = build {
                source = path {
                    path = "Dockerfile"
                }
            }
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
