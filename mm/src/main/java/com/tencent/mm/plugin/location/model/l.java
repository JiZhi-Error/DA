package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.pluginsdk.location.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class l implements c {

    /* renamed from: h  reason: collision with root package name */
    int f1505h = 300;
    int w = 300;
    HashMap<Long, WeakReference<ImageView>> yFV = new HashMap<>();
    HashMap<Long, ca.b> yFW = new HashMap<>();
    HashMap<Long, WeakReference<ProgressBar>> yFX = new HashMap<>();
    HashMap<Long, WeakReference<ImageView>> yFY = new HashMap<>();
    HashMap<ca.b, ca> yFZ = new HashMap<>();
    HashMap<Long, Integer> yGa = new HashMap<>();
    HashSet<Long> yGb = new HashSet<>();

    public l() {
        AppMethodBeat.i(55708);
        start();
        AppMethodBeat.o(55708);
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        AppMethodBeat.i(55709);
        n.ecP().a(this);
        AppMethodBeat.o(55709);
    }

    @Override // com.tencent.mm.pluginsdk.location.c
    public final void a(String str, d dVar) {
        AppMethodBeat.i(55710);
        if (dVar == null) {
            AppMethodBeat.o(55710);
        } else if (!this.yFW.containsKey(Long.valueOf(dVar.JTu))) {
            AppMethodBeat.o(55710);
        } else {
            ca remove = this.yFZ.remove(this.yFW.get(Long.valueOf(dVar.JTu)));
            if (remove == null) {
                AppMethodBeat.o(55710);
                return;
            }
            WeakReference<ImageView> weakReference = this.yFV.get(Long.valueOf(remove.field_msgId));
            if (weakReference == null || weakReference.get() == null) {
                AppMethodBeat.o(55710);
            } else if (!this.yGa.containsKey(Long.valueOf(remove.field_msgId))) {
                AppMethodBeat.o(55710);
            } else {
                weakReference.get().setImageBitmap(q.bcR().a(remove.field_msgId, str, this.yGa.remove(Long.valueOf(remove.field_msgId)).intValue(), this.w, this.f1505h, remove.field_isSend == 0));
                WeakReference<ProgressBar> remove2 = this.yFX.remove(Long.valueOf(remove.field_msgId));
                if (!(remove2 == null || remove2.get() == null)) {
                    remove2.get().setVisibility(8);
                }
                WeakReference<ImageView> remove3 = this.yFY.remove(Long.valueOf(remove.field_msgId));
                if (!(remove3 == null || remove3.get() == null)) {
                    remove3.get().setVisibility(0);
                }
                AppMethodBeat.o(55710);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.location.c
    public final void a(d dVar) {
        AppMethodBeat.i(55711);
        if (dVar == null) {
            AppMethodBeat.o(55711);
        } else if (!this.yFW.containsKey(Long.valueOf(dVar.JTu))) {
            AppMethodBeat.o(55711);
        } else {
            ca remove = this.yFZ.remove(this.yFW.get(Long.valueOf(dVar.JTu)));
            if (remove == null) {
                AppMethodBeat.o(55711);
                return;
            }
            this.yFV.get(Long.valueOf(remove.field_msgId));
            if (remove != null && (remove.fQX < 0 || remove.fQX > 5)) {
                remove.nK(0);
                remove.nK(remove.fQX + 1);
                if (g.aAc()) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(remove.field_msgId, remove);
                    Log.i("MicroMsg.StaticMapMsgLogic", "on error count %d", Integer.valueOf(remove.fQX));
                }
            }
            AppMethodBeat.o(55711);
        }
    }
}
