package section5;

public class Qspiders {
	String batch,area,trainer;
	private String phno;
	private double fee;
	Qspiders(String batch,String area,String trainer){
		this.batch=batch;
		this.area=area;
		this.trainer=trainer;
	}
	public void setPhno(String phno) {
		this.phno=phno;
	}
	public void setFee(double fee) {
		this.fee=fee;
	}
	public String getPhno() {
		return phno;
	}
	public double getFee() {
		return fee;
	}

}
