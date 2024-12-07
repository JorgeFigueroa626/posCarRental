package posCarRental.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import posCarRental.dto.CarDto;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String brand;

    private String color;

    private String name;

    //private String type;

    //private String transmission;

    @Column(length = 1000)
    private String description;

    private Long price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp year;

    @Column(columnDefinition = "longblob")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "fuel_id", referencedColumnName = "id")
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "transmission_id", referencedColumnName = "id")
    private Transmission transmission;

    //crear su el mapeo de CAR para crear el service de Lista
    public CarDto getCarDto(){
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        //carDto.setBrand(brand);
        carDto.setColor(color);
        //carDto.setType(type);
        carDto.setPrice(price);
        carDto.setYear(year);
        carDto.setDescription(description);
        //carDto.setTransmission(transmission);
        carDto.setReturnedImage(image);
        carDto.setBrandId(brand.getId());
        carDto.setFuelId(fuel.getId());
        carDto.setTransmissionId(transmission.getId());
        return carDto;
    }
}