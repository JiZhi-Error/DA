package com.eclipsesource.v8;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public interface V8Context {
    V8Object add(String str, double d2);

    V8Object add(String str, int i2);

    V8Object add(String str, V8Value v8Value);

    V8Object add(String str, String str2);

    V8Object add(String str, boolean z);

    V8Object addNull(String str);

    V8Object addUndefined(String str);

    boolean contains(String str);

    V8Array executeArrayFunction(String str, V8Array v8Array);

    V8Array executeArrayScript(String str, ExecuteDetails executeDetails);

    V8Array executeArrayScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    V8Array executeArrayScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    boolean executeBooleanFunction(String str, V8Array v8Array);

    boolean executeBooleanScript(String str, ExecuteDetails executeDetails);

    boolean executeBooleanScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    boolean executeBooleanScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    String executeDebugScript(String str, String str2);

    double executeDoubleFunction(String str, V8Array v8Array);

    double executeDoubleScript(String str, ExecuteDetails executeDetails);

    double executeDoubleScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    double executeDoubleScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    Object executeFunction(String str, V8Array v8Array);

    int executeIntegerFunction(String str, V8Array v8Array);

    int executeIntegerScript(String str, ExecuteDetails executeDetails);

    int executeIntegerScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    int executeIntegerScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    Object executeJSFunction(String str);

    Object executeJSFunction(String str, Object... objArr);

    V8Object executeObjectFunction(String str, V8Array v8Array);

    V8Object executeObjectScript(String str, ExecuteDetails executeDetails);

    V8Object executeObjectScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    V8Object executeObjectScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    Object executeScript(String str, ExecuteDetails executeDetails);

    Object executeScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    Object executeScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    String executeStringFunction(String str, V8Array v8Array);

    String executeStringScript(String str, ExecuteDetails executeDetails);

    String executeStringScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    String executeStringScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    void executeVoidFunction(String str, V8Array v8Array);

    void executeVoidScript(String str, ExecuteDetails executeDetails);

    void executeVoidScript(String str, String str2, int i2, ExecuteDetails executeDetails);

    void executeVoidScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    Object executeWxaScript(ArrayList<ScriptPartObject> arrayList, String str, int i2, String str2, String str3, int i3, ExecuteDetails executeDetails);

    Object get(String str);

    V8Array getArray(String str);

    boolean getBoolean(String str);

    double getDouble(String str);

    V8Object getGlobalObject();

    int getInteger(String str);

    String[] getKeys();

    V8Object getObject(String str);

    long getPtr();

    String getString(String str);

    int getType(String str);

    boolean isReleased();

    SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer byteBuffer);

    V8Array newV8Array();

    V8ArrayBuffer newV8ArrayBuffer(int i2);

    V8ArrayBuffer newV8ArrayBuffer(ByteBuffer byteBuffer);

    V8Function newV8Function(JavaCallback javaCallback);

    V8Object newV8Object();

    V8TypedArray newV8TypedArray(V8ArrayBuffer v8ArrayBuffer, int i2, int i3, int i4);

    V8Object registerJavaMethod(JavaCallback javaCallback, String str);

    V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str);

    V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr);

    V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z);

    void release();

    void shareObject(String str, V8Context v8Context);

    void shareObject(String str, V8Context v8Context, String str2);
}
