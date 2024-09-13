package io.compiler.core.ast;
import io.compiler.types.*;


public class ExprCommand extends Command{
	private Var var;
	private String fatores;
	
	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		return var.getId() + " = " + fatores+";\n";
		
	}
	public Var getVar() {
		return var;
	}
	public void setVar(Var var) {
		this.var = var;
	}
	public String getFatores() {
		return fatores;
	}
	public void setFatores(String fatores) {
		this.fatores = fatores;
	}
	public ExprCommand(Var var, String fatores) {
		super();
		this.var = var;
		this.fatores = fatores;
	}
	public ExprCommand() {
		super();
	}
}
