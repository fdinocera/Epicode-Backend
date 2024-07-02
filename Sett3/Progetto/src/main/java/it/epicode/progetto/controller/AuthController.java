package it.epicode.progetto.controller;



import it.epicode.progetto.DTO.UserDto;
import it.epicode.progetto.DTO.UserLoginDto;
import it.epicode.progetto.exception.BadRequestException;
import it.epicode.progetto.service.AuthService;
import it.epicode.progetto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public String register(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s + s2));
        }

        return userService.saveUser(userDto);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s + s2));
        }

        return authService.authenticateUserAndCreateToken(userLoginDto);
    }
}
