
public class Flight {
	private int id,seats;
	private String fname,df,at;
	public Flight(int id,String fname,String df,String ato,int seats)
	{
		this.id=id;
		this.fname=fname;
		this.df=df;
		this.at=ato;
		this.seats=seats;
	}
	public int getid() {
		return id;
	}
	public String getfname() {
		return fname;
	}
	public String getdf() {
		return df;
	}
	public String getato() {
		return at;
	}
	public int getseats() {
		return seats;
	}
	

}
