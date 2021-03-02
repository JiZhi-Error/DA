package com.tencent.mm.splash;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.lang.reflect.Field;

/* access modifiers changed from: package-private */
public final class j implements Handler.Callback {
    public static int LAUNCH_ACTIVITY = 100;
    public static int NMd = 113;
    public static int NMe = 114;
    public static int NMf = 115;
    public static int NMg = 116;
    public static int NMh = 121;
    public static int NMi = 122;
    public static int NMj = 126;
    public static int NMk = 145;
    private static boolean NMl = false;
    private static Runnable NMm;
    private static boolean NMo = false;
    Handler.Callback AFR;
    private boolean NMn = false;
    private Context mContext;

    public j(Context context, Handler.Callback callback) {
        this.mContext = context;
        this.AFR = callback;
    }

    public static void aH(Runnable runnable) {
        NMl = true;
        NMm = runnable;
    }

    public static boolean gyw() {
        return NMo;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(40678);
        if (this.NMn) {
            h.c("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
            AppMethodBeat.o(40678);
            return false;
        }
        NMo = false;
        h.c("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", Integer.valueOf(message.what), Boolean.valueOf(h.gyj()), Boolean.valueOf(h.gyk()));
        if (!NMl || message.what != 987654321) {
            if (h.gyj() && !h.gyk()) {
                h.c("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", Integer.valueOf(message.what), Boolean.valueOf(h.gyj()));
                if (message.what == NMd || message.what == NMe || message.what == NMf || message.what == NMg || message.what == NMh || message.what == NMi || message.what == NMk) {
                    Message obtain = Message.obtain();
                    obtain.copyFrom(message);
                    h.NLC.add(obtain);
                    if (h.NLG != null) {
                        h.NLG.WU();
                    }
                    AppMethodBeat.o(40678);
                    return true;
                }
            }
            if (message.what == NMj || (Build.VERSION.SDK_INT == 28 && message.what == 160)) {
                if (h.NLH.size() > 0) {
                    NMo = true;
                }
                h.c("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", Integer.valueOf(h.NLH.size()));
                Object obj = message.obj;
                if (d.oF(25)) {
                    try {
                        if (l.NMw == null) {
                            Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
                            declaredField.setAccessible(true);
                            l.NMw = declaredField;
                        }
                        h.c("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", Boolean.valueOf(((Boolean) l.NMw.get(obj)).booleanValue()));
                        l.NMw.set(obj, Boolean.FALSE);
                    } catch (Exception e2) {
                        h.a(e2, "");
                    }
                }
            }
            if (this.AFR != null) {
                this.NMn = true;
                boolean handleMessage = this.AFR.handleMessage(message);
                this.NMn = false;
                AppMethodBeat.o(40678);
                return handleMessage;
            }
            AppMethodBeat.o(40678);
            return false;
        }
        if (NMm != null) {
            h.c("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
            NMm.run();
        }
        AppMethodBeat.o(40678);
        return true;
    }
}
