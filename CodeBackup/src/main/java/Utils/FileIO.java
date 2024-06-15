package Utils;

import java.io.*;

import java.nio.file.Paths;

import java.util.*;
/**
 *
 * <p> This class handles the FileIO for the program for
 * reading and writing files. The justification for it being static is that
 * the whole program needs it and it makes more sense for future usability if
 * every program can call the code directly rather than an object that HAS to
 * be made instead.
 * </p>
 *@author Brandon
 * **/
public class FileIO { // This class handles file IO and is mainly used
    // for making the highscore system work

    // Base path
    private static final String scores =
            Paths.get("src/main/resources/").toString() +
                    "/Highscores.json";

    /**
     * <p> This function makes a new file IFF a file doesnt already exists.
     * This means that the current file wont be
     * overwritten
     * </p>
     * @throws IOException - Possibility to fail to read or write in this
     * function
     * @return boolean - returns boolean on if the file is written (true) or
     * return boolean if the file isn't written/fileIO error (false) - Type
     * boolean
     * **/
    public static boolean MakeFile() throws IOException { // returns true if
        // file exists

        File file = new File(scores);
        try{
            return file.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * <p> This function gets the high score file path
     * </p>
     *
     * @return scores Returns the current path to the highscores file
     * - type String
     * **/
    public static String GetScores(){
        return scores;
    }

    /**
     * <p> This function appends a score to the highscores file.
     * </p>
     *
     * @param s Takes in a string to append to the file - Type String
     * @throws IOException - Possibility to fail to read or write in this
     * function
     * **/
    public static void Append(String s) throws IOException {

        FileWriter fileWriter = new FileWriter(scores,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        fileWriter.close();
    }
    /**
     * <p>
     *     This function adds a score to the current JSON high scores file.
     *     It takes in a JSON object and converts it
     *    to the formatting the file needs.</p>
     *
     * @param J Takes in a Json object from the custom Json_Game class.
     *         - Type Json_Game
     *
     * @throws IOException - Possibility to fail to read or write in this
     * function
     * **/
    public static void AddScore(Json_Game J) throws IOException {
        // Appends json score to already existing JSON file

        File file = new File(scores);
        Json_Game[] JJ = Json_Game.GrabData();

        ArrayList<Json_Game> J_arr_copy = new ArrayList<>(Arrays.asList(JJ));
        ArrayList<String> S = new ArrayList<>();

        J_arr_copy.add(J);

        S.add("{\n\t\"Data\" " + ":" +" \n\t\t [");

        for (Json_Game j : J_arr_copy){

            String f = "\n\t\t\t{" + "\"" +  j.GetM_name() + "\"" +" : " +
                    "\"" + Integer.toString(j.GetM_score()) +"\"" + "},";
            S.add(f);

        }

        boolean delete = file.delete();
        MakeFile();
        S.add("\n\t\t]\n}");

        for(String s: S){
            Append(s);
        }

    }


}
