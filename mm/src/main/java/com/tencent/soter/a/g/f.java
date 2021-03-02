package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;
import com.tencent.soter.core.c.d;

public class f {
    private static volatile f RRg = null;
    static volatile SparseArray<d> RRh = null;
    final Object RRi = new Object();

    private f() {
        AppMethodBeat.i(35);
        RRh = new SparseArray<>(5);
        AppMethodBeat.o(35);
    }

    public static f hlO() {
        f fVar;
        AppMethodBeat.i(36);
        if (RRg == null) {
            synchronized (f.class) {
                try {
                    if (RRg == null) {
                        RRg = new f();
                    }
                    fVar = RRg;
                } finally {
                    AppMethodBeat.o(36);
                }
            }
            return fVar;
        }
        f fVar2 = RRg;
        AppMethodBeat.o(36);
        return fVar2;
    }

    public final boolean a(final d dVar, e eVar) {
        AppMethodBeat.i(37);
        if (!dVar.hlM()) {
            int hashCode = dVar.hashCode();
            synchronized (this.RRi) {
                for (int i2 = 0; i2 < RRh.size(); i2++) {
                    try {
                        int keyAt = RRh.keyAt(i2);
                        if (RRh.get(keyAt) != null && RRh.get(keyAt).getClass().getName().equals(dVar.getClass().getName())) {
                            d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                            eVar.errCode = TXLiteAVCode.EVT_CAMERA_REMOVED;
                            eVar.errMsg = "add SOTER task to queue failed. check the logcat for further information";
                            dVar.c(eVar);
                            return false;
                        }
                    } finally {
                        AppMethodBeat.o(37);
                    }
                }
                RRh.put(hashCode, dVar);
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.g.f.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(32);
                        dVar.execute();
                        AppMethodBeat.o(32);
                    }
                });
                AppMethodBeat.o(37);
                return true;
            }
        }
        d.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
        AppMethodBeat.o(37);
        return false;
    }

    public final void hlP() {
        AppMethodBeat.i(38);
        synchronized (this.RRi) {
            try {
                d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
                if (RRh.size() != 0) {
                    for (int i2 = 0; i2 < RRh.size(); i2++) {
                        final int keyAt = RRh.keyAt(i2);
                        g.hlR().aj(new Runnable() {
                            /* class com.tencent.soter.a.g.f.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(33);
                                synchronized (f.this.RRi) {
                                    try {
                                        d dVar = (d) f.RRh.get(keyAt);
                                        if (dVar != null) {
                                            dVar.hlN();
                                        }
                                    } finally {
                                        AppMethodBeat.o(33);
                                    }
                                }
                            }
                        });
                    }
                }
                RRh.clear();
            } finally {
                AppMethodBeat.o(38);
            }
        }
    }

    public final void hlQ() {
        AppMethodBeat.i(39);
        synchronized (this.RRi) {
            try {
                d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
                if (RRh.size() != 0) {
                    for (int i2 = 0; i2 < RRh.size(); i2++) {
                        final int keyAt = RRh.keyAt(i2);
                        g.hlR().aj(new Runnable() {
                            /* class com.tencent.soter.a.g.f.AnonymousClass3 */

                            public final void run() {
                                d dVar;
                                AppMethodBeat.i(34);
                                synchronized (f.this.RRi) {
                                    try {
                                        dVar = (d) f.RRh.get(keyAt);
                                    } finally {
                                        AppMethodBeat.o(34);
                                    }
                                }
                                if (dVar != null && (dVar instanceof a) && !((a) dVar).isCancelled()) {
                                    ((a) dVar).hlL();
                                }
                            }
                        });
                    }
                }
            } finally {
                AppMethodBeat.o(39);
            }
        }
    }
}
