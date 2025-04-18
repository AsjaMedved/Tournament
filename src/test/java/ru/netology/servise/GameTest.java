package ru.netology.servise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Alice", 100);
    Player player2 = new Player(2, "Bob", 90);
    Player player3 = new Player(3, "Charlie", 100);
    Player player4 = new Player(4, "Diana", 110);

    @Test
    public void shouldReturn1IfFirstPlayerIsStronger() {
        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");

        assertEquals(1, result);
    }

    @Test
    public void shouldReturn2IfSecondPlayerIsStronger() {
        game.register(player1);
        game.register(player4);

        int result = game.round("Alice", "Diana");

        assertEquals(2, result);
    }

    @Test
    public void shouldReturn0IfPlayersEqualStrength() {
        game.register(player1);
        game.register(player3);

        int result = game.round("Alice", "Charlie");

        assertEquals(0, result);
    }

    @Test
    public void shouldThrowExceptionIfFirstPlayerNotRegistered() {
        game.register(player2);

        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );

        assertEquals("Игрок Alice не зарегистрирован", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfSecondPlayerNotRegistered() {
        game.register(player1);

        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );

        assertEquals("Игрок Bob не зарегистрирован", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfBothPlayersNotRegistered() {
        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );

        assertEquals("Игрок Alice не зарегистрирован", exception.getMessage());
    }
}



