package h2;
import java.util.ArrayList;

public class Bus {
	public ArrayList<Passenger> passengers;
	
	public Bus() {
		passengers = new ArrayList<>();
	}
	
	public void enterBus(Passenger p) {
		passengers.add(p);
	}
	
	private void exitBus() {
		for(int i=0; i<passengers.size();i++) {
			if(passengers.get(i).planned == passengers.get(i).visited) {
				passengers.remove(i);
				i--;
			}
		}
	}
	
	public void nextStop(Passenger[] boarding) {
		for(int i=0; i< passengers.size();i++) {
			passengers.get(i).visited += 1;
		}
		exitBus();
		
		for(int x=0; x<boarding.length;x++) {
			passengers.add(boarding[x]);
		}
	}
	
	
	public void nextStop() {
		for(int i=0; i< passengers.size();i++) {
			passengers.get(i).visited += 1;
		}
		exitBus();
	}
	
	
	public ArrayList<Passenger> findPassengersWithoutTicket() {
		ArrayList<Passenger> withoutticket = new ArrayList<>();
		for(int i=0; i< passengers.size();i++) {
			if(passengers.get(i).ticket == false) {
				withoutticket.add(passengers.get(i));
				passengers.remove(i);
				i--;
			}
		}
		return withoutticket;
	}
	
	public void transferPassangers(Bus otherBus, String[] passengerNames) {
		for(int i=0; i<passengers.size();i++) {
			for(int j=0; j<passengerNames.length; j++) {
				if(passengers.get(i).name== passengerNames[j]) {
					otherBus.enterBus(passengers.get(i));
					passengers.remove(i);
					i--;
				}
			}
		}
	}

}
