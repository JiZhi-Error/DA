package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static Set<Long> qIq = new HashSet();

    static {
        AppMethodBeat.i(88970);
        AppMethodBeat.o(88970);
    }

    public static void Cy(long j2) {
        AppMethodBeat.i(88964);
        qIq.add(Long.valueOf(j2));
        AppMethodBeat.o(88964);
    }

    public static void Cz(long j2) {
        AppMethodBeat.i(88965);
        qIq.remove(Long.valueOf(j2));
        AppMethodBeat.o(88965);
    }

    public static boolean CA(long j2) {
        AppMethodBeat.i(88966);
        boolean contains = qIq.contains(Long.valueOf(j2));
        AppMethodBeat.o(88966);
        return contains;
    }

    public static boolean f(a aVar) {
        a alb;
        int i2 = 1;
        AppMethodBeat.i(88967);
        if (aVar.field_sectionMd5Byte == null) {
            String str = aVar.field_filePath;
            String str2 = aVar.field_md5;
            String str3 = aVar.field_appId;
            o oVar = new o(str);
            Log.i("MicroMsg.FileDownloadMD5Manager", "MD5 Check: %s, File Exists: %b", str, Boolean.valueOf(oVar.exists()));
            long currentTimeMillis = System.currentTimeMillis();
            String bhK = s.bhK(aa.z(oVar.mUri));
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Log.i("MicroMsg.FileDownloadMD5Manager", "MD5 Check Time: %d", Long.valueOf(currentTimeMillis2));
            Log.i("MicroMsg.FileDownloadMD5Manager", "Original MD5: %s, Calculated MD5: %s", str2, bhK);
            if (!Util.isNullOrNil(str3) && (alb = d.alb(str3)) != null) {
                long j2 = alb.field_downloadId;
                if (!alb.field_reserveInWifi) {
                    i2 = 0;
                }
                com.tencent.mm.plugin.downloader.f.a.a(111, new b(str3, j2, "", currentTimeMillis2, i2));
            }
            if (Util.isNullOrNil(str2)) {
                boolean exists = oVar.exists();
                AppMethodBeat.o(88967);
                return exists;
            } else if (Util.isNullOrNil(bhK)) {
                Log.i("MicroMsg.FileDownloadMD5Manager", "check from file failed, may caused by low memory while checking md5");
                boolean exists2 = oVar.exists();
                AppMethodBeat.o(88967);
                return exists2;
            } else {
                boolean equalsIgnoreCase = str2.trim().equalsIgnoreCase(bhK.trim());
                AppMethodBeat.o(88967);
                return equalsIgnoreCase;
            }
        } else {
            boolean g2 = g(aVar);
            AppMethodBeat.o(88967);
            return g2;
        }
    }

    public static boolean g(a aVar) {
        int i2;
        AppMethodBeat.i(88968);
        if (aVar == null || aVar.field_sectionMd5Byte == null) {
            AppMethodBeat.o(88968);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        q qVar = new q();
        try {
            qVar.parseFrom(aVar.field_sectionMd5Byte);
            boolean c2 = c(aVar.field_filePath, qVar.qGz);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Log.i("MicroMsg.FileDownloadMD5Manager", "sectionMd5Check, costTime = %d, ret = %b", Long.valueOf(currentTimeMillis2), Boolean.valueOf(c2));
            String str = aVar.field_appId;
            long j2 = aVar.field_downloadId;
            if (aVar.field_reserveInWifi) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            com.tencent.mm.plugin.downloader.f.a.a(111, new b(str, j2, "", currentTimeMillis2, i2));
            AppMethodBeat.o(88968);
            return c2;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.FileDownloadMD5Manager", e2, "", new Object[0]);
            AppMethodBeat.o(88968);
            return true;
        }
    }

    private static boolean c(String str, LinkedList<com.tencent.mm.plugin.downloader.c.b.a> linkedList) {
        boolean z;
        int read;
        AppMethodBeat.i(88969);
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile dB = s.dB(str, false);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            Iterator<com.tencent.mm.plugin.downloader.c.b.a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                com.tencent.mm.plugin.downloader.c.b.a next = it.next();
                dB.seek(next.qGj);
                long j2 = (next.qGk - next.qGj) + 1;
                int min = (int) Math.min(2048L, j2);
                byte[] bArr = new byte[min];
                while (j2 > 0 && (read = dB.read(bArr, 0, (int) Math.min((long) min, j2))) >= 0) {
                    j2 -= (long) read;
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder(32);
                    for (byte b2 : digest) {
                        sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                    }
                    if (!sb.toString().trim().equals(next.qGl)) {
                        z = false;
                        break;
                    }
                }
            }
            if (dB != null) {
                try {
                    dB.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.FileDownloadMD5Manager", e3, "", new Object[0]);
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                    z = true;
                } catch (IOException e4) {
                    z = true;
                }
            } else {
                z = true;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(88969);
            throw th;
        }
        AppMethodBeat.o(88969);
        return z;
    }
}
