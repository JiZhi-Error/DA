package com.tencent.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.i.a.h;
import com.tencent.i.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n {
    private static l SqK;

    public static void a(Context context, m mVar) {
        AppMethodBeat.i(214679);
        if (SqK == null) {
            synchronized (n.class) {
                try {
                    if (SqK == null) {
                        l lVar = new l(context, mVar);
                        lVar.hqo();
                        SqK = lVar;
                    }
                } finally {
                    AppMethodBeat.o(214679);
                }
            }
            return;
        }
        AppMethodBeat.o(214679);
    }

    public static boolean a(i.a aVar) {
        AppMethodBeat.i(214681);
        if (hqc() == null) {
            AppMethodBeat.o(214681);
            return false;
        }
        boolean a2 = hqc().a(aVar);
        AppMethodBeat.o(214681);
        return a2;
    }

    private static synchronized l hqc() {
        l lVar;
        synchronized (n.class) {
            lVar = SqK;
        }
        return lVar;
    }

    public static boolean a(h.a aVar, e eVar) {
        AppMethodBeat.i(214680);
        if (TextUtils.isEmpty(aVar.zfX) || hqc() == null) {
            AppMethodBeat.o(214680);
            return false;
        }
        boolean a2 = hqc().a(aVar, eVar);
        AppMethodBeat.o(214680);
        return a2;
    }
}
