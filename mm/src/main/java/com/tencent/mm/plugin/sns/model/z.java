package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.e.c;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ewq;
import com.tencent.mm.protocal.protobuf.fbc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class z extends q implements m, b {
    private static Vector<String> DIh = new Vector<>();
    private long DIK = 0;
    private String DIL = "";
    public boolean DIe;
    long DIf = 0;
    long DIg = 0;
    public int DIi = 0;
    public int DIj = 0;
    private long DJd = 0;
    private final long DJe = 102400;
    private boolean DJf = false;
    private boolean DJg = false;
    private boolean DJh = false;
    private w DJi = null;
    public int akb = 0;
    public i callback;
    private boolean jiQ = false;
    public int pullType = 0;
    d rr;
    final int sourceType;

    static {
        AppMethodBeat.i(95670);
        AppMethodBeat.o(95670);
    }

    public static synchronized boolean aPa(String str) {
        boolean z;
        synchronized (z.class) {
            AppMethodBeat.i(95662);
            if (DIh.contains(str)) {
                z = false;
                AppMethodBeat.o(95662);
            } else {
                DIh.add(str);
                z = true;
                AppMethodBeat.o(95662);
            }
        }
        return z;
    }

    public static synchronized boolean aPb(String str) {
        synchronized (z.class) {
            AppMethodBeat.i(95663);
            DIh.remove(str);
            AppMethodBeat.o(95663);
        }
        return true;
    }

    public z(long j2, long j3, int i2) {
        int i3;
        long j4;
        long j5;
        AppMethodBeat.i(179086);
        long currentTimeMillis = System.currentTimeMillis();
        d.a aVar = new d.a();
        aVar.iLN = new ebd();
        aVar.iLO = new ebe();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.funcId = 211;
        aVar.iLP = 98;
        aVar.respCmdId = 1000000098;
        this.rr = aVar.aXF();
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i3 = 1;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i3 = 3;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            i3 = 4;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            i3 = 2;
        } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            i3 = 5;
        } else {
            i3 = 0;
        }
        this.DIf = j2;
        this.DIe = j2 == 0 && j3 == 0;
        this.sourceType = 2;
        ebd ebd = (ebd) this.rr.iLK.iLR;
        ebd.MYL = i3;
        ebd.MZh = j2;
        int fbw = aj.faE().fbw();
        n faO = aj.faO();
        if (this.DIe) {
            j4 = 0;
        } else {
            j4 = j2;
        }
        this.DIg = faO.g(j4, fbw, true);
        ebd.Nau = this.DIg;
        int a2 = d.a(this.DIg, j2, "@__weixintimtline");
        ebd.Nav = a2;
        ebd.NaB = j3;
        if (this.DIe) {
            aw faZ = aj.faZ();
            j5 = faZ.DNM;
            if (faZ.DNJ != null && !Util.isNullOrNil(faZ.DNJ.DRY)) {
                Iterator<l> it = faZ.DNJ.DRY.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    l next = it.next();
                    if (!Util.isNullOrNil(next.tbl)) {
                        j5 = next.tbl.peekLast().longValue() - 1;
                        break;
                    }
                }
            }
        } else {
            j5 = 0;
        }
        ebd.NaC = j5;
        ebd.NaA = i2 == 1 ? 1 : 0;
        w wVar = null;
        Cursor rawQuery = aj.faW().iFy.rawQuery("select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + x.EmU + " order by SnsWsFoldGroup.top desc limit 1", null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                wVar = new w();
                wVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        this.DJi = wVar;
        if (this.DJi == null) {
            ebd.NaD = 0;
            ebd.NaF = 0;
        } else {
            Log.i("MicroMsg.NetSceneSnsTimeLine", "firstFinishWsGroup.size:%s, firstFinishWsGroup.top:%s, firstFinishWsGroup.bottom:%s", Integer.valueOf(this.DJi.field_size), r.Jc(this.DJi.field_top), r.Jc(this.DJi.field_bottom));
            ebd.NaD = this.DJi.field_top;
            ebd.NaF = this.DJi.field_top;
        }
        ebd.NaE = ah.DKg;
        this.pullType = i2;
        com.tencent.mm.plugin.sns.storage.l aQr = aj.faS().aQr("@__weixintimtline");
        if (this.DIe) {
            this.DIK = aj.faO().g(0L, 1, true);
            Log.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.DIK);
            ebd.Naw = this.DIK;
            this.DIL = aQr == null ? "" : aQr.field_md5;
            if (this.DIL == null) {
                this.DIL = "";
            }
            ebd.MZg = this.DIL;
        }
        long a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_session_size, 102400L);
        if (aQr == null || aQr.field_adsession == null || ((long) aQr.field_adsession.length) > a3) {
            ebd.MYJ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            Log.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", aQr.field_adsession);
            ebd.MYJ = new SKBuiltinBuffer_t().setBuffer(aQr.field_adsession);
        }
        this.DJd = j2;
        Log.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + fbw + " max:" + j2 + " min:" + this.DIg + " ReqTime:" + ebd.Nav + " nettype: " + i3 + " MinIdForCheckUnread:" + ebd.NaC + " pullType:" + i2 + " minIdForPrePage:" + j3 + " NearbyFoldId:" + ebd.NaD + " FoldSectionSize：" + ah.DKg);
        Log.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", r.Jb(j2), r.Jb(this.DIg), Integer.valueOf(a2));
        Log.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(179086);
    }

    private void faj() {
        AppMethodBeat.i(95665);
        n faO = aj.faO();
        Cursor rawQuery = faO.iFy.rawQuery(n.feW(), null, 2);
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2++;
        }
        rawQuery.close();
        if (i2 >= 3 || i2 <= 0) {
            if (i2 == 0) {
                this.DJf = true;
            }
            AppMethodBeat.o(95665);
            return;
        }
        this.DJg = true;
        AppMethodBeat.o(95665);
    }

    private void a(ebe ebe, String str) {
        SnsInfo JJ;
        AppMethodBeat.i(95666);
        an.a("@__weixintimtline", this.sourceType, ebe.KOH, str);
        this.DIg = ebe.KOH.getLast().Id;
        if (this.DIf == 0) {
            this.DIf = ebe.KOH.getFirst().Id;
        } else {
            this.DIf = d.Jf(this.DIf);
        }
        d.f("@__weixintimtline", this.DIf, this.DIg, ebe.NaG);
        try {
            Iterator<SnsObject> it = ebe.KOH.iterator();
            while (it.hasNext()) {
                SnsObject next = it.next();
                if (next.NoChange == 0 && (JJ = aj.faO().JJ(next.Id)) != null && JJ.getTimeLine() != null && JJ.getTypeFlag() == 15) {
                    try {
                        h.INSTANCE.a(14388, Long.valueOf(next.Id), 4, JJ.getTimeLine().ContentObj.LoV.get(0).Url, 0);
                    } catch (Exception e2) {
                    }
                }
            }
            AppMethodBeat.o(95666);
        } catch (Exception e3) {
            AppMethodBeat.o(95666);
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95667);
        Log.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        ebe ebe = (ebe) ((d) sVar).iLL.iLR;
        if (sVar.getRespObj().getRetCode() == 207 || sVar.getRespObj().getRetCode() == 0) {
            MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVDeleteTable", false);
            if (this.DIe) {
                if (ebe != null) {
                    Log.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", Integer.valueOf(ebe.NaP.size()), Integer.valueOf(ebe.KOH.size()));
                    aj.dRd().post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bb: INVOKE  
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x00b2: INVOKE  (r5v6 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.dRd():com.tencent.mm.sdk.platformtools.MMHandler)
                          (wrap: com.tencent.mm.plugin.sns.model.aw$2 : 0x00b8: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.sns.model.aw$2) = 
                          (wrap: com.tencent.mm.plugin.sns.model.aw : 0x00a8: INVOKE  (r1v25 com.tencent.mm.plugin.sns.model.aw) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.faZ():com.tencent.mm.plugin.sns.model.aw)
                          (wrap: java.util.LinkedList<java.lang.Long> : 0x00ac: IGET  (r2v12 java.util.LinkedList<java.lang.Long>) = (r0v6 'ebe' com.tencent.mm.protocal.protobuf.ebe) com.tencent.mm.protocal.protobuf.ebe.NaP java.util.LinkedList)
                          (wrap: java.util.LinkedList<com.tencent.mm.protocal.protobuf.SnsObject> : 0x00ae: IGET  (r3v3 java.util.LinkedList<com.tencent.mm.protocal.protobuf.SnsObject>) = (r0v6 'ebe' com.tencent.mm.protocal.protobuf.ebe) com.tencent.mm.protocal.protobuf.ebe.KOH java.util.LinkedList)
                          (wrap: java.util.LinkedList<java.lang.Integer> : 0x00b0: IGET  (r4v2 java.util.LinkedList<java.lang.Integer>) = (r0v6 'ebe' com.tencent.mm.protocal.protobuf.ebe) com.tencent.mm.protocal.protobuf.ebe.NaQ java.util.LinkedList)
                         call: com.tencent.mm.plugin.sns.model.aw.2.<init>(com.tencent.mm.plugin.sns.model.aw, java.util.LinkedList, java.util.LinkedList, java.util.LinkedList):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.sns.model.z.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b8: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.sns.model.aw$2) = 
                          (wrap: com.tencent.mm.plugin.sns.model.aw : 0x00a8: INVOKE  (r1v25 com.tencent.mm.plugin.sns.model.aw) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.faZ():com.tencent.mm.plugin.sns.model.aw)
                          (wrap: java.util.LinkedList<java.lang.Long> : 0x00ac: IGET  (r2v12 java.util.LinkedList<java.lang.Long>) = (r0v6 'ebe' com.tencent.mm.protocal.protobuf.ebe) com.tencent.mm.protocal.protobuf.ebe.NaP java.util.LinkedList)
                          (wrap: java.util.LinkedList<com.tencent.mm.protocal.protobuf.SnsObject> : 0x00ae: IGET  (r3v3 java.util.LinkedList<com.tencent.mm.protocal.protobuf.SnsObject>) = (r0v6 'ebe' com.tencent.mm.protocal.protobuf.ebe) com.tencent.mm.protocal.protobuf.ebe.KOH java.util.LinkedList)
                          (wrap: java.util.LinkedList<java.lang.Integer> : 0x00b0: IGET  (r4v2 java.util.LinkedList<java.lang.Integer>) = (r0v6 'ebe' com.tencent.mm.protocal.protobuf.ebe) com.tencent.mm.protocal.protobuf.ebe.NaQ java.util.LinkedList)
                         call: com.tencent.mm.plugin.sns.model.aw.2.<init>(com.tencent.mm.plugin.sns.model.aw, java.util.LinkedList, java.util.LinkedList, java.util.LinkedList):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.model.z.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.model.aw, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 313
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.z.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
                }

                private static void a(ebe ebe) {
                    AppMethodBeat.i(202728);
                    if (ebe != null) {
                        if (!Util.isNullOrNil(ebe.KOH)) {
                            ArrayList<Long> arrayList = new ArrayList();
                            Iterator<SnsObject> it = ebe.KOH.iterator();
                            while (it.hasNext()) {
                                SnsObject next = it.next();
                                if (next != null && an.YA(next.ExtFlag)) {
                                    arrayList.add(Long.valueOf(next.Id));
                                }
                            }
                            for (Long l : arrayList) {
                                aj.faX().JO(l.longValue());
                            }
                        }
                        try {
                            fbc fbc = new fbc();
                            fbc.parseFrom(com.tencent.mm.platformtools.z.a(ebe.NaR));
                            if (!Util.isNullOrNil(fbc.Nxs)) {
                                int size = fbc.Nxs.size() / ah.DKg;
                                Log.i("MicroMsg.NetSceneSnsTimeLine", "wsInfo.timeline_idx.size:%s, SnsConfig.wsFoldGroupSize:%s, tmp:%s", Integer.valueOf(fbc.Nxs.size()), Integer.valueOf(ah.DKg), Integer.valueOf(size));
                                if (size == 0) {
                                    w wVar = new w();
                                    wVar.field_top = fbc.Nxs.getFirst().MuD;
                                    wVar.field_bottom = fbc.Nxs.getLast().MuD;
                                    wVar.field_size = fbc.Nxs.size();
                                    if (wVar.field_size == ah.DKg) {
                                        Log.i("MicroMsg.NetSceneSnsTimeLine", "insert topId:%s, bottomId:%s", r.Jc(wVar.field_top), r.Jc(wVar.field_bottom));
                                        aj.faW().a(wVar);
                                    } else {
                                        Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, field_size:%s", Integer.valueOf(wVar.field_size));
                                    }
                                } else if (size > 0) {
                                    for (int i2 = 0; i2 < size; i2++) {
                                        int size2 = (fbc.Nxs.size() - 1) - (ah.DKg * i2);
                                        int i3 = (size2 - ah.DKg) + 1;
                                        int i4 = i3 < 0 ? 0 : i3;
                                        w wVar2 = new w();
                                        wVar2.field_top = fbc.Nxs.get(i4).MuD;
                                        wVar2.field_bottom = fbc.Nxs.get(size2).MuD;
                                        wVar2.field_size = (size2 - i4) + 1;
                                        if (wVar2.field_size == ah.DKg) {
                                            Log.i("MicroMsg.NetSceneSnsTimeLine", "insert index:%s, topIndex:%s, bottomIndex:%s, topId:%s, bottomId:%s", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(size2), r.Jc(wVar2.field_top), r.Jc(wVar2.field_bottom));
                                            aj.faW().a(wVar2);
                                        } else {
                                            Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, index:%s, topIndex:%s, bottomIndex:%s, field_size:%s", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(size2), Integer.valueOf(wVar2.field_size));
                                        }
                                    }
                                }
                            }
                            if (!Util.isNullOrNil(fbc.Ltx)) {
                                Iterator<ewq> it2 = fbc.Ltx.iterator();
                                while (it2.hasNext()) {
                                    ewq next2 = it2.next();
                                    if (!(next2 == null || Util.isNullOrNil(next2.KOJ) || next2.Nul == null)) {
                                        long j2 = next2.Nuj;
                                        int i5 = next2.Nuk;
                                        new SnsObject().parseFrom(next2.Nul.toByteArray());
                                        ebn ebn = new ebn();
                                        ebn.Nbk.addAll(next2.KOJ);
                                        ebn.Nbl = com.tencent.mm.modelsns.n.PM(new String(next2.Nul.ObjectDesc.getBuffer().toByteArray())).ContentDesc;
                                        u uVar = new u();
                                        uVar.field_groupId = j2;
                                        uVar.field_groupTime = i5;
                                        uVar.field_groupStrcut = ebn.toByteArray();
                                        aj.faX().a(uVar);
                                        LinkedList linkedList = new LinkedList();
                                        linkedList.add(next2.Nul);
                                        an.a("@__weixintimtline", 128, linkedList, r.Jc(next2.Nul.Id));
                                    }
                                }
                            }
                            AppMethodBeat.o(202728);
                            return;
                        } catch (Exception e2) {
                            Log.w("MicroMsg.NetSceneSnsTimeLine", "parse WSInfo err: %s", e2.getMessage());
                        }
                    }
                    AppMethodBeat.o(202728);
                }

                private void a(int i2, int i3, String str, ebe ebe) {
                    AppMethodBeat.i(202729);
                    if (ebe.KOH.size() == 0) {
                        aPb("@__weixintimtline");
                        this.callback.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(202729);
                        return;
                    }
                    Iterator<SnsObject> it = ebe.KOH.iterator();
                    while (it.hasNext()) {
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", Long.valueOf(it.next().Id));
                    }
                    a(ebe, r.Jc(this.DIf));
                    aPb("@__weixintimtline");
                    this.callback.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(202729);
                }

                private void b(int i2, int i3, String str, ebe ebe) {
                    int size;
                    AppMethodBeat.i(179087);
                    if (ebe.MZl != null) {
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + ebe.MZl.Naq + " " + ebe.MZl.Nap);
                        int i4 = ebe.MZl.Naq;
                        a.DCT = i4;
                        if (i4 <= 0) {
                            a.DCT = Integer.MAX_VALUE;
                        }
                        aq.NSd = ebe.MZl.Nap;
                    }
                    this.DIi = ebe.MZk;
                    this.DIj = ebe.xuw;
                    Log.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + ebe.MZk + " , objCount:  " + ebe.MvM + " cflag : " + ebe.xuw);
                    this.akb = ebe.MvM;
                    String Jc = r.Jc(this.DIf);
                    if (!ebe.KOH.isEmpty()) {
                        StringBuilder append = new StringBuilder("respone size ").append(ebe.KOH.size()).append(" Max ").append(ebe.KOH.getFirst().Id).append(" ").append(r.Jb(ebe.KOH.getFirst().Id)).append("  respone min  ").append(ebe.KOH.getLast().Id).append(" ").append(r.Jb(ebe.KOH.getLast().Id)).append(" adCount=");
                        if (ebe.NaI == null) {
                            size = 0;
                        } else {
                            size = ebe.NaI.size();
                        }
                        Log.i("MicroMsg.NetSceneSnsTimeLine", append.append(size).toString());
                    } else {
                        Log.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty, adCount=" + (ebe.NaI == null ? 0 : ebe.NaI.size()));
                    }
                    c.c(ebe.NaM, ebe.NaL, 0);
                    if (this.DIL.equals(ebe.MZg)) {
                        this.DIg = aj.faO().g(this.DIe ? 0 : this.DJd, this.DIi, true);
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.DIg));
                        faj();
                        aPb("@__weixintimtline");
                        this.callback.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(179087);
                        return;
                    }
                    aj.faS().g("@__weixintimtline", ebe.MZg, com.tencent.mm.platformtools.z.a(ebe.MYJ));
                    Log.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + ebe.KOH.size() + " adsize : " + ebe.NaH);
                    for (int i5 = 0; i5 < ebe.NaI.size(); i5++) {
                        ds dsVar = ebe.NaI.get(i5);
                        if (this.jiQ) {
                            String str2 = aj.getAccPath() + "ad.proto";
                            try {
                                byte[] byteArray = dsVar.toByteArray();
                                com.tencent.mm.vfs.s.f(str2, byteArray, byteArray.length);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e2.getMessage());
                            }
                        }
                        String a2 = com.tencent.mm.platformtools.z.a(dsVar.KHH);
                        String a3 = com.tencent.mm.platformtools.z.a(dsVar.KHG.MYI);
                        String b2 = com.tencent.mm.platformtools.z.b(dsVar.KHG.MYH.ObjectDesc);
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(a2)));
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(a3)));
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b2 + APLogFileUtil.SEPARATOR_LINE);
                        long j2 = 0;
                        try {
                            if (!Util.isNullOrNil(a2, a3)) {
                                if (!(dsVar.KHG == null || dsVar.KHG.MYH == null)) {
                                    j2 = Util.nullAsNil(Long.valueOf(dsVar.KHG.MYH.Id));
                                }
                                com.tencent.mm.plugin.sns.data.i.d(j2, a2, a3);
                            }
                        } catch (Throwable th) {
                            Log.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + th.toString());
                        }
                        final String str3 = dsVar.KHG.MYH.Username;
                        if (!Util.isNullOrNil(str3)) {
                            boolean aOd = k.aOd(a3);
                            Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:" + str3 + ", isUsePreferedInfo=" + aOd + ", snsId=" + r.Jc(j2));
                            if (!aOd) {
                                ay.a.iDq.aL(str3, "");
                                com.tencent.f.h.RTc.o(new Runnable() {
                                    /* class com.tencent.mm.plugin.sns.model.z.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(95661);
                                        Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + str3);
                                        com.tencent.mm.aj.c.Mf(str3);
                                        p.aYD().Mh(str3);
                                        AppMethodBeat.o(95661);
                                    }
                                }, 10000);
                            }
                        }
                        e.a(dsVar);
                    }
                    if (this.jiQ && ebe.NaI.size() == 0) {
                        try {
                            byte[] aW = com.tencent.mm.vfs.s.aW(aj.getAccPath() + "ad.proto", 0, -1);
                            ds dsVar2 = new ds();
                            dsVar2.parseFrom(aW);
                            ebe.NaI.add(dsVar2);
                            ebe.NaH = ebe.NaI.size();
                            Log.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + ebe.NaH);
                            if (ebe.NaI.size() > 0) {
                                ds dsVar3 = ebe.NaI.get(0);
                                String a4 = com.tencent.mm.platformtools.z.a(dsVar3.KHH);
                                String a5 = com.tencent.mm.platformtools.z.a(dsVar3.KHG.MYI);
                                String b3 = com.tencent.mm.platformtools.z.b(dsVar3.KHG.MYH.ObjectDesc);
                                Log.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(a4)));
                                Log.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(a5)));
                                Log.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b3 + APLogFileUtil.SEPARATOR_LINE);
                                c(dsVar3);
                            }
                        } catch (Exception e3) {
                            Log.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e3.getMessage());
                        }
                    }
                    a.a(ebe.NaI, ebe.KOH, this.DIe, this.pullType);
                    j.d(ebe.NaI, false);
                    if (ebe.NaH == 0) {
                        Log.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", Integer.valueOf(ebe.NaJ));
                        a.e(ebe.NaK, ebe.KOH);
                        a.bo(ebe.NaK);
                    }
                    if (!this.DIe) {
                        Log.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + ebe.KOH.size());
                        if (ebe.KOH.isEmpty()) {
                            aj.faO().aQt(Jc);
                            this.DJf = true;
                            this.DIg = this.DIf;
                        } else {
                            a(ebe, Jc);
                        }
                        aPb("@__weixintimtline");
                        this.callback.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(179087);
                        return;
                    }
                    LinkedList<Long> linkedList = new LinkedList<>();
                    Iterator<SnsObject> it = ebe.KOH.iterator();
                    while (it.hasNext()) {
                        linkedList.add(Long.valueOf(it.next().Id));
                    }
                    wh whVar = new wh();
                    whVar.ecr.ecs = linkedList;
                    EventCenter.instance.publish(whVar);
                    if (this.rr.iLL.getRetCode() == 207) {
                        if (ebe.KOH.isEmpty()) {
                            aj.faO().feP();
                            this.DIg = this.DIf;
                        } else {
                            aj.faO().aQu(r.Jc(ebe.KOH.getFirst().Id));
                            aj.faO().aQt(r.Jc(ebe.KOH.getLast().Id));
                            a(ebe, Jc);
                            j.br(ebe.KOH);
                        }
                        this.DJf = true;
                        aPb("@__weixintimtline");
                        this.callback.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(179087);
                        return;
                    }
                    if (ebe.KOH.isEmpty()) {
                        aj.faO().feP();
                        this.DIg = this.DIf;
                        this.DJf = true;
                    } else {
                        a(ebe, Jc);
                        j.br(ebe.KOH);
                    }
                    aPb("@__weixintimtline");
                    this.callback.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(179087);
                }

                private static boolean c(ds dsVar) {
                    AppMethodBeat.i(95668);
                    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                        AppMethodBeat.o(95668);
                        return false;
                    }
                    try {
                        com.tencent.mm.modelsns.n.PM(com.tencent.mm.platformtools.z.b(dsVar.KHG.MYH.ObjectDesc));
                        aj.faJ();
                        AppMethodBeat.o(95668);
                        return true;
                    } catch (Exception e2) {
                        AppMethodBeat.o(95668);
                        return false;
                    }
                }

                public final boolean fak() {
                    return this.pullType == 2;
                }

                @Override // com.tencent.mm.ak.q
                public final int getType() {
                    return 211;
                }

                @Override // com.tencent.mm.ak.q
                public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
                    AppMethodBeat.i(95669);
                    this.callback = iVar;
                    ebd ebd = (ebd) this.rr.iLK.iLR;
                    LinkedList<Long> fcv = com.tencent.mm.plugin.sns.k.e.DUQ.fcv();
                    if (fcv == null || fcv.isEmpty()) {
                        ebd.Nax = 0;
                    } else {
                        ebd.Nay = fcv;
                        ebd.Nax = ebd.Nay.size();
                        Log.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", fcv);
                    }
                    ebd.Naz = g.aAh().azQ().getInt(ar.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, 0);
                    g.aAh().azQ().set(ar.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, (Object) 0);
                    Log.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", Integer.valueOf(ebd.Nax), Integer.valueOf(ebd.Naz));
                    int dispatch = dispatch(gVar, this.rr, this);
                    AppMethodBeat.o(95669);
                    return dispatch;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final String getUserName() {
                    return "@__weixintimtline";
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eYW() {
                    return this.DIe;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eYX() {
                    return this.pullType == 1;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final int eYY() {
                    return -1;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eYZ() {
                    return false;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eZa() {
                    return this.DJf;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eZb() {
                    return this.DJg;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eZc() {
                    return false;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final long eZd() {
                    return this.DIg;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eZe() {
                    return false;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final long eZf() {
                    return 0;
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final String eZg() {
                    return "";
                }

                @Override // com.tencent.mm.plugin.sns.b.b
                public final boolean eZh() {
                    return this.DJh;
                }
            }
