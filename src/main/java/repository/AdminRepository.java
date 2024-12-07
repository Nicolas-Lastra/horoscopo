package repository;

import dto.AdminResponseDTO;

import java.util.Optional;

public interface AdminRepository {
    Optional<AdminResponseDTO> findByUsername(String username);
}
