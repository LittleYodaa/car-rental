package pl.patrykkawula.carrental.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkawula.carrental.rent.model.RentEntity;

public interface RentRepository extends JpaRepository<RentEntity, Long> {

}
