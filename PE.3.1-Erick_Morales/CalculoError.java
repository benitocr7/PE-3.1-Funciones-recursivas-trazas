public class CalculoError {

    // 3. Provocación de Error
    public double calcularSubsidioSinBase(int dependientes) {
        // ERROR INDUCIDO: No hay Caso Base (o la condición está mal)
        // El sistema intentará calcular "hacia atrás" infinitamente: 3, 2, 1, 0, -1,
        // -2...

        System.out.println("Calculando para dependientes: " + dependientes); // Para ver el loop infinito

        // Llamada recursiva sin fin
        return 15.00 + calcularSubsidioSinBase(dependientes - 1);
    }

    public static void main(String[] args) {
        CalculoError buggy = new CalculoError();
        try {
            System.out.println("Iniciando cálculo infinito...");
            buggy.calcularSubsidioSinBase(3);
        } catch (StackOverflowError e) {
            System.err.println("\n!!! ERROR CAPTURADO: StackOverflowError !!!");
            System.err.println("La pila de llamadas se ha llenado (Recursion Depth limit exceeded).");
            System.err.println("Causa: Ausencia de Caso Base que detenga la recursión.");
        }
    }
}
