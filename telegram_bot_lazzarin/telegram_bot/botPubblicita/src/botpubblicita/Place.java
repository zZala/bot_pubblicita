/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author lazzarin_andrea
 */
public class Place {

    private String display_name;
    private double lat, lon;

    public Place(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Place(Node node) {
        Element e = (Element) node;
        this.display_name = e.getAttribute("display_name");
        this.lat = Double.parseDouble(e.getAttribute("lat"));
        this.lon = Double.parseDouble(e.getAttribute("lon"));
    }

    

    public String getDisplay_name() {
        return display_name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
