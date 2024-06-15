package Mechanics;

import MVC.SnakeModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import Utils.ImageSaveUtil;


import java.util.Random;
/**
 *
 * <p>The food is a pickup that the player can collide with to gain an
 * addition to their score. This class
 * extends the SnakeObj abstract class </p>
 *
 * @see SnakeObj
 * @author Brandon
 * **/
public class Food extends SnakeObj
{
	/**
	 * <p>This constructor sets a default position and random image for
	 * the food object </p>
	 *
	 * @see SnakeObj
	 * **/
	public Food()	{
		int X_POS = 300;
		int Y_POS = 300;
		SetM_IsLiving(true);

		SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
				new Random().nextInt(10))));

		SetM_w((int) GetM_i().getWidth());
		SetM_h((int) GetM_i().getHeight());

		SetM_x(X_POS);
		SetM_y(Y_POS);
	}
	/**
	 *<p>This constructor allows for the configuration of an x and y
	 * position for the food object. This constructor grabs a random image
	 * from the food directory.</p>
	 * @param x Takes in an int to set the x position - Type int
	 * @param y Takes in an int to set the y position - Type int
	 * @see SnakeObj
	 * **/
	public Food(int x, int y){
		SetM_IsLiving(true);

		SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
				new Random().nextInt(10))));

		SetM_w((int) GetM_i().getWidth());
		SetM_h((int) GetM_i().getHeight());

		SetM_x(x);
		SetM_y(y);
	}
	/**
	 * <p>The ResetFruit public function resets the fruit's position
	 * and its image with its relative image directory space (Food in resources)
	 * </p>
	 * @param g Takes in the Graphics context to grab the width and height
	 * **/
	private void ResetFruit(GraphicsContext g){
		int BOUND = 10;
		SetM_x((int) (Math.random() * (g.getCanvas().getWidth()
				- GetM_w())));
		SetM_y((int) (Math.random() * (g.getCanvas().getHeight()
				- GetM_h())));
		this.SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
				new Random().nextInt(BOUND))));
	}
	/**
	 * <p>The Eaten public function, ensures that a fruit doesn't reset
	 * in a tree and that the event adds to the player's score
	 * </p>
	 * @param mySnake Takes in the snake object for data related to a
	 *                   collision (positions and rectangle area)
	 * @param g Takes in the Graphics context to grab the width and height
	 * @param tree Takes in a tree object to check if the fruit has spawned
	 *                in a tree
	 * @param model Takes in the model object to adhere to the "Dasher"
	 *                 gamemode if its flag is set to true
	 * **/
	public boolean Eaten(Snake mySnake, GraphicsContext g, Tree tree,
					  SnakeModel model){

		while(InTree(this,tree)){
			ResetFruit(g);}

		if (mySnake.GetRectangle().intersects(
				this.GetRectangle().getBoundsInLocal()) && GetM_IsLiving()
				&& mySnake.GetM_IsLiving()){

					mySnake.SetLength(mySnake.GetLength() + 1);
					ResetFruit(g);
					if(model.GetGameState().IsM_Dasher()){
						mySnake.SetM_speed_XY((int) (mySnake.GetM_speed_XY() +(
								mySnake.GetLength() * 0.1)));
					}
					return true;
		}
		return false;
	}
	/**
	 * <p>The Eaten public function, ensures that a fruit doesn't reset
	 * in a tree and that the event adds to the player's score
	 * </p>
	 * @param f Takes in the food object for data related to a
	 * 	                    collision (positions and rectangle area) - Type Food
	 * @param tree Takes in a tree object for data related to a
     *               collision (positions and rectangle area) - Type Tree
	 * @return Returns a boolean based on the intersection between a fruit
	 * and tree object
	 * **/
	public boolean InTree(Food f, Tree tree){
		return tree.GetRectangle().intersects(
				f.GetRectangle().getBoundsInLocal());
	}
	/**
	 *<p>Draws the fruit on the game canvas
	 * </p>
	 * @param g Takes in a graphics context so the game canvas can be drawn to
	 * @param img Takes in a ImageView so the renderSnake function can draw
	 *               the snakes head properly - Type ImageView
	 * **/
	@Override
	public void Draw(GraphicsContext g, ImageView img) {}

	/**
	 * <p>Draws the fruit on the game canvas
	 * </p>
	 * @param g Takes in a graphics context so the game canvas can be drawn
	 *             to - Type GraphicsContext
	 *
	 * **/
	@Override
	public void Draw(GraphicsContext g)
	{
		g.drawImage(GetM_i(), GetM_x(), GetM_y());
	}
}
