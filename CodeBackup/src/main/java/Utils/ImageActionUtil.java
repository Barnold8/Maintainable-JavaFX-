package Utils;

import javafx.scene.image.Image;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

/**
 *
 * <p>
 *     This class handles grabbing images
 * </p>
 *@author Brandon
 * **/
public class ImageActionUtil
{
	/**
	 *
	 * <p>
	 *     This function returns an image based on the imagepath passed into it
	 * </p>
	 * @param imagePath - Takes in a path to the image, so it can grab the
	 *                     image - Type String
	 * @return i Returns and image based on the file path given - Type Image
	 * **/

	public static Image GetImage(String imagePath)
			throws MalformedURLException {
		URL u = Paths.get("src/main/resources/"+imagePath).toUri().toURL();
		/*System.out.println(u);*/
		Image i = null;
		try
		{
			assert u != null;
			i = new Image(u.openStream());

		} catch (Exception e)
		{
			// Error can occur on pre init which is fine
			/*System.err.println("ERROR : SPECIFIC IMAGE NOT FOUND AT " + u);
			e.printStackTrace();*/
		}

		return i;
	}


}
