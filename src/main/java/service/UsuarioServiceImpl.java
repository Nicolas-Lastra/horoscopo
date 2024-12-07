package service;

import dto.UsuarioCreateDTO;
import dto.UsuarioResponseDTO;
import mapper.UsuarioMapper;
import repository.HoroscopoRepository;
import repository.HoroscopoRepositoryImpl;
import repository.UsuarioRepository;
import repository.UsuarioRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private HoroscopoRepository horoscopoRepository;
    public UsuarioServiceImpl() {
        this.usuarioRepository = new UsuarioRepositoryImpl();
        this.horoscopoRepository = new HoroscopoRepositoryImpl();
    }



    private boolean validarDatosRegistro(UsuarioCreateDTO usuario, String confirmPassword) {

        // Validacion de todos los campos

        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty() ) {
            return false;
        }

        if (usuario.getUsername() == null || usuario.getUsername().trim().isEmpty() ) {
            return false;
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty() ) {
            return false;
        }

        LocalDateTime fechaMinima = LocalDateTime.MIN;
        if (usuario.getFechaNacimiento() == null || usuario.getFechaNacimiento().equals(fechaMinima)) {
            return false;
        }

        if (!usuario.getPassword().equals(confirmPassword)) {
            return false;
        }

        return true;

    }

    @Override
    public boolean registrarUsuario(UsuarioCreateDTO usuario, String confirmPassword) {

        if (!validarDatosRegistro(usuario, confirmPassword)) {
            System.out.println("Error: Datos de registro inválidos.");
            return false;
        }

        // Setear animal en usuario

        try {
            calcularAnimalporFecha(usuario);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

        // Verifica si el nombre de usuario ya existe
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            System.out.println("Error: Nombre de usuario ya existe.");
            return false;
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            System.out.println("Error: Email ya registrado.");
            return false;
        }

        return usuarioRepository.save(UsuarioMapper.toEntity(usuario));
    }

    @Override
    public boolean autenticarUsuario(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return usuarioRepository
                .findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public Optional<UsuarioResponseDTO> findUsuarioByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return Optional.empty();
        }

        return usuarioRepository
                .findByUsername(username)
                .map(UsuarioMapper::toDto);
    }

    @Override
    public List<UsuarioResponseDTO> findAllUsuarios() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    private void calcularAnimalporFecha(UsuarioCreateDTO usuario) {
        LocalDateTime fechaAnimal = usuario.getFechaNacimiento();

        if (fechaAnimal == null) {
            throw new IllegalArgumentException("la fecha de nacimiento no puede ser nula en calcularAnimalporFecha");
        }

        try {
            int animal = horoscopoRepository.findAnimalByDate(fechaAnimal);
            usuario.setAnimal(animal);
        } catch (IllegalStateException e) {
            System.out.println("Error al asignar animal: " + e.getMessage());
            throw new IllegalArgumentException("No se pudo asignar un animal al usuario.");
        }

    }
}
