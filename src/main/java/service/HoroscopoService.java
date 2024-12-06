package service;

import dto.HoroscopoResponseDTO;

import java.util.Optional;

public interface HoroscopoService {
    Optional<HoroscopoResponseDTO> findHoroscopoById(int id);
}
