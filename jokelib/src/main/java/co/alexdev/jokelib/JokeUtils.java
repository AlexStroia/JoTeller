package co.alexdev.jokelib;

import java.util.Random;

public class JokeUtils {

    private final static String[] mJokes = new String[]{"Boy complains to his father: You told me to put a potato in my swimming trunks! You said it would impress the girls at the pool! But you forgot to mention one thing!" + "\n" + "Father: Really, what?" + " \n" + "Boy: That the potato should go in the front.",
            "My old aunts would come and tease me at weddings, “Well Sarah? Do you think you'll be next?” - We've settled this quickly once I've started doing the same to them at funerals.",
            "A mother asks her son: Anton, do you think I'm a bad mom?" + "\n" + " - Son: My name is Paul.",
            "An eskimo brings his friend to his home for a visit. When they arrive, his friend asks, puzzled" + "\n" + " – “So where's your igloo?” - The friend replies: " + "\n" + " “Oh no, I must've left the iron on…”",
            "Doctor: You're obese." + "\n" + " - Patient: For that I definitely want a second opinion." + "\n" + " - Doctor: You're quite ugly, too. ",
            "A husband and a wife sit at the table, having dinner. The woman drops a bit of tomato sauce on her white top." + "\n" + " Oh no, I look like a pig! The man nods, And you dropped tomato sauce on your top!",};

    public static String loadJoke() {
        Random random = new Random();

        int toSize = random.nextInt(mJokes.length);
        return mJokes[toSize];
    }
}
