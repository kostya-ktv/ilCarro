package application.security.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.security.entities.Account;

public interface AccountMongoRepository extends MongoRepository<Account, String>{

}
