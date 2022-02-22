package com.car.zadanie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/cars")
@RestController
public class CarApi {
    private List<Car> carList;

    public CarApi() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L, "opel", "black", "vectra"));
        carList.add(new Car(2L, "seat", "blue", "ibiza"));
        carList.add(new Car(3L, "opel", "black", "corsa"));

    }

    @GetMapping
    public ResponseEntity<List<Car>> getCar() {
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarBy(@PathVariable long id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody Car car) {
boolean add = carList.add(car);
        if (add) {
return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
@PutMapping
public ResponseEntity modCar(@RequestBody Car newCar){
    Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
    if (first.isPresent()) {
        carList.remove(first.get());
        carList.add(newCar);
        return new ResponseEntity<>(HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

        @DeleteMapping("/{id}")
        public ResponseEntity deleteCar(@PathVariable long id) {
            Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
            if (first.isPresent()) {
                carList.remove(first.get());
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }


