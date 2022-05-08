// package com.example.webshop.service;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;

// import com.example.webshop.repository.AccountRepo;
// import com.example.webshop.repository.RolesRepo;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserService implements UserDetailsService {
//     @PersistenceContext
//     private EntityManager em;

//     @Autowired
//     AccountRepo userRepository;
    
//     @Autowired
//     RolesRepo roleRepository;
//     @Autowired
//     BCryptPasswordEncoder bCryptPasswordEncoder;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
//         return null;
//     }
// }
