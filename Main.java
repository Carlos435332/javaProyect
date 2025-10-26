import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("¿Tiene tarjeta de monedero electrónico? (S/N)");
            String respuesta = sc.nextLine().trim().toUpperCase();

            boolean tieneTarjeta = respuesta.equals("S");
            String numeroTarjeta = "";

            if (tieneTarjeta) {
                System.out.print("Ingrese número de tarjeta (8 dígitos): ");
                numeroTarjeta = sc.nextLine();
            }

            Cliente cliente = new Cliente(tieneTarjeta, numeroTarjeta);
            Tienda tienda = new Tienda();
            tienda.realizarCompra(cliente);
        }
    }
}
