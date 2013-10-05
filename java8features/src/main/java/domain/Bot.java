package domain;

public class Bot {
    private final String name;
    private final String author;
    private final int rating;
    private final int score;

    public Bot(String name, String author, int rating, int score) {
        this.name = name;
        this.author = author;
        this.rating = rating;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getScore() {
        return this.score;
    }

    public String toString() {
        return String.format("%d: '%s' by %s. Score: %d", this.rating, this.name, this.author, this.score);
    }
}
