package aip.FiveProgrammers;

public class FiveProgrammers {
	public static void main(String[] args){		
		String programmerName[] = {"Albert","Bert","Chris","Dave","Eliot"};
		int	programmerID[] = {1,2,3,4,5};
		boolean dbKnowledge[] = {true, true, false, false, true};
		int dbKnowledge_to_int[] = new int[dbKnowledge.length];
		
		System.out.println("The following programmers have DB knowledge:\nProgrammer ID\tProgrammer Name");
		for(int i = 0; i < dbKnowledge_to_int.length; i++) {
			boolean dbKnow;
			dbKnow = dbKnowledge[i];
			if(dbKnow == true) {
				System.out.println("\t" + programmerID[i] + "\t\t" + programmerName[i]);
				}			
		}
	}
}
