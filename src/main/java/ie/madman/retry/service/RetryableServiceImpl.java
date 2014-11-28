package ie.madman.retry.service;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryableServiceImpl implements RetryableService {

    private int count = 0;

    @Retryable(include = RuntimeException.class)
    @Override
    public void service() {

        if (count++ < 2) {
            throw new RuntimeException("Planned");
        }
    }

    @Override
    public int getCount() {
        return count;
    }

}
