package Utils;

import javafx.scene.image.Image;

import java.util.HashMap;

import java.util.Map;
/**
 *
 * <p>
 *     This class holds all of the image paths for the images
 * </p>
 * @author Brandon
 * **/
public class ImageSaveUtil
{

	private static Map<String, Image> m_images = new HashMap<>();

	/**
	 * <p>
	 *     This function returns the image hashmap that holds all of the images
	 * </p>
	 * @return m_images Returns the images hashmap - type &lt;
	 * MapString,Image&gt;
	 * **/
	public static Map<String, Image> GetM_images(){
		return m_images;
	}

	static
	{
		try {
			m_images.put("snake-head-right", ImageActionUtil.GetImage(
					"/Snake/snake-head-right.png"));
			m_images.put("snake-body", ImageActionUtil.GetImage(
					"Snake/snake-body.png"));
			m_images.put("0", ImageActionUtil.GetImage(
					"/Food/food-kiwi.png"));
			m_images.put("1", ImageActionUtil.GetImage(
					"/Food/food-lemon.png"));
			m_images.put("2", ImageActionUtil.GetImage(
					"/Food/food-litchi.png"));
			m_images.put("3", ImageActionUtil.GetImage(
					"/Food/food-mango.png"));
			m_images.put("4", ImageActionUtil.GetImage(
					"/Food/food-apple.png"));
			m_images.put("5", ImageActionUtil.GetImage(
					"/Food/food-banana.png"));
			m_images.put("6", ImageActionUtil.GetImage(
					"/Food/food-blueberry.png"));
			m_images.put("7", ImageActionUtil.GetImage(
					"/Food/food-cherry.png"));
			m_images.put("8", ImageActionUtil.GetImage(
					"/Food/food-durian.png"));
			m_images.put("9", ImageActionUtil.GetImage(
					"/Food/food-grape.png"));
			m_images.put("10", ImageActionUtil.GetImage(
					"/Food/food-grapefruit.png"));
			m_images.put("11", ImageActionUtil.GetImage(
					"/Food/food-peach.png"));
			m_images.put("12", ImageActionUtil.GetImage(
					"/Food/food-pear.png"));
			m_images.put("13", ImageActionUtil.GetImage(
					"/Food/food-orange.png"));
			m_images.put("14", ImageActionUtil.GetImage(
					"/Food/food-pineapple.png"));
			m_images.put("15", ImageActionUtil.GetImage(
					"/Food/food-strawberry.png"));
			m_images.put("16", ImageActionUtil.GetImage(
					"/Trees/Tree1" + ".png"));
			m_images.put("17", ImageActionUtil.GetImage(
					"/Trees/Tree2" + ".png"));
			m_images.put("18", ImageActionUtil.GetImage(
					"/Trees/Tree3" + ".png"));
			m_images.put("19", ImageActionUtil.GetImage(
					"/Trees/Tree4" + ".png"));
			m_images.put("20", ImageActionUtil.GetImage(
					"/Trees/Tree5" + ".png"));
			m_images.put("21", ImageActionUtil.GetImage(
					"/Trees/Tree6" + ".png"));
			m_images.put("22", ImageActionUtil.GetImage(
					"/Trees/Tree7" + ".png"));
			m_images.put("23", ImageActionUtil.GetImage(
					"/Trees/Tree8" + ".png"));
			m_images.put("24", ImageActionUtil.GetImage(
					"/PowerUps" + "/SpeedDown.png"));
			m_images.put("25", ImageActionUtil.GetImage(
					"/PowerUps" + "/SpeedUp.png"));
			m_images.put("26", ImageActionUtil.GetImage(
					"/PowerUps" + "/Random.png"));
			m_images.put("27", ImageActionUtil.GetImage(
					"/Enemy" + "/DogLeft.png"));
			m_images.put("28", ImageActionUtil.GetImage(
					"/Enemy" + "/DogRight.png"));
			m_images.put("UI-background", ImageActionUtil.GetImage(
					"/UI/UI-background.png"));
			m_images.put("game-scene-01", ImageActionUtil.GetImage(
					"/UI/game-scene-01.jpg"));
		}catch(Exception e){

		}
	}

}
