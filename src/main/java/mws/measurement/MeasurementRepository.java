package mws.measurement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MeasurementRepository extends MongoRepository<Measurement, String> {

}
