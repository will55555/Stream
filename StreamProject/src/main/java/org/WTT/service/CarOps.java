package org.WTT.service;

import org.WTT.data.DataRetriever;
import org.WTT.entity.Car;

import java.util.List;

public class CarOps {
    List<Car> cars = DataRetriever.getCars();

    public Integer getCarCount() {
        return cars.size();
    }
}
