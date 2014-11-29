package ie.madman.retry.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdkdp")
@ContextConfiguration("classpath:applicationContext-retry.xml")
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
