package ie.madman.retry.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.madman.retry.config.CglibProxyRetryConfig;
import ie.madman.retry.service.RetryableService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CglibProxyRetryConfig.class, loader = AnnotationConfigContextLoader.class)
public class RetryableServiceImplCglibTest {

    @Autowired
    private RetryableService retryableService;

    @Test
    public void test() {
        assertTrue(AopUtils.isAopProxy(retryableService));
        assertFalse(AopUtils.isJdkDynamicProxy(retryableService));
        assertTrue(AopUtils.isCglibProxy(retryableService));
        retryableService.service();
        assertEquals(3, retryableService.getCount());
    }

}
