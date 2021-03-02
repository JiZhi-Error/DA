package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class aq {
    private static final int DMp = h.aqJ().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);

    public static class a implements i, com.tencent.mm.plugin.sns.b.i {
        public static int DMq = -1;
        public Map<String, Integer> DMA = new HashMap();
        private ax DMB = new ax();
        private Map<String, Long> DMr = new HashMap();
        private Map<String, Integer> DMs = new HashMap();
        private Map<String, Long> DMt = new HashMap();
        private Map<String, Integer> DMu = new HashMap();
        private int DMv = 0;
        public long DMw = 0;
        public long DMx = 0;
        private LinkedList<String> DMy = new LinkedList<>();
        public Map<String, ArrayList<b>> DMz = new HashMap();
        private Map<i.a, String> iMA = new HashMap();

        public a() {
            AppMethodBeat.i(95895);
            AppMethodBeat.o(95895);
        }

        public final void l(String str, ArrayList<b> arrayList) {
            AppMethodBeat.i(95896);
            this.DMz.put(str, arrayList);
            AppMethodBeat.o(95896);
        }

        @Override // com.tencent.mm.plugin.sns.b.i
        public final Intent g(Intent intent, String str) {
            AppMethodBeat.i(95897);
            intent.putExtra("sns_userName", str);
            if (this.DMy == null || !this.DMy.contains(str)) {
                AppMethodBeat.o(95897);
            } else {
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                AppMethodBeat.o(95897);
            }
            return intent;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.sns.b.i
        public final void a(int i2, String str, i.a aVar) {
            AppMethodBeat.i(95898);
            Log.i("MicroMsg.SnsService", "startServer " + i2 + " " + aVar);
            aj.faN().gna = z.aTY();
            aj.faN().fan();
            aj.faK().eZn();
            if (this.iMA.isEmpty()) {
                g.aAi();
                g.aAg().hqi.a(211, this);
                g.aAi();
                g.aAg().hqi.a(212, this);
            }
            if (!this.iMA.containsKey(aVar)) {
                if (i2 == 1) {
                    this.iMA.put(aVar, "@__weixintimtline");
                } else if (i2 == 2 || i2 == 3 || i2 == 10) {
                    this.iMA.put(aVar, str);
                } else if (i2 == 4) {
                    this.iMA.put(aVar, "@__classify_timeline");
                } else if (i2 == 5) {
                    this.iMA.put(aVar, "");
                } else {
                    this.iMA.put(aVar, "");
                }
            }
            switch (i2) {
                case 1:
                    this.DMw = 0;
                    this.DMv = fbw();
                    z.aPb("@__weixintimtline");
                    break;
                case 2:
                    synchronized (this.DMr) {
                        try {
                            this.DMr.put(str, 0L);
                        } finally {
                            AppMethodBeat.o(95898);
                        }
                    }
                    synchronized (this.DMs) {
                        try {
                            if (!this.DMs.containsKey(str)) {
                                this.DMs.put(str, Integer.valueOf(fbw()));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    ab.aPe(str);
                    this.DMy.add(str);
                    AppMethodBeat.o(95898);
                    return;
                case 10:
                    synchronized (this.DMt) {
                        try {
                            this.DMt.put(str, 0L);
                        } finally {
                            AppMethodBeat.o(95898);
                        }
                    }
                    synchronized (this.DMu) {
                        try {
                            if (!this.DMu.containsKey(str)) {
                                this.DMu.put(str, Integer.valueOf(fbw()));
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    ab.aPe(str);
                    this.DMy.add(str);
                    AppMethodBeat.o(95898);
                    return;
            }
            AppMethodBeat.o(95898);
        }

        @Override // com.tencent.mm.plugin.sns.b.i
        public final boolean a(i.a aVar, int i2) {
            AppMethodBeat.i(95899);
            Log.d("MicroMsg.SnsService", "closeServer");
            this.iMA.remove(aVar);
            if ((i2 == 2 || i2 == 10) && this.DMy.size() > 0) {
                this.DMy.removeLast();
            }
            if (this.iMA.isEmpty()) {
                g.aAi();
                g.aAg().hqi.b(211, this);
                g.aAi();
                g.aAg().hqi.b(212, this);
                ar.release();
                SnsInfo.release();
                new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.aq.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(95894);
                        a.a(a.this);
                        AppMethodBeat.o(95894);
                    }
                }, 5000);
                an.fbo();
                Log.i("MicroMsg.SnsService", "close finish");
            }
            AppMethodBeat.o(95899);
            return true;
        }

        public final void b(int i2, String str, boolean z, int i3) {
            int i4;
            AppMethodBeat.i(95900);
            if (ac.jOi) {
                AppMethodBeat.o(95900);
                return;
            }
            synchronized (this.DMr) {
                try {
                    Log.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", str, Integer.valueOf(i2), Long.valueOf(this.DMw), this.DMr);
                } finally {
                    AppMethodBeat.o(95900);
                }
            }
            if (i2 == 2) {
                if (!ab.aPd(str)) {
                    AppMethodBeat.o(95900);
                    return;
                }
                long j2 = 0;
                synchronized (this.DMr) {
                    try {
                        if (this.DMr.containsKey(str)) {
                            j2 = this.DMr.get(str).longValue();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (j2 == 0) {
                    ab.aPe(str);
                    AppMethodBeat.o(95900);
                    return;
                }
                g.aAi();
                t tVar = g.aAg().hqi;
                int i5 = ax.DOc;
                if (z) {
                    i4 = 4;
                } else {
                    i4 = 8;
                }
                tVar.a(new ab(str, j2, z, i3, i5, 0, i4, i2), 0);
                AppMethodBeat.o(95900);
            } else if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        if (!o.aPa("@__classify_timeline")) {
                            AppMethodBeat.o(95900);
                        } else if (this.DMw == 0) {
                            o.aPb("@__classify_timeline");
                            AppMethodBeat.o(95900);
                        } else {
                            g.aAi();
                            g.aAg().hqi.a(new o(""), 0);
                            AppMethodBeat.o(95900);
                        }
                    } else if (i2 == 10) {
                        if (!ab.aPd(str)) {
                            AppMethodBeat.o(95900);
                            return;
                        }
                        long j3 = 0;
                        synchronized (this.DMt) {
                            try {
                                if (this.DMt.containsKey(str)) {
                                    j3 = this.DMt.get(str).longValue();
                                }
                            } finally {
                                AppMethodBeat.o(95900);
                            }
                        }
                        if (j3 == 0) {
                            ab.aPe(str);
                            AppMethodBeat.o(95900);
                            return;
                        }
                        g.aAi();
                        g.aAg().hqi.a(new ab(str, j3, z, i3, ax.DOc, 1, 64, i2), 0);
                    }
                }
            } else if (!z.aPa("@__weixintimtline")) {
                AppMethodBeat.o(95900);
            } else if (this.DMw == 0) {
                z.aPb("@__weixintimtline");
                AppMethodBeat.o(95900);
            } else {
                aj.faZ().DNF = ax.DOf;
                g.aAi();
                g.aAg().hqi.a(new z(this.DMw, 0, 0), 0);
                AppMethodBeat.o(95900);
            }
        }

        @Override // com.tencent.mm.plugin.sns.b.i
        public final void a(final int i2, final String str, final boolean z, final int i3) {
            AppMethodBeat.i(95901);
            if (ac.jOi) {
                AppMethodBeat.o(95901);
                return;
            }
            Log.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", Integer.valueOf(i2), str);
            wg wgVar = new wg();
            wgVar.ecq.state = 1;
            EventCenter.instance.publish(wgVar);
            if (i2 == 2) {
                aj.eJP().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.aq.a.AnonymousClass2 */

                    public final void run() {
                        int i2;
                        AppMethodBeat.i(202777);
                        if (!ab.aPd(str)) {
                            AppMethodBeat.o(202777);
                            return;
                        }
                        g.aAi();
                        t tVar = g.aAg().hqi;
                        String str = str;
                        boolean z = z;
                        int i3 = i3;
                        int i4 = ax.DOc;
                        if (z) {
                            i2 = 4;
                        } else {
                            i2 = 8;
                        }
                        tVar.a(new ab(str, 0, z, i3, i4, 0, i2, i2), 0);
                        AppMethodBeat.o(202777);
                    }
                });
                AppMethodBeat.o(95901);
            } else if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        if (!o.aPa("@__classify_timeline")) {
                            AppMethodBeat.o(95901);
                            return;
                        }
                        g.aAi();
                        g.aAg().hqi.a(new o(""), 0);
                        AppMethodBeat.o(95901);
                        return;
                    } else if (i2 == 10) {
                        aj.eJP().post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.model.aq.a.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(202778);
                                if (!ab.aPd(str)) {
                                    AppMethodBeat.o(202778);
                                    return;
                                }
                                g.aAi();
                                g.aAg().hqi.a(new ab(str, 0, z, i3, ax.DOc, 1, 64, i2), 0);
                                AppMethodBeat.o(202778);
                            }
                        });
                    }
                }
                AppMethodBeat.o(95901);
            } else if (!z.aPa("@__weixintimtline")) {
                AppMethodBeat.o(95901);
            } else {
                aj.faZ().DNF = ax.DOf;
                aj.faZ().DNM = aj.faO().h(0, 1, true);
                g.aAi();
                g.aAh().azQ().set(68377, "");
                g.aAi();
                g.aAg().hqi.a(new z(0, 0, 0), 0);
                AppMethodBeat.o(95901);
            }
        }

        public final void a(int i2, String str, int i3, boolean z, long j2, int i4) {
            AppMethodBeat.i(95902);
            Log.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", Integer.valueOf(i3), Integer.valueOf(i2));
            if (i2 == 2) {
                if (!ab.aPd(str)) {
                    AppMethodBeat.o(95902);
                    return;
                } else if (i3 == ax.DOd) {
                    this.DMB.a(str, z, i4, j2, i2);
                    AppMethodBeat.o(95902);
                    return;
                } else if (i3 == ax.DOe) {
                    ax.b(str, z, i4, j2, i2);
                    AppMethodBeat.o(95902);
                    return;
                } else if (i3 == ax.DOf) {
                    ax.f(str, z, i4);
                    AppMethodBeat.o(95902);
                    return;
                }
            } else if (i2 == 1) {
                if (!z.aPa("@__weixintimtline")) {
                    AppMethodBeat.o(95902);
                    return;
                }
                aj.faZ().DNF = i3;
                if (i3 == ax.DOd) {
                    this.DMB.a(str, z, i4, j2, i2);
                    AppMethodBeat.o(95902);
                    return;
                } else if (i3 == ax.DOe) {
                    aj.faZ().DNI = true;
                    ax.b(str, z, i4, this.DMx, i2);
                }
            }
            AppMethodBeat.o(95902);
        }

        public final int aPn(String str) {
            AppMethodBeat.i(95903);
            synchronized (this.DMs) {
                try {
                    if (this.DMs.containsKey(str)) {
                        int intValue = this.DMs.get(str).intValue();
                        if (intValue <= 0) {
                            intValue = r.eZv();
                        }
                        return intValue;
                    }
                    int eZv = r.eZv();
                    AppMethodBeat.o(95903);
                    return eZv;
                } finally {
                    AppMethodBeat.o(95903);
                }
            }
        }

        public final int fbw() {
            AppMethodBeat.i(95904);
            if (this.DMv > 0) {
                int i2 = this.DMv;
                AppMethodBeat.o(95904);
                return i2;
            }
            int eZv = r.eZv();
            AppMethodBeat.o(95904);
            return eZv;
        }

        public final void W(long j2, int i2) {
            AppMethodBeat.i(95905);
            Log.d("MicroMsg.SnsService", "setTimeLastId %d", Long.valueOf(j2));
            if (i2 > 0) {
                this.DMv = i2;
                r.Ym(i2);
            }
            if (j2 == 0) {
                AppMethodBeat.o(95905);
                return;
            }
            this.DMw = j2;
            AppMethodBeat.o(95905);
        }

        public final void Jv(long j2) {
            AppMethodBeat.i(179094);
            Log.d("MicroMsg.SnsService", "setTimeFirstId %d", Long.valueOf(j2));
            if (j2 == 0) {
                AppMethodBeat.o(179094);
                return;
            }
            this.DMx = j2;
            AppMethodBeat.o(179094);
        }

        public static int fbx() {
            AppMethodBeat.i(95906);
            if (DMq != -1) {
                int i2 = DMq;
                AppMethodBeat.o(95906);
                return i2;
            }
            DMq = r.eZu();
            Log.i("MicroMsg.SnsService", "getTimelineControlFlag %d", Integer.valueOf(DMq));
            int i3 = DMq;
            AppMethodBeat.o(95906);
            return i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x011b  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r11, int r12, java.lang.String r13, com.tencent.mm.ak.q r14) {
            /*
            // Method dump skipped, instructions count: 736
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.aq.a.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }

        public static void aPo(String str) {
            AppMethodBeat.i(95908);
            ag faN = aj.faN();
            if (Util.isNullOrNil(faN.gna)) {
                faN.gna = z.aTY();
            }
            String str2 = faN.gna;
            SnsInfo aQl = f.aQl(str);
            try {
                SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(aQl.field_attrBuf);
                Iterator<dzo> it = snsObject.LikeUserList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    dzo next = it.next();
                    if (next.Username.equals(str2)) {
                        snsObject.LikeUserList.remove(next);
                        snsObject.LikeCount--;
                        aQl.field_attrBuf = snsObject.toByteArray();
                        if (aQl.isAd()) {
                            aj.faR().replace(aQl.getAdSnsInfo());
                        } else {
                            aj.faO().S(aQl);
                        }
                    }
                }
            } catch (Exception e2) {
            }
            if (aj.faN().Jt(y.aOa(str))) {
                if (aQl.isAd()) {
                    ADInfo adInfo = aQl.getAdInfo();
                    ((d) g.af(d.class)).a(11855, aQl.getAdRecSrc(), 0, adInfo == null ? "" : adInfo.viewId, Integer.valueOf(aQl.getAdRecSrc()));
                    g.aAi();
                    g.aAg().hqi.a(new s(y.aOa(str), 7), 0);
                    AppMethodBeat.o(95908);
                    return;
                }
                g.aAi();
                g.aAg().hqi.a(new s(y.aOa(str), 5), 0);
            }
            AppMethodBeat.o(95908);
        }

        private static dzo b(SnsInfo snsInfo, int i2, String str, dzo dzo, int i3, int i4, String str2) {
            String str3;
            ADInfo adInfo;
            int i5;
            AppMethodBeat.i(95911);
            dzi dzi = new dzi();
            dzi.iAc = str;
            dzi.CreateTime = (int) (Util.nowMilliSecond() / 1000);
            dzi.MYQ = z.aUa();
            dzi.MKC = z.aTY();
            dzi.xub = 0;
            dzi.MYR = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(snsInfo.getUserName());
            dzi.LsY = snsInfo.getUserName();
            dzi.oUv = i2;
            dzi.MYX = i3;
            if (snsInfo.isSourceExist(32)) {
                dzi.MYU = dzo == null ? 0 : dzo.MYV;
            } else {
                dzi.MYS = dzo == null ? 0 : dzo.MYT;
            }
            if (!Util.isNullOrNil(str2)) {
                dzu dzu = new dzu();
                dzu.Md5 = str2;
                dzi.MYY = new LinkedList<>();
                dzi.MYY.add(dzu);
                dzi.MYZ = 1;
            }
            dzi dzi2 = new dzi();
            if (dzo == null) {
                str3 = "";
            } else {
                str3 = dzo.Username;
            }
            dzi2.MKC = str3;
            if (!Util.isNullOrNil(dzi2.MKC)) {
                dzi2.MYQ = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(dzi2.MKC);
            }
            dzj dzj = new dzj();
            dzj.Id = snsInfo.field_snsId;
            dzj.MZb = dzi;
            dzj.MZc = dzi2;
            String str4 = "";
            int i6 = 0;
            if (snsInfo.isAd()) {
                Log.i("MicroMsg.SnsService", "sendComment, sourceScene=" + i4 + ", type=" + i2 + ", flag=" + i3);
                if (i4 == 2) {
                    i5 = 1;
                    adInfo = snsInfo.getAtAdInfo();
                } else {
                    adInfo = snsInfo.getAdInfo();
                    i5 = 0;
                }
                String str5 = adInfo == null ? "" : adInfo.viewId;
                str4 = adInfo == null ? "" : adInfo.uxInfo;
                if (dzi.oUv == 7) {
                    ((d) g.af(d.class)).a(11855, snsInfo.getAdRecSrc(), 1, str5, Integer.valueOf(snsInfo.getAdRecSrc()));
                } else if (dzi.oUv == 8) {
                    ((d) g.af(d.class)).a(11855, snsInfo.getAdRecSrc(), 2, str5, Integer.valueOf(snsInfo.getAdRecSrc()));
                }
                AdSnsInfo adSnsInfo = snsInfo.getAdSnsInfo();
                if (adSnsInfo != null) {
                    if (adSnsInfo.field_firstControlTime == 0) {
                        adSnsInfo.field_firstControlTime = dzi.CreateTime;
                        aj.faR().b(adSnsInfo.field_snsId, adSnsInfo);
                    }
                    cj remindInfoGroup = adSnsInfo.getRemindInfoGroup();
                    if (i4 == 2) {
                        if (remindInfoGroup != null) {
                            dzj.MZb.KHJ = remindInfoGroup.KGE;
                            if (remindInfoGroup.KGE != null) {
                                Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", Long.valueOf(remindInfoGroup.KGE.MQh), Integer.valueOf(remindInfoGroup.KGE.MQc));
                                if (remindInfoGroup.KGE.MQh == 0 && remindInfoGroup.KGE.MQc == 0) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 9);
                                    i6 = i5;
                                }
                            } else {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 7);
                                Log.i("MicroMsg.SnsService", "remindInfo is null!");
                                i6 = i5;
                            }
                        } else {
                            Log.i("MicroMsg.SnsService", "remindInfo group is null!");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 5);
                            i6 = i5;
                        }
                    } else if (e.iY(i3, 8)) {
                        Log.i("MicroMsg.SnsService", "sendAtFriend");
                        if (remindInfoGroup == null) {
                            Log.i("MicroMsg.SnsService", "remindInfo group is null!");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 5);
                        } else if (remindInfoGroup.KGD != null) {
                            dzj.MZb.KHJ = remindInfoGroup.KGD;
                            Log.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", Long.valueOf(remindInfoGroup.KGD.MQh), Integer.valueOf(remindInfoGroup.KGD.MQc));
                            if (remindInfoGroup.KGD.MQh == 0 && remindInfoGroup.KGD.MQc == 0) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 8);
                                i6 = i5;
                            }
                        } else if (remindInfoGroup.KGE != null) {
                            dzj.MZb.KHJ = remindInfoGroup.KGE;
                            Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", Long.valueOf(remindInfoGroup.KGE.MQh), Integer.valueOf(remindInfoGroup.KGE.MQc));
                            if (remindInfoGroup.KGE.MQh == 0 && remindInfoGroup.KGE.MQc == 0) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 8);
                                i6 = i5;
                            }
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 6);
                            Log.i("MicroMsg.SnsService", "remindInfo is null!");
                            i6 = i5;
                        }
                    }
                }
                i6 = i5;
            }
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).toString().getBytes());
            if (snsInfo.isSourceExist(32)) {
                messageDigest = "_AD_TAG_".concat(String.valueOf(messageDigest));
            }
            if (!aj.faN().a(messageDigest, dzj)) {
                Log.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ag.aPg(messageDigest)) {
                g.aAi();
                g.aAg().hqi.a(new k(dzj, messageDigest, str4, i6), 0);
            } else {
                g.aAi();
                g.aAg().hqi.a(new p(dzj, messageDigest, i4), 0);
            }
            AppMethodBeat.o(95911);
            return null;
        }

        public static dzo a(SnsInfo snsInfo, int i2, String str, String str2, int i3) {
            AppMethodBeat.i(95912);
            dzi dzi = new dzi();
            dzi.iAc = str;
            dzi.CreateTime = (int) (Util.nowMilliSecond() / 1000);
            dzi.MYQ = z.aUa();
            dzi.MKC = z.aTY();
            dzi.xub = i3;
            dzi.MYR = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(snsInfo.getUserName());
            dzi.LsY = snsInfo.getUserName();
            dzi.oUv = i2;
            if (snsInfo.isSourceExist(32)) {
                dzi.MYU = 0;
            } else {
                dzi.MYS = 0;
            }
            dzi dzi2 = new dzi();
            dzi2.MKC = str2;
            if (!Util.isNullOrNil(dzi2.MKC)) {
                dzi2.MYQ = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(dzi2.MKC);
            }
            dzj dzj = new dzj();
            dzj.Id = snsInfo.field_snsId;
            dzj.MZb = dzi;
            dzj.MZc = dzi2;
            String str3 = "";
            if (snsInfo.isAd()) {
                ADInfo adInfo = snsInfo.getAdInfo();
                String str4 = adInfo == null ? "" : adInfo.viewId;
                str3 = adInfo == null ? "" : adInfo.uxInfo;
                if (dzi.oUv == 7) {
                    ((d) g.af(d.class)).a(11855, snsInfo.getAdRecSrc(), 1, str4, Integer.valueOf(snsInfo.getAdRecSrc()));
                } else if (dzi.oUv == 8) {
                    ((d) g.af(d.class)).a(11855, snsInfo.getAdRecSrc(), 2, str4, Integer.valueOf(snsInfo.getAdRecSrc()));
                }
            }
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).toString().getBytes());
            if (snsInfo.isSourceExist(32)) {
                messageDigest = "_AD_TAG_".concat(String.valueOf(messageDigest));
            }
            if (!aj.faN().a(messageDigest, dzj, str3)) {
                Log.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ag.aPg(messageDigest)) {
                g.aAi();
                g.aAg().hqi.a(new k(dzj, messageDigest, str3, 0), 0);
            } else {
                g.aAi();
                g.aAg().hqi.a(new p(dzj, messageDigest, i3), 0);
            }
            AppMethodBeat.o(95912);
            return null;
        }

        public static void a(String str, int i2, String str2, SnsInfo snsInfo, int i3) {
            AppMethodBeat.i(95913);
            if (i2 == 3 || i2 == 5) {
                dzi dzi = new dzi();
                dzi.iAc = str2;
                dzi.CreateTime = (int) (System.currentTimeMillis() / 1000);
                dzi.MYQ = z.aUa();
                dzi.MKC = z.aTY();
                dzi.xub = i3;
                dzi.MYR = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str);
                dzi.LsY = str;
                dzi.oUv = i2;
                dzj dzj = new dzj();
                dzj.Id = snsInfo.field_snsId;
                dzj.MZb = dzi;
                dzj.MZc = new dzi();
                String messageDigest = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).toString().getBytes());
                long j2 = snsInfo.field_snsId;
                try {
                    Log.v("MicroMsg.SnsService", "comment stg inserted");
                    com.tencent.mm.plugin.sns.storage.h hVar = new com.tencent.mm.plugin.sns.storage.h();
                    hVar.field_talker = str;
                    hVar.field_snsID = j2;
                    hVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                    hVar.field_curActionBuf = dzi.toByteArray();
                    hVar.field_type = i2;
                    hVar.field_isSend = true;
                    hVar.field_isRead = 1;
                    aj.faT().insert(hVar);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsService", e2, "", new Object[0]);
                }
                aj.faN().a(messageDigest, dzj);
                AppMethodBeat.o(95913);
                return;
            }
            AppMethodBeat.o(95913);
        }

        @Override // com.tencent.mm.plugin.sns.b.i
        public final void aNX(String str) {
            AppMethodBeat.i(95914);
            String accSnsPath = aj.getAccSnsPath();
            String str2 = str + "bg_";
            String str3 = str + "tbg_";
            if (s.YS(str2)) {
                s.deleteFile(ar.ki(accSnsPath, str) + str3);
                s.bo(ar.ki(accSnsPath, str), str2, str3);
            }
            AppMethodBeat.o(95914);
        }

        public static dzo a(SnsInfo snsInfo, int i2, String str, int i3) {
            AppMethodBeat.i(95909);
            dzo b2 = b(snsInfo, i2, str, null, 0, i3, "");
            AppMethodBeat.o(95909);
            return b2;
        }

        public static dzo a(SnsInfo snsInfo, int i2, String str, dzo dzo, int i3, int i4, String str2) {
            AppMethodBeat.i(95910);
            dzo b2 = b(snsInfo, i2, str, dzo, i3, i4, str2);
            AppMethodBeat.o(95910);
            return b2;
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(95915);
            if (!aj.isInValid() && aVar.iMA.isEmpty()) {
                aj.faL().fad();
                Log.d("MicroMsg.SnsService", "clean sns cache");
            }
            AppMethodBeat.o(95915);
        }
    }

    public static void g(ArrayList<String> arrayList, String str) {
        SnsInfo Zr;
        TimeLineObject timeLine;
        AppMethodBeat.i(95916);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(95916);
            return;
        }
        Iterator it = new ArrayList(arrayList).iterator();
        while (it.hasNext()) {
            int i2 = Util.getInt((String) it.next(), 0);
            if (!(i2 == 0 || (Zr = aj.faO().Zr(i2)) == null || (timeLine = Zr.getTimeLine()) == null || timeLine.ContentObj == null || timeLine.ContentObj.LoU != 26)) {
                timeLine.ContentObj.LoX = str;
                aj.faO().d(i2, Zr);
                sn snVar = new sn();
                snVar.dZd.dZe = i2;
                EventCenter.instance.publish(snVar);
            }
        }
        AppMethodBeat.o(95916);
    }

    static {
        AppMethodBeat.i(95919);
        AppMethodBeat.o(95919);
    }

    public static boolean fbv() {
        boolean z;
        AppMethodBeat.i(95917);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, (Object) 0)).intValue();
        Log.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", Integer.valueOf(intValue), Integer.valueOf(DMp));
        if (intValue < DMp) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(intValue + 1));
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.o(95917);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0039, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isEqual(com.tencent.e.f.e.bytesToHexString(r3.digest()), "2A281593D71DF33374E6124E9106DF08") != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean gQ(android.content.Context r6) {
        /*
            r5 = 95918(0x176ae, float:1.3441E-40)
            r0 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = "com.tencent.weishi"
            r4 = 64
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r4)     // Catch:{ Exception -> 0x003f }
            if (r2 == 0) goto L_0x0051
            android.content.pm.Signature[] r2 = r2.signatures     // Catch:{ Exception -> 0x003f }
            r3 = 0
            r2 = r2[r3]     // Catch:{ Exception -> 0x003f }
            byte[] r2 = r2.toByteArray()     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Exception -> 0x003f }
            r3.update(r2)     // Catch:{ Exception -> 0x003f }
            byte[] r2 = r3.digest()     // Catch:{ Exception -> 0x003f }
            java.lang.String r2 = com.tencent.e.f.e.bytesToHexString(r2)     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = "2A281593D71DF33374E6124E9106DF08"
            boolean r2 = com.tencent.mm.sdk.platformtools.Util.isEqual(r2, r3)     // Catch:{ Exception -> 0x003f }
            if (r2 == 0) goto L_0x0051
        L_0x003b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x003f:
            r2 = move-exception
            java.lang.String r3 = "MicroMsg.SnsLogic"
            java.lang.String r4 = "checkWeishiInstalled Exception: %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = r2.getMessage()
            r0[r1] = r2
            com.tencent.mm.sdk.platformtools.Log.w(r3, r4, r0)
        L_0x0051:
            r0 = r1
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.aq.gQ(android.content.Context):boolean");
    }
}
