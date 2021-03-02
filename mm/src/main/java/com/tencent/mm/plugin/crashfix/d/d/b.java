package com.tencent.mm.plugin.crashfix.d.d;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.crashfix.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b extends a {
    protected b(Object obj) {
        super(obj);
        qCR = "mHandler";
    }

    @Override // com.tencent.mm.plugin.crashfix.d.d.a, java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(145632);
        if (this.qCQ != null) {
            if (method.getName().equals("enqueueToast") && objArr[1].getClass().getName().equals("android.widget.Toast$TN")) {
                try {
                    Field declaredField = objArr[1].getClass().getDeclaredField(qCR);
                    declaredField.setAccessible(true);
                    a.c(declaredField);
                    final Handler handler = (Handler) declaredField.get(objArr[1]);
                    declaredField.set(objArr[1], new Handler() {
                        /* class com.tencent.mm.plugin.crashfix.d.d.b.AnonymousClass1 */

                        public final void handleMessage(Message message) {
                            AppMethodBeat.i(145631);
                            try {
                                Log.i("MicroMsg.INotificationManagerInvocationHandler", "run on my handler");
                                handler.handleMessage(message);
                                AppMethodBeat.o(145631);
                            } catch (Exception e2) {
                                Log.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
                                AppMethodBeat.o(145631);
                            }
                        }
                    });
                    Log.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
                } catch (Exception e2) {
                    Log.e("MicroMsg.INotificationManagerInvocationHandler", e2.getMessage());
                }
            }
            Object invoke = method.invoke(this.qCQ, objArr);
            AppMethodBeat.o(145632);
            return invoke;
        }
        AppMethodBeat.o(145632);
        return null;
    }
}
