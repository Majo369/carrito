package co.edu.uniquindio.poo.Model;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteradorPreciosBajos<T extends Producto> implements Iterator<T> {
    private List<T> lista;
    private double precioMaximo;
    private int indiceActual;
    private T siguienteProducto; 
    
    public IteradorPreciosBajos(List<T> lista, double precioMaximo) {
        this.lista = lista;
        this.precioMaximo = precioMaximo;
        this.indiceActual = 0;
        this.siguienteProducto = null;
        buscarSiguiente(); 
    }

   
    private void buscarSiguiente() {
        siguienteProducto = null;
        while (indiceActual < lista.size()) {
            T producto = lista.get(indiceActual);
            indiceActual++;
            if (producto.getPrecio() <= precioMaximo) {
                siguienteProducto = producto;
                return; 
            }
        }
        
    }

    @Override
    public boolean hasNext() {
        
        return siguienteProducto != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más productos con precio bajo.");
        }
        T productoADevolver = siguienteProducto;
        buscarSiguiente(); 
        return productoADevolver;
    }
}