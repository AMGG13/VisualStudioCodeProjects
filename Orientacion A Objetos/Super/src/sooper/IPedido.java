package sooper;

import java.util.Set;

import contenedores.IContenedor;
import productos.IProducto;

//<>
public interface IPedido {
    String getReference();
    Set<IProducto> getProductos();
    Set<IContenedor> getContenedores();
    void addContenedor(IContenedor contenedor);
    IContenedor addProducto(IProducto producto);
}
