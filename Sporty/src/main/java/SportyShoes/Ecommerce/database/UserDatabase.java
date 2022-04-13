package SportyShoes.Ecommerce.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SportyShoes.Ecommerce.entity.User;

@Repository
public class UserDatabase {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public long count()
	{
		String sql= "select count(*) from users";
		return this.template.queryForObject(sql, Long.class);
	}
	
	public boolean deleteUser(int id)
	{
		String sql = "delete from users where id=?";
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
	public boolean insertUser(User user)
	{
		String sql = "insert into users (firstname,surname,email,phone,dateofbirth,password) values (?,?,?,?,?,?);";
		try {
			this.template.update(sql, user.getFirstname(), user.getSurname(), user.getEmail(), user.getPhone(), user.getDateofbirth(), user.getPassword());
		}
		catch(DataAccessException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	public User getUserById(int id)
	{
		String sql = "select * from users where id=?";
		return this.template.queryForObject(sql, new ShoeRowMapper(), id);
	}
	
	public User getUserByEmail(String email)
	{
	
		String sql = "select * from users where email=?";
		return this.template.queryForObject(sql, new ShoeRowMapper(), email);
		
	}
	public List<User> getUsers()
	{
		String sql = "select * from users";
		return this.template.query(sql, new ShoeRowMapper());
	}
	
	class ShoeRowMapper implements RowMapper<User>
	{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			user.setId(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setSurname(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPhone(rs.getString(5));
			user.setDateofbirth(rs.getString(6));
			user.setPassword(rs.getString(7));
			user.setType(rs.getString(8));
			return user;
		}
		
	}



}
