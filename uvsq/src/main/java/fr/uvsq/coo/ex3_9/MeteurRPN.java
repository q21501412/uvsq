package fr.uvsq.coo.ex3_9;

import java.util.Collection;

public class MeteurRPN extends Interpreter {

	public MeteurRPN() {

	}

	public void addOperand(String operand) {
		history.add(operand);
	}

	public Collection<String> getOperands() {
		return this.cmds.keySet();
	}

}
