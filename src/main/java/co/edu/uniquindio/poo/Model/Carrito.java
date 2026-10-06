package co.edu.uniquindio.poo.Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrito<T extends Producto> implements Iterable<T> {
    private List<T> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(T producto) {
        productos.add(producto);
        System.out.println(" Agregado: " + producto.getNombre());
    }

   
    public T obtenerProductoMasCaro() {
        if (productos.isEmpty()) return null;
        T masCaro = productos.get(0);
        for (T p : productos) {
            if (p.getPrecio() > masCaro.getPrecio()) {
                masCaro = p;
            }
        }
        return masCaro;
    }

   
    public double calcularTotal() {
        double total = 0;
        for (T p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    
    @Override
    public Iterator<T> iterator() {
        return productos.iterator();
    }

    
    public Iterator<T> iteratorPreciosBajos(double precioMaximo) {
        return new IteradorPreciosBajos<>(productos, precioMaximo);
    }

    public int tamaño() {
        return productos.size();
    }
}