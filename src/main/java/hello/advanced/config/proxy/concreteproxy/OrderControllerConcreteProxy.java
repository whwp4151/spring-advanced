package hello.advanced.config.proxy.concreteproxy;

import hello.advanced.app.v0.OrderControllerV0;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.RequestParam;

public class OrderControllerConcreteProxy extends OrderControllerV0 {

    private final OrderControllerV0 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV0 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(@RequestParam("itemId") String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");

            target.request(itemId);

            logTrace.end(status);
            return "ok";
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
