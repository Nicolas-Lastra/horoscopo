package modelo;

import java.time.LocalDateTime;

public class Horoscopo {
    private int id;
    private String animal;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    // constructores
    public Horoscopo() {
    }

    public Horoscopo(int id, String animal) {
        this.id = id;
        this.animal = animal;
    }

    public Horoscopo(int id, String animal, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.animal = animal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    // toString

    @Override
    public String toString() {
        return "Horoscopo{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
