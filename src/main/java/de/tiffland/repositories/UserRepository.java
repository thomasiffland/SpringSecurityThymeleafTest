package de.tiffland.repositories;

import de.tiffland.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Thomas on 01.02.16.
 */
public interface UserRepository extends MongoRepository<User,String> {
    public User findOneByUsername(String username);
}
