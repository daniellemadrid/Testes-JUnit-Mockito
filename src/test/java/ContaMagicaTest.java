import enums.Categoria;
import model.ContaMagica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ContaMagicaTest {
    private ContaMagica contaMagica;

    @BeforeEach
    public void setUp() {
        contaMagica = new ContaMagica("dani", new BigDecimal(1000), Categoria.SILVER);

    }

    @Test
    public void deveriaDepositar() {
        System.out.println("depositando:");
        contaMagica.deposita(new BigDecimal("4000"));
        assertEquals(new BigDecimal("5000"), contaMagica.getSaldo());
        System.out.println(contaMagica.getSaldo());

    }
    @Test
    public void deveriaRetirar() {
        System.out.println("retirando:");
        contaMagica.deposita(new BigDecimal("40000"));
        contaMagica.retirada(new BigDecimal("20000"));
        assertEquals(new BigDecimal("21000"), contaMagica.getSaldo());
        System.out.println(contaMagica.getSaldo());
    }

    @Test
    public void deveriaSerPlatinumComBonus() {
        contaMagica.deposita(new BigDecimal("200000"));
        System.out.println(contaMagica.getSaldo());
        assertEquals(Categoria.PLATINUM, contaMagica.getCategoria());
    }
    @Test
    public void deveriaSerGoldComBonus(){
        contaMagica.deposita(new BigDecimal("50000"));
        contaMagica.deposita(new BigDecimal("20000"));
        contaMagica.deposita(new BigDecimal("10"));
        System.out.println(contaMagica.getSaldo());
        assertEquals(Categoria.GOLD, contaMagica.getCategoria());
    }
    @Test
    public void deveriaPassarGoldParaPlatinum(){
        contaMagica.deposita(new BigDecimal("200000"));
        contaMagica.retirada(new BigDecimal("1000"));
        System.out.println(contaMagica.getSaldo());
        assertEquals(Categoria.PLATINUM, contaMagica.getCategoria());

    }
    @Test
    void deveriaPassarPlatinumParaGold() {
        contaMagica.deposita(new BigDecimal("200000"));
        contaMagica.retirada(new BigDecimal("200000"));
        System.out.println(contaMagica.getSaldo());
        assertEquals(Categoria.GOLD, contaMagica.getCategoria());
    }

    @Test
    void deveAtualizarDeGoldParaSilver() {
        contaMagica.deposita(new BigDecimal("50000"));
        contaMagica.retirada(new BigDecimal("40000"));
        System.out.println(contaMagica.getSaldo());
        assertEquals(Categoria.SILVER,contaMagica.getCategoria());
    }

    @Test
    public void naoDeveriaRetirarSaldoZero() {
        contaMagica = new ContaMagica("dani", new BigDecimal(0), Categoria.SILVER);
        contaMagica.retirada(new BigDecimal("10"));
        assertEquals(new BigDecimal("0"), contaMagica.getSaldo());
    }

    @Test
    public void naoDeveriaDepositarValorNegativo(){
        contaMagica.deposita(new BigDecimal("-10"));
       assertEquals(new BigDecimal("1000"), contaMagica.getSaldo());
    }
    @Test
    public void naoDeveriaRetirarSaldoQueNaoTem(){
        contaMagica.deposita(new BigDecimal(2000));
        contaMagica.retirada(new BigDecimal(3000));
        assertEquals(new BigDecimal(0), contaMagica.getSaldo());
        System.out.println(contaMagica.getStatus());
    }
 }

//1-testar se a retirada está funcionando
//2- testar se o deposita está funcionando
//3- cliente platinum tem que depositar e receber o bonus 2,5% sobre o valor de deposito
//5- cliente gold tem que depositar e receber o bonus de 1% sobre o valor de deposito
//6- se o platinum tiver saldo abaixo de 100mil ele desce pra categoria gold
//7- se o gold tiver saldo abaixo de 25mil ele desce pra categoria silver
//8- nao conseguir retirar se o saldo for 0
//9- nao pode depositar valor negativo
//10- quando o saldo ultrapassa 50mil a categoria vira gold
//11- quando o saldo ultrapassa 200mil a categoria vira platinum