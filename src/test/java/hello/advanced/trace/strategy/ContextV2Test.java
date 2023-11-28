package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.ContextV2;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    public void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    @Test
    public void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("로직1"));
        context.execute(() -> log.info("로직2"));
    }

}
