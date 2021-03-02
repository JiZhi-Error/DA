package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int16Array extends TypedArray {
    public Int16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61680);
        AppMethodBeat.o(61680);
    }

    public short get(int i2) {
        AppMethodBeat.i(61681);
        short s = this.buffer.asShortBuffer().get(i2);
        AppMethodBeat.o(61681);
        return s;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61682);
        int limit = this.buffer.asShortBuffer().limit();
        AppMethodBeat.o(61682);
        return limit;
    }

    public void put(int i2, short s) {
        AppMethodBeat.i(61683);
        this.buffer.asShortBuffer().put(i2, s);
        AppMethodBeat.o(61683);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 13;
    }
}
