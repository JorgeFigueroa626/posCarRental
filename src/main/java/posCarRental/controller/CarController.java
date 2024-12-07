package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.dto.CarDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.exception.CarNotFoundException;
import posCarRental.service.ICarService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/car")
    public ResponseEntity<?> posCar(@ModelAttribute CarDto requestDto) throws Exception {
        boolean success = carService.posCar(requestDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/car")
    public ResponseEntity<?> findAllCars(){
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<?> getByCarId(@PathVariable Long carId){
        CarDto carDtoId = carService.getByCarId(carId);
        if (carDtoId != null) {
            return ResponseEntity.ok(carDtoId);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/car/{carId}")
    public ResponseEntity<?> updateCar(@PathVariable Long carId, @ModelAttribute CarDto requestDto) throws Exception {
        try {
            boolean upate = carService.updateByCarId(carId, requestDto);
            if (upate) {
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/car/{carId}")
    public  ResponseEntity<Void> delete(@PathVariable Long carId) throws CarNotFoundException {
        boolean success = carService.deleteByCarId(carId);
        if(success) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/car/search")
    public ResponseEntity<?> searchCar(@RequestBody SearchCarDto searchCarDto){
        try {
            return ResponseEntity.ok(carService.searchCar(searchCarDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
