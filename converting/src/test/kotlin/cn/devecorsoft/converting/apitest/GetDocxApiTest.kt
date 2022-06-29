package cn.devecorsoft.converting.apitest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetDocxApiTest(
    @Autowired private val testRestTemplate: TestRestTemplate
) {

    @BeforeEach
    fun setup() {
        val processBuilder = ProcessBuilder()
        val process = processBuilder.command("pandoc", "-f", "markdown", "-t", "docx", "-o", "test.docx").start()
        process.outputStream.write("# For test".toByteArray())
        process.outputStream.flush()
        process.outputStream.close()
    }

    @Test
    fun `should 200`() {
        val result = testRestTemplate.getForEntity("/docx/test.docx", Resource::class.java)
        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.headers.contentType).isEqualTo(MediaType.MULTIPART_FORM_DATA)
    }
}