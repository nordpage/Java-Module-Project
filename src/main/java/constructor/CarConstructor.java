package constructor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import models.Car;

public class CarConstructor {

    private final Set<Car> cars = new HashSet<>();

   public boolean addCar(String name, int speed) {
        Car newCar = new Car(name, speed);
       if (cars.stream().anyMatch(car -> car.name.equals(name))) {
           System.out.println("Автомобиль с именем '" + name + "' уже существует.");
           return false;
       }
       return cars.add(newCar);

   }

   public int carsSize() {
       return cars.size();
   }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }
}
