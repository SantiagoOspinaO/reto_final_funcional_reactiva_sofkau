package co.com.sofkau.ejercicio1;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {

    private static void esRepetido(List<Correo> correos) {
        Flux.fromIterable(correos)
                .distinct(Correo::getCorreo)
                .collect(Collectors.toList())
                .subscribe(correo -> System.out.println("Correos sin repetir -> " + correo.toString()));
    }

    private static void tipoDominio(List<Correo> correos, String dominio) {
        Flux.fromIterable(correos)
                .filter(correo -> correo.getCorreo().contains(dominio.toLowerCase()))
                .count()
                .subscribe(numero -> System.out.println("Cantidad de dominios -> " + dominio + ": " + numero));
    }

    private static void sonCorrectos(List<Correo> correos) {
        Flux.fromIterable(correos)
                .map(correo -> {
                    var expresiones = "^[a-zA-Z0-9_!#$%&'*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+\\.[A-Za-z]{2,4}";
                    return correo.getCorreo().matches(expresiones) ? correo : "No valido";
                }).collect(Collectors.toList())
                .subscribe(correo -> System.out.println("Correos validos -> " + correo.toString()));
    }

    private static void seEnvio(List<Correo> correos) {
        Flux.fromIterable(correos)
                .filter(Correo::isEnviado)
                .collect(Collectors.toList())
                .subscribe(correo -> System.out.println("Correos enviados -> " + correo.toString()));
    }

    public static void main(String[] args) {
        List<Correo> correos = List.of(
                new Correo("santi.23@gmail.com", true),
                new Correo("santi.os@hotmail.es", false),
                new Correo("23@gmailcom", false),
                new Correo("cristian@outlook.com", true),
                new Correo("juan@outlook.com", false),
                new Correo("juanhotmail.com", true),
                new Correo("miguel@outlook.es", true),
                new Correo("jhon.m@hotmail.es", true),
                new Correo("daniel@gmail.edu.co", false),
                new Correo("hola-manrrique@outlook.com", true),
                new Correo("santi@gmail.es", true),
                new Correo("santi@hotmail.es", false),
                new Correo("carlos@gailcom", false),
                new Correo("cristianl@outlook.com", true),
                new Correo("migue@outlook.edu.co", true),
                new Correo("juan1hotmail.com", false),
                new Correo("miguel@outlook.com", true),
                new Correo("jhon-0@hotmail.es", true),
                new Correo("daniel_castro@gmail.com", false),
                new Correo("juan@@outlook.edu.co", true),
                new Correo("santi@gmail.es", true),
                new Correo("santi@hotmail.es", false),
                new Correo("carlos@gailcom", false),
                new Correo("cristian@outlook.com", true),
                new Correo("migue@outlook.edu.co", true),
                new Correo("juanhotmail.com", false),
                new Correo("miguel@outlook.com", true),
                new Correo("jhon874@hotmail.es", true),
                new Correo("daniel_castro@gmail.com", false),
                new Correo("juan#@outlook.edu.co", true)
        );

        esRepetido(correos);
        tipoDominio(correos, "gmail");
        tipoDominio(correos, "hotmail");
        tipoDominio(correos, "outlook");
        sonCorrectos(correos);
        seEnvio(correos);
    }
}

