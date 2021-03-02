package com.eclipsesource.v8;

import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;

public abstract class V8Value implements Releasable {
    public static final int BOOLEAN = 3;
    public static final int BYTE = 9;
    public static final int DOUBLE = 2;
    public static final int FLOAT_32_ARRAY = 16;
    public static final int FLOAT_64_ARRAY = 2;
    public static final int INTEGER = 1;
    public static final int INT_16_ARRAY = 13;
    public static final int INT_32_ARRAY = 1;
    public static final int INT_8_ARRAY = 9;
    public static final int NULL = 0;
    public static final int STRING = 4;
    public static final int UNDEFINED = 99;
    public static final int UNKNOWN = 0;
    public static final int UNSIGNED_INT_16_ARRAY = 14;
    public static final int UNSIGNED_INT_32_ARRAY = 15;
    public static final int UNSIGNED_INT_8_ARRAY = 11;
    public static final int UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
    public static final int V8_ARRAY = 5;
    public static final int V8_ARRAY_BUFFER = 10;
    public static final int V8_FUNCTION = 7;
    public static final int V8_OBJECT = 6;
    public static final int V8_TYPED_ARRAY = 8;
    protected long objectHandle;
    protected boolean released = true;
    protected V8 v8;

    /* access modifiers changed from: protected */
    public abstract V8Value createTwin();

    protected V8Value() {
    }

    protected V8Value(V8 v82) {
        if (v82 == null) {
            this.v8 = (V8) this;
        } else {
            this.v8 = v82;
        }
    }

    /* access modifiers changed from: protected */
    public void initialize(long j2, Object obj) {
        long initNewV8Object = this.v8.initNewV8Object(j2);
        this.released = false;
        addObjectReference(initNewV8Object);
    }

    /* access modifiers changed from: protected */
    public void addObjectReference(long j2) {
        this.objectHandle = j2;
        try {
            this.v8.addObjRef(this);
        } catch (Error e2) {
            release();
            throw e2;
        } catch (RuntimeException e3) {
            release();
            throw e3;
        }
    }

    @Deprecated
    public static String getStringRepresentaion(int i2) {
        return getStringRepresentation(i2);
    }

    public static String getStringRepresentation(int i2) {
        switch (i2) {
            case 0:
                return "Null";
            case 1:
                return DownloadSetting.TYPE_INTEGER;
            case 2:
                return "Double";
            case 3:
                return "Boolean";
            case 4:
                return "String";
            case 5:
                return "V8Array";
            case 6:
                return "V8Object";
            case 7:
                return "V8Function";
            case 8:
                return "V8TypedArray";
            case 9:
                return "Byte";
            case 10:
                return "V8ArrayBuffer";
            case 11:
                return "UInt8Array";
            case 12:
                return "UInt8ClampedArray";
            case 13:
                return "Int16Array";
            case 14:
                return "UInt16Array";
            case 15:
                return "UInt32Array";
            case 16:
                return "Float32Array";
            case 99:
                return "Undefined";
            default:
                throw new IllegalArgumentException("Invalid V8 type: ".concat(String.valueOf(i2)));
        }
    }

    public boolean isUndefined() {
        return false;
    }

    public V8 getRuntime() {
        return this.v8;
    }

    public int getV8Type() {
        if (isUndefined()) {
            return 99;
        }
        this.v8.checkThread();
        this.v8.checkReleased();
        return this.v8.getType(this.v8.getV8RuntimePtr(), this.objectHandle);
    }

    public V8Value twin() {
        if (isUndefined()) {
            return this;
        }
        this.v8.checkThread();
        this.v8.checkReleased();
        V8Value createTwin = createTwin();
        this.v8.createTwin(this, createTwin);
        return createTwin;
    }

    public V8Value setWeak() {
        this.v8.checkThread();
        this.v8.checkReleased();
        this.v8.v8WeakReferences.put(Long.valueOf(getHandle()), this);
        this.v8.setWeak(this.v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    public boolean isWeak() {
        this.v8.checkThread();
        this.v8.checkReleased();
        return this.v8.isWeak(this.v8.getV8RuntimePtr(), getHandle());
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        this.v8.checkThread();
        if (!this.released) {
            try {
                this.v8.releaseObjRef(this);
            } finally {
                this.released = true;
                this.v8.release(this.v8.getV8RuntimePtr(), this.objectHandle);
            }
        }
    }

    public boolean isReleased() {
        return this.released;
    }

    public boolean strictEquals(Object obj) {
        this.v8.checkThread();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        if (((V8Value) obj).isUndefined()) {
            return false;
        }
        return this.v8.strictEquals(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
    }

    /* access modifiers changed from: protected */
    public long getHandle() {
        checkReleased();
        return this.objectHandle;
    }

    public boolean equals(Object obj) {
        return strictEquals(obj);
    }

    public boolean jsEquals(Object obj) {
        this.v8.checkThread();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        if (((V8Value) obj).isUndefined()) {
            return false;
        }
        return this.v8.equals(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
    }

    public int hashCode() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.identityHash(this.v8.getV8RuntimePtr(), getHandle());
    }

    /* access modifiers changed from: protected */
    public void checkReleased() {
        if (this.released) {
            throw new IllegalStateException("Object released");
        }
    }
}
