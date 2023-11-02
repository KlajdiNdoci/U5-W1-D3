package KlajdiNdoci;

import KlajdiNdoci.entities.Menú;
import KlajdiNdoci.entities.Ordine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class U5W1D2ApplicationTests {
	@BeforeAll
	static void verifyMenuArraysAreFilled(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D2Application.class);
		Menú menú = (Menú) ctx.getBean("getMenu");
		assertNotNull(menú.getPizzaList());
		log.info("L'array delle pizze nel menú non é nullo");
		assertNotNull(menú.getBevandaList());
		log.info("L'array delle bevande nel menú non é nullo");
		ctx.close();
	}

	@Test
	void verifyOrderArrayIsFilled(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D2Application.class);
		Ordine o1 = (Ordine) ctx.getBean("getOrdine");
		assertNotNull(o1.getPizze());
		log.info("Sono presenti pizze nell'ordine");
		ctx.close();
	}




}
