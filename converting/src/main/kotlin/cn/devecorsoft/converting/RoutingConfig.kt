package cn.devecorsoft.converting

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*

@Configuration
class RoutingConfig {
    @Bean
    fun monoRouting(renderingMarkdownHandler: RenderingMarkdownHandler): RouterFunction<ServerResponse> = coRouter {
        POST(Endpoints.RENDER_MARKDOWN, renderingMarkdownHandler::render)
    }
}