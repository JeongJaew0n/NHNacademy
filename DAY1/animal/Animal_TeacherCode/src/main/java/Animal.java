import java.util.Arrays;

public abstract class Animal {
    static boolean isFlyable(Animal animal) {
        return  (animal instanceof Flyable);
    }

    static boolean isSwimable(Animal animal) {
        return  animal.getClass().isAnnotationPresent(Swimable.class);
    }

    public String toString() {
        return  this.getClass().getSimpleName();
    }

}
