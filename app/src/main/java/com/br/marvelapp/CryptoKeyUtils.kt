package com.br.marvelapp

import java.security.NoSuchAlgorithmException

object CryptoKeyUtils {
    const val publicKey = "6bd10faa6dfbe50d7e8b7329b1df6c71"
    const val privateKey = "b503778cc3eb652d3d5484cd6e6f2b9672312ec9"

    fun md5(s: String): String {
        val md5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = java.security.MessageDigest
                .getInstance(md5)
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2)
                    h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }
}