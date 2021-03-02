package com.eclipsesource.v8;

public abstract class V8ScriptException extends V8RuntimeException {
    private final int contextTag;
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    V8ScriptException(int i2, String str, int i3, String str2, String str3, int i4, int i5, String str4, Throwable th) {
        this.contextTag = i2;
        this.fileName = str;
        this.lineNumber = i3;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i4;
        this.endColumn = i5;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public int getContextTag() {
        return this.contextTag;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    public String toString() {
        return createMessageLine() + createMessageDetails() + createJSStackDetails() + "\n" + getClass().getName();
    }

    public String getMessage() {
        return createMessageLine();
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    private String createMessageLine() {
        return this.fileName + ":" + this.lineNumber + ": " + this.jsMessage;
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace != null) {
            return "\n" + this.jsStackTrace;
        }
        return "";
    }

    private String createMessageDetails() {
        StringBuilder sb = new StringBuilder();
        if (this.sourceLine != null && !this.sourceLine.isEmpty()) {
            sb.append('\n');
            sb.append(this.sourceLine);
            sb.append('\n');
            if (this.startColumn >= 0) {
                sb.append(createCharSequence(this.startColumn, ' '));
                sb.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return sb.toString();
    }

    private char[] createCharSequence(int i2, char c2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = c2;
        }
        return cArr;
    }
}
