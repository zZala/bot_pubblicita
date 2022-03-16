/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import telegramApi.Actions;
import telegramApi.JMessage.Result;

/**
 *
 * @author lazzarin_andrea
 */
public class ThreadUpdate extends Thread {

    String path;

    public ThreadUpdate() {

        this.path = "https://api.telegram.org/bot5206576723:AAEbpt72DyN3kVmftSdxmBqDap9WDs6rd7Q/getUpdates";
    }

    @Override
    public void run() {
        FileCSV csv = new FileCSV("utenti.csv");
        Actions a = new Actions();
        int last_update_id = 0;
        Result lastMessage;
        while (true) {
            try {
                lastMessage = a.getUpdates(path);
                if (lastMessage.update_id != last_update_id) {
                    last_update_id = lastMessage.update_id;
                    Place p;
                    if (lastMessage.message.location != null) {
                        p = new Place(lastMessage.message.location.latitude, lastMessage.message.location.longitude);
                        csv.writeUtente(lastMessage.message.chat, p);
                    } else if (lastMessage.message.text.contains("/paese ")) {
                        String temp[] = lastMessage.message.text.split(" ", 2);
                        String paese = temp[1];
                        OpenStreetMap op = new OpenStreetMap();
                        p = op.cercaPaese(paese);
                        csv.writeUtente(lastMessage.message.chat, p);
                    }
                    
                }
                Thread.sleep(1000);
            } catch (IOException | ParserConfigurationException | SAXException | InterruptedException ex) {
                Logger.getLogger(ThreadUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
