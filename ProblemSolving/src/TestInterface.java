
//@FunctionalInterface
public interface TestInterface {
    public void test();

    default void printSomething(){
        System.out.println("hello");
    }
    static void printSomething2(){
        System.out.println("hello");
    }
    static void printSomething3(){
        System.out.println("hello");
    }
}
