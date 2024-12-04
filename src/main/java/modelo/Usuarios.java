package modelo;

import java.time.LocalDateTime;

public class Usuarios {
    private int id;
    private String nombre;
    private String username;
    private String email;
    private LocalDateTime fechaNacimiento;
    private String password;
    private int animal;

    // constructores

    public Usuarios() {
    }

    public Usuarios(int id, String nombre, String username, String email, LocalDateTime fecha_nacimiento, String password, int animal) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fecha_nacimiento;
        this.password = password;
        this.animal = animal;
    }

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }


    // toString

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fecha_nacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", animal=" + animal +
                '}';
    }
}
