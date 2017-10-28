package demo.lin1000.java8.labmda.templatemethod;

@FunctionalInterface
public interface Criteria{
    public void check() throws ApplicationDenied;
}
