package dev.leotoloza.avengersapp.data.service.security

import java.math.BigInteger
import java.security.MessageDigest

class HashKeyBuilder {
    fun build(timestamp: String, privateKey: String, publicKey: String): String {
        val input = timestamp + privateKey + publicKey
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        return BigInteger(1, digest).toString(16).padStart(32, '0')
    }
}
