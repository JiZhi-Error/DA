package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FilesCopy {
    private static final String TAG = "MicroMsg.SDK.FilesCopy";

    private FilesCopy() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055 A[SYNTHETIC, Splitter:B:24:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[SYNTHETIC, Splitter:B:27:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a9 A[SYNTHETIC, Splitter:B:48:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ae A[SYNTHETIC, Splitter:B:51:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.FilesCopy.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean copy(String str, String str2, boolean z) {
        AppMethodBeat.i(157540);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157540);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(157540);
            return false;
        }
        o oVar2 = new o(str2);
        if (oVar.isFile()) {
            if (oVar2.isFile() || !oVar2.exists()) {
                copyFile(str, str2);
                if (z) {
                    oVar.delete();
                }
            } else {
                AppMethodBeat.o(157540);
                return false;
            }
        } else if (oVar.isDirectory()) {
            if (!oVar2.exists()) {
                oVar2.mkdirs();
            }
            if (!oVar2.isDirectory()) {
                AppMethodBeat.o(157540);
                return false;
            }
            String[] list = oVar.list();
            for (int i2 = 0; i2 < list.length; i2++) {
                copy(str + FilePathGenerator.ANDROID_DIR_SEP + list[i2], str2 + FilePathGenerator.ANDROID_DIR_SEP + list[i2], z);
            }
        }
        AppMethodBeat.o(157540);
        return true;
    }

    public static boolean copyAssets(Context context, String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(157541);
        try {
            boolean copyAssetsStream = copyAssetsStream(context.getAssets().open(str), str2, false);
            AppMethodBeat.o(157541);
            return copyAssetsStream;
        } catch (IOException e2) {
            Log.e(TAG, "copy assets file srcpath=%s to=%s failed, try pattern now", str, str2);
            while (true) {
                String str3 = str + "." + i2;
                try {
                    if (!copyAssetsStream(context.getAssets().open(str3), str2, true)) {
                        break;
                    }
                    Log.d(TAG, "copy pattern %s", str3);
                    i2++;
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(157541);
            return true;
        }
    }

    private static boolean copyAssetsStream(InputStream inputStream, String str, boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(157542);
        OutputStream outputStream = null;
        try {
            int available = inputStream.available();
            OutputStream dw = s.dw(str, z);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dw.write(bArr, 0, read);
            }
            if (!z) {
                o oVar = new o(str);
                if (!oVar.exists() || ((long) available) != oVar.length()) {
                    z2 = false;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    z2 = false;
                }
            }
            if (dw != null) {
                try {
                    dw.close();
                    z3 = z2;
                } catch (IOException e3) {
                    Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                }
            } else {
                z3 = z2;
            }
        } catch (Exception e4) {
            Log.printErrStackTrace(TAG, e4, "", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace(TAG, e5, "", new Object[0]);
                }
            }
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                    Log.printErrStackTrace(TAG, e6, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    Log.printErrStackTrace(TAG, e7, "", new Object[0]);
                }
            }
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                    Log.printErrStackTrace(TAG, e8, "", new Object[0]);
                }
            }
            AppMethodBeat.o(157542);
            throw th;
        }
        AppMethodBeat.o(157542);
        return z3;
    }
}
