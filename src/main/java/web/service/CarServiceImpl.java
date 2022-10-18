package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {


    @Override
    public List<Car> show(int amount) {
        ArrayList<Car> carList = new ArrayList<>();

        carList.add(new Car(1, "v4", "black"));
        carList.add(new Car(2, "v5", "white"));
        carList.add(new Car(3, "v6", "yellow"));
        carList.add(new Car(4, "v7", "blue"));
        carList.add(new Car(5, "v8", "red"));

        if (amount <= 5) {
            return carList.subList(0, amount);
        } else {
            return carList;
        }

    }
}


