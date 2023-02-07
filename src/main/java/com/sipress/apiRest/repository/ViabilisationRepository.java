package com.sipress.apiRest.repository;

import com.sipress.apiRest.models.User;
import com.sipress.apiRest.models.Viabilisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ViabilisationRepository extends JpaRepository<Viabilisation,Long> {


}
