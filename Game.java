import javax.swing.JOptionPane;
// "C:\Users\frem541\Desktop\shit\.png"
// главный класс игры
public class Game 
{
	// метод, запускающий игру
	public static void main(String[] args) 
	{
		// вызов окна для выбора уровня сложности
		String rez=JOptionPane.showInputDialog(null, "Введите уровень сложности игры от 1 до 6", "Сложность игры",1);
		// помещение результата выбора
		int level=rez.charAt(0)-'0';
		// проверка
		if ((level>=1)&&(level<=6))
		{
			// создание окна с игровым полем
			win window = new win(level);
		}
		else
			System.out.print("Error");
	}

}
