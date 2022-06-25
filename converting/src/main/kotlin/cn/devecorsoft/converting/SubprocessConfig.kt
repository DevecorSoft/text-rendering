package cn.devecorsoft.converting

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class SubprocessConfig {

    @Bean
    @Scope("prototype")
    fun processBuilder() = ProcessBuilder()
}