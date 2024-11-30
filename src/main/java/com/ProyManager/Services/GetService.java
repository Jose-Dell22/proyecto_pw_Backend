package com.ProyManager.Services;
import com.ProyManager.Repository.InvoicesRepository;
import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.Repository.SuppliersRepository;
import com.ProyManager.Repository.UsersRepository;
import com.ProyManager.model.Invoices;
import com.ProyManager.model.Projects;
import com.ProyManager.model.Suppliers;
import com.ProyManager.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetService {
    @Autowired
    private ProjectsRepository ProjectRepository;

    @Autowired
    private SuppliersRepository supplierRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private InvoicesRepository invoiceRepository;

    public List<Projects> getAllProjects() {
        return ProjectRepository.findAll();
    }

    public List<Suppliers> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Invoices> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Método para obtener todo junto en un solo objeto (si es necesario)
    public List<Object> getAllEntities() {
        return List.of(getAllProjects(), getAllSuppliers(), getAllUsers(), getAllInvoices());
    }
}
