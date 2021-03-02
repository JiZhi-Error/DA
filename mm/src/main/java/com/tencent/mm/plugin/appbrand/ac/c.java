package com.tencent.mm.plugin.appbrand.ac;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    private static LinkedList<e> gCs = new LinkedList<>();
    private static boolean iGo = false;
    private static HashSet<a> ogq = new HashSet<>();
    private static boolean ogr = false;

    public interface a {
        void A(LinkedList<e> linkedList);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(121090);
        done();
        AppMethodBeat.o(121090);
    }

    static {
        AppMethodBeat.i(121091);
        AppMethodBeat.o(121091);
    }

    public static synchronized void reset() {
        synchronized (c.class) {
            AppMethodBeat.i(121086);
            iGo = false;
            ogr = false;
            gCs.clear();
            ogq.clear();
            AppMethodBeat.o(121086);
        }
    }

    public static synchronized void a(final String str, a aVar) {
        synchronized (c.class) {
            AppMethodBeat.i(121087);
            if (iGo) {
                ogq.add(aVar);
                AppMethodBeat.o(121087);
            } else if (ogr) {
                aVar.A(gCs);
                AppMethodBeat.o(121087);
            } else {
                iGo = true;
                ogq.add(aVar);
                g.aAi();
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ac.c.AnonymousClass1 */

                    public final void run() {
                        ah ahVar;
                        k.b HD;
                        String str;
                        AppMethodBeat.i(121085);
                        c.gCs.clear();
                        if (ab.Eq(str)) {
                            ahVar = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
                        } else {
                            ahVar = null;
                        }
                        int i2 = 0;
                        int i3 = 100;
                        while (i3 >= 100) {
                            Cursor eA = ((l) g.af(l.class)).eiy().eA(str, i2);
                            if (eA != null) {
                                try {
                                    i3 = eA.getCount();
                                } catch (Throwable th) {
                                    if (eA != null) {
                                        eA.close();
                                    }
                                    AppMethodBeat.o(121085);
                                    throw th;
                                }
                            } else {
                                i3 = 0;
                            }
                            while (eA != null && eA.moveToNext()) {
                                ca caVar = new ca();
                                caVar.setMsgId(eA.getLong(0));
                                caVar.yF(eA.getLong(1));
                                caVar.setCreateTime(eA.getLong(2));
                                caVar.setContent(eA.getString(3));
                                caVar.nv(eA.getInt(4));
                                caVar.Cz(eA.getString(5));
                                String str2 = caVar.field_content;
                                if (!(str2 == null || (HD = k.b.HD(str2)) == null || !c.zA(HD.type))) {
                                    String a2 = c.a(caVar, ab.Eq(str), str);
                                    as Kn = ((l) g.af(l.class)).aSN().Kn(a2);
                                    String str3 = "";
                                    if (ahVar != null) {
                                        str3 = ahVar.getDisplayName(a2);
                                    }
                                    e eVar = new e(caVar.field_createTime, HD.type, HD.title, caVar.field_msgId, Kn.field_username, Kn.arI(), Kn.field_conRemark, str3, Util.nullAs(HD.izj, HD.appId), HD, caVar.field_msgSvrId);
                                    eVar.desc = HD.title;
                                    WxaAttributes Xk = ((q) g.af(q.class)).Xk(eVar.dXm.izi);
                                    eVar.title = Xk != null ? Xk.field_nickname : eVar.dXm.eah;
                                    if (Xk != null) {
                                        str = Xk.field_brandIconURL;
                                    } else {
                                        str = eVar.dXm.izB;
                                    }
                                    eVar.imagePath = str;
                                    if (HD.izk != 1) {
                                        String d2 = com.tencent.mm.av.q.bcR().d(caVar.field_imgPath, false, true);
                                        if (!Util.isNullOrNil(d2)) {
                                            eVar.ogu = "file://".concat(String.valueOf(d2));
                                        }
                                    }
                                    c.gCs.add(eVar);
                                }
                            }
                            if (eA != null) {
                                eA.close();
                            }
                            i2 += i3;
                        }
                        Log.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(c.gCs.size()));
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ac.c.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(121084);
                                c.access$100();
                                AppMethodBeat.o(121084);
                            }
                        });
                        AppMethodBeat.o(121085);
                    }
                });
                AppMethodBeat.o(121087);
            }
        }
    }

    private static synchronized void done() {
        synchronized (c.class) {
            AppMethodBeat.i(121088);
            Log.i("MicroMsg.AppBrandHistoryListLogic", "done");
            ogr = true;
            iGo = false;
            Iterator<a> it = ogq.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.A(gCs);
                }
            }
            ogq.clear();
            AppMethodBeat.o(121088);
        }
    }

    public static boolean zA(int i2) {
        return 33 == i2 || 36 == i2;
    }

    protected static String a(ca caVar, boolean z, String str) {
        AppMethodBeat.i(121089);
        if (caVar.field_isSend == 1) {
            String aTY = z.aTY();
            AppMethodBeat.o(121089);
            return aTY;
        }
        String str2 = null;
        if (z) {
            str2 = bp.Ks(caVar.field_content);
        }
        if (!Util.isNullOrNil(str2)) {
            str = str2;
        }
        AppMethodBeat.o(121089);
        return str;
    }
}
