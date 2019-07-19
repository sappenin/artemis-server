package org.artemis.db.repositories;

import org.artemis.db.entities.PointerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointerRepository extends CrudRepository<PointerEntity, String> {

}
