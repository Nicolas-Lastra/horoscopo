package dto;

public class UsuarioResponseDTO {
    private String username;
    private String email;
    private Integer animal;

    // Constructores

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(String username, String email, Integer animal) {
        this.username = username;
        this.email = email;
        this.animal = animal;
    }
    // Getter & Setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAnimal() {
        return animal;
    }

    public void setAnimal(Integer animal) {
        this.animal = animal;
    }


    // toString

    @Override
    public String toString() {
        return "UsuarioResponseDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", animal=" + animal +
                '}';
    }
}
