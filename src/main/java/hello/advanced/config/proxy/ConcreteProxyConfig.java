package hello.advanced.config.proxy;

import hello.advanced.app.v0.OrderControllerV0;
import hello.advanced.app.v0.OrderRepositoryV0;
import hello.advanced.app.v0.OrderServiceV0;
import hello.advanced.config.proxy.concreteproxy.OrderControllerConcreteProxy;
import hello.advanced.config.proxy.concreteproxy.OrderRepositoryConcreteProxy;
import hello.advanced.config.proxy.concreteproxy.OrderServiceConcreteProxy;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV0 orderController(LogTrace logTrace) {
        OrderControllerV0 orderControllerV0 = new OrderControllerV0(orderService(logTrace));
        return new OrderControllerConcreteProxy(orderControllerV0, logTrace);
    }

    @Bean
    public OrderServiceV0 orderService(LogTrace logTrace) {
        OrderServiceV0 orderServiceV0 = new OrderServiceV0(orderRepository(logTrace));
        return new OrderServiceConcreteProxy(orderServiceV0, logTrace);
    }

    @Bean
    public OrderRepositoryV0 orderRepository(LogTrace logTrace) {
        OrderRepositoryV0 orderRepositoryV0 = new OrderRepositoryV0();
        return new OrderRepositoryConcreteProxy(orderRepositoryV0, logTrace);
    }

}
