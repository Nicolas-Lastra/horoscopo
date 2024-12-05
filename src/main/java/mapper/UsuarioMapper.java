package mapper;

import dto.UsuarioCreateDTO;
import dto.UsuarioResponseDTO;
import modelo.Usuarios;

public class UsuarioMapper {

    public static UsuarioResponseDTO toDto(Usuarios usuario) {
        return new UsuarioResponseDTO(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getAnimal()
        );
    }

    public static Usuarios toEntity(UsuarioCreateDTO dto) {
        return new Usuarios(
                dto.getNombre(),
                dto.getUsername(),
                dto.getEmail(),
                dto.getFechaNacimiento(),
                dto.getPassword(),
                dto.getAnimal()
        );
    }
}
