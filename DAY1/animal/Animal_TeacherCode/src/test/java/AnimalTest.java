import java.util.Arrays;
import java.util.List;

public class AnimalTest {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(new Bat(), new Hawk(), new Ostrich(), new Penguin(), new Tiger(), new Whale());

        System.out.println("Flyable birds : " + Arrays.toString(animals.stream().filter(x->Animal.isFlyable(x)).toArray()));
        System.out.println("Swimable birds : " + Arrays.toString(animals.stream().filter(x->Animal.isSwimable(x)).toArray()));
    }
}
