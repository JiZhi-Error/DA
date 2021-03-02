package com.tencent.luggage.e.a;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.InputStream;

public final class a {
    public static int m(InputStream inputStream) {
        int i2 = 0;
        AppMethodBeat.i(138794);
        try {
            i2 = b.m(inputStream);
            AppMethodBeat.o(138794);
        } catch (Exception e2) {
            Log.e("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", e2);
            AppMethodBeat.o(138794);
        }
        return i2;
    }

    public static int getExifOrientation(String str) {
        AppMethodBeat.i(138795);
        if (!s.YS(str)) {
            Log.e("Luggage.ImageInfoUtils", "getExifOrientation err ");
            AppMethodBeat.o(138795);
            return 0;
        }
        try {
            InputStream openRead = s.openRead(str);
            try {
                int m = b.m(openRead);
                if (openRead != null) {
                    openRead.close();
                }
                AppMethodBeat.o(138795);
                return m;
            } catch (Throwable th) {
                if (openRead != null) {
                    if (th != null) {
                        try {
                            openRead.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        openRead.close();
                    }
                }
                AppMethodBeat.o(138795);
                throw th;
            }
        } catch (Exception e2) {
            Log.e("Luggage.ImageInfoUtils", "getExifOrientation, path = %s, e = %s", str, e2);
            AppMethodBeat.o(138795);
            return 0;
        }
    }

    public static boolean d(BitmapFactory.Options options) {
        AppMethodBeat.i(138796);
        if (options == null) {
            AppMethodBeat.o(138796);
            return false;
        }
        String str = options.outMimeType;
        if (str == null) {
            AppMethodBeat.o(138796);
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.indexOf("jpg") >= 0) {
            AppMethodBeat.o(138796);
            return true;
        } else if (lowerCase.indexOf("jpeg") >= 0) {
            AppMethodBeat.o(138796);
            return true;
        } else {
            AppMethodBeat.o(138796);
            return false;
        }
    }

    public static String e(BitmapFactory.Options options) {
        AppMethodBeat.i(138797);
        String str = options.outMimeType;
        if (str == null) {
            AppMethodBeat.o(138797);
            return "unknown";
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.indexOf("jpg") >= 0) {
            AppMethodBeat.o(138797);
            return "jpeg";
        } else if (lowerCase.indexOf("jpeg") >= 0) {
            AppMethodBeat.o(138797);
            return "jpeg";
        } else if (lowerCase.indexOf("png") >= 0) {
            AppMethodBeat.o(138797);
            return "png";
        } else if (lowerCase.indexOf("gif") >= 0) {
            AppMethodBeat.o(138797);
            return "gif";
        } else {
            AppMethodBeat.o(138797);
            return "unknown";
        }
    }

    public static String hN(int i2) {
        switch (i2) {
            case 0:
                return "up";
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "right";
            case 7:
                return "right-mirrored";
            case 8:
                return "left";
            default:
                return "up";
        }
    }
}
