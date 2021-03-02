package com.tencent.mm.plugin.performance.diagnostic.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.a.e;
import org.xwalk.core.XWalkEnvironment;

public final class b {
    static String aJS(String str) {
        AppMethodBeat.i(124914);
        if (TextUtils.equals(str, "armeabi")) {
            AppMethodBeat.o(124914);
            return "arm";
        } else if (TextUtils.equals(str, XWalkEnvironment.RUNTIME_ABI_ARM32_STR)) {
            AppMethodBeat.o(124914);
            return "arm";
        } else if (TextUtils.equals(str, XWalkEnvironment.RUNTIME_ABI_ARM64_STR)) {
            AppMethodBeat.o(124914);
            return "arm64";
        } else if (TextUtils.equals(str, "mips")) {
            AppMethodBeat.o(124914);
            return "mips";
        } else if (TextUtils.equals(str, "mips64")) {
            AppMethodBeat.o(124914);
            return "mips64";
        } else if (TextUtils.equals(str, "x86")) {
            AppMethodBeat.o(124914);
            return "x86";
        } else if (TextUtils.equals(str, "x86_64")) {
            AppMethodBeat.o(124914);
            return "x86_64";
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown abi: ".concat(String.valueOf(str)));
            AppMethodBeat.o(124914);
            throw illegalArgumentException;
        }
    }

    private static o U(o oVar) {
        AppMethodBeat.i(176895);
        o oVar2 = new o(aa.z(oVar.her()));
        AppMethodBeat.o(176895);
        return oVar2;
    }

    public static void a(o oVar, o oVar2, q qVar) {
        ZipOutputStream zipOutputStream;
        AppMethodBeat.i(176896);
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(s.ap(oVar2)));
            try {
                ArrayList arrayList = new ArrayList();
                o U = U(oVar);
                if (U.isDirectory()) {
                    arrayList.addAll(Arrays.asList(U.a(qVar)));
                } else {
                    arrayList.add(U);
                }
                while (!arrayList.isEmpty()) {
                    o U2 = U((o) arrayList.remove(0));
                    String substring = aa.z(U2.her()).substring(aa.z(U.her()).length());
                    if (substring.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        substring = substring.substring(1);
                    }
                    if (substring.isEmpty()) {
                        substring = U2.getName();
                    }
                    ZipEntry zipEntry = new ZipEntry(substring);
                    zipEntry.setMethod(8);
                    try {
                        zipOutputStream.putNextEntry(zipEntry);
                        if (U2.isDirectory()) {
                            arrayList.addAll(Arrays.asList(U2.a(qVar)));
                        } else {
                            a(U2, zipOutputStream);
                        }
                        zipOutputStream.closeEntry();
                    } catch (Throwable th) {
                        zipOutputStream.closeEntry();
                        AppMethodBeat.o(176896);
                        throw th;
                    }
                }
                e.e(zipOutputStream);
                AppMethodBeat.o(176896);
            } catch (Throwable th2) {
                th = th2;
                e.e(zipOutputStream);
                AppMethodBeat.o(176896);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
            e.e(zipOutputStream);
            AppMethodBeat.o(176896);
            throw th;
        }
    }

    static o V(o oVar) {
        AppMethodBeat.i(176897);
        if (!oVar.canRead()) {
            IOException iOException = new IOException("cannot read file: " + aa.z(oVar.her()));
            AppMethodBeat.o(176897);
            throw iOException;
        }
        AppMethodBeat.o(176897);
        return oVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bd, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c0, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc A[ExcHandler: all (r0v15 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:21:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int aJT(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.diagnostic.a.b.aJT(java.lang.String):int");
    }

    private static void a(o oVar, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.i(176898);
        byte[] bArr = new byte[4096];
        try {
            bufferedInputStream = new BufferedInputStream(s.ao(oVar));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        e.W(bufferedInputStream);
                        AppMethodBeat.o(176898);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream.flush();
                    e.W(bufferedInputStream);
                    AppMethodBeat.o(176898);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            outputStream.flush();
            e.W(bufferedInputStream);
            AppMethodBeat.o(176898);
            throw th;
        }
    }
}
