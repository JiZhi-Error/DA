package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.MissingFormatArgumentException;

public final class g {
    private static TPPlayerMgr.OnLogListener Sfk = null;
    private static int Sfl = 50;
    private static boolean cWq = true;

    public static void v(String str, String str2) {
        AppMethodBeat.i(189636);
        ac(60, str, str2);
        AppMethodBeat.o(189636);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(189637);
        ac(50, str, str2);
        AppMethodBeat.o(189637);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(189638);
        ac(40, str, str2);
        AppMethodBeat.o(189638);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(189639);
        ac(20, str, str2);
        AppMethodBeat.o(189639);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(189640);
        ac(10, str, str2);
        AppMethodBeat.o(189640);
    }

    public static void e(String str, Throwable th) {
        AppMethodBeat.i(189641);
        e(str, th, "");
        AppMethodBeat.o(189641);
    }

    public static void e(String str, Throwable th, String str2) {
        AppMethodBeat.i(189642);
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2 + "\n";
        }
        if (th != null) {
            str3 = str3 + Log.getStackTraceString(th);
        }
        ac(10, str, str3);
        AppMethodBeat.o(189642);
    }

    public static void setDebugEnable(boolean z) {
        cWq = z;
    }

    public static void setOnLogListener(TPPlayerMgr.OnLogListener onLogListener) {
        Sfk = onLogListener;
    }

    private static void ac(int i2, String str, String str2) {
        AppMethodBeat.i(189643);
        if (i2 == 20) {
            i2 = 10;
        }
        try {
            if (Sfk != null) {
                if (i2 <= Sfl) {
                    ad(i2, str, str2);
                    AppMethodBeat.o(189643);
                    return;
                }
            } else if (cWq && i2 <= Sfl) {
                Log.println(arG(i2), str, str2);
            }
            AppMethodBeat.o(189643);
        } catch (MissingFormatArgumentException e2) {
            AppMethodBeat.o(189643);
        } catch (Exception e3) {
            AppMethodBeat.o(189643);
        } catch (OutOfMemoryError e4) {
            AppMethodBeat.o(189643);
        }
    }

    private static int arG(int i2) {
        switch (i2) {
            case 10:
                return 6;
            case 20:
                return 5;
            case 40:
                return 4;
            case 50:
                return 3;
            case 60:
                return 2;
            default:
                return 0;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void ad(int i2, String str, String str2) {
        AppMethodBeat.i(189644);
        switch (i2) {
            case 10:
                Sfk.e(str, str2);
                break;
            case 20:
                Sfk.w(str, str2);
                AppMethodBeat.o(189644);
                return;
            case 40:
                Sfk.i(str, str2);
                AppMethodBeat.o(189644);
                return;
            case 50:
                Sfk.d(str, str2);
                AppMethodBeat.o(189644);
                return;
            case 60:
                Sfk.v(str, str2);
                AppMethodBeat.o(189644);
                return;
        }
        AppMethodBeat.o(189644);
    }
}
