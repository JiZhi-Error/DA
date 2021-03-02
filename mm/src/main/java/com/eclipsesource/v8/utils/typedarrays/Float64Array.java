package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Float64Array extends TypedArray {
    public Float64Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float64Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61676);
        AppMethodBeat.o(61676);
    }

    public double get(int i2) {
        AppMethodBeat.i(61677);
        double d2 = this.buffer.asDoubleBuffer().get(i2);
        AppMethodBeat.o(61677);
        return d2;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61678);
        int limit = this.buffer.asDoubleBuffer().limit();
        AppMethodBeat.o(61678);
        return limit;
    }

    public void put(int i2, double d2) {
        AppMethodBeat.i(61679);
        this.buffer.asDoubleBuffer().put(i2, d2);
        AppMethodBeat.o(61679);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 2;
    }
}
