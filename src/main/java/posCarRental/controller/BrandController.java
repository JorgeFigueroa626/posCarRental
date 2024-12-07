package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.entity.Brand;
import posCarRental.service.IBrandService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping("/brand")
    public ResponseEntity<?> create(@RequestBody Brand brand){
        try {
            return ResponseEntity.ok(brandService.createBrand(brand));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/brand")
    public ResponseEntity<?> findAllBrands(){
        try {
            return ResponseEntity.ok(brandService.findAllBrands());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<?> getByBrandId(@PathVariable Long brandId){
        try {
            return ResponseEntity.ok(brandService.getByBrandId(brandId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
