package co.com.mercadolibre.quasarfireoperation.repository;

import co.com.mercadolibre.quasarfireoperation.model.entity.Satellite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatelliteRepository extends MongoRepository<Satellite, String> {
    Satellite findByName(String name);
}
