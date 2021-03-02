package org.extra.tools;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import org.extra.a.c;

public class b {
    public static final String TAG = b.class.getSimpleName();
    private static Context appContext;

    static {
        AppMethodBeat.i(236825);
        AppMethodBeat.o(236825);
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(236821);
        try {
            appContext = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
        } catch (Exception e2) {
        }
        Context context = appContext;
        if (!load(str) && !di(context, str)) {
            dj(context, str);
        }
        AppMethodBeat.o(236821);
    }

    public static Context getAppContext() {
        return appContext;
    }

    private static boolean load(String str) {
        AppMethodBeat.i(236822);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(236822);
            return false;
        }
        boolean z = true;
        try {
            System.loadLibrary(str);
        } catch (Throwable th) {
            new StringBuilder("loadLibrary ").append(str).append(" fail! Error: ").append(th.getMessage());
            z = false;
        }
        AppMethodBeat.o(236822);
        return z;
    }

    private static boolean di(Context context, String str) {
        AppMethodBeat.i(236823);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(236823);
            return false;
        }
        boolean z = true;
        try {
            System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + ShareConstants.SO_PATH + str + ".so");
        } catch (Throwable th) {
            new StringBuilder("load  fail! Error: ").append(th.getMessage());
            z = false;
        }
        AppMethodBeat.o(236823);
        return z;
    }

    private static boolean dj(Context context, String str) {
        AppMethodBeat.i(236824);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(236824);
            return false;
        }
        try {
            c.loadLibrary(context, str);
            AppMethodBeat.o(236824);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(236824);
            return false;
        }
    }
}
