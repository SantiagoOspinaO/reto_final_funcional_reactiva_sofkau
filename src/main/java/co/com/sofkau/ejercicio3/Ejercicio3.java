package co.com.sofkau.ejercicio3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio3 {

    public static void derivar(Integer coeficiente, Integer exponente) {
        BiFunction<Integer, Integer, Integer> coeficien = (coeficient, exponent) -> coeficient * exponent;
        Function<Integer, Integer> exponen = (expone) -> expone - 1;
        System.out.println("∂f/∂x " + coeficiente +"x^" + exponente +" = " + coeficien.apply(coeficiente, exponente) +"x^" + exponen.apply(exponente));
    }

    public static void integrar(Integer coeficiente, Integer exponente) {
        BiFunction<Integer, Integer, Integer> coeficien = (coeficient, exponent) -> {
            if (coeficient / (exponent + 1) == 1) {
                return 1;
            } else {
                return coeficient / (exponent + 1);
            }
        };
        Function<Integer, Integer> exponen = (expone) -> expone + 1;
        System.out.println("∫" + coeficiente + "x^" + exponente + "∂x = " + coeficien.apply(coeficiente, exponente) + "x^" + exponen.apply(exponente) + " + c");
    }

    public static void main(String[] args) {
        derivar(6, 2);
        integrar(12, 1);
    }
}
