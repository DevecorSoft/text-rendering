package cn.devecorsoft.converting

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class RenderingMarkdownHandler(
    private val processBuilder: ProcessBuilder
) {

    suspend fun render(serverRequest: ServerRequest): ServerResponse {
        val data = serverRequest.awaitBody<MarkdownDto>()
        val outputStream =
            processBuilder.command("pandoc", "-f", "markdown", "-t", "docx", "-o", "test.docx").start().outputStream
        outputStream.write(
            data.content.toByteArray()
        )
        outputStream.flush()
        return ServerResponse.ok().buildAndAwait()
    }
}
