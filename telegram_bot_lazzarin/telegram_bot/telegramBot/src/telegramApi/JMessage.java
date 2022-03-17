/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramApi;

import java.util.ArrayList;

/**
 *
 * @author lazzarin_andrea
 */
public class JMessage {

    public boolean ok;
    public ArrayList<Result> result;

    public class From {

        public int id;
        public boolean is_bot;
        public String first_name;
        public String last_name;
        public String username;
        public String language_code;
    }

    public class Chat {

        public int id;
        public String first_name;
        public String last_name;
        public String username;
        public String type;
    }

    public class Entity {

        public int offset;
        public int length;
        public String type;
    }

    public class Location {

        public double latitude;
        public double longitude;
    }

    public class Message {

        public int message_id;
        public From from;
        public Chat chat;
        public int date;
        public String text;
        public ArrayList<Entity> entities;
        public Location location;
    }

    public class Result {

        public int update_id;
        public Message message;

    }
}
