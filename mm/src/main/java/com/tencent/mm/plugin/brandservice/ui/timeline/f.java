package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;

public final class f {
    public int dEb;
    public int psq;
    public int psr;
    public long pss;
    public com.tencent.mm.plugin.brandservice.ui.timeline.a.b pst;
    c<String, b> psu = new c<>();
    public HashMap<String, Boolean> psv = new HashMap<>();
    a psw;

    public static class b extends ot {
        public String fQY;
        public String psI;
    }

    public final void a(com.tencent.mm.plugin.brandservice.ui.timeline.a.b bVar) {
        this.pst = bVar;
    }

    public class c<K, V> extends HashMap<K, V> {
        public c() {
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final V put(K k, V v) {
            AppMethodBeat.i(194917);
            com.tencent.mm.plugin.brandservice.ui.timeline.a.b bVar = f.this.pst;
            K k2 = k;
            V v2 = v;
            p.h(k2, "key");
            p.h(v2, "item");
            synchronized (com.tencent.mm.plugin.brandservice.ui.timeline.a.b.class) {
                try {
                    bVar.pyQ.put(k2, v2);
                } catch (Throwable th) {
                    AppMethodBeat.o(194917);
                    throw th;
                }
            }
            V v3 = (V) super.put(k, v);
            AppMethodBeat.o(194917);
            return v3;
        }
    }

    public f(int i2, long j2) {
        AppMethodBeat.i(194918);
        this.dEb = i2;
        this.pss = j2;
        AppMethodBeat.o(194918);
    }

