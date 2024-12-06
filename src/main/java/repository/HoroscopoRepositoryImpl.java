package repository;

import configuration.DatabaseConnection;
import modelo.Horoscopo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class HoroscopoRepositoryImpl implements HoroscopoRepository {

    private final DatabaseConnection databaseConnection;

    public HoroscopoRepositoryImpl() {this.databaseConnection = DatabaseConnection.getInstance();}

    @Override
    public Optional<Horoscopo> encontrarAnimalPorId(int id) {
        String query = "SELECT animal FROM horoscopo WHERE animal = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Horoscopo(
                        rs.getInt("id"),
                        rs.getString("animal")
                ));
            }

            return Optional.empty();

        } catch (
                SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
