package com.tencent.mm.pluginsdk.j.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    public static long hv(String str) {
        AppMethodBeat.i(152084);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152084);
            return 0;
        }
        o oVar = new o(str);
        if (oVar.isFile()) {
            long length = oVar.length();
            AppMethodBeat.o(152084);
            return length;
        }
        AppMethodBeat.o(152084);
        return 0;
    }

    public static boolean y(String str, byte[] bArr) {
        AppMethodBeat.i(152085);
        if (Util.isNullOrNil(bArr)) {
            AppMethodBeat.o(152085);
            return false;
        }
        o oVar = new o(str);
        oVar.delete();
        oVar.heq().mkdirs();
        OutputStream outputStream = null;
        try {
            outputStream = s.ap(oVar);
            outputStream.write(bArr);
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(152085);
            return true;
        } catch (FileNotFoundException e3) {
            Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e3, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                }
            }
        } catch (IOException e5) {
            Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e5, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e6) {
                    Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e6, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e7) {
                    Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e7, "", new Object[0]);
                }
            }
            AppMethodBeat.o(152085);
            throw th;
        }
        AppMethodBeat.o(152085);
        return false;
    }

    public static byte[] bei(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Throwable th;
        IOException e2;
        AppMethodBeat.i(152086);
        try {
            inputStream = s.openRead(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException e3) {
                e = e3;
                byteArrayOutputStream = null;
                try {
                    Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    c(inputStream);
                    c(byteArrayOutputStream);
                    AppMethodBeat.o(152086);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    c(inputStream);
                    c(byteArrayOutputStream);
                    AppMethodBeat.o(152086);
                    throw th;
                }
            } catch (IOException e4) {
                e2 = e4;
                byteArrayOutputStream = null;
                Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                c(inputStream);
                c(byteArrayOutputStream);
                AppMethodBeat.o(152086);
                return null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                c(inputStream);
                c(byteArrayOutputStream);
                AppMethodBeat.o(152086);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        c(inputStream);
                        c(byteArrayOutputStream);
                        AppMethodBeat.o(152086);
                        return byteArray;
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                c(inputStream);
                c(byteArrayOutputStream);
                AppMethodBeat.o(152086);
                return null;
            } catch (IOException e6) {
                e2 = e6;
                Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                c(inputStream);
                c(byteArrayOutputStream);
                AppMethodBeat.o(152086);
                return null;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            byteArrayOutputStream = null;
            inputStream = null;
            Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            c(inputStream);
            c(byteArrayOutputStream);
            AppMethodBeat.o(152086);
            return null;
        } catch (IOException e8) {
            e2 = e8;
            byteArrayOutputStream = null;
            inputStream = null;
            Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
            c(inputStream);
            c(byteArrayOutputStream);
            AppMethodBeat.o(152086);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
            c(inputStream);
            c(byteArrayOutputStream);
            AppMethodBeat.o(152086);
            throw th;
        }
    }

    public static void c(Closeable closeable) {
        AppMethodBeat.i(152087);
        if (closeable == null) {
            AppMethodBeat.o(152087);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(152087);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
            Log.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", closeable.getClass().getSimpleName(), e2.getMessage()));
            AppMethodBeat.o(152087);
        }
    }

    public static boolean bej(String str) {
        AppMethodBeat.i(152088);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152088);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists() || oVar.delete()) {
            AppMethodBeat.o(152088);
            return true;
        }
        AppMethodBeat.o(152088);
        return false;
    }

    public static boolean YS(String str) {
        AppMethodBeat.i(152089);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152089);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isFile()) {
            AppMethodBeat.o(152089);
            return false;
        }
        AppMethodBeat.o(152089);
        return true;
    }
}
