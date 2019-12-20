package org.launchcode.Lokker.R.models.data;

import org.launchcode.Lokker.R.models.Gym;
        import org.launchcode.Lokker.R.models.Lokkers;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;

@Repository
@Transactional
public interface GymDao extends CrudRepository<Gym, Integer> {
    //Gym findbyId(int locId);
    // Gym findByGym (String name);
}