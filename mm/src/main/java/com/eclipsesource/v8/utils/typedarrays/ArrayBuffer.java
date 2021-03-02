package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ArrayBuffer {
    private ByteBuffer byteBuffer;

    public ArrayBuffer(int i2) {
        AppMethodBeat.i(61664);
        this.byteBuffer = ByteBuffer.allocateDirect(i2);
        AppMethodBeat.o(61664);
    }

    public ArrayBuffer(byte[] bArr) {
        AppMethodBeat.i(61665);
        this.byteBuffer = ByteBuffer.allocateDirect(bArr.length);
        this.byteBuffer.put(bArr, 0, bArr.length);
        AppMethodBeat.o(61665);
    }

    public ArrayBuffer(ByteBuffer byteBuffer2) {
        AppMethodBeat.i(61666);
        this.byteBuffer = validateByteBuffer(byteBuffer2);
        AppMethodBeat.o(61666);
    }

    private ByteBuffer validateByteBuffer(ByteBuffer byteBuffer2) {
        AppMethodBeat.i(61667);
        if (!byteBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
            AppMethodBeat.o(61667);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(61667);
        return byteBuffer2;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public byte getByte(int i2) {
        AppMethodBeat.i(61668);
        byte b2 = this.byteBuffer.get(i2);
        AppMethodBeat.o(61668);
        return b2;
    }

    public short getUnsignedByte(int i2) {
        AppMethodBeat.i(61669);
        short s = (short) (this.byteBuffer.get(i2) & 255);
        AppMethodBeat.o(61669);
        return s;
    }

    public void put(int i2, byte b2) {
        AppMethodBeat.i(61670);
        this.byteBuffer.put(i2, b2);
        AppMethodBeat.o(61670);
    }

    public int limit() {
        AppMethodBeat.i(61671);
        int limit = this.byteBuffer.limit();
        AppMethodBeat.o(61671);
        return limit;
    }

    public String toString() {
        return "[object ArrayBuffer]";
    }
}
