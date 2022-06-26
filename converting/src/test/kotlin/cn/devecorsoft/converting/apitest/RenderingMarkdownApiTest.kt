package cn.devecorsoft.converting.apitest

import cn.devecorsoft.converting.Endpoints
import cn.devecorsoft.converting.MarkdownDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RenderingMarkdownApiTest(
    @Autowired private val testRestTemplate: TestRestTemplate
) {

    @Test
    fun `should 200`() {
        val result = testRestTemplate.postForEntity<Resource>(Endpoints.RENDER_MARKDOWN, MarkdownDto("# test"))
        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.headers.contentType).isEqualTo(MediaType.MULTIPART_FORM_DATA)
        assertThat(result.body?.contentLength()).isGreaterThan(0L)
    }
}