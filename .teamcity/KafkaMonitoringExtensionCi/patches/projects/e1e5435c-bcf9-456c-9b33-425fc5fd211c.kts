package KafkaMonitoringExtensionCi.patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the project with uuid = 'e1e5435c-bcf9-456c-9b33-425fc5fd211c' (id = 'KafkaMonitoringExtensionCi')
accordingly, and delete the patch script.
*/
changeProject(uuid("e1e5435c-bcf9-456c-9b33-425fc5fd211c")) {
    expectBuildTypesOrder(AbsoluteId("KafkaMonitoringExtensionCi_Build"), AbsoluteId("KafkaMonitoringExtensionCi_SetupKafka"), AbsoluteId("KafkaMonitoringExtensionCi_Stop"))
    buildTypesOrderIds = arrayListOf<Id>()
}
