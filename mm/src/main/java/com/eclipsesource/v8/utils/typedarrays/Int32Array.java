package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int32Array extends TypedArray {
    public Int32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61684);
        AppMethodBeat.o(61684);
    }

    public int get(int i2) {
        AppMethodBeat.i(61685);
        int i3 = this.buffer.asIntBuffer().get(i2);
        AppMethodBeat.o(61685);
        return i3;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61686);
        int limit = this.buffer.asIntBuffer().limit();
        AppMethodBeat.o(61686);
        return limit;
    }

    public void put(int i2, int i3) {
        AppMethodBeat.i(61687);
        this.buffer.asIntBuffer().put(i2, i3);
        AppMethodBeat.o(61687);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 1;
    }
}
