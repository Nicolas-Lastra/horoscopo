package repository;

import configuration.DatabaseConnection;
import modelo.Horoscopo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoroscopoRepositoryImpl implements HoroscopoRepository {

    private final DatabaseConnection databaseConnection;

    public HoroscopoRepositoryImpl() {this.databaseConnection = DatabaseConnection.getInstance();}

    @Override
    public Optional<Horoscopo> encontrarAnimalPorId(int id) {
        String query = "SELECT animal, fecha_inicio, fecha_fin FROM horoscopo WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Horoscopo(
                        rs.getString("animal"),
                        rs.getTimestamp("fecha_inicio").toLocalDateTime(),
                        rs.getTimestamp("fecha_fin").toLocalDateTime()
                ));
            }

            return Optional.empty();

        } catch (
                SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Horoscopo> findAllAnimals() {
        String query = "SELECT id, animal, fecha_inicio, fecha_fin FROM horoscopo";
        List<Horoscopo> listaHoroscopo = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listaHoroscopo.add(new Horoscopo(
                        rs.getInt("id"),
                        rs.getString("animal"),
                        rs.getTimestamp("fecha_inicio").toLocalDateTime(),
                        rs.getTimestamp("fecha_fin").toLocalDateTime()
                ));
            }
            return listaHoroscopo;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public int findAnimalByDate(LocalDateTime fechaNacimiento) {
        String query = "SELECT id FROM horoscopo WHERE ? BETWEEN fecha_inicio AND fecha_fin";

        System.out.println("Fecha de nacimiento recibida: " + fechaNacimiento);

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            if(fechaNacimiento == null) {
                throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
            }

            stmt.setTimestamp(1, Timestamp.valueOf(fechaNacimiento));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Error: No se encontró un rango de fechas para el horóscopo");
        throw new IllegalStateException("No se encontró un rango de fechas válido para el horóscopo");
    }
}
