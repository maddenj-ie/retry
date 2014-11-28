package ie.madman.retry.service;

public interface RetryableService {
    void service();

    int getCount();
}
