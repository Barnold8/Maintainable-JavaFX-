package Utils;


import MVC.SnakeModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * <p>
 *     This class implements the JSON functionality that is needed for parsing
 *     levels and high scores
 * </p>
 *@author Brandon
 * **/
public class Json_Game implements Comparable<Json_Game> {
    // No default lib exists for JSON so im making it myself
    /**
     * <p>
     *     Returns the name of the player in the JSON object
     * </p>
     * @return m_name Returns the m_name variable - Type String
     * **/
    public String GetM_name(){
        return m_name;
    }
    /**
     * <p>
     *     Returns the score of the player in the JSON object
     * </p>
     * @return m_score Returns player score - Type int
     * **/
    public int GetM_score(){
        return m_score;
    }
    /**
     * <p>
     *     This function sets the name of the player in the JSON object
     * </p>
     * @param n Takes in string to set as the player name - Type String
     * **/
    public void SetM_name(String n){
        m_name = n;}
    /**
     * <p>
     *     This function sets the score of the player in the JSON object
     * </p>
     *
     * @param n Takes in an int to set as the player score - Type int
     * **/
    public void SetM_score(int n){
        m_score = n;
    }
    private String m_name;
    private int m_score;
    /**
     *
     * <p>
     *     This function sets the score in the JSON object based on the
     *     string given
     * </p>
     * @param s Takes in a string to set the score with. - Type String
     * @return J Returns a Json_Game object - Type Json_Game
     * **/
    private static Json_Game strToJsonScore(String s){
        int LENGTHBOUND = 2;
        Json_Game J = new Json_Game();
        String[] elements = s.split(":");
        if(elements.length != LENGTHBOUND){return null;}
        J.SetM_name(elements[0]);
        J.SetM_score(Integer.parseInt(elements[1]));

        return J;
    }
    /**
     *
     * <p>
     *     This function returns a json object that uses the name
     *     variable as the level path.
     * </p>
     * @param s Takes in a string which is used as the file path
     *         - Type String
     * @return J Returns a JSON object - Type Json_Game
     * **/
    private static Json_Game strToJsonLevelDat(String s){

        Json_Game J = new Json_Game();
        J.SetM_name(s);

        return J;
    }
    /**
     *
     * <p>
     *     This default constructor sets the variables of the object
     *     to the default values expected for their types
     * </p>
     *
     * **/
    public Json_Game(){

        m_name = null;
        m_score = 0;

    }

    /**
     * <p>
     *     This default constructor sets the
     *     variables of the object to the default values expected for their
     *     types
     * </p>
     * @param x Takes in string x to set the my_name string but keep the
     *          m_score default - type String
     * **/
    public Json_Game(String x){

        m_name = x;
        m_score = 0;

    }
    /**
     *
     * <p>
     *     This constructor enforces the object to have a name and a score
     * </p>
     * @param x Takes in String x to set the m_name variable - Type String
     * @param y Takes in an int to set the m_score variable - Type int
     *
     * **/
    public Json_Game(String x, int y){

        m_name = x;
        m_score = y;

    }
    /**
     *
     * <p>
     *     This function constructs a string based off of the JSON
     *     object passed into it for easy processing
     * </p>
     *
     * @param j Takes in a Json object to construct into a string
     *         - Type Json_Game
     * @return new String Returns a string based on the JSon object
     * - Type String
     * **/
    public static String ConstrJsonCons(Json_Game j){ // turns JSON
        // object to string
        // constant
        return new String("\"" +j.GetM_name() + "\"" + " : "+ "\""
                +j.GetM_score() +
                "\"" );
    }
    /**
     *
     * <p>
     *     This function constructs a String based on the string passed in to
     *     it, This is used to append dats to the
     *     file without having to add more code to do simple tasks
     * </p>
     * @param inner Takes in a string to set the array for the JSON object
     * @param outer Takes in a string to set the outer section of the JSON
     *             object
     * @return data Returns a string containing the entire object - Type String
     * **/
    public static String ConstructJSON(String outer, Json_Game[] inner){ //
        // constructs
        // simple one dict json string
        String formatStr = "\n \""+outer+ "\" :";
        StringBuffer d =  new StringBuffer();
        int TCOUNT = 2;
        StringBuffer data = new StringBuffer("{ " +  formatStr + "\n \t\t[\n");

        for(int i = 0; i < inner.length-1 ;i ++){

            for(int y = 0; y < TCOUNT+1; y++){
                data.append("\t");
            }
            data.append("{ "+ ConstrJsonCons(inner[i]) + " },\n");

        }
        data.append("\t\t\t{ "+ ConstrJsonCons(inner[inner.length-1]) + " }\n");
        return data + "\t\t]\n}";

    }

    /**
     *
     * <p>
     *     This function returns a boolean on if the Json string data is
     *     valid or not
     * </p>
     * @param line - Takes in a string to check against. Type - String
     * @return booleanType - Returns a boolean on if the Json string is
     * valid or not - Type boolean
     * **/
    private static boolean jsonSanitise(String line){ // ensures sanitised
        // strings only via boolean return type
        // if string has : and not [ or ]
        return line.indexOf(':') != -1
                && line.indexOf('[') == -1 && line.indexOf(']') == -1;
    }

