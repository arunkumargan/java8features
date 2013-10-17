package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
                .forEach(name -> System.out.println(name));
    }


    @Test
    public void constructorReference() {

    }

    public <F, T> void transfer(Collection<F> source, Collection<T> dest) {

    }
}
