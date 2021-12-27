package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Role;
import com.geekbrains.spring.web.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;


    public Role getByName(Long id) {
        return roleRepository.getById(id);
    }
}
