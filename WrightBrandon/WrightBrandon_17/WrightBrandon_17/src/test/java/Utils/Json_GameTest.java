package Utils;

import MVC.SnakeModel;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class Json_GameTest {

    int charCount(String s,char check){

        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == check) {
                x++;
            }
        }
        return x;
    }
    @Test
    void constrJsonConsTest1() {
        Json_Game J = new Json_Game();
        assertNotNull(Json_Game.ConstrJsonCons(J));
    }
    @Test
    void constrJsonConsTest2() {
        Json_Game J = new Json_Game();
        String output = Json_Game.ConstrJsonCons(J);
        int leftBracket = output.indexOf("{");
        int rightBracket = output.indexOf("}");
        int colonLocale = output.indexOf(":");
        assertTrue(leftBracket == -1
                && rightBracket == -1 && colonLocale != -1);
    }

    @Test
    void constructJSON() {
        Json_Game[] jsonARR = {
                new Json_Game("A",3),
                new Json_Game("B",22),
                new Json_Game("C")
        };
        String output = Json_Game.ConstructJSON("Something",jsonARR);

        boolean colCount = charCount(output,':') == jsonARR.length +1;
        boolean leftBrackCount = charCount(output,'{')
                ==  jsonARR.length +1;

        boolean rightBrackCount = charCount(output,'}')
                ==  jsonARR.length +1;
        boolean opSqL =  charCount(output,'[') == 1;
        boolean opSqR =  charCount(output,']') == 1;

        assertTrue(colCount && leftBrackCount
        && rightBrackCount && opSqL && opSqR);
    }

    @Test
    void addObject() {
        Json_Game J = new Json_Game("A",4);
        Json_Game[] jsonARR = {
                new Json_Game("A",3),
                new Json_Game("B",22),
                new Json_Game("C")
        };
        int OrigCount = jsonARR.length;
        jsonARR = Json_Game.AddObject(jsonARR,J);
        int NewCount = jsonARR.length;
        assertTrue(NewCount > OrigCount);
    }

    @Test
    void grabData() {
        assertNotNull(Json_Game.GrabData());
    }

    @Test
    void constLvlDat() {
        Json_Game[] Trees = Json_Game.GrabData(new SnakeModel(false));
        ArrayList<String[]> foo = Json_Game.ConstLvlDat(Trees);
        assertTrue(foo.size() > 0);
    }

}