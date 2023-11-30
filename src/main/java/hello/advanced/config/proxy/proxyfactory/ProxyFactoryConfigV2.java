package hello.advanced.config.proxy.proxyfactory;

import hello.advanced.app.v0.OrderControllerV0;
import hello.advanced.app.v0.OrderRepositoryV0;
import hello.advanced.app.v0.OrderServiceV0;
import hello.advanced.config.proxy.proxyfactory.advice.LogTraceAdvice;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyFactoryConfigV2 {

    @Bean
    public OrderControllerV0 orderControllerV0(LogTrace logTrace) {
        OrderControllerV0 orderController = new OrderControllerV0(orderServiceV0(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(orderController);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (OrderControllerV0) proxyFactory.getProxy();
    }

    @Bean
    public OrderServiceV0 orderServiceV0(LogTrace logTrace) {
        OrderServiceV0 orderService = new OrderServiceV0(orderRepositoryV0(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(orderService);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (OrderServiceV0) proxyFactory.getProxy();
    }

    @Bean
    public OrderRepositoryV0 orderRepositoryV0(LogTrace logTrace) {
        OrderRepositoryV0 orderRepository = new OrderRepositoryV0();

        ProxyFactory proxyFactory = new ProxyFactory(orderRepository);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (OrderRepositoryV0) proxyFactory.getProxy();
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }

}
