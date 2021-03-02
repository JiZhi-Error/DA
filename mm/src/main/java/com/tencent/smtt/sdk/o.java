package com.tencent.smtt.sdk;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class o extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    private static o f2100a;

    public o(String str) {
        super(str);
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            AppMethodBeat.i(55215);
            if (f2100a == null) {
                o oVar2 = new o("TbsHandlerThread");
                f2100a = oVar2;
                oVar2.start();
            }
            oVar = f2100a;
            AppMethodBeat.o(55215);
        }
        return oVar;
    }
}
