package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class g extends IListener<bp> {
    public g() {
        AppMethodBeat.i(160970);
        this.__eventId = bp.class.getName().hashCode();
        AppMethodBeat.o(160970);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(bp bpVar) {
        boolean z;
        AppMethodBeat.i(73436);
        bp bpVar2 = bpVar;
        if (bpVar2.dEN.dEO == 38) {
            int i2 = bpVar2.dEN.subType;
            int i3 = bpVar2.dEN.dEP;
            String str = bpVar2.dEN.filePath;
            if (!Util.isNullOrNil(str) || s.YS(str)) {
                String bzN = AppBrandGlobalSystemConfig.bzN();
                if (!s.YS(bzN)) {
                    z = true;
                } else {
                    String bhK = s.bhK(str);
                    String bhK2 = s.bhK(bzN);
                    if (Util.isNullOrNil(bhK) || bhK.equals(bhK2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    AppBrandGlobalSystemConfig.bzM();
                    FilesCopy.copyFile(str, bzN);
                    b.gnC().aP(38, i2, i3);
                }
            }
        }
        AppMethodBeat.o(73436);
        return true;
    }

    public static void bzQ() {
        int i2;
        AppMethodBeat.i(194308);
        if (MMApplicationContext.isMainProcess()) {
            b gnC = b.gnC();
            b.gnC();
            com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(i.kD(38, 1));
            if (beg == null) {
                i2 = 0;
            } else {
                i2 = Util.getInt(beg.field_fileVersion, 0);
            }
            gnC.g(38, 1, i2, false);
            AppMethodBeat.o(194308);
            return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
        AppMethodBeat.o(194308);
    }
}
