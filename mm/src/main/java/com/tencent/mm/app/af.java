package com.tencent.mm.app;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import org.xmlpull.v1.XmlPullParserException;

public final class af {
    public static boolean b(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(125026);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (className != null && (className.contains("de.robv.android.xposed.XposedBridge") || className.contains("com.zte.heartyservice.SCC.FrameworkBridge"))) {
                AppMethodBeat.o(125026);
                return true;
            }
        }
        AppMethodBeat.o(125026);
        return false;
    }

    public static void e(Throwable th) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(125027);
        ApplicationLike applicationLike = d.dks;
        if (applicationLike == null || applicationLike.getApplication() == null) {
            ShareTinkerLog.v("TinkerCrashProtect", "applicationlike is null", new Object[0]);
            AppMethodBeat.o(125027);
        } else if (!b.c(applicationLike)) {
            ShareTinkerLog.v("TinkerCrashProtect", "tinker is not loaded", new Object[0]);
            AppMethodBeat.o(125027);
        } else {
            boolean z3 = Build.MODEL.contains("ZUK") || Build.MODEL.contains("zuk");
            boolean z4 = false;
            while (th != null) {
                if (!z4) {
                    z = b(th.getStackTrace());
                } else {
                    z = z4;
                }
                if (z) {
                    if (!(th instanceof IllegalAccessError) || !th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        ShareTinkerLog.v("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
                        ShareTinkerInternals.killAllOtherProcess(applicationLike.getApplication());
                        b.e(applicationLike);
                        ShareTinkerInternals.setTinkerDisableWithSharedPreferences(applicationLike.getApplication());
                        AppMethodBeat.o(125027);
                        return;
                    }
                }
                if (z3) {
                    ShareTinkerLog.v("TinkerCrashProtect", "it is zuk model here, crash:" + th.getMessage(), new Object[0]);
                    if ((th instanceof XmlPullParserException) && th.getMessage().contains("tag requires a 'drawable' attribute or child tag defining a drawable")) {
                        ShareTinkerLog.v("TinkerCrashProtect", "have zuk parse error: just clean tinker", new Object[0]);
                        ShareTinkerInternals.killAllOtherProcess(applicationLike.getApplication());
                        b.e(applicationLike);
                        ShareTinkerInternals.setTinkerDisableWithSharedPreferences(applicationLike.getApplication());
                        AppMethodBeat.o(125027);
                        return;
                    }
                }
                th = th.getCause();
                z4 = z;
            }
            AppMethodBeat.o(125027);
        }
    }
}
