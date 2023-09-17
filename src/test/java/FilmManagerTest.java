import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test
    public void testNoFilms() {
        FilmManager manager = new FilmManager();
        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }


    @Test
    public void testAddOneFilm() {
        FilmManager manager = new FilmManager();
        manager.newFilm("newFilm1");
        String[] actual = manager.findAll();
        String[] expected = {"newFilm1"};
        Assertions.assertArrayEquals(actual, expected);
    }


    @Test
    public void testAddFilms() {
        FilmManager manager = new FilmManager();
        manager.newFilm("newFilm1");
        manager.newFilm("2");
        manager.newFilm("Film3");
        String[] actual = manager.findAll();
        String[] expected = {"newFilm1", "2", "Film3"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testLastDefaultFilmsLess() {
        FilmManager manager = new FilmManager();
        manager.newFilm("newFilm1");
        manager.newFilm("2");
        manager.newFilm("Film3");
        String[] actual = manager.findLast();
        String[] expected = {"Film3", "2", "newFilm1"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testLastDefaultFilmsAbove() {
        FilmManager manager = new FilmManager();
        manager.newFilm("newFilm1");
        manager.newFilm("2");
        manager.newFilm("Film3");
        manager.newFilm("Film4");
        manager.newFilm("Film5");
        String[] actual = manager.findLast();
        String[] expected = {"Film5", "Film4", "Film3", "2", "newFilm1"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testLastFilmsAbove() {
        FilmManager manager = new FilmManager(2);
        manager.newFilm("newFilm1");
        manager.newFilm("2");
        manager.newFilm("Film3");
        String[] actual = manager.findLast();
        String[] expected = {"Film3", "2"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testLastFilmsLess() {
        FilmManager manager = new FilmManager(5);
        manager.newFilm("newFilm1");
        manager.newFilm("2");
        manager.newFilm("Film3");
        String[] actual = manager.findLast();
        String[] expected = {"Film3", "2", "newFilm1"};
        Assertions.assertArrayEquals(actual, expected);
    }
}

