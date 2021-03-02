package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Float32Array extends TypedArray {
    public Float32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(61672);
        AppMethodBeat.o(61672);
    }

    public float get(int i2) {
        AppMethodBeat.i(61673);
        float f2 = this.buffer.asFloatBuffer().get(i2);
        AppMethodBeat.o(61673);
        return f2;
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int length() {
        AppMethodBeat.i(61674);
        int limit = this.buffer.asFloatBuffer().limit();
        AppMethodBeat.o(61674);
        return limit;
    }

    public void put(int i2, float f2) {
        AppMethodBeat.i(61675);
        this.buffer.asFloatBuffer().put(i2, f2);
        AppMethodBeat.o(61675);
    }

    @Override // com.eclipsesource.v8.utils.typedarrays.TypedArray
    public int getType() {
        return 16;
    }
}
