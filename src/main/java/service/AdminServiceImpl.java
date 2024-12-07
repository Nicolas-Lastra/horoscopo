package service;

import dto.AdminResponseDTO;
import repository.AdminRepository;
import repository.AdminRepositoryImpl;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl() {
        this.adminRepository = new AdminRepositoryImpl();
    }

    @Override
    public Optional<AdminResponseDTO> autenticarAdmin(String username, String password) {

        Optional<AdminResponseDTO> adminOptional = adminRepository.findByUsername(username);
        if (adminOptional.isPresent()) {
            AdminResponseDTO admin = adminOptional.get();
            if (admin.getPassword().equals(password)) {
                return Optional.of(admin);
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Admin no encontrado para username: " + username);
        }
        return Optional.empty();
    }
}
