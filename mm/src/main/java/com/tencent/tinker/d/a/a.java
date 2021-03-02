package com.tencent.tinker.d.a;

import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public final class a extends DeflaterOutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final byte[] Skx = {0};
    private int SkA;
    private ByteArrayOutputStream SkB;
    private ZipEntry SkC;
    private long SkD;
    private int SkE;
    private byte[] SkF;
    private final int SkG;
    private byte[] Sky;
    private final HashSet<String> Skz;
    private boolean chA;
    private boolean closed;
    private int compressionLevel;
    private final CRC32 crc;
    private int offset;
    private int padding;

    public a(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private a(OutputStream outputStream, byte b2) {
        super(outputStream, new Deflater(-1, true));
        this.Sky = EMPTY_BYTE_ARRAY;
        this.Skz = new HashSet<>();
        this.SkA = 8;
        this.compressionLevel = -1;
        this.SkB = new ByteArrayOutputStream();
        this.crc = new CRC32();
        this.SkD = 0;
        this.offset = 0;
        this.chA = false;
        this.closed = false;
        this.padding = 0;
        this.SkG = 4;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.util.zip.DeflaterOutputStream, java.lang.AutoCloseable
    public final void close() {
        if (!this.closed) {
            finish();
            this.def.end();
            this.out.close();
            this.out = null;
            this.closed = true;
        }
    }

    public final void closeEntry() {
        int c2;
        hpk();
        if (this.SkC != null) {
            if (this.SkC.getMethod() == 8) {
                super.finish();
            }
            if (this.SkC.getMethod() == 0) {
                if (this.crc.getValue() != this.SkC.getCrc()) {
                    throw new ZipException("CRC mismatch");
                } else if (this.SkC.getSize() != this.SkD) {
                    throw new ZipException("Size mismatch");
                }
            }
            int i2 = 30;
            if (this.SkC.getMethod() != 0) {
                i2 = 46;
                c(this.out, 134695760L);
                this.SkC.setCrc(this.crc.getValue());
                c(this.out, this.SkC.getCrc());
                this.SkC.setCompressedSize((long) this.def.getTotalOut());
                c(this.out, this.SkC.getCompressedSize());
                this.SkC.setSize((long) this.def.getTotalIn());
                c(this.out, this.SkC.getSize());
            }
            int i3 = this.SkC.getMethod() == 0 ? 0 : 8;
            c((OutputStream) this.SkB, 33639248L);
            d(this.SkB, 20);
            d(this.SkB, 20);
            d(this.SkB, i3 | 2048);
            d(this.SkB, this.SkC.getMethod());
            d(this.SkB, 0);
            d(this.SkB, 33);
            c(this.SkB, this.crc.getValue());
            if (this.SkC.getMethod() == 8) {
                c2 = (int) (((long) i2) + c(this.SkB, (long) this.def.getTotalOut()));
                c(this.SkB, (long) this.def.getTotalIn());
            } else {
                c2 = (int) (((long) i2) + c(this.SkB, this.SkD));
                c(this.SkB, this.SkD);
            }
            int d2 = c2 + d(this.SkB, this.SkE);
            if (this.SkC.getExtra() != null) {
                d2 += d(this.SkB, this.SkC.getExtra().length);
            } else {
                d(this.SkB, 0);
            }
            String comment = this.SkC.getComment();
            byte[] bArr = EMPTY_BYTE_ARRAY;
            if (comment != null) {
                bArr = comment.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            }
            d(this.SkB, bArr.length);
            d(this.SkB, 0);
            d(this.SkB, 0);
            c((OutputStream) this.SkB, 0L);
            c(this.SkB, (long) this.offset);
            this.SkB.write(this.SkF);
            this.SkF = null;
            if (this.SkC.getExtra() != null) {
                this.SkB.write(this.SkC.getExtra());
            }
            this.offset = d2 + this.padding + this.offset;
            this.padding = 0;
            if (bArr.length > 0) {
                this.SkB.write(bArr);
            }
            this.SkC = null;
            this.crc.reset();
            this.SkD = 0;
            this.def.reset();
        }
    }

    @Override // java.util.zip.DeflaterOutputStream
    public final void finish() {
        hpk();
        if (!this.chA) {
            if (this.Skz.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.SkC != null) {
                closeEntry();
            }
            int size = this.SkB.size();
            c((OutputStream) this.SkB, 101010256L);
            d(this.SkB, 0);
            d(this.SkB, 0);
            d(this.SkB, this.Skz.size());
            d(this.SkB, this.Skz.size());
            c(this.SkB, (long) size);
            c(this.SkB, (long) (this.offset + this.padding));
            d(this.SkB, this.Sky.length);
            if (this.Sky.length > 0) {
                this.SkB.write(this.Sky);
            }
            this.SkB.writeTo(this.out);
            this.SkB = null;
            this.chA = true;
        }
    }

    private static void c(OutputStream outputStream, int i2) {
        if (i2 > 0) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    outputStream.write(0);
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    public final void putNextEntry(ZipEntry zipEntry) {
        int i2;
        int i3;
        int i4 = 0;
        if (this.SkC != null) {
            closeEntry();
        }
        int method = zipEntry.getMethod();
        if (method == -1) {
            i2 = this.SkA;
        } else {
            i2 = method;
        }
        if (i2 == 0) {
            if (zipEntry.getCompressedSize() == -1) {
                zipEntry.setCompressedSize(zipEntry.getSize());
            } else if (zipEntry.getSize() == -1) {
                zipEntry.setSize(zipEntry.getCompressedSize());
            }
            if (zipEntry.getCrc() == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (zipEntry.getSize() == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (zipEntry.getSize() != zipEntry.getCompressedSize()) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        hpk();
        if (this.Skz.contains(zipEntry.getName())) {
            throw new ZipException("Entry already exists: " + zipEntry.getName());
        } else if (this.Skz.size() == 65535) {
            throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
        } else {
            this.SkF = zipEntry.getName().getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            this.SkE = this.SkF.length;
            if (this.SkE > 65535) {
                throw new IllegalArgumentException("Name too long: " + this.SkE + " UTF-8 bytes");
            }
            this.def.setLevel(this.compressionLevel);
            zipEntry.setMethod(i2);
            this.SkC = zipEntry;
            this.Skz.add(this.SkC.getName());
            int i5 = i2 == 0 ? 0 : 8;
            c(this.out, 67324752L);
            d(this.out, 20);
            d(this.out, i5 | 2048);
            d(this.out, i2);
            if (this.SkC.getTime() == -1) {
                this.SkC.setTime(System.currentTimeMillis());
            }
            d(this.out, 0);
            d(this.out, 33);
            if (i2 == 0) {
                c(this.out, this.SkC.getCrc());
                c(this.out, this.SkC.getSize());
                c(this.out, this.SkC.getSize());
            } else {
                c(this.out, 0L);
                c(this.out, 0L);
                c(this.out, 0L);
            }
            d(this.out, this.SkE);
            int i6 = this.SkE + this.offset + 30;
            if (this.SkC.getExtra() != null) {
                i3 = this.SkC.getExtra().length;
            } else {
                i3 = 0;
            }
            int i7 = i3 + i6;
            if (this.SkC.getMethod() == 0 && this.SkG != 0) {
                int i8 = this.SkG;
                i4 = (i8 - (i7 % i8)) % this.SkG;
            }
            this.padding = i4;
            if (this.SkC.getExtra() != null) {
                d(this.out, this.SkC.getExtra().length + this.padding);
            } else {
                d(this.out, this.padding);
            }
            this.out.write(this.SkF);
            if (this.SkC.getExtra() != null) {
                this.out.write(this.SkC.getExtra());
            }
            c(this.out, this.padding);
        }
    }

    private static long c(OutputStream outputStream, long j2) {
        outputStream.write((int) (255 & j2));
        outputStream.write(((int) (j2 >> 8)) & 255);
        outputStream.write(((int) (j2 >> 16)) & 255);
        outputStream.write(((int) (j2 >> 24)) & 255);
        return j2;
    }

    private static int d(OutputStream outputStream, int i2) {
        if (i2 > 65535) {
            throw new IllegalArgumentException("value " + i2 + " is too large for type 'short'.");
        }
        outputStream.write(i2 & 255);
        outputStream.write((i2 >> 8) & 255);
        return i2;
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream, java.util.zip.DeflaterOutputStream
    public final void write(int i2) {
        byte[] bArr = Skx;
        bArr[0] = (byte) (i2 & 255);
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream, java.util.zip.DeflaterOutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        int length = bArr.length;
        if ((i2 | i3) < 0 || i2 > length || length - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("length=" + length + "; regionStart=" + i2 + "; regionLength=" + i3);
        } else if (this.SkC == null) {
            throw new ZipException("No active entry");
        } else {
            if (this.SkC.getMethod() == 0) {
                this.out.write(bArr, i2, i3);
            } else {
                super.write(bArr, i2, i3);
            }
            this.crc.update(bArr, i2, i3);
            this.SkD += (long) i3;
        }
    }

    private void hpk() {
        if (this.closed) {
            throw new IOException("Stream is closed");
        }
    }
}
