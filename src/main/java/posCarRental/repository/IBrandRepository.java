package posCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posCarRental.entity.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {
}
