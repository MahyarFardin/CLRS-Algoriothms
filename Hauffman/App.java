import java.util.*;

public class App{
  public static void main(String args[]){
	String text="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

	text=text.toLowerCase();
	System.out.print("The text is "+(text.length()*16)+" bits\n");
	
	ArrayList<String[]>	characterList=new ArrayList<>();
	
	for(int i=0; i<text.length(); i++){
	  boolean flag=false;
	  String character=Character.toString(text.charAt(i));

	  for(int j=0; j<characterList.size(); j++){
		  if(characterList.get(j)[0].equals(character)){
			/* System.out.print(Integer.parseInt(characterList.get(j)[1])); */
			characterList.get(j)[1]=String.valueOf(Integer.parseInt(characterList.get(j)[1])+1);
			flag=true;
		  }
	  }

	  if(flag==false && !character.equals(" ")){
		String [] temp={character, "1"};
		characterList.add(temp);
	  }
	}

	for(int i=0; i<characterList.size(); i++){
	  for(int j=i+1; j<characterList.size(); j++){
		if(Integer.parseInt(characterList.get(i)[1])<Integer.parseInt(characterList.get(j)[1])){
		  String [] temp= characterList.get(i);	
		  characterList.set(i, characterList.get(j));	
		  characterList.set(j, temp);	
		}
	  }
	}
  
	
	for(String [] temp: characterList){
	  System.out.print(temp[0]);
	  System.out.print(temp[1]);
	  System.out.println();
	}
  }
}
