package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.entity.Brand;
import posCarRental.entity.Transmission;
import posCarRental.service.IBrandService;
import posCarRental.service.ITransmissionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransmissionController {

    @Autowired
    private ITransmissionService transmissionService;

    @PostMapping("/transmission")
    public ResponseEntity<?> create(@RequestBody Transmission transmission){
        try {
            return ResponseEntity.ok(transmissionService.createTransmission(transmission));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/transmission")
    public ResponseEntity<?> findAllTransmissions(){
        try {
            return ResponseEntity.ok(transmissionService.findAllTransmissions());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/transmission/{transmissionId}")
    public ResponseEntity<?> getByTransmissionId(@PathVariable Long transmissionId){
        try {
            return ResponseEntity.ok(transmissionService.getByTransmissionId(transmissionId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
