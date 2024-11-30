package com.ProyManager.Services;

import com.ProyManager.Repository.PaymentsRepository;
import com.ProyManager.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PaymentsRepository paymentsRepository;

    // Crear o actualizar un pago
    public Payments saveOrUpdatePayment(Payments payment) {
        return paymentsRepository.save(payment);
    }

    // Obtener todos los pagos
    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    // Obtener un pago por ID
    public Optional<Payments> getPaymentById(int paymentId) {
        return paymentsRepository.findById(paymentId);
    }

    // Eliminar un pago por ID
    public void deletePaymentById(int paymentId) {
        paymentsRepository.deleteById(paymentId);
    }
}
