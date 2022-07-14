package co.com.sofkau.ejercicio2;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> palabras = List.of("gonorrea", "tonto", "sapo", "perro", "atolondrado",
                " baboso", "bobo", "cacorro", "coscorria", "fufurufa", "garbimba", "hijueputa",
                "idiota", "imbecil", "lambon", "malparido", "maricon", "pirobo", "zorra", "hp");

        System.out.println("Ingrese una palabra");
        String in = sc.nextLine().toLowerCase();

        var nuevaLista = Arrays.stream(in.split(" ")).toList();

        Flux.fromIterable(nuevaLista).map(mensaje -> {
            if (palabras.contains(mensaje.toLowerCase())) {
                mensaje = "******";
            }
            return mensaje;
        }).subscribe(mensaje -> System.out.println(mensaje.toString()));
    }
}
