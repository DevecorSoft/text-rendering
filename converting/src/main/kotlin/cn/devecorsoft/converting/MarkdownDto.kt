package cn.devecorsoft.converting

import java.math.BigInteger
import java.security.MessageDigest

class MarkdownDto(
    val content: String
) {
    private val messageDigest = MessageDigest.getInstance("MD5")

    val checksum: String
        get() {
            return BigInteger(1, messageDigest.digest(content.toByteArray()))
                .toString(16)
        }
}
