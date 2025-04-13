package br.com.isaccanedo.auth.service;

import br.com.isaccanedo.auth.dto.RegistrationRequest;
import br.com.isaccanedo.auth.model.Usuario;
import br.com.isaccanedo.auth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(RegistrationRequest request) {
        if (usuarioRepository.existsByCpf(request.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setCpf(request.getCpf());
        usuario.setRg(request.getRg());
        usuario.setMatricula(request.getMatricula());
        usuario.setDiretoria(request.getDiretoria());
        usuario.setSuperintendencia(request.getSuperintendencia());
        usuario.setArea(request.getArea());
        usuario.setCargo(request.getCargo());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword())); // Senha criptografada
        usuario.setObservacao(request.getObservacao());

        return usuarioRepository.save(usuario);
    }
}
