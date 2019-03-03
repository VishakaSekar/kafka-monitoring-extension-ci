package ExtensionsJMX_KafkaMonitoringExtension.patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the project with uuid = '7d4cafb4-fc98-4354-a0ce-366ac8986247' (id = 'ExtensionsJMX_KafkaMonitoringExtension')
accordingly, and delete the patch script.
*/
changeProject(uuid("7d4cafb4-fc98-4354-a0ce-366ac8986247")) {
    params {
        add {
            password("env.APPDYNAMICS_AGENT_ACCOUNT_ACCESS_KEY", "credentialsJSON:65747919-6823-4341-8a84-db15e792b3d7", display = ParameterDisplay.HIDDEN)
        }
        add {
            password("env.ENCRYPTION_KEY", "credentialsJSON:5c88d389-6725-4be7-a257-b4b03d0bac0b", display = ParameterDisplay.HIDDEN)
        }
    }
}
