package com.tencent.g;

import android.content.Context;
import com.tencent.g.b.b;
import com.tencent.g.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    private static i Spc;
    private Context mAppContext;
    private boolean mStarted;

    private static i hpR() {
        AppMethodBeat.i(62809);
        if (Spc == null) {
            synchronized (i.class) {
                try {
                    if (Spc == null) {
                        Spc = new i();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(62809);
                    throw th;
                }
            }
        }
        i iVar = Spc;
        AppMethodBeat.o(62809);
        return iVar;
    }

    public static void lq(Context context) {
        AppMethodBeat.i(62810);
        i hpR = hpR();
        if (!hpR.mStarted) {
            hpR.mAppContext = context;
            try {
                b a2 = f.a(new d("EventCenter", com.tencent.g.a.b.class.getName()));
                if (a2 != null) {
                    a2.start();
                }
                AppMethodBeat.o(62810);
                return;
            } catch (Throwable th) {
                com.tencent.pb.common.c.b.w("service", th);
            }
        }
        AppMethodBeat.o(62810);
    }
}
