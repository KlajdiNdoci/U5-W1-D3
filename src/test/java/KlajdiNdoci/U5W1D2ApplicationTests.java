package KlajdiNdoci;

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
	@Test
	void verifyArrayIsFilled(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D2Application.class);
		Ordine o1 = (Ordine) ctx.getBean("getOrdine");
		assertNotNull(o1.getPizze());
		log.info("L'array non é nullo");
		ctx.close();
	}

	@Test
	void contextLoads() {
	}



}
