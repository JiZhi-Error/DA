package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt16Array extends TypedArray {
    public UInt16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61692);
        AppMethodBeat.o(61692);
    }

    public int get(int i2) {
        AppMethodBeat.i(61693);
        int i3 = 65535 & this.buffer.asShortBuffer().get(i2);
        AppMethodBeat.o(61693);
        return i3;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61694);
        int limit = this.buffer.asShortBuffer().limit();
        AppMethodBeat.o(61694);
        return limit;
    }

    public void put(int i2, int i3) {
        AppMethodBeat.i(61695);
        this.buffer.asShortBuffer().put(i2, (short) (65535 & i3));
        AppMethodBeat.o(61695);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 14;
    }
}
