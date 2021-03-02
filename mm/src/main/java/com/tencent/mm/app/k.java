package com.tencent.mm.app;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class k {
    static boolean e(Application application) {
        AppMethodBeat.i(212149);
        try {
            Method declaredMethod = Class.forName("com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine").getDeclaredMethod("triggerOnDemand", Application.class);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(null, application)).booleanValue();
            AppMethodBeat.o(212149);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(212149);
            return false;
        }
    }
}
