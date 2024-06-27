import constructor.Race;
import constructor.CarConstructor;

public class Main {

    public static void main(String[] args) {
        CarConstructor constructor = new CarConstructor();
        Race race = new Race(constructor);
        while (constructor.carsSize() < 3) {
            race.prepare();
        }
        race.getFasterCar();
    }

}
