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
        processBuilder.command("pandoc", "-h").start()
        return ServerResponse.ok().buildAndAwait()
    }
}
