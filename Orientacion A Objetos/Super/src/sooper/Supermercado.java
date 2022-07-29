package sooper;

import javax.swing.Icon;

import contenedores.Bolsa;
import contenedores.Caja;
import contenedores.Contenedor;
import contenedores.IContenedor;

public class Supermercado {
    public static void main(String[] args) {
        IPedido pedido1 = new Pedido("P001");
        IContenedor caja1 = new Caja("C001", 30, 50, 90);
        IContenedor bolsa1 = new Bolsa("B001", 30, 30);
        pedido1.addContenedor(caja1);
        pedido1.addContenedor(bolsa1);
        System.out.println(pedido1.getReference());
    }
}
