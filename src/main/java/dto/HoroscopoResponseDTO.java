package dto;

import java.time.LocalDateTime;

public class HoroscopoResponseDTO {
    private String animal;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    // Constructores

    public HoroscopoResponseDTO() {
    }

    public HoroscopoResponseDTO(String animal, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.animal = animal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getter & Setter

    public String getAnimal() {
        return animal;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    // toString

    @Override
    public String toString() {
        return "HoroscopoResponseDTO{" +
                "animal='" + animal + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
