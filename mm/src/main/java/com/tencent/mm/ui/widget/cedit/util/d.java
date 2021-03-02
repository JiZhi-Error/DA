package com.tencent.mm.ui.widget.cedit.util;

import android.os.Build;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.a.a;
import java.lang.reflect.Method;

public final class d {
    private static Object QLO;
    private static Method QLP;
    private static float density = -1.0f;

    public static boolean haY() {
        AppMethodBeat.i(206130);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                QLP = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                Object invoke = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
                QLO = invoke;
                if (invoke == null || QLP == null) {
                    AppMethodBeat.o(206130);
                    return false;
                }
                try {
                    QLP.invoke(QLO, new String[]{"L"});
                    AppMethodBeat.o(206130);
                    return true;
                } catch (Throwable th) {
                    AppMethodBeat.o(206130);
                    return false;
                }
            } catch (Throwable th2) {
                System.out.println("soontest reflect bootstrap failed:" + th2.getMessage());
                AppMethodBeat.o(206130);
                return false;
            }
        } else {
            AppMethodBeat.o(206130);
            return false;
        }
    }

    public static void resetLockedMeta(Spannable spannable) {
        AppMethodBeat.i(206131);
        new a(MetaKeyKeyListener.class.getName(), "resetLockedMeta", (Class<?>[]) new Class[]{Spannable.class}).invoke(spannable);
        AppMethodBeat.o(206131);
    }

    public static void a(View view, Spannable spannable) {
        AppMethodBeat.i(206132);
        new a(MetaKeyKeyListener.class.getName(), "startSelecting", (Class<?>[]) new Class[]{Spannable.class}).invoke(view, spannable);
        AppMethodBeat.o(206132);
    }

    public static void b(View view, Spannable spannable) {
        AppMethodBeat.i(206133);
        new a(MetaKeyKeyListener.class.getName(), "stopSelecting", (Class<?>[]) new Class[]{Spannable.class}).invoke(view, spannable);
        AppMethodBeat.o(206133);
    }

    public static boolean haZ() {
        AppMethodBeat.i(206134);
        boolean gKc = a.C2075a.OLX.gKc();
        AppMethodBeat.o(206134);
        return gKc;
    }
}
