package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.g;
import com.tencent.stubs.logger.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class s {
    public static InputStream openRead(String str) {
        AppMethodBeat.i(13264);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.o(13264);
            throw fileNotFoundException;
        }
        InputStream b2 = b(aa.parseUri(str), null);
        AppMethodBeat.o(13264);
        return b2;
    }

    public static InputStream b(Uri uri, g.e eVar) {
        AppMethodBeat.i(13266);
        g.e a2 = g.hYQ().a(uri, eVar);
        if (!a2.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13266);
            throw fileNotFoundException;
        }
        InputStream openRead = a2.Rcl.openRead(a2.path);
        AppMethodBeat.o(13266);
        return openRead;
    }

    public static ReadableByteChannel c(Uri uri, g.e eVar) {
        AppMethodBeat.i(170165);
        g.e a2 = g.hYQ().a(uri, eVar);
        if (!a2.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(170165);
            throw fileNotFoundException;
        }
        ReadableByteChannel boI = a2.Rcl.boI(a2.path);
        AppMethodBeat.o(170165);
        return boI;
    }

    public static OutputStream LM(String str) {
        AppMethodBeat.i(258778);
        OutputStream dw = dw(str, false);
        AppMethodBeat.o(258778);
        return dw;
    }

    public static OutputStream dw(String str, boolean z) {
        AppMethodBeat.i(13269);
        if (str == null || str.isEmpty()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path is empty");
            AppMethodBeat.o(13269);
            throw fileNotFoundException;
        }
        OutputStream a2 = a(aa.parseUri(str), (g.e) null, z);
        AppMethodBeat.o(13269);
        return a2;
    }

    static OutputStream a(Uri uri, g.e eVar, boolean z) {
        AppMethodBeat.i(13271);
        g.e a2 = g.hYQ().a(uri, eVar);
        if (!a2.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13271);
            throw fileNotFoundException;
        }
        OutputStream dw = a2.Rcl.dw(a2.path, z);
        AppMethodBeat.o(13271);
        return dw;
    }

    public static WritableByteChannel d(Uri uri, g.e eVar) {
        AppMethodBeat.i(187759);
        g.e a2 = g.hYQ().a(uri, eVar);
        if (!a2.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(187759);
            throw fileNotFoundException;
        }
        WritableByteChannel dv = a2.Rcl.dv(a2.path, false);
        AppMethodBeat.o(187759);
        return dv;
    }

    public static RandomAccessFile dB(String str, boolean z) {
        AppMethodBeat.i(13272);
        RandomAccessFile a2 = a(aa.parseUri(str), z);
        AppMethodBeat.o(13272);
        return a2;
    }

    public static RandomAccessFile a(Uri uri, boolean z) {
        AppMethodBeat.i(13273);
        String b2 = aa.b(uri, z);
        if (b2 == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13273);
            throw fileNotFoundException;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(b2, z ? "rw" : "r");
        AppMethodBeat.o(13273);
        return randomAccessFile;
    }

    public static ParcelFileDescriptor nv(String str, String str2) {
        AppMethodBeat.i(13274);
        ParcelFileDescriptor a2 = a(aa.parseUri(str), (g.e) null, str2);
        AppMethodBeat.o(13274);
        return a2;
    }

    public static ParcelFileDescriptor a(Uri uri, g.e eVar, String str) {
        AppMethodBeat.i(13275);
        g.e a2 = g.hYQ().a(uri, eVar);
        if (!a2.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13275);
            throw fileNotFoundException;
        }
        ParcelFileDescriptor nr = a2.Rcl.nr(a2.path, str);
        AppMethodBeat.o(13275);
        return nr;
    }

    public static String k(String str, boolean z) {
        AppMethodBeat.i(13276);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(13276);
            return null;
        }
        String b2 = aa.b(aa.parseUri(str), z);
        AppMethodBeat.o(13276);
        return b2;
    }

    public static int A(String str, byte[] bArr) {
        AppMethodBeat.i(258779);
        int e2 = e(str, bArr, bArr.length);
        AppMethodBeat.o(258779);
        return e2;
    }

    public static int e(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(13277);
        if (bArr == null || bArr.length == 0 || bArr.length < i2 + 0) {
            AppMethodBeat.o(13277);
            return -2;
        }
        OutputStream outputStream = null;
        try {
            outputStream = dw(str, true);
            outputStream.write(bArr, 0, i2);
            aa.closeQuietly(outputStream);
            AppMethodBeat.o(13277);
            return 0;
        } catch (Exception e2) {
            Log.w("MicroMsg.VFSFileOp", e2, "");
            Log.w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), 0, Integer.valueOf(i2));
            aa.closeQuietly(outputStream);
            AppMethodBeat.o(13277);
            return -1;
        } catch (Throwable th) {
            aa.closeQuietly(outputStream);
            AppMethodBeat.o(13277);
            throw th;
        }
    }

    public static long boW(String str) {
        AppMethodBeat.i(13278);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(13278);
            return 0;
        }
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13278);
            return 0;
        }
        e boM = a2.Rcl.boM(a2.path);
        if (boM == null) {
            AppMethodBeat.o(13278);
            return 0;
        }
        long j2 = boM.size;
        AppMethodBeat.o(13278);
        return j2;
    }

    public static long boX(String str) {
        AppMethodBeat.i(13279);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(13279);
            return 0;
        }
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13279);
            return 0;
        }
        e boM = a2.Rcl.boM(a2.path);
        if (boM == null) {
            AppMethodBeat.o(13279);
            return 0;
        }
        long j2 = boM.RbI;
        AppMethodBeat.o(13279);
        return j2;
    }

    public static byte[] aW(String str, int i2, int i3) {
        InputStream inputStream;
        Throwable th;
        IOException e2;
        AppMethodBeat.i(13280);
        if (str == null) {
            AppMethodBeat.o(13280);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((i3 < 0 || i3 > 8388608) ? 4096 : i3);
        try {
            inputStream = openRead(str);
            for (long j2 = (long) i2; j2 > 0; j2 -= inputStream.skip(j2)) {
                try {
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        Log.w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e2.getMessage());
                        aa.closeQuietly(inputStream);
                        AppMethodBeat.o(13280);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        aa.closeQuietly(inputStream);
                        AppMethodBeat.o(13280);
                        throw th;
                    }
                }
            }
            byte[] bArr = new byte[1024];
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = inputStream.read(bArr, 0, Math.min(i3, 1024));
                if (read == -1 || i3 <= 0) {
                    aa.closeQuietly(inputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i3 -= read;
                }
            }
            aa.closeQuietly(inputStream);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
            }
            Log.d("MicroMsg.VFSFileOp", "readFromFile: %s [%d]", str, Integer.valueOf(byteArray2.length));
            AppMethodBeat.o(13280);
            return byteArray2;
        } catch (IOException e5) {
            e2 = e5;
            inputStream = null;
            Log.w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e2.getMessage());
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(13280);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(13280);
            throw th;
        }
    }

    public static String boY(String str) {
        InputStreamReader inputStreamReader;
        AppMethodBeat.i(13281);
        StringBuilder sb = new StringBuilder();
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        aa.closeQuietly(inputStreamReader);
                        String sb2 = sb.toString();
                        AppMethodBeat.o(13281);
                        return sb2;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    AppMethodBeat.o(13281);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    aa.closeQuietly(inputStreamReader);
                    AppMethodBeat.o(13281);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamReader = null;
            Log.e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            AppMethodBeat.o(13281);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            aa.closeQuietly(inputStreamReader);
            AppMethodBeat.o(13281);
            throw th;
        }
    }

    public static int C(String str, byte[] bArr) {
        AppMethodBeat.i(258780);
        int f2 = f(str, bArr, bArr.length);
        AppMethodBeat.o(258780);
        return f2;
    }

    public static int f(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(13283);
        if (bArr == null) {
            AppMethodBeat.o(13283);
            return -2;
        } else if (bArr.length < i2 + 0) {
            AppMethodBeat.o(13283);
            return -3;
        } else {
            OutputStream outputStream = null;
            try {
                outputStream = dw(str, false);
                outputStream.write(bArr, 0, i2);
                aa.closeQuietly(outputStream);
                AppMethodBeat.o(13283);
                return 0;
            } catch (IOException e2) {
                Log.e("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
                aa.closeQuietly(outputStream);
                AppMethodBeat.o(13283);
                return -1;
            } catch (Throwable th) {
                aa.closeQuietly(outputStream);
                AppMethodBeat.o(13283);
                throw th;
            }
        }
    }

    public static String boZ(String str) {
        AppMethodBeat.i(13284);
        String parent = new o(str).hes().getParent();
        AppMethodBeat.o(13284);
        return parent;
    }

    public static boolean boN(String str) {
        AppMethodBeat.i(13285);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(13285);
            return false;
        }
        o oVar = new o(str);
        if (oVar.mkdirs() || oVar.isDirectory()) {
            AppMethodBeat.o(13285);
            return true;
        }
        AppMethodBeat.o(13285);
        return false;
    }

    public static long nw(String str, String str2) {
        long j2 = -1;
        AppMethodBeat.i(13286);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.o(13286);
        } else if (str.equals(str2)) {
            AppMethodBeat.o(13286);
        } else {
            g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
            g.e a3 = g.hYQ().a(aa.parseUri(str2), (g.e) null);
            if (!a2.valid() || !a3.valid()) {
                AppMethodBeat.o(13286);
            } else {
                try {
                    j2 = a3.Rcl.c(a3.path, a2.Rcl, a2.path);
                    AppMethodBeat.o(13286);
                } catch (IOException e2) {
                    Log.w("MicroMsg.VFSFileOp", "Failed to copy file " + str + " -> " + str2 + ": " + e2.getMessage());
                    AppMethodBeat.o(13286);
                }
            }
        }
        return j2;
    }

    public static boolean YS(String str) {
        AppMethodBeat.i(13287);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(13287);
            return false;
        }
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13287);
            return false;
        }
        boolean boL = a2.Rcl.boL(a2.path);
        AppMethodBeat.o(13287);
        return boL;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(13288);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(13288);
            return false;
        }
        boolean delete = new o(str).delete();
        AppMethodBeat.o(13288);
        return delete;
    }

    public static boolean bo(String str, String str2, String str3) {
        AppMethodBeat.i(13289);
        boolean nx = nx(str + str2, str + str3);
        AppMethodBeat.o(13289);
        return nx;
    }

    public static boolean nx(String str, String str2) {
        AppMethodBeat.i(13290);
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            AppMethodBeat.o(13290);
            return false;
        }
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        g.e a3 = g.hYQ().a(aa.parseUri(str2), (g.e) null);
        if (!a2.valid() || !a3.valid()) {
            AppMethodBeat.o(13290);
            return false;
        }
        try {
            boolean a4 = a3.Rcl.a(a3.path, a2.Rcl, a2.path);
            if (!a4) {
                a4 = a3.Rcl.c(a3.path, a2.Rcl, a2.path) >= 0;
                if (a4) {
                    a2.Rcl.gC(a2.path);
                }
            }
            AppMethodBeat.o(13290);
            return a4;
        } catch (IOException e2) {
            Log.w("MicroMsg.VFSFileOp", "Failed to move file " + str + " -> " + str2 + ": " + e2.getMessage());
            AppMethodBeat.o(13290);
            return false;
        }
    }

    public static Iterable<e> dC(String str, boolean z) {
        AppMethodBeat.i(13291);
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13291);
            return null;
        }
        Iterable<e> dx = a2.Rcl.dx(a2.path, z);
        AppMethodBeat.o(13291);
        return dx;
    }

    private static boolean a(g.e eVar, g.e eVar2, boolean z) {
        AppMethodBeat.i(13292);
        if (!eVar.valid() || !eVar2.valid()) {
            AppMethodBeat.o(13292);
            return false;
        }
        Iterable<e> dx = eVar.Rcl.dx(eVar.path, true);
        if (dx == null) {
            AppMethodBeat.o(13292);
            return false;
        }
        HashSet hashSet = new HashSet();
        eVar2.Rcl.boN(eVar2.path);
        hashSet.add(eVar2.path);
        for (e eVar3 : dx) {
            String substring = eVar3.NGP.substring(eVar.path.length());
            if (!substring.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                substring = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(substring));
            }
            String str = eVar2.path + substring;
            if (!eVar3.RbJ) {
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf > 0) {
                    String substring2 = str.substring(0, lastIndexOf);
                    if (hashSet.add(substring2)) {
                        eVar2.Rcl.boN(substring2);
                    }
                }
                if (z) {
                    try {
                        eVar2.Rcl.a(str, eVar3.RbK, eVar3.NGP);
                    } catch (IOException e2) {
                        Log.w("MicroMsg.VFSFileOp", e2, "Failed to " + (z ? "move" : "copy") + " files.");
                        AppMethodBeat.o(13292);
                        return false;
                    }
                } else {
                    eVar2.Rcl.c(str, eVar3.RbK, eVar3.NGP);
                }
            } else if (hashSet.add(str)) {
                eVar2.Rcl.boN(str);
            }
        }
        AppMethodBeat.o(13292);
        return true;
    }

    public static boolean ny(String str, String str2) {
        AppMethodBeat.i(13293);
        boolean a2 = a(g.hYQ().a(aa.parseUri(str), (g.e) null), g.hYQ().a(aa.parseUri(str2), (g.e) null), false);
        AppMethodBeat.o(13293);
        return a2;
    }

    public static boolean cL(String str, String str2) {
        AppMethodBeat.i(13294);
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        g.e a3 = g.hYQ().a(aa.parseUri(str2), (g.e) null);
        if (a2.valid() && a3.valid()) {
            FileSystem.b bVar = a2.Rcl;
            FileSystem.b bVar2 = a3.Rcl;
            if ((bVar.hdR() & 10) == 10 && (bVar2.hdR() & 10) == 10) {
                String dz = bVar.dz(a2.path, false);
                String dz2 = bVar2.dz(a3.path, true);
                if (!(dz == null || dz2 == null || !new File(dz).renameTo(new File(dz2)))) {
                    AppMethodBeat.o(13294);
                    return true;
                }
            }
        }
        if (!a(a2, a3, true) || !dy(str, false)) {
            AppMethodBeat.o(13294);
            return false;
        }
        AppMethodBeat.o(13294);
        return true;
    }

    public static boolean deleteDir(String str) {
        AppMethodBeat.i(258781);
        boolean dy = dy(str, true);
        AppMethodBeat.o(258781);
        return dy;
    }

    public static boolean dy(String str, boolean z) {
        AppMethodBeat.i(13296);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(13296);
            return false;
        }
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13296);
            return false;
        }
        boolean dy = a2.Rcl.dy(a2.path, z);
        AppMethodBeat.o(13296);
        return dy;
    }

    public static boolean bpa(String str) {
        AppMethodBeat.i(13297);
        try {
            o oVar = new o(str);
            if (oVar.exists() || oVar.createNewFile()) {
                AppMethodBeat.o(13297);
                return true;
            }
            AppMethodBeat.o(13297);
            return false;
        } catch (IOException e2) {
            AppMethodBeat.o(13297);
            return false;
        }
    }

    public static String akC(String str) {
        AppMethodBeat.i(13298);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(13298);
            return "";
        }
        String name = new o(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == name.length() - 1) {
            AppMethodBeat.o(13298);
            return "";
        }
        String substring = name.substring(lastIndexOf + 1);
        AppMethodBeat.o(13298);
        return substring;
    }

    public static String bpb(String str) {
        AppMethodBeat.i(13299);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(13299);
            return "";
        }
        String name = new o(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            AppMethodBeat.o(13299);
            return str;
        } else if (lastIndexOf == 0) {
            AppMethodBeat.o(13299);
            return "";
        } else {
            String substring = name.substring(0, lastIndexOf);
            AppMethodBeat.o(13299);
            return substring;
        }
    }

    public static void bpc(String str) {
        AppMethodBeat.i(13300);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(13300);
            return;
        }
        g.e a2 = g.hYQ().a(aa.parseUri(str), (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13300);
        } else if ((a2.Rcl.hdR() & 2) == 0) {
            AppMethodBeat.o(13300);
        } else if (a2.Rcl.dz(a2.path, true) == null) {
            AppMethodBeat.o(13300);
        } else {
            try {
                a2.Rcl.dw(a2.path + "/.nomedia", false).close();
                AppMethodBeat.o(13300);
            } catch (IOException e2) {
                AppMethodBeat.o(13300);
            }
        }
    }

    private static byte[] bpd(String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        AppMethodBeat.i(13301);
        if (str == null) {
            AppMethodBeat.o(13301);
            return null;
        }
        try {
            inputStream = openRead(str);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        instance.update(bArr, 0, read);
                    } else {
                        byte[] digest = instance.digest();
                        aa.closeQuietly(inputStream);
                        AppMethodBeat.o(13301);
                        return digest;
                    }
                }
            } catch (Exception e2) {
                aa.closeQuietly(inputStream);
                AppMethodBeat.o(13301);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                aa.closeQuietly(inputStream2);
                AppMethodBeat.o(13301);
                throw th;
            }
        } catch (Exception e3) {
            inputStream = null;
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(13301);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = null;
            aa.closeQuietly(inputStream2);
            AppMethodBeat.o(13301);
            throw th;
        }
    }

    public static String bhK(String str) {
        AppMethodBeat.i(13302);
        byte[] bpd = bpd(str);
        if (bpd == null) {
            AppMethodBeat.o(13302);
            return null;
        }
        StringBuilder sb = new StringBuilder(32);
        for (byte b2 : bpd) {
            sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(13302);
        return sb2;
    }

    public static int fW(String str, String str2) {
        ZipInputStream zipInputStream;
        AppMethodBeat.i(13303);
        try {
            zipInputStream = new ZipInputStream(openRead(str));
            try {
                HashSet hashSet = new HashSet();
                byte[] bArr = new byte[4096];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains("..\\")) {
                            if (nextEntry.isDirectory()) {
                                String substring = name.substring(0, name.length() - 1);
                                if (hashSet.add(substring)) {
                                    new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + substring).mkdirs();
                                }
                            } else {
                                o oVar = new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + name);
                                String bpg = aa.bpg(name);
                                if (bpg != null && hashSet.add(bpg)) {
                                    new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + bpg).mkdirs();
                                }
                                OutputStream ap = ap(oVar);
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    ap.write(bArr, 0, read);
                                }
                                ap.close();
                            }
                        }
                    } else {
                        aa.closeQuietly(zipInputStream);
                        AppMethodBeat.o(13303);
                        return 0;
                    }
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                try {
                    Log.w("MicroMsg.VFSFileOp", e, "");
                    aa.closeQuietly(zipInputStream);
                    AppMethodBeat.o(13303);
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    aa.closeQuietly(zipInputStream);
                    AppMethodBeat.o(13303);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                Log.w("MicroMsg.VFSFileOp", e, "");
                aa.closeQuietly(zipInputStream);
                AppMethodBeat.o(13303);
                return -2;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            zipInputStream = null;
            Log.w("MicroMsg.VFSFileOp", e, "");
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(13303);
            return -1;
        } catch (IOException e5) {
            e = e5;
            zipInputStream = null;
            Log.w("MicroMsg.VFSFileOp", e, "");
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(13303);
            return -2;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(13303);
            throw th;
        }
    }

    public static boolean nz(String str, String str2) {
        AppMethodBeat.i(170171);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(170171);
            return false;
        }
        boolean t = t(Collections.singletonList(str), str2);
        AppMethodBeat.o(170171);
        return t;
    }

    public static boolean t(List<String> list, String str) {
        ZipOutputStream zipOutputStream;
        InputStream inputStream;
        ZipOutputStream zipOutputStream2;
        Throwable th;
        e boM;
        Iterable<e> singletonList;
        int lastIndexOf;
        String substring;
        AppMethodBeat.i(13304);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(13304);
            return false;
        }
        boN(boZ(str));
        byte[] bArr = new byte[4096];
        try {
            zipOutputStream2 = new ZipOutputStream(dw(str, false));
            try {
                for (String str2 : list) {
                    g.e a2 = g.hYQ().a(aa.parseUri(str2), (g.e) null);
                    if (a2.valid() && (boM = a2.Rcl.boM(a2.path)) != null) {
                        if (boM.RbJ) {
                            int length = (a2.path.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? 0 : 1) + a2.path.length();
                            singletonList = a2.Rcl.dx(a2.path, true);
                            if (singletonList != null) {
                                lastIndexOf = length;
                            }
                        } else {
                            singletonList = Collections.singletonList(boM);
                            lastIndexOf = a2.path.lastIndexOf(47) + 1;
                        }
                        for (e eVar : singletonList) {
                            if (!eVar.RbJ) {
                                if (eVar.NGP.length() < lastIndexOf) {
                                    substring = eVar.name;
                                } else {
                                    substring = eVar.NGP.substring(lastIndexOf);
                                }
                                inputStream = eVar.RbK.openRead(eVar.NGP);
                                try {
                                    zipOutputStream2.putNextEntry(new ZipEntry(substring));
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        zipOutputStream2.write(bArr, 0, read);
                                    }
                                    inputStream.close();
                                    zipOutputStream2.closeEntry();
                                } catch (IOException e2) {
                                    e = e2;
                                    zipOutputStream = zipOutputStream2;
                                    try {
                                        Log.w("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
                                        aa.closeQuietly(inputStream);
                                        aa.closeQuietly(zipOutputStream);
                                        AppMethodBeat.o(13304);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        zipOutputStream2 = zipOutputStream;
                                        aa.closeQuietly(inputStream);
                                        aa.closeQuietly(zipOutputStream2);
                                        AppMethodBeat.o(13304);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    aa.closeQuietly(inputStream);
                                    aa.closeQuietly(zipOutputStream2);
                                    AppMethodBeat.o(13304);
                                    throw th;
                                }
                            }
                        }
                    }
                }
                aa.closeQuietly(null);
                aa.closeQuietly(zipOutputStream2);
                AppMethodBeat.o(13304);
                return true;
            } catch (IOException e3) {
                e = e3;
                zipOutputStream = zipOutputStream2;
                inputStream = null;
                Log.w("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
                aa.closeQuietly(inputStream);
                aa.closeQuietly(zipOutputStream);
                AppMethodBeat.o(13304);
                return false;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                aa.closeQuietly(inputStream);
                aa.closeQuietly(zipOutputStream2);
                AppMethodBeat.o(13304);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            zipOutputStream = null;
            inputStream = null;
            Log.w("MicroMsg.VFSFileOp", e, "Failed to write ZipFile");
            aa.closeQuietly(inputStream);
            aa.closeQuietly(zipOutputStream);
            AppMethodBeat.o(13304);
            return false;
        } catch (Throwable th5) {
            th = th5;
            zipOutputStream2 = null;
            inputStream = null;
            aa.closeQuietly(inputStream);
            aa.closeQuietly(zipOutputStream2);
            AppMethodBeat.o(13304);
            throw th;
        }
    }

    public static InputStream ao(o oVar) {
        AppMethodBeat.i(13265);
        InputStream b2 = b(oVar.mUri, oVar.heo());
        AppMethodBeat.o(13265);
        return b2;
    }

    public static OutputStream ap(o oVar) {
        AppMethodBeat.i(13268);
        OutputStream a2 = a(oVar.mUri, oVar.heo(), false);
        AppMethodBeat.o(13268);
        return a2;
    }

    public static OutputStream d(o oVar, boolean z) {
        AppMethodBeat.i(170167);
        OutputStream a2 = a(oVar.mUri, oVar.heo(), z);
        AppMethodBeat.o(170167);
        return a2;
    }
}
