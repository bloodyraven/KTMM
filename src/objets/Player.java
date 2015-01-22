package objets;

import java.util.ArrayList;

public class Player {
	
	private String login;
	private ArrayList<Character> listChar;
	
	public Player(String login) {
		this.login=login;
		setListChar(new ArrayList<Character>());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ArrayList<Character> getListChar() {
		return listChar;
	}

	public void setListChar(ArrayList<Character> listChar) {
		this.listChar = listChar;
	}
	
}
