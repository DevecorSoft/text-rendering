package cn.devecorsoft.converting

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.mock.web.reactive.function.server.MockServerRequest
import reactor.core.publisher.Mono
import java.io.InputStream
import java.io.OutputStream

@ExtendWith(MockitoExtension::class)
internal class RenderingMarkdownHandlerTest {
    @Mock
    private lateinit var processBuilder: ProcessBuilder

    @Mock
    private lateinit var process: Process

    @Mock
    private lateinit var outputStream: OutputStream

    @Mock
    private lateinit var inputStream: InputStream

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

                `when`(processBuilder.command("pandoc", "-f", "markdown", "-t", "docx", "-o", "-")).thenReturn(
                    processBuilder
                )
                `when`(processBuilder.start()).thenReturn(process)
                `when`(process.outputStream).thenReturn(outputStream)
                `when`(process.inputStream).thenReturn(inputStream)

                renderingMarkdownHandler.render(
                    MockServerRequest.builder().body(Mono.just(MarkdownDto("# test")))
                )

                verify(outputStream).write("# test".toByteArray())
                verify(outputStream).flush()
                verify(outputStream).close()
            }
        }
    }

    @Nested
    @DisplayName("Given rendering markdown to file")
    inner class MarkdownAsFile {

        @Nested
        @DisplayName("When perform basic markdown syntax without styles")
        inner class StandardSyntax {

            @OptIn(ExperimentalCoroutinesApi::class)
            @Test
            fun `Then should delegate to subprocess`() = runTest {
                val markdownDto = MarkdownDto("# test")

                `when`(
                    processBuilder.command(
                        "pandoc",
                        "-f",
                        "markdown",
                        "-t",
                        "docx",
                        "-o",
                        "${markdownDto.checksum}.docx"
                    )
                ).thenReturn(
                    processBuilder
                )
                `when`(processBuilder.start()).thenReturn(process)
                `when`(process.outputStream).thenReturn(outputStream)

                renderingMarkdownHandler.renderAsFile(
                    MockServerRequest.builder().body(Mono.just(markdownDto))
                )

                verify(outputStream).write("# test".toByteArray())
                verify(outputStream).flush()
                verify(outputStream).close()
            }
        }
    }
}