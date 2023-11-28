package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    public void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("로직1"));
        template.execute(() -> log.info("로직2"));
    }

}
