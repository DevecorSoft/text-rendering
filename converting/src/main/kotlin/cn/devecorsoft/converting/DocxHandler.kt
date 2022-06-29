package cn.devecorsoft.converting

import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import java.io.File
import java.io.FileInputStream

@Component
class DocxHandler {
    suspend fun getDocx(serverRequest: ServerRequest): ServerResponse {
        val pathDocx = serverRequest.pathVariable("docxName")
        val file = File("./${pathDocx}")
        return ServerResponse.ok().contentType(MediaType.MULTIPART_FORM_DATA).contentLength(file.length())
            .bodyValueAndAwait(InputStreamResource(FileInputStream(file)))
    }
}