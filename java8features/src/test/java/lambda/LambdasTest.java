package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class LambdasTest {

    @Test
    public void test01IterateOverBotsAndSort() {
        List<Bot> bots = SampleBotsList.getSampleBots();

        System.out.println("Before :");
        for (Bot bot: bots) {
            System.out.println(bot);
        }

        Collections.sort(bots, new Comparator<Bot>() {
            @Override
            public int compare(Bot o1, Bot o2) {
                return o1.getRating() - o2.getRating();
            }
        });

        System.out.println("After :");
        for (Bot bot: bots) {
            System.out.println(bot);
        }
    }



    @Test
    public void test02IterateOverTheBotsWithLambdas() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        System.out.println("Before: ");
        bots.forEach(System.out::println);
        Collections.sort(bots, (bot1, bot2) -> (bot1.getRating() - bot2.getRating()));

        System.out.println("After : ");
        bots.forEach(System.out::println);
    }

    @Test
    public void test03NoParameterNoReturnTypeInterfacePreJava8() {
        Foo1 foo1 = new Foo1() {
            @Override
            public void doSomething() {
                System.out.println("Foo1: doSomething called");
            }
        }                                                      ;

        foo1.doSomething();
    }

    @Test
    public void test04NoParameterNoReturnTypeInterfaceWithJava8() {
        Foo1 foo1 = () -> System.out.println("Foo1: doSomething called");                                             ;
        foo1.doSomething();
    }

    @Test
    public void test05NoParameterNoReturnTypeInterfacePreJava8() {
        methodWithFoo1(new Foo1() {
            @Override
            public void doSomething() {
                System.out.println("Foo1: doSomething called");
            }
        });                                                      ;
    }

    @Test
    public void test06NoParameterNoReturnTypeInterfaceWithJava8() {
        methodWithFoo1(() -> System.out.println("Foo1: doSomething called"));                                                      ;
    }


    public void methodWithFoo1(Foo1 foo1) {
        foo1.doSomething();
    }

    @Test
    public void test07WithParamAndReturnTypePreJava8() {
        Foo2<Bot, Integer> foo2 = new Foo2<Bot, Integer>() {
            @Override
            public Integer doSomething(Bot bot) {
                return bot.getAuthor().length();
            }
        };
        Bot bot = SampleBotsList.getSampleBots().get(0);
        assertThat(foo2.doSomething(bot), equalTo(14));

        methodWithFoo2(new Foo2<Bot, Integer>() {
            @Override
            public Integer doSomething(Bot input) {
                return bot.getAuthor().length();
            }
        }, bot);
    }

    @Test
    public void test08WithParamAndReturnTypeWithJava8() {
        Foo2<Bot, Integer> foo2  = (input -> input.getAuthor().length());

        Bot bot = SampleBotsList.getSampleBots().get(0);
        assertThat(foo2.doSomething(bot), equalTo(14));

        methodWithFoo2(
                ((Bot input) -> {return input.getAuthor().length();}) ,
                bot);
    }


    public<I,O> O methodWithFoo2(Foo2<I, O> foo2, I input) {
       return foo2.doSomething(input);
    }
}
