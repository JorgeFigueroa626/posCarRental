package posCarRental.service;

import org.springframework.web.multipart.MultipartFile;
import posCarRental.dto.RolRequestDto;
import posCarRental.entity.Rol;

import java.io.IOException;
import java.util.List;

public interface IRolService {

    //String uploadImageFirebase(MultipartFile file) throws IOException;

    Rol saveRol(RolRequestDto rol) throws IOException;

    Rol getByRoleId(Long id);

    List<Rol> findAllRoles();

    Rol updateRole(Long id, Rol rol);

    void deleteByRolId(Long id);
}
