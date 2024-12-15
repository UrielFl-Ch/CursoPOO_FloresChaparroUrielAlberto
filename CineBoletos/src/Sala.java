public class Sala {
    private final String tipo;
    private int boletosVendidos;
    private double totalRecaudado;

    public Sala(String tipo) {
        this.tipo = tipo;
        this.boletosVendidos = 0;
        this.totalRecaudado = 0.0;
    }

    public void venderBoleto(double precio) {
        boletosVendidos++;
        totalRecaudado += precio;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public String getTipo() {
        return tipo;
    }
}