package com.tencent.tinker.d.a;

import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class g implements Cloneable {
    String KJM;
    long SkJ = -1;
    int SkK = -1;
    int SkL = -1;
    byte[] SkM;
    long SkN = -1;
    long SkO = -1;
    public long crc = -1;
    int hXs = -1;
    public String name;
    long size = -1;

    public g(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        byte[] bytes = str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        if (bytes.length > 65535) {
            throw new IllegalArgumentException("Name" + " too long: " + bytes.length);
        }
        this.name = str;
    }

    public g(g gVar) {
        this.name = gVar.name;
        this.KJM = gVar.KJM;
        this.hXs = gVar.hXs;
        this.size = gVar.size;
        this.SkJ = gVar.SkJ;
        this.crc = gVar.crc;
        this.SkK = gVar.SkK;
        this.SkL = gVar.SkL;
        this.SkM = gVar.SkM;
        this.SkN = gVar.SkN;
        this.SkO = gVar.SkO;
    }

    g(byte[] bArr, InputStream inputStream, Charset charset) {
        f.b(inputStream, bArr, 0, 46);
        c a2 = d.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a2.readInt();
        if (((long) readInt) != 33639248) {
            h.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        a2.seek(8);
        int readShort = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(readShort)));
        }
        charset = (readShort & 2048) != 0 ? Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET) : charset;
        this.SkK = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        this.hXs = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        this.SkL = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        this.crc = ((long) a2.readInt()) & Util.MAX_32BIT_VALUE;
        this.SkJ = ((long) a2.readInt()) & Util.MAX_32BIT_VALUE;
        this.size = ((long) a2.readInt()) & Util.MAX_32BIT_VALUE;
        int readShort2 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        int readShort3 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        int readShort4 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
        a2.seek(42);
        this.SkN = ((long) a2.readInt()) & Util.MAX_32BIT_VALUE;
        byte[] bArr2 = new byte[readShort2];
        f.b(inputStream, bArr2, 0, bArr2.length);
        if (db(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort3 > 0) {
            this.SkM = new byte[readShort3];
            f.b(inputStream, this.SkM, 0, readShort3);
        }
        if (readShort4 > 0) {
            byte[] bArr3 = new byte[readShort4];
            f.b(inputStream, bArr3, 0, readShort4);
            this.KJM = new String(bArr3, 0, bArr3.length, charset);
        }
    }

    private static boolean db(byte[] bArr) {
        for (byte b2 : bArr) {
            if (b2 == 0) {
                return true;
            }
        }
        return false;
    }

    public final void setMethod(int i2) {
        if (i2 == 0 || i2 == 8) {
            this.SkK = i2;
            return;
        }
        throw new IllegalArgumentException("Bad method: ".concat(String.valueOf(i2)));
    }

    public final void setSize(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Bad size: ".concat(String.valueOf(j2)));
        }
        this.size = j2;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.name);
        stringBuffer.append("\ncomment:" + this.KJM);
        stringBuffer.append("\ntime:" + this.hXs);
        stringBuffer.append("\nsize:" + this.size);
        stringBuffer.append("\ncompressedSize:" + this.SkJ);
        stringBuffer.append("\ncrc:" + this.crc);
        stringBuffer.append("\ncompressionMethod:" + this.SkK);
        stringBuffer.append("\nmodDate:" + this.SkL);
        stringBuffer.append("\nextra length:" + this.SkM.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.SkN);
        stringBuffer.append("\ndataOffset:" + this.SkO);
        return stringBuffer.toString();
    }

    @Override // java.lang.Object
    public final Object clone() {
        try {
            g gVar = (g) super.clone();
            gVar.SkM = this.SkM != null ? (byte[]) this.SkM.clone() : null;
            return gVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return this.name.equals(((g) obj).name);
    }
}
