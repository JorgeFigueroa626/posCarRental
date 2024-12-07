package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.dto.BookACarDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.service.IBookACarService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookACarController {

    @Autowired
    private IBookACarService bookACarService;

    @PostMapping("/car/bookACar")
    public ResponseEntity<?> bookACar(@RequestBody BookACarDto bookACarDto){
        boolean success = bookACarService.bookACar(bookACarDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/car/bookACar/{userId}")
    public ResponseEntity<List<BookACarDto>> getBookingsByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(bookACarService.getBookingsByUserId(userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/car/bookingsCar")
    public ResponseEntity<List<BookACarDto>> findAllBookings(){
        return ResponseEntity.ok(bookACarService.findAllBookings());
    }

    @GetMapping("/car/bookingsCar/{bookingId}/{status}")
    public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status){
        boolean success = bookACarService.changeBookingStatus(bookingId, status);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
