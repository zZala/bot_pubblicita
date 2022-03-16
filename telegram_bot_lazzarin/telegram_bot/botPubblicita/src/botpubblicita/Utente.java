/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

/**
 *
 * @author lazzarin_andrea
 */
public class Utente {

    int chat_id;
    String username;
    Double lat, lon;

    public Utente(int chat_id, String username, Double lat, Double lon) {
        this.chat_id = chat_id;
        this.username = username;
        this.lat = lat;
        this.lon = lon;
    }

    public Utente(String line) {
        String[] campi = line.split(";");
        this.chat_id = Integer.parseInt(campi[0]);
        this.username = campi[1];
        this.lat = Double.parseDouble(campi[2]);
        this.lon = Double.parseDouble(campi[3]);;
    }

}
