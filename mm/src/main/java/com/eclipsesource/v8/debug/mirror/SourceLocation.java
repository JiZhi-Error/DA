package com.eclipsesource.v8.debug.mirror;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceLocation {
    private final int column;
    private final int line;
    private final int position;
    private final String scriptName;
    private String sourceText;

    public SourceLocation(String str, int i2, int i3, int i4, String str2) {
        this.scriptName = str;
        this.position = i2;
        this.line = i3;
        this.column = i4;
        this.sourceText = str2;
    }

    public String toString() {
        AppMethodBeat.i(61532);
        String str = this.scriptName + " : " + this.position + " : " + this.line + " : " + this.column + " : " + this.sourceText;
        AppMethodBeat.o(61532);
        return str;
    }

    public String getScriptName() {
        return this.scriptName;
    }

    public int getPosition() {
        return this.position;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public String getSourceText() {
        return this.sourceText;
    }
}
