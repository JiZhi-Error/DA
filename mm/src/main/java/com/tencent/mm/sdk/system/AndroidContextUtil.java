package com.tencent.mm.sdk.system;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class AndroidContextUtil {
    private static final String TAG = "Luggage.AndroidContextUtil";

    public static Activity castActivityOrNull(Context context) {
        Context baseContext;
        AppMethodBeat.i(153458);
        Context context2 = context;
        while (context2 != null) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                AppMethodBeat.o(153458);
                return activity;
            } else if (!(context2 instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context2).getBaseContext()) == context2) {
                AppMethodBeat.o(153458);
                return null;
            } else {
                context2 = baseContext;
            }
        }
        AppMethodBeat.o(153458);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isContextReferencedByOtherContext(android.content.Context r5, android.content.Context r6) {
        /*
            r1 = 1
            r2 = 0
            r4 = 214358(0x34556, float:3.0038E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 != r6) goto L_0x000f
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r1
        L_0x000e:
            return r0
        L_0x000f:
            boolean r0 = r6 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L_0x0031
            android.content.ContextWrapper r6 = (android.content.ContextWrapper) r6
            android.content.Context r0 = r6.getBaseContext()
        L_0x0019:
            if (r5 != r0) goto L_0x0020
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r1
            goto L_0x000e
        L_0x0020:
            boolean r3 = r0 instanceof android.content.ContextWrapper
            if (r3 == 0) goto L_0x002c
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            if (r0 != 0) goto L_0x0019
        L_0x002c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r2
            goto L_0x000e
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r2
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.system.AndroidContextUtil.isContextReferencedByOtherContext(android.content.Context, android.content.Context):boolean");
    }

    public static void fixInputMethodManagerLeak(Context context) {
        AppMethodBeat.i(153459);
        if (context == null) {
            AppMethodBeat.o(153459);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(153459);
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    View view = (View) obj;
                    if (view.getContext() == context || isContextReferencedByOtherContext(context, view.getContext())) {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (Throwable th) {
                Log.w(TAG, "fixInputMethodManagerLeak %s", th.getMessage());
            }
        }
        AppMethodBeat.o(153459);
    }
}
