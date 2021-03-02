package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BufferInfo {
    public int bufferSize;
    public byte[] byteBuffer;
    public byte[] tempByteBuffer;

    public void setByteBufferCapacity(int i2) {
        if (this.byteBuffer == null || this.byteBuffer.length < i2) {
            this.byteBuffer = new byte[i2];
        }
    }

    public void setTempByteBufferCapacity(int i2) {
        if (this.tempByteBuffer == null || this.tempByteBuffer.length < i2) {
            this.tempByteBuffer = new byte[i2];
        }
    }

    public void appendByte(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(103516);
        if (bArr != null && i2 >= 0 && i3 > 0 && i2 + i3 <= bArr.length) {
            setByteBufferCapacity(this.bufferSize + i3);
            System.arraycopy(bArr, i2, this.byteBuffer, this.bufferSize, i3);
        }
        AppMethodBeat.o(103516);
    }

    public void fillByte(byte[] bArr, int i2) {
        if (bArr != null && i2 > 0 && i2 <= bArr.length) {
            this.byteBuffer = bArr;
            this.bufferSize = i2;
        }
    }

    public BufferInfo fillInto(BufferInfo bufferInfo) {
        bufferInfo.bufferSize = this.bufferSize;
        bufferInfo.byteBuffer = this.byteBuffer;
        bufferInfo.tempByteBuffer = this.tempByteBuffer;
        return bufferInfo;
    }
}