    public final void c(z zVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        com.tencent.mm.ag.p ahw;
        int i8;
        int i9 = 1;
        int i10 = 0;
        AppMethodBeat.i(5935);
        if (zVar == null) {
            AppMethodBeat.o(5935);
        } else if (zVar.gAt()) {
            if (zVar.gAt()) {
                u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(zVar.field_msgId, zVar.field_content);
                if (a2 == null || Util.isNullOrNil(a2.iAd)) {
                    AppMethodBeat.o(5935);
                    return;
                }
                try {
                    int size = a2.iAd.size();
                    if (size <= 2 || zVar.field_isExpand) {
                        i4 = size;
                    } else {
                        i4 = 2;
                    }
                    int i11 = 0;
                    while (i11 < i4) {
                        v vVar = (v) a2.iAd.get(i11);
                        if (vVar != null) {
                            b bVar = this.psu.get(zVar.getId() + "_" + i11);
                            if (bVar == null) {
                                b bVar2 = new b();
                                this.psu.put(zVar.getId() + "_" + i11, bVar2);
                                bVar2.KUC = zVar.field_talker;
                                a(bVar2, i2, zVar);
                                bVar2.KUI = 0;
                                bVar2.KUK = 0;
                                bVar2.KUL = 0;
                                bVar2.KTM = 0;
                                bVar2.ybm = vVar.type;
                                if (!Util.isNullOrNil(vVar.url) && (ahw = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahw(vVar.url)) != null) {
                                    if (ahw.izZ != null) {
                                        i8 = ahw.izZ.izT;
                                    } else {
                                        i8 = 0;
                                    }
                                    bVar2.KUS = "1_" + i8 + ";";
                                    bVar2.KVn = ahw.iAa;
                                }
                                bVar2.KUU = i11;
                                bVar2.KUV = zVar.field_isExpand ? 1 : 0;
                                if (i11 != 0 || !zVar.NQj) {
                                    i6 = 0;
                                } else {
                                    i6 = 1;
                                }
                                bVar2.KUZ = i6;
                                if (zVar.NQk) {
                                    i7 = 1;
                                } else {
                                    i7 = 0;
                                }
                                bVar2.KVa = i7;
                                bVar2.KVd = vVar.iwf;
                                bVar2.KIJ = vVar.type;
                                bVar2.KVe = zVar.field_rankSessionId;
                                a(bVar2, zVar.field_talker);
                                if (!Util.isNullOrNil(vVar.url)) {
                                    Uri parse = Uri.parse(vVar.url);
                                    int i12 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                    long j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                                    bVar2.KUF.add(Integer.valueOf(i12));
                                    bVar2.dFm = j2;
                                    bVar2.KUT = j2;
                                }
                                if (zVar.field_isExpand) {
                                    bVar2.KUH = 2;
                                } else if (a2.iAd.size() > 2) {
                                    bVar2.KUH = 1;
                                } else {
                                    bVar2.KUH = 0;
                                }
                                as Kn = ((l) g.af(l.class)).aSN().Kn(zVar.field_talker);
                                bVar2.nHh = (Kn == null || com.tencent.mm.contact.c.oR(Kn.field_type)) ? 0 : 2;
                                if (vVar.type == 5) {
                                    bVar2.psI = vVar.vid;
                                }
                            } else {
                                bVar.KUZ = (i11 != 0 || !zVar.NQj) ? 0 : 1;
                                if (zVar.NQk) {
                                    i5 = 1;
                                } else {
                                    i5 = 0;
                                }
                                bVar.KVa = i5;
                                bVar.KUG++;
                                bVar.pos = i2;
                                bVar.KUO = (int) (System.currentTimeMillis() / 1000);
                                a(bVar, zVar.field_talker);
                            }
                        }
                        i11++;
                    }
                    AppMethodBeat.o(5935);
                    return;
                } catch (UnsupportedOperationException e2) {
                    Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", e2.getMessage());
                    AppMethodBeat.o(5935);
                    return;
                } catch (Exception e3) {
                    Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", e3.getMessage());
                }
            }
            AppMethodBeat.o(5935);
        } else if (zVar.gAu()) {
            d(zVar, i2);
            AppMethodBeat.o(5935);
        } else if (zVar.gAv()) {
            if (zVar.gAv()) {
                b bVar3 = this.psu.get(zVar.getId());
                if (bVar3 == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    b bVar4 = new b();
                    this.psu.put(zVar.getId(), bVar4);
                    bVar4.KUC = zVar.field_talker;
                    a(bVar4, i2, zVar);
                    bVar4.ybm = f(zVar);
                    a(bVar4, zVar.field_talker);
                    bVar4.nHh = af.G(zVar);
                    String gAG = zVar.gAG();
                    bVar4.aid = gAG;
                    bVar4.traceid = zVar.getTraceId();
                    r rVar = r.NPl;
                    bVar4.KVi = r.biK(gAG) ? 1 : 0;
                    MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
                    if (!Util.isEqual(gAG, singleMMKV.decodeString("BizLastExposeAdAId"))) {
                        singleMMKV.encode("BizLastExposeAdTime", currentTimeMillis);
                        singleMMKV.encode("BizLastExposeAdAId", gAG);
                    }
                    com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(69);
                    com.tencent.mm.storage.p pVar = new com.tencent.mm.storage.p();
                    pVar.field_aId = zVar.gAG();
                    pVar.field_msgId = zVar.field_msgId;
                    pVar.field_exposeTime = currentTimeMillis;
                    ag.bao().a(pVar);
                    AppMethodBeat.o(5935);
                    return;
                }
                bVar3.KUG++;
                bVar3.pos = i2;
                bVar3.KUO = (int) (System.currentTimeMillis() / 1000);
                a(bVar3, zVar.field_talker);
            }
            AppMethodBeat.o(5935);
        } else if (zVar.gAs()) {
            e(zVar, i2);
            AppMethodBeat.o(5935);
        } else {
            b bVar5 = this.psu.get(zVar.getId());
            if (bVar5 == null) {
                b bVar6 = new b();
                this.psu.put(zVar.getId(), bVar6);
                bVar6.KUC = zVar.field_talker;
                bVar6.dFm = 0;
                a(bVar6, i2, zVar);
                bVar6.KUI = 0;
                bVar6.KUK = 0;
                bVar6.KUL = 0;
                bVar6.KTM = 0;
                bVar6.ybm = f(zVar);
                a(bVar6, zVar.field_talker);
                bVar6.KUZ = zVar.NQj ? 1 : 0;
                if (!zVar.NQk) {
                    i9 = 0;
                }
                bVar6.KVa = i9;
                as Kn2 = ((l) g.af(l.class)).aSN().Kn(zVar.field_talker);
                if (Kn2 != null && !com.tencent.mm.contact.c.oR(Kn2.field_type)) {
                    i10 = 3;
                }
                bVar6.nHh = i10;
                AppMethodBeat.o(5935);
                return;
            }
            bVar5.KUG++;
            bVar5.pos = i2;
            bVar5.KUO = (int) (System.currentTimeMillis() / 1000);
            a(bVar5, zVar.field_talker);
            if (zVar.NQj) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            bVar5.KUZ = i3;
            if (!zVar.NQk) {
                i9 = 0;
            }
            bVar5.KVa = i9;
            AppMethodBeat.o(5935);
        }
    }

