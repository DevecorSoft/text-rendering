package cn.devecorsoft.converting

import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RenderingController {

    @PostMapping(Endpoints.RENDER_MARKDOWN)
    fun renderMarkdown(): ResponseEntity<Resource> {
        return ResponseEntity.ok(null)
    }
}