import enums.Categoria;
import model.ContaMagica;
import model.MktBanco;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

public class TesteMockito {

    private MktBanco mktBanco;
    private ContaMagica contaMagica;

    @BeforeEach
    public void setUp() {
        contaMagica = Mockito.mock(ContaMagica.class);
        mktBanco = new MktBanco(contaMagica);
    }

    @Test
    public void deveriaMostrarQuantoFaltaSilverParaGold(){
      Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal("20000"));
      Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.SILVER);
       assertEquals(new BigDecimal("30000"), mktBanco.faltanteProxCategoria());

    }
    @Test
    public void deveriaMostrarQuantoFaltaGoldParaPlatinum(){
        Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal("100000"));
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.GOLD);
        assertEquals(new BigDecimal("100000"), mktBanco.faltanteProxCategoria());

    }
    @Test
    public void deveriaRetornarZero(){
        Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal("200000"));
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.PLATINUM);
        assertEquals(new BigDecimal("0"), mktBanco.faltanteProxCategoria());

    }
    @Test
    public void deveriaMostrarCategoriaSeguinteDaSilver(){
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.SILVER);
        assertEquals(Categoria.GOLD, mktBanco.proxCategoria());
    }
    @Test
    public void deveriaMostrarCategoriaSeguinteDaGold(){
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.GOLD);
        assertEquals(Categoria.PLATINUM, mktBanco.proxCategoria());
    }
    @Test
    public void naoDeveriaMostrarCategoriaSeguintePlatinum(){
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.PLATINUM);
        assertEquals(Categoria.PLATINUM, mktBanco.proxCategoria());
    }

}

//testar quanto falta em dinheiro para trocar de silver para gold
//testar quanto falta em dinheiro para trocar de gold para platinum
//a categoria platinum deveria retornar zero

//testar a categoria seguinte da silver
//testar a categoria seguinte da gold
//a categoria platinum não deveria ter proxima