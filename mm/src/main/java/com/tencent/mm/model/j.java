package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import junit.framework.Assert;

public final class j {
    public static void HO(String str) {
        AppMethodBeat.i(123959);
        Assert.assertTrue(!Util.isNullOrNil(str));
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            AppMethodBeat.o(123959);
            return;
        }
        Kn.setType(Kn.field_type | 2048);
        ab.G(Kn);
        if (((l) g.af(l.class)).aST().bjY(str) == null && Kn.gBM()) {
            if (com.tencent.mm.al.g.Nd(str)) {
                if (((l) g.af(l.class)).aST().bjY("officialaccounts") == null) {
                    az azVar = new az("officialaccounts");
                    azVar.gCr();
                    ((l) g.af(l.class)).aST().e(azVar);
                }
                az azVar2 = new az(str);
                azVar2.yA(System.currentTimeMillis());
                azVar2.Co("officialaccounts");
                ((l) g.af(l.class)).aST().e(azVar2);
            } else if (com.tencent.mm.al.g.Nf(str)) {
                c fJ = com.tencent.mm.al.g.fJ(str);
                if (((l) g.af(l.class)).aST().bjY(fJ.field_enterpriseFather) == null) {
                    az azVar3 = new az(fJ.field_enterpriseFather);
                    azVar3.gCr();
                    ((l) g.af(l.class)).aST().e(azVar3);
                }
                az azVar4 = new az(str);
                azVar4.yA(System.currentTimeMillis());
                azVar4.Co(fJ.UN());
                ((l) g.af(l.class)).aST().e(azVar4);
            }
            Log.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(str)));
        }
        ((l) g.af(l.class)).aST().bke(str);
        AppMethodBeat.o(123959);
    }

    public static int a(final String str, final long j2, final bp.a aVar) {
        AppMethodBeat.i(123960);
        Log.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", Long.valueOf(j2));
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.model.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(123957);
                Cursor ca = ((q) g.af(q.class)).aSR().ca(str, j2);
                if (ca.moveToFirst()) {
                    while (!ca.isAfterLast() && (aVar == null || !aVar.amG())) {
                        ca caVar = new ca();
                        caVar.convertFrom(ca);
                        bp.z(caVar);
                        ca.moveToNext();
                    }
                }
                ca.close();
                ((q) g.af(q.class)).aSR().bZ(str, j2);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.model.j.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(123956);
                        if (aVar != null) {
                            aVar.amH();
                        }
                        AppMethodBeat.o(123956);
                    }
                });
                AppMethodBeat.o(123957);
            }

            public final String toString() {
                AppMethodBeat.i(123958);
                String str = super.toString() + "|deleteMsgByTalker";
                AppMethodBeat.o(123958);
                return str;
            }
        });
        AppMethodBeat.o(123960);
        return 0;
    }
}
