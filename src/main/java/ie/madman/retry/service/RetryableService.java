package ie.madman.retry.service;

import org.springframework.retry.annotation.Retryable;

public interface RetryableService {

    @Retryable(include = RuntimeException.class)
    void service();

    int getCount();
}
