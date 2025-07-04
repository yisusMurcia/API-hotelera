package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.dto.UserAuthDto;
import ing.yisus.apihotelera.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth/")
@RequiredArgsConstructor
@Validated
public class AuthControl {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody UserAuthDto userAuthDto) {
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthDto.getUsername(), userAuthDto.getPassword())
            );
            User user = (User) auth.getPrincipal();
            String jwtToken = jwtUtil.generateToken(user.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwtToken);
            response.put("username", user.getUsername());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Credenciales no validas");
        }
    }

    @PostMapping("signup")
    public ResponseEntity<Object> signUp(@RequestBody UserAuthDto userAuthDto) {
        // Implementación del registro de usuario
        // Aquí deberías agregar la lógica para guardar el usuario en la base de datos
        // y retornar una respuesta adecuada.
        return ResponseEntity.ok("Registro exitoso");
    }
}
