package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
public final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.app.a$a  reason: collision with other inner class name */
    static class C0539a {
        public static Object dmH;
        public static Handler kHW;
    }

    static boolean bug() {
        Object obj;
        AppMethodBeat.i(226281);
        if (C0539a.dmH == null || C0539a.kHW == null) {
            try {
                Application application = (Application) MMApplicationContext.getContext().getApplicationContext();
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(null, new Object[0]);
                if (invoke != null) {
                    obj = invoke;
                } else {
                    Field field = application.getClass().getField("mLoadedApk");
                    field.setAccessible(true);
                    Object obj2 = field.get(application);
                    Field declaredField = obj2.getClass().getDeclaredField("mActivityThread");
                    declaredField.setAccessible(true);
                    obj = declaredField.get(obj2);
                }
                C0539a.dmH = obj;
                Field declaredField2 = obj.getClass().getDeclaredField("mH");
                declaredField2.setAccessible(true);
                C0539a.kHW = (Handler) declaredField2.get(obj);
            } catch (Throwable th) {
                Log.e("MicroMsg.AppBrandProcessSuicideLogic.ActivityThreadHackDetector", "hack ActivityThread failed %s", th);
            }
        }
        Handler handler = C0539a.kHW;
        if (handler == null) {
            AppMethodBeat.o(226281);
            return false;
        } else if (handler.hasMessages(100) || handler.hasMessages(126) || ((Build.VERSION.SDK_INT == 28 && handler.hasMessages(160)) || handler.hasMessages(JsApiGetBackgroundAudioState.CTRL_INDEX))) {
            AppMethodBeat.o(226281);
            return true;
        } else {
            AppMethodBeat.o(226281);
            return false;
        }
    }
}
