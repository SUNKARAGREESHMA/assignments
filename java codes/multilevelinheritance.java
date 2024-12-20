package JAVA_FULLSTACK;

class vehicle{
	int nofwheels;
	String brand;
	public vehicle(int nofwheels, String brand) {
		super();
		this.nofwheels = nofwheels;
		this.brand = brand;
	}
	
	public void vehicleinfo() {
		System.out.println("vehicle"+nofwheels);
	}
}

class car extends vehicle{
int makingyear;
	public car(int nofwheels, String brand,int makingyear) {
		super(nofwheels, brand);
		// TODO Auto-generated constructor stub
		this.makingyear=makingyear;
	}
	public void carinfo() {
		System.out.println("making year is"+makingyear);
		
	}
}

class ev extends car{
	int batterycapacity;

	public ev(int nofwheels, String brand, int makingyear,int batterycapacity) {
		super(nofwheels, brand, makingyear);
		// TODO Auto-generated constructor stub
		this.batterycapacity=batterycapacity;
	}
	
	public void evinfo() {
		System.out.println("battery capacity is"+batterycapacity);
	}
	
}




public class multilevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ev tesla=new ev(4,"tesla",1997,78);
         tesla.evinfo();
         tesla.carinfo();
         tesla.vehicleinfo();
	}

}
