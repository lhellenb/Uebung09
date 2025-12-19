package h1;

import java.util.ArrayList;

public class PrioListe {
	public ArrayList<Patient> myList = new ArrayList<>();
	
	
	public void addPatient(Patient p) {
		if(myList.size()==0) {
			myList.add(0,p);
		} else if(myList.get(myList.size()-1).prio < p.prio) {  //Wenn die Prioriät des letzten (! weil fängt ja bei 0 an!) Elements aus der Liste kleiner ist als die Priorität von unserem Patienten p ist
			myList.add(p); //Dann fügen wir das Element von ganz rechts ein
		}
		else {
			int i=0;
			while(myList.get(i).prio < p.prio) { //Solange die Prioriät des i-ten Patienten aus der Liste kleiner ist als die unseres Patienten
				i++;  //gehen wir in der Liste ein Patient weiter
			}
			myList.add(i,p); //wir setzen den Patienten an der i-ten Stelle ein
		}
	}
	
	
	public Patient getNextPatient() {
		if(myList.size() == 0) {
			return new Patient("Niemand mehr da", -2);
		}
		Patient p;
		p = myList.get(0);
		myList.remove(0);
		return p;
	}
	
	public int getPosition(Patient p) {
		for(int i=0; i<myList.size(); i++) {
			if(myList.get(i).prio == p.prio) {
				return i;
			}
		}return -1;
	}
	

}
