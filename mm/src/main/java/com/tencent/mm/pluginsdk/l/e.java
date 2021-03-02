package com.tencent.mm.pluginsdk.l;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Process;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;

public final class e {
    private static final String KaM = ("/storage/emulated/" + (Process.myUid() / 100000) + FilePathGenerator.ANDROID_DIR_SEP);

    static {
        AppMethodBeat.i(232186);
        AppMethodBeat.o(232186);
    }

    private static String ben(String str) {
        AppMethodBeat.i(232184);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(232184);
            return str;
        } else if (str.startsWith("/sdcard/")) {
            String substring = str.substring(8);
            AppMethodBeat.o(232184);
            return substring;
        } else if (str.startsWith(KaM)) {
            String substring2 = str.substring(KaM.length());
            AppMethodBeat.o(232184);
            return substring2;
        } else {
            AppMethodBeat.o(232184);
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a8, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.ShareUtil", r0, "[-] Fail to call readlink.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = new java.io.File(r9).getCanonicalPath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bf, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.ShareUtil", r0, "[-] Fail to call getCanonicalPath.", new java.lang.Object[0]);
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x018d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x018e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x018d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String beo(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 409
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.l.e.beo(java.lang.String):java.lang.String");
    }

    public static final String b(ContentResolver contentResolver, Uri uri) {
        o oVar;
        InputStream inputStream;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(31178);
        if (uri == null) {
            AppMethodBeat.o(31178);
            return null;
        }
        String type = contentResolver.getType(uri);
        String extByMimeType = getExtByMimeType(type);
        String c2 = c(contentResolver, uri);
        if (Util.isNullOrNil(c2)) {
            c2 = "share_file" + getExtByMimeType(type);
        }
        o oVar2 = new o(b.aKM(), c2);
        if (oVar2.exists()) {
            bg.aVF();
            oVar = new o(m.aB(c.aTg(), c2, extByMimeType));
        } else {
            oVar = oVar2;
        }
        try {
            outputStream = s.ap(oVar);
            try {
                inputStream = contentResolver.openInputStream(uri);
                if (inputStream == null) {
                    Util.qualityClose(inputStream);
                    Util.qualityClose(outputStream);
                    AppMethodBeat.o(31178);
                    return null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            String z = aa.z(oVar.her());
                            Util.qualityClose(inputStream);
                            Util.qualityClose(outputStream);
                            AppMethodBeat.o(31178);
                            return z;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(31178);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(31178);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                Log.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(31178);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(31178);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            outputStream = null;
            Log.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
            Util.qualityClose(inputStream);
            Util.qualityClose(outputStream);
            AppMethodBeat.o(31178);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            outputStream = null;
            Util.qualityClose(inputStream);
            Util.qualityClose(outputStream);
            AppMethodBeat.o(31178);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.l.e.c(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }

    public static final String a(ContentResolver contentResolver, Uri uri, int i2) {
        InputStream inputStream;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(31180);
        if (uri == null) {
            AppMethodBeat.o(31180);
            return null;
        }
        o oVar = new o(MMApplicationContext.getContext().getCacheDir(), "share_img_tmp_" + i2 + getExtByMimeType(contentResolver.getType(uri)));
        oVar.delete();
        try {
            outputStream = s.ap(oVar);
            try {
                inputStream = contentResolver.openInputStream(uri);
                if (inputStream == null) {
                    Util.qualityClose(inputStream);
                    Util.qualityClose(outputStream);
                    AppMethodBeat.o(31180);
                    return null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            String z = aa.z(oVar.her());
                            Util.qualityClose(inputStream);
                            Util.qualityClose(outputStream);
                            AppMethodBeat.o(31180);
                            return z;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(31180);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(31180);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                Log.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(31180);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(31180);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            outputStream = null;
            Log.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
            Util.qualityClose(inputStream);
            Util.qualityClose(outputStream);
            AppMethodBeat.o(31180);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            outputStream = null;
            Util.qualityClose(inputStream);
            Util.qualityClose(outputStream);
            AppMethodBeat.o(31180);
            throw th;
        }
    }

    private static String getExtByMimeType(String str) {
        String[] split;
        AppMethodBeat.i(31181);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(31181);
            return "";
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if ((extensionFromMimeType == null || extensionFromMimeType.length() == 0) && (split = str.split(FilePathGenerator.ANDROID_DIR_SEP)) != null && split.length > 1) {
            extensionFromMimeType = split[1];
        }
        String concat = ".".concat(String.valueOf(extensionFromMimeType));
        AppMethodBeat.o(31181);
        return concat;
    }
}
