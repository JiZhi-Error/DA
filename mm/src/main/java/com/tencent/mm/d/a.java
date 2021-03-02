package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    public C0309a dje;
    public b djf = null;

    public a(b bVar) {
        this.djf = bVar;
    }

    public final int A(File file) {
        AppMethodBeat.i(961);
        try {
            if (fO(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                AppMethodBeat.o(961);
                return -1;
            }
            byte[] byteArray = this.djf.toByteArray();
            byte[] bt = C0309a.bt((C0309a.djg << 32) | ((long) new C0309a(byteArray.length).djh));
            byte[] bArr = {(byte) ((byteArray.length + 8) % 256), (byte) ((byteArray.length + 8) / 256)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(byteArray);
            fileOutputStream.write(bt);
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(961);
            return 0;
        } catch (Exception e2) {
            AppMethodBeat.o(961);
            return -1;
        }
    }

    public static boolean fP(String str) {
        boolean z = false;
        AppMethodBeat.i(963);
        if (str == null) {
            AppMethodBeat.o(963);
        } else {
            File file = new File(str);
            if (!file.exists()) {
                AppMethodBeat.o(963);
            } else {
                a fO = fO(str);
                if (!(fO == null || fO.djf == null)) {
                    try {
                        byte[] bArr = {0, 0};
                        File file2 = new File(str);
                        if (file2.exists()) {
                            z = fO.djf.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (fO.dje.djh + 8))) - 2), bArr));
                            AppMethodBeat.o(963);
                        }
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(963);
            }
        }
        return z;
    }

    private static byte[] k(String str, int i2, int i3) {
        int i4;
        byte[] bArr;
        AppMethodBeat.i(964);
        if (str == null) {
            AppMethodBeat.o(964);
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(964);
            return null;
        }
        if (i3 == -1) {
            i4 = (int) file.length();
        } else {
            i4 = i3;
        }
        if (i2 < 0) {
            AppMethodBeat.o(964);
            return null;
        } else if (i4 <= 0) {
            AppMethodBeat.o(964);
            return null;
        } else {
            if (i2 + i4 > ((int) file.length())) {
                i4 = ((int) file.length()) - i2;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                bArr = new byte[i4];
                try {
                    randomAccessFile.seek((long) i2);
                    randomAccessFile.readFully(bArr);
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                bArr = null;
            }
            AppMethodBeat.o(964);
            return bArr;
        }
    }

    /* renamed from: com.tencent.mm.d.a$a  reason: collision with other inner class name */
    public static class C0309a {
        static final long djg = ((long) "Micromsg".hashCode());
        public int djh = 0;

        static {
            AppMethodBeat.i(959);
            AppMethodBeat.o(959);
        }

        public C0309a(int i2) {
            this.djh = i2;
        }

        public static C0309a U(byte[] bArr) {
            C0309a aVar;
            AppMethodBeat.i(960);
            if (bArr.length == 8) {
                long j2 = 0;
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    j2 |= ((long) (bArr[i2] & 255)) << (i2 * 8);
                }
                if ((j2 >> 32) == djg) {
                    aVar = new C0309a((int) j2);
                    AppMethodBeat.o(960);
                    return aVar;
                }
            }
            aVar = null;
            AppMethodBeat.o(960);
            return aVar;
        }

        static byte[] bt(long j2) {
            byte[] bArr = new byte[8];
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i2] = (byte) ((int) ((j2 >> (i2 * 8)) & 255));
            }
            return bArr;
        }
    }

    public static a fO(String str) {
        int i2 = 0;
        AppMethodBeat.i(962);
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i2 = (int) file.length();
                }
            } catch (Exception e2) {
            }
        }
        if (i2 < 8) {
            AppMethodBeat.o(962);
            return null;
        }
        C0309a U = C0309a.U(k(str, i2 - 8, 8));
        if (U == null) {
            AppMethodBeat.o(962);
            return null;
        }
        if (U.djh >= 0) {
            b bVar = new b();
            bVar.parseFrom(k(str, (i2 - U.djh) - 8, U.djh));
            a aVar = new a(bVar);
            aVar.dje = U;
            AppMethodBeat.o(962);
            return aVar;
        }
        AppMethodBeat.o(962);
        return null;
    }
}
