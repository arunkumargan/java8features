package lambda;

import domain.Bot;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class ParameterNameDiscoveryTest {

    @Test
    public void discoverMethodAndConstrutorParameters() throws  Exception{
        Class<Bot> clazz = Bot.class;
        Constructor ctor = clazz.getConstructor(String.class, String.class, int.class, int.class);
        Parameter[] ctorParameters =ctor.getParameters();

        for (Parameter param: ctorParameters) {
            System.out.println(param.isNamePresent() + ":" + param.getName());
        }
    }
}
