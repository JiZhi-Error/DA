package com.tencent.mm.plugin.crashfix.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public class NativeAllocationRegistryApplyFreeFunctionHook {
    private static long qCy = 0;
    private static long qCz = 0;

    public static native long getTestMethodAddr();

    public static native void hook(Method method, Method method2);

    @Keep
    public static boolean isNeedRelease(long j2, long j3) {
        AppMethodBeat.i(145627);
        if (j2 == 0 && j3 == 0) {
            AppMethodBeat.o(145627);
            return true;
        } else if (qCy == j2 && qCz == j3) {
            Log.e("NativeAllocationRegistryApplyFreeFunctionHook", "protect succ");
            h.INSTANCE.idkeyStat(1113, 7, 1, false);
            AppMethodBeat.o(145627);
            return false;
        } else {
            qCy = j2;
            qCz = j3;
            AppMethodBeat.o(145627);
            return true;
        }
    }
}
