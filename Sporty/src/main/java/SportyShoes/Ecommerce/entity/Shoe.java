package SportyShoes.Ecommerce.entity;

import org.springframework.stereotype.Component;

@Component
public class Shoe {
	private int Sid;
	private String Smodelname;
	private String Scompany;
	private String Scategory;
	private int Sprice;
	private String Simage;
	private int Ssize;
	
	public Shoe(){
		
		
	}

	public Shoe(int sid, String smodelname, String scompany, String scategory, int sprice, String simage, int ssize) {
		super();
		Sid = sid;
		Smodelname = smodelname;
		Scompany = scompany;
		Scategory = scategory;
		Sprice = sprice;
		Simage = simage;
		Ssize = ssize;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSmodelname() {
		return Smodelname;
	}

	public void setSmodelname(String smodelname) {
		Smodelname = smodelname;
	}

	public String getScompany() {
		return Scompany;
	}

	public void setScompany(String scompany) {
		Scompany = scompany;
	}

	public String getScategory() {
		return Scategory;
	}

	public void setScategory(String scategory) {
		Scategory = scategory;
	}

	public int getSprice() {
		return Sprice;
	}

	public void setSprice(int sprice) {
		Sprice = sprice;
	}

	public String getSimage() {
		return Simage;
	}

	public void setSimage(String simage) {
		Simage = simage;
	}

	public int getSsize() {
		return Ssize;
	}

	public void setSsize(int ssize) {
		Ssize = ssize;
	}

	@Override
	public String toString() {
		return "Shoe [Sid=" + Sid + ", Smodelname=" + Smodelname + ", Scompany=" + Scompany + ", Scategory=" + Scategory
				+ ", Sprice=" + Sprice + ", Simage=" + Simage + ", Ssize=" + Ssize + "]";
	}


	

}
