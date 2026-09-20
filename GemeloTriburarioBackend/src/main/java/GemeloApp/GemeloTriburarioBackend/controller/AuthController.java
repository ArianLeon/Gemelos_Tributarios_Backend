package GemeloApp.GemeloTriburarioBackend.controller;

import GemeloApp.GemeloTriburarioBackend.model.Usuario;
import GemeloApp.GemeloTriburarioBackend.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticacion")
public class AuthController {

    private final UsuarioService usuarioService;

    public record LoginRequest(@NotBlank String correo, @NotBlank String contrasenaHash) {
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest datos) {
        Usuario usuario = usuarioService.login(datos.correo(), datos.contrasenaHash());
        return ResponseEntity.ok(usuario);
    }
}