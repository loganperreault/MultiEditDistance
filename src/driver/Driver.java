package driver;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edit_distance.DPTableRow;
import edit_distance.DPTableTree;
import edit_distance.MultiEditDistance;

public class Driver {
	
	// TODO: look into first counting the number of matches for letters
	// and storing in a hashmap so we can do better with early stopping
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//DPTableTree tree = new DPTableTree();
		
		String baseString = "Kurt Russell";
		DPTableRow.setSize(baseString.length() + 1);
		Map.Entry<String, Integer> base = new AbstractMap.SimpleEntry<String, Integer>(baseString, 1);
		//Predicate starring = new Predicate("data/starring.txt");
		List<String> actors = new ArrayList<>();
		actors.add("Kurt BRussle");
		//actors.add("Henry Russell");
		actors.add("Samuel Jackson");
		//actors.add("Samuel L Jackson");
		actors.add("Kurt Russel");
		actors.add("Kurt Russell");
		Predicate starring = new Predicate();
		starring.populate(actors);
		
		MultiEditDistance med = new MultiEditDistance();
		med.findSimilar(starring, base);
		System.out.println(med.getCellCount());
		
		DPTableRow root = DPTableRow.getRoot();
		DPTableTree tree = new DPTableTree(root);
		//tree.printTree();
		
	}

}
