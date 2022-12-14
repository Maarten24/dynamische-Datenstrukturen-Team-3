package de.hebk.menu.CSVReader;

import de.hebk.game.Questions;
import de.hebk.model.list.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    /**
     * Attribute
     */
    String path = "src/main/java/de/hebk/menu/CSVReader/Questions.csv";

    /**
     * Konstruktor für CSVReader
     */
    public CSVReader() {
        loadFile(path);
    }

    /**
     * Diese Methode liest die CSV-Datei mit den Fragen, indem sie jede Zeile der Datei durchgeht und einer Liste hinzufügt.
     * @param path Dateipfad
     * @return Zurückgegebene Liste
     */
    public List<Questions> loadFile(String path) {
        File file = new File(path);
        List<Questions> list = new List<Questions>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                int id = Integer.parseInt(array[0]);
                int diff = Integer.parseInt(array[1]);
                list.append(new Questions(id,diff,array[2],array[3],array[4],array[5],array[6]));
                String ret = "ID: " + id + " Schwierigkeit: " + diff + " Frage: " + array[2] + " Antworten: " + array[3] + " " + array[4] + " " + array[5] + " " + array[6];
                System.out.println(ret);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public String getPath() {
        return this.path;
    }
}
