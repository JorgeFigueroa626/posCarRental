package posCarRental.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RolRequestDto {

    private String name;
    private MultipartFile image;
}
