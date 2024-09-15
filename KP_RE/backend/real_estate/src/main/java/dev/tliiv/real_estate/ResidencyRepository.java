package dev.tliiv.real_estate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResidencyRepository extends MongoRepository<Residency, ObjectId> {
    List<Residency> findByIdIn(List<ObjectId> ids);
}
