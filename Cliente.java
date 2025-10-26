public class Cliente {
    private final String numeroTarjeta;
    private final boolean tieneTarjeta;
    private final Monedero monedero;

    public Cliente(boolean tieneTarjeta, String numeroTarjeta) {
        this.tieneTarjeta = tieneTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.monedero = new Monedero();
    }

    public boolean tieneTarjeta() {
        return tieneTarjeta;
    }

    public boolean validarTarjeta() {
        return numeroTarjeta.matches("\\d{8}");
    }

    public Monedero getMonedero() {
        return monedero;
    }
}
