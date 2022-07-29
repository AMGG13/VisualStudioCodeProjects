package contenedores;

import sooper.TipoDeContenedores;

public class Bolsa extends Contenedor{
    private static final byte DOS = 2;
    private int ancho;
    public Bolsa(String referencia, int alto, int ancho) {
        super(referencia, alto);
        this.ancho=ancho;
    }
    @Override
    public int getSuperficie() {
        int radio = getDiametro()/DOS;
        return (int)(Math.PI*radio*radio);
    }
    private int getDiametro() {
        return (int)((DOS*ancho)/Math.PI);
    }
    @Override
    public TipoDeContenedores getTipo() {
        return TipoDeContenedores.BOLSA;
    }
}
