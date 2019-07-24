package com.blockget2.kotlin





import ch.decent.sdk.DCoreApi
import ch.decent.sdk.DCoreConstants
import ch.decent.sdk.DCoreSdk
import ch.decent.sdk.crypto.Credentials
import ch.decent.sdk.model.*
import ch.decent.sdk.net.TrustAllCerts
import okhttp3.OkHttpClient
import org.slf4j.LoggerFactory




fun main(args: Array<String>) {
    println("Hello, World")
    println("testing")

    val client = TrustAllCerts.wrap(OkHttpClient().newBuilder()).build()
    val api = DCoreSdk.create(
        client,
        "wss://testnet-socket.dcore.io/",
        "https://testnet.dcore.io/",
        LoggerFactory.getLogger("SDK_SAMPLE")
    )
    val credentials = api.accountApi
        .createCredentials("public-account-10", "5JMpT5C75rcAmuUB81mqVBXbmL1BKea4MYwVK6voMQLvigLKfrE")
        .blockingGet()

    //        balanc
    //        receiver
    val receiver = api.accountApi.getByName("public-account-9")
        .blockingGet()
    println("RECIEVER ACCOUNT " + receiver.toString())



}

