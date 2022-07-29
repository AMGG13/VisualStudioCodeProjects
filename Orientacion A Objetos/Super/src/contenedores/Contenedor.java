package contenedores;

import java.util.Set;

import productos.IProducto;
import sooper.TipoDeContenedores;

public abstract class Contenedor implements IContenedor {
    private String referencia;
    private int alto;
    private int resistencia;
    private Set<IProducto> productos;

    
    public Contenedor(String referencia, int alto) {
        this.referencia = referencia;
        this.alto = alto;
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    @Override
    public int getVolumenDisponible() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getResistencia() {
        return resistencia;
    }

    @Override
    public Set<IProducto> getProductos() {
        return productos;
    }

    @Override
    public TipoDeContenedores getTipo() {
        return null;
    }

    @Override
    public boolean meterProducto(IProducto producto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean resiste(IProducto producto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getSuperficie() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
