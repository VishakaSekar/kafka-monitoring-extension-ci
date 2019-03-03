package ExtensionsJMX_KafkaMonitoringExtension

import ExtensionsJMX_KafkaMonitoringExtension.vcsRoots.*
import ExtensionsJMX_KafkaMonitoringExtension.vcsRoots.kafkamonitoringextensionci
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "7d4cafb4-fc98-4354-a0ce-366ac8986247"
    id("ExtensionsJMX_KafkaMonitoringExtension")
    parentId("ExtensionsJMX")
    name = "Kafka Monitoring Extension"

    vcsRoot(kafkamonitoringextensionci)

    features {
        versionedSettings {
            id = "PROJECT_EXT_24"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = "${kafkamonitoringextensionci.id}"
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
