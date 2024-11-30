package com.ProyManager.Controllers;

import com.ProyManager.Services.PostService;
import com.ProyManager.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api/payments")
public class PostController {
    @Autowired
    private PostService paymentsService;

    @PostMapping("/Update")
    public ResponseEntity<Payments> saveOrUpdatePayment(@RequestBody Payments payment) {
        Payments savedPayment = paymentsService.saveOrUpdatePayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/payments")
    public List<Payments> getAllPayments() {
        return paymentsService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable int id) {
        Optional<Payments> payment = paymentsService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable int id) {
        paymentsService.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }
}
