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
        Collections.sort(bots, (bot1, bot2) -> (Bot.compareByRating(bot1, bot2)));
    }

    @Test
    public void referenceToInstanceMethod() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        bots.stream()
            .map(bot -> bot.getName())
            .forEach(name -> System.out.println(name));
    }


    @Test
    public void constructorReference() {
        List<String> list1 = newList(() -> new LinkedList());
        List<String> list2 = newList(() -> new ArrayList<>());
        list2.add("one");
        list2.add("two");
        list2.forEach(System.out::println);
    }

    private <T> List<T> newList(Supplier<List<T>> supplier) {
        return supplier.get();
    }
}
