package cn.devecorsoft.converting

import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class RenderingMarkdownHandler(
    private val processBuilder: ProcessBuilder
) {

    suspend fun render(serverRequest: ServerRequest): ServerResponse {
        val data = serverRequest.awaitBody<MarkdownDto>()
        val process = processBuilder.command("pandoc", "-f", "markdown", "-t", "docx", "-o", "-").start()
        val outputStream = process.outputStream

        outputStream.write(
            data.content.toByteArray()
        )
        outputStream.flush()
        outputStream.close()
        return ServerResponse.ok().contentType(MediaType.MULTIPART_FORM_DATA)
            .bodyValueAndAwait(InputStreamResource(process.inputStream))
    }
}
