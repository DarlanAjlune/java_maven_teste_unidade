package br.inatel.cdg;

import br.inatel.cdg.game.Game;

import java.io.FileNotFoundException;
import java.util.List;

import static br.inatel.cdg.csv.Csv.readCsv;
import static br.inatel.cdg.filter.Filter.*;

public class Main {
    public static void main(String[] args) {

        String path = "src/main/resources/vendas-games.csv";
        List<Game> listaTodosGames = null;
        try {
            listaTodosGames = readCsv(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Lista de todos os jogos presentes no CSV fornecido");
        listaTodosGames.forEach(umGame -> System.out.println(umGame.toString()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Lista de jogos da plataforma Wii");
        filterPlataforma(listaTodosGames, "Wii").forEach(umGameWii -> System.out.println(umGameWii.toString()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Lista de jodos da editora Ubisoft");
        filterEditor(listaTodosGames, "Ubisoft").forEach(umGameUbisoft -> System.out.println(umGameUbisoft.toString()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Maior venda global da editora Ubisoft feita para a plataforma Wii");
        System.out.println(filterMaiorVendaGlobal(filterEditor(filterPlataforma(listaTodosGames, "Wii"), "Ubisoft")));

    }
}
