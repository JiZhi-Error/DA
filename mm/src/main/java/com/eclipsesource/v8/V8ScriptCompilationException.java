package com.eclipsesource.v8;

public class V8ScriptCompilationException extends V8ScriptException {
    V8ScriptCompilationException(String str, int i2, String str2, String str3, int i3, int i4) {
        super(0, str, i2, str2, str3, i3, i4, null, null);
    }

    V8ScriptCompilationException(int i2, String str, int i3, String str2, String str3, int i4, int i5) {
        super(i2, str, i3, str2, str3, i4, i5, null, null);
    }
}
