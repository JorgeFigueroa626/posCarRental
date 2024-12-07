package posCarRental.service;

import posCarRental.entity.Brand;

import java.util.List;

public interface IBrandService {

    Brand createBrand(Brand brand);

    List<Brand> findAllBrands();

    Brand getByBrandId(Long id);
}
