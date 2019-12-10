package org.launchcode.Lokker.R.models.data;
import org.launchcode.Lokker.R.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
//dao is data access object, interfaces that allow us to access classes and interact with the database
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
     User findByUsername(String username);
}