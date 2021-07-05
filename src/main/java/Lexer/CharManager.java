package Lexer;

import lex_erro_log.LexLog;
import lex_erro_log.LexerErrorDiag;

public class CharManager {

    // we store the source ? and advance?
    private char wrappedChar;  // currentChar;

    private final String source;

    private final LexLog lexLog;
    private final Position charPosition;

    public int m_idx;
    public CharManager(String source, LexLog lexLog) {
        this.charPosition = new Position();
        this.source = source;
        this.lexLog = lexLog;

        advance();
    }

    public CharManager(String src) {
        this(src, new LexerErrorDiag(src));
    }



    boolean advance() {
        if (charPosition.column < source.length()) {
            wrappedChar = source.charAt(charPosition.column ++);
            m_idx ++;
            if (wrappedChar == '\n') {
                m_idx = 0;
                charPosition.row ++;
            }
            return true;
        }

        wrappedChar = '\0';
        return false;

    }

    // Todo: return a logger instance and check for null test;
    public boolean log(int actualIdx, int newLineIdx) { // can throw? right?
        return lexLog.log(actualIdx, newLineIdx);
    }

    public char getWrappedChar() {
        return wrappedChar;
    }

    public Position getCharPosition() {
        return charPosition;
    }




    public char currentChar() {
        return wrappedChar;
    }
}

class Position {
    int row = 1;
    int column;  // should be private ? write ?
}
