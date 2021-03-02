package com.c.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class b implements a {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private final int cqb;
    private final ByteBuffer[] cqc;
    private final long cqd;
    private long cqe;
    private final int mPadding;

    private b(File file) {
        long j2 = 0;
        this.cqb = 1073741824;
        this.mPadding = 1024;
        this.cqd = file.length();
        int i2 = ((int) (this.cqd / ((long) this.cqb))) + 1;
        this.cqc = new ByteBuffer[i2];
        FileInputStream fileInputStream = new FileInputStream(file);
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                this.cqc[i3] = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, j2, Math.min(this.cqd - j2, (long) (this.cqb + this.mPadding)));
                this.cqc[i3].order(cqa);
                j2 += (long) this.cqb;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
        this.cqe = 0;
        fileInputStream.close();
    }

    public b(File file, byte b2) {
        this(file);
    }

    @Override // com.c.a.b.a.a
    public final byte readByte() {
        byte b2 = this.cqc[getIndex()].get(getOffset());
        this.cqe++;
        return b2;
    }

    @Override // com.c.a.b.a.a
    public final void M(byte[] bArr) {
        int index = getIndex();
        this.cqc[index].position(getOffset());
        if (bArr.length <= this.cqc[index].remaining()) {
            this.cqc[index].get(bArr, 0, bArr.length);
        } else {
            int position = this.cqb - this.cqc[index].position();
            this.cqc[index].get(bArr, 0, position);
            this.cqc[index + 1].position(0);
            this.cqc[index + 1].get(bArr, position, bArr.length - position);
        }
        this.cqe += (long) bArr.length;
    }

    @Override // com.c.a.b.a.a
    public final void y(byte[] bArr, int i2, int i3) {
        if ($assertionsDisabled || ((long) i3) < this.cqd) {
            this.cqe += (long) i2;
            int index = getIndex();
            this.cqc[index].position(getOffset());
            if (bArr.length <= this.cqc[index].remaining()) {
                this.cqc[index].get(bArr, 0, bArr.length);
            } else {
                int position = this.cqb - this.cqc[index].position();
                this.cqc[index].get(bArr, 0, position);
                int min = Math.min(i3 - position, bArr.length - position);
                int i4 = ((this.cqb + min) - 1) / this.cqb;
                for (int i5 = 0; i5 < i4; i5++) {
                    int min2 = Math.min(min, this.cqb);
                    this.cqc[index + 1 + i5].position(0);
                    this.cqc[index + 1 + i5].get(bArr, position, min2);
                    position += min2;
                    min -= min2;
                }
            }
            this.cqe += (long) Math.min(bArr.length, i3);
            return;
        }
        throw new AssertionError();
    }

    @Override // com.c.a.b.a.a
    public final char readChar() {
        char c2 = this.cqc[getIndex()].getChar(getOffset());
        this.cqe += 2;
        return c2;
    }

    @Override // com.c.a.b.a.a
    public final short readShort() {
        short s = this.cqc[getIndex()].getShort(getOffset());
        this.cqe += 2;
        return s;
    }

    @Override // com.c.a.b.a.a
    public final int readInt() {
        int i2 = this.cqc[getIndex()].getInt(getOffset());
        this.cqe += 4;
        return i2;
    }

    @Override // com.c.a.b.a.a
    public final long readLong() {
        long j2 = this.cqc[getIndex()].getLong(getOffset());
        this.cqe += 8;
        return j2;
    }

    @Override // com.c.a.b.a.a
    public final float readFloat() {
        float f2 = this.cqc[getIndex()].getFloat(getOffset());
        this.cqe += 4;
        return f2;
    }

    @Override // com.c.a.b.a.a
    public final double readDouble() {
        double d2 = this.cqc[getIndex()].getDouble(getOffset());
        this.cqe += 8;
        return d2;
    }

    @Override // com.c.a.b.a.a
    public final void aT(long j2) {
        this.cqe = j2;
    }

    @Override // com.c.a.b.a.a
    public final long position() {
        return this.cqe;
    }

    @Override // com.c.a.b.a.a
    public final boolean hasRemaining() {
        return this.cqe < this.cqd;
    }

    @Override // com.c.a.b.a.a
    public final long Kq() {
        return this.cqd - this.cqe;
    }

    private int getIndex() {
        return (int) (this.cqe / ((long) this.cqb));
    }

    private int getOffset() {
        return (int) (this.cqe % ((long) this.cqb));
    }
}
