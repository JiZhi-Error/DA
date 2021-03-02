package com.tencent.mm.plugin.crashfix.b.a;

import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Proxy;

public final class a {
    public static WindowManager a(WindowManager windowManager) {
        AppMethodBeat.i(145622);
        WindowManager windowManager2 = (WindowManager) Proxy.newProxyInstance(windowManager.getClass().getClassLoader(), windowManager.getClass().getInterfaces(), new b(windowManager));
        Log.i("MicroMsg.SafeWindowManager", "proxy");
        AppMethodBeat.o(145622);
        return windowManager2;
    }
}
