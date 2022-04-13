package SportyShoes.Ecommerce.entity;


import org.springframework.stereotype.Component;

@Component
public class Order {
	
	private int id;
	private int userid;
	private int shoeid;
	private String date;
	private int numberofshoes;
	
	public Order() {	}

	public Order(int id, int userid, int shoeid, String date, int numberofshoes) {
		super();
		this.id = id;
		this.userid = userid;
		this.shoeid = shoeid;
		this.date = date;
		this.numberofshoes = numberofshoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getShoeid() {
		return shoeid;
	}

	public void setShoeid(int shoeid) {
		this.shoeid = shoeid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumberofshoes() {
		return numberofshoes;
	}

	public void setNumberofshoes(int numberofshoes) {
		this.numberofshoes = numberofshoes;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", shoeid=" + shoeid + ", date=" + date
				+ ", numberofshoes=" + numberofshoes + "]";
	}
	
	

}
