package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;

public final class t {
    public d.c zwJ = d.c.Stop;
    SparseArray<WeakReference<d.b>> zwK = new SparseArray<>();
    private MMHandler zwL = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.mmsight.model.a.t.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(89602);
            if (257 == message.what) {
                d.c cVar = (d.c) message.obj;
                for (int i2 = 0; i2 < t.this.zwK.size(); i2++) {
                    if (t.this.zwK.valueAt(i2).get() != null) {
                        int[] iArr = AnonymousClass2.zwN;
                        cVar.ordinal();
                    }
                }
                AppMethodBeat.o(89602);
            } else if (258 == message.what) {
                d.b bVar = (d.b) message.obj;
                if (bVar == null) {
                    AppMethodBeat.o(89602);
                    return;
                }
                t.this.zwK.put(bVar.hashCode(), new WeakReference<>(bVar));
                AppMethodBeat.o(89602);
            } else {
                if (259 == message.what) {
                    d.b bVar2 = (d.b) message.obj;
                    if (bVar2 == null) {
                        AppMethodBeat.o(89602);
                        return;
                    }
                    t.this.zwK.remove(bVar2.hashCode());
                }
                AppMethodBeat.o(89602);
            }
        }
    };

    public t() {
        AppMethodBeat.i(89604);
        AppMethodBeat.o(89604);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.t$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] zwN = new int[d.c.values().length];

        static {
            AppMethodBeat.i(89603);
            try {
                zwN[d.c.Start.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zwN[d.c.Stop.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zwN[d.c.Sent.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zwN[d.c.Error.ordinal()] = 4;
                AppMethodBeat.o(89603);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(89603);
            }
        }
    }

    public final void a(d.c cVar) {
        AppMethodBeat.i(89605);
        Log.i("MicroMsg.SightMediaStatusHandler", "status change to %s", cVar.toString());
        this.zwJ = cVar;
        this.zwL.sendMessage(this.zwL.obtainMessage(CdnLogic.kAppTypeFestivalImage, cVar));
        AppMethodBeat.o(89605);
    }
}
