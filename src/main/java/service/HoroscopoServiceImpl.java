package service;

import dto.HoroscopoResponseDTO;
import mapper.HoroscopoMapper;
import repository.HoroscopoRepository;
import repository.HoroscopoRepositoryImpl;

import java.util.Optional;

public class HoroscopoServiceImpl implements HoroscopoService {

    private final HoroscopoRepository horoscopoRepository;
    public HoroscopoServiceImpl() {this.horoscopoRepository = new HoroscopoRepositoryImpl();}

    @Override
    public Optional<HoroscopoResponseDTO> findHoroscopoById(int id) {

        if (id < 0) {
            return Optional.empty();
        }

        return horoscopoRepository
                .encontrarAnimalPorId(id)
                .map(HoroscopoMapper::toDto);

    }
}
