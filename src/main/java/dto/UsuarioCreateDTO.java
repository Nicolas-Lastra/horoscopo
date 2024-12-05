package dto;

import java.time.LocalDateTime;

public class UsuarioCreateDTO {
    private String nombre;
    private String username;
    private String email;
    private LocalDateTime fechaNacimiento;
    private String password;
    private Integer animal;

    // constructores
    public UsuarioCreateDTO() {
    }

    public UsuarioCreateDTO(String nombre, String username, String email, LocalDateTime fechaNacimiento, String password, Integer animal) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.animal = animal;
    }

    // Getter & Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "UsuarioCreateDTO{" +
                "nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", animal=" + animal +
                '}';
    }
}
