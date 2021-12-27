package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.dto.RegRequest;
import com.geekbrains.spring.web.entities.Role;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.exceptions.AlreadyExistUserException;
import com.geekbrains.spring.web.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final RoleService roleService;

    @Transactional
    public void isUserExist(RegRequest regRequest){
        Optional<User> optUser = userService.findByUsername(regRequest.getUsername());
        if (optUser.isPresent()){ throw new AlreadyExistUserException("Пользователь с таким именем существует"); }
        else {
            User user = new User();
            user.setPassword(regRequest.getPassword()); // здесь что-то должно хэшировать пароль
            user.setUsername(regRequest.getUsername());
            user.setEmail(regRequest.getEmail()); //сюда не додумался добавить проверку на уникальность е-мейла
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            Role role = new Role(roleService.getByName(1L));
            user.setRoles(new ArrayList<>(List.of(role)));
            userService.save(user);
        }

//        User user = new User();
//        user.setPassword(regRequest.getPassword());
//        user.setUsername(regRequest.getUsername());
//        user.setEmail(regRequest.getEmail());

    }
}
