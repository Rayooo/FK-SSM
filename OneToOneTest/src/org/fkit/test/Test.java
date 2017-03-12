import org.fkit.domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ray on 2017/3/12.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("org.fkit.domain.Person");
        System.out.println(c.getMethods());

        Object obj = c.newInstance();
        Method method = c.getMethod("setName", new Class[]{String.class});
        Object result = method.invoke(obj, new Object[] {"aaA"});
        System.out.println(result);

        Method method1 = c.getMethod("getName");
        Object obj1 = method1.invoke(obj);
        System.out.println(obj1);
    }
}
