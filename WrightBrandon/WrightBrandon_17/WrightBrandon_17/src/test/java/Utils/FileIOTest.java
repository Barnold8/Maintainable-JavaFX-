package Utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.io.*;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {
    //WARNING: Tests adds weird data to the highscores.json file
    @Test
    void makeFile() throws IOException {
        File f = new File(Paths.get("src/main/resources/")
                .toString() + "/Highscores.json");
        if(f.exists() && !f.isDirectory()) {
            assertFalse(FileIO.MakeFile());
        }else{
            assertTrue(FileIO.MakeFile());
        }

    }

    int FileCharCount(String fpath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fpath));
        String line = reader.readLine();
        int chars = 0;
        while(line != null){

            String[] charSet = line.split(" ");

            for(String word : charSet){
                chars += word.length();
            }

            line = reader.readLine();
        }
        return chars;
    }

    @Test
    void addScoreTest() throws IOException {
        String fpath = Paths.get("src/main/resources/")
                .toString() + "/Highscores.json";

        Json_Game J = new Json_Game("Foo",12);
        int start = FileCharCount(fpath);
        FileIO.AddScore(J);
        int end = FileCharCount(fpath);

        assertTrue(end > start);

    }
    @Test
    void append() throws IOException {

        String fpath = Paths.get("src/main/resources/")
                .toString() + "/Highscores.json";
        int chars = FileCharCount(fpath);
        FileIO.Append("FooBarABC");
        int newChars = FileCharCount(fpath);

        System.out.println(chars);
        System.out.println(newChars);
        assertTrue(newChars > chars);

    }

}