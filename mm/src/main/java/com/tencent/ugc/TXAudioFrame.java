package com.tencent.ugc;

import java.nio.ByteBuffer;

public class TXAudioFrame {
    private ByteBuffer mByteBuffer;
    private int mLength;

    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setLength(int i2) {
        this.mLength = i2;
    }
}
