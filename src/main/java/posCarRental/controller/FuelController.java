package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.entity.Fuel;
import posCarRental.service.IFuelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuelController {

    @Autowired
    private IFuelService fuelService;

    @PostMapping("/fuel")
    public ResponseEntity<?> create(@RequestBody Fuel fuel){
        try {
            return ResponseEntity.ok(fuelService.createFuel(fuel));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/fuel")
    public ResponseEntity<?> findAllFuels(){
        try {
            return ResponseEntity.ok(fuelService.findAllFuel());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/fuel/{fuelId}")
    public ResponseEntity<?> getByFuelId(@PathVariable Long fuelId){
        try {
            return ResponseEntity.ok(fuelService.getByFuelId(fuelId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
