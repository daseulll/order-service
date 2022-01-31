package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    // private 으로 생성자를 선언하면 외부에서 생성할 수 없다.
    // singleton 패턴 적용
    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instance;
    }
}
