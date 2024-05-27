package it.epicode.esercizio.service;


//import it.epicode.esercizio.DTO.UserLoginDto;
//import it.epicode.esercizio.exception.UnauthorizedException;
//import it.epicode.esercizio.model.User;
//import it.epicode.esercizio.security.JwtTool;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import it.epicode.esercizio.DTO.UserLoginDto;
import it.epicode.esercizio.exception.UnauthorizedException;
import it.epicode.esercizio.model.User;
import it.epicode.esercizio.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto) {

        User user = userService.getUserByEmail(userLoginDto.getEmail());

        if(user.getPassword().equals(userLoginDto.getPassword())){
            return jwtTool.createToken(user);
        }else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }
    }
}
