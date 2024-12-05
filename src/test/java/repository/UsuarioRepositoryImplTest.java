package repository;

import dto.UsuarioCreateDTO;
import dto.UsuarioResponseDTO;
import modelo.Usuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.UsuarioService;
import service.UsuarioServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        /*Usuarios usuario1 = new Usuarios(1, "Juan Pérez", "juanp", "juan@example.com",
                LocalDateTime.of(1990, 5, 20, 10, 0), "password123", 1);
        Usuarios usuario2 = new Usuarios(2, "Ana López", "anal", "ana@example.com",
                LocalDateTime.of(1985, 3, 15, 8, 30), "password456", 2);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);*/

        // Ejecutar el metodo
        List<Usuarios> usuarios = usuarioRepository.findAll();

        // Verificar resultados
        assertNotNull(usuarios, "La lista de usuarios no debería ser nula");
        assertEquals(17, usuarios.size(), "El número de usuarios debería ser 16");

        Usuarios retrievedUsuario1 = usuarios.get(0);
        Usuarios retrievedUsuario2 = usuarios.get(1);

        assertEquals("Juan Pérez", retrievedUsuario1.getNombre());
        assertEquals("María López", retrievedUsuario2.getNombre());
    }

    /*Test para findByUsername*/
    @Test
    @DisplayName("Test para findByUsername")
    void findByUsername_ShouldReturnUsuario_WhenUsuarioExists() {
        // Act
        Optional<Usuarios> result = usuarioRepository.findByUsername("juanito");

        // Assert
        assertTrue(result.isPresent(), "El usuario debería existir");
        Usuarios usuario = result.get();
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("juanito", usuario.getUsername());
        assertEquals("juan.perez@example.com", usuario.getEmail());
        assertEquals("securePass123", usuario.getPassword());
        assertEquals(1, usuario.getAnimal());
    }

    @Test
    @DisplayName("Test findByUsername vacio")
    void findByUsername_ShouldReturnEmptyOptional_WhenUsuarioDoesNotExist() {
        // Act
        Optional<Usuarios> result = usuarioRepository.findByUsername("usuario_no_existente");

        // Assert
        assertTrue(result.isEmpty(), "El usuario no debería existir");
    }

    @Test
    @DisplayName("Test findByEmail cuando correo existe")
    void findByEmail_ShouldReturnUsuario_WhenEmailExists() {
        // Act
        Optional<Usuarios> result = usuarioRepository.findByEmail("juan@example.com");

        // Assert
        assertTrue(result.isPresent(), "El usuario debería existir");
        Usuarios usuario = result.get();
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("juanp", usuario.getUsername());
        assertEquals("juan@example.com", usuario.getEmail());
        assertEquals("password123", usuario.getPassword());
        assertEquals(1, usuario.getAnimal());
    }

    @Test
    @DisplayName("Test findByEmail cuando no existe")
    void findByEmail_ShouldReturnEmptyOptional_WhenEmailDoesNotExist() {
        // Act
        Optional<Usuarios> result = usuarioRepository.findByEmail("no_existe@example.com");

        // Assert
        assertTrue(result.isEmpty(), "No debería existir un usuario con ese email");
    }

    @Test
    @DisplayName("Test UsuarioCreateDTO nuevo usuario")
    void registrarUsuario_ShouldRegisterUsuario_WhenDataIsValid() {
        // Arrange
        UsuarioCreateDTO nuevoUsuario = new UsuarioCreateDTO(
                "Didi",
                "did",
                "didi@example.com",
                LocalDateTime.of(1995, 3, 15, 8, 30),
                "password456",
                11
        );

        UsuarioService usuarioService = new UsuarioServiceImpl();

        // Act
        boolean resultado = usuarioService.registrarUsuario(nuevoUsuario, "password456");

        // Assert
        assertTrue(resultado, "El usuario debería registrarse correctamente.");
    }

    @Test
    @DisplayName("Test UsuarioCreateDTO nuevo usuario replicado")
    void registrarUsuario_ShouldFail_WhenPasswordsDoNotMatch() {
        // Arrange
        UsuarioCreateDTO nuevoUsuario = new UsuarioCreateDTO(
                "Carlos Ruiz",
                "carlos",
                "carlos@example.com",
                LocalDateTime.of(1985, 7, 10, 10, 0),
                "password123",
                3
        );

        UsuarioService usuarioService = new UsuarioServiceImpl();
        // Act
        boolean resultado = usuarioService.registrarUsuario(nuevoUsuario, "passwordIncorrecta");

        // Assert
        assertFalse(resultado, "El registro debería fallar si las contraseñas no coinciden.");
    }

    @Test
    @DisplayName("Test autenticar usuario Didi")
    void autenticarUsuario_ShouldAuthenticate_WhenCredentialsAreCorrect() {
        // Act
        UsuarioService usuarioService = new UsuarioServiceImpl();
        boolean resultado = usuarioService.autenticarUsuario("did", "password456");

        // Assert
        assertTrue(resultado, "El usuario debería autenticarse correctamente.");
    }

    @Test
    @DisplayName("Test Autenticar usuario Didi falla")
    void autenticarUsuario_ShouldFail_WhenCredentialsAreIncorrect() {
        // Act
        UsuarioService usuarioService = new UsuarioServiceImpl();
        boolean resultado = usuarioService.autenticarUsuario("did", "contraseñaIncorrecta");

        // Assert
        assertFalse(resultado, "La autenticación debería fallar con credenciales incorrectas.");
    }

}
