package com.crudapp.services;

import com.crudapp.domain.Car;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsServiceImpl implements ICarsService {
    private static Map<Integer, Car> cars;

//    public static void main(String[] args) {
//        CarsServiceImpl.loadCars();
//        for(Car each: cars){
//            System.out.println(each.getCarName());
//        }
//    }

    public CarsServiceImpl() {
        loadCars();
    }

    @Override
    public List<Car> listAllCars() {

        return new ArrayList<>(cars.values());
    }

    @Override
    public Car getCarById(int id) {
        return cars.get(id);
    }
    @Override
    public Car updateCarsList(Car newCar) {

        if (newCar != null){
            if(cars.isEmpty()){
                newCar.setId(1);
                cars.put(1, newCar);
            }
            else if (newCar.getId() == null) {
                newCar.setId(getNextKey());
                cars.put(newCar.getId(), newCar);
            }
            else{
                cars.put(newCar.getId(), newCar);
            }
            return newCar;
        } else {
            throw new RuntimeException("car Can't be added");
        }

    }

    @Override
    public void deleteCar(Integer id) {
        cars.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(cars.keySet()) + 1;
    }

    private static void loadCars(){

        cars = new HashMap<>();

        Car car1= new Car();
        car1.setId(1);
        car1.setCarName("Ferrari");
        car1.setCarPrice((double) 2000000);
        car1.setImageUrl("../static/images/ferrari.jpeg");

        cars.put(1,car1);

        Car car2= new Car();
        car2.setId(2);
        car2.setCarName("Lamborghini");
        car2.setCarPrice((double) 1000000);
        car2.setImageUrl("../static/images/Bugati.png");
        cars.put(2,car2);


        Car car3= new Car();
        car3.setId(3);
        car3.setCarName("McLaren");
        car3.setCarPrice((double) 3000000);
        car3.setImageUrl("mclaren.jpeg");
        cars.put(3,car3);


        Car car4= new Car();
        car4.setId(4);
        car4.setCarName("Camero");
        car4.setCarPrice((double) 4000000);
        car4.setImageUrl("../static/images/camero.jpg");
        cars.put(4,car4);

        Car car5= new Car();
        car5.setId(5);
        car5.setCarName("Bugati");
        car5.setCarPrice((double) 5000000);
        car5.setImageUrl("../static/images/Bugati.png");
        cars.put(5,car5);



    }

}
