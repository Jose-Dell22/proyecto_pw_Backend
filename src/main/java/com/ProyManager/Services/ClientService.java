package com.ProyManager.Services;

import com.ProyManager.model.Client;
import com.ProyManager.model.Projects;
import com.ProyManager.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

}