package cn.devecorsoft.converting

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import org.springframework.web.reactive.function.server.*

@Configuration
class RoutingConfig {
    @Bean
    fun renderingRouting(renderingMarkdownHandler: RenderingMarkdownHandler): RouterFunction<ServerResponse> = coRouter {
        POST(Endpoints.RENDER_MARKDOWN, renderingMarkdownHandler::render)
        POST(Endpoints.RENDER_MARKDOWN_AS_FILE, renderingMarkdownHandler::renderAsFile)
    }

    @Bean
    fun docxRouting(docxHandler: DocxHandler): RouterFunction<ServerResponse> = coRouter {
        GET(Endpoints.DOCX, docxHandler::getDocx)
    }

    @Bean
    fun corsFilter(): CorsWebFilter {
        val config = CorsConfiguration()

        config.allowCredentials = true
        config.addAllowedOriginPattern("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")

        val source = UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration(Endpoints.RENDER_MARKDOWN, config)
            registerCorsConfiguration(Endpoints.RENDER_MARKDOWN_AS_FILE, config)
        }
        return CorsWebFilter(source)
    }
}