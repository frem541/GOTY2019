import javax.swing.JOptionPane;
// "C:\Users\frem541\Desktop\shit\.png"
// ������� ����� ����
public class Game 
{
	// �����, ����������� ����
	public static void main(String[] args) 
	{
		// ����� ���� ��� ������ ������ ���������
		String rez=JOptionPane.showInputDialog(null, "������� ������� ��������� ���� �� 1 �� 6", "��������� ����",1);
		// ��������� ���������� ������
		int level=rez.charAt(0)-'0';
		// ��������
		if ((level>=1)&&(level<=6))
		{
			// �������� ���� � ������� �����
			win window = new win(level);
		}
		else
			System.out.print("Error");
	}

}
