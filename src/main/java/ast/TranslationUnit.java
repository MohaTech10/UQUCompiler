package ast;

import semantic.Context;
import semantic.Definition;
import semantic.TranslationUnitContext;

import java.util.List;
import java.util.Map;

/**
 * Root Node in our AST
 */
public class TranslationUnit extends ASTNode {

    private final String fileName;  // name of file;

    GlobalScope globalMembers;

    /*transUnitSymbol fContext;*/
    TranslationUnitContext translationUnitContext;

    // Todo: Not to be confused with struct decl as they introduce new scope of a program;
    // Todo: this is an initial of implementation. We're not taking nested scopes in account yet;

    /*List<ASTNode> structDecl;*/

    public TranslationUnit(int line, String fileName,  GlobalScope globalMembers) {
        super(line);
        this.globalMembers = globalMembers;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "TranslationUnit{" +
                "globalMembers=" + globalMembers +
                '}';
    }

    @Override
    protected void dump(int indent) {
        System.out.println("TranslationUnit");
        globalMembers.dump(indent + 2);
    }

    public void dump() {
        dump(0);
    }

    public Map<String, Definition> getTranslationUnitContext() {
        return translationUnitContext.table;
    }

    public List<Statement> gTree() {return globalMembers.getStatements();}
}
