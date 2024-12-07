package service;

import dto.AdminResponseDTO;

import java.util.Optional;

public interface AdminService {
    Optional<AdminResponseDTO> autenticarAdmin(String username, String password);
}
