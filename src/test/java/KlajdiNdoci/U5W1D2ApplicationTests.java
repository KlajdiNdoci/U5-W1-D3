package KlajdiNdoci;

import KlajdiNdoci.entities.Menú;
import KlajdiNdoci.entities.Ordine;
import KlajdiNdoci.entities.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class U5W1D2ApplicationTests {
	private static AnnotationConfigApplicationContext ctx;
	@Value("${costo.coperto}")
	private int costoCoperto;
	private static Menú menú;
	private static Ordine o1;


	@BeforeAll
	static void verifyMenuArraysAreFilled(){
		ctx = new AnnotationConfigApplicationContext(U5W1D2Application.class);
		menú = (Menú) ctx.getBean("getMenu");
		assertFalse(menú.getPizzaList().isEmpty());
		log.info("L'array delle pizze nel menú non é nullo");
		assertFalse(menú.getBevandaList().isEmpty());
		log.info("L'array delle bevande nel menú non é nullo");
	}

	@Test
	void verifyOrderArrayIsFilled(){
		o1 = (Ordine) ctx.getBean("getOrdine");
		assertFalse(o1.getPizze().isEmpty());
		log.info("Sono presenti pizze nell'ordine");
	}

	@Test
	void testCalcTot(){
		double result = o1.calcImportoTotale(costoCoperto);
		assertEquals(18.56, result);
		log.info("Somma importo totale: " + result);
	}

	@Test
	void testNumPizze(){
		List<Pizza> pizzaList = menú.getPizzaList();
		assertEquals(3, pizzaList.size());
		log.info("Sono presenti " + pizzaList.size() + " pizze nel menu");
	}

	@ParameterizedTest
	@CsvSource({"2, 18.56", "3, 21.56", "4, 24.56"})
	void calcThreeTots(int a, double expectedResult){
		double result = o1.calcImportoTotale(a);
		assertEquals(expectedResult, result);
	}

	@AfterAll
	static void closeCtx(){
		ctx.close();
		log.info("Ctx chiuso");
	}


}
