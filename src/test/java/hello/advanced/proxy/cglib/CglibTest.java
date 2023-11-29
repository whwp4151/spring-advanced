package hello.advanced.proxy.cglib;

import hello.advanced.proxy.cglib.code.TimeMethodInterceptor;
import hello.advanced.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    public void cglib() {
        ConcreteService concreteService = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(concreteService));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        proxy.call();
    }

}
