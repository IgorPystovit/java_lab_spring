package lambdasandstreams.model.commandpattern;

@FunctionalInterface
public interface Command {
    String execute(String str);
}
