package KafkaMonitoringExtensionCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object KafkaMonitoringExtensionCi_Build : BuildType({
    uuid = "75c498f0-14c7-45a6-a538-53ad0f9b87dc"
    name = "Build"

    vcs {
        root(KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionC_2)
    }

    steps {
        maven {
<<<<<<< HEAD
            goals = "clean install"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }


=======
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
            scriptContent = "./download-kafka.sh"
        }
        script {
            scriptContent = "./start-kafka.sh"
        }
        script {
            scriptContent = "./broker-list.sh"
        }
        script {
            scriptContent = "./create-topics.sh"
        }
        script {
            scriptContent = "./start-kafka-shell.sh"
        }
        script {
            scriptContent = "./versions.sh"
        }
>>>>>>> b0bf904db3528eacb99625b4d823f1b17f730069
    }

    triggers {
        vcs {
        }
    }

    artifactRules = """
       target/KafkaMonitor-*.zip
    """.trimIndent()
})
