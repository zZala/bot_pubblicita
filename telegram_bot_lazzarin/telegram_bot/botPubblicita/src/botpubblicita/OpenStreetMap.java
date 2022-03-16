/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author lazzarin_andrea
 */
public class OpenStreetMap {

    public OpenStreetMap() {
    }

    public Place cercaPaese(String paese) throws MalformedURLException, UnsupportedEncodingException, IOException, ParserConfigurationException, SAXException {
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(paese, "UTF-8") + "&format=xml&addressdetails=1");

        Scanner inRemote = new Scanner(url.openStream());
        inRemote.useDelimiter("\u001a");

        String content = inRemote.next();
        PrintWriter wr = new PrintWriter("out.xml");
        wr.write(content);
        wr.close();
        inRemote.close();

        ParseFileXML xml = new ParseFileXML("out.xml");
        Place p = (Place) xml.parseDocumentPlace().get(0);
        return p;
    }

}
