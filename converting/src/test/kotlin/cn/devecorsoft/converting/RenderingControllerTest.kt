package cn.devecorsoft.converting

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class RenderingControllerTest {

    @InjectMocks
    private lateinit var renderingController: RenderingController

    @Nested
    @DisplayName("Given rendering markdown")
    inner class Markdown {
        @Nested
        @DisplayName("to WordprocessingML file")
        inner class ToWordprocessingML {
            @Test
            fun `should return a binary resource`() {
                renderingController.renderMarkdown()
            }
        }
    }
}
