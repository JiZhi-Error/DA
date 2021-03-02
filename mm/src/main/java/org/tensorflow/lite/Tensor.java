package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public final class Tensor {
    public final a Ujq;
    int[] Ujr;
    private final int[] Ujs;
    private final a Ujt;
    public long nativeHandle;

    private static native ByteBuffer buffer(long j2);

    private static native long create(long j2, int i2);

    private static native void delete(long j2);

    private static native int dtype(long j2);

    static native boolean hasDelegateBufferHandle(long j2);

    private static native int index(long j2);

    public static native String name(long j2);

    public static native int numBytes(long j2);

    private static native float quantizationScale(long j2);

    private static native int quantizationZeroPoint(long j2);

    static native void readMultiDimensionalArray(long j2, Object obj);

    private static native int[] shape(long j2);

    private static native int[] shapeSignature(long j2);

    static native void writeDirectBuffer(long j2, Buffer buffer);

    static native void writeMultiDimensionalArray(long j2, Object obj);

    static native void writeScalar(long j2, Object obj);

    static Tensor ax(long j2, int i2) {
        AppMethodBeat.i(238976);
        Tensor tensor = new Tensor(create(j2, i2));
        AppMethodBeat.o(238976);
        return tensor;
    }

    public static class a {
        private final int Uju;
        private final float scale;

        public a(float f2, int i2) {
            this.scale = f2;
            this.Uju = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void close() {
        AppMethodBeat.i(238977);
        delete(this.nativeHandle);
        this.nativeHandle = 0;
        AppMethodBeat.o(238977);
    }

    /* access modifiers changed from: package-private */
    public final void hQs() {
        AppMethodBeat.i(238978);
        this.Ujr = shape(this.nativeHandle);
        AppMethodBeat.o(238978);
    }

    private a gH(Object obj) {
        AppMethodBeat.i(238979);
        if (obj != null) {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                while (cls.isArray()) {
                    cls = cls.getComponentType();
                }
                if (Float.TYPE.equals(cls)) {
                    a aVar = a.FLOAT32;
                    AppMethodBeat.o(238979);
                    return aVar;
                } else if (Integer.TYPE.equals(cls)) {
                    a aVar2 = a.INT32;
                    AppMethodBeat.o(238979);
                    return aVar2;
                } else if (Byte.TYPE.equals(cls)) {
                    if (this.Ujq == a.STRING) {
                        a aVar3 = a.STRING;
                        AppMethodBeat.o(238979);
                        return aVar3;
                    }
                    a aVar4 = a.UINT8;
                    AppMethodBeat.o(238979);
                    return aVar4;
                } else if (Long.TYPE.equals(cls)) {
                    a aVar5 = a.INT64;
                    AppMethodBeat.o(238979);
                    return aVar5;
                } else if (Boolean.TYPE.equals(cls)) {
                    a aVar6 = a.BOOL;
                    AppMethodBeat.o(238979);
                    return aVar6;
                } else if (String.class.equals(cls)) {
                    a aVar7 = a.STRING;
                    AppMethodBeat.o(238979);
                    return aVar7;
                }
            } else if (Float.class.equals(cls) || (obj instanceof FloatBuffer)) {
                a aVar8 = a.FLOAT32;
                AppMethodBeat.o(238979);
                return aVar8;
            } else if (Integer.class.equals(cls) || (obj instanceof IntBuffer)) {
                a aVar9 = a.INT32;
                AppMethodBeat.o(238979);
                return aVar9;
            } else if (Byte.class.equals(cls)) {
                a aVar10 = a.UINT8;
                AppMethodBeat.o(238979);
                return aVar10;
            } else if (Long.class.equals(cls) || (obj instanceof LongBuffer)) {
                a aVar11 = a.INT64;
                AppMethodBeat.o(238979);
                return aVar11;
            } else if (Boolean.class.equals(cls)) {
                a aVar12 = a.BOOL;
                AppMethodBeat.o(238979);
                return aVar12;
            } else if (String.class.equals(cls)) {
                a aVar13 = a.STRING;
                AppMethodBeat.o(238979);
                return aVar13;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DataType error: cannot resolve DataType of " + obj.getClass().getName());
        AppMethodBeat.o(238979);
        throw illegalArgumentException;
    }

    /* access modifiers changed from: package-private */
    public final int[] gI(Object obj) {
        int i2;
        AppMethodBeat.i(238980);
        int gJ = gJ(obj);
        if (this.Ujq == a.STRING) {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                while (cls.isArray()) {
                    cls = cls.getComponentType();
                }
                if (Byte.TYPE.equals(cls)) {
                    i2 = gJ - 1;
                    int[] iArr = new int[i2];
                    a(obj, 0, iArr);
                    AppMethodBeat.o(238980);
                    return iArr;
                }
            }
        }
        i2 = gJ;
        int[] iArr2 = new int[i2];
        a(obj, 0, iArr2);
        AppMethodBeat.o(238980);
        return iArr2;
    }

    private static int gJ(Object obj) {
        AppMethodBeat.i(238981);
        if (obj == null || !obj.getClass().isArray()) {
            AppMethodBeat.o(238981);
            return 0;
        } else if (Array.getLength(obj) == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Array lengths cannot be 0.");
            AppMethodBeat.o(238981);
            throw illegalArgumentException;
        } else {
            int gJ = gJ(Array.get(obj, 0)) + 1;
            AppMethodBeat.o(238981);
            return gJ;
        }
    }

    private static void a(Object obj, int i2, int[] iArr) {
        AppMethodBeat.i(238982);
        if (iArr == null || i2 == iArr.length) {
            AppMethodBeat.o(238982);
            return;
        }
        int length = Array.getLength(obj);
        if (iArr[i2] == 0) {
            iArr[i2] = length;
        } else if (iArr[i2] != length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", Integer.valueOf(iArr[i2]), Integer.valueOf(length), Integer.valueOf(i2)));
            AppMethodBeat.o(238982);
            throw illegalArgumentException;
        }
        for (int i3 = 0; i3 < length; i3++) {
            a(Array.get(obj, i3), i2 + 1, iArr);
        }
        AppMethodBeat.o(238982);
    }

    private Tensor(long j2) {
        AppMethodBeat.i(238984);
        this.nativeHandle = j2;
        this.Ujq = a.awm(dtype(j2));
        this.Ujr = shape(j2);
        this.Ujs = shapeSignature(j2);
        this.Ujt = new a(quantizationScale(j2), quantizationZeroPoint(j2));
        AppMethodBeat.o(238984);
    }

    /* access modifiers changed from: package-private */
    public final ByteBuffer Pf() {
        AppMethodBeat.i(238985);
        ByteBuffer order = buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
        AppMethodBeat.o(238985);
        return order;
    }

    /* access modifiers changed from: package-private */
    public final void gK(Object obj) {
        AppMethodBeat.i(238983);
        if (obj instanceof ByteBuffer) {
            AppMethodBeat.o(238983);
            return;
        }
        a gH = gH(obj);
        if (gH == this.Ujq) {
            AppMethodBeat.o(238983);
        } else if (gH.hQr().equals(this.Ujq.hQr())) {
            AppMethodBeat.o(238983);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", this.Ujq, obj.getClass().getName(), gH));
            AppMethodBeat.o(238983);
            throw illegalArgumentException;
        }
    }
}
