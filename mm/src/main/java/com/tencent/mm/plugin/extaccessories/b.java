package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public final class b implements bd {
    String hqG;
    private a sOI;

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
        AppMethodBeat.i(24544);
        bg.aVF();
        this.hqG = c.getAccPath();
        o oVar = new o(this.hqG);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        o oVar2 = new o(this.hqG + "image/spen/");
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        AppMethodBeat.o(24544);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(24545);
        Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.sOI == null) {
            this.sOI = new a();
        }
        EventCenter.instance.addListener(this.sOI);
        bg.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.extaccessories.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(24540);
                if (!bg.aAc()) {
                    AppMethodBeat.o(24540);
                } else if (Util.isNullOrNil(b.this.hqG)) {
                    AppMethodBeat.o(24540);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    Util.deleteOutOfDateFile(b.this.hqG + "image/spen/", "spen_", 259200000);
                    Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(24540);
                }
            }
        }, 5000);
        AppMethodBeat.o(24545);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(24546);
        Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.sOI != null) {
            EventCenter.instance.removeListener(this.sOI);
        }
        AppMethodBeat.o(24546);
    }

    public static class a extends IListener<rk> {
        public a() {
            AppMethodBeat.i(161363);
            this.__eventId = rk.class.getName().hashCode();
            AppMethodBeat.o(161363);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rk rkVar) {
            AppMethodBeat.i(24543);
            boolean a2 = a(rkVar);
            AppMethodBeat.o(24543);
            return a2;
        }

        private boolean a(rk rkVar) {
            AppMethodBeat.i(24542);
            if (!(rkVar instanceof rk)) {
                Log.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
                AppMethodBeat.o(24542);
                return false;
            }
            Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
            if (!(rkVar.dXZ == null || rkVar.dXZ.dYb == null || rkVar.dXZ.dYa == null)) {
                try {
                    new SlookWritingBuddy(rkVar.dXZ.dYb).setImageWritingListener(new SubCoreExtAccessories$RegistSpenBuddyEventListener$1(this, rkVar));
                } catch (Exception e2) {
                    Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(24542);
            return true;
        }
    }
}
