package SportyShoes.Ecommerce.entity;


import org.springframework.stereotype.Component;

@Component
public class Company {

	private int id;
	private String company;
	
	public Company() {	}

	public Company(int id, String company) {
		super();
		this.id = id;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", company=" + company + "]";
	}
	
	
	
}
