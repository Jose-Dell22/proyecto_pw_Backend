package com.ProyManager.Repository;

import com.ProyManager.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments,Integer> {
}
