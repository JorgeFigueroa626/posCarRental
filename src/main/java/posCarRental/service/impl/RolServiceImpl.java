package posCarRental.service.impl;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import posCarRental.dto.RolRequestDto;
import posCarRental.entity.Rol;
import posCarRental.exception.CarNotFoundException;
import posCarRental.repository.IRolRepository;
import posCarRental.service.IFirebaseStorageService;
import posCarRental.service.IRolService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IFirebaseStorageService firebaseStorageService;

    @Override
    public Rol saveRol(RolRequestDto requestDto) throws CarNotFoundException, IOException {
        try {
            Rol rol = new Rol();
            rol.setName(requestDto.getName());

            // Subir la imagen a Firebase
            String imageUrl = firebaseStorageService.uploadImage(requestDto.getImage());

            // Guardar la URL en la base de datos
            rol.setImage(imageUrl);
            return rolRepository.save(rol);

        }catch (Exception e){
            throw  new CarNotFoundException(e.getMessage());
        }
    }

    @Override
    public Rol getByRoleId(Long id) {
        return rolRepository.findById(id).get();
    }

    @Override
    public List<Rol> findAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol updateRole(Long id, Rol rol) {
        Rol updateId = rolRepository.findById(id).get();
        updateId.setName(rol.getName());
        return rolRepository.save(updateId);
    }

    @Override
    public void deleteByRolId(Long id) {
        rolRepository.deleteById(id);
    }
}
