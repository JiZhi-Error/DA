package com.tencent.mm.plugin.crashfix.b.a;

import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b implements InvocationHandler {
    protected Object qCx;

    public b(WindowManager windowManager) {
        this.qCx = windowManager;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean z = false;
        AppMethodBeat.i(145623);
        if (method.getName().equals("removeViewImmediate")) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 0) {
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (stackTrace[i2].getMethodName().equals("handleDestroyActivity")) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (z) {
            try {
                Log.i("MicroMsg.WindowManagerInvocationHandler", "removeViewImmediate");
                Object invoke = method.invoke(this.qCx, objArr);
                AppMethodBeat.o(145623);
                return invoke;
            } catch (Exception e2) {
                Log.e("MicroMsg.WindowManagerInvocationHandler", "catch it");
                AppMethodBeat.o(145623);
                return null;
            }
        } else {
            Object invoke2 = method.invoke(this.qCx, objArr);
            AppMethodBeat.o(145623);
            return invoke2;
        }
    }
}
