package bo.edu.ucb.todo.api;

import bo.edu.ucb.todo.bl.AuthBl;
import bo.edu.ucb.todo.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
class AuthApi {

    @PostMapping("/api/v1/auth/login")
    public ResponseDto<TokenDto> login(@RequestBody LoginDto login) {
        ResponseDto<TokenDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        TokenDto tokenDto = authBl.login(login);
        if (tokenDto == null) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid credentials");
        } else {
            response.setCode("0000");
            response.setResponse(tokenDto);
        }
        return response;
    }
}
