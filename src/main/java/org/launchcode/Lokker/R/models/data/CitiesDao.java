package org.launchcode.Lokker.R.models.data;

import org.launchcode.Lokker.R.models.Cities;
import org.launchcode.Lokker.R.models.Lokkers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CitiesDao extends CrudRepository <Cities, Integer> {
    //Cities findById (Integer id);

}
