package contenedores;

import java.util.Set;

import productos.IProducto;
import sooper.TipoDeContenedores;

public interface IContenedor {  
    String getReferencia();
    int getVolumen();
    int getSuperficie();
    int getVolumenDisponible();
    int getResistencia();
    Set<IProducto> getProductos();
    TipoDeContenedores getTipo();
    boolean meterProducto(IProducto producto);
    boolean resiste(IProducto producto);
    
}
