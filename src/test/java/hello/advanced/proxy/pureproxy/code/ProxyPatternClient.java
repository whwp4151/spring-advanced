package hello.advanced.proxy.pureproxy.code;

public class ProxyPatternClient {

    private final Subject subject;

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }

}
