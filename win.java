import java.awt.Container;
import java.text.NumberFormat.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class win extends JFrame
{
	private field gameField; // игровое поле
	// обработчик событий нажатия на клавиши
	private class myKey implements KeyListener
	{
		// метод, срабатывающий при нажатии
		public void keyPressed(KeyEvent e)
		{
			int key_=e.getKeyCode();
			if (key_==27) // 27 - ASCII код escape
				System.exit(0);
			else
			{
				if ((key_ == 37)||(key_ == 65)) // 37 - ASCII код клавиши влево
				{
					if (gameField.x - 30 > -48)
						gameField.x -= 50;
					else
						gameField.x = 752;
				}
				if ((key_ == 39)||(key_ == 68)) // 39 - ASCII код клавиши вправо
				{
					if (gameField.x + 30 < 752)
						gameField.x += 50;
					else
						gameField.x = -48;
				}
			}
		}
		// метод, срабатывающий при отпускании
		public void keyReleased(KeyEvent e) {}
		// метод, срабатывающий при комбинации
		public void keyTyped(KeyEvent e) {}
	}
	public win (int level)
	{
		// подключение обработчика события к окну
		addKeyListener(new myKey());
		// установка активности окна
		setFocusable(true);
		setBounds(0,0,800,600);
		setTitle("Новогодний дождь");
		// создание игрового поля
		gameField = new field(level);
		// прикрепления панели (поля) в окно
		Container con = getContentPane();
		con.add(gameField);
		setVisible(true);
	}
}
