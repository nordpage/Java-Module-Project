package constructor;

import java.util.Scanner;

import models.Car;

public class Race {
    private static final int MAX_SPEED = 250;
    private static final int MIN_SPEED = 0;
    private static final int HOURS_IN_DAY = 24;

    private final CarConstructor constructor;
    private final Scanner scanner;

    public Race(CarConstructor constructor) {
        this.constructor = constructor;
        this.scanner = new Scanner(System.in);
    }

    public void prepare() {
        String name = carName();
        int speed = carSpeed();
        constructor.addCar(name, speed);
    }

    private String carName() {
        System.out.println(formatMessage("- Введите название машины №%d"));
        return scanner.next();
    }

    private int carSpeed() {
        while (true) {
            System.out.println(formatMessage("- Введите скорость машины №%d"));
            try {
                int speed = Integer.parseInt(scanner.next());
                if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
                    return speed;
                } else {
                    System.out.println("- Неправильная скорость.");
                }
            } catch (NumberFormatException e) {
                System.out.println("- Пожалуйста, введите целое число.");
            }
        }
    }

    private String formatMessage(String message) {
        return String.format(message, constructor.carsSize() + 1);
    }

    public void getFasterCar() {
        Car fasterCar = constructor.getCars().stream()
                .max((c1, c2) -> Integer.compare(c1.speed * HOURS_IN_DAY, c2.speed * HOURS_IN_DAY))
                .orElse(null);

        if (fasterCar != null) {
            System.out.printf("- Самая быстрая машина: %s%n", fasterCar.name);
        } else {
            System.out.println("- Нет машин в списке.");
        }
    }
}
