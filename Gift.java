import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
public class Gift 
{
	public Image img;
	static public Image imgarr[];
	public int x,y;
	public boolean act;
	private Timer timerUpdate;
	public Gift(int level)
	{
		// создание и настройка таймера
		timerUpdate = new Timer(600/level, new ActionListener()	
		{
			public void actionPerformed(ActionEvent e)
			{
				down();
			}
		});
		act = false;
		// загрузка изображений подарков в статический массив
		imgarr = new Image[4];
		for (int i = 0; i < 4; i++)
		{
			try
			{
			imgarr[i] = ImageIO.read(new File("./p"+i+".png"));
			}
			catch(IOException ex) {}
		}
	}
	// метод, активизирующий подарок и выкидывающий его сверху
	public void start()
	{
		// случайно выбираем картинку из массива
		int i = (int)(Math.random()*4);
		img = imgarr[i];
		// запускаем таймер
		timerUpdate.start();
		y = 0;
		// случайно делаем отступ слева
		x = (int)(Math.random()*700);
		// активируем подарок
		act = true;
	}
	// метод движения вниз
	public void down()
	{
		if (act == true)
			// перемещаем подарок вниз
			y+=20;
		if ((y+img.getHeight(null)) >= 600) // если пропустили
		{
			// останавливаем таймер
			timerUpdate.stop();
		}
	}
	// метод, рисующий подарок
	public void draw(Graphics gr)
	{
		if (act == true)
			gr.drawImage(img,x,y,null);
	}
}
