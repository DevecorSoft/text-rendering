package cn.devecorsoft.converting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarkdownDtoTest {
    @Test
    fun `should calculate checksum of markdown content`() {
        val markdownDto = MarkdownDto("# test")
        assertThat(markdownDto.checksum).isEqualTo("f9bab2bec0278638ea4bd0a3fd250d19")
    }
}