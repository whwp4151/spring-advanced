package hello.advanced.proxy.jdkdynamic;

import hello.advanced.proxy.jdkdynamic.code.AImpl;
import hello.advanced.proxy.jdkdynamic.code.AInterface;
import hello.advanced.proxy.jdkdynamic.code.BImpl;
import hello.advanced.proxy.jdkdynamic.code.BInterface;
import hello.advanced.proxy.jdkdynamic.code.TimeInvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    public void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.call();
    }

    @Test
    public void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.call();
    }

}
