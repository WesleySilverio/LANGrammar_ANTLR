package io.compiler.core.ast;

import java.util.List;
import java.util.ArrayList;

public class IfCommand extends Command {
	private String expression;
	private List<Command> trueList;
	private List<Command> falseList;
	
	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("if("+expression+") {\n");
		for(Command cmd: trueList) {
			str.append(cmd.generateTarget());
		}
		str.append("}\n");
		if(!falseList.isEmpty()){
			str.append("else {\n");
			for(Command cmd: falseList) {
				str.append(cmd.generateTarget());
			}
			str.append("}\n");
		}
		return str.toString();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<Command> getTrueList() {
		return trueList;
	}

	public void setTrueList(List<Command> trueList) {
		this.trueList = trueList != null ? trueList : new ArrayList<>();
	}

	public List<Command> getFalseList() {
		return falseList;
	}

	public void setFalseList(List<Command> falseList) {
		this.falseList =  falseList != null ? falseList : new ArrayList<>();
	}

	public IfCommand(String expression, List<Command> trueList, List<Command> falseList) {
		super();
		this.expression = expression;
		this.trueList = trueList != null ? trueList : new ArrayList<>();
		this.falseList = falseList != null ? falseList : new ArrayList<>();
	}

	public IfCommand() {
		this.expression = "";
        this.trueList = new ArrayList<>();
        this.falseList = new ArrayList<>();
	}	
}
