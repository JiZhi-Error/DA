package com.tencent.b.a.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class p {
    private static volatile p dga = null;
    private boolean canWrite = false;
    private Context context = null;

    public final boolean N(String str, String str2) {
        AppMethodBeat.i(87603);
        if (this.canWrite) {
            try {
                boolean putString = Settings.System.putString(this.context.getContentResolver(), str, str2);
                AppMethodBeat.o(87603);
                return putString;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(87603);
        return false;
    }

    private p(Context context2) {
        AppMethodBeat.i(87604);
        this.context = context2.getApplicationContext();
        this.canWrite = s.checkPermission(this.context, "android.permission.WRITE_SETTINGS");
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = Settings.System.class.getDeclaredMethod("canWrite", Context.class);
                declaredMethod.setAccessible(true);
                this.canWrite = ((Boolean) declaredMethod.invoke(null, this.context)).booleanValue();
                AppMethodBeat.o(87604);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(87604);
    }

    public static p br(Context context2) {
        AppMethodBeat.i(87605);
        if (dga == null) {
            synchronized (p.class) {
                try {
                    if (dga == null) {
                        dga = new p(context2);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(87605);
                    throw th;
                }
            }
        }
        p pVar = dga;
        AppMethodBeat.o(87605);
        return pVar;
    }
}
