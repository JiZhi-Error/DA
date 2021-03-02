package com.eclipsesource.v8;

public class V8ScriptExecutionException extends V8ScriptException {
    V8ScriptExecutionException(String str, int i2, String str2, String str3, int i3, int i4, String str4) {
        this(0, str, i2, str2, str3, i3, i4, str4, null);
    }

    V8ScriptExecutionException(int i2, String str, int i3, String str2, String str3, int i4, int i5, String str4, Throwable th) {
        super(i2, str, i3, str2, str3, i4, i5, str4, th);
    }
}
