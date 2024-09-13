package io.compiler.core.ast;
import java.util.List;
import java.util.ArrayList;

public class WhileCommand extends Command{
	private String expression;
	private List<Command> whileList;
	
	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while("+expression+") {\n");
		for(Command cmd: whileList) {
			str.append(cmd.generateTarget());
		}
		str.append("}\n");
		return str.toString();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<Command> getWhileList() {
		return whileList;
	}

	public void setWhileList(List<Command> whileList) {
		this.whileList = (whileList != null) ? whileList : new ArrayList<>();
	}

	public WhileCommand(String expression, List<Command> whileList) {
		super();
		this.expression = expression;
		this.whileList = (whileList != null) ? whileList : new ArrayList<>();
	}

	public WhileCommand() {
		this.expression = "";
		this.whileList = new ArrayList<>();
	}
	
	
}