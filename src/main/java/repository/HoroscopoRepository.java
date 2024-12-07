package repository;

import modelo.Horoscopo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HoroscopoRepository {
    Optional<Horoscopo> encontrarAnimalPorId(int id);
    List<Horoscopo> findAllAnimals();

    int findAnimalByDate(LocalDateTime fechaNacimiento);
}
