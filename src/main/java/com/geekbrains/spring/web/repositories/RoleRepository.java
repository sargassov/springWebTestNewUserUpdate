package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.entities.Role;
import com.geekbrains.spring.web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
