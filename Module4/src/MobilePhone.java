
public class MobilePhone extends phone {/* this is known as Inheritance
 where it takes all of the functions from the parent class*/
public void roamfree()
{
	System.out.println("Mobile Free");
}
@Override//annotation
public void call()/* Concept of Overriding- 
where same function name is described in the child class.
When we call the function it will first see the function in child class
 and if it is not there inside the child class, than it will search in
  the parent class. */
{
	System.out.println("Mobile phone Calling");
}
}
