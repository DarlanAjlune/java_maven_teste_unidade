package br.inatel.cdg.csv;

import br.inatel.cdg.game.Game;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class Csv {

    public static List<Game> readCsv(String path) throws FileNotFoundException {
        List<Game> listaTodosGames = new CsvToBeanBuilder(new FileReader(path))
                .withType(Game.class)
                .build()
                .parse();

        return listaTodosGames;
    }

}
