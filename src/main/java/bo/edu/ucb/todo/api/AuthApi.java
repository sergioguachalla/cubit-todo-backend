package bo.edu.ucb.todo.api;

import bo.edu.ucb.todo.bl.AuthBl;
import bo.edu.ucb.todo.dto.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*")
class AuthApi {

    @PostMapping("/api/v1/auth/login")
    public ResponseEntity<ResponseDto<TokenDto>> login(@RequestBody LoginDto login) {
        ResponseDto<TokenDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        TokenDto tokenDto = authBl.login(login);
        int httpStatus = 200;
        if (tokenDto == null) {
            System.out.print(tokenDto);
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid credentials");
            httpStatus=401;
        } else {
            response.setCode("0000");
            response.setResponse(tokenDto);
            response.setErrorMessage("");

        }
        return new ResponseEntity<ResponseDto<TokenDto>>(response, null, httpStatus);
}
    
    
}
