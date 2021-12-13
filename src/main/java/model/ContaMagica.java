package model;

import enums.Categoria;

import java.math.BigDecimal;

public class ContaMagica {
    private String cliente;
    private BigDecimal saldo;
    private Categoria categoria = Categoria.SILVER;


    public ContaMagica(String cliente, BigDecimal saldo, Categoria categoria) {
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
        String deposita = valor.toString();
        if (getStatus().equals(Categoria.GOLD)) {
            BigDecimal valorDeposita = valor;
            valor = valor.multiply(new BigDecimal(0.01));
            valor = valor.add(valorDeposita);
            saldo = new BigDecimal(deposita).add(valor);
        } else if (getStatus().equals(Categoria.PLATINUM)) {
            BigDecimal valorDeposita = valor;
            valor = valor.multiply(new BigDecimal(0.025));
            valor = valor.add(valorDeposita);
            saldo = new BigDecimal(deposita).add(valor);
        }

    }


    public void retirada(BigDecimal valor) {
        String retirada = valor.toString();
        saldo = new BigDecimal(retirada).subtract(valor);

        if (saldo.compareTo(new BigDecimal(100000)) == -1) {
            categoria = Categoria.GOLD;
            System.out.println("Você perdeu sua categoria de Platinum e passou para Gold");

        } else if (saldo.compareTo(new BigDecimal(25000)) == -1) {
            categoria = Categoria.SILVER;
            System.out.println("Você perdeu sua categoria de Gold e passou para Silver");

        }
    }


    public Categoria getStatus() {
        BigDecimal saldoAtual = saldo;

        if (saldoAtual.compareTo(new BigDecimal(50000)) == -1) {
            categoria = Categoria.SILVER;
        } else if (saldoAtual.compareTo(new BigDecimal(50000)) == 0 || (saldoAtual.compareTo(new BigDecimal(50000)) == 1) && saldoAtual.compareTo(new BigDecimal(20000)) == -1) {
            categoria = Categoria.GOLD;
        } else {
            categoria = Categoria.PLATINUM;
        }
        return categoria;
    }

}