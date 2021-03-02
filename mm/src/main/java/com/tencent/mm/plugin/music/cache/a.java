package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public com.tencent.mm.plugin.music.g.a.a AiB;
    public d AiC;
    public h AiD;
    public int AiE = -1;
    public int AiF = 0;
    private byte[] buffer = new byte[81920];
    public int fs = -1;
    public int mSize = 0;

    public a(com.tencent.mm.plugin.music.g.a.a aVar) {
        AppMethodBeat.i(137148);
        this.AiB = aVar;
        AppMethodBeat.o(137148);
    }

    public final synchronized boolean SB(int i2) {
        return this.fs <= i2 && i2 <= this.fs + 81920;
    }

    public final synchronized boolean SC(int i2) {
        return this.fs <= i2 && i2 <= this.fs + this.mSize;
    }

    public final synchronized boolean etB() {
        int[] iArr;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(137149);
            if (this.fs < 0 || this.mSize <= 0) {
                Log.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", Integer.valueOf(this.fs), Integer.valueOf(this.mSize));
                AppMethodBeat.o(137149);
            } else {
                byte[] bArr = new byte[this.mSize];
                System.arraycopy(this.buffer, 0, bArr, 0, this.mSize);
                this.AiD.b(bArr, (long) this.fs, this.mSize);
                d dVar = this.AiC;
                int i2 = this.fs;
                int i3 = this.mSize;
                if (i2 < 0 || i3 < 0 || ((long) i2) > dVar.jPY || ((long) (i2 + i3)) > dVar.jPY) {
                    Log.i("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(dVar.jPY));
                    Log.e("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
                    iArr = null;
                } else {
                    int[] iArr2 = new int[2];
                    iArr2[1] = -1;
                    iArr2[0] = -1;
                    int i4 = i2 + i3;
                    int index = dVar.getIndex(i2);
                    int index2 = dVar.getIndex(i4);
                    for (int i5 = index; i5 <= index2; i5++) {
                        int i6 = (i5 + 1) * 8192;
                        if (i5 * 8192 >= i2 && i6 <= i4) {
                            if (iArr2[0] == -1) {
                                iArr2[0] = i5;
                            }
                            if (iArr2[0] > i5) {
                                iArr2[0] = i5;
                            }
                            if (iArr2[1] == -1) {
                                iArr2[1] = i5;
                            }
                            if (iArr2[1] < i5) {
                                iArr2[1] = i5;
                            }
                        }
                    }
                    if (((long) i4) == dVar.jPY && ((index2 == 0 && i2 == 0) || (index2 > 0 && i2 <= index2 * 8192))) {
                        Log.i("MicroMsg.Music.IndexBitMgr", "write to file end!");
                        iArr2[0] = index;
                        iArr2[1] = index2;
                    }
                    iArr = iArr2;
                }
                if (iArr == null) {
                    Log.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
                    AppMethodBeat.o(137149);
                } else if (iArr[0] == -1 || iArr[1] == -1) {
                    Log.d("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    AppMethodBeat.o(137149);
                } else {
                    for (int i7 = iArr[0]; i7 <= iArr[1]; i7++) {
                        this.AiC.SG(i7);
                    }
                    int i8 = iArr[0];
                    if (i8 > 0) {
                        int i9 = i8 - 1;
                        if (!this.AiC.SF(i9) && this.AiE + this.AiF == this.fs && this.mSize > 0 && this.AiF >= 8192) {
                            Log.i("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", Integer.valueOf(i9));
                            z = true;
                        }
                    }
                    if (z) {
                        this.AiC.SG(iArr[0] - 1);
                    }
                    this.AiC.etI();
                    AppMethodBeat.o(137149);
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void SD(int i2) {
        this.AiE = this.fs;
        this.AiF = this.mSize;
        this.fs = i2;
        this.mSize = 0;
    }

    public final synchronized void J(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(137150);
        int i4 = i2 - this.fs;
        this.mSize = i4 + i3;
        System.arraycopy(bArr, 0, this.buffer, i4, i3);
        AppMethodBeat.o(137150);
    }

    public final synchronized void h(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(137151);
        int i5 = i3 - this.fs;
        this.mSize = i5 + i4;
        System.arraycopy(bArr, i2, this.buffer, i5, i4);
        AppMethodBeat.o(137151);
    }
}
