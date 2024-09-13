package io.compiler.core.ast;
import io.compiler.types.*;

public class readCommand extends Command {
	private Var var;
	
	
	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		return var.getId() + " = " + ((var.getType() == Types.NUMBER)?"_scTrx.nextInt();\n" : "_scTrx.nextLine();\n");
	}


	public Var getVar() {
		return var;
	}


	public void setVar(Var var) {
		this.var = var;
	}


	public readCommand(Var var) {
		super();
		this.var = var;
	}


	public readCommand() {
		super();
	}
}
