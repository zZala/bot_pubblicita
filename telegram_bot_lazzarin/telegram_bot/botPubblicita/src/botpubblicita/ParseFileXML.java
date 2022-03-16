/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author lazzarin_andrea
 */
public class ParseFileXML {

    String filename;

    public ParseFileXML(String filename) {
        this.filename = filename;
    }

    public List parseDocumentPlace() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, element;
        NodeList nodelist;

        Document document;

        factory = DocumentBuilderFactory.newDefaultInstance();
        builder = factory.newDocumentBuilder();

        document = (Document) builder.parse(filename);
        root = document.getDocumentElement();

        nodelist = root.getElementsByTagName("place");
        List lista = new ArrayList<Place>();

        for (int i = 0; i < nodelist.getLength(); i++) {

            lista.add(parseObject(nodelist.item(i)));
        }

        return lista;
    }

    public Place parseObject(Node o) {
        Place m = new Place(o);
        return m;
    }
}
