public class calculo {

    private static double MONTO_BASE = 55.00;
    private static double MONTO_DEPENDIENTE = 15.00;
    private static double FACTOR_RURAL = 1.15;

    public double calculo(int dependientes, boolean esRural) {
        double monto = MONTO_BASE;

        for (int i = 0; i < dependientes; i++) {
            monto += MONTO_DEPENDIENTE;
        }

        return esRural ? monto * FACTOR_RURAL : monto;
    }

    public static void main(String[] args) {
        calculo c = new calculo(); // crear objeto
        System.out.println("Caso 1: Zona Urbana $" + c.calculo(0, false));
    }
}
