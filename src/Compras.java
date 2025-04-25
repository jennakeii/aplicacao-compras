public class Compras implements Comparable<Compras> {
    private String produto;
    private double valor;

    public Compras(String produto, double valor) {
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(Compras outraCompra) {
        return Double.compare(this.getValor(), outraCompra.getValor());
    }
}
