package dev.leotoloza.avengersapp.data.service.security

import org.junit.Assert.assertEquals
import org.junit.Test

class HashKeyBuilderTest {

    @Test
    fun `build should return correct MD5 hash`() {
        val hashKeyBuilder = HashKeyBuilder()
        val timestamp = "1"
        val privateKey = "abcd"
        val publicKey = "1234"
        // el hash md5 de "1abcd1234" es "ffd275c5130566a2916217b101f26150"
        val expectedHash = "ffd275c5130566a2916217b101f26150"

        val actualHash = hashKeyBuilder.build(timestamp, privateKey, publicKey)

        assertEquals(expectedHash, actualHash)
    }
}
