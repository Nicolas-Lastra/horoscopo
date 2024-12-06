package mapper;

import dto.HoroscopoResponseDTO;
import modelo.Horoscopo;

public class HoroscopoMapper {

    public static HoroscopoResponseDTO toDto(Horoscopo horoscopo) {
        return new HoroscopoResponseDTO(
                horoscopo.getAnimal(),
                horoscopo.getFechaInicio(),
                horoscopo.getFechaFin()
        );
    }
}
