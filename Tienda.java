import java.util.Scanner;

public class Tienda {
    private final Producto[] productos;

    public Tienda() {
        productos = new Producto[] {
            new Producto("Vitaminas y Minerales", 142, 1.42),
            new Producto("Suero", 19, 0.95),
            new Producto("Leche en polvo", 128, 1.30)
        };
    }

    public void realizarCompra(Cliente cliente) {
        if (!cliente.tieneTarjeta()) {
            System.out.println("No se aplicarán abonos sin tarjeta de monedero.");
            return;
        }

        if (!cliente.validarTarjeta()) {
            System.out.println("Número de tarjeta inválido. Debe tener 8 dígitos.");
            return;
        }

        System.out.println("Tarjeta válida. ¡Bienvenido a la farmacia!");

        double totalCompra = 0;
        double totalAbono = 0;
        int opcion;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                mostrarMenu();
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1, 2, 3 -> {
                        Producto seleccionado = productos[opcion - 1];
                        totalCompra += seleccionado.getPrecio();
                        totalAbono += seleccionado.getAbono();
                        System.out.println("Agregó: " + seleccionado.getNombre());
                    }
                    case 4 -> System.out.println("Finalizando compra...");
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } while (opcion != 4);
        }

        // Realiza abono
        cliente.getMonedero().abonar(totalAbono);

        // Mostrar resumen
        System.out.println("\n=== RESUMEN DE COMPRA ===");
        System.out.println("Total de compra: $" + totalCompra);
        System.out.println("Abono obtenido: $" + totalAbono);
        System.out.println("Saldo final en monedero: $" + cliente.getMonedero().getSaldo());
    }

    private void mostrarMenu() {
        System.out.println("\nSeleccione un producto:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i]);
        }
        System.out.println("4. Finalizar compra");
        System.out.print("Opción: ");
    }
}
