package repository;

import modelo.Horoscopo;

import java.util.Optional;

public interface HoroscopoRepository {
    Optional<Horoscopo> encontrarAnimalPorId(int id);
}
