package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.RandomAccessFile;

public final class g extends a {
    public static final int jQp = c.bJ("vide");
    public static final int jQq = c.bJ("soun");
    public static final int jQr = c.bJ("hint");
    public long duration = 0;
    public long jQs = 0;
    public long jQt = 0;
    long jQu = 0;

    static {
        AppMethodBeat.i(133867);
        AppMethodBeat.o(133867);
    }

    public g(int i2, long j2, int i3) {
        super(i2, j2, i3, 0);
    }

    public final boolean a(RandomAccessFile randomAccessFile, byte[] bArr) {
        boolean z;
        long j2;
        int i2;
        int i3;
        AppMethodBeat.i(133866);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int read = randomAccessFile.read(bArr);
        while (true) {
            if (read < 8) {
                z = z4;
                break;
            }
            int readInt = c.readInt(bArr, 0);
            int readInt2 = c.readInt(bArr, 4);
            if (readInt2 == a.blA) {
                byte[] bArr2 = new byte[4];
                int read2 = randomAccessFile.read(bArr2);
                if (read2 < 4) {
                    i3 = -1;
                } else {
                    int i4 = read2 + 0;
                    if (bArr2[0] == 0) {
                        if (!c.a(randomAccessFile, 8)) {
                            i3 = -1;
                        } else {
                            int i5 = i4 + 8;
                            int read3 = randomAccessFile.read(bArr);
                            if (read3 < 8) {
                                i3 = -1;
                            } else {
                                i3 = i5 + read3;
                                this.jQs = c.D(bArr, 0);
                                this.duration = c.D(bArr, 4);
                            }
                        }
                    } else if (!c.a(randomAccessFile, 16)) {
                        i3 = -1;
                    } else {
                        int i6 = i4 + 16;
                        int read4 = randomAccessFile.read(bArr2);
                        if (read4 < 4) {
                            i3 = -1;
                        } else {
                            int i7 = i6 + read4;
                            this.jQs = c.D(bArr2, 0);
                            int read5 = randomAccessFile.read(bArr);
                            if (read5 < 8) {
                                i3 = -1;
                            } else {
                                i3 = read5 + i7;
                                this.duration = c.aE(bArr);
                            }
                        }
                    }
                }
                if (i3 <= 0) {
                    Log.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    AppMethodBeat.o(133866);
                    return false;
                }
                z2 = true;
                j2 = (long) ((readInt - read) - i3);
                z = z4;
            } else if (readInt2 == a.blB) {
                if (!c.a(randomAccessFile, 8)) {
                    i2 = -1;
                } else {
                    int read6 = randomAccessFile.read(bArr, 0, 4);
                    if (read6 < 4) {
                        i2 = -1;
                    } else {
                        this.jQt = (long) c.readInt(bArr, 0);
                        i2 = read6 + 8;
                    }
                }
                if (i2 <= 0) {
                    Log.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    AppMethodBeat.o(133866);
                    return false;
                }
                z3 = true;
                j2 = (long) ((readInt - read) - i2);
                z = z4;
            } else if (readInt2 == a.blo) {
                this.jQu = randomAccessFile.getFilePointer() - ((long) read);
                j2 = (long) (readInt - read);
                z = true;
            } else {
                j2 = (long) (readInt - 8);
                z = z4;
            }
            if (z2 && z3 && z) {
                break;
            } else if (!c.a(randomAccessFile, j2)) {
                AppMethodBeat.o(133866);
                return false;
            } else {
                read = randomAccessFile.read(bArr);
                z4 = z;
            }
        }
        if (!z2 || !z3 || !z) {
            AppMethodBeat.o(133866);
            return false;
        }
        AppMethodBeat.o(133866);
        return true;
    }
}
