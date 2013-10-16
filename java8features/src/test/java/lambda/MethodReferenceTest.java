package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class MethodReferenceTest {

    @Test
    public void iterateOnBotsTest() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        bots.forEach(bot -> System.out.println(bot));
        bots.forEach(System.out::println);
    }

    @Test
    public void sortByPersonRatingTest() {
        List<Bot> bots = SampleBotsList.getSampleBots();
        Collections.sort(bots, (bot1, bot2) -> (bot1.getRating() - bot2.getRating()));

        Collections.sort(bots, (bot1, bot2) -> (Bot.compareByRating(bot1, bot2)));
        Collections.sort(bots, Bot::compareByRating);
    }
}
