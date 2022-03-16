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
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import telegramApi.JMessage.Result;

/**
 *
 * @author zzala
 */
public class Actions {

    public Actions() {
    }

    public Result getUpdates(String jsonS) throws IOException {

        URL fileUrl = new URL(jsonS);
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");

        String content = inRemote.next();

        String stringJson = content;
        JMessage messages = new Gson().fromJson(content, JMessage.class);

        System.out.println(messages.result.get(messages.result.size() - 1));
        return messages.result.get(messages.result.size() - 1);
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
