package br.com.isaccanedo.auth.controller;

import br.com.isaccanedo.auth.dto.RegistrationRequest;
import br.com.isaccanedo.auth.model.Usuario;
import br.com.isaccanedo.auth.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody RegistrationRequest request) {
        Usuario usuarioCriado = usuarioService.registrarUsuario(request);
        return ResponseEntity.ok(usuarioCriado);
    }
}