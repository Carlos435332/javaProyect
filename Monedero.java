public class Monedero {
    private double saldo;

    public Monedero() {
        this.saldo = 0;
    }

    public void abonar(double cantidad) {
        saldo += cantidad;
        if (saldo >= 150) {
            saldo += 150;
            System.out.println("¡Felicidades! Se le han regalado $150 adicionales por acumular $150 o más.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
