package cn.devecorsoft.converting

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.mock.web.reactive.function.server.MockServerRequest
import reactor.core.publisher.Mono

@ExtendWith(MockitoExtension::class)
internal class RenderingMarkdownHandlerTest {
    @Mock
    private lateinit var processBuilder: ProcessBuilder

    @InjectMocks
    private lateinit var renderingMarkdownHandler: RenderingMarkdownHandler

    @Nested
    @DisplayName("Given rendering markdown")
    inner class Markdown {

        @Nested
        @DisplayName("When perform basic markdown syntax without styles")
        inner class StandardSyntax {

            @OptIn(ExperimentalCoroutinesApi::class)
            @Test
            fun `Then should delegate to subprocess`() = runTest {

                `when`(processBuilder.command("pandoc", "-h")).thenReturn(processBuilder)

                renderingMarkdownHandler.render(
                    MockServerRequest.builder().body(Mono.just(MarkdownDto("")))
                )

                verify(processBuilder).start()
            }
        }
    }
}