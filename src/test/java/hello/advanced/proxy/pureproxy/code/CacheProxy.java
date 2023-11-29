package hello.advanced.proxy.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

/*
* 프록시 패턴
* RealSubject 코드를 변경하지 않고 프록시를 도입해서 접근제어
* */
@Slf4j
public class CacheProxy implements Subject {

    private final Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }

}
