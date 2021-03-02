package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private long ofk = 0;
    private long ofl = 0;
    private long ofm = 0;
    private boolean ofn = false;
    private HashMap<String, akf> ofo = new HashMap<>();
    private LinkedList<aap> ofp = new LinkedList<>();
    private HashMap<String, aap> ofq = new HashMap<>();

    public h() {
        AppMethodBeat.i(49300);
        AppMethodBeat.o(49300);
    }

    public final void bYX() {
        AppMethodBeat.i(49301);
        bYY();
        AppMethodBeat.o(49301);
    }

    private void bYY() {
        AppMethodBeat.i(49302);
        this.ofl = Util.nowSecond();
        this.ofk = this.ofl;
        this.ofn = false;
        this.ofo.clear();
        this.ofp.clear();
        this.ofq.clear();
        this.ofm = 0;
        AppMethodBeat.o(49302);
    }

    public final void bYZ() {
        AppMethodBeat.i(49303);
        this.ofl = Util.nowSecond();
        AppMethodBeat.o(49303);
    }

    public final void bZa() {
        AppMethodBeat.i(49304);
        this.ofm = (Util.nowSecond() - this.ofl) + this.ofm;
        this.ofl = Util.nowSecond();
        AppMethodBeat.o(49304);
    }

    public final void iU(boolean z) {
        this.ofn = z;
    }

    private LinkedList<akf> bZb() {
        AppMethodBeat.i(49305);
        LinkedList<akf> linkedList = new LinkedList<>();
        for (String str : this.ofo.keySet()) {
            linkedList.add(this.ofo.get(str));
        }
        Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", Integer.valueOf(this.ofo.size()));
        AppMethodBeat.o(49305);
        return linkedList;
    }

    public final void Br(long j2) {
        int i2;
        boolean z;
        long j3 = 86400;
        AppMethodBeat.i(49306);
        if (this.ofp.size() == 0) {
            if (this.ofo.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Log.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
                AppMethodBeat.o(49306);
                return;
            }
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
        long nowSecond = Util.nowSecond() - this.ofl;
        if (nowSecond < 86400) {
            j3 = this.ofm + nowSecond;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.ofp);
        LinkedList<akf> bZb = bZb();
        if (this.ofn) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", Long.valueOf(j2), Integer.valueOf(this.ofp.size()), Integer.valueOf(bZb.size()), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(this.ofk));
        a(this.ofp, bZb);
        int i3 = (int) this.ofk;
        Log.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
        f.bZn().postToWorker(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b0: INVOKE  
              (wrap: com.tencent.mm.plugin.appbrand.ac.m$a : 0x00a6: INVOKE  (r0v6 com.tencent.mm.plugin.appbrand.ac.m$a) =  type: STATIC call: com.tencent.mm.plugin.appbrand.utils.f.bZn():com.tencent.mm.plugin.appbrand.ac.m$a)
              (wrap: com.tencent.mm.plugin.appbrand.appusage.a.f$1 : 0x00ad: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.appbrand.appusage.a.f$1) = 
              (r14v0 'j2' long)
              (r4v6 'bZb' java.util.LinkedList<com.tencent.mm.protocal.protobuf.akf>)
              (r5v1 'linkedList' java.util.LinkedList)
              (r6v4 'i2' int)
              (wrap: int : 0x0099: CAST (r7v1 int) = (int) (r0v3 'j3' long))
              (r8v1 'i3' int)
             call: com.tencent.mm.plugin.appbrand.appusage.a.f.1.<init>(long, java.util.LinkedList, java.util.LinkedList, int, int, int):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.ac.m.a.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.ui.recommend.h.Br(long):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ad: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.appbrand.appusage.a.f$1) = 
              (r14v0 'j2' long)
              (r4v6 'bZb' java.util.LinkedList<com.tencent.mm.protocal.protobuf.akf>)
              (r5v1 'linkedList' java.util.LinkedList)
              (r6v4 'i2' int)
              (wrap: int : 0x0099: CAST (r7v1 int) = (int) (r0v3 'j3' long))
              (r8v1 'i3' int)
             call: com.tencent.mm.plugin.appbrand.appusage.a.f.1.<init>(long, java.util.LinkedList, java.util.LinkedList, int, int, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.ui.recommend.h.Br(long):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.appusage.a.f, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.recommend.h.Br(long):void");
    }

    private static void a(LinkedList<aap> linkedList, LinkedList<akf> linkedList2) {
        AppMethodBeat.i(49307);
        if (linkedList.size() > 0) {
            Iterator<aap> it = linkedList.iterator();
            while (it.hasNext()) {
                aap next = it.next();
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                sb.append("username:").append(next.username).append(",");
                sb.append("recommend_id:").append(next.nHd).append(",");
                sb.append("item_count:").append(next.LlU).append(",");
                sb.append("footnote_count:").append(next.LlV).append(",");
                sb.append("strategy_info:").append(next.nHe).append(",");
                sb.append("appid:").append(next.dNI).append(",");
                sb.append("page_path:").append(next.nHf).append(",");
                sb.append("page_param:").append(next.nHg).append(",");
                sb.append("card_type:").append(next.nHh).append(",");
                sb.append("pass_str:").append(next.nHi).append(",");
                sb.append("},");
                Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", sb.toString());
            }
        }
        if (linkedList2.size() > 0) {
            Iterator<akf> it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                akf next2 = it2.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("{");
                sb2.append("username:").append(next2.username).append(",");
                sb2.append("recommend_id:").append(next2.nHd).append(",");
                sb2.append("count:").append(next2.count).append(",");
                sb2.append("strategy_info:").append(next2.nHe).append(",");
                sb2.append("expose_millisecond:").append(next2.Ltp).append(",");
                sb2.append("appid:").append(next2.dNI).append(",");
                sb2.append("page_path:").append(next2.nHf).append(",");
                sb2.append("page_param:").append(next2.nHg).append(",");
                sb2.append("card_type:").append(next2.nHh).append(",");
                sb2.append("pass_str:").append(next2.nHi).append(",");
                sb2.append("},");
                Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", sb2.toString());
            }
        }
        AppMethodBeat.o(49307);
    }

    public final void a(int i2, dko dko) {
        AppMethodBeat.i(49308);
        if (dko == null) {
            AppMethodBeat.o(49308);
            return;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", Integer.valueOf(i2), dko.gTT, dko.MOA, Integer.valueOf(dko.nHh), dko.nHd);
        if (this.ofq.containsKey(dko.nHd)) {
            this.ofq.get(dko.nHd).LlU++;
            AppMethodBeat.o(49308);
            return;
        }
        aap c2 = c(i2, dko);
        c2.LlU = 1;
        c2.LlV = 0;
        this.ofq.put(dko.nHd, c2);
        this.ofp.add(c2);
        AppMethodBeat.o(49308);
    }

    public final void b(int i2, dko dko) {
        AppMethodBeat.i(49309);
        if (dko == null) {
            AppMethodBeat.o(49309);
            return;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", Integer.valueOf(i2), dko.gTT, dko.MOA, Integer.valueOf(dko.nHh), dko.nHd);
        if (this.ofq.containsKey(dko.nHd)) {
            this.ofq.get(dko.nHd).LlV++;
            AppMethodBeat.o(49309);
            return;
        }
        aap c2 = c(i2, dko);
        c2.LlU = 0;
        c2.LlV = 1;
        this.ofq.put(dko.nHd, c2);
        this.ofp.add(c2);
        AppMethodBeat.o(49309);
    }

    private static aap c(int i2, dko dko) {
        AppMethodBeat.i(49310);
        aap aap = new aap();
        aap.username = dko.gTT;
        aap.nHd = dko.nHd;
        aap.nHe = dko.nHe;
        aap.nHf = dko.nHf;
        aap.nHg = dko.nHg;
        aap.nHh = dko.nHh;
        aap.nHi = dko.nHi;
        aap.position = i2 + 1;
        WxaAttributes d2 = n.buC().d(dko.gTT, new String[0]);
        if (d2 != null) {
            aap.dNI = d2.field_appId;
        }
        AppMethodBeat.o(49310);
        return aap;
    }

    public final void W(String str, long j2) {
        AppMethodBeat.i(49312);
        if (this.ofo.containsKey(str)) {
            akf akf = this.ofo.get(str);
            akf.Ltp = (int) (((long) akf.Ltp) + j2);
            this.ofo.put(str, akf);
        }
        AppMethodBeat.o(49312);
    }

    public final void d(int i2, dko dko) {
        AppMethodBeat.i(49311);
        if (this.ofo.containsKey(dko.nHd)) {
            akf akf = this.ofo.get(dko.nHd);
            akf.count++;
            this.ofo.put(dko.nHd, akf);
            AppMethodBeat.o(49311);
            return;
        }
        akf akf2 = new akf();
        akf2.username = dko.gTT;
        akf2.count = 1;
        akf2.nHd = dko.nHd;
        akf2.nHe = dko.nHe;
        akf2.Ltp = 0;
        akf2.nHf = dko.nHf;
        akf2.nHg = dko.nHg;
        akf2.nHh = dko.nHh;
        akf2.nHi = dko.nHi;
        akf2.position = i2 + 1;
        WxaAttributes d2 = n.buC().d(dko.gTT, new String[0]);
        if (d2 != null) {
            akf2.dNI = d2.field_appId;
        }
        this.ofo.put(dko.nHd, akf2);
        AppMethodBeat.o(49311);
    }
}
