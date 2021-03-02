package com.tencent.mm.plugin.crashfix.d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class a implements InvocationHandler {
    protected static String qCR = "mShow";
    protected Object qCQ;

    protected a(Object obj) {
        this.qCQ = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(145630);
        if (this.qCQ != null) {
            if (method.getName().equals("enqueueToast") && objArr[1].getClass().getName().equals("android.widget.Toast$TN")) {
                try {
                    Field declaredField = objArr[1].getClass().getDeclaredField(qCR);
                    declaredField.setAccessible(true);
                    com.tencent.mm.plugin.crashfix.c.a.c(declaredField);
                    final Runnable runnable = (Runnable) declaredField.get(objArr[1]);
                    declaredField.set(objArr[1], new Runnable() {
                        /* class com.tencent.mm.plugin.crashfix.d.d.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(145629);
                            try {
                                Log.i("MicroMsg.INotificationManagerInvocationHandler", "run on my runnable");
                                runnable.run();
                                AppMethodBeat.o(145629);
                            } catch (Exception e2) {
                                Log.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
                                AppMethodBeat.o(145629);
                            }
                        }
                    });
                    Log.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
                } catch (Exception e2) {
                    Log.e("MicroMsg.INotificationManagerInvocationHandler", e2.getMessage());
                }
            }
            Object invoke = method.invoke(this.qCQ, objArr);
            AppMethodBeat.o(145630);
            return invoke;
        }
        AppMethodBeat.o(145630);
        return null;
    }
}
