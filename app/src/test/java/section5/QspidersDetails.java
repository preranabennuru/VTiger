package section5;

public class QspidersDetails {
	public static void main(String[] args) {
		Qspiders q=new Qspiders("ELP","Basavanagudi","Raj Sir");
				 q.setPhno("9483399216");
				 q.setFee(100000);
				 System.out.println(q.batch);
				 System.out.println(q.area);
				 System.out.println(q.trainer);
				 System.out.println(q.getPhno());
				 System.out.println(q.getFee());
				
	}

}
