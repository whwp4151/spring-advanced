package hello.advanced.trace.strategy.code;

/*
* 변하지 않는 부분을 Context에 두고 변하는 부분을 Strategy라는 인터페이스를 만들고 해당 인터페이스를 구현
* 상속이 아닌 위임으로 문제를 해결
* */
public interface Strategy {

    void call();

}
