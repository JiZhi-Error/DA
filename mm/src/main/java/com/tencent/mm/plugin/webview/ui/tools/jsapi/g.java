package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class g {
    private static final SparseArray<f> Jvo = new SparseArray<>();
    private static volatile f Jvp = null;

    private g() {
    }

    static {
        AppMethodBeat.i(82017);
        AppMethodBeat.o(82017);
    }

    @Deprecated
    public static f ghF() {
        AppMethodBeat.i(82014);
        if (Jvp == null) {
            Jvp = new f(0);
        }
        f fVar = Jvp;
        AppMethodBeat.o(82014);
        return fVar;
    }

    public static f ahd(int i2) {
        f fVar;
        AppMethodBeat.i(82015);
        synchronized (g.class) {
            try {
                if (Jvo.get(i2) == null) {
                    Jvo.put(i2, new f(i2));
                }
                fVar = Jvo.get(i2);
                Jvp = fVar;
            } finally {
                AppMethodBeat.o(82015);
            }
        }
        return fVar;
    }

    public static void detach() {
        AppMethodBeat.i(82016);
        Log.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (g.class) {
            for (int i2 = 0; i2 < Jvo.size(); i2++) {
                try {
                    Jvo.valueAt(i2);
                    Jvo.keyAt(i2);
                } finally {
                    AppMethodBeat.o(82016);
                }
            }
            Jvo.clear();
        }
        if (Jvp != null) {
            Jvp = null;
        }
    }
}
