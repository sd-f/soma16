package at.tugraz.ist.soma.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

import at.tugraz.ist.soma.DataPool;
import at.tugraz.ist.soma.cfg.CFGNode;
import at.tugraz.ist.soma.utils.DataIO;
import at.tugraz.ist.soma.utils.Visualizer;

/**
 * This is the class where you should implement static slicing using a PDG.
 * @author Stephan Frühwirt
 */
public class StaticSlicer {

	private DataPool pool = DataPool.getInstance();
	ArrayList<Integer>slice = new ArrayList<>();
	
	/**
	 * calls all necessary methods for calculating the slice.
	 * You can use the {@link at.tugraz.ist.soma.utils.Visualizer#createPDGdotFile(HashMap, ArrayList)}
	 * to get a graphical representation of your graph!
	 */
	public void calculateSlice(){
		HashMap<Integer, Node> tree = generateControlDependencies();
		generateDataDependencies(tree);
		startTheSlicingParty(tree);
		
		Visualizer.createPDGdotFile(tree, slice);
		DataIO.printSliceToOutputFile(slice);
	}
	
	/**
	 * generates the control dependencies of the PDG.
	 * @return the generated PDG 
	 */
	private HashMap<Integer, Node> generateControlDependencies() {
		ArrayList<CFGNode> cfg = pool.getControlFlowGraph();
		
		HashMap<Integer, Node>tree = new LinkedHashMap<Integer, Node>();
		
		// TODO: calculate the control dependencies
		
		return tree;
	}
	
	/**
	 * adds the data dependencies to the generated PDG.
	 * @param tree the PDG which was created in {@link at.tugraz.ist.soma.algorithms.StaticSlicer#generateControlDependencies()}.
	 */
	private void generateDataDependencies(HashMap<Integer, Node> tree) {
		
		// TODO: calculate the data dependencies
		
	}
	
	/**
	 * calculates the slice of a given PDG.
	 */
	private void startTheSlicingParty(HashMap<Integer, Node> tree) {
		
		String criterion = pool.getSlicingCriterion();
		
		ArrayList<String>criterionVariables = new ArrayList<>();
		
		criterion = criterion.replaceAll("[() {}]", "");
		String[] arr = criterion.split(",");
		int criterionLine = Integer.parseInt(arr[0]);
		
		for(int i = 1; i < arr.length; i++){
			criterionVariables.add(arr[i]);
		}
		
		// TODO: calculate the slice using the criterionLine variable and
		//			the ArrayList criterionVariables containing all variables
		//			from the slicing criterion (as used in public2.java)

		Collections.sort(slice);
	}

	/**
	 * checks if a set contains at least one variable of a second set.
	 */
	private boolean contains(HashSet<String> set1, HashSet<String> set2){
		for(String string : set1){
			if(set2.contains(string)){
				return true;
			}
		}
		return false;
	}
}
