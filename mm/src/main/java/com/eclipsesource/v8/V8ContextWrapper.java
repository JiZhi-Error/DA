package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class V8ContextWrapper implements InvocationHandler {
    private static final String TAG = "V8ContextWrapper";
    private final MultiContextV8 multiContextV8;
    private final V8Context proxy = ((V8Context) Proxy.newProxyInstance(V8ContextWrapper.class.getClassLoader(), new Class[]{V8Context.class}, this));
    private final V8ContextImpl v8ContextImpl;
    private final long v8ContextPtr;

    V8ContextWrapper(MultiContextV8 multiContextV82, long j2) {
        AppMethodBeat.i(62112);
        this.multiContextV8 = multiContextV82;
        this.v8ContextPtr = j2;
        enterContext();
        this.v8ContextImpl = new V8ContextImpl(j2);
        AppMethodBeat.o(62112);
    }

    public V8Context context() {
        return this.proxy;
    }

    /* access modifiers changed from: protected */
    public long getPtr() {
        return this.v8ContextPtr;
    }

    private void enterContext() {
        AppMethodBeat.i(62113);
        this.multiContextV8.enterContext(this);
        AppMethodBeat.o(62113);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(62114);
        if (this == obj) {
            AppMethodBeat.o(62114);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(62114);
            return false;
        } else if (this.v8ContextPtr == ((V8ContextWrapper) obj).v8ContextPtr) {
            AppMethodBeat.o(62114);
            return true;
        } else {
            AppMethodBeat.o(62114);
            return false;
        }
    }

    public int hashCode() {
        return (int) (this.v8ContextPtr ^ (this.v8ContextPtr >>> 32));
    }

    final class V8ContextImpl extends V8Object implements V8Context {
        private final long ptr;

        V8ContextImpl(long j2) {
            super(V8ContextWrapper.this.multiContextV8.getV8());
            AppMethodBeat.i(62075);
            this.objectHandle = this.v8.getGlobalObject();
            this.ptr = j2;
            AppMethodBeat.o(62075);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final void executeVoidScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62076);
            this.v8.executeVoidScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62076);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final void executeVoidScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62077);
            this.v8.executeVoidScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62077);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final void executeVoidScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62078);
            this.v8.executeVoidScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62078);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final Object executeWxaScript(ArrayList<ScriptPartObject> arrayList, String str, int i2, String str2, String str3, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(175414);
            Object executeWxaScript = this.v8.executeWxaScript(arrayList, str, i2, str2, str3, i3, executeDetails);
            AppMethodBeat.o(175414);
            return executeWxaScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final int executeIntegerScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62079);
            int executeIntegerScript = this.v8.executeIntegerScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62079);
            return executeIntegerScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final int executeIntegerScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62080);
            int executeIntegerScript = this.v8.executeIntegerScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62080);
            return executeIntegerScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final int executeIntegerScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62081);
            int executeIntegerScript = this.v8.executeIntegerScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62081);
            return executeIntegerScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final double executeDoubleScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62082);
            double executeDoubleScript = this.v8.executeDoubleScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62082);
            return executeDoubleScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final double executeDoubleScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62083);
            double executeDoubleScript = this.v8.executeDoubleScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62083);
            return executeDoubleScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final double executeDoubleScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62084);
            double executeDoubleScript = this.v8.executeDoubleScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62084);
            return executeDoubleScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final String executeStringScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62085);
            String executeStringScript = this.v8.executeStringScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62085);
            return executeStringScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final String executeStringScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62086);
            String executeStringScript = this.v8.executeStringScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62086);
            return executeStringScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final String executeStringScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62087);
            String executeStringScript = this.v8.executeStringScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62087);
            return executeStringScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final boolean executeBooleanScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62088);
            boolean executeBooleanScript = this.v8.executeBooleanScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62088);
            return executeBooleanScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final boolean executeBooleanScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62089);
            boolean executeBooleanScript = this.v8.executeBooleanScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62089);
            return executeBooleanScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final boolean executeBooleanScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62090);
            boolean executeBooleanScript = this.v8.executeBooleanScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62090);
            return executeBooleanScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Array executeArrayScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62091);
            V8Array executeArrayScript = this.v8.executeArrayScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62091);
            return executeArrayScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Array executeArrayScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62092);
            V8Array executeArrayScript = this.v8.executeArrayScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62092);
            return executeArrayScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Array executeArrayScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62093);
            V8Array executeArrayScript = this.v8.executeArrayScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62093);
            return executeArrayScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final Object executeScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62094);
            Object executeScript = this.v8.executeScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62094);
            return executeScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final Object executeScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62095);
            Object executeScript = this.v8.executeScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62095);
            return executeScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final Object executeScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62096);
            Object executeScript = this.v8.executeScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62096);
            return executeScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Object executeObjectScript(String str, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62097);
            V8Object executeObjectScript = this.v8.executeObjectScript(str, null, 0, null, null, 0, executeDetails);
            AppMethodBeat.o(62097);
            return executeObjectScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Object executeObjectScript(String str, String str2, int i2, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62098);
            V8Object executeObjectScript = this.v8.executeObjectScript(str, str2, i2, null, null, 0, executeDetails);
            AppMethodBeat.o(62098);
            return executeObjectScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Object executeObjectScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
            AppMethodBeat.i(62099);
            V8Object executeObjectScript = this.v8.executeObjectScript(str, str2, i2, str3, str4, i3, executeDetails);
            AppMethodBeat.o(62099);
            return executeObjectScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final void shareObject(String str, V8Context v8Context) {
            AppMethodBeat.i(62100);
            shareObjectImpl(str, v8Context, null);
            AppMethodBeat.o(62100);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final void shareObject(String str, V8Context v8Context, String str2) {
            AppMethodBeat.i(62101);
            shareObjectImpl(str, v8Context, str2);
            AppMethodBeat.o(62101);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Object newV8Object() {
            AppMethodBeat.i(62102);
            V8Object v8Object = new V8Object(this.v8);
            AppMethodBeat.o(62102);
            return v8Object;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Array newV8Array() {
            AppMethodBeat.i(62103);
            V8Array v8Array = new V8Array(this.v8);
            AppMethodBeat.o(62103);
            return v8Array;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8ArrayBuffer newV8ArrayBuffer(int i2) {
            AppMethodBeat.i(62104);
            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.v8, i2);
            AppMethodBeat.o(62104);
            return v8ArrayBuffer;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8ArrayBuffer newV8ArrayBuffer(ByteBuffer byteBuffer) {
            AppMethodBeat.i(62105);
            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.v8, byteBuffer);
            AppMethodBeat.o(62105);
            return v8ArrayBuffer;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer byteBuffer) {
            AppMethodBeat.i(62106);
            SharedV8ArrayBuffer sharedV8ArrayBuffer = new SharedV8ArrayBuffer(this.v8, byteBuffer);
            AppMethodBeat.o(62106);
            return sharedV8ArrayBuffer;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Function newV8Function(JavaCallback javaCallback) {
            AppMethodBeat.i(62107);
            V8Function v8Function = new V8Function(this.v8, javaCallback);
            AppMethodBeat.o(62107);
            return v8Function;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8TypedArray newV8TypedArray(V8ArrayBuffer v8ArrayBuffer, int i2, int i3, int i4) {
            AppMethodBeat.i(62108);
            V8TypedArray v8TypedArray = new V8TypedArray(this.v8, v8ArrayBuffer, i2, i3, i4);
            AppMethodBeat.o(62108);
            return v8TypedArray;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final String executeDebugScript(String str, String str2) {
            AppMethodBeat.i(62109);
            String executeDebugScript = this.v8.executeDebugScript(str, str2);
            AppMethodBeat.o(62109);
            return executeDebugScript;
        }

        @Override // com.eclipsesource.v8.V8Context
        public final V8Object getGlobalObject() {
            return this;
        }

        @Override // com.eclipsesource.v8.V8Context, com.eclipsesource.v8.V8Value, com.eclipsesource.v8.Releasable
        public final void release() {
            AppMethodBeat.i(62110);
            if (isReleased()) {
                AppMethodBeat.o(62110);
                return;
            }
            this.v8.releaseObjRef(this);
            V8ContextWrapper.this.multiContextV8.releaseContext(V8ContextWrapper.this);
            this.released = true;
            AppMethodBeat.o(62110);
        }

        @Override // com.eclipsesource.v8.V8Context
        public final long getPtr() {
            return this.ptr;
        }

        private void shareObjectImpl(String str, V8Context v8Context, String str2) {
            AppMethodBeat.i(62111);
            checkReleased();
            this.v8.checkThread();
            if (str == null || str.isEmpty()) {
                AppMethodBeat.o(62111);
            } else if (v8Context == null) {
                AppMethodBeat.o(62111);
            } else {
                V8Object object = getObject(str);
                if (str2 == null || str2.isEmpty()) {
                    str2 = str;
                }
                v8Context.add(str2, object);
                object.release();
                AppMethodBeat.o(62111);
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(62115);
        if (!method.getName().equals("isReleased")) {
            this.v8ContextImpl.checkReleased();
            enterContext();
        }
        try {
            Object invoke = method.invoke(this.v8ContextImpl, objArr);
            AppMethodBeat.o(62115);
            return invoke;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            AppMethodBeat.o(62115);
            throw cause;
        }
    }
}
