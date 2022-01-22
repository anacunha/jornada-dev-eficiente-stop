package com.deveficiente.stop.room;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

public class CreateRoomRequest {

    @Positive
    @Max(12)
    private final int rounds;

    @Positive
    @Max(12)
    private final int players;

    private final String password;

    // categories.size() == rounds
    // Re-use existing categories
    // Single word
    @NotEmpty
    private final List<String> categories;

    // A - Z
    @NotEmpty
    private final List<Character> letters;

    public CreateRoomRequest(final int rounds,
                             final int players,
                             final String password,
                             final List<String> categories,
                             final List<Character> letters) {
        this.rounds = rounds;
        this.players = players;
        this.password = password;
        this.categories = categories;
        this.letters = letters;
    }

    public List<Character> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        return "CreateRoomRequest{" +
                "rounds=" + rounds +
                ", players=" + players +
                ", password='" + password + '\'' +
                ", categories=" + categories +
                ", letters=" + letters +
                '}';
    }
}
