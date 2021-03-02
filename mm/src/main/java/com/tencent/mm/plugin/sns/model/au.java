package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class au {
    private static HashMap<String, b> DNc = new HashMap<>();
    private static LinkedList<a> DNd = new LinkedList<>();
    private static IListener DNe = new IListener<yd>() {
        /* class com.tencent.mm.plugin.sns.model.au.AnonymousClass1 */

        {
            AppMethodBeat.i(160677);
            this.__eventId = yd.class.getName().hashCode();
            AppMethodBeat.o(160677);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yd ydVar) {
            String str;
            int i2;
            a fD;
            int i3 = 1;
            AppMethodBeat.i(95929);
            yd ydVar2 = ydVar;
            if ((ydVar2 instanceof yd) && (fD = au.fD((str = ydVar2.eey.id), (i2 = ydVar2.eey.type))) != null) {
                String str2 = ydVar2.eey.eez;
                fD.DNg = str2;
                fD.ecu = ydVar2.eey.ecu;
                Object[] objArr = new Object[3];
                objArr[0] = fD.id;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Boolean.valueOf(!Util.isNullOrNil(str2));
                Log.i("MicroMsg.SnsTranslateManager", "finish translate, id:%s, type: %d, success: %b", objArr);
                switch (i2) {
                    case 2:
                        break;
                    case 3:
                        i3 = 2;
                        break;
                    default:
                        i3 = -1;
                        break;
                }
                if (i3 != -1) {
                    au.k(str, i3, fD.DNg, fD.ecu);
                    au.DNd.remove(fD);
                }
            }
            AppMethodBeat.o(95929);
            return false;
        }
    };

    public static class b {
        public boolean DNh;
        public boolean DNi;
        public boolean aGI;
        public String brand;
        public boolean iGD;
        public String id;
        public String result;
        public int showFlag;
    }

    static /* synthetic */ void k(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(95950);
        j(str, i2, str2, str3);
        AppMethodBeat.o(95950);
    }

    static {
        AppMethodBeat.i(95951);
        AppMethodBeat.o(95951);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String DNf;
        String DNg;
        String ecu;
        String id;
        int type;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95930);
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!this.id.equals(aVar.id) || this.type != aVar.type) {
                    AppMethodBeat.o(95930);
                    return false;
                }
                AppMethodBeat.o(95930);
                return true;
            }
            boolean equals = super.equals(obj);
            AppMethodBeat.o(95930);
            return equals;
        }
    }

    public static void init() {
        AppMethodBeat.i(95931);
        EventCenter.instance.addListener(DNe);
        AppMethodBeat.o(95931);
    }

    public static void unInit() {
        AppMethodBeat.i(95932);
        EventCenter.instance.removeListener(DNe);
        AppMethodBeat.o(95932);
    }

    private static boolean Xn() {
        AppMethodBeat.i(95933);
        if (!c.aZU("translate")) {
            AppMethodBeat.o(95933);
            return false;
        }
        String value = h.aqJ().getValue("TranslateSnsOff");
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(95933);
            return true;
        } else if (Util.safeParseInt(value) != 0) {
            AppMethodBeat.o(95933);
            return false;
        } else {
            AppMethodBeat.o(95933);
            return true;
        }
    }

    public static void a(Menu menu, boolean z) {
        AppMethodBeat.i(95934);
        if (Xn()) {
            if (z) {
                menu.add(0, 14, 0, R.string.hbl);
                AppMethodBeat.o(95934);
                return;
            }
            menu.add(0, 15, 0, R.string.hbl);
        }
        AppMethodBeat.o(95934);
    }

    public static void b(Menu menu, boolean z) {
        AppMethodBeat.i(95935);
        if (Xn()) {
            if (z) {
                menu.add(0, 16, 0, R.string.hbn);
                AppMethodBeat.o(95935);
                return;
            }
            menu.add(0, 17, 0, R.string.hbn);
        }
        AppMethodBeat.o(95935);
    }

    public static void E(SnsInfo snsInfo) {
        AppMethodBeat.i(95936);
        if (snsInfo != null) {
            String snsId = snsInfo.getSnsId();
            Log.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", snsId);
            if (snsInfo.field_snsId == 0) {
                Log.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                DNc.remove(snsId);
                j(snsId, 1, null, null);
                AppMethodBeat.o(95936);
                return;
            }
            if (DNc.containsKey(snsId)) {
                b bVar = DNc.get(snsId);
                if (!bVar.iGD || bVar.aGI) {
                    DNc.remove(snsId);
                } else {
                    Log.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", snsId);
                    j(bVar.id, 1, bVar.result, bVar.brand);
                    AppMethodBeat.o(95936);
                    return;
                }
            }
            if (snsInfo.getTimeLine() != null) {
                String str = snsInfo.getTimeLine().ContentDesc;
                ya yaVar = new ya();
                yaVar.eep.id = snsId;
                yaVar.eep.eeq = str;
                yaVar.eep.type = 2;
                EventCenter.instance.publish(yaVar);
                fz(snsInfo.getSnsId(), 1);
                a aVar = new a((byte) 0);
                aVar.id = snsId;
                aVar.DNf = str;
                aVar.type = 2;
                DNd.add(aVar);
            }
        }
        AppMethodBeat.o(95936);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(95937);
        if ((bVar.showFlag & 2) != 0) {
            bVar.DNh = false;
        } else if ((bVar.showFlag & 4) != 0) {
            bVar.DNi = false;
        }
        DNc.put(bVar.id, bVar);
        AppMethodBeat.o(95937);
    }

    private static void b(b bVar) {
        AppMethodBeat.i(95938);
        if ((bVar.showFlag & 2) != 0) {
            bVar.DNh = true;
        } else if ((bVar.showFlag & 4) != 0) {
            bVar.DNi = true;
        }
        DNc.put(bVar.id, bVar);
        AppMethodBeat.o(95938);
    }

    public static void F(SnsInfo snsInfo) {
        AppMethodBeat.i(95939);
        if (snsInfo != null) {
            String snsId = snsInfo.getSnsId();
            b(aPp(snsId));
            wl wlVar = new wl();
            wlVar.ecx.type = 1;
            wlVar.ecx.id = snsId;
            EventCenter.instance.publish(wlVar);
            Log.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", snsId);
        }
        AppMethodBeat.o(95939);
    }

    public static void a(m mVar) {
        long j2;
        AppMethodBeat.i(95940);
        if (!(mVar == null || mVar.DIu == null)) {
            String str = mVar.iAc;
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
                AppMethodBeat.o(95940);
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (mVar.DIu.MYT != 0) {
                j2 = (long) mVar.DIu.MYT;
            } else {
                j2 = mVar.DIu.MYV;
            }
            String kj = kj(mVar.Epv, sb.append(j2).toString());
            if (DNc.containsKey(kj)) {
                b bVar = DNc.get(kj);
                if (!bVar.iGD || Util.isNullOrNil(bVar.result)) {
                    DNc.remove(kj);
                } else {
                    Log.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", kj);
                    j(bVar.id, 2, bVar.result, bVar.brand);
                    AppMethodBeat.o(95940);
                    return;
                }
            }
            ya yaVar = new ya();
            yaVar.eep.id = kj;
            yaVar.eep.eeq = str;
            yaVar.eep.type = 3;
            EventCenter.instance.publish(yaVar);
            fz(kj, 2);
            a aVar = new a((byte) 0);
            aVar.id = kj;
            aVar.DNf = str;
            aVar.type = 3;
            DNd.add(aVar);
            Log.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", aVar.id);
        }
        AppMethodBeat.o(95940);
    }

    public static void b(m mVar) {
        AppMethodBeat.i(95941);
        if (mVar != null) {
            String kj = kj(mVar.Epv, new StringBuilder().append(mVar.DIu.MYT != 0 ? (long) mVar.DIu.MYT : mVar.DIu.MYV).toString());
            b(aPp(kj));
            wl wlVar = new wl();
            wlVar.ecx.type = 2;
            wlVar.ecx.id = kj;
            EventCenter.instance.publish(wlVar);
            Log.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", kj);
        }
        AppMethodBeat.o(95941);
    }

    private static void fz(String str, int i2) {
        AppMethodBeat.i(95942);
        if (!DNc.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.brand = null;
            bVar.result = null;
            bVar.iGD = false;
            bVar.aGI = false;
            bVar.DNi = true;
            bVar.DNh = true;
            DNc.put(str, bVar);
        }
        wk wkVar = new wk();
        wkVar.ecw.type = i2;
        wkVar.ecw.id = str;
        EventCenter.instance.publish(wkVar);
        AppMethodBeat.o(95942);
    }

    private static void j(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(95943);
        if (DNc.containsKey(str)) {
            b bVar = DNc.get(str);
            bVar.brand = str3;
            bVar.result = str2;
            bVar.iGD = true;
            bVar.aGI = Util.isNullOrNil(str2);
            DNc.put(str, bVar);
        }
        if (Util.isNullOrNil(str2)) {
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.hbm, 1).show();
        }
        wi wiVar = new wi();
        wiVar.ect.type = i2;
        wiVar.ect.id = str;
        wiVar.ect.result = str2;
        wiVar.ect.ecu = str3;
        EventCenter.instance.publish(wiVar);
        AppMethodBeat.o(95943);
    }

    public static String kj(String str, String str2) {
        AppMethodBeat.i(95944);
        String str3 = str + ";" + str2;
        AppMethodBeat.o(95944);
        return str3;
    }

    public static HashMap<String, b> fbC() {
        return DNc;
    }

    public static void fA(String str, int i2) {
        AppMethodBeat.i(95945);
        if (DNc.containsKey(str)) {
            b bVar = DNc.get(str);
            bVar.showFlag |= i2;
            DNc.put(str, bVar);
        }
        AppMethodBeat.o(95945);
    }

    public static void fB(String str, int i2) {
        AppMethodBeat.i(95946);
        if (DNc.containsKey(str)) {
            b bVar = DNc.get(str);
            bVar.showFlag &= i2 ^ -1;
            if (i2 != 2 && i2 == 4) {
                bVar.DNi = true;
            }
            DNc.put(str, bVar);
        }
        AppMethodBeat.o(95946);
    }

    public static boolean fC(String str, int i2) {
        AppMethodBeat.i(95947);
        if (!DNc.containsKey(str)) {
            AppMethodBeat.o(95947);
            return false;
        } else if ((DNc.get(str).showFlag & i2) != 0) {
            AppMethodBeat.o(95947);
            return true;
        } else {
            AppMethodBeat.o(95947);
            return false;
        }
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.showFlag & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b aPp(String str) {
        AppMethodBeat.i(95948);
        if (DNc.containsKey(str)) {
            b bVar = DNc.get(str);
            AppMethodBeat.o(95948);
            return bVar;
        }
        AppMethodBeat.o(95948);
        return null;
    }

    static /* synthetic */ a fD(String str, int i2) {
        AppMethodBeat.i(95949);
        Iterator<a> it = DNd.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.type == i2 && !Util.isNullOrNil(str) && !Util.isNullOrNil(next.id) && str.equals(next.id)) {
                AppMethodBeat.o(95949);
                return next;
            }
        }
        AppMethodBeat.o(95949);
        return null;
    }
}
