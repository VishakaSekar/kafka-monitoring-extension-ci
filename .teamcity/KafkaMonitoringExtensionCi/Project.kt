package KafkaMonitoringExtensionCi

import KafkaMonitoringExtensionCi.buildTypes.*
import KafkaMonitoringExtensionCi.vcsRoots.*
import KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.versionedSettings

object Project : Project({
    id("KafkaMonitoringExtensionCi")
    parentId("_Root")
    name = "Kafka Monitoring Extension Ci"

    vcsRoot(KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)

    buildType(KafkaMonitoringExtensionCi_Build)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = "${KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
