package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.c;
import org.tensorflow.lite.nnapi.NnApiDelegate;

public final class NativeInterpreterWrapper implements AutoCloseable {
    private final List<b> TiL = new ArrayList();
    private long Uje;
    private long Ujf;
    private long Ujg;
    private long Ujh = 0;
    private long Uji = -1;
    private ByteBuffer Ujj;
    private Map<String, Integer> Ujk;
    private Map<String, Integer> Ujl;
    public Tensor[] Ujm;
    public Tensor[] Ujn;
    private boolean Ujo = false;
    private final List<AutoCloseable> Ujp = new ArrayList();

    private static native long allocateTensors(long j2, long j3);

    private static native void allowBufferHandleOutput(long j2, boolean z);

    private static native void allowFp16PrecisionForFp32(long j2, boolean z);

    private static native void applyDelegate(long j2, long j3, long j4);

    private static native long createCancellationFlag(long j2);

    private static native long createErrorReporter(int i2);

    private static native long createInterpreter(long j2, long j3, int i2);

    private static native long createModel(String str, long j2);

    private static native long createModelWithBuffer(ByteBuffer byteBuffer, long j2);

    private static native void delete(long j2, long j3, long j4);

    private static native long deleteCancellationFlag(long j2);

    private static native int getExecutionPlanLength(long j2);

    private static native int getInputCount(long j2);

    private static native String[] getInputNames(long j2);

    private static native int getInputTensorIndex(long j2, int i2);

    private static native int getOutputCount(long j2);

    private static native int getOutputDataType(long j2, int i2);

    private static native String[] getOutputNames(long j2);

    private static native int getOutputTensorIndex(long j2, int i2);

    private static native boolean hasUnresolvedFlexOp(long j2);

    private static native void numThreads(long j2, int i2);

    private static native void resetVariableTensors(long j2, long j3);

    private static native boolean resizeInput(long j2, long j3, int i2, int[] iArr, boolean z);

    private static native void run(long j2, long j3);

    private static native void setCancelled(long j2, long j3, boolean z);

    private static native void useXNNPACK(long j2, long j3, boolean z, int i2);

