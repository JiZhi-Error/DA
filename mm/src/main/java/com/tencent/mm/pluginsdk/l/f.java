package com.tencent.mm.pluginsdk.l;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;

public final class f {
    public static String formatSecToMin(int i2) {
        AppMethodBeat.i(31182);
        String format = String.format("%d:%02d", Long.valueOf(((long) i2) / 60), Long.valueOf(((long) i2) % 60));
        AppMethodBeat.o(31182);
        return format;
    }

    private static boolean isNullOrNil(String str) {
        AppMethodBeat.i(31183);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(31183);
            return true;
        }
        AppMethodBeat.o(31183);
        return false;
    }

    public static void a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, String str, boolean z) {
        AppMethodBeat.i(31184);
        if (isNullOrNil(str)) {
            IOException iOException = new IOException("saveBitmapToImage pathName null or nil");
            AppMethodBeat.o(31184);
            throw iOException;
        }
        OutputStream outputStream = null;
        try {
            outputStream = s.dw(str, false);
            bitmap.compress(compressFormat, 60, outputStream);
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.VideoUtil", e2, "", new Object[0]);
                }
            }
            if (z) {
                Log.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.o(31184);
                return;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.VideoUtil", e3, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.VideoUtil", e4, "", new Object[0]);
                }
            }
            if (z) {
                Log.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.o(31184);
                return;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.VideoUtil", e5, "", new Object[0]);
                }
            }
            if (z) {
                Log.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.o(31184);
            throw th;
        }
        AppMethodBeat.o(31184);
    }
}
