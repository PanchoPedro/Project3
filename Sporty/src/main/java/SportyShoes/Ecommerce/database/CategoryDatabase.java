package SportyShoes.Ecommerce.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SportyShoes.Ecommerce.entity.Category;

@Repository
public class CategoryDatabase {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public long count()
	{
		String sql= "select count(*) from categories";
		return this.template.queryForObject(sql, Long.class);
	}
	
	public boolean deleteCategory(int id)
	{
		String sql = "delete from categories where id=?";
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
	public boolean insertCategory(Category category)
	{
		String sql = "insert into categories (category) values(?)";
		try {
			this.template.update(sql, category.getCategory());
		}
		catch(DataAccessException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	public Category getCategoryById(int id)
	{
		String sql = "select * from categories where id=?";
		return this.template.queryForObject(sql, new ShoeRowMapper(), id);
	}
	public List<Category> getCategories()
	{
		String sql = "select * from categories";
		return this.template.query(sql, new ShoeRowMapper());
	}
	
	class ShoeRowMapper implements RowMapper<Category>
	{
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setCategory(rs.getString(2));
			return category;
		}
		
	}



}
