package com.ProyManager.Services;

import com.ProyManager.Repository.ClientRepository;
import com.ProyManager.Services.ServicesImpl.ClientDetailsImpl;
import com.ProyManager.model.Client;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró cliente con el email: " + email));

        return ClientDetailsImpl.build(client);
    }
}
