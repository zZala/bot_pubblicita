/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import telegramApi.JMessage.Chat;

/**
 *
 * @author lazzarin_andrea
 */
public class FileCSV {

    String fileName = "";

    public FileCSV(String fileName) {
        this.fileName = fileName;
    }

    public List<Utente> getListUtenti() throws FileNotFoundException, IOException {
        List<Utente> listUtenti = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = br.readLine()) != null) //returns a Boolean value  
        {
            listUtenti.add(new Utente(line));
        }
        return listUtenti;
    }

    public int checkUtente(int id) throws IOException {
        List<Utente> listUtenti = getListUtenti();
        for (int i = 0; i < listUtenti.size(); i++) {
            if (listUtenti.get(i).chat_id == id) {
                return i;
            }
        }
        return -1;
    }

    public void writeUtente(Chat c, Place p) throws IOException {
        int index = checkUtente(c.id);
        if (index == -1) {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.append(c.id + ";" + c.username + ";" + p.getLat() + ";" + p.getLon() + "\n");
                writer.flush();
            }
        } else {
            List<Utente> listUtenti = getListUtenti();
            listUtenti.get(index).lat = p.getLat();
            listUtenti.get(index).lon = p.getLon();
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("");
                for (Utente u : listUtenti) {
                    writer.append(u.chat_id + ";" + u.username + ";" + u.lat + ";" + u.lon + "\n");
                }
                writer.flush();
            }
        }
    }
}
