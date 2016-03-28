package learning.datastructures.recursion;

public class ChooseTeam {
	
	private char[] letters;
	private int nLetters;
	private char[] team;
	private int teamSize;
	
	public ChooseTeam(int k, String members) {
		letters = members.toCharArray();
		team = new char[k];
		nLetters = letters.length;
		teamSize = k;
	}
	
	public void doSelection() {
		doSelection(teamSize, 0);
	}
			
		
	public void doSelection(int k, int j) {
		int l = nLetters - k + 1;
		int m = teamSize - k;
		
		if (k == 1){
			for (int i = j; i < l; ++i){
				team[m] = letters[i];
				displayTeam(team);
			}
		} else {
			
			for (int i = j; i < l; ++i){
				team[m] = letters[i];
				doSelection(k - 1, i + 1);
			}
		}
	}
	
	public void displayTeam(char[] team){
		int n = team.length;
		for (int i = 0; i < n; ++i)
			System.out.print(team[i]);
		System.out.println();
	}
	
	public static void main(String[] args){
		ChooseTeam newTeam = new ChooseTeam(4, "ABCDEF");
		newTeam.doSelection();
	}

}
