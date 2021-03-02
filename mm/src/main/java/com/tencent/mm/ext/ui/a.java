package com.tencent.mm.ext.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: com.tencent.mm.ext.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC0343a {
        void ei(boolean z);
    }

    static class b implements InvocationHandler {
        WeakReference<AbstractC0343a> hfj;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            AppMethodBeat.i(197819);
            if (this.hfj == null) {
                com.tencent.liteapp.b.b.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!", new Object[0]);
                AppMethodBeat.o(197819);
            } else {
                AbstractC0343a aVar = this.hfj.get();
                if (aVar == null) {
                    com.tencent.liteapp.b.b.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!", new Object[0]);
                    AppMethodBeat.o(197819);
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.ei(z);
                    AppMethodBeat.o(197819);
                }
            }
            return null;
        }
    }
}
