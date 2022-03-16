/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.BufferedReader;
import java.io.File;
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

    public FileCSV(String fileName) throws IOException {
        this.fileName = fileName;
        File f = new File("utenti.csv");
        if (!f.exists()) {
            f.createNewFile();
        }
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
            FileWriter writer = new FileWriter(fileName, true);
            writer.append(c.id + ";" + c.username + ";" + p.getLat() + ";" + p.getLon() + "\n");
            writer.flush();
            writer.close();
        } else {
            List<Utente> listUtenti = getListUtenti();
            listUtenti.get(index).lat = p.getLat();
            listUtenti.get(index).lon = p.getLon();
            svuotaFile();
            FileWriter fw = new FileWriter(fileName, true);
            for (Utente u : listUtenti) {
                fw.append(u.chat_id + ";" + u.username + ";" + u.lat + ";" + u.lon + "\n");
            }
            fw.flush();
            fw.close();

        }
    }

    public void svuotaFile() throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("");
        writer.flush();
        writer.close();
    }
}