    NativeInterpreterWrapper(ByteBuffer byteBuffer) {
        AppMethodBeat.i(238969);
        TensorFlowLite.init();
        if (byteBuffer == null || (!(byteBuffer instanceof MappedByteBuffer) && (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
            AppMethodBeat.o(238969);
            throw illegalArgumentException;
        }
        this.Ujj = byteBuffer;
        long createErrorReporter = createErrorReporter(512);
        long createModelWithBuffer = createModelWithBuffer(this.Ujj, createErrorReporter);
        c.a aVar = new c.a();
        this.Uje = createErrorReporter;
        this.Ujg = createModelWithBuffer;
        this.Ujf = createInterpreter(createModelWithBuffer, createErrorReporter, aVar.UiY);
        if (aVar.Ujc != null && aVar.Ujc.booleanValue()) {
            this.Ujh = createCancellationFlag(this.Ujf);
        }
        this.Ujm = new Tensor[getInputCount(this.Ujf)];
        this.Ujn = new Tensor[getOutputCount(this.Ujf)];
        if (aVar.Uja != null) {
            allowFp16PrecisionForFp32(this.Ujf, aVar.Uja.booleanValue());
        }
        if (aVar.Ujb != null) {
            allowBufferHandleOutput(this.Ujf, aVar.Ujb.booleanValue());
        }
        a(aVar);
        if (aVar.Ujd != null) {
            useXNNPACK(this.Ujf, createErrorReporter, aVar.Ujd.booleanValue(), aVar.UiY);
        }
        allocateTensors(this.Ujf, createErrorReporter);
        this.Ujo = true;
        AppMethodBeat.o(238969);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(238970);
        for (int i2 = 0; i2 < this.Ujm.length; i2++) {
            if (this.Ujm[i2] != null) {
                this.Ujm[i2].close();
                this.Ujm[i2] = null;
            }
        }
        for (int i3 = 0; i3 < this.Ujn.length; i3++) {
            if (this.Ujn[i3] != null) {
                this.Ujn[i3].close();
                this.Ujn[i3] = null;
            }
        }
        delete(this.Uje, this.Ujg, this.Ujf);
        deleteCancellationFlag(this.Ujh);
        this.Uje = 0;
        this.Ujg = 0;
        this.Ujf = 0;
        this.Ujh = 0;
        this.Ujj = null;
        this.Ujk = null;
        this.Ujl = null;
        this.Ujo = false;
        this.TiL.clear();
        for (AutoCloseable autoCloseable : this.Ujp) {
            try {
                autoCloseable.close();
            } catch (Exception e2) {
                System.err.println("Failed to close flex delegate: ".concat(String.valueOf(e2)));
            }
        }
        this.Ujp.clear();
        AppMethodBeat.o(238970);
    }

    public final void a(Object[] objArr, Map<Integer, Object> map) {
        int[] gI;
        AppMethodBeat.i(238971);
        this.Uji = -1;
        if (objArr == null || objArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Input error: Inputs should not be null or empty.");
            AppMethodBeat.o(238971);
            throw illegalArgumentException;
        } else if (map == null || map.isEmpty()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Input error: Outputs should not be null or empty.");
            AppMethodBeat.o(238971);
            throw illegalArgumentException2;
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Tensor awn = awn(i2);
                Object obj = objArr[i2];
                if (obj == null) {
                    gI = null;
                } else if (obj instanceof Buffer) {
                    gI = null;
                } else {
                    awn.gK(obj);
                    gI = awn.gI(obj);
                    if (Arrays.equals(awn.Ujr, gI)) {
                        gI = null;
                    }
                }
                if (gI != null && resizeInput(this.Ujf, this.Uje, i2, gI, false)) {
                    this.Ujo = false;
                    if (this.Ujm[i2] != null) {
                        this.Ujm[i2].hQs();
                    }
                }
            }
            boolean z = !this.Ujo;
            if (z) {
                allocateTensors(this.Ujf, this.Uje);
                this.Ujo = true;
            }
            for (int i3 = 0; i3 < objArr.length; i3++) {
                Tensor awn2 = awn(i3);
                Object obj2 = objArr[i3];
                if (obj2 != null) {
                    awn2.gK(obj2);
                    if (obj2 instanceof Buffer) {
                        Buffer buffer = (Buffer) obj2;
                        int numBytes = Tensor.numBytes(awn2.nativeHandle);
                        int capacity = obj2 instanceof ByteBuffer ? buffer.capacity() : buffer.capacity() * awn2.Ujq.hQq();
                        if (numBytes != capacity) {
                            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", Tensor.name(awn2.nativeHandle), Integer.valueOf(numBytes), Integer.valueOf(capacity)));
                            AppMethodBeat.o(238971);
                            throw illegalArgumentException3;
                        }
                    } else {
                        int[] gI2 = awn2.gI(obj2);
                        if (!Arrays.equals(gI2, awn2.Ujr)) {
                            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with shape %s from a Java object with shape %s.", Tensor.name(awn2.nativeHandle), Arrays.toString(awn2.Ujr), Arrays.toString(gI2)));
                            AppMethodBeat.o(238971);
                            throw illegalArgumentException4;
                        }
                    }
                    if (obj2 instanceof Buffer) {
                        Buffer buffer2 = (Buffer) obj2;
                        if (buffer2 instanceof ByteBuffer) {
                            ByteBuffer byteBuffer = (ByteBuffer) buffer2;
                            if (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()) {
                                awn2.Pf().put(byteBuffer);
                            } else {
                                Tensor.writeDirectBuffer(awn2.nativeHandle, buffer2);
                            }
                        } else if (buffer2 instanceof LongBuffer) {
                            LongBuffer longBuffer = (LongBuffer) buffer2;
                            if (!longBuffer.isDirect() || longBuffer.order() != ByteOrder.nativeOrder()) {
                                awn2.Pf().asLongBuffer().put(longBuffer);
                            } else {
                                Tensor.writeDirectBuffer(awn2.nativeHandle, buffer2);
                            }
                        } else if (buffer2 instanceof FloatBuffer) {
                            FloatBuffer floatBuffer = (FloatBuffer) buffer2;
                            if (!floatBuffer.isDirect() || floatBuffer.order() != ByteOrder.nativeOrder()) {
                                awn2.Pf().asFloatBuffer().put(floatBuffer);
                            } else {
                                Tensor.writeDirectBuffer(awn2.nativeHandle, buffer2);
                            }
                        } else if (buffer2 instanceof IntBuffer) {
                            IntBuffer intBuffer = (IntBuffer) buffer2;
                            if (!intBuffer.isDirect() || intBuffer.order() != ByteOrder.nativeOrder()) {
                                awn2.Pf().asIntBuffer().put(intBuffer);
                            } else {
                                Tensor.writeDirectBuffer(awn2.nativeHandle, buffer2);
                            }
                        } else {
                            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("Unexpected input buffer type: ".concat(String.valueOf(buffer2)));
                            AppMethodBeat.o(238971);
                            throw illegalArgumentException5;
                        }
                    } else if (obj2.getClass().isArray()) {
                        Tensor.writeMultiDimensionalArray(awn2.nativeHandle, obj2);
                    } else {
                        Tensor.writeScalar(awn2.nativeHandle, obj2);
                    }
                } else if (!Tensor.hasDelegateBufferHandle(awn2.nativeHandle)) {
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
                    AppMethodBeat.o(238971);
                    throw illegalArgumentException6;
                }
            }
            long nanoTime = System.nanoTime();
            run(this.Ujf, this.Uje);
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (z) {
                for (int i4 = 0; i4 < this.Ujn.length; i4++) {
                    if (this.Ujn[i4] != null) {
                        this.Ujn[i4].hQs();
                    }
                }
            }
            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                Tensor awo = awo(entry.getKey().intValue());
                Object value = entry.getValue();
                if (value != null) {
                    awo.gK(value);
                    if (value instanceof Buffer) {
                        Buffer buffer3 = (Buffer) value;
                        int numBytes2 = Tensor.numBytes(awo.nativeHandle);
                        int capacity2 = value instanceof ByteBuffer ? buffer3.capacity() : buffer3.capacity() * awo.Ujq.hQq();
                        if (numBytes2 > capacity2) {
                            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", Tensor.name(awo.nativeHandle), Integer.valueOf(numBytes2), Integer.valueOf(capacity2)));
                            AppMethodBeat.o(238971);
                            throw illegalArgumentException7;
                        }
                    } else {
                        int[] gI3 = awo.gI(value);
                        if (!Arrays.equals(gI3, awo.Ujr)) {
                            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with shape %s to a Java object with shape %s.", Tensor.name(awo.nativeHandle), Arrays.toString(awo.Ujr), Arrays.toString(gI3)));
                            AppMethodBeat.o(238971);
                            throw illegalArgumentException8;
                        }
                    }
                    if (value instanceof Buffer) {
                        Buffer buffer4 = (Buffer) value;
                        if (buffer4 instanceof ByteBuffer) {
                            ((ByteBuffer) buffer4).put(awo.Pf());
                        } else if (buffer4 instanceof FloatBuffer) {
                            ((FloatBuffer) buffer4).put(awo.Pf().asFloatBuffer());
                        } else if (buffer4 instanceof LongBuffer) {
                            ((LongBuffer) buffer4).put(awo.Pf().asLongBuffer());
                        } else if (buffer4 instanceof IntBuffer) {
                            ((IntBuffer) buffer4).put(awo.Pf().asIntBuffer());
                        } else {
                            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("Unexpected output buffer type: ".concat(String.valueOf(buffer4)));
                            AppMethodBeat.o(238971);
                            throw illegalArgumentException9;
                        }
                    } else {
                        Tensor.readMultiDimensionalArray(awo.nativeHandle, value);
                    }
                } else if (!Tensor.hasDelegateBufferHandle(awo.nativeHandle)) {
                    IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
                    AppMethodBeat.o(238971);
                    throw illegalArgumentException10;
                }
            }
            this.Uji = nanoTime2;
            AppMethodBeat.o(238971);
        }
    }

