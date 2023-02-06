package com.sipress.apiRest.repository;

import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoncierRepository extends JpaRepository<Foncier, Long> {
    List<Foncier> findByNomContainingOrNomContaining(String text, String textAgain);

    @Query("SELECT f FROM Foncier f WHERE " +
            "f.nom LIKE CONCAT('%',:query, '%')" +
            "Or f.prix LIKE CONCAT('%', :query, '%')"+
            "Or f.surface LIKE CONCAT('%', :query, '%')")
    List<Foncier> searchFonciers(String query);






}
