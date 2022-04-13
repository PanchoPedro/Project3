package SportyShoes.Ecommerce.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SportyShoes.Ecommerce.entity.Order;

@Repository
public class OrderDatabase {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public long count()
	{
		String sql= "select count(*) from orders";
		return this.template.queryForObject(sql, Long.class);
	}
	
	public boolean deleteOrder(int id)
	{
		String sql = "delete from orders where id=?";
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
	public boolean insertOrder(Order order)
	{
		String sql = "insert into orders (userid,shoeid,date,numberofshoes) values(?,?,CURDATE(),?)";
		try {
			this.template.update(sql, order.getUserid(), order.getShoeid(), order.getNumberofshoes());
		}
		catch(DataAccessException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	public Order getOrderById(int id)
	{
		String sql = "select * from orders where id=?";
		return this.template.queryForObject(sql, new ShoeRowMapper(), id);
	}
	public List<Order> getorders()
	{
		String sql = "select * from orders";
		return this.template.query(sql, new ShoeRowMapper());
	}
	
	class ShoeRowMapper implements RowMapper<Order>
	{
		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Order order = new Order();
			order.setId(rs.getInt(1));
			order.setUserid(rs.getInt(2));
			order.setShoeid(rs.getInt(3));
			order.setDate(rs.getString(4));
			order.setNumberofshoes(rs.getInt(5));
			return order;
		}
		
	}



}
