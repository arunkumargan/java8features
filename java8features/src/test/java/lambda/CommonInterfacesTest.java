package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CommonInterfacesTest {

    @Test
    public void testConsumer() {
        List<Bot> bots = SampleBotsList.getSampleBots();

        bots.forEach(new Consumer<Bot>() {
            @Override
            public void accept(Bot bot) {
                System.out.println(bot.getName());
            }
        }) ;


        bots.forEach(bot -> System.out.println(bot.getName()));
    }

    @Test
    public void testSupplier() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        Optional<Bot> topBot = bots.stream().filter(bot -> bot.getRating() == 1).findFirst();
        topBot.orElseGet(new Supplier<Bot>() {
            @Override
            public Bot get() {
                return new Bot("nonexistent", "nonexistent", 0, 0);
            }
        });
        topBot.orElseGet(() -> new Bot("nonexistent", "nonexistent", 0, 0)) ;
    }

    @Test
    public void testPredicate() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        List<Bot> top5 = bots.stream().filter(new Predicate<Bot>() {
            @Override
            public boolean test(Bot bot) {
                return bot.getRating() <= 5  ;
            }
        }).collect(Collectors.toCollection(ArrayList::new));
//        top5 = bots.stream().filter(bot -> bot.getRating() <= 5).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(top5);
    }


    @Test
    public void testFunction() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        bots.stream().map(new Function<Bot, String>() {
            @Override
            public String apply(Bot bot) {
                return bot.getName() + ":" + bot.getAuthor();
            }
        }).collect(Collectors.toCollection(ArrayList::new));

        bots.stream().map(bot -> bot.getName() + ":" + bot.getAuthor()).collect(Collectors.toCollection(ArrayList::new));
    }
}
