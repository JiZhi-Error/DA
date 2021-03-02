package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class m {
    public static int VERSION = 5;
    public static int cNR = 0;
    public static int cNS = 1;
    public static int cNT = 2;
    public static int cNU = 3;
    public static int cNV = 4;
    public static int cNW = 6;
    Map<Integer, String> cNX = new HashMap();

    public m() {
        AppMethodBeat.i(140061);
        AppMethodBeat.o(140061);
    }

    /* access modifiers changed from: package-private */
    public final void c(RandomAccessFile randomAccessFile) {
        boolean z = true;
        AppMethodBeat.i(140062);
        short readShort = randomAccessFile.readShort();
        short readShort2 = randomAccessFile.readShort();
        short readShort3 = randomAccessFile.readShort();
        if (readShort == 1 && readShort2 == 0) {
            randomAccessFile.seek(12);
            byte[] bArr = new byte[4];
            c cVar = new c((byte) 0);
            int i2 = 0;
            while (true) {
                if (i2 >= readShort3) {
                    break;
                }
                randomAccessFile.read(bArr);
                cVar.name = new String(bArr);
                cVar.cOh = randomAccessFile.readInt();
                cVar.offset = randomAccessFile.readInt();
                cVar.length = randomAccessFile.readInt();
                if ("name".equalsIgnoreCase(cVar.name)) {
                    break;
                }
                if (cVar.name == null || cVar.name.length() == 0) {
                    break;
                }
                i2++;
            }
            z = false;
            if (!z) {
                AppMethodBeat.o(140062);
                return;
            }
            randomAccessFile.seek((long) cVar.offset);
            b bVar = new b((byte) 0);
            bVar.cOe = randomAccessFile.readShort();
            bVar.cOf = randomAccessFile.readShort();
            bVar.cOg = randomAccessFile.readShort();
            a aVar = new a((byte) 0);
            for (int i3 = 0; i3 < bVar.cOf; i3++) {
                aVar.cNY = randomAccessFile.readShort();
                aVar.cNZ = randomAccessFile.readShort();
                aVar.cOa = randomAccessFile.readShort();
                aVar.cOb = randomAccessFile.readShort();
                aVar.cOc = randomAccessFile.readShort();
                aVar.cOd = randomAccessFile.readShort();
                long filePointer = randomAccessFile.getFilePointer();
                if (aVar.cOc <= 0 || aVar.cOc >= 32767) {
                    AppMethodBeat.o(140062);
                    return;
                }
                byte[] bArr2 = new byte[aVar.cOc];
                randomAccessFile.seek((long) (cVar.offset + aVar.cOd + bVar.cOg));
                randomAccessFile.read(bArr2);
                this.cNX.put(Integer.valueOf(aVar.cOb), new String(bArr2, Charset.forName("utf-16")));
                randomAccessFile.seek(filePointer);
            }
            AppMethodBeat.o(140062);
            return;
        }
        AppMethodBeat.o(140062);
    }

    public final String toString() {
        AppMethodBeat.i(140063);
        String obj = this.cNX.toString();
        AppMethodBeat.o(140063);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public static class c {
        int cOh;
        int length;
        String name;
        int offset;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int cOe;
        int cOf;
        int cOg;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int cNY;
        int cNZ;
        int cOa;
        int cOb;
        int cOc;
        int cOd;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
