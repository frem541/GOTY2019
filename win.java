import java.awt.Container;
import java.text.NumberFormat.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class win extends JFrame
{
	private field gameField; // ������� ����
	// ���������� ������� ������� �� �������
	private class myKey implements KeyListener
	{
		// �����, ������������� ��� �������
		public void keyPressed(KeyEvent e)
		{
			int key_=e.getKeyCode();
			if (key_==27) // 27 - ASCII ��� escape
				System.exit(0);
			else
			{
				if ((key_ == 37)||(key_ == 65)) // 37 - ASCII ��� ������� �����
				{
					if (gameField.x - 30 > -48)
						gameField.x -= 50;
					else
						gameField.x = 752;
				}
				if ((key_ == 39)||(key_ == 68)) // 39 - ASCII ��� ������� ������
				{
					if (gameField.x + 30 < 752)
						gameField.x += 50;
					else
						gameField.x = -48;
				}
			}
		}
		// �����, ������������� ��� ����������
		public void keyReleased(KeyEvent e) {}
		// �����, ������������� ��� ����������
		public void keyTyped(KeyEvent e) {}
	}
	public win (int level)
	{
		// ����������� ����������� ������� � ����
		addKeyListener(new myKey());
		// ��������� ���������� ����
		setFocusable(true);
		setBounds(0,0,800,600);
		setTitle("���������� �����");
		// �������� �������� ����
		gameField = new field(level);
		// ������������ ������ (����) � ����
		Container con = getContentPane();
		con.add(gameField);
		setVisible(true);
	}
}
