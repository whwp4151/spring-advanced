package hello.advanced.proxy.jdkdynamic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {

    @Test
    public void reflection0() {
        Hello target = new Hello();

        log.info("공통 로직 시작");
        String result1 = target.callA();
        log.info("result :: {}", result1);

        log.info("공통 로직 시작");
        String result2 = target.callB();
        log.info("result :: {}", result2);
    }

    @Test
    public void reflection1() throws Exception {
        // 클래스나 메서드 정보를 동적으로 변경할 수 있다.
        Class<?> aClass = Class.forName("hello.advanced.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        Method callA = aClass.getMethod("callA");
        Object result1 = callA.invoke(target);
        log.info("result1 :: {}", result1);

        Method callB = aClass.getMethod("callB");
        Object result2 = callB.invoke(target);
        log.info("result2 :: {}", result2);
    }

    @Test
    public void reflection2() throws Exception {
        Class<?> aClass = Class.forName("hello.advanced.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        Method callA = aClass.getMethod("callA");
        dynamicCall(callA, target);

        Method callB = aClass.getMethod("callB");
        dynamicCall(callB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("공통 로직 시작");
        Object result = method.invoke(target);
        log.info("result :: {}", result);
    }
    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

}
