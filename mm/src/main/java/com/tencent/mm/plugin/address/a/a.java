package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements bd {
    private l ksJ = null;
    private com.tencent.mm.plugin.address.b.a.a ksK = null;
    private j ksL = new j();
    private k ksM = new k();

    public a() {
        AppMethodBeat.i(20756);
        AppMethodBeat.o(20756);
    }

    public static a bqb() {
        AppMethodBeat.i(20757);
        bg.aVz();
        a aVar = (a) cg.KG("plugin.address");
        if (aVar == null) {
            Log.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
            aVar = new a();
            bg.aVz().a("plugin.address", aVar);
        }
        AppMethodBeat.o(20757);
        return aVar;
    }

    public static com.tencent.mm.plugin.address.b.a.a bqc() {
        AppMethodBeat.i(20758);
        g.aAf().azk();
        if (bqb().ksK == null) {
            bqb().ksK = new com.tencent.mm.plugin.address.b.a.a();
        }
        com.tencent.mm.plugin.address.b.a.a aVar = bqb().ksK;
        AppMethodBeat.o(20758);
        return aVar;
    }

    public static l bqd() {
        AppMethodBeat.i(20759);
        g.aAf().azk();
        if (bqb().ksJ == null) {
            bqb().ksJ = new l();
        }
        l lVar = bqb().ksJ;
        AppMethodBeat.o(20759);
        return lVar;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(20760);
        EventCenter.instance.addListener(this.ksL);
        EventCenter.instance.addListener(this.ksM);
        l bqd = bqd();
        bg.aVF();
        bqd.path = c.getAccPath() + "addrmgr";
        AppMethodBeat.o(20760);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(20761);
        EventCenter.instance.removeListener(this.ksL);
        EventCenter.instance.removeListener(this.ksM);
        AppMethodBeat.o(20761);
    }
}
