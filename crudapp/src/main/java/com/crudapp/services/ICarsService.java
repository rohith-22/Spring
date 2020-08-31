package com.crudapp.services;

import com.crudapp.domain.Car;

import java.util.List;

public interface ICarsService {

    List<Car> listAllCars();

    Car getCarById(int id);

    Car updateCarsList(Car car);

    void deleteCar(Integer id);
}
