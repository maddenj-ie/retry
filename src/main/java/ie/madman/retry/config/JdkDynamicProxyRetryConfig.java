package ie.madman.retry.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;

@Configuration
@EnableRetry(proxyTargetClass = false)
@Profile("jdkdp")
public class JdkDynamicProxyRetryConfig {
    @Bean
    public MethodInterceptor retryInterceptor() {
        return RetryInterceptorBuilder.stateful().maxAttempts(3).build();
    }
}
