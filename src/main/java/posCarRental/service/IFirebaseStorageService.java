package posCarRental.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface IFirebaseStorageService {

    public String uploadImage(MultipartFile file) throws IOException;
}
