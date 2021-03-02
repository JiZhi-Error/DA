package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8ClampedArray extends TypedArray {
    public UInt8ClampedArray(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8ClampedArray(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61704);
        AppMethodBeat.o(61704);
    }

    public short get(int i2) {
        AppMethodBeat.i(61705);
        short s = (short) (this.buffer.get(i2) & 255);
        AppMethodBeat.o(61705);
        return s;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61706);
        int limit = this.buffer.limit();
        AppMethodBeat.o(61706);
        return limit;
    }

    public void put(int i2, short s) {
        AppMethodBeat.i(61707);
        if (s > 255) {
            this.buffer.put(i2, (byte) -1);
            AppMethodBeat.o(61707);
        } else if (s < 0) {
            this.buffer.put(i2, (byte) 0);
            AppMethodBeat.o(61707);
        } else {
            this.buffer.put(i2, (byte) s);
            AppMethodBeat.o(61707);
        }
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 12;
    }
}
