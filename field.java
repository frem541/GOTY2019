import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class field extends JPanel
{
	private Image hat, background;
	private Image numbers[];
	public int x = 400; // x - координата шапки в данной момент
	private int level;
	public int score;
	private Gift[] gameGift;
	private Image end_game;
	public Timer timerUpdate, timerDraw;
	public field(int level)
	{
		score = 0;
		this.level = level;
		// загружаем картинки
		try
		{
			hat = ImageIO.read(new File("./hat.png"));
		}
		catch(IOException ex) {}
		numbers = new Image[10];
		for (int i = 0; i < 10; i++)
		{
			try
			{
				numbers[i] = ImageIO.read(new File("./num"+i+".png"));
			}
			catch(IOException ex) {}
		}
		try
		{
			background = ImageIO.read(new File("./background.png"));
		}
		catch(IOException ex) {}
		try
		{
			end_game = ImageIO.read(new File("./Endgame.png"));
		}
		catch(IOException ex) {}
		gameGift = new Gift[9];
		for (int i = 0; i < 9; i++)
		{
			gameGift[i] = new Gift(level);
		}
		// таймер выплёвывает подарки
		timerUpdate = new Timer(3500 - level*500, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				updateStart();
			}
		});
		timerUpdate.start();
		// таймер для перерисовки
		timerDraw = new Timer(50, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// метод таймера для перерисовки (на него срабатывает paintComponent с другим именем >_<)
				repaint();
			}
		});
		timerDraw.start();
	}
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);
		gr.drawImage(background, 0, 0, null);
		for (int i = 0; i < 9; i++)
		{
			gameGift[i].draw(gr);  
			if (gameGift[i].act == true)
			{
				// если подарок достиг нижней границы и пропущен
				if (gameGift[i].y+gameGift[i].img.getHeight(null) >= 600)
				{
					gr.drawImage(end_game, 120, 200, null);
					timerDraw.stop();
					timerUpdate.stop();
					break;
				}
				// если подарок достиг нижней границы, но его ещё можно поймать
				if (gameGift[i].y+gameGift[i].img.getHeight(null) >= 500)
				{
					// если "попадает" в шапку
					if(Math.abs(gameGift[i].x-x) <= 90)
					{
						gameGift[i].act = false;
						score++;
					}
				}
			}
		}
		gr.drawImage(hat, x, 435, null);
		if (score  < 10)
		{
			gr.drawImage(numbers[score], 0, 0, null);
		}
		else if (score < 100)
		{
			gr.drawImage(numbers[score/10], 0, 0, null);
			gr.drawImage(numbers[score%10], numbers[score/10].getWidth(null), 0, null);
		}
		else if (score < 1000)
		{
			gr.drawImage(numbers[score/100], 0, 0, null);
			gr.drawImage(numbers[score/10%10], numbers[score/100].getWidth(null), 0, null);
			gr.drawImage(numbers[score%10], numbers[score/10%10].getWidth(null)+numbers[score/100].getWidth(null), 0, null);
		}
		else
		{
			gr.drawImage(numbers[score/1000], 0, 0, null);
			gr.drawImage(numbers[score/100%10], numbers[score/1000].getWidth(null), 0, null);
			gr.drawImage(numbers[score/10%10], numbers[score/100%10].getWidth(null)+numbers[score/1000].getWidth(null), 0, null);
			gr.drawImage(numbers[score%10], numbers[score/10%10].getWidth(null)+numbers[score/100%10].getWidth(null)+numbers[score/1000].getWidth(null), 0, null);
		}
	}
	// метод для закидывания подарков
	private void updateStart()
	{
		for (int i = 0; i < 9; i++)
		{
			if (gameGift[i].act == false)
			{
				gameGift[i].start();
				break;
			}
		}
	}
}