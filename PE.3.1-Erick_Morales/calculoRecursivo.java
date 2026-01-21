public class calculoRecursivo {
    private static double MONTO_BASE = 55.00;
    private static double MONTO_DEPENDIENTE = 15.00;
    private static double FACTOR_RURAL = 1.15;

    public double calcularSubsidioBDH(int dependientes, boolean esRural) {
        // --- Requisito Crítico: Caso Base ---
        // Familia sin dependientes: se retorna el monto base ($55).
        // Si es rural, se aplica el factor al caso base.
        if (dependientes == 0) {
            return esRural ? MONTO_BASE * FACTOR_RURAL : MONTO_BASE;
        }

        // --- Requisito Crítico: Caso Recursivo ---
        // Se agrega $15 por dependiente (ajustado si es rural) y se llama
        // recursivamente para n-1.
        double aporteActual = esRural ? MONTO_DEPENDIENTE * FACTOR_RURAL : MONTO_DEPENDIENTE;
        return aporteActual + calcularSubsidioBDH(dependientes - 1, esRural);
    }

    // Método para mantener compatibilidad con tu main anterior si lo necesitas,
    // pero la función principal solicitada es la de arriba.
    public double calcularSubsidioBDH_Final(int dependientes, boolean esRural) {
        return calcularSubsidioBDH(dependientes, esRural);
    }

    public static void main(String[] args) {
        calculoRecursivo sistema = new calculoRecursivo();

        System.out.println("--- Verificación del Sistema de Subsidios (Recursivo) ---");

        // Caso 1: 0 dependientes, Zona Urbana. Esperado: $55.00
        double caso1 = sistema.calcularSubsidioBDH(0, false);
        System.out.printf("Caso 1 (0 dep, Urbana): $%.2f (Esperado: $55.00)%n", caso1);

        // Caso 2: 2 dependientes, Zona Urbana. Esperado: 55 + 15 + 15 = $85.00
        double caso2 = sistema.calcularSubsidioBDH(2, false);
        System.out.printf("Caso 2 (2 dep, Urbana): $%.2f (Esperado: $85.00)%n", caso2);

        // Caso 3: 3 dependientes, Zona Rural. Esperado: (55 + 15 + 15 + 15) * 1.15 =
        // 115.00
        double caso3 = sistema.calcularSubsidioBDH(3, true);
        System.out.printf("Caso 3 (3 dep, Rural):  $%.2f (Esperado: $115.00)%n", caso3);
    }
}
