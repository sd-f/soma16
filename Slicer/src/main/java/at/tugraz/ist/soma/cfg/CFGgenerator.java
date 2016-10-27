package at.tugraz.ist.soma.cfg;

import at.tugraz.ist.soma.DataPool;
import at.tugraz.ist.soma.statements.Statement;
import at.tugraz.ist.soma.utils.Type;
import at.tugraz.ist.soma.utils.Visualizer;
import java.util.*;

/**
 * This class creates a control flow graph using the list of {@link at.tugraz.ist.soma.statements.Statement}s.
 * @author Stephan Frühwirt
 */
public class CFGgenerator {

	private DataPool pool;
	private Deque<CFGNode> stack;
	private static EnumSet<Type> CONTROL_STATEMENT_TYPES = EnumSet.of(Type.IF_STMT, Type.LOOP_FOR, Type.LOOP_WHILE);
	
	public CFGgenerator(){
		pool = DataPool.getInstance();
		stack = new LinkedList<>();
	}

	private static Boolean IS_CONTROL_STATEMENT(Statement statement) {
		return CONTROL_STATEMENT_TYPES.contains(statement.getType());
	}
	
	/**
	 * generates the CFG. You can use the {@link at.tugraz.ist.soma.utils.Visualizer#createCFGdotFile(ArrayList)}
	 * to get a graphical representation of your graph!
	 */
	public void generate(){
		ArrayList<CFGNode> cfg = new ArrayList<>();

		
		// TODO: calculate the CFG
		//		hint: this will be the most difficult part of this exercise.
		//		Prepare a coffee supply...


		CFGNode lastNode = null;
		Iterator<Statement> statementIterator = pool.getStatements().values().iterator();
		while (statementIterator.hasNext()) {
			// new node may stay null if no new node is necessary
			CFGNode newNode = null;
			// setup useful objects
			Statement currentStatement = statementIterator.next();

			if (currentStatement.getLastLine() == -1) {
				newNode = new CFGNode(currentStatement);

				newNode.appendPredecessor(lastNode);
				cfg.add(newNode);
			}

			//if (currentStatement.getLastLine() == -1)
				//System.out.println(currentStatement);
			//System.out.println(currentStatement.getLastLine());

			// is current statement control statement like if, while, for
			/*
			Boolean isControlStatement = IS_CONTROL_STATEMENT(currentStatement);

			// control statement mus have last statement as predecessor
			if (isControlStatement) {
				newNode = new CFGNode(currentStatement);
				newNode.appendPredecessor(lastNode);
				cfg.add(newNode);
			} else {

			}
			*/
			if (newNode != null)
				lastNode = newNode;


			if (!statementIterator.hasNext()) {
				CFGNode endNode = new CFGNode();
				endNode.appendPredecessor(lastNode);
				cfg.add(endNode);
			}
		}



		Visualizer.createCFGdotFile(cfg);
		pool.setControlFlowGraph(cfg);
	}
}
