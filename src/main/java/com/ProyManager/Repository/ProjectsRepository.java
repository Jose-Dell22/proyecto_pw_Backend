package com.ProyManager.Repository;

import com.ProyManager.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    List<Projects> findAllByOrderByProjectNameAsc();

    @Query("SELECT p FROM Projects p JOIN p.clients c WHERE c.client_id = :clientId")
    List<Projects> findProjectsByClientId(@Param("clientId") Long clientId);
}