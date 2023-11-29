package hello.advanced.proxy.jdkdynamic.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Time 실행");
        long startTime = System.currentTimeMillis();

        Object result = method.invoke(target);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime :: {}", resultTime);
        return result;
    }

}
