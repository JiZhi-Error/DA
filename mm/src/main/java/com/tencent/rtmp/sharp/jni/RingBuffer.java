package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RingBuffer {
    private final int DEFAULT_SIZE;
    public int c_totalSize;
    public boolean m_isEmpty;
    public byte[] m_pBuf;
    public int m_read;
    public int m_write;

    public RingBuffer() {
        AppMethodBeat.i(13644);
        this.DEFAULT_SIZE = 1000;
        this.c_totalSize = 1000;
        this.m_read = 0;
        this.m_write = 0;
        this.m_isEmpty = true;
        this.m_pBuf = null;
        this.c_totalSize = 1000;
        this.m_isEmpty = true;
        this.m_read = 0;
        this.m_write = 0;
        this.m_pBuf = new byte[this.c_totalSize];
        AppMethodBeat.o(13644);
    }

    public RingBuffer(int i2) {
        AppMethodBeat.i(13645);
        this.DEFAULT_SIZE = 1000;
        this.c_totalSize = 1000;
        this.m_read = 0;
        this.m_write = 0;
        this.m_isEmpty = true;
        this.c_totalSize = i2;
        this.m_isEmpty = true;
        this.m_read = 0;
        this.m_write = 0;
        this.m_pBuf = new byte[this.c_totalSize];
        AppMethodBeat.o(13645);
    }

    public void Push(byte[] bArr, int i2) {
        AppMethodBeat.i(13646);
        if (this.m_pBuf == null) {
            AppMethodBeat.o(13646);
        } else if (RemainWrite() < i2) {
            AppMethodBeat.o(13646);
        } else {
            if (this.c_totalSize - this.m_write >= i2) {
                System.arraycopy(bArr, 0, this.m_pBuf, this.m_write, i2);
            } else {
                System.arraycopy(bArr, 0, this.m_pBuf, this.m_write, this.c_totalSize - this.m_write);
                System.arraycopy(bArr, this.c_totalSize - this.m_write, this.m_pBuf, 0, i2 - (this.c_totalSize - this.m_write));
            }
            this.m_write = (this.m_write + i2) % this.c_totalSize;
            this.m_isEmpty = false;
            AppMethodBeat.o(13646);
        }
    }

    public int RemainRead() {
        if (this.m_write < this.m_read) {
            return (this.c_totalSize - this.m_read) + this.m_write;
        }
        if (this.m_write > this.m_read) {
            return this.m_write - this.m_read;
        }
        if (this.m_isEmpty) {
            return 0;
        }
        return this.c_totalSize;
    }

    public int RemainWrite() {
        AppMethodBeat.i(13647);
        int RemainRead = this.c_totalSize - RemainRead();
        AppMethodBeat.o(13647);
        return RemainRead;
    }

    public void Clear() {
        this.m_write = 0;
        this.m_read = this.m_write;
        this.m_isEmpty = true;
    }

    public boolean Pop(byte[] bArr, int i2) {
        boolean z = false;
        AppMethodBeat.i(13648);
        if (this.m_pBuf == null) {
            AppMethodBeat.o(13648);
            return false;
        } else if (RemainRead() < i2 || i2 <= 0) {
            AppMethodBeat.o(13648);
            return false;
        } else {
            if (this.c_totalSize - this.m_read >= i2) {
                System.arraycopy(this.m_pBuf, this.m_read, bArr, 0, i2);
            } else {
                System.arraycopy(this.m_pBuf, this.m_read, bArr, 0, this.c_totalSize - this.m_read);
                System.arraycopy(this.m_pBuf, 0, bArr, this.c_totalSize - this.m_read, i2 - (this.c_totalSize - this.m_read));
            }
            this.m_read = (this.m_read + i2) % this.c_totalSize;
            if (this.m_read == this.m_write) {
                z = true;
            }
            this.m_isEmpty = z;
            AppMethodBeat.o(13648);
            return true;
        }
    }
}
