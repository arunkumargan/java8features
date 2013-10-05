package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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


}