    public final Tensor awn(int i2) {
        AppMethodBeat.i(238972);
        if (i2 < 0 || i2 >= this.Ujm.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid input Tensor index: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(238972);
            throw illegalArgumentException;
        }
        Tensor tensor = this.Ujm[i2];
        if (tensor == null) {
            Tensor[] tensorArr = this.Ujm;
            tensor = Tensor.ax(this.Ujf, getInputTensorIndex(this.Ujf, i2));
            tensorArr[i2] = tensor;
        }
        AppMethodBeat.o(238972);
        return tensor;
    }

    public final Tensor awo(int i2) {
        AppMethodBeat.i(238973);
        if (i2 < 0 || i2 >= this.Ujn.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid output Tensor index: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(238973);
            throw illegalArgumentException;
        }
        Tensor tensor = this.Ujn[i2];
        if (tensor == null) {
            Tensor[] tensorArr = this.Ujn;
            tensor = Tensor.ax(this.Ujf, getOutputTensorIndex(this.Ujf, i2));
            tensorArr[i2] = tensor;
        }
        AppMethodBeat.o(238973);
        return tensor;
    }

    private void a(c.a aVar) {
        b kO;
        AppMethodBeat.i(238974);
        boolean hasUnresolvedFlexOp = hasUnresolvedFlexOp(this.Ujf);
        if (hasUnresolvedFlexOp && (kO = kO(aVar.TiL)) != null) {
            this.Ujp.add((AutoCloseable) kO);
            applyDelegate(this.Ujf, this.Uje, kO.getNativeHandle());
        }
        try {
            for (b bVar : aVar.TiL) {
                applyDelegate(this.Ujf, this.Uje, bVar.getNativeHandle());
                this.TiL.add(bVar);
            }
            if (aVar.UiZ != null && aVar.UiZ.booleanValue()) {
                NnApiDelegate nnApiDelegate = new NnApiDelegate();
                this.Ujp.add(nnApiDelegate);
                applyDelegate(this.Ujf, this.Uje, nnApiDelegate.Ujw);
            }
            AppMethodBeat.o(238974);
        } catch (IllegalArgumentException e2) {
            if (!(hasUnresolvedFlexOp && !hasUnresolvedFlexOp(this.Ujf))) {
                AppMethodBeat.o(238974);
                throw e2;
            }
            System.err.println("Ignoring failed delegate application: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(238974);
        }
    }

    private static b kO(List<b> list) {
        AppMethodBeat.i(238975);
        try {
            Class<?> cls = Class.forName("org.tensorflow.lite.flex.FlexDelegate");
            for (b bVar : list) {
                if (cls.isInstance(bVar)) {
                    AppMethodBeat.o(238975);
                    return null;
                }
            }
            b bVar2 = (b) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(238975);
            return bVar2;
        } catch (Exception e2) {
            AppMethodBeat.o(238975);
            return null;
        }
    }
}
