package SportyShoes.Ecommerce.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SportyShoes.Ecommerce.entity.Shoe;


@Repository
public class ShoeDatabase {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public long count()
	{
		String sql= "select count(*) from shoes";
		return this.template.queryForObject(sql, Long.class);
	}
	
	public boolean deleteShoe(int id)
	{
		String sql = "delete from shoes where id=?";
		try {
			int result = this.template.update(sql, id);
			if (result == 0) {return false;}
		}
		catch(DataAccessException e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	public boolean insertShoe(Shoe shoe)
	{
		String sql = "insert into shoes (modelname,company,category,price,imagelink,size) values(?,?,?,?,?,?)";
		try {
			this.template.update(sql, shoe.getSmodelname(), shoe.getScompany(), shoe.getScategory(), shoe.getSprice(), shoe.getSimage(), shoe.getSsize());
		}
		catch(DataAccessException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	public Shoe getShoeById(int id)
	{
		String sql = "select * from shoes where id=?";
		return this.template.queryForObject(sql, new ShoeRowMapper(), id);
	}
	public List<Shoe> getShoes()
	{
		String sql = "select * from shoes";
		return this.template.query(sql, new ShoeRowMapper());
	}
	
	
	class ShoeRowMapper implements RowMapper<Shoe>
	{
		@Override
		public Shoe mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Shoe shoe = new Shoe();
			shoe.setSid(rs.getInt(1));
			shoe.setSmodelname(rs.getString(2));
			shoe.setScompany(rs.getString(3));
			shoe.setScategory(rs.getString(4));
			shoe.setSprice(rs.getInt(5));
			shoe.setSimage(rs.getString(6));
			shoe.setSsize(rs.getInt(7));
			return shoe;
		}
		
	}



}
