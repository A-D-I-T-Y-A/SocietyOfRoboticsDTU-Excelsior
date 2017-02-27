package org.srdtu.srdtu;

/**
 * Created by Aditya on 1/26/2017.
 */

public class EventCode {

    public EventCode(){

    }

    public static String getCode(String s){

        switch(s){
            case "Bend it like Asimove (Robot Soccer)":
                return "Bend";

            case "Botzilla (Robot War)":
                return "Botzilla";

            case "Bomb Barrage":
                return "Bomb";

            case "Chasing a Mirage (Laser Maze)":
                return "Chasing";

            case "Code Safari":
                return "Code";

            case "Crack the Company":
                return "Crack";

            case "Creating Talks":
                return "Creating";

            case "Eureka (Research Paper)":
                return "Eureka";

            case "Fast'17 (Robot Race)":
                return  "Fast";

            case "Fastest Line Follower (LFR)":
                return "Fastest";

            case "IC ART":
                return "IC";

            case "Java Derby":
                return "Java";

            case "Mock Stock":
                return "Mock";

            case "Quidditch":
                return "Quidditch";

            case "Quizzards":
                return "Quizzards";

            case "Silicon Valley":
                return "Silicon";

            case "Simulate One, Complete One":
                return "Simulate";

            case "Pull it that way":
                return "Pull";

            default:
                return "Err";
        }
    }
}
