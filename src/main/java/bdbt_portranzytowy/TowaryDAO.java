package bdbt_portranzytowy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TowaryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;

	public List<Towar> list() {
		String sql = "SELECT * FROM TOWARY ORDER BY NR_TOWARU";

		RowMapper<Towar> rowMapper = new RowMapper<>() {
			public Towar mapRow(ResultSet result, int row) throws SQLException {
				Integer id = result.getInt(1);
				float waga = result.getFloat(2);
				float szerokosc = result.getFloat(3);
				float dlugosc = result.getFloat(4);
				float wysokosc = result.getFloat(5);
				String opis = result.getString(6);

				return new Towar(id, waga, szerokosc, dlugosc, wysokosc, opis);
			}
		};

		List<Towar> listTowary = jdbcTemplate.query(sql, rowMapper);
		return listTowary;
	}

	/* Constructor */
	public TowaryDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* Create */
	public void add(Towar towar) {
		// TO DO
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TOWARY").usingColumns("WAGA", "SZEROKOSC", "DLUGOSC", "WYSOKOSC", "OPIS");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(towar);
		insertActor.execute(param);
	}
	

	/* Read */
	public Towar get(int id) {
		String sql = "SELECT * FROM TOWARY WHERE NR_TOWARU = " + String.valueOf(id);
		Towar towar = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Towar.class));
		return towar;
	}
		

	/* Update */
	public void update(Towar towar) {
		String sql = "UPDATE TOWARY SET WAGA=" + towar.getWaga() +  ", szerokosc=" + towar.getSzerokosc() + ", dlugosc=" + towar.getDlugosc()
		+  ", wysokosc="+ towar.getWysokosc()+ ", opis='" + towar.getOpis() + "' WHERE nr_towaru=" + towar.getId();
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(towar);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
				
	}

	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM TOWARY WHERE nr_towaru = ?";
		jdbcTemplate.update(sql, id);
	}

}
