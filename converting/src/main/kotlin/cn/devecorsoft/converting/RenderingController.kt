package cn.devecorsoft.converting

import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RenderingController {

    @PostMapping("/rendering/markdown")
    fun renderMarkdown(): ResponseEntity<Resource> {
        return ResponseEntity.ok(null)
    }
}