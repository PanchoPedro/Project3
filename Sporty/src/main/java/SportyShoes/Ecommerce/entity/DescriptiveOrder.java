package SportyShoes.Ecommerce.entity;


import org.springframework.stereotype.Component;

@Component
public class DescriptiveOrder {
	
	private int id;
	private int userid;
	private String date;
	private int numberofshoes;
	private String modelname;
	private String company;
	private String category;
	
	public DescriptiveOrder() {	}

	public DescriptiveOrder(int id, int userid, String date, int numberofshoes, String modelname, String company,
			String category) {
		super();
		this.id = id;
		this.userid = userid;
		this.date = date;
		this.numberofshoes = numberofshoes;
		this.modelname = modelname;
		this.company = company;
		this.category = category;
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

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "DescriptiveOrder [id=" + id + ", userid=" + userid + ", date=" + date + ", numberofshoes="
				+ numberofshoes + ", modelname=" + modelname + ", company=" + company + ", category=" + category + "]";
	}


	
	

}
