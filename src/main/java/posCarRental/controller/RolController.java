package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.entity.Rol;
import posCarRental.service.IRolService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private IRolService rolService;

    @PostMapping("/rol")
    public ResponseEntity<?> create(@RequestBody Rol rol){
        try {
            return ResponseEntity.ok(rolService.saveRol(rol));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/rol/{rolId}")
    public ResponseEntity<?> getByRolId(@PathVariable Long rolId){
        try {
            return ResponseEntity.ok(rolService.getByRoleId(rolId));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/rol")
    public ResponseEntity<List<?>> findAllRol(){
        try {
            return ResponseEntity.ok(rolService.findAllRoles());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
