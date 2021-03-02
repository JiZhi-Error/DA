package com.tencent.tinker.d.a;

import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class h implements Closeable {
    public String KJM;
    private final LinkedHashMap<String, g> SkP;
    private File SkQ;
    private RandomAccessFile SkR;
    private final String filename;

    public h(File file) {
        this(file, (byte) 0);
    }

    public h(String str) {
        this(new File(str), (byte) 0);
    }

    private h(File file, byte b2) {
        this.SkP = new LinkedHashMap<>();
        this.filename = file.getPath();
        this.SkQ = null;
        this.SkR = new RandomAccessFile(this.filename, "r");
        hpm();
    }

    static void a(String str, long j2, String str2, long j3, String str3, int i2) {
        throw new ZipException("file name:" + str + ", file size" + j2 + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j3 + ", " + str3 + " signature not found; was " + Integer.toHexString(i2));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        RandomAccessFile randomAccessFile = this.SkR;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.SkR = null;
                randomAccessFile.close();
            }
            if (this.SkQ != null) {
                this.SkQ.delete();
                this.SkQ = null;
            }
        }
    }

    public final void oa() {
        if (this.SkR == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final Enumeration<? extends g> entries() {
        oa();
        final Iterator<g> it = this.SkP.values().iterator();
        return new Enumeration<g>() {
            /* class com.tencent.tinker.d.a.h.AnonymousClass1 */

            public final boolean hasMoreElements() {
                h.this.oa();
                return it.hasNext();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Enumeration
            public final /* synthetic */ g nextElement() {
                h.this.oa();
                return (g) it.next();
            }
        };
    }

    public final g bqM(String str) {
        oa();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        g gVar = this.SkP.get(str);
        if (gVar == null) {
            return this.SkP.get(str + FilePathGenerator.ANDROID_DIR_SEP);
        }
        return gVar;
    }

    public final InputStream a(g gVar) {
        a aVar;
        g bqM = bqM(gVar.name);
        if (bqM == null) {
            return null;
        }
        RandomAccessFile randomAccessFile = this.SkR;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, bqM.SkN);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), bqM.name, bqM.SkN, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & ISelectionInterface.HELD_NOTHING;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(reverseBytes2)));
            }
            dataInputStream.skipBytes(18);
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & ISelectionInterface.HELD_NOTHING;
            int reverseBytes4 = Short.reverseBytes(dataInputStream.readShort()) & ISelectionInterface.HELD_NOTHING;
            dataInputStream.close();
            aVar.skip((long) (reverseBytes3 + reverseBytes4));
            if (bqM.SkK == 0) {
                aVar.bur = aVar.offset + bqM.size;
            } else {
                aVar.bur = aVar.offset + bqM.SkJ;
            }
        }
        return aVar;
    }

    private void hpm() {
        long j2 = 0;
        long length = this.SkR.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.SkR.length());
        }
        this.SkR.seek(0);
        if (((long) Integer.reverseBytes(this.SkR.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j3 = length - 65536;
        if (j3 >= 0) {
            j2 = j3;
        }
        while (true) {
            this.SkR.seek(length);
            if (((long) Integer.reverseBytes(this.SkR.readInt())) != 101010256) {
                long j4 = length - 1;
                if (j4 < j2) {
                    throw new ZipException("End Of Central Directory signature not found");
                }
                length = j4;
            } else {
                byte[] bArr = new byte[18];
                this.SkR.readFully(bArr);
                c a2 = d.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a2.readShort() & ISelectionInterface.HELD_NOTHING;
                int readShort2 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
                int readShort3 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
                int readShort4 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
                a2.hpl();
                long readInt = ((long) a2.readInt()) & Util.MAX_32BIT_VALUE;
                int readShort5 = a2.readShort() & ISelectionInterface.HELD_NOTHING;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        byte[] bArr2 = new byte[readShort5];
                        this.SkR.readFully(bArr2);
                        this.KJM = new String(bArr2, 0, bArr2.length, e.UTF_8);
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new a(this.SkR, readInt), 4096);
                    byte[] bArr3 = new byte[46];
                    for (int i2 = 0; i2 < readShort3; i2++) {
                        g gVar = new g(bArr3, bufferedInputStream, e.UTF_8);
                        if (gVar.SkN >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = gVar.name;
                        if (this.SkP.put(str, gVar) != null) {
                            throw new ZipException("Duplicate entry name: ".concat(String.valueOf(str)));
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        }
    }

    public static class a extends InputStream {
        private final RandomAccessFile SkT;
        private long bur;
        private long offset;

        private a(RandomAccessFile randomAccessFile, long j2, long j3) {
            this.SkT = randomAccessFile;
            this.offset = j2;
            this.bur = j3;
        }

        public a(RandomAccessFile randomAccessFile, long j2) {
            this(randomAccessFile, j2, randomAccessFile.length());
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.offset < this.bur ? 1 : 0;
        }

        @Override // java.io.InputStream
        public final int read() {
            return f.T(this);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            int read;
            synchronized (this.SkT) {
                long j2 = this.bur - this.offset;
                if (((long) i3) > j2) {
                    i3 = (int) j2;
                }
                this.SkT.seek(this.offset);
                read = this.SkT.read(bArr, i2, i3);
                if (read > 0) {
                    this.offset += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        @Override // java.io.InputStream
        public final long skip(long j2) {
            if (j2 > this.bur - this.offset) {
                j2 = this.bur - this.offset;
            }
            this.offset += j2;
            return j2;
        }
    }
}
