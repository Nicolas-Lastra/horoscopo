package repository;

import configuration.DatabaseConnection;
import dto.AdminResponseDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AdminRepositoryImpl implements AdminRepository {
    private final DatabaseConnection databaseConnection;

    public AdminRepositoryImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public Optional<AdminResponseDTO> findByUsername(String username) {
        String query = "SELECT id, nombre, username, email, password FROM admins WHERE username = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new AdminResponseDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
