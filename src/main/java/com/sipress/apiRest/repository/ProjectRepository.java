package com.sipress.apiRest.repository;

import com.sipress.apiRest.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByNomContainingOrVilleContaining(String text, String textAgain);

    @Query("SELECT p FROM Project p WHERE " +
            "p.nom LIKE CONCAT('%',:query, '%')" +
            "Or p.description LIKE CONCAT('%', :query, '%')"+
            "Or p.promoteur LIKE CONCAT('%', :query, '%')")
    List<Project> searchProjects(String query);

}
