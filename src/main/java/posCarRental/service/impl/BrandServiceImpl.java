package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posCarRental.entity.Brand;
import posCarRental.repository.IBrandRepository;
import posCarRental.service.IBrandService;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getByBrandId(Long id) {
        return brandRepository.findById(id).orElseThrow();
    }
}
