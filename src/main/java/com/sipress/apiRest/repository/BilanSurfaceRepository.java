package com.sipress.apiRest.repository;

import com.sipress.apiRest.models.BilanSurface;
import com.sipress.apiRest.models.Foncier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BilanSurfaceRepository extends JpaRepository<BilanSurface, Long> {
//    List<Foncier> findByBetContainingOrBetContaining(String text, String textAgain);
//
//    @Query("SELECT b FROM BilanSurface b WHERE " +
//            "b.bet LIKE CONCAT('%',:query, '%')" +
//            "Or f.p LIKE CONCAT('%', :query, '%')"+
//            "Or f.surface LIKE CONCAT('%', :query, '%')")
//    List<BilanSurface> searchBilanSurface(String query);


}
