package at.tugraz.ist.soma.cfg;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import at.tugraz.ist.soma.DataPool;
import at.tugraz.ist.soma.statements.Statement;
import at.tugraz.ist.soma.utils.Visualizer;

/**
 * This class creates a control flow graph using the list of {@link at.tugraz.ist.soma.statements.Statement}s.
 * @author Stephan Frühwirt
 */
public class CFGgenerator {

	private DataPool pool;
	private Deque<CFGNode> stack;
	
	public CFGgenerator(){
		pool = DataPool.getInstance();
		stack = new LinkedList<>();
	}
	
	/**
	 * generates the CFG. You can use the {@link at.tugraz.ist.soma.utils.Visualizer#createCFGdotFile(ArrayList)}
	 * to get a graphical representation of your graph!
	 */
	public void generate(){
		ArrayList<CFGNode> cfg = new ArrayList<>();
		
		CFGNode node = new CFGNode();
		cfg.add(node);
		
		stack.push(node);
		
		// TODO: calculate the CFG
		//		hint: this will be the most difficult part of this exercise.
		//		Prepare a coffee supply...
		for(Statement stmt : pool.getStatements().values()){
			
		}

		Visualizer.createCFGdotFile(cfg);
		pool.setControlFlowGraph(cfg);
	}
}
