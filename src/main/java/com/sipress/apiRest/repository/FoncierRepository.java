package com.sipress.apiRest.repository;

import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Frais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoncierRepository extends JpaRepository<Foncier, Long> {
//    List<Frais> findByHonoraireContainingOrFraisEnregistrementContaining(String text, String textAgain);
//
//    @Query("SELECT f FROM Frais f WHERE " +
//            "f.honoraire LIKE CONCAT('%',:query, '%')" +
//            "Or f.fraisGeneraux LIKE CONCAT('%', :query, '%')"+
//            "Or f.honoraire LIKE CONCAT('%', :query, '%')")
//    List<Frais> searchFrais(String query);

    Foncier findFoncierByProjectId(Long id);

}
