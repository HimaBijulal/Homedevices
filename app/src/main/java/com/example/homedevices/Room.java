

package com.example.homedevices;
import java.util.List;
import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
public class Room  implements Serializable{
	public ArrayList <Outlet> listofoutlets;


	public ArrayList<Outlet> getListofoutlets() {
		return listofoutlets;
	}

	private String label;


	Room(String label) {
		this.label = label;
		listofoutlets = new ArrayList<Outlet>();

	}

	String getLabel() {
		return label;
	}

	public void GenerateReport() {
		//print from the funtion getPower in this class
	}
	public List<String> getoutletLabels(){
		List<String> arr= new ArrayList<String>();
		for(int i=0;i<listofoutlets.size();i++){
			arr.add(listofoutlets.get(i).getLabel());
		}
		return arr;

	}
	public List<String> getUnpluggedOutletLabels(){
		List<String> arr= new ArrayList<String>();
		for(int i=0;i<listofoutlets.size();i++){
			if(!listofoutlets.get(i).isPlugged())
				arr.add(listofoutlets.get(i).getLabel());
		}
		return arr;

	}
	public boolean addOutlet(String OutletLabel){
		if(getOutlet(OutletLabel)==null){
			listofoutlets.add(new Outlet(OutletLabel));
			return true;
		}
		return false;


	}
	public Outlet getOutlet(String Outletlabel){
		if(listofoutlets==null)
			return null;
		for(Outlet outlet: listofoutlets)
			if(outlet.getLabel().equals(Outletlabel)) {
				return outlet;
			}
		return null;

	}

	public double GetPower() {
		double power=0.0;
		for (Outlet o:listofoutlets){
			power+=o.CurrentUsage();
		}
		return power;

	}

	public void delOutlet(String outletLabel) {
		Outlet temp = getOutlet(outletLabel);
		listofoutlets.remove(temp);


	}

    public List<String> getpluggedOutletLabels() {
		List<String> arr= new ArrayList<String>();
		for(int i=0;i<listofoutlets.size();i++){
			if(listofoutlets.get(i).isPlugged())
				arr.add(listofoutlets.get(i).getLabel());
		}
		return arr;
    }
}