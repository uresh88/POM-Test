import java.util.ArrayList;
import java.util.List;

public class TestMain
{
	List<String> textList = new ArrayList();

	public static String test = "Welcome to" + "Baeldung!";
	public void addText(String text) {
		textList.add(text);
	}

	public List getTextList() {
		return this.textList;
	}
	public static void main(String[] arg){
		System.out.println(TestMain.test);
	}
}
