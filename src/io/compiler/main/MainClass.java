package io.compiler.main;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import io.compiler.core.*;
import io.compiler.core.ast.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {
	public static void main(String[] args) {
		try {
			LANGrammarLexer lexer;
			LANGrammarParser parser;
			lexer = new LANGrammarLexer(CharStreams.fromFileName("teste.in"));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			parser = new LANGrammarParser(tokenStream);
			System.out.println("LAN Compiler");
			parser.prog();
			//parser.exibirVar();
			System.out.println("Compilation Successfully");
			
			//genereteTarget()
			Program program = parser.getProgram();
			System.out.println(program.generateTarget());
			
			//Arquivo java 
			try {
				File f = new File(program.getName()+".java");
				FileWriter fr = new FileWriter(f);
				PrintWriter pr = new PrintWriter(fr);
				pr.println(program.generateTarget());
				pr.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
			
		}
		catch(Exception ex){
			System.out.println("Erro: "+ ex.getMessage());
		}
	}
}
