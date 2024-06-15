package Utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.nio.file.Paths;

/**
 *
 * <p> This class provides the music to the program
 * </p>
 *@author Brandon
 * **/
public class Music {
    /**
     * <p>
     *
     * This function is a wrapper to set the music to play on a continuous
     * loop and throw an error if some problem has occurred.   </p>
     * **/
    public void PlayAudio(){
        try {
            this.m_mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            this.m_mediaPlayer.play();
        }catch(MediaException media){
            System.out.println("Cannot play the current track");
        }
    }
    /**
     * <p> This function provides the relative base path for the music files
     * </p>
     * @return Path - Returns the path of the hard coded directory for music
     * files
     * **/
    private String getBasePath(){
        return  Paths.get(
                "src/main/resources/Music/").toString();

    }
    /**
     * <p> This function stops the current track and ensures that a new one
     * is set and played. This is done by using a trackNumber, much like you
     * would see on an album and the song is a track. So the relative file
     * path is just a track ID.
     * </p>
     * @param TrackNum - Takes in an int to set the track specified in the
     *                 m_tracks array of strings.
     * **/
    public void SetTrack(int TrackNum){
        this.m_mediaPlayer.stop(); // to avoid any errors
        this.m_media = new Media(new File
                (Paths.get("src/main/resources/Music/"+m_tracks[TrackNum])
                        .toUri())
                .toURI().toString());
        this.m_mediaPlayer = new MediaPlayer(this.m_media);
        this.m_mediaPlayer.play();
    }
    private final String[] m_tracks =
            {"MainMenu.mp3","Settings.mp3","HighScores.mp3",
                    "LevelSelect.mp3", "Game.mp3"};
    private Media m_media;
    private MediaPlayer m_mediaPlayer;

    /**
     * <p> This default constructor ensures that a default track is set on
     * the objects creation so some music HAS to be playing
     * </p>
     *
     * **/
    public Music(){

/*        this.m_media =
                new Media(new File(getBasePath()+"\\"+
                        m_tracks[0]).toURI().toString());*/
        this.m_media = new Media(new File
                (Paths.get("src/main/resources/Music/"+m_tracks[0]).toUri())
                .toURI().toString());
        this.m_mediaPlayer = new MediaPlayer(m_media);

    }

}
