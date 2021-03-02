package com.tencent.mm.plugin.crashfix.d.d;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.crashfix.c.a;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d implements b {
    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean Fh(int i2) {
        if (i2 < 26) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean cAO() {
        AppMethodBeat.i(145634);
        Object cAP = cAP();
        if (cAP != null) {
            Object dc = c.dc(cAP);
            if (dc == null) {
                Log.e("MicroMsg.ToastBadTokenFix", "INotificationManagerInvocationHandler.getProxy null");
                AppMethodBeat.o(145634);
                return false;
            }
            Log.i("MicroMsg.ToastBadTokenFix", "INotificationManagerInvocationHandler.getProxy succ");
            try {
                Field declaredField = Toast.class.getDeclaredField("sService");
                declaredField.setAccessible(true);
                a.c(declaredField);
                declaredField.set(null, dc);
                Log.i("MicroMsg.ToastBadTokenFix", "replace succ");
                AppMethodBeat.o(145634);
                return true;
            } catch (NoSuchFieldException e2) {
                Log.e("MicroMsg.ToastBadTokenFix", e2.getMessage());
            } catch (IllegalAccessException e3) {
                Log.e("MicroMsg.ToastBadTokenFix", e3.getMessage());
            }
        }
        AppMethodBeat.o(145634);
        return false;
    }

    private static Object cAP() {
        Object obj = null;
        AppMethodBeat.i(145635);
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
            Field declaredField = Toast.class.getDeclaredField("sService");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (NoSuchFieldException e2) {
            Log.e("MicroMsg.ToastBadTokenFix", e2.getMessage());
        } catch (IllegalAccessException e3) {
            Log.e("MicroMsg.ToastBadTokenFix", e3.getMessage());
        } catch (NoSuchMethodException e4) {
            Log.e("MicroMsg.ToastBadTokenFix", e4.getMessage());
        } catch (InvocationTargetException e5) {
            Log.e("MicroMsg.ToastBadTokenFix", e5.getMessage());
        }
        AppMethodBeat.o(145635);
        return obj;
    }
}
