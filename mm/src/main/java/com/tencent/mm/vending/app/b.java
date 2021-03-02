package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b QYZ;
    Map<c, a> QZa = new ConcurrentHashMap();
    final SparseIntArray QZb = new SparseIntArray();
    final Handler QZc = new Handler(com.tencent.mm.vending.i.b.hdL().RaP.getLooper()) {
        /* class com.tencent.mm.vending.app.b.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            AppMethodBeat.i(74894);
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.onCreate();
                    synchronized (aVar.QYP) {
                        try {
                            aVar.QYS = true;
                            aVar.QYP.notify();
                        } finally {
                            AppMethodBeat.o(74894);
                        }
                    }
                    return;
                case 2:
                    AppMethodBeat.o(74894);
                    return;
                case 3:
                    AppMethodBeat.o(74894);
                    return;
                case 4:
                    aVar.onDestroy();
                    break;
            }
            AppMethodBeat.o(74894);
        }
    };

    public b() {
        AppMethodBeat.i(74891);
        AppMethodBeat.o(74891);
    }

    static {
        AppMethodBeat.i(74893);
        QYZ = null;
        QYZ = new b();
        AppMethodBeat.o(74893);
    }

    public static b hdp() {
        return QYZ;
    }

    public final void a(c cVar, a aVar) {
        AppMethodBeat.i(74892);
        if (!this.QZa.containsKey(cVar)) {
            this.QZa.put(cVar, aVar);
            a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", cVar, Integer.valueOf(cVar.hashCode()), aVar, Looper.myLooper());
            int i2 = this.QZb.get(cVar.hashCode(), 0);
            if (i2 > 0 && i2 < 4) {
                if (i2 > 0) {
                    this.QZc.sendMessage(this.QZc.obtainMessage(1, aVar));
                }
                if (i2 >= 2) {
                    this.QZc.sendMessage(this.QZc.obtainMessage(2, aVar));
                }
                if (i2 >= 3) {
                    this.QZc.sendMessage(this.QZc.obtainMessage(3, aVar));
                }
                if (i2 >= 4) {
                    this.QZc.sendMessage(this.QZc.obtainMessage(4, aVar));
                }
            }
            AppMethodBeat.o(74892);
            return;
        }
        a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
        AppMethodBeat.o(74892);
    }
}
