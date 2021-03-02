package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class V8TypedArray extends V8Array {
    public V8TypedArray(V8 v8, V8ArrayBuffer v8ArrayBuffer, int i2, int i3, int i4) {
        super(v8, new V8ArrayData(v8ArrayBuffer, i3, i4, i2));
        AppMethodBeat.i(62204);
        AppMethodBeat.o(62204);
    }

    private V8TypedArray(V8 v8) {
        super(v8);
    }

    public V8ArrayBuffer getBuffer() {
        AppMethodBeat.i(62205);
        V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) get("buffer");
        AppMethodBeat.o(62205);
        return v8ArrayBuffer;
    }

    public ByteBuffer getByteBuffer() {
        AppMethodBeat.i(62206);
        V8ArrayBuffer buffer = getBuffer();
        try {
            return buffer.getBackingStore();
        } finally {
            buffer.release();
            AppMethodBeat.o(62206);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Value
    public void initialize(long j2, Object obj) {
        AppMethodBeat.i(62207);
        this.v8.checkThread();
        if (obj == null) {
            super.initialize(j2, obj);
            AppMethodBeat.o(62207);
            return;
        }
        V8ArrayData v8ArrayData = (V8ArrayData) obj;
        checkArrayProperties(v8ArrayData);
        long createTypedArray = createTypedArray(j2, v8ArrayData);
        this.released = false;
        addObjectReference(createTypedArray);
        AppMethodBeat.o(62207);
    }

    private long createTypedArray(long j2, V8ArrayData v8ArrayData) {
        AppMethodBeat.i(62208);
        switch (v8ArrayData.type) {
            case 1:
                long initNewV8Int32Array = this.v8.initNewV8Int32Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8Int32Array;
            case 2:
                long initNewV8Float64Array = this.v8.initNewV8Float64Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8Float64Array;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
                AppMethodBeat.o(62208);
                throw illegalArgumentException;
            case 9:
                long initNewV8Int8Array = this.v8.initNewV8Int8Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8Int8Array;
            case 11:
                long initNewV8UInt8Array = this.v8.initNewV8UInt8Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8UInt8Array;
            case 12:
                long initNewV8UInt8ClampedArray = this.v8.initNewV8UInt8ClampedArray(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8UInt8ClampedArray;
            case 13:
                long initNewV8Int16Array = this.v8.initNewV8Int16Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8Int16Array;
            case 14:
                long initNewV8UInt16Array = this.v8.initNewV8UInt16Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8UInt16Array;
            case 15:
                long initNewV8UInt32Array = this.v8.initNewV8UInt32Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8UInt32Array;
            case 16:
                long initNewV8Float32Array = this.v8.initNewV8Float32Array(j2, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(62208);
                return initNewV8Float32Array;
        }
    }

    public static int getStructureSize(int i2) {
        AppMethodBeat.i(62209);
        switch (i2) {
            case 1:
            case 15:
            case 16:
                AppMethodBeat.o(62209);
                return 4;
            case 2:
                AppMethodBeat.o(62209);
                return 8;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i2));
                AppMethodBeat.o(62209);
                throw illegalArgumentException;
            case 9:
            case 11:
            case 12:
                AppMethodBeat.o(62209);
                return 1;
            case 13:
            case 14:
                AppMethodBeat.o(62209);
                return 2;
        }
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        AppMethodBeat.i(62210);
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
        AppMethodBeat.o(62210);
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        AppMethodBeat.i(62211);
        if (v8ArrayData.size < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("RangeError: Invalid typed array length");
            AppMethodBeat.o(62211);
            throw illegalStateException;
        } else if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.getBackingStore().limit()) {
            IllegalStateException illegalStateException2 = new IllegalStateException("RangeError: Invalid typed array length");
            AppMethodBeat.o(62211);
            throw illegalStateException2;
        } else {
            AppMethodBeat.o(62211);
        }
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        AppMethodBeat.i(62212);
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
            AppMethodBeat.o(62212);
            throw illegalStateException;
        }
        AppMethodBeat.o(62212);
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
    public V8Value createTwin() {
        AppMethodBeat.i(62213);
        V8TypedArray v8TypedArray = new V8TypedArray(this.v8);
        AppMethodBeat.o(62213);
        return v8TypedArray;
    }

    /* access modifiers changed from: package-private */
    public static class V8ArrayData {
        private V8ArrayBuffer buffer;
        private int offset;
        private int size;
        private int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i2, int i3, int i4) {
            this.buffer = v8ArrayBuffer;
            this.offset = i2;
            this.size = i3;
            this.type = i4;
        }
    }
}
