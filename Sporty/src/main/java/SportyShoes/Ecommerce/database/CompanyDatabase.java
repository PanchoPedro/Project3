package SportyShoes.Ecommerce.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SportyShoes.Ecommerce.entity.Company;

@Repository
public class CompanyDatabase {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public long count()
	{
		String sql= "select count(*) from companies";
		return this.template.queryForObject(sql, Long.class);
	}
	
	public boolean deleteCompany(int id)
	{
		String sql = "delete from companies where id=?";
		try {
			this.template.update(sql, id);
		}
		catch(DataAccessException e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	public boolean insertCompany(Company company)
	{
		String sql = "insert into companies (company) values(?)";
		try {
			this.template.update(sql, company.getCompany());
		}
		catch(DataAccessException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	public Company getCompanyById(int id)
	{
		String sql = "select * from companies where id=?";
		return this.template.queryForObject(sql, new ShoeRowMapper(), id);
	}
	public List<Company> getCompanies()
	{
		String sql = "select * from companies";
		return this.template.query(sql, new ShoeRowMapper());
	}
	
	class ShoeRowMapper implements RowMapper<Company>
	{
		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Company company = new Company();
			company.setId(rs.getInt(1));
			company.setCompany(rs.getString(2));
			return company;
		}
		
	}



}
