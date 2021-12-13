import model.ContaMagica;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaMagicaTest {
    //1-testar a retirada com cada categoria
    //2- cliente silver não é valorizado com bonus
    //3- cliente tem que inicar na categoria silver
    //4- cliente platinum tem que depositar e receber o bonus 2,5% sobre o valor de deposito
    //5- cliente gold tem que depositar e receber o bonus de 1% sobre o valor de deposito
    //6- se o platinum tiver saldo abaixo de 100mil ele desce pra categoria gold
    //7- se o gold tiver saldo abaixo de 25mil ele desce pra categoria silver
    //8- nao conseguir retirar se o saldo for 0
    //9- nao pode depositar valor negativo
    //10- quando o saldo ultrapassa 50mil a categoria vira gold
    //11- quando o saldo ultrapassa 200mil a categoria vira platinum




    private ContaMagica contaMagica;

    @Test
    public void deveriaDepositar(){
        contaMagica.deposita(new BigDecimal(10000));
        System.out.println(contaMagica.getSaldo());
    }
}
