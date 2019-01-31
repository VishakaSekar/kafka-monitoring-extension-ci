package KafkaMonitoringExtensionCi

import KafkaMonitoringExtensionCi.buildTypes.*
import KafkaMonitoringExtensionCi.vcsRoots.*
import KafkaMonitoringExtensionCi.vcsRoots.KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "d8ec7368-9cde-4a3c-b444-e7c3d06d247a"
    id("KafkaMonitoringExtensionCi")
    parentId("_Root")
    name = "Kafka Monitoring Extension Ci"

    vcsRoot(KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR)

    buildType(KafkaMonitoringExtensionCi_Build)
    buildType(KafkaMonitoringExtensionCi_SetupKafka)
    buildType(KafkaMonitoringExtensionCi_IntegrationTestsInLinux)
    buildType(KafkaMonitoringExtensionCi_Stop)

    features {
        versionedSettings {
            id = "PROJECT_EXT_4"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = "${KafkaMonitoringExtensionCi_HttpsGithubComVishakaSekarKafkaMonitoringExtensionCiR.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }

    buildTypesOrder = arrayListOf(
            KafkaMonitoringExtensionCi_Build,
            KafkaMonitoringExtensionCi_SetupKafka,
            KafkaMonitoringExtensionCi_IntegrationTestsInLinux,
            KafkaMonitoringExtensionCi_Stop
    )



})
