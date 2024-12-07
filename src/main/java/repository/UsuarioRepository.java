package repository;

import modelo.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    boolean save(Usuarios usuario);
    Optional<Usuarios> findByUsername(String username);
    Optional<Usuarios> findByEmail(String email);
    List<Usuarios> findAll();
    Optional<Usuarios> findById(int id);

    boolean update(Usuarios usuario);
    boolean deleteById(int id);
}
