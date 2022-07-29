package productos;

import contenedores.IContenedor;
import sooper.Categoria;

public interface IProducto {
    String getReferencia();
    int getPeso();
    int getPrecio();
    int getVolumen();
    Categoria getCategories();
    boolean setCompatible(IProducto producto);
    boolean cabeEnContenedor(IContenedor contenedor);
    void meterProducto(IContenedor contenedor);

}
