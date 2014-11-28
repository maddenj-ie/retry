package ie.madman.retry.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.madman.retry.config.JdkDynamicProxyRetryConfig;
import ie.madman.retry.service.RetryableService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JdkDynamicProxyRetryConfig.class, loader = AnnotationConfigContextLoader.class)
public class RetryableServiceImplJdkDynamicProxyTest {

    @Autowired
    private RetryableService retryableService;

    @Test
    public void test() {
        assertTrue(AopUtils.isAopProxy(retryableService));
        assertTrue(AopUtils.isJdkDynamicProxy(retryableService));
        assertFalse(AopUtils.isCglibProxy(retryableService));
        retryableService.service();
        assertEquals(3, retryableService.getCount());
    }

}
