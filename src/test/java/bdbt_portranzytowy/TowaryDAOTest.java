package bdbt_portranzytowy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import bdbt_portranzytowy.daos.TowaryDAO;
import bdbt_portranzytowy.models.Towar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class TowaryDAOTest {
	
	private TowaryDAO towaryDao;

	@BeforeEach
	void setUp() throws Exception { // Setup przed wykonaniem kazdego z testow
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
		datasource.setUsername("jzobniow");
		datasource.setPassword("jzobniow");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		towaryDao = new TowaryDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Towar> listTowary = towaryDao.list();
		System.out.println(towaryDao.list());

		// Czy jest pusta?
		assertFalse(listTowary.isEmpty());
		
		// Czy wszystkie id sa inne?
		assertTrue(wszystkieInneIndeksy());
		
	}
	
	boolean wszystkieInneIndeksy() {
		List<Integer> indeksy = new ArrayList<Integer>();
		for(Towar item : towaryDao.list()) {
			if (indeksy.contains(item.getId()))
				return false;
			else
				indeksy.add(item.getId());
		}
		return true;
	}

	@Test
	void testAdd() {
		Towar towar = new Towar(200, 20f, 20f, 20f, 30f, "XXX");
		towaryDao.add(towar);
		
	}

	@Test
	void testGet() {
		assertNotNull(towaryDao.get(2));
		
	}

	@Test
	void testUpdate() {
		List<Towar> towaryPrzed = towaryDao.list();
		Towar towar = new Towar(2, 21, 20, 30, 40, "Ciezki towar, mozna zgniesc");
		towaryDao.update(towar);
		List<Towar> towaryPo = towaryDao.list();
		assertFalse(towaryPrzed.equals(towaryPo));
	}

	@Test
	void testDelete() {
		List<Towar> towaryPrzed = towaryDao.list();
		towaryDao.delete(12);
		List<Towar> towaryPo = towaryDao.list();
		assertFalse(towaryPrzed.equals(towaryPo));
	}

}
