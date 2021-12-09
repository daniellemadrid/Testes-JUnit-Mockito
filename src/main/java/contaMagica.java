import java.math.BigDecimal;

public class contaMagica {
    private String cliente;
    private BigDecimal saldo;
    private Categoria categoria = Categoria.SILVER;


    public contaMagica(String cliente, BigDecimal saldo, Categoria categoria) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.categoria = categoria;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void deposita(BigDecimal valor) {
        saldo.add(valor);
        if(saldo.doubleValue() >= 50000){
            setCategoria(Categoria.GOLD);
            System.out.println("Você é um cliente GOLD!");
            saldo.add(saldo.multiply(new BigDecimal(0.1)));
        }else if(saldo.doubleValue() >= 200000){
            setCategoria(Categoria.PLATINUM);
            saldo.add(saldo.multiply(new BigDecimal(2.5)));
            System.out.println("Você é um cliente PLATINUM");
        }

    }

    public void retirada(BigDecimal valor) {
        if (saldo.doubleValue() - valor.doubleValue() <= 0) {
            System.out.println("Não pode sacar! sem saldo");
        } else {
            saldo.subtract(valor);
        }
    }
    public  Categoria getStatus(){
        return getCategoria();
    }
}
