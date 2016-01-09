package fr.uvsq.coo.ex3_9;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter {

	protected Stack<String> history = new Stack<String>();
	protected Map<String, Command> cmds = new HashMap<String, Command>();

	public void session() {
		while (true) {
			Command command = getNewCommand();
			if (command instanceof Quit) {
				return;
			} else if (command instanceof Undo) {
				history.pop();
				return;
			} else {
				command.execute();
			}
		}
	}

	protected Command getNewCommand() {
		String s = history.pop();
		while (!cmds.containsKey(s)) {
			System.out.println("Not a valid command; try again!");
			// s = input.getString();
		}
		return (cmds.get(s));
	}
}
