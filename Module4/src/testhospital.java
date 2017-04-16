
public class testhospital {
public static void main(String[] args)
{
	//Hostipal h= new Hostipal();//  object cannot be defined for a class
	Fortis_hospital f= new Fortis_hospital();
	f.operate();
	f.doscan();
	f.dovaccination();
	f.phoneconsultation();
	System.out.println("----------------------");
	
	govthospital g= new govthospital();
	g.operate();
	g.doscan();
	g.dovaccination();
	//g.phoneconsultation();// Cannot be called from here 
	
	Hospital h= new Fortis_hospital();
	h.operate();
	h.doscan();
	h.dovaccination();
	//h.phoneconsultation();// this cannot be done 
	
	Hospital h1= new govthospital();
	h1.operate();
	h1= new Fortis_hospital();
	h1.operate();
	Hospital x= null;
	x= new govthospital();
	x.doscan();
	x= new Fortis_hospital();
	x.doscan();
	}
}
