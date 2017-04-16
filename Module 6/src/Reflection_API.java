import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Reflection_API {
public static void main(String[] args) throws SecurityException , NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
{String x= "sampletext";
Method method= Reflection_API.class.getMethod(x,String.class);
method.invoke(method,"hello");
System.out.println("end");
}
public static void sampletext(String X)
{System.out.println("in Sample text " + X);
}
}
