package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class n {
    public static long q(o oVar) {
        long q;
        long j2 = 0;
        AppMethodBeat.i(175568);
        if (oVar == null) {
            AppMethodBeat.o(175568);
            return -1;
        }
        o[] het = oVar.het();
        if (het == null) {
            AppMethodBeat.o(175568);
            return 0;
        }
        for (o oVar2 : het) {
            if (oVar2.isFile()) {
                q = oVar2.length();
            } else {
                q = q(oVar2);
            }
            j2 += q;
        }
        AppMethodBeat.o(175568);
        return j2;
    }

    public static long r(o oVar) {
        long r;
        long j2 = 0;
        AppMethodBeat.i(134329);
        if (oVar == null) {
            AppMethodBeat.o(134329);
            return -1;
        }
        o[] het = oVar.het();
        if (het == null) {
            AppMethodBeat.o(134329);
            return 0;
        }
        for (o oVar2 : het) {
            if (oVar2.isFile()) {
                r = oVar2.length();
            } else {
                r = r(oVar2);
            }
            j2 += r;
        }
        AppMethodBeat.o(134329);
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.nio.ByteBuffer a(com.tencent.mm.vfs.o r11, long r12, long r14) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.n.a(com.tencent.mm.vfs.o, long, long):java.nio.ByteBuffer");
    }

    static ByteBuffer s(o oVar) {
        AppMethodBeat.i(175570);
        ByteBuffer a2 = a(oVar, 0, -1);
        AppMethodBeat.o(175570);
        return a2;
    }

    public static int a(ZipInputStream zipInputStream, String str) {
        AppMethodBeat.i(134332);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!name.contains("../") && !name.contains("..\\")) {
                        if (nextEntry.isDirectory()) {
                            new o(str + FilePathGenerator.ANDROID_DIR_SEP + name.substring(0, name.length() - 1)).mkdirs();
                        } else {
                            o oVar = new o(str + FilePathGenerator.ANDROID_DIR_SEP + name);
                            oVar.heq().mkdirs();
                            oVar.createNewFile();
                            try {
                                OutputStream ap = s.ap(oVar);
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    ap.write(bArr, 0, read);
                                    ap.flush();
                                }
                                Util.qualityClose(ap);
                            } catch (Exception e2) {
                                AppMethodBeat.o(134332);
                                throw e2;
                            } catch (Throwable th) {
                                Util.qualityClose(null);
                                AppMethodBeat.o(134332);
                                throw th;
                            }
                        }
                    }
                } else {
                    Util.qualityClose(zipInputStream);
                    AppMethodBeat.o(134332);
                    return 0;
                }
            }
        } catch (FileNotFoundException e3) {
            Log.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e3, "unzipBytes", new Object[0]);
            Util.qualityClose(zipInputStream);
            AppMethodBeat.o(134332);
            return -1;
        } catch (IOException e4) {
            Log.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e4, "unzipBytes", new Object[0]);
            Util.qualityClose(zipInputStream);
            AppMethodBeat.o(134332);
            return -2;
        } catch (OutOfMemoryError e5) {
            Log.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e5, "unzipBytes", new Object[0]);
            Util.qualityClose(zipInputStream);
            AppMethodBeat.o(134332);
            return -3;
        } catch (Throwable th2) {
            Util.qualityClose(zipInputStream);
            AppMethodBeat.o(134332);
            throw th2;
        }
    }

    static void a(o oVar, q qVar) {
        AppMethodBeat.i(175571);
        o[] a2 = oVar.a(qVar);
        if (a2 != null) {
            for (o oVar2 : a2) {
                if (oVar2.isDirectory()) {
                    a(oVar2, qVar);
                }
            }
        }
        AppMethodBeat.o(175571);
    }

    public static void t(o oVar) {
        AppMethodBeat.i(175572);
        if (oVar == null || !oVar.isDirectory()) {
            AppMethodBeat.o(175572);
            return;
        }
        if (oVar.exists()) {
            o[] het = oVar.het();
            if (het != null) {
                for (o oVar2 : het) {
                    if (oVar2.isDirectory()) {
                        t(oVar2);
                    }
                    oVar2.delete();
                }
            }
            oVar.delete();
        }
        AppMethodBeat.o(175572);
    }

    public static boolean u(o oVar) {
        boolean z = false;
        AppMethodBeat.i(175573);
        if (oVar == null) {
            NullPointerException nullPointerException = new NullPointerException("file should not be NULL");
            AppMethodBeat.o(175573);
            throw nullPointerException;
        }
        if (!oVar.exists()) {
            AppMethodBeat.o(175573);
        } else {
            try {
                FileStructStat fileStructStat = new FileStructStat();
                if (FileStat.b(aa.z(oVar.her()), fileStructStat) == 0) {
                    Log.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", aa.z(oVar.her()), Integer.valueOf(fileStructStat.st_mode));
                    z = fileStructStat.isSymLink();
                    AppMethodBeat.o(175573);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e2, "", new Object[0]);
            }
            AppMethodBeat.o(175573);
        }
        return z;
    }

    public static String Wd(String str) {
        AppMethodBeat.i(134336);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134336);
            return str;
        }
        int i2 = 0;
        while (i2 < str.length() && '/' == str.charAt(i2)) {
            i2++;
        }
        String substring = str.substring(i2);
        AppMethodBeat.o(134336);
        return substring;
    }

    public static String We(String str) {
        int i2 = 0;
        AppMethodBeat.i(134337);
        Log.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134337);
            return "";
        }
        String trim = str.trim();
        if (!trim.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            String concat = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(trim));
            AppMethodBeat.o(134337);
            return concat;
        }
        while (i2 < trim.length() && '/' == trim.charAt(i2)) {
            i2++;
        }
        String str2 = FilePathGenerator.ANDROID_DIR_SEP + trim.substring(i2);
        AppMethodBeat.o(134337);
        return str2;
    }

    public static String Wf(String str) {
        AppMethodBeat.i(196166);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(196166);
            return str;
        }
        int i2 = 0;
        while (i2 < str.length() && '/' == str.charAt(i2)) {
            i2++;
        }
        String substring = str.substring(i2);
        AppMethodBeat.o(196166);
        return substring;
    }
}
