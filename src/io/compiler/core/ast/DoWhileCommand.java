package io.compiler.core.ast;
import java.util.List;
import java.util.ArrayList;

public class DoWhileCommand extends Command {
	private String expression;
	private List<Command> dowhileList;

	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("do{\n");
		for(Command cmd: dowhileList) {
			str.append(cmd.generateTarget());
		}
		str.append("} while("+expression+");");
		return str.toString();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<Command> getDowhileList() {
		return dowhileList;
	}

	public void setDowhileList(List<Command> dowhileList) {
		this.dowhileList = (dowhileList != null)? dowhileList : new ArrayList<>();
	}

	public DoWhileCommand(String expression, List<Command> dowhileList) {
		super();
		this.expression = expression;
		this.dowhileList = (dowhileList != null)? dowhileList : new ArrayList<>();
	}

	public DoWhileCommand() {
		this.expression = "";
		this.dowhileList = new ArrayList<>();
	}
	
	
}
