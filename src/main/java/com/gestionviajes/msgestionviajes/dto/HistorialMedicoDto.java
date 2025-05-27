package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO utilizado para registrar o actualizar el historial médico de una mascota.
 * Contiene información relevante como diagnóstico, tratamiento, medicación y notas.
 */
@Setter
@Getter
public class HistorialMedicoDto {

    /**
     * Diagnóstico realizado al paciente. Campo obligatorio.
     */
    @NotBlank(message = "Diagnóstico es obligatorio")
    private String diagnóstico;

    /**
     * Tratamiento prescrito. Campo obligatorio.
     */
    @NotBlank(message = "Tratamiento es obligatorio")
    private String tratamiento;

    /**
     * Medicación asociada al tratamiento (opcional).
     */
    private String medicación;

    /**
     * Notas adicionales sobre el historial médico (opcional).
     */
    private String notas;

    // Métodos getters y setters explícitos (aunque ya están generados por Lombok)

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getMedicación() {
        return medicación;
    }

    public void setMedicación(String medicación) {
        this.medicación = medicación;
    }

    public @NotBlank(message = "Tratamiento es obligatorio") String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(@NotBlank(message = "Tratamiento es obligatorio") String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public @NotBlank(message = "Diagnóstico es obligatorio") String getDiagnóstico() {
        return diagnóstico;
    }

    public void setDiagnóstico(@NotBlank(message = "Diagnóstico es obligatorio") String diagnóstico) {
        this.diagnóstico = diagnóstico;
    }
}
