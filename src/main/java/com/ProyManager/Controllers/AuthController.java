package com.ProyManager.Controllers;

import com.ProyManager.Config.JwtUtils;
import com.ProyManager.Repository.ClientRepository;
import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.Repository.RoleRepository;
import com.ProyManager.Services.AuthService;
import com.ProyManager.Services.ServicesImpl.ClientDetailsImpl;
import com.ProyManager.dto.JwtResponseDTO;
import com.ProyManager.dto.LoginRequestDTO;
import com.ProyManager.dto.MessageResponse;
import com.ProyManager.dto.RegisterRequestDTO;
import com.ProyManager.model.Client;
import com.ProyManager.model.Projects;
import com.ProyManager.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AuthService authService;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ProjectsRepository projectsRepository;


    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        ClientDetailsImpl clientDetails = (ClientDetailsImpl) authentication.getPrincipal();
        List<String> roles = clientDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponseDTO(
                jwt,
                clientDetails.getId(),
                clientDetails.getUsername(),
                roles));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@RequestBody RegisterRequestDTO registerRequest) {
        try {
            Client client = authService.registerClient(
                    registerRequest.getName(),
                    registerRequest.getEmail(),
                    registerRequest.getPassword(),
                    registerRequest.getRole(),
                    registerRequest.getProjectIds()
            );

            return ResponseEntity.ok(new MessageResponse("Client registered successfully!"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse(e.getMessage()));
        }
    }
}

