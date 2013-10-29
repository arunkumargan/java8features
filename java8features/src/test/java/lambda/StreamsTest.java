package lambda;

import domain.Bot;
import domain.SampleBotsList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {
    private List<Bot> bots;

    @Before
    public void setUp() {
        this.bots = SampleBotsList.getSampleBots();
    }

    @Test
    public void testStreamAndParallelStream() {
        bots.stream().forEach(System.out::println);
        System.out.println();
        bots.parallelStream().forEach(System.out::println);
    }

    @Test
    public void testFilter() {
       bots.stream()
                .filter(bot -> bot.getRating() <= 5)
                .forEach(System.out::println);
    }

    @Test
    public void testMap() {
        bots.stream()
                .map(bot -> bot.getAuthor())
                .forEach(System.out::println);

    }


    @Test
    public void testCollect() {
        List<String> authors = bots.stream()
                .map(bot -> bot.getAuthor())
                .collect(Collectors.toList());
        System.out.println("authors = " + authors);
    }
    @Test
    public void testCollectScore() {
        int totalScore = bots.stream()
                .mapToInt(Bot::getScore)
                .sum();
        System.out.println("totalScore = " + totalScore);
    }
}