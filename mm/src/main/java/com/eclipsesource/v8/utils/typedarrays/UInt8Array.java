package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8Array extends TypedArray {
    public UInt8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61700);
        AppMethodBeat.o(61700);
    }

    public short get(int i2) {
        AppMethodBeat.i(61701);
        short s = (short) (this.buffer.get(i2) & 255);
        AppMethodBeat.o(61701);
        return s;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61702);
        int limit = this.buffer.limit();
        AppMethodBeat.o(61702);
        return limit;
    }

    public void put(int i2, short s) {
        AppMethodBeat.i(61703);
        this.buffer.put(i2, (byte) (s & 255));
        AppMethodBeat.o(61703);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 11;
    }
}
