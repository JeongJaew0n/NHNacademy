import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_Animal {



    public static void main(String[] args) {

        ArrayList<Animal> flyableAnimals = new ArrayList<>();
        ArrayList<Animal> swimableAnimals = new ArrayList<>();

        // 동물들을 특성별로 분류하고 종류를 출력한다.
        Animal[] animals = {new Bat(), new Hawk(), new Ostrich(), new Penguin(), new Tiger(), new Whale()};

        for(Animal animal : animals) {
            if(animal instanceof Flyable) {
                flyableAnimals.add(animal);
            }
            if(animal instanceof Swimable) {
                swimableAnimals.add(animal);
            }
        }

        System.out.println("FlyableAnimals:" + Arrays.toString(flyableAnimals.toArray()) + "\n" +
                "SwimableAnimals: " + Arrays.toString(swimableAnimals.toArray()));

    }

}

//스트림 사용.