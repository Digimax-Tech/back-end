package com.sipress.apiRest.repository;

import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.models.EtudeFoncierImmeuble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtudeFoncierimmeubleRepository extends JpaRepository<EtudeFoncierImmeuble, Long> {
//    List<Foncier> findByNomContainingOrNomContaining(String text, String textAgain);
//
//    @Query("SELECT f FROM Foncier f WHERE " +
//            "f.nom LIKE CONCAT('%',:query, '%')" +
//            "Or f.prix LIKE CONCAT('%', :query, '%')"+
//            "Or f.surface LIKE CONCAT('%', :query, '%')")
//    List<Foncier> searchFonciers(String query);

    EtudeFoncierImmeuble findEtudeFoncierImmeubleByProjectId(Long id);
}
