package service;

import dto.UsuarioCreateDTO;
import dto.UsuarioResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    boolean registrarUsuario(UsuarioCreateDTO usuario, String confirmPassword);
    boolean autenticarUsuario(String username, String password);
    Optional<UsuarioResponseDTO> findUsuarioByUsername(String username);
    List<UsuarioResponseDTO> findAllUsuarios();
}
