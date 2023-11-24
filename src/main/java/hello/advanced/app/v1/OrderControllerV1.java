package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 helloTraceV1;

    @GetMapping("/v1/request")
    public String request(@RequestParam("itemId") String itemId) {
        TraceStatus status = null;
        try {
            status = helloTraceV1.begin("OrderControllerV1.request()");
            orderService.orderItem(itemId);
            helloTraceV1.end(status);
            return "ok";
        } catch (Exception e) {
            helloTraceV1.exception(status, e);
            throw e;
        }
    }

}
