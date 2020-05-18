package com.lake.smartway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
    WebSecurityConfigurerAdapter 상속받는 우리가 만든 커스텀한 Bean등록하게 되면
    Spring Security가 제공하는 SecurityAutoConfiguration 동작을 안함
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //요청에 대한 인증 처리
                .antMatchers("/index.html","/secu").permitAll() // 해당 요청만 인증 없이 허용
                .anyRequest().authenticated() // 그외 요청은 모두 인증 필요
                .and()
                .formLogin() // form 로그인을 사용 : (my(인증정보없는경우)는 왜 form 로그인에 걸리지? accept header에 html에 있는 경우 여기에 걸림 그외는 아래의 httpBasic)
                .and()
                .httpBasic(); // httpBasicBasicAuthentication 을 사용
    }

    /*
    spring security에서 passwordEncoder는 강요임.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
