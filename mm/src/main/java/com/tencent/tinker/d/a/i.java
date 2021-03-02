package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class i extends FilterOutputStream {
    public static final byte[] SkU = new byte[0];
    private static final byte[] SkV = {-1, -1, -1, -1};
    private int SkA;
    private ByteArrayOutputStream SkB;
    private byte[] SkF;
    private final boolean SkW;
    private g SkX;
    private byte[] SkY;
    private boolean SkZ;
    public byte[] Sky;
    private final HashSet<String> Skz;
    private long offset;

    public i(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private i(OutputStream outputStream, byte b2) {
        super(outputStream);
        this.Skz = new HashSet<>();
        this.Sky = SkU;
        this.SkA = 8;
        this.SkB = new ByteArrayOutputStream();
        this.offset = 0;
        this.SkW = false;
    }

    private static long d(OutputStream outputStream, long j2) {
        outputStream.write((int) (255 & j2));
        outputStream.write(((int) (j2 >> 8)) & 255);
        outputStream.write(((int) (j2 >> 16)) & 255);
        outputStream.write(((int) (j2 >> 24)) & 255);
        return j2;
    }

    private static int e(OutputStream outputStream, int i2) {
        outputStream.write(i2 & 255);
        outputStream.write((i2 >> 8) & 255);
        return i2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public final void close() {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.SkB != null) {
            if (this.Skz.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.SkX != null) {
                closeEntry();
            }
            int size = this.SkB.size();
            d(this.SkB, 101010256);
            e(this.SkB, 0);
            e(this.SkB, 0);
            if (this.SkZ) {
                e(this.SkB, 65535);
                e(this.SkB, 65535);
                d(this.SkB, -1);
                d(this.SkB, -1);
            } else {
                e(this.SkB, this.Skz.size());
                e(this.SkB, this.Skz.size());
                d(this.SkB, (long) size);
                d(this.SkB, this.offset);
            }
            e(this.SkB, this.Sky.length);
            if (this.Sky.length > 0) {
                this.SkB.write(this.Sky);
            }
            this.SkB.writeTo(this.out);
            this.SkB = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void closeEntry() {
        long j2;
        hpk();
        if (this.SkX != null) {
            long j3 = 30;
            if (this.SkX.SkK != 0) {
                j3 = 46;
                d(this.out, 134695760);
                d(this.out, this.SkX.crc);
                d(this.out, this.SkX.SkJ);
                d(this.out, this.SkX.size);
            }
            int i2 = this.SkX.SkK == 0 ? 0 : 8;
            d(this.SkB, 33639248);
            e(this.SkB, 20);
            e(this.SkB, 20);
            e(this.SkB, i2 | 2048);
            e(this.SkB, this.SkX.SkK);
            e(this.SkB, this.SkX.hXs);
            e(this.SkB, this.SkX.SkL);
            d(this.SkB, this.SkX.crc);
            if (this.SkX.SkK == 8) {
                j2 = j3 + this.SkX.SkJ;
            } else {
                j2 = j3 + this.SkX.size;
            }
            d(this.SkB, this.SkX.SkJ);
            d(this.SkB, this.SkX.size);
            long e2 = j2 + ((long) e(this.SkB, this.SkF.length));
            if (this.SkX.SkM != null) {
                e2 += (long) e(this.SkB, this.SkX.SkM.length);
            } else {
                e(this.SkB, 0);
            }
            e(this.SkB, this.SkY.length);
            e(this.SkB, 0);
            e(this.SkB, 0);
            d(this.SkB, 0);
            d(this.SkB, this.SkX.SkN);
            this.SkB.write(this.SkF);
            this.SkF = null;
            if (this.SkX.SkM != null) {
                this.SkB.write(this.SkX.SkM);
            }
            this.offset = e2 + this.offset;
            if (this.SkY.length > 0) {
                this.SkB.write(this.SkY);
                this.SkY = SkU;
            }
            this.SkX = null;
        }
    }

    public final void b(g gVar) {
        int i2;
        if (this.SkX != null) {
            closeEntry();
        }
        int i3 = gVar.SkK;
        if (i3 == -1) {
            i2 = this.SkA;
        } else {
            i2 = i3;
        }
        if (i2 == 0) {
            if (gVar.SkJ == -1) {
                gVar.SkJ = gVar.size;
            } else if (gVar.size == -1) {
                gVar.setSize(gVar.SkJ);
            }
            if (gVar.crc == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (gVar.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (gVar.size != gVar.SkJ) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        hpk();
        gVar.KJM = null;
        gVar.SkM = null;
        gVar.hXs = 40691;
        gVar.SkL = 18698;
        this.SkF = gVar.name.getBytes(e.UTF_8);
        D("Name", this.SkF);
        this.SkY = SkU;
        if (gVar.KJM != null) {
            this.SkY = gVar.KJM.getBytes(e.UTF_8);
            D("Comment", this.SkY);
        }
        gVar.setMethod(i2);
        this.SkX = gVar;
        this.SkX.SkN = this.offset;
        this.Skz.add(this.SkX.name);
        int i4 = i2 == 0 ? 0 : 8;
        d(this.out, 67324752);
        e(this.out, 20);
        e(this.out, i4 | 2048);
        e(this.out, i2);
        e(this.out, this.SkX.hXs);
        e(this.out, this.SkX.SkL);
        if (i2 == 0) {
            d(this.out, this.SkX.crc);
            d(this.out, this.SkX.size);
            d(this.out, this.SkX.size);
        } else {
            d(this.out, 0);
            d(this.out, 0);
            d(this.out, 0);
        }
        e(this.out, this.SkF.length);
        if (this.SkX.SkM != null) {
            e(this.out, this.SkX.SkM.length);
        } else {
            e(this.out, 0);
        }
        this.out.write(this.SkF);
        if (this.SkX.SkM != null) {
            this.out.write(this.SkX.SkM);
        }
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        b.checkOffsetAndCount(bArr.length, i2, i3);
        if (this.SkX == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i2, i3);
    }

    private void hpk() {
        if (this.SkB == null) {
            throw new IOException("Stream is closed");
        }
    }

    public static void D(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
