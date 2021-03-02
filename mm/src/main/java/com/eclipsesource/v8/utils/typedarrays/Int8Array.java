package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int8Array extends TypedArray {
    public Int8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61688);
        AppMethodBeat.o(61688);
    }

    public byte get(int i2) {
        AppMethodBeat.i(61689);
        byte b2 = this.buffer.get(i2);
        AppMethodBeat.o(61689);
        return b2;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61690);
        int limit = this.buffer.limit();
        AppMethodBeat.o(61690);
        return limit;
    }

    public void put(int i2, byte b2) {
        AppMethodBeat.i(61691);
        this.buffer.put(i2, b2);
        AppMethodBeat.o(61691);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 9;
    }
}
