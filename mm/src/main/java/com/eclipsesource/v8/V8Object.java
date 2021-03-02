package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class V8Object extends V8Value {
    public V8Object(V8 v8) {
        this(v8, null);
    }

    protected V8Object(V8 v8, Object obj) {
        super(v8);
        AppMethodBeat.i(62166);
        if (v8 != null) {
            this.v8.checkThread();
            initialize(this.v8.getV8RuntimePtr(), obj);
        }
        AppMethodBeat.o(62166);
    }

    protected V8Object() {
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value
    public V8Value createTwin() {
        AppMethodBeat.i(62167);
        V8Object v8Object = new V8Object(this.v8);
        AppMethodBeat.o(62167);
        return v8Object;
    }

    @Override // com.eclipsesource.v8.V8Value
    public V8Object twin() {
        AppMethodBeat.i(62168);
        V8Object v8Object = (V8Object) super.twin();
        AppMethodBeat.o(62168);
        return v8Object;
    }

    public boolean contains(String str) {
        AppMethodBeat.i(62169);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        boolean contains = this.v8.contains(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62169);
        return contains;
    }

    public String[] getKeys() {
        AppMethodBeat.i(62170);
        this.v8.checkThread();
        checkReleased();
        String[] keys = this.v8.getKeys(this.v8.getV8RuntimePtr(), this.objectHandle);
        AppMethodBeat.o(62170);
        return keys;
    }

    public int getType(String str) {
        AppMethodBeat.i(62171);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        int type = this.v8.getType(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62171);
        return type;
    }

    public Object get(String str) {
        AppMethodBeat.i(62172);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        AppMethodBeat.o(62172);
        return obj;
    }

    public int getInteger(String str) {
        AppMethodBeat.i(62173);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        int integer = this.v8.getInteger(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62173);
        return integer;
    }

    public boolean getBoolean(String str) {
        AppMethodBeat.i(62174);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        boolean z = this.v8.getBoolean(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62174);
        return z;
    }

    public double getDouble(String str) {
        AppMethodBeat.i(62175);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        double d2 = this.v8.getDouble(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62175);
        return d2;
    }

    public String getString(String str) {
        AppMethodBeat.i(62176);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        String string = this.v8.getString(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62176);
        return string;
    }

    public V8Array getArray(String str) {
        AppMethodBeat.i(62177);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Array)) {
            V8Array v8Array = (V8Array) obj;
            AppMethodBeat.o(62177);
            return v8Array;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(62177);
        throw v8ResultUndefined;
    }

    public V8Object getObject(String str) {
        AppMethodBeat.i(62178);
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Object)) {
            V8Object v8Object = (V8Object) obj;
            AppMethodBeat.o(62178);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(62178);
        throw v8ResultUndefined;
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62179);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        int executeIntegerFunction = this.v8.executeIntegerFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62179);
        return executeIntegerFunction;
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62180);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        double executeDoubleFunction = this.v8.executeDoubleFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62180);
        return executeDoubleFunction;
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62181);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        String executeStringFunction = this.v8.executeStringFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62181);
        return executeStringFunction;
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62182);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        boolean executeBooleanFunction = this.v8.executeBooleanFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62182);
        return executeBooleanFunction;
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62183);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 5, this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        if (executeFunction instanceof V8Array) {
            V8Array v8Array2 = (V8Array) executeFunction;
            AppMethodBeat.o(62183);
            return v8Array2;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(62183);
        throw v8ResultUndefined;
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62184);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        if (executeFunction instanceof V8Object) {
            V8Object v8Object = (V8Object) executeFunction;
            AppMethodBeat.o(62184);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(62184);
        throw v8ResultUndefined;
    }

    public Object executeFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62185);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 0, this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62185);
        return executeFunction;
    }

    public Object executeJSFunction(String str) {
        AppMethodBeat.i(62186);
        Object executeFunction = executeFunction(str, null);
        AppMethodBeat.o(62186);
        return executeFunction;
    }

    public Object executeJSFunction(String str, Object... objArr) {
        AppMethodBeat.i(62187);
        if (objArr == null) {
            Object executeFunction = executeFunction(str, null);
            AppMethodBeat.o(62187);
            return executeFunction;
        }
        V8Array v8Array = new V8Array(this.v8.getRuntime());
        try {
            for (Object obj : objArr) {
                if (obj == null) {
                    v8Array.pushNull();
                } else if (obj instanceof V8Value) {
                    v8Array.push((V8Value) obj);
                } else if (obj instanceof Integer) {
                    v8Array.push((Integer) obj);
                } else if (obj instanceof Double) {
                    v8Array.push((Double) obj);
                } else if (obj instanceof Long) {
                    v8Array.push(((Long) obj).doubleValue());
                } else if (obj instanceof Float) {
                    v8Array.push((double) ((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    v8Array.push((Boolean) obj);
                } else if (obj instanceof String) {
                    v8Array.push((String) obj);
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported Object of type: " + obj.getClass());
                    AppMethodBeat.o(62187);
                    throw illegalArgumentException;
                }
            }
            return executeFunction(str, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(62187);
        }
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        AppMethodBeat.i(62188);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        this.v8.executeVoidFunction(this.v8.getV8RuntimePtr(), this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62188);
    }

    public V8Object add(String str, int i2) {
        AppMethodBeat.i(62189);
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, i2);
        AppMethodBeat.o(62189);
        return this;
    }

    public V8Object add(String str, boolean z) {
        AppMethodBeat.i(62190);
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, z);
        AppMethodBeat.o(62190);
        return this;
    }

    public V8Object add(String str, double d2) {
        AppMethodBeat.i(62191);
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, d2);
        AppMethodBeat.o(62191);
        return this;
    }

    public V8Object add(String str, String str2) {
        AppMethodBeat.i(62192);
        this.v8.checkThread();
        checkReleased();
        if (str2 == null) {
            this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(V8.getUndefined())) {
            this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        AppMethodBeat.o(62192);
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        AppMethodBeat.i(62193);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.v8.addObject(this.v8.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        AppMethodBeat.o(62193);
        return this;
    }

    public V8Object addUndefined(String str) {
        AppMethodBeat.i(62194);
        this.v8.checkThread();
        checkReleased();
        this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62194);
        return this;
    }

    public V8Object addNull(String str) {
        AppMethodBeat.i(62195);
        this.v8.checkThread();
        checkReleased();
        this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.o(62195);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        AppMethodBeat.i(62196);
        this.v8.checkThread();
        checkReleased();
        this.v8.setPrototype(this.v8.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
        AppMethodBeat.o(62196);
        return this;
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        AppMethodBeat.i(62197);
        this.v8.checkThread();
        checkReleased();
        this.v8.registerCallback(javaCallback, getHandle(), str);
        AppMethodBeat.o(62197);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        AppMethodBeat.i(62198);
        this.v8.checkThread();
        checkReleased();
        this.v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
        AppMethodBeat.o(62198);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        AppMethodBeat.i(62199);
        V8Object registerJavaMethod = registerJavaMethod(obj, str, str2, clsArr, false);
        AppMethodBeat.o(62199);
        return registerJavaMethod;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        AppMethodBeat.i(62200);
        this.v8.checkThread();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.v8.registerCallback(obj, method, getHandle(), str2, z);
            AppMethodBeat.o(62200);
            return this;
        } catch (NoSuchMethodException e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.o(62200);
            throw illegalStateException;
        } catch (SecurityException e3) {
            IllegalStateException illegalStateException2 = new IllegalStateException(e3);
            AppMethodBeat.o(62200);
            throw illegalStateException2;
        }
    }

    public String toString() {
        AppMethodBeat.i(62201);
        if (isReleased() || this.v8.isReleased()) {
            AppMethodBeat.o(62201);
            return "[Object released]";
        }
        this.v8.checkThread();
        String v8 = this.v8.toString(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(62201);
        return v8;
    }

    private void checkKey(String str) {
        AppMethodBeat.i(62202);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Key cannot be null");
            AppMethodBeat.o(62202);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(62202);
    }

    static class Undefined extends V8Object {
        @Override // com.eclipsesource.v8.V8Value
        public boolean isUndefined() {
            return true;
        }

        @Override // com.eclipsesource.v8.V8Value
        public boolean isReleased() {
            return false;
        }

        @Override // com.eclipsesource.v8.V8Value, com.eclipsesource.v8.Releasable
        public void release() {
        }

        @Override // com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
        public Undefined twin() {
            AppMethodBeat.i(62133);
            Undefined undefined = (Undefined) V8Object.super.twin();
            AppMethodBeat.o(62133);
            return undefined;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.eclipsesource.v8.V8Value
        public boolean equals(Object obj) {
            AppMethodBeat.i(62134);
            if (!(obj instanceof V8Object) || !((V8Object) obj).isUndefined()) {
                AppMethodBeat.o(62134);
                return false;
            }
            AppMethodBeat.o(62134);
            return true;
        }

        @Override // com.eclipsesource.v8.V8Value
        public int hashCode() {
            return 919;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, boolean z) {
            AppMethodBeat.i(62135);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62135);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Value
        public V8 getRuntime() {
            AppMethodBeat.i(62136);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62136);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, double d2) {
            AppMethodBeat.i(62137);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62137);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, int i2) {
            AppMethodBeat.i(62138);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62138);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public Object executeJSFunction(String str, Object... objArr) {
            AppMethodBeat.i(62139);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62139);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public Object executeFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62140);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62140);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, String str2) {
            AppMethodBeat.i(62141);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62141);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            AppMethodBeat.i(62142);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62142);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object addUndefined(String str) {
            AppMethodBeat.i(62143);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62143);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public boolean contains(String str) {
            AppMethodBeat.i(62144);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62144);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62145);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62145);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62146);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62146);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public double executeDoubleFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62147);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62147);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public int executeIntegerFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62148);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62148);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62149);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62149);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62150);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62150);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(62151);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62151);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Array getArray(String str) {
            AppMethodBeat.i(62152);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62152);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public boolean getBoolean(String str) {
            AppMethodBeat.i(62153);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62153);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public double getDouble(String str) {
            AppMethodBeat.i(62154);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62154);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public int getInteger(String str) {
            AppMethodBeat.i(62155);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62155);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String[] getKeys() {
            AppMethodBeat.i(62156);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62156);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object getObject(String str) {
            AppMethodBeat.i(62157);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62157);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String getString(String str) {
            AppMethodBeat.i(62158);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62158);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public int getType(String str) {
            AppMethodBeat.i(62159);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62159);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            AppMethodBeat.i(62160);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62160);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            AppMethodBeat.i(62161);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62161);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            AppMethodBeat.i(62162);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62162);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            AppMethodBeat.i(62163);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62163);
            throw unsupportedOperationException;
        }
    }
}
