package hello.advanced.config.proxy.concreteproxy;

import hello.advanced.app.v0.OrderServiceV0;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV0 {

    private final OrderServiceV0 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV0 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");

            target.orderItem(itemId);

            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
