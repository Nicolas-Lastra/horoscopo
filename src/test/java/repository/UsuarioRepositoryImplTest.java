package repository;

import modelo.Usuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositoryImplTest {

    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository = new UsuarioRepositoryImpl();
        // Opcional: Puedes limpiar la tabla `usuarios` aquí si es necesario.
    }

    @Test
    void findAll_ShouldReturnAllUsuarios() {
        // Preparar datos de prueba
        Usuarios usuario1 = new Usuarios(1, "Juan Pérez", "juanp", "juan@example.com",
                LocalDateTime.of(1990, 5, 20, 10, 0), "password123", 1);
        Usuarios usuario2 = new Usuarios(2, "Ana López", "anal", "ana@example.com",
                LocalDateTime.of(1985, 3, 15, 8, 30), "password456", 2);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        // Ejecutar el método
        List<Usuarios> usuarios = usuarioRepository.findAll();

        // Verificar resultados
        assertNotNull(usuarios, "La lista de usuarios no debería ser nula");
        assertEquals(12, usuarios.size(), "El número de usuarios debería ser 2");

        Usuarios retrievedUsuario1 = usuarios.get(0);
        Usuarios retrievedUsuario2 = usuarios.get(1);

        assertEquals("Juan Pérez", retrievedUsuario1.getNombre());
        assertEquals("María López", retrievedUsuario2.getNombre());
    }
}
