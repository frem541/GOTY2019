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
		// �������� � ��������� �������
		timerUpdate = new Timer(600/level, new ActionListener()	
		{
			public void actionPerformed(ActionEvent e)
			{
				down();
			}
		});
		act = false;
		// �������� ����������� �������� � ����������� ������
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
	// �����, �������������� ������� � ������������ ��� ������
	public void start()
	{
		// �������� �������� �������� �� �������
		int i = (int)(Math.random()*4);
		img = imgarr[i];
		// ��������� ������
		timerUpdate.start();
		y = 0;
		// �������� ������ ������ �����
		x = (int)(Math.random()*700);
		// ���������� �������
		act = true;
	}
	// ����� �������� ����
	public void down()
	{
		if (act == true)
			// ���������� ������� ����
			y+=20;
		if ((y+img.getHeight(null)) >= 600) // ���� ����������
		{
			// ������������� ������
			timerUpdate.stop();
		}
	}
	// �����, �������� �������
	public void draw(Graphics gr)
	{
		if (act == true)
			gr.drawImage(img,x,y,null);
	}
}
