
public class exercise1 {

		public static void main(String[] a){
		A a1 = new B();
		a1.meth1();
		a1.meth2();
		a1.meth3();
		//a1.meth4();
		}


		interface A{
		public void meth1();
		public void meth2();
		public void meth3();
		}



		class B implements A{

		@Override
		public void meth1() {
		System.out.println("meth1");
		}
		@Override
		public void meth2() {
		System.out.println("meth2");
		}
		@Override
		public void meth3() {
		System.out.println("meth3");
		}
		public void meth4() {
		System.out.println("meth4");
		}
		}
}