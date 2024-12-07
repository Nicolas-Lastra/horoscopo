package repository;

import configuration.DatabaseConnection;
import modelo.Usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final DatabaseConnection databaseConnection;

    public UsuarioRepositoryImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public boolean save(Usuarios usuario) {
        String query = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password, animal) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, usuario.getEmail());
            stmt.setTimestamp(4, Timestamp.valueOf(usuario.getFechaNacimiento()));
            stmt.setString(5, usuario.getPassword());
            stmt.setInt(6, usuario.getAnimal());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Usuarios> findByUsername(String username) {
        String query = "SELECT id, nombre, username, email, fecha_nacimiento, password, animal FROM usuarios WHERE username = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_nacimiento").toLocalDateTime(),
                        rs.getString("password"),
                        rs.getInt("animal")
                ));
            }

            return Optional.empty();

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Usuarios> findByEmail(String email) {
        String query = "SELECT id, nombre, username, email, fecha_nacimiento, password, animal FROM usuarios WHERE email = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_nacimiento").toLocalDateTime(),
                        rs.getString("password"),
                        rs.getInt("animal")
                ));
            }

            return Optional.empty();

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Usuarios> findAll() {
        String query = "SELECT id, nombre, username, email, fecha_nacimiento, password, animal FROM usuarios";
        List<Usuarios> usuarios = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_nacimiento").toLocalDateTime(),
                        rs.getString("password"),
                        rs.getInt("animal")
                ));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<Usuarios> findById(int id) {
        String query = "SELECT id, nombre, username, email, fecha_nacimiento, password, animal FROM usuarios WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_nacimiento").toLocalDateTime(),
                        rs.getString("password"),
                        rs.getInt("animal")
                ));
            }

            return Optional.empty();

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean update(Usuarios usuario) {
        String query = "UPDATE usuarios SET nombre = ?, username = ?, email = ?, fecha_nacimiento = ?, password = ? WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Seteamos los campos del usuario
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, usuario.getEmail());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(usuario.getFechaNacimiento()));
            stmt.setString(5, usuario.getPassword());
            stmt.setInt(6, usuario.getId()); // Condición para actualizar por ID

            return stmt.executeUpdate() > 0; // Retorna true si se actualizó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0; // Retorna true si se eliminó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
