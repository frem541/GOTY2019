import javax.swing.JOptionPane;
// ãëàâíûé êëàññ èãðû
public class Game 
{
	// ìåòîä, çàïóñêàþùèé èãðó
	public static void main(String[] args) 
	{
		// âûçîâ îêíà äëÿ âûáîðà óðîâíÿ ñëîæíîñòè
		String rez=JOptionPane.showInputDialog(null, "Ââåäèòå óðîâåíü ñëîæíîñòè èãðû îò 1 äî 6", "Ñëîæíîñòü èãðû",1);
		// ïîìåùåíèå ðåçóëüòàòà âûáîðà
		int level=rez.charAt(0)-'0';
		// ïðîâåðêà
		if ((level>=1)&&(level<=6))
		{
			// ñîçäàíèå îêíà ñ èãðîâûì ïîëåì
			win window = new win(level);
		}
		else
			System.out.print("Error");
	}

}
