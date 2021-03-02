package com.tencent.mm.plugin.sns.k;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.b.a.io;
import com.tencent.mm.g.b.a.is;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.g.b.a.kd;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.g.b.a.nk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e {
    private static final Integer DUP = 1;
    public static e DUQ = new e();
    public long Aqq = 0;
    public HashMap<String, Integer> DUR;
    public HashMap<String, String> DUS;
    public HashSet<String> DUT;
    private LinkedHashMap<Long, Object> DUU;
    private int DUV = 0;
    public String DUW = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public int DUX = -1;
    public int DUY = 200;
    public int DUZ = LocalCache.TIME_DAY;
    public ke DVA = new ke();
    public String DVB = "";
    public int DVC = 0;
    public int DVD = 0;
    public dz DVE = new dz();
    public int DVF = 0;
    public ht DVG = new ht();
    public Map<Long, it> DVH = new HashMap();
    public is DVI = new is();
    public List<Long> DVJ = new ArrayList();
    public kb DVa = new kb();
    public Map<String, Integer> DVb = new HashMap();
    public Map<String, b> DVc = new HashMap();
    public Map<String, a> DVd = new HashMap();
    public iu DVe = new iu();
    public List<String> DVf = new ArrayList();
    public List<String> DVg = new ArrayList();
    public List<String> DVh = new ArrayList();
    public List<String> DVi = new ArrayList();
    public List<String> DVj = new ArrayList();
    public List<String> DVk = new ArrayList();
    public long DVl = 0;
    public long DVm = 0;
    public long DVn = 0;
    public long DVo = 0;
    public long DVp = 0;
    public long DVq = 0;
    private LinkedList<ih> DVr = new LinkedList<>();
    private List<String> DVs = new ArrayList();
    private List<String> DVt = new ArrayList();
    public long DVu = 0;
    private long DVv = 0;
    public long DVw = 0;
    public long DVx = 0;
    public kd DVy = new kd();
    public ke DVz = new ke();
    public an gmR;
    public int hmp = 0;
    private IListener<fp> qZd = new IListener<fp>() {
        /* class com.tencent.mm.plugin.sns.k.e.AnonymousClass2 */

        {
            AppMethodBeat.i(160683);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(160683);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(96210);
            e.d(e.this);
            AppMethodBeat.o(96210);
            return false;
        }
    };
    public long viC = 0;

    static /* synthetic */ void d(e eVar) {
        AppMethodBeat.i(96247);
        eVar.fct();
        AppMethodBeat.o(96247);
    }

    static {
        AppMethodBeat.i(96248);
        AppMethodBeat.o(96248);
    }

    private e() {
        AppMethodBeat.i(96212);
        c Fu = d.aXu().Fu("100077");
        if (Fu.isValid()) {
            Map<String, String> gzz = Fu.gzz();
            this.DUY = Util.getInt(gzz.get("maxCacheFeedCount"), 200);
            this.DUZ = Util.getInt(gzz.get("maxCacheSeconds"), LocalCache.TIME_DAY);
            this.hmp = Util.getInt(gzz.get("needUploadData"), 0);
        }
        Log.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", Integer.valueOf(this.DUY), Integer.valueOf(this.DUZ), Integer.valueOf(this.hmp));
        fct();
        this.gmR = new an(ar.NSe + "snsreport.cfg");
        Object obj = this.gmR.get(3, new HashMap());
        Object obj2 = this.gmR.get(4, new HashMap());
        Object obj3 = this.gmR.get(5, new HashSet());
        Object obj4 = this.gmR.get(6, new LinkedHashMap());
        if (!(obj instanceof HashMap) || !(obj2 instanceof HashMap) || !(obj3 instanceof HashSet) || !(obj4 instanceof LinkedHashMap)) {
            s.deleteFile(ar.NSe + "snsreport.cfg");
            this.gmR.reset();
            this.DUR = new HashMap<>();
            this.DUS = new HashMap<>();
            this.DUT = new HashSet<>();
            this.DUU = new LinkedHashMap<>();
        } else {
            this.DUR = (HashMap) obj;
            this.DUS = (HashMap) obj2;
            this.DUT = (HashSet) obj3;
            this.DUU = (LinkedHashMap) obj4;
        }
        Log.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", Integer.valueOf(this.DUR.size()), Integer.valueOf(this.DUS.size()), Integer.valueOf(this.DUT.size()), Integer.valueOf(this.DUU.size()));
        EventCenter.instance.add(this.qZd);
        AppMethodBeat.o(96212);
    }

    public final void ck(String str, boolean z) {
        AppMethodBeat.i(96213);
        if (this.hmp == 0) {
            AppMethodBeat.o(96213);
            return;
        }
        this.DUR.put(str, Integer.valueOf(this.DUR.containsKey(str) ? this.DUR.get(str).intValue() + 1 : 1));
        if (z) {
            this.DUT.add(str);
        }
        AppMethodBeat.o(96213);
    }

    public final void kq(String str, String str2) {
        AppMethodBeat.i(96214);
        if (this.hmp == 0 || Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(96214);
            return;
        }
        this.DUS.put(str, str2);
        AppMethodBeat.o(96214);
    }

    private void fct() {
        AppMethodBeat.i(96215);
        this.DUV = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_real_feed_exposure_count_limit_and, 0);
        Log.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", Integer.valueOf(this.DUV));
        AppMethodBeat.o(96215);
    }

    public final synchronized void Jz(long j2) {
        AppMethodBeat.i(96216);
        if (this.DUV > 0) {
            this.DUU.put(Long.valueOf(j2), DUP);
        }
        AppMethodBeat.o(96216);
    }

    public final synchronized void fcu() {
        AppMethodBeat.i(96217);
        if (this.DUV <= 0) {
            AppMethodBeat.o(96217);
        } else {
            final LinkedHashMap linkedHashMap = (LinkedHashMap) this.DUU.clone();
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.k.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(96209);
                    long currentTicks = Util.currentTicks();
                    int size = linkedHashMap.size();
                    if (size >= e.this.DUV) {
                        int i2 = size - e.this.DUV;
                        Iterator it = linkedHashMap.keySet().iterator();
                        int i3 = 0;
                        while (it.hasNext() && i3 < i2) {
                            it.next();
                            it.remove();
                            i3++;
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.k.e.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(96208);
                                LinkedHashMap linkedHashMap = e.this.DUU;
                                e.this.DUU = linkedHashMap;
                                linkedHashMap.clear();
                                AppMethodBeat.o(96208);
                            }
                        });
                    }
                    e.this.gmR.set(6, linkedHashMap);
                    Log.i("MicroMsg.SnsReportHelper", "save exposure feed id for cgi [%d] oriSize[%d] cost[%d]", Integer.valueOf(linkedHashMap.size()), Integer.valueOf(size), Long.valueOf(Util.ticksToNow(currentTicks)));
                    AppMethodBeat.o(96209);
                }
            }, "save_exposure_feed");
            AppMethodBeat.o(96217);
        }
    }

    public final synchronized LinkedList<Long> fcv() {
        LinkedList<Long> linkedList;
        AppMethodBeat.i(96218);
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.DUU.clone();
        if (linkedHashMap.size() <= 0 || this.DUV <= 0) {
            linkedList = null;
            AppMethodBeat.o(96218);
        } else {
            LinkedList<Long> linkedList2 = new LinkedList<>();
            int i2 = 0;
            for (Long l : linkedHashMap.keySet()) {
                linkedList2.addFirst(l);
                int i3 = i2 + 1;
                if (i3 > this.DUV) {
                    linkedList2.removeLast();
                }
                i2 = i3;
            }
            AppMethodBeat.o(96218);
            linkedList = linkedList2;
        }
        return linkedList;
    }

    public final void fcw() {
        AppMethodBeat.i(96219);
        if (!(this.DVa == null || this.DVa.eTn == -1)) {
            kb kbVar = this.DVa;
            kbVar.eTC = kbVar.x("MediaEditedPublishIds", r.eZz(), true);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, Integer> entry : this.DVb.entrySet()) {
                sb.append(entry.getKey()).append("|");
                sb2.append(entry.getValue()).append("|");
            }
            int lastIndexOf = sb.lastIndexOf("|");
            int lastIndexOf2 = sb2.lastIndexOf("|");
            if (lastIndexOf != -1) {
                kb kbVar2 = this.DVa;
                kbVar2.eTp = kbVar2.x("ChatroomMemClickList", sb.substring(0, lastIndexOf), true);
            }
            if (lastIndexOf2 != -1) {
                kb kbVar3 = this.DVa;
                kbVar3.eTA = kbVar3.x("ChatroomMemClickNumList", sb2.substring(0, lastIndexOf2), true);
            }
            this.DVa.bfK();
            this.DVa = new kb();
            this.DVb.clear();
        }
        AppMethodBeat.o(96219);
    }

    public final void YP(int i2) {
        if (this.DVa != null) {
            switch (i2) {
                case 0:
                    this.DVa.eTn = 1;
                    return;
                case 1:
                    this.DVa.eTn = 2;
                    return;
                case 2:
                    this.DVa.eTn = 3;
                    return;
                case 3:
                    this.DVa.eTn = 4;
                    return;
                default:
                    return;
            }
        }
    }

    public final void aO(Map<String, List<String>> map) {
        AppMethodBeat.i(96220);
        if (!(map == null || map.isEmpty() || this.DVa == null)) {
            this.DVa.eTr = map.keySet().size();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                List<String> value = entry.getValue();
                if (value != null) {
                    sb.append(entry.getKey()).append("|").append(value.size()).append(";");
                }
            }
            kb kbVar = this.DVa;
            kbVar.eTs = kbVar.x("SelectedChatroomList", sb.toString(), true);
        }
        AppMethodBeat.o(96220);
    }

    public final void gT(List<String> list) {
        AppMethodBeat.i(96221);
        if (!(list == null || list.isEmpty() || this.DVa == null)) {
            this.DVa.eTu = list.size();
            kb kbVar = this.DVa;
            kbVar.eTv = kbVar.x("SelectedUINList", Util.listToString(list, "|"), true);
        }
        AppMethodBeat.o(96221);
    }

    public final void aP(Map<String, List<String>> map) {
        AppMethodBeat.i(96222);
        if (!(map == null || map.isEmpty() || this.DVa == null)) {
            this.DVa.eTx = map.keySet().size();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                List<String> value = entry.getValue();
                if (value != null) {
                    sb.append(entry.getKey()).append("|").append(value.size()).append(";");
                }
            }
            kb kbVar = this.DVa;
            kbVar.eTy = kbVar.x("SelectedLabelList", sb.toString(), true);
        }
        AppMethodBeat.o(96222);
    }

    public static void aPQ(String str) {
        AppMethodBeat.i(96224);
        nk nkVar = new nk();
        nkVar.Az(str);
        nkVar.fgC = 1;
        nkVar.fgD = 1;
        nkVar.bfK();
        AppMethodBeat.o(96224);
    }

    public static void fG(String str, int i2) {
        AppMethodBeat.i(96225);
        nk nkVar = new nk();
        nkVar.Az(str);
        nkVar.fgC = 2;
        nkVar.fgD = (long) i2;
        nkVar.bfK();
        AppMethodBeat.o(96225);
    }

    public static void aPR(String str) {
        AppMethodBeat.i(96226);
        nk nkVar = new nk();
        nkVar.Az(str);
        nkVar.fgC = 3;
        nkVar.fgD = 1;
        nkVar.bfK();
        AppMethodBeat.o(96226);
    }

    public class b {
        public io DVQ;
        public int position;

        b() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r7, com.tencent.mm.plugin.sns.ui.bl r8, java.lang.String r9, java.lang.String r10, int r11, int r12, boolean r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 303
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.k.e.a(android.view.View, com.tencent.mm.plugin.sns.ui.bl, java.lang.String, java.lang.String, int, int, boolean, int, int):void");
    }

    public final void ix(int i2, int i3) {
        AppMethodBeat.i(96228);
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, b> entry : DUQ.DVc.entrySet()) {
            b value = entry.getValue();
            if (!(value == null || value.DVQ == null)) {
                if (value.position < i2 - 1 || value.position > i3) {
                    value.DVQ.ePd = System.currentTimeMillis();
                    value.DVQ.bfK();
                    arrayList.add(value.DVQ.eOQ);
                }
            }
        }
        for (String str : arrayList) {
            this.DVc.remove(str);
        }
        AppMethodBeat.o(96228);
    }

    public final void cl(String str, boolean z) {
        b bVar;
        AppMethodBeat.i(96229);
        if (!(str == null || (bVar = this.DVc.get(str)) == null || bVar.DVQ == null)) {
            if (z) {
                bVar.DVQ.eOY = 1;
                AppMethodBeat.o(96229);
                return;
            }
            bVar.DVQ.eOY = 3;
        }
        AppMethodBeat.o(96229);
    }

    public final void cm(String str, boolean z) {
        b bVar;
        AppMethodBeat.i(96230);
        if (!(str == null || (bVar = this.DVc.get(str)) == null || bVar.DVQ == null)) {
            if (z) {
                bVar.DVQ.ePb = 1;
                AppMethodBeat.o(96230);
                return;
            }
            bVar.DVQ.ePj = 1;
        }
        AppMethodBeat.o(96230);
    }

    public class a {
        public il DVN;
        public List<String> DVO = new ArrayList();
        public List<String> DVP = new ArrayList();
        public int position;

        public a() {
            AppMethodBeat.i(96211);
            AppMethodBeat.o(96211);
        }
    }

    public final void iy(int i2, int i3) {
        AppMethodBeat.i(96231);
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, a> entry : this.DVd.entrySet()) {
            a value = entry.getValue();
            if (!(value == null || value.DVN == null)) {
                if (value.position < i2 - 1 || value.position > i3) {
                    il ilVar = value.DVN;
                    ilVar.eOJ = ilVar.x("ClickEmojiIconIdList", listToString(value.DVO, "|"), true);
                    il ilVar2 = value.DVN;
                    ilVar2.eOK = ilVar2.x("ClickEmojiIdList", listToString(value.DVP, "|"), true);
                    value.DVN.bfK();
                    arrayList.add(value.DVN.eOG);
                }
            }
        }
        for (String str : arrayList) {
            this.DVd.remove(str);
        }
        AppMethodBeat.o(96231);
    }

    private static <T> String listToString(List<T> list, String str) {
        AppMethodBeat.i(96232);
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                T t = list.get(i2);
                if (t != null) {
                    sb.append(t.toString()).append(str);
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(96232);
        return sb2;
    }

    public final void fcx() {
        AppMethodBeat.i(96233);
        this.DVf.clear();
        this.DVg.clear();
        this.DVh.clear();
        this.DVi.clear();
        this.DVj.clear();
        this.DVk.clear();
        this.DVl = 0;
        this.DVm = 0;
        this.DVn = 0;
        this.DVo = 0;
        this.DVp = 0;
        this.DVq = 0;
        AppMethodBeat.o(96233);
    }

    public final void N(SnsInfo snsInfo) {
        AppMethodBeat.i(96234);
        if (snsInfo != null) {
            String Jc = r.Jc(snsInfo.field_snsId);
            if (!this.DVf.contains(Jc)) {
                this.DVf.add(Jc);
            }
        }
        AppMethodBeat.o(96234);
    }

    public final void O(SnsInfo snsInfo) {
        AppMethodBeat.i(96235);
        if (snsInfo != null) {
            String Jc = r.Jc(snsInfo.field_snsId);
            if (!this.DVg.contains(Jc)) {
                this.DVg.add(Jc);
            }
        }
        AppMethodBeat.o(96235);
    }

    public final void P(SnsInfo snsInfo) {
        AppMethodBeat.i(96236);
        if (snsInfo != null) {
            String Jc = r.Jc(snsInfo.field_snsId);
            if (!this.DVh.contains(Jc)) {
                this.DVh.add(Jc);
            }
        }
        AppMethodBeat.o(96236);
    }

    public final void c(SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(96237);
        if (snsInfo != null) {
            String str = r.Jc(snsInfo.field_snsId) + "_" + i2;
            if (!this.DVi.contains(str)) {
                this.DVi.add(str);
            }
        }
        AppMethodBeat.o(96237);
    }

    public final void d(SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(96238);
        if (snsInfo != null) {
            String str = r.Jc(snsInfo.field_snsId) + "_" + i2;
            if (!this.DVk.contains(str)) {
                this.DVk.add(str);
            }
        }
        AppMethodBeat.o(96238);
    }

    public final ih fcy() {
        AppMethodBeat.i(96239);
        ih peekLast = this.DVr.peekLast();
        if (peekLast == null) {
            peekLast = new ih();
        }
        AppMethodBeat.o(96239);
        return peekLast;
    }

    public final ih fcz() {
        AppMethodBeat.i(96240);
        ih peekLast = this.DVr.peekLast();
        AppMethodBeat.o(96240);
        return peekLast;
    }

    public final ih fcA() {
        AppMethodBeat.i(96241);
        fcC();
        ih ihVar = new ih();
        this.DVr.push(ihVar);
        AppMethodBeat.o(96241);
        return ihVar;
    }

    public final void fcB() {
        AppMethodBeat.i(96242);
        if (this.DVu != 0) {
            this.DVv += System.currentTimeMillis() - this.DVu;
            this.DVu = 0;
        }
        AppMethodBeat.o(96242);
    }

    public final void e(SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(96243);
        if (snsInfo != null) {
            String str = r.Jc(snsInfo.field_snsId) + "_" + i2;
            if (!this.DVs.contains(str)) {
                this.DVs.add(str);
            }
        }
        AppMethodBeat.o(96243);
    }

    public final void f(SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(96244);
        if (snsInfo != null) {
            String str = r.Jc(snsInfo.field_snsId) + "_" + i2;
            if (!this.DVt.contains(str)) {
                this.DVt.add(str);
            }
        }
        AppMethodBeat.o(96244);
    }

    private void fcC() {
        AppMethodBeat.i(96245);
        this.DVs.clear();
        this.DVt.clear();
        this.DVu = 0;
        this.DVw = 0;
        this.DVv = 0;
        this.DVx = 0;
        AppMethodBeat.o(96245);
    }

    public final void fcD() {
        AppMethodBeat.i(96246);
        ih fcy = fcy();
        fcy.eOu = (long) this.DVs.size();
        fcy.eOv = (long) this.DVt.size();
        fcy.eOw = this.DVx;
        fcy.eOx = this.DVv;
        Log.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", fcy.abW());
        fcy.bfK();
        try {
            this.DVr.removeLast();
        } catch (Exception e2) {
            Log.w("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport remove err: %s", e2.getMessage());
        }
        fcC();
        AppMethodBeat.o(96246);
    }

    public final void fcE() {
        AppMethodBeat.i(202801);
        this.DVA.enl = 2;
        this.DVA.bfK();
        this.DVA = new ke();
        AppMethodBeat.o(202801);
    }

    public static void a(int i2, String str, int i3, int i4, long j2, int i5) {
        AppMethodBeat.i(202802);
        a(i2, str, i3, i4, j2, 0, 0, i5);
        AppMethodBeat.o(202802);
    }

    public static void a(int i2, String str, int i3, int i4, long j2, long j3, long j4, int i5) {
        int intValue;
        int i6;
        String str2;
        AppMethodBeat.i(202803);
        if (i5 == 2) {
            intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SNS_JUMP_FINDER_POST_EXPOSE_COUNT_INT_SYNC, (Object) 0)).intValue();
            i6 = 0;
            str2 = "";
        } else {
            intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SNS_FINDER_EXPOSE_COUNT_INT_SYNC, (Object) 0)).intValue();
            i6 = i4;
            str2 = str;
        }
        ((aj) g.ah(aj.class)).snsToFinderPostReport(DUQ.DVB, i2, str2, i3, i6, intValue, j3, j4, j2, i5);
        AppMethodBeat.o(202803);
    }

    public static void b(SnsInfo snsInfo, int i2, String str, int i3) {
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(202804);
        if (snsInfo != null) {
            if (!Util.isEqual(snsInfo.getUserName(), z.aTY())) {
                i4 = 1;
            } else if (Util.isEqual(str, z.aTY())) {
                i4 = 2;
            } else {
                i4 = 3;
            }
            SnsObject C = com.tencent.mm.plugin.sns.model.an.C(snsInfo);
            if (C != null) {
                int i7 = C.CommentCount;
                i5 = C.LikeCount;
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            in inVar = new in();
            inVar.wk(r.Jc(snsInfo.field_snsId));
            inVar.wm(String.valueOf(i2));
            inVar.eOM = i4;
            inVar.wl(str);
            inVar.eOP = i3;
            inVar.eON = (long) i5;
            inVar.eOO = (long) i6;
            inVar.bfK();
        }
        AppMethodBeat.o(202804);
    }

    public static void a(SnsObject snsObject, int i2, String str) {
        int i3;
        AppMethodBeat.i(202805);
        if (snsObject != null) {
            if (Util.isEqual(snsObject.Username, z.aTY())) {
                i3 = Util.isEqual(str, z.aTY()) ? 2 : 3;
            } else {
                i3 = 1;
            }
            int i4 = snsObject.CommentCount;
            int i5 = snsObject.LikeCount;
            in inVar = new in();
            inVar.wk(r.Jc(snsObject.Id));
            inVar.wm(String.valueOf(i2));
            inVar.eOM = i3;
            inVar.wl(str);
            inVar.eOP = 1;
            inVar.eON = (long) i5;
            inVar.eOO = (long) i4;
            inVar.bfK();
        }
        AppMethodBeat.o(202805);
    }

    public final void fcF() {
        AppMethodBeat.i(202806);
        this.DVE.bfK();
        this.DVE = new dz();
        AppMethodBeat.o(202806);
    }

    public final void fcG() {
        AppMethodBeat.i(202807);
        this.DVG.bfK();
        this.DVG = new ht();
        AppMethodBeat.o(202807);
    }

    public final void YQ(int i2) {
        AppMethodBeat.i(202808);
        for (Map.Entry<Long, it> entry : this.DVH.entrySet()) {
            it value = entry.getValue();
            if (value != null) {
                value.ePI = (long) i2;
                entry.getValue().bfK();
            }
        }
        this.DVH.clear();
        AppMethodBeat.o(202808);
    }

    public final void a(List<Long> list, long j2, String str) {
        AppMethodBeat.i(202809);
        this.viC = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (Long l : list) {
            sb.append(r.Jc(l.longValue())).append("#");
        }
        is isVar = this.DVI;
        isVar.ePD = isVar.x("FeedList", sb.toString(), true);
        this.DVI.ePB = (long) list.size();
        this.DVI.ws(r.Jc(j2));
        this.DVI.ws(r.Jc(j2));
        is isVar2 = this.DVI;
        isVar2.eoK = isVar2.x("UserName", str, true);
        AppMethodBeat.o(202809);
    }
}
