package ExtensionsJMX_KafkaMonitoringExtension.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object kafkamonitoringextensionci : GitVcsRoot({
    uuid = "0727f1a7-b9bf-40fa-a056-787ede9b55ec"
    name = "kafka"
    id = "kafkamonitoringextensionci"
    url = "git@github.com:VishakaSekar/kafka-monitoring-extension-ci.git"
    userNameStyle = GitVcsRoot.UserNameStyle.EMAIL
    authMethod = uploadedKey {
        uploadedKey = "v"
        passphrase = "credentialsJSON:7036c5d7-cf6f-4746-ac0f-681a8777ee4d"
    }
})
