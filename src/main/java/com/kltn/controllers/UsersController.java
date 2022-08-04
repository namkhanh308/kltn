package com.kltn.controllers;


import com.kltn.dto.request.LoginRequest;
import com.kltn.dto.respone.ResponeToken;
import com.kltn.enttities.UserDetail;
import com.kltn.filters.JwtAuthenticationFilter;
import com.kltn.service.ClientService;
import com.kltn.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
    @Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JWTUtil jwtUntil;

    @Autowired
    JwtAuthenticationFilter filter;

    @Autowired
    ClientService clientService;

	@PostMapping("/api/token")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        UserDetail detail = (UserDetail) authentication.getPrincipal();

        // Trả về jwt cho người dùng.
        String jwt = jwtUntil.generateToken(detail);
        return new ResponseEntity<>(new ResponeToken(jwt,
                                                    detail.getUser().getUserRole().get(0).getRole().getRoleName(),
                                                    String.valueOf(detail.getUser().getId())),
                                                    HttpStatus.OK);
    }

    @GetMapping("/aaa")
    public ResponseEntity<?> test(HttpServletRequest request) {
	    // lấy ra token của user hiện tại
        String jwt = filter.getJwtFromRequest(request);
        // lấy ra user hiện tại từ token
        Integer idUser = jwtUntil.getUserByIdfromJWT(jwt);
        return new ResponseEntity<>(String.valueOf(idUser), HttpStatus.OK);
    }

}
