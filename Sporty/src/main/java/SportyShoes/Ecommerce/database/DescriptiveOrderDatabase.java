package SportyShoes.Ecommerce.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SportyShoes.Ecommerce.entity.DescriptiveOrder;

@Repository
public class DescriptiveOrderDatabase {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public List<DescriptiveOrder> getOrdersByCategory(String category)
	{
		String sql = "SELECT orders.id,orders.userid,orders.date,orders.numberofshoes,shoes.modelname,shoes.company,shoes.category FROM orders,shoes where orders.shoeid=shoes.id AND shoes.category=?;";
		return this.template.query(sql, new ShoeRowMapper(), category);
	}
	
	public List<DescriptiveOrder> getOrdersByDate(String date)
	{
		String sql = "SELECT orders.id,orders.userid,orders.date,orders.numberofshoes,shoes.modelname,shoes.company,shoes.category FROM orders,shoes where orders.shoeid=shoes.id AND orders.date=?;";
		return this.template.query(sql, new ShoeRowMapper(), date);
	}
	public List<DescriptiveOrder> getorders()
	{
		String sql = "SELECT orders.id,orders.userid,orders.date,orders.numberofshoes,shoes.modelname,shoes.company,shoes.category FROM orders,shoes where orders.shoeid=shoes.id;";
		return this.template.query(sql, new ShoeRowMapper());
	}
	
	class ShoeRowMapper implements RowMapper<DescriptiveOrder>
	{
		@Override
		public DescriptiveOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			DescriptiveOrder descriptiveorder = new DescriptiveOrder();
			descriptiveorder.setId(rs.getInt(1));
			descriptiveorder.setUserid(rs.getInt(2));
			descriptiveorder.setDate(rs.getString(3));
			descriptiveorder.setNumberofshoes(rs.getInt(4));
			descriptiveorder.setModelname(rs.getString(5));
			descriptiveorder.setCompany(rs.getString(6));
			descriptiveorder.setCategory(rs.getString(7));
			return descriptiveorder;
		}
		
	}



}
