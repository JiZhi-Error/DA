package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

class MBuf {
    private ByteBuffer buffer = null;

    MBuf() {
    }

    public void setBuffer(byte[] bArr) {
        AppMethodBeat.i(230329);
        int length = bArr.length;
        this.buffer = ByteBuffer.allocateDirect(length);
        this.buffer.position(0);
        this.buffer.put(bArr, 0, length);
        this.buffer.position(0);
        AppMethodBeat.o(230329);
    }

    public int getOffset() {
        AppMethodBeat.i(230330);
        int position = this.buffer.position();
        AppMethodBeat.o(230330);
        return position;
    }

    public int getLen() {
        AppMethodBeat.i(230331);
        int capacity = this.buffer.capacity();
        AppMethodBeat.o(230331);
        return capacity;
    }

    public ByteBuffer getBuffer() {
        return this.buffer;
    }
}