    public final void e(z zVar) {
        AppMethodBeat.i(194919);
        if (zVar.field_isRead == 1) {
            AppMethodBeat.o(194919);
            return;
        }
        this.psv.put(zVar.getId(), Boolean.TRUE);
        aa ban = ag.ban();
        if (zVar.field_isRead != 1) {
            h.RTc.b(new Runnable(zVar) {
                /* class com.tencent.mm.storage.aa.AnonymousClass5 */
                final /* synthetic */ z peS;

                {
                    this.peS = r2;
                }

                public final void run() {
                    AppMethodBeat.i(212337);
                    this.peS.field_isRead = 1;
                    Log.d("MicroMsg.BizTimeLineInfoStorage", "updateUnReadStatus ret = %b", Boolean.valueOf(aa.this.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set isRead = 1 where msgId = " + this.peS.field_msgId)));
                    AppMethodBeat.o(212337);
                }
            }, "updateUnReadStatus");
        }
        AppMethodBeat.o(194919);
    }

    private void a(b bVar, int i2, z zVar) {
        int i3;
        b bVar2;
        int i4 = 0;
        AppMethodBeat.i(194920);
        bVar.KVo = System.currentTimeMillis();
        bVar.KUO = (int) (bVar.KVo / 1000);
        bVar.pos = i2;
        bVar.fQY = zVar.field_bizClientMsgId;
        bVar.KUG = 1;
        bVar.KUN = 0;
        bVar.KUP = (int) (zVar.field_createTime / 1000);
        if (zVar.gAs()) {
            i3 = 3;
            bVar2 = bVar;
        } else if (zVar.gAo() == ag.ban().gAS()) {
            i3 = 0;
            bVar2 = bVar;
        } else if (System.currentTimeMillis() - zVar.field_createTime <= Util.MILLSECONDS_OF_DAY) {
            i3 = 1;
            bVar2 = bVar;
        } else {
            i3 = 2;
            bVar2 = bVar;
        }
        bVar2.KUR = i3;
        if (!this.psv.containsKey(zVar.getId())) {
            i4 = 1;
        }
        bVar.KUX = i4;
        bVar.KVe = zVar.field_rankSessionId;
        bVar.weight = (int) zVar.gAp();
        AppMethodBeat.o(194920);
    }

    private void d(z zVar, int i2) {
        AppMethodBeat.i(194921);
        ege gAD = zVar.gAD();
        if (gAD != null && (gAD.style == 101 || gAD.style == 102 || gAD.style == 103)) {
            ale ale = gAD.Nga;
            if (ale == null || Util.isNullOrNil(ale.KUf)) {
                AppMethodBeat.o(194921);
                return;
            }
            boolean z = false;
            for (int i3 = 0; i3 < ale.KUf.size(); i3++) {
                if (ale.KUf.get(i3).KHa == 0) {
                    pi piVar = ale.KUf.get(i3).KWy.get(0);
                    b bVar = this.psu.get(zVar.getId() + "_" + i3);
                    if (bVar == null) {
                        b bVar2 = new b();
                        this.psu.put(zVar.getId() + "_" + i3, bVar2);
                        bVar2.KUC = ale.KUf.get(i3).UserName;
                        if (piVar != null && (piVar.KHa & 1) == 0) {
                            String str = piVar.KSj;
                            if (!Util.isNullOrNil(str)) {
                                try {
                                    Uri parse = Uri.parse(str);
                                    int i4 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                    long j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                                    bVar2.KUF.add(Integer.valueOf(i4));
                                    bVar2.dFm = j2;
                                    bVar2.KUT = j2;
                                } catch (Exception e2) {
                                }
                            }
                            bVar2.KVg = piVar.KWv;
                            bVar2.KVh = piVar.KWw;
                        }
                        a(bVar2, i2, zVar);
                        int i5 = 3;
                        if (gAD.style == 103) {
                            i5 = 7;
                        }
                        bVar2.nHh = i5;
                        if (piVar.xLi != null) {
                            bVar2.KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(piVar.xLi);
                        }
                        if (gAD != null) {
                            bVar2.KVb = gAD.MOC;
                        }
                        bVar2.KUU = i3;
                        if (piVar != null) {
                            bVar2.KIJ = piVar.iAb;
                        }
                        bVar2.style = zVar.NQn != null ? zVar.NQn.style : 0;
                        bVar2.event = zVar.NQn != null ? zVar.NQn.event : "";
                        if (!(zVar.NQn == null || zVar.NQn.Nga == null)) {
                            bVar2.eaO = zVar.NQn.Nga.KUk;
                            bVar2.KVf = zVar.NQn.Nga.KUo;
                        }
                        if (gAD.style == 102 || gAD.style == 103) {
                            bVar2.KVk = gAD.Nga.Luk;
                            bVar2.KVj = gAD.Nga.Luj;
                        }
                        bVar2.pTd = gAD.Nga.Lug;
                    } else {
                        bVar.KUG++;
                        bVar.pos = i2;
                        bVar.KUO = (int) (System.currentTimeMillis() / 1000);
                    }
                    if (!z && gAD.Nga != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21064, Long.valueOf(System.currentTimeMillis()), gAD.Nga.KUk, Long.valueOf(gAD.MOC), 3, 1, Integer.valueOf(gAD.style), gAD.Nga.KUo);
                    }
                    z = true;
                } else {
                    z = z;
                }
            }
            AppMethodBeat.o(194921);
        } else if (gAD == null || gAD.style != 1001 || gAD.Ngc == null) {
            efz gAC = zVar.gAC();
            if (gAC == null || gAC.KWy == null || gAC.KWy.size() <= 0) {
                Log.w("MicroMsg.BizTimeLineReport", "recCard is null");
                AppMethodBeat.o(194921);
                return;
            }
            int size = gAC.KWy.size();
            for (int i6 = 0; i6 < size; i6++) {
                ega ega = gAC.KWy.get(i6);
                b bVar3 = this.psu.get(zVar.getId() + "_" + i6);
                if (bVar3 == null) {
                    b bVar4 = new b();
                    this.psu.put(zVar.getId() + "_" + i6, bVar4);
                    bVar4.KUC = zVar.field_talker;
                    if (ega != null && (ega.KHa & 1) == 0) {
                        String str2 = gAC.KWy.get(i6).KSj;
                        if (!Util.isNullOrNil(str2)) {
                            try {
                                Uri parse2 = Uri.parse(str2);
                                int i7 = Util.getInt(parse2.getQueryParameter("idx"), 0);
                                long j3 = Util.getLong(parse2.getQueryParameter("mid"), 0);
                                bVar4.KUF.add(Integer.valueOf(i7));
                                bVar4.dFm = j3;
                                bVar4.KUT = j3;
                            } catch (Exception e3) {
                            }
                        }
                    }
                    if (ega != null) {
                        bVar4.KIJ = ega.iAb;
                    }
                    a(bVar4, i2, zVar);
                    bVar4.nHh = 1;
                    if (gAC.NfT != null) {
                        bVar4.KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(gAC.NfT.NfV);
                    }
                    if (gAD != null) {
                        bVar4.KVb = gAD.MOC;
                    }
                    bVar4.KUU = i6;
                    bVar4.style = zVar.NQn != null ? zVar.NQn.style : 0;
                    bVar4.pTd = gAC.Lug;
                } else {
                    bVar3.KUG++;
                    bVar3.pos = i2;
                    bVar3.KUO = (int) (System.currentTimeMillis() / 1000);
                }
            }
            AppMethodBeat.o(194921);
        } else {
            if (zVar.gAu()) {
                b bVar5 = this.psu.get(zVar.getId() + "_0");
                if (bVar5 == null) {
                    b bVar6 = new b();
                    this.psu.put(zVar.getId() + "_0", bVar6);
                    bVar6.KUp = gAD.dSJ;
                    a(bVar6, i2, zVar);
                    bVar6.nHh = 5;
                    if (gAD != null) {
                        bVar6.KVb = gAD.MOC;
                    }
                    bVar6.style = 1001;
                    com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(74);
                } else {
                    bVar5.KUG++;
                    bVar5.pos = i2;
                    bVar5.KUO = (int) (System.currentTimeMillis() / 1000);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = Long.valueOf(System.currentTimeMillis());
                objArr[1] = gAD.Ngc.cardId;
                objArr[2] = Long.valueOf(gAD.MOC);
                objArr[3] = 5;
                objArr[4] = 1;
                objArr[5] = Integer.valueOf(gAD.style);
                objArr[6] = gAD.Nga != null ? gAD.Nga.KUo : "";
                hVar.a(21064, objArr);
                Log.i("MicroMsg.BizTimeLineReport", "onExposeRecCanvasMsg %d", Long.valueOf(zVar.field_msgId));
            }
            AppMethodBeat.o(194921);
        }
    }

    private void e(z zVar, int i2) {
        AppMethodBeat.i(194922);
        if (!zVar.gAs() || zVar.NQr == null || Util.isNullOrNil(zVar.NQr.MOG)) {
            AppMethodBeat.o(194922);
            return;
        }
        dkr dkr = zVar.NQr;
        int size = dkr.MOG.size();
        for (int i3 = 0; i3 < size; i3++) {
            dlb dlb = dkr.MOG.get(i3);
            b bVar = this.psu.get(zVar.getId() + "_" + i3);
            if (bVar == null) {
                b bVar2 = new b();
                this.psu.put(zVar.getId() + "_" + i3, bVar2);
                a(bVar2, i2, zVar);
                bVar2.nHh = af.G(zVar);
                bVar2.KVp = zVar.NQm;
                bVar2.style = dkr.KUh;
                bVar2.KVh = dlb.KWw;
                bVar2.KIJ = dlb.MOY.iAb;
                bVar2.KUU = i3;
                bVar2.KUC = dlb.MOX.UserName;
                bVar2.eaO = dkr.KUk;
                String str = dlb.MOY.KSj;
                if (!Util.isNullOrNil(str)) {
                    try {
                        Uri parse = Uri.parse(str);
                        int i4 = Util.getInt(parse.getQueryParameter("idx"), 0);
                        long j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                        bVar2.KUF.add(Integer.valueOf(i4));
                        bVar2.dFm = j2;
                        bVar2.KUT = j2;
                    } catch (Exception e2) {
                    }
                }
                if (dkr.KUh == 2002) {
                    bVar2.KVk = dkr.Luk;
                    bVar2.KVj = dkr.Luj;
                } else {
                    bVar2.KVk = dlb.Luk;
                    bVar2.KVj = dlb.Luj;
                }
                if (dkr.KUh == 2002) {
                    bVar2.KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(dkr.MOI);
                } else if (dkr.KUh == 2001) {
                    bVar2.KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(dlb.MOI);
                    if (dlb.MOY.iAb == 5 && i3 == 0 && com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(dkr) && dlb.MOY.Mjm != null) {
                        bVar2.psI = dlb.MOY.Mjm.KSu;
                    }
                }
                bVar2.KUZ = (i3 != 0 || !com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(dkr)) ? 0 : 1;
                bVar2.pTd = dlb.MOX.oUJ;
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(74);
            } else {
                bVar.KUG++;
                bVar.pos = i2;
                bVar.KUO = (int) (System.currentTimeMillis() / 1000);
            }
        }
        AppMethodBeat.o(194922);
    }

    public static void a(ege ege) {
        AppMethodBeat.i(194923);
        if (ege.Nga != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21064, Long.valueOf(System.currentTimeMillis()), ege.Nga.KUk, Long.valueOf(ege.MOC), 3, 2, Integer.valueOf(ege.style), ege.Nga.KUo);
        }
        AppMethodBeat.o(194923);
    }

    public final void a(final z zVar, int i2, int i3) {
        AppMethodBeat.i(194924);
        if (zVar == null) {
            AppMethodBeat.o(194924);
            return;
        }
        final b bVar = this.psu.get(zVar.getId() + "_" + i2);
        if (bVar == null && this.pst != null) {
            c(zVar, i2);
            this.pst.cnl();
            bVar = this.psu.get(zVar.getId() + "_" + i2);
        }
        if (bVar != null) {
            bVar.KUY = 1;
            Log.d("MicroMsg.BizTimeLineReport", "onClick %d", Integer.valueOf(i2));
            com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.f.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(5930);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(bVar);
                    if (!Util.isNullOrNil(bVar.psI)) {
                        b bVar = bVar;
                        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                        bVar.KVl = MPVideoPreviewMgr.aiL(bVar.psI);
                        b bVar2 = bVar;
                        MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                        bVar2.KVm = MPVideoPreviewMgr.aiM(bVar.psI);
                    }
                    Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", zVar.getId());
                    g.aAg().hqi.a(new k(linkedList, f.this.psq, f.this.psr, f.this.dEb, f.this.pss, 1, 1), 0);
                    AppMethodBeat.o(5930);
                }
            }, 0);
        }
        if (!zVar.gAu() && !zVar.gAs()) {
            a(zVar, i2, 11, i3);
        }
        AppMethodBeat.o(194924);
    }

    public final void b(z zVar, int i2, int i3) {
        AppMethodBeat.i(194925);
        if (zVar.gAs() || zVar.gAu()) {
            b bVar = this.psu.get(zVar.getId() + "_" + i2);
            if (bVar == null) {
                Log.i("MicroMsg.BizTimeLineReport", "onClickTag fail sessionItem is null");
                AppMethodBeat.o(194925);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(bVar);
            if (!Util.isNullOrNil(bVar.psI)) {
                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                bVar.KVl = MPVideoPreviewMgr.aiL(bVar.psI);
                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                bVar.KVm = MPVideoPreviewMgr.aiM(bVar.psI);
            }
            Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", zVar.getId());
            g.aAg().hqi.a(new k(linkedList, this.psq, this.psr, this.dEb, this.pss, 1, 24 == i3 ? 2 : 3), 0);
            AppMethodBeat.o(194925);
            return;
        }
        AppMethodBeat.o(194925);
    }

    private static int f(z zVar) {
        AppMethodBeat.i(194926);
        if (zVar.isText()) {
            AppMethodBeat.o(194926);
            return 1;
        } else if (zVar.gAz()) {
            AppMethodBeat.o(194926);
            return 2;
        } else if (zVar.gAy()) {
            AppMethodBeat.o(194926);
            return 3;
        } else {
            AppMethodBeat.o(194926);
            return -1;
        }
    }

    private static void a(b bVar, String str) {
        AppMethodBeat.i(5936);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || !Kn.arE()) {
            bVar.KUM = 0;
            bVar.KUQ = 0;
            AppMethodBeat.o(5936);
            return;
        }
        bVar.KUM = 1;
        bVar.KUQ = 1;
        AppMethodBeat.o(5936);
    }

    public final void g(z zVar) {
        AppMethodBeat.i(194927);
        f(zVar, 1);
        AppMethodBeat.o(194927);
    }

    public final void h(z zVar) {
        AppMethodBeat.i(194928);
        f(zVar, 9);
        AppMethodBeat.o(194928);
    }

    public final void cmz() {
        AppMethodBeat.i(194929);
        Dg(5);
        AppMethodBeat.o(194929);
    }

    public final void a(z zVar, boolean z) {
        AppMethodBeat.i(5937);
        b bVar = this.psu.get(zVar.getId());
        if (bVar == null) {
            AppMethodBeat.o(5937);
            return;
        }
        bVar.KTM = z ? 1 : 2;
        AppMethodBeat.o(5937);
    }

    public final void f(z zVar, int i2) {
        AppMethodBeat.i(5938);
        a(zVar, 0, i2, -1);
        AppMethodBeat.o(5938);
    }

    private void a(final z zVar, final int i2, final int i3, final int i4) {
        AppMethodBeat.i(5939);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.f.AnonymousClass4 */

            public final void run() {
                int i2;
                int i3;
                long j2 = 0;
                AppMethodBeat.i(5933);
                if (zVar.gAt()) {
                    try {
                        u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(zVar.field_msgId, zVar.field_content);
                        if (a2 != null && !Util.isNullOrNil(a2.iAd)) {
                            v vVar = (v) a2.iAd.get(i2);
                            if (!Util.isNullOrNil(vVar.url)) {
                                Uri parse = Uri.parse(vVar.url);
                                j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                                i3 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                i2 = i3;
                                f.this.a(zVar.field_talker, j2, i2, i3, i4);
                                AppMethodBeat.o(5933);
                            }
                        }
                        i3 = 0;
                        i2 = i3;
                    } catch (UnsupportedOperationException e2) {
                        Log.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", e2.getMessage());
                        i2 = 0;
                    } catch (Exception e3) {
                        Log.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", e3.getMessage());
                    }
                    f.this.a(zVar.field_talker, j2, i2, i3, i4);
                    AppMethodBeat.o(5933);
                }
                i2 = 0;
                f.this.a(zVar.field_talker, j2, i2, i3, i4);
                AppMethodBeat.o(5933);
            }
        }, 0);
        AppMethodBeat.o(5939);
    }

    public final void Dg(int i2) {
        AppMethodBeat.i(5940);
        a("", 0, 0, i2, -1);
        AppMethodBeat.o(5940);
    }

    public final void a(String str, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(5941);
        a(str, j2, i2, i3, i4, 0L, false, 0);
        AppMethodBeat.o(5941);
    }

    public final void a(String str, long j2, int i2, int i3, int i4, long j3, boolean z, int i5) {
        AppMethodBeat.i(194930);
        if (i4 <= 0) {
            i4 = (int) (System.currentTimeMillis() / 1000);
        }
        int i6 = z ? 1 : 0;
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (!z && Kn != null && !com.tencent.mm.contact.c.oR(Kn.field_type)) {
            i6 = 3;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, str, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.dEb), Integer.valueOf(i2), Long.valueOf(j3), "", Integer.valueOf(i6), Integer.valueOf(i5));
        AppMethodBeat.o(194930);
    }

    public final void f(String str, long j2, String str2) {
        AppMethodBeat.i(194931);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, str, 0L, 17, Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.dEb), 0, Long.valueOf(j2), str2, 1, 0);
        AppMethodBeat.o(194931);
    }

    public final void a(String str, long j2, int i2, int i3, long j3, String str2, int i4, String str3, String str4, String str5, int i5, int i6, String str6) {
        AppMethodBeat.i(194932);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i7 = 3;
        if (i6 == 103) {
            i7 = 7;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, str, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.dEb), Integer.valueOf(i2), Long.valueOf(j3), str2, Integer.valueOf(i7), Integer.valueOf(i4), str3, str4, str5, Integer.valueOf(i5), Integer.valueOf(i6), str6);
        AppMethodBeat.o(194932);
    }

    public final void a(String str, long j2, int i2, String str2, String str3, int i3, String str4, int i4) {
        AppMethodBeat.i(194933);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, str, Long.valueOf(j2), 16, Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.dEb), Integer.valueOf(i2), 0L, str2, Integer.valueOf(i4), 0, "", "", str3, 0, Integer.valueOf(i3), str4);
        AppMethodBeat.o(194933);
    }

    public final void a(String str, long j2, int i2, int i3, long j3, String str2, String str3, String str4, String str5, int i4, String str6, String str7, String str8) {
        AppMethodBeat.i(194934);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i5 = 3;
        if (i4 == 103) {
            i5 = 7;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, str, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.dEb), Integer.valueOf(i2), Long.valueOf(j3), str2, Integer.valueOf(i5), 0, str3, str4, str5, 0, Integer.valueOf(i4), str6, str7, str8);
        AppMethodBeat.o(194934);
    }

    static class a {
        int dEb;
        String dVu;
        int msgType;
        int psE;
        int psF;
        int psG;
        int psH;

        private a() {
            this.psH = -1;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void l(int i2, String str, int i3) {
        AppMethodBeat.i(194935);
        if (this.psw == null) {
            this.psw = new a((byte) 0);
        }
        if (i3 == 0) {
            this.psw.psE++;
            this.psw.psH = 0;
        }
        if (this.psw.psF == 0) {
            this.psw.psF = (int) (System.currentTimeMillis() / 1000);
        }
        a aVar = this.psw;
        if (i2 == 0) {
            i2 = this.psw.msgType;
        }
        aVar.msgType = i2;
        this.psw.dEb = this.dEb;
        a aVar2 = this.psw;
        if ("".equals(str)) {
            str = this.psw.dVu;
        }
        aVar2.dVu = str;
        if (this.psw.psG != 1) {
            this.psw.psG = i3;
        }
        AppMethodBeat.o(194935);
    }
}
