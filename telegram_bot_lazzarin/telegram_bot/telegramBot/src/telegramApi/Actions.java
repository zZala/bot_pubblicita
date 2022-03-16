/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramApi;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import telegramApi.JMessage.Result;

/**
 *
 * @author lazzarin_andrea
 */
public class Actions {

    private int lastUpdateId;
    public Actions() {
        this.lastUpdateId=-1;
    }

    public Result getUpdates(String jsonS) throws IOException {

        URL fileUrl = new URL(jsonS);
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");

        String content = inRemote.next();

        String stringJson = content;
        JMessage messages = new Gson().fromJson(content, JMessage.class);
        
        if (messages.ok && messages.result.size() != 0) {
            if (lastUpdateId == -1) {
                lastUpdateId = messages.result.get(messages.result.size() - 1).update_id;
            } else if (messages.result.size() == 0) {
                //nessun messaggio
            } else if (messages.result.get(messages.result.size() - 1).update_id <= lastUpdateId) {
                //nessun messaggio nuovo
            } else {
                lastUpdateId++;
                return messages.result.get(messages.result.size() - 1);
            }
        }
        return null;
    }

    public void sendMessage(int idDestinatario, String testo) throws MalformedURLException, IOException {
        String url = "https://api.telegram.org/bot5206576723:AAEbpt72DyN3kVmftSdxmBqDap9WDs6rd7Q/sendMessage?";
        String path = "chat_id=" + idDestinatario + "&text=" + URLEncoder.encode(testo, "UTF-8");
        url += path;
        URL fileUrl = new URL(url);
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");

        String content = inRemote.next();
        inRemote.close();
    }

}
