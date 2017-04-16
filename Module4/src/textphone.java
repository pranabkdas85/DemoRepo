public class textphone {
 public static void main(String[] args)
 {
	 MobilePhone m= new MobilePhone();
	 phone p= new phone();
	 
	 p.call(); // Here it calls the call function from the child class
	 p.voicemail();
	 
	 m.call();
	 m.voicemail();
	 m.roamfree();
		 smartphone s=new smartphone();
		 s.call();
 }
}
