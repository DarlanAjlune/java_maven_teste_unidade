package br.inatel.cdg.csv;

import br.inatel.cdg.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static br.inatel.cdg.csv.Csv.readCsv;

public class TesteCsv {

    @Test
    public void testaLeituraCsv100Games() {
        String path = "src/main/resources/vendas-games.csv";
        List<Game> listGame = null;
        try {
            listGame = readCsv(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(100, listGame.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void testeLeituraCSVNaoExiste() throws FileNotFoundException {
        String path = "vendas-games.csv";
        List<Game> listGame = readCsv(path);

    }
}
