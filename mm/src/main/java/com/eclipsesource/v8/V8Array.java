package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Array extends V8Object {
    protected V8Array() {
    }

    public V8Array(V8 v8) {
        super(v8);
        AppMethodBeat.i(62029);
        v8.checkThread();
        AppMethodBeat.o(62029);
    }

    protected V8Array(V8 v8, Object obj) {
        super(v8, obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
    public V8Value createTwin() {
        AppMethodBeat.i(62030);
        V8Array v8Array = new V8Array(this.v8);
        AppMethodBeat.o(62030);
        return v8Array;
    }

    @Override // com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
    public V8Array twin() {
        AppMethodBeat.i(62031);
        V8Array v8Array = (V8Array) super.twin();
        AppMethodBeat.o(62031);
        return v8Array;
    }

    @Override // com.eclipsesource.v8.V8Object
    public String toString() {
        AppMethodBeat.i(62032);
        if (this.released || this.v8.isReleased()) {
            AppMethodBeat.o(62032);
            return "[Array released]";
        }
        String v8Object = super.toString();
        AppMethodBeat.o(62032);
        return v8Object;
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value
    public void initialize(long j2, Object obj) {
        AppMethodBeat.i(62033);
        long initNewV8Array = this.v8.initNewV8Array(j2);
        this.released = false;
        addObjectReference(initNewV8Array);
        AppMethodBeat.o(62033);
    }

    public int length() {
        AppMethodBeat.i(62034);
        this.v8.checkThread();
        checkReleased();
        int arrayGetSize = this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(62034);
        return arrayGetSize;
    }

    public int getType(int i2) {
        AppMethodBeat.i(62035);
        this.v8.checkThread();
        checkReleased();
        int type = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62035);
        return type;
    }

    public int getType() {
        AppMethodBeat.i(62036);
        this.v8.checkThread();
        checkReleased();
        int arrayType = this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(62036);
        return arrayType;
    }

    public int getType(int i2, int i3) {
        AppMethodBeat.i(62037);
        this.v8.checkThread();
        checkReleased();
        int type = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), i2, i3);
        AppMethodBeat.o(62037);
        return type;
    }

    public int getInteger(int i2) {
        AppMethodBeat.i(62038);
        this.v8.checkThread();
        checkReleased();
        int arrayGetInteger = this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62038);
        return arrayGetInteger;
    }

    public boolean getBoolean(int i2) {
        AppMethodBeat.i(62039);
        this.v8.checkThread();
        checkReleased();
        boolean arrayGetBoolean = this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62039);
        return arrayGetBoolean;
    }

    public byte getByte(int i2) {
        AppMethodBeat.i(62040);
        this.v8.checkThread();
        checkReleased();
        byte arrayGetByte = this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62040);
        return arrayGetByte;
    }

    public double getDouble(int i2) {
        AppMethodBeat.i(62041);
        this.v8.checkThread();
        checkReleased();
        double arrayGetDouble = this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62041);
        return arrayGetDouble;
    }

    public String getString(int i2) {
        AppMethodBeat.i(62042);
        this.v8.checkThread();
        checkReleased();
        String arrayGetString = this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62042);
        return arrayGetString;
    }

    public int[] getIntegers(int i2, int i3) {
        AppMethodBeat.i(62043);
        this.v8.checkThread();
        checkReleased();
        int[] arrayGetIntegers = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), i2, i3);
        AppMethodBeat.o(62043);
        return arrayGetIntegers;
    }

    public int getIntegers(int i2, int i3, int[] iArr) {
        AppMethodBeat.i(62044);
        this.v8.checkThread();
        checkReleased();
        if (i3 > iArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(62044);
            throw indexOutOfBoundsException;
        }
        int arrayGetIntegers = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), i2, i3, iArr);
        AppMethodBeat.o(62044);
        return arrayGetIntegers;
    }

    public double[] getDoubles(int i2, int i3) {
        AppMethodBeat.i(62045);
        this.v8.checkThread();
        checkReleased();
        double[] arrayGetDoubles = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), i2, i3);
        AppMethodBeat.o(62045);
        return arrayGetDoubles;
    }

    public int getDoubles(int i2, int i3, double[] dArr) {
        AppMethodBeat.i(62046);
        this.v8.checkThread();
        checkReleased();
        if (i3 > dArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(62046);
            throw indexOutOfBoundsException;
        }
        int arrayGetDoubles = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), i2, i3, dArr);
        AppMethodBeat.o(62046);
        return arrayGetDoubles;
    }

    public boolean[] getBooleans(int i2, int i3) {
        AppMethodBeat.i(62047);
        this.v8.checkThread();
        checkReleased();
        boolean[] arrayGetBooleans = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), i2, i3);
        AppMethodBeat.o(62047);
        return arrayGetBooleans;
    }

    public byte[] getBytes(int i2, int i3) {
        AppMethodBeat.i(62048);
        this.v8.checkThread();
        checkReleased();
        byte[] arrayGetBytes = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), i2, i3);
        AppMethodBeat.o(62048);
        return arrayGetBytes;
    }

    public int getBooleans(int i2, int i3, boolean[] zArr) {
        AppMethodBeat.i(62049);
        this.v8.checkThread();
        checkReleased();
        if (i3 > zArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(62049);
            throw indexOutOfBoundsException;
        }
        int arrayGetBooleans = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), i2, i3, zArr);
        AppMethodBeat.o(62049);
        return arrayGetBooleans;
    }

    public int getBytes(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(62050);
        this.v8.checkThread();
        checkReleased();
        if (i3 > bArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(62050);
            throw indexOutOfBoundsException;
        }
        int arrayGetBytes = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), i2, i3, bArr);
        AppMethodBeat.o(62050);
        return arrayGetBytes;
    }

    public String[] getStrings(int i2, int i3) {
        AppMethodBeat.i(62051);
        this.v8.checkThread();
        checkReleased();
        String[] arrayGetStrings = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), i2, i3);
        AppMethodBeat.o(62051);
        return arrayGetStrings;
    }

    public int getStrings(int i2, int i3, String[] strArr) {
        AppMethodBeat.i(62052);
        this.v8.checkThread();
        checkReleased();
        if (i3 > strArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(62052);
            throw indexOutOfBoundsException;
        }
        int arrayGetStrings = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), i2, i3, strArr);
        AppMethodBeat.o(62052);
        return arrayGetStrings;
    }

    public Object get(int i2) {
        AppMethodBeat.i(62053);
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i2);
        AppMethodBeat.o(62053);
        return arrayGet;
    }

    public V8Array getArray(int i2) {
        AppMethodBeat.i(62054);
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, i2);
        if (arrayGet == null || (arrayGet instanceof V8Array)) {
            V8Array v8Array = (V8Array) arrayGet;
            AppMethodBeat.o(62054);
            return v8Array;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(62054);
        throw v8ResultUndefined;
    }

    public V8Object getObject(int i2) {
        AppMethodBeat.i(62055);
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i2);
        if (arrayGet == null || (arrayGet instanceof V8Object)) {
            V8Object v8Object = (V8Object) arrayGet;
            AppMethodBeat.o(62055);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(62055);
        throw v8ResultUndefined;
    }

    public V8Array push(int i2) {
        AppMethodBeat.i(62056);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), i2);
        AppMethodBeat.o(62056);
        return this;
    }

    public V8Array push(boolean z) {
        AppMethodBeat.i(62057);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), z);
        AppMethodBeat.o(62057);
        return this;
    }

    public V8Array push(double d2) {
        AppMethodBeat.i(62058);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), d2);
        AppMethodBeat.o(62058);
        return this;
    }

    public V8Array push(String str) {
        AppMethodBeat.i(62059);
        this.v8.checkThread();
        checkReleased();
        if (str == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), str);
        }
        AppMethodBeat.o(62059);
        return this;
    }

    public V8Array push(V8Value v8Value) {
        AppMethodBeat.i(62060);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        AppMethodBeat.o(62060);
        return this;
    }

    public V8Array push(Object obj) {
        AppMethodBeat.i(62061);
        this.v8.checkThread();
        checkReleased();
        if (obj instanceof V8Value) {
            this.v8.checkRuntime((V8Value) obj);
        }
        if (obj == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (obj instanceof V8Value) {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(62061);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(62061);
        return this;
    }

    public V8Array pushNull() {
        AppMethodBeat.i(62062);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(62062);
        return this;
    }

    public V8Array pushUndefined() {
        AppMethodBeat.i(62063);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(62063);
        return this;
    }

    static class Undefined extends V8Array {
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

        @Override // com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
        public Undefined twin() {
            AppMethodBeat.i(61969);
            Undefined undefined = (Undefined) V8Array.super.twin();
            AppMethodBeat.o(61969);
            return undefined;
        }

        @Override // com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.eclipsesource.v8.V8Value
        public boolean equals(Object obj) {
            AppMethodBeat.i(61970);
            if (!(obj instanceof V8Object) || !((V8Object) obj).isUndefined()) {
                AppMethodBeat.o(61970);
                return false;
            }
            AppMethodBeat.o(61970);
            return true;
        }

        @Override // com.eclipsesource.v8.V8Value
        public int hashCode() {
            return 919;
        }

        @Override // com.eclipsesource.v8.V8Value
        public V8 getRuntime() {
            AppMethodBeat.i(61971);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61971);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, boolean z) {
            AppMethodBeat.i(61972);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61972);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, double d2) {
            AppMethodBeat.i(61973);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61973);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, int i2) {
            AppMethodBeat.i(61974);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61974);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, String str2) {
            AppMethodBeat.i(61975);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61975);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            AppMethodBeat.i(61976);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61976);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object addUndefined(String str) {
            AppMethodBeat.i(61977);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61977);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public boolean contains(String str) {
            AppMethodBeat.i(61978);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61978);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61979);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61979);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61980);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61980);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public double executeDoubleFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61981);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61981);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public int executeIntegerFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61982);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61982);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61983);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61983);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61984);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61984);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(61985);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61985);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Array getArray(String str) {
            AppMethodBeat.i(61986);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61986);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public boolean getBoolean(String str) {
            AppMethodBeat.i(61987);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61987);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public double getDouble(String str) {
            AppMethodBeat.i(61988);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61988);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public int getInteger(String str) {
            AppMethodBeat.i(61989);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61989);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String[] getKeys() {
            AppMethodBeat.i(61990);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61990);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object getObject(String str) {
            AppMethodBeat.i(61991);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61991);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public String getString(String str) {
            AppMethodBeat.i(61992);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61992);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public int getType(String str) {
            AppMethodBeat.i(61993);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61993);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            AppMethodBeat.i(61994);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61994);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            AppMethodBeat.i(61995);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61995);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            AppMethodBeat.i(61996);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61996);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            AppMethodBeat.i(61997);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61997);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public Object get(int i2) {
            AppMethodBeat.i(61998);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61998);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array getArray(int i2) {
            AppMethodBeat.i(61999);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61999);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public boolean getBoolean(int i2) {
            AppMethodBeat.i(62000);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62000);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public boolean[] getBooleans(int i2, int i3) {
            AppMethodBeat.i(62001);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62001);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public byte[] getBytes(int i2, int i3) {
            AppMethodBeat.i(62002);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62002);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getBytes(int i2, int i3, byte[] bArr) {
            AppMethodBeat.i(62003);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62003);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public byte getByte(int i2) {
            AppMethodBeat.i(62004);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62004);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getBooleans(int i2, int i3, boolean[] zArr) {
            AppMethodBeat.i(62005);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62005);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public double getDouble(int i2) {
            AppMethodBeat.i(62006);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62006);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public double[] getDoubles(int i2, int i3) {
            AppMethodBeat.i(62007);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62007);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getDoubles(int i2, int i3, double[] dArr) {
            AppMethodBeat.i(62008);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62008);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getInteger(int i2) {
            AppMethodBeat.i(62009);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62009);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int[] getIntegers(int i2, int i3) {
            AppMethodBeat.i(62010);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62010);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getIntegers(int i2, int i3, int[] iArr) {
            AppMethodBeat.i(62011);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62011);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Object getObject(int i2) {
            AppMethodBeat.i(62012);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62012);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public String getString(int i2) {
            AppMethodBeat.i(62013);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62013);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public String[] getStrings(int i2, int i3) {
            AppMethodBeat.i(62014);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62014);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getStrings(int i2, int i3, String[] strArr) {
            AppMethodBeat.i(62015);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62015);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getType() {
            AppMethodBeat.i(62016);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62016);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getType(int i2) {
            AppMethodBeat.i(62017);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62017);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int getType(int i2, int i3) {
            AppMethodBeat.i(62018);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62018);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public int length() {
            AppMethodBeat.i(62019);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62019);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array push(boolean z) {
            AppMethodBeat.i(62020);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62020);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array push(double d2) {
            AppMethodBeat.i(62021);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62021);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array push(int i2) {
            AppMethodBeat.i(62022);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62022);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array push(String str) {
            AppMethodBeat.i(62023);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62023);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array push(V8Value v8Value) {
            AppMethodBeat.i(62024);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62024);
            throw unsupportedOperationException;
        }

        @Override // com.eclipsesource.v8.V8Array
        public V8Array pushUndefined() {
            AppMethodBeat.i(62025);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(62025);
            throw unsupportedOperationException;
        }
    }
}
