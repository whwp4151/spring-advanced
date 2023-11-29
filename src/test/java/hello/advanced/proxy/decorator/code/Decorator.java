package hello.advanced.proxy.decorator.code;

public abstract class Decorator {

    private final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public abstract String  operation();

}
