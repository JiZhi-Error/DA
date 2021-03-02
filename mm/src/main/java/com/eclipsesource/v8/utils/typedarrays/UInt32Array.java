package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt32Array extends TypedArray {
    public UInt32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61696);
        AppMethodBeat.o(61696);
    }

    public long get(int i2) {
        AppMethodBeat.i(61697);
        long j2 = (long) (this.buffer.asIntBuffer().get(i2) & -1);
        AppMethodBeat.o(61697);
        return j2;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61698);
        int limit = this.buffer.asIntBuffer().limit();
        AppMethodBeat.o(61698);
        return limit;
    }

    public void put(int i2, long j2) {
        AppMethodBeat.i(61699);
        this.buffer.asIntBuffer().put(i2, (int) (-1 & j2));
        AppMethodBeat.o(61699);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 15;
    }
}
