import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cartao {
    private double limite;
    private double saldo;
    public List<Compras> compras;

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public boolean lancaCompra (Compras compra){
        if  (saldo >= compra.getValor()){
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compras> getCompras() {
        Collections.sort(compras);
        return compras;
    }
}
