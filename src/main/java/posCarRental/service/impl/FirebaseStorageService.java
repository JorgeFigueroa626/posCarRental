package posCarRental.service.impl;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import posCarRental.service.IFirebaseStorageService;

import java.io.IOException;
import java.util.UUID;

@Service
public class FirebaseStorageService implements IFirebaseStorageService {

    @Value("${firebase.storage.file.path.base}")
    private String FIREBASE_STORAGE;

    private static final String BUCKET_NAME = "web-ecommerce-dcdaa.appspot.com";

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        Bucket bucket = StorageClient.getInstance().bucket(BUCKET_NAME);

        // Generar un nombre único para la imagen
        //String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // Subir la imagen al bucket
        Blob blob = bucket.create("image/" + fileName, file.getBytes(), file.getContentType());

        // Obtener la URL de acceso público
        return "https://firebasestorage.googleapis.com/v0/b/" + BUCKET_NAME + "/o/" +
                blob.getName().replace("/", "%2F") + "?alt=media";
    }
}
