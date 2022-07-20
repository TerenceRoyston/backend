import org.junit.Test;

/**
 * @author XuBowen
 * @date 2022/2/9 20:21
 */
public class TestInterface {

    @Test
    public void testEat() {
        Animal animal = (Animal) new Dog();
        animal.eat();



    }
}
