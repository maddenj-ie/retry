package ie.madman.retry.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;

@Configuration
@ComponentScan("ie.madman.retry")
@EnableRetry(proxyTargetClass = true)
public class CglibProxyRetryConfig {
    @Bean
    public MethodInterceptor retryInterceptor() {
        return RetryInterceptorBuilder.stateful().maxAttempts(3).build();
    }
}