    /**
     * <p>
     *     This function adds a Json object to the an already existing
     *     Json object array.It takes in the JSon
     *     array, makes an arraylist and append the new object to the
     *     arraylist and then copy that data to a Jsonp[]
     *     array.
     * </p>
     * @param J Takes in a Json_Game object to add to the arraylist - Type
     *          Json_Game
     * @param J_arr Takes in a Json_Game array to append to -
     *              Type Json_Gamep[]
     * @return Array Returns the array with the added object -
     * type Json_Game[]
     *
     * **/
    public static Json_Game[] AddObject(Json_Game[] J_arr, Json_Game J){ // Add
        // JSON_Game
        // element to
        // JSON_Game[] array

        ArrayList<Json_Game> J_arr_copy = new ArrayList<>(Arrays.asList(J_arr));
        J_arr_copy.add(J);
        return J_arr_copy.toArray(new Json_Game[J_arr_copy.size()]);
    }
    /**
     * <p>
     *     This function cleans the string passed in it so it
     *     isnt read as pure json data but its string equivalent
     * </p>
     * @param s Takes in a string to parse - Type String
     * @return s Returns the cleaned string - Type String
     * **/

    private static String cleanStr(String s){
        String clean = s;
        s = s.replace("\t","");
        s = s.replace(",","");
        s = s.replace("{","");
        s = s.replace("}","");
        s = s.replace("\"","");
        s = s.replace(" ","");
        return s;
    }
    /**
     * <p>
     *     This function grabs the highscore data from the highscore
     *     file to process on the highscore screen.
     * </p>
     * @return Array Returns an array of json objects based on the high score
     * data - Type Json_Game[]
     * **/
    public static Json_Game[] GrabData(){ // Reads JSON data from
        // file and constructs JSON_Game[] array off of that data

        BufferedReader reader;
        ArrayList<Json_Game> J = new ArrayList<>();

        try{

            reader = new BufferedReader(new FileReader(FileIO.GetScores()));
            String line = reader.readLine();

            while(line != null ){

                if(jsonSanitise(line)) {
                    line = cleanStr(line);

                    J.add(strToJsonScore(line));
                }
                line = reader.readLine();
            }
            reader.close();

        }
        catch(IOException e){e.printStackTrace();}

        J.remove(0);
        return J.toArray(new Json_Game[J.size()]);
    }
    /**
     * <p>
     *     This function handles the level data
     * </p>
     * @param model Takes SnakeModel to get the level path
     * @return Array Returns an array of json objects based on the level data
     *  - Type Json_Game[]
     * **/

    public static Json_Game[] GrabData(SnakeModel model){

        // for some reason string path thing goes funky in here
        BufferedReader reader;
        ArrayList<Json_Game> J = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(
                    // Some weird java thing putting a \ infront of file
                    // This fixes that
                    model.GetM_levelPath().substring(6)
                    //model.GetM_levelPath()
            ));

            String line = reader.readLine();

            while(line != null ){

                if(jsonSanitise(line)) {
                    line = cleanStr(line);
                    J.add(strToJsonLevelDat(line));
                }
                line = reader.readLine();
            }
            reader.close();

        }
        catch(Exception e){ // IOException e
            System.out.println("Couldnt load level "+model.GetM_levelPath());
            e.printStackTrace();
        }
        System.out.println(J);
        //J.remove(0);
        return J.toArray(new Json_Game[J.size()]);
    }
    /**
     * <p>
     *     This function returns the sorted list of JSon high scores so the
     *     highscore screen shows the
     *     descending order of top scores
     * </p>
     * @return JJ Returns a sorted list of Json objects - List &lt;Json_Game&gt;
     * **/
    public static List<Json_Game> GetSorted(){


        List<String> scores = new ArrayList<>();
        Json_Game[] Jarr = Json_Game.GrabData();
        List<Json_Game> JJ = Arrays.asList(Jarr);
        Collections.sort(JJ);
        Collections.reverse(JJ);


        return JJ;
    }

    /**
     *
     * <p>
     *     This function constructs the levels based on the JSon data parsed
     *     into them.
     * </p>
     * @param data Takes in a json array to construct the levels off of
     *             the data there - type Json_Game[]
     * @return end_data Returns the constructed level data -
     * Type ArrayList &lt;String[]&gt;
     * **/
    public static ArrayList<String[]> ConstLvlDat(Json_Game[] data){
        ArrayList<String[]> end_data = new ArrayList<>();
        String[] tempstr;
        for(Json_Game d: data){

            tempstr = (d.GetM_name().split(":"));
            tempstr = Arrays.copyOfRange(tempstr, 1, tempstr.length);
            if(tempstr.length != 0){
                tempstr[0] = tempstr[0].replace("x","");
                tempstr[1] = tempstr[1].replace("y","");
                end_data.add(tempstr);
            }
        }

        return end_data;
    }
    /**
     *
     * <p>
     *     This overriden funtion is used for sorting lists based on basic
     *     logic implemented within the function
     * </p>
     * @param o Takes a Json object to compare the score to another object
     * **/

    @Override
    public int compareTo(Json_Game o) {

        return Integer.compare(this.m_score, o.m_score);
    }
}
