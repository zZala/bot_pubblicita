/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import telegramApi.*;

/**
 *
 * @author palazzolo_thomas
 */
public class botPubblicita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, MalformedURLException, UnsupportedEncodingException, ParserConfigurationException, SAXException {
        // TODO code application logic here
        final String baseUrl = "https://api.telegram.org/bot";
        final String token = "5206576723:AAEbpt72DyN3kVmftSdxmBqDap9WDs6rd7Q/";

        ThreadUpdate tu=new ThreadUpdate();
        tu.start();
    }

}
