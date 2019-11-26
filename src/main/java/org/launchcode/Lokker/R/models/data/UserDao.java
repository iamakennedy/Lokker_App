package org.launchcode.Lokker.R.models.data;
import org.launchcode.Lokker.R.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
}