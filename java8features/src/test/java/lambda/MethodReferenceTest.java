package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodReferenceTest {

    @Test
    public void referenceToStaticMethod() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        Collections.sort(bots, (bot1, bot2) -> (bot1.getRating() - bot2.getRating()));

        Collections.sort(bots, (bot1, bot2) -> (Bot.compareByRating(bot1, bot2)));
        Collections.sort(bots, Bot::compareByRating);
    }

    @Test
    public void referenceToInstanceMethod() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        List<String> botNames =
                bots.stream()
                        .map(bot -> bot.getName())
                        .collect(Collectors.toCollection(ArrayList::new));

        botNames.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name));

        botNames.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


    @Test
    public void constructorReference() {
        List<String> list1 = newList(LinkedList::new);
        List<String> list2 = newList(ArrayList::new);
        list2.add("one");
        list2.add("two");
        list2.forEach(System.out::println);
    }

    public <F, T> void transfer(Collection<F> source, Collection<T> dest) {

    }

    private <T> List<T> newList(Supplier<List<T>> supplier) {
        return supplier.get();
    }
}
