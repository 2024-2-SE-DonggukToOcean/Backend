package com.example.dongguktoocean.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf ->
            csrf.disable() // CSRF 보호 비활성화
        }.httpBasic { basic ->
            basic.disable() // HTTP Basic 인증 비활성화
        }.authorizeHttpRequests { auth ->
            auth.requestMatchers("/api/v1/**").permitAll() // /api/v1/** 경로 허용
            auth.anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
        }
        return http.build()
    }
}


