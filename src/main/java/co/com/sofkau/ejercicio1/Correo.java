package co.com.sofkau.ejercicio1;

import lombok.Data;

@Data
public class Correo {

    private String correo;
    private final boolean enviado;

    public Correo(String correo, boolean enviado) {
        this.correo = correo;
        this.enviado = enviado;
    }
}
