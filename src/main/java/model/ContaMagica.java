package model;

import enums.Categoria;

import java.math.BigDecimal;
import java.util.Objects;

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

    //
    public void deposita(BigDecimal valor) {
        setSaldo(saldo.add(valor));
        int gold = saldo.compareTo(new BigDecimal("50000"));
        int platinium = saldo.compareTo(new BigDecimal("200000"));

        if ((gold > 0) || (gold == 0)) {
            setCategoria(Categoria.GOLD);
            System.out.println("Cliente Gold");
            setSaldo(saldo.add(valor.multiply(new BigDecimal("0.01"))));
        }
        if ((platinium > 0) || (platinium == 0)) {
            setCategoria(Categoria.PLATINUM);
            setSaldo(saldo.add(valor.multiply(new BigDecimal("0.025"))));
            System.out.println("Cliente Platinum");
        }
    }

    public void retirada(BigDecimal valor) {
        int verificaSaldo = saldo.compareTo(valor);
        if (verificaSaldo >= 0) {
            setSaldo(saldo.subtract(valor));
            if ((getSaldo().compareTo(new BigDecimal("100000")) < 0) && getCategoria() == Categoria.PLATINUM) {
                setCategoria(Categoria.GOLD);
                System.out.println("De platinum você foi para gold");
            } else if ((getSaldo().compareTo(new BigDecimal("25000")) < 0) && getCategoria() == Categoria.GOLD) {
                setCategoria(Categoria.SILVER);
                System.out.println("De Gold você foi para Silver");
            }
        }
    }

    public Categoria getStatus() {
        return getCategoria();
    }

}