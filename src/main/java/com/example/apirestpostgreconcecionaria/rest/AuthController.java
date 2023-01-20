package com.example.apirestpostgreconcecionaria.rest;


import com.example.apirestpostgreconcecionaria.domain.User;
import com.example.apirestpostgreconcecionaria.repository.UserRepository;
import com.example.apirestpostgreconcecionaria.security.jwt.JwtTokenUtil;
import com.example.apirestpostgreconcecionaria.security.payload.JwtResponse;
import com.example.apirestpostgreconcecionaria.security.payload.MessageResponse;
import com.example.apirestpostgreconcecionaria.security.payload.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authManager,
                          UserRepository userRepository,
                          PasswordEncoder encoder,
                          JwtTokenUtil jwtTokenUtil) {
        this.authManager = authManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse>  login(@RequestBody RegisterRequest loginRequest){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest signUpRequest){
        //Check 1 : username
        if (userRepository.existByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        //check2 : email
        if (userRepository.existByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        //create new user's account

        User user = new User(signUpRequest.getUsername(),signUpRequest.getEmail(),signUpRequest.getPassword());

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered succesfully!"));
    }
}
