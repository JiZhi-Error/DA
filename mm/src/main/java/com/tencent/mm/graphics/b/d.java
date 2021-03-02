package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public enum d {
    INSTANCE;
    
    public WeakReference<Context> hkm = null;
    public HashMap<Integer, a> hkn = new HashMap<>();
    public b hko = null;
    public final Object hkp = new Object();
    public boolean isRunning = false;

    private d(String str) {
        AppMethodBeat.i(136208);
        AppMethodBeat.o(136208);
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(136207);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(136207);
        return dVar;
    }

    static {
        AppMethodBeat.i(136211);
        AppMethodBeat.o(136211);
    }

    public final b axG() {
        b bVar;
        a aVar;
        AppMethodBeat.i(136209);
        synchronized (this.hkp) {
            try {
                if (this.hkn == null || (aVar = this.hkn.get(2)) == null || !(aVar instanceof b)) {
                    bVar = null;
                    AppMethodBeat.o(136209);
                } else {
                    aVar.axD();
                    bVar = (b) aVar;
                }
            } finally {
                AppMethodBeat.o(136209);
            }
        }
        return bVar;
    }

    public final void axH() {
        AppMethodBeat.i(136210);
        synchronized (this.hkp) {
            try {
                if (this.isRunning) {
                    if (this.hko != null) {
                        this.hko.cancel();
                    }
                    this.isRunning = false;
                    if (this.hkn != null) {
                        this.hkn.clear();
                    }
                    AppMethodBeat.o(136210);
                }
            } finally {
                AppMethodBeat.o(136210);
            }
        }
    }
}
