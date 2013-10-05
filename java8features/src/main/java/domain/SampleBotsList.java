package domain;

import java.util.Arrays;
import java.util.List;

public abstract class SampleBotsList {
    public static List<Bot> getSampleBots() {
        return Arrays.asList(
                new Bot("SeafarerRobot", "Biju Kunjummen",             4,  9232  ),
                new Bot("Dreamer",       "Rick Ryker",                 8,  5129  ),
                new Bot("DrunkenBoxer",  "Courtney & Courtland Jones", 3,  11428 ),
                new Bot("Dandroid",      "Dan Gradl",                  5,  7896  ),
                new Bot("Karolos",       "Chuck Eastus",               1,  21772 ),
                new Bot("Schizoid",      "Michael Dowden",             6,  6428  ),
                new Bot("TaggartBot",    "Don Taggart",                2,  12870 ),
                new Bot("AggressiveBot", "Michael Slattery",           7,  5779  )
        );
    }
}
