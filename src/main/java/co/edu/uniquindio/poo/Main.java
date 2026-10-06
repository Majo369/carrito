package co.edu.uniquindio.poo;
import java.util.Iterator;
import co.edu.uniquindio.poo.Model.Carrito;
import co.edu.uniquindio.poo.Model.Producto;

public class Main {
    public static void main(String[] args) {
        Carrito<Producto> carrito = new Carrito<>();

        
        carrito.agregarProducto(new Producto("Laptop HP", 520000.0));
        carrito.agregarProducto(new Producto("Mouse Logitech", 25000.5));
        carrito.agregarProducto(new Producto("Monitor Samsung", 300000.0));
        carrito.agregarProducto(new Producto("Teclado Mecánico", 85000.0));
        carrito.agregarProducto(new Producto("Cable USB", 5000.0));
        carrito.agregarProducto(new Producto("Audífonos Sony", 150000.0));
        carrito.agregarProducto(new Producto("Notebook Dell", 120000.0));
        carrito.agregarProducto(new Producto("Cable HDMI", 15000.0));
        carrito.agregarProducto(new Producto("Audífonos JBL", 100000.0));

        System.out.println("\nPRODUCTO MÁS CARO");
        System.out.println("El más caro es: " + carrito.obtenerProductoMasCaro());

        System.out.println("\nPRECIO TOTAL");
        System.out.println("Total: $" + carrito.calcularTotal());

        System.out.println("\nRECORRIDO NORMAL (TODOS)");
        for (Producto p : carrito) {
            System.out.println("-" + p);
        }

        System.out.println("\nRECORRIDO FILTRADO: SOLO PRECIOS BAJOS (<= $100.000)");
        Iterator<Producto> itBaratos = carrito.iteratorPreciosBajos(100000.00);
        while (itBaratos.hasNext()) {
            Producto p = itBaratos.next();
            System.out.println("Oferta: " + p);
        }
    }
}
