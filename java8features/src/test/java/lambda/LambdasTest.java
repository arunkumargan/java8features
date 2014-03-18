package lambda;

import domain.Bot;
import domain.Condition;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class LambdasTest {

    @Test
    public void test00TasteOfLambdas() {
//        List<Bot> subset = SampleBotsList.getSubset(new Predicate<Bot>() {
//            @Override
//            public boolean test(Bot bot) {
//                return bot.getRating() <= 2;
//            }
//        });
//
//        subset.forEach(new Consumer<Bot>() {
//            @Override
//            public void accept(Bot bot) {
//                System.out.println(bot);
//            }
//        });

        List<Bot> subset = SampleBotsList.getSubset(bot -> bot.getRating() <= 2);

        subset.forEach(System.out::println);



    }




    @Test
    public void test01IterateOverBotsAndSort() {
        List<Bot> bots = SampleBotsList.getSampleBots();

        System.out.println("Before :");
        for (Bot bot: bots) {
            System.out.println(bot);
        }

        Comparator<Bot> botComparator = new Comparator<Bot>() {
            @Override
            public int compare(Bot b1, Bot b2) {
                return b1.getRating() - b2.getRating();
            }
        };

        Collections.sort(bots, botComparator);

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

        Collections.sort(bots, (b1, b2) -> b1.getRating() - b2.getRating());

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
        } ;

        foo1.doSomething();
    }

    @Test
    public void test04NoParameterNoReturnTypeInterfaceWithJava8() {
        Foo1 foo1 = () -> System.out.println("Foo1: doSomething called");
        foo1.doSomething();
    }

    @Test
    public void test05NoParameterNoReturnTypeInterfacePreJava8() {
        methodWithFoo1(new Foo1() {
            @Override
            public void doSomething() {
                System.out.println("Foo1: doSomething called");
            }
        });
    }

    @Test
    public void test06NoParameterNoReturnTypeInterfaceWithJava8() {
        methodWithFoo1(() -> System.out.println("Foo1: doSomething called"));
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

        methodWithFoo2(((Bot input) -> {return input.getAuthor().length();}), bot);
    }

    @Test
    public void test09Closures() {
        Supplier<String> supplier = SampleBotsList.supplier();

        System.out.println(supplier.get());
        SampleBotsList.buffer.append(" world");
        System.out.println(supplier.get());

    }


    public<I,O> O methodWithFoo2(Foo2<I, O> foo2, I input) {
       return foo2.doSomething(input);
    }
}
