package com.tencent.tinker.d.a;

import java.nio.ByteOrder;

public final class d extends c {
    private final ByteOrder SkH;
    private final byte[] buffer;
    private final int byteCount;
    private final int offset = 0;
    private int position;

    private d(byte[] bArr, int i2, ByteOrder byteOrder) {
        this.buffer = bArr;
        this.byteCount = i2;
        this.SkH = byteOrder;
    }

    public static c a(byte[] bArr, int i2, ByteOrder byteOrder) {
        return new d(bArr, i2, byteOrder);
    }

    @Override // com.tencent.tinker.d.a.c
    public final void seek(int i2) {
        this.position = i2;
    }

    @Override // com.tencent.tinker.d.a.c
    public final void hpl() {
        this.position += 4;
    }

    @Override // com.tencent.tinker.d.a.c
    public final int readInt() {
        int i2;
        byte[] bArr = this.buffer;
        int i3 = this.offset + this.position;
        if (this.SkH == ByteOrder.BIG_ENDIAN) {
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            i2 = ((bArr[i5 + 1] & 255) << 0) | ((bArr[i3] & 255) << 24) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 8);
        } else {
            int i6 = i3 + 1;
            int i7 = i6 + 1;
            i2 = ((bArr[i7 + 1] & 255) << 24) | ((bArr[i3] & 255) << 0) | ((bArr[i6] & 255) << 8) | ((bArr[i7] & 255) << 16);
        }
        this.position += 4;
        return i2;
    }

    @Override // com.tencent.tinker.d.a.c
    public final short readShort() {
        short s;
        byte[] bArr = this.buffer;
        int i2 = this.offset + this.position;
        if (this.SkH == ByteOrder.BIG_ENDIAN) {
            s = (short) ((bArr[i2 + 1] & 255) | (bArr[i2] << 8));
        } else {
            s = (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
        }
        this.position += 2;
        return s;
    }
}
