package com.tencent.mm.plugin.sns.ad.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.sns.ad.d.a.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class k implements e {
    public static Map<String, Integer> Dvs = new HashMap();
    private int CHZ = -1;
    private int DuA = 0;
    public HashMap<String, Long> Dvh = new HashMap<>();
    public HashSet<Long> Dvi = new HashSet<>();
    private Map<String, Long> Dvj = new HashMap();
    private Map<String, Integer> Dvk = new HashMap();
    private Map<String, c> Dvl = new HashMap();
    public HashSet<Long> Dvm = new HashSet<>();
    public Map<Long, l> Dvn = new HashMap();
    public Map<Long, l> Dvo = new HashMap();
    public Map<String, d> Dvp = new HashMap();
    public Map<String, a> Dvq = new HashMap();
    private Map<String, Integer> Dvr = new HashMap();
    private int Dvt = 0;
    private View Dvu = null;
    public Map<Long, Integer> Dvv = new HashMap();
    public Map<Long, Integer> Dvw = new HashMap();
    public HashSet<String> Dvx = new HashSet<>();
    private Activity activity;
    public int source = 0;

    static {
        AppMethodBeat.i(95019);
        AppMethodBeat.o(95019);
    }

    public final boolean IP(long j2) {
        AppMethodBeat.i(94995);
        boolean contains = this.Dvi.contains(Long.valueOf(j2));
        AppMethodBeat.o(94995);
        return contains;
    }

    public final void a(int i2, View view, Activity activity2) {
        this.DuA = i2;
        this.Dvu = view;
        this.activity = activity2;
    }

    public k(int i2) {
        AppMethodBeat.i(94996);
        this.source = i2;
        AppMethodBeat.o(94996);
    }

    public final long fr(String str, int i2) {
        long j2;
        AppMethodBeat.i(94997);
        c cVar = this.Dvl.get(str);
        if (cVar != null) {
            j2 = cVar.DuL;
        } else {
            j2 = 0;
        }
        Log.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + str + ", clkPos=" + i2 + ", time=" + j2);
        AppMethodBeat.o(94997);
        return j2;
    }

    public final void onResume() {
        AppMethodBeat.i(94998);
        long currentTicks = Util.currentTicks();
        for (String str : this.Dvq.keySet()) {
            a aVar = this.Dvq.get(str);
            Log.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(str)));
            aVar.DvH = currentTicks;
            l lVar = this.Dvn.get(Long.valueOf(aVar.DuE));
            if (lVar != null) {
                lVar.onResume();
            }
            l lVar2 = this.Dvo.get(Long.valueOf(aVar.DuE));
            if (lVar2 != null) {
                lVar2.onResume();
            }
        }
        for (Map.Entry<String, c> entry : this.Dvl.entrySet()) {
            c value = entry.getValue();
            if (value != null && aj.DKh) {
                value.uL(false);
                if (!Util.isNullOrNil(value.dJX) && this.Dvq.get(value.dJX) != null) {
                    a aVar2 = this.Dvq.get(value.dJX);
                    if (value.eXp()) {
                        aVar2.DvJ = Util.currentTicks();
                        Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + value.dJX);
                    } else if (value.Dvf) {
                        aVar2.DvN = Util.currentTicks();
                        Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + value.dJX);
                    }
                }
            }
        }
        AppMethodBeat.o(94998);
    }

    public final void I(final long j2, final boolean z) {
        AppMethodBeat.i(94999);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass1 */

            public final void run() {
                l lVar;
                AppMethodBeat.i(94990);
                if (k.this.IP(j2)) {
                    k kVar = k.this;
                    long j2 = j2;
                    boolean z = z;
                    if (z) {
                        if (kVar.Dvo.containsKey(Long.valueOf(j2))) {
                            lVar = kVar.Dvo.get(Long.valueOf(j2));
                        } else {
                            lVar = new l("timeline");
                        }
                    } else if (kVar.Dvn.containsKey(Long.valueOf(j2))) {
                        lVar = kVar.Dvn.get(Long.valueOf(j2));
                    } else {
                        lVar = new l("timeline");
                    }
                    lVar.DvO = 1;
                    lVar.DvW.DwX++;
                    if (z) {
                        kVar.Dvo.put(Long.valueOf(j2), lVar);
                        AppMethodBeat.o(94990);
                        return;
                    }
                    kVar.Dvn.put(Long.valueOf(j2), lVar);
                }
                AppMethodBeat.o(94990);
            }
        });
        AppMethodBeat.o(94999);
    }

    public final void e(long j2, int i2, boolean z) {
        AppMethodBeat.i(95000);
        MMHandlerThread.postToMainThread(new Runnable(j2, i2, true, z) {
            /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass2 */
            final /* synthetic */ boolean DvB = true;
            final /* synthetic */ long Dvy;
            final /* synthetic */ boolean Dvz;
            final /* synthetic */ int moi;

            {
                this.Dvy = r4;
                this.moi = r6;
                this.Dvz = r8;
            }

            public final void run() {
                AppMethodBeat.i(94991);
                k.this.b(this.Dvy, this.moi, this.DvB, this.Dvz);
                AppMethodBeat.o(94991);
            }
        });
        AppMethodBeat.o(95000);
    }

    public final void f(long j2, int i2, boolean z) {
        AppMethodBeat.i(202042);
        b(j2, i2, z, false);
        AppMethodBeat.o(202042);
    }

    public final void b(long j2, int i2, boolean z, boolean z2) {
        l lVar;
        AppMethodBeat.i(95002);
        if (z2) {
            if (this.Dvo.containsKey(Long.valueOf(j2))) {
                lVar = this.Dvo.get(Long.valueOf(j2));
            } else {
                lVar = new l("timeline");
            }
        } else if (this.Dvn.containsKey(Long.valueOf(j2))) {
            lVar = this.Dvn.get(Long.valueOf(j2));
        } else {
            lVar = new l("timeline");
        }
        Log.d("MicroMsg.SnsAdStatistic", "snsId=" + r.Jb(j2) + ", duration=" + i2);
        if (i2 > 0) {
            lVar.setDuration(i2);
        }
        lVar.DvO = z ? 1 : 0;
        if (z2) {
            this.Dvo.put(Long.valueOf(j2), lVar);
            AppMethodBeat.o(95002);
            return;
        }
        this.Dvn.put(Long.valueOf(j2), lVar);
        AppMethodBeat.o(95002);
    }

    public final void J(long j2, boolean z) {
        AppMethodBeat.i(95003);
        d(j2, z, false);
        AppMethodBeat.o(95003);
    }

    public final void d(long j2, boolean z, boolean z2) {
        l lVar;
        AppMethodBeat.i(95004);
        if (z2) {
            if (this.Dvo.containsKey(Long.valueOf(j2))) {
                lVar = this.Dvo.get(Long.valueOf(j2));
            } else {
                lVar = new l("timeline");
            }
        } else if (this.Dvn.containsKey(Long.valueOf(j2))) {
            lVar = this.Dvn.get(Long.valueOf(j2));
        } else {
            lVar = new l("timeline");
        }
        if (z) {
            lVar.DvW.Dxa = 2;
        } else {
            lVar.DvW.Dxa = 1;
        }
        lVar.DvW.Dxb = 1;
        if (z2) {
            this.Dvo.put(Long.valueOf(j2), lVar);
            AppMethodBeat.o(95004);
            return;
        }
        this.Dvn.put(Long.valueOf(j2), lVar);
        AppMethodBeat.o(95004);
    }

    public final void an(final long j2, final long j3) {
        AppMethodBeat.i(95005);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(94992);
                if (k.this.IP(j2)) {
                    k kVar = k.this;
                    long j2 = j3;
                    if (!kVar.Dvm.contains(Long.valueOf(j2))) {
                        kVar.Dvm.add(Long.valueOf(j2));
                    }
                }
                AppMethodBeat.o(94992);
            }
        });
        AppMethodBeat.o(95005);
    }

    public final boolean IQ(long j2) {
        AppMethodBeat.i(95006);
        if (this.Dvm.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(95006);
            return true;
        }
        AppMethodBeat.o(95006);
        return false;
    }

    public final void c(final long j2, final long j3, final boolean z) {
        AppMethodBeat.i(95007);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass4 */

            public final void run() {
                l lVar;
                AppMethodBeat.i(94993);
                if (k.this.IP(j2)) {
                    k kVar = k.this;
                    long j2 = j2;
                    long j3 = j3;
                    boolean z = z;
                    if (z) {
                        if (kVar.Dvo.containsKey(Long.valueOf(j2))) {
                            lVar = kVar.Dvo.get(Long.valueOf(j2));
                        } else {
                            lVar = new l("timeline");
                        }
                    } else if (kVar.Dvn.containsKey(Long.valueOf(j2))) {
                        lVar = kVar.Dvn.get(Long.valueOf(j2));
                    } else {
                        lVar = new l("timeline");
                    }
                    if (lVar.DvW.Dxc == 0) {
                        lVar.DvW.Dxc = j3;
                    }
                    if (z) {
                        kVar.Dvo.put(Long.valueOf(j2), lVar);
                        AppMethodBeat.o(94993);
                        return;
                    }
                    kVar.Dvn.put(Long.valueOf(j2), lVar);
                }
                AppMethodBeat.o(94993);
            }
        });
        AppMethodBeat.o(95007);
    }

    public final void K(long j2, boolean z) {
        l lVar;
        l lVar2;
        AppMethodBeat.i(95008);
        if (z) {
            if (this.Dvo.containsKey(Long.valueOf(j2))) {
                lVar2 = this.Dvo.get(Long.valueOf(j2));
                lVar2.XK(0);
            } else {
                lVar2 = new l("timeline");
            }
            this.Dvo.put(Long.valueOf(j2), lVar2);
            AppMethodBeat.o(95008);
            return;
        }
        if (this.Dvn.containsKey(Long.valueOf(j2))) {
            lVar = this.Dvn.get(Long.valueOf(j2));
            lVar.XK(0);
        } else {
            lVar = new l("timeline");
        }
        this.Dvn.put(Long.valueOf(j2), lVar);
        AppMethodBeat.o(95008);
    }

    public final void onPause() {
        AppMethodBeat.i(95009);
        for (String str : this.Dvq.keySet()) {
            a aVar = this.Dvq.get(str);
            Log.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(str)));
            aVar.DvK += Util.ticksToNow(aVar.DvH);
            aVar.DvH = 0;
            l lVar = this.Dvn.get(Long.valueOf(aVar.DuE));
            if (lVar != null) {
                lVar.jkY = Util.currentTicks();
            }
            l lVar2 = this.Dvo.get(Long.valueOf(aVar.DuE));
            if (lVar2 != null) {
                lVar2.jkY = Util.currentTicks();
            }
        }
        for (Map.Entry<String, c> entry : this.Dvl.entrySet()) {
            c value = entry.getValue();
            if (value != null && aj.DKh) {
                value.uL(false);
                if (!Util.isNullOrNil(value.dJX) && this.Dvq.get(value.dJX) != null) {
                    a aVar2 = this.Dvq.get(value.dJX);
                    if (aVar2.DvJ > 0) {
                        long ticksToNow = Util.ticksToNow(aVar2.DvJ);
                        aVar2.DvL += ticksToNow;
                        aVar2.DvJ = 0;
                        Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + ticksToNow + ", total=" + aVar2.DvL + ", id=" + value.dJX);
                    }
                    if (aVar2.DvN > 0) {
                        long ticksToNow2 = Util.ticksToNow(aVar2.DvN);
                        aVar2.DvM += ticksToNow2;
                        aVar2.DvN = 0;
                        Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + ticksToNow2 + ", total=" + aVar2.DvM + ", id=" + value.dJX);
                    }
                }
            }
        }
        AppMethodBeat.o(95009);
    }

    private ADInfo g(SnsInfo snsInfo) {
        AppMethodBeat.i(95010);
        if (snsInfo == null) {
            AppMethodBeat.o(95010);
            return null;
        } else if (this.source == 2) {
            ADInfo atAdInfo = snsInfo.getAtAdInfo();
            AppMethodBeat.o(95010);
            return atAdInfo;
        } else {
            ADInfo adInfo = snsInfo.getAdInfo();
            AppMethodBeat.o(95010);
            return adInfo;
        }
    }

    private b h(SnsInfo snsInfo) {
        AppMethodBeat.i(95011);
        if (snsInfo == null) {
            AppMethodBeat.o(95011);
            return null;
        } else if (this.source == 2) {
            b atFriendRemindInfoSourceInfo = snsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo();
            AppMethodBeat.o(95011);
            return atFriendRemindInfoSourceInfo;
        } else {
            b timelineRemindInfoSourceInfo = snsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
            AppMethodBeat.o(95011);
            return timelineRemindInfoSourceInfo;
        }
    }

    private b i(SnsInfo snsInfo) {
        AppMethodBeat.i(95012);
        if (snsInfo == null) {
            AppMethodBeat.o(95012);
            return null;
        } else if (this.source == 2) {
            b atFriendRemindInfoSelfInfo = snsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
            AppMethodBeat.o(95012);
            return atFriendRemindInfoSelfInfo;
        } else {
            b timelineRemindInfoSelfInfo = snsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
            AppMethodBeat.o(95012);
            return timelineRemindInfoSelfInfo;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.g.e
    public final void a(int i2, String str, boolean z, View view, long j2, SnsObject snsObject, int i3, int i4) {
        String str2;
        c cVar;
        int i5;
        int i6;
        l lVar;
        l lVar2;
        c.b b2;
        l lVar3;
        int jJ;
        AppMethodBeat.i(95013);
        this.Dvi.add(Long.valueOf(j2));
        this.Dvh.put(str, Long.valueOf(j2));
        if (this.CHZ == -1) {
            if (this.activity == null) {
                jJ = -1;
            } else {
                jJ = ao.jJ(this.activity);
            }
            this.CHZ = jJ;
        }
        SnsInfo aQm = aj.faO().aQm(str);
        if (aQm == null) {
            Log.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!, snsId=" + r.Jb(j2) + ", localId=" + str);
            AppMethodBeat.o(95013);
            return;
        }
        c cVar2 = this.Dvl.get(str);
        ADInfo g2 = g(aQm);
        if (g2 != null) {
            str2 = g2.viewId;
        } else {
            str2 = "";
        }
        if (cVar2 != null || view == null || !aj.DKh) {
            cVar = cVar2;
        } else {
            cVar = new c(g2, str, j2, view, this.DuA, this.Dvu, this.CHZ, i4, snsObject, i2, aQm.getAdXml());
            cVar.DuL = System.currentTimeMillis();
            aj.dRd().post(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c8: INVOKE  
                  (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x00bf: INVOKE  (r2v108 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.dRd():com.tencent.mm.sdk.platformtools.MMHandler)
                  (wrap: com.tencent.mm.plugin.sns.ad.g.c$1 : 0x00c5: CONSTRUCTOR  (r5v42 com.tencent.mm.plugin.sns.ad.g.c$1) = (r3v19 'cVar' com.tencent.mm.plugin.sns.ad.g.c) call: com.tencent.mm.plugin.sns.ad.g.c.1.<init>(com.tencent.mm.plugin.sns.ad.g.c):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.sns.ad.g.k.a(int, java.lang.String, boolean, android.view.View, long, com.tencent.mm.protocal.protobuf.SnsObject, int, int):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c5: CONSTRUCTOR  (r5v42 com.tencent.mm.plugin.sns.ad.g.c$1) = (r3v19 'cVar' com.tencent.mm.plugin.sns.ad.g.c) call: com.tencent.mm.plugin.sns.ad.g.c.1.<init>(com.tencent.mm.plugin.sns.ad.g.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ad.g.k.a(int, java.lang.String, boolean, android.view.View, long, com.tencent.mm.protocal.protobuf.SnsObject, int, int):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 23 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.ad.g.c, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                */
            /*
            // Method dump skipped, instructions count: 1191
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.g.k.a(int, java.lang.String, boolean, android.view.View, long, com.tencent.mm.protocal.protobuf.SnsObject, int, int):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x06f0 A[Catch:{ Throwable -> 0x08dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x07c5  */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x0868  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x08d3  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0637  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x064d  */
        @Override // com.tencent.mm.plugin.sns.ad.g.e
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r22, java.lang.String r23, long r24, int r26) {
            /*
            // Method dump skipped, instructions count: 2374
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.g.k.a(int, java.lang.String, long, int):void");
        }

        public final void eXq() {
            AppMethodBeat.i(259433);
            uM(false);
            AppMethodBeat.o(259433);
        }

        public final void uM(boolean z) {
            AppMethodBeat.i(95015);
            Log.i("MicroMsg.SnsAdStatistic", "checkAd %s", Boolean.valueOf(z));
            for (Map.Entry<String, c> entry : this.Dvl.entrySet()) {
                c value = entry.getValue();
                if (value != null && aj.DKh) {
                    value.uL(z);
                    if (!Util.isNullOrNil(value.dJX) && this.Dvq.get(value.dJX) != null) {
                        a aVar = this.Dvq.get(value.dJX);
                        boolean eXp = value.eXp();
                        if (eXp && aVar.DvJ == 0) {
                            aVar.DvJ = Util.currentTicks();
                            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + value.dJX);
                        } else if (!eXp && aVar.DvJ > 0) {
                            long ticksToNow = Util.ticksToNow(aVar.DvJ);
                            aVar.DvL += ticksToNow;
                            aVar.DvJ = 0;
                            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + ticksToNow + ", total=" + aVar.DvL);
                        }
                        boolean z2 = value.Dvf;
                        if (z2 && aVar.DvN == 0) {
                            aVar.DvN = Util.currentTicks();
                            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + value.dJX);
                        } else if (!z2 && aVar.DvN > 0) {
                            long ticksToNow2 = Util.ticksToNow(aVar.DvN);
                            aVar.DvM += ticksToNow2;
                            aVar.DvN = 0;
                            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + ticksToNow2 + ", total=" + aVar.DvM);
                        }
                    }
                }
            }
            AppMethodBeat.o(95015);
        }

        @Override // com.tencent.mm.plugin.sns.ad.g.e
        public final void clear() {
            AppMethodBeat.i(95016);
            Log.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
            for (String str : new HashSet(this.Dvq.keySet())) {
                a aVar = this.Dvq.get(str);
                a(aVar.position, aVar.ecF, aVar.DuE, aVar.jkT);
            }
            final HashMap hashMap = new HashMap(this.Dvr);
            aj.eJP().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass5 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(94994);
                    for (String str : hashMap.keySet()) {
                        AdSnsInfo Zp = aj.faR().Zp(y.aQI(str));
                        if (Zp != null) {
                            SnsInfo convertToSnsInfo = Zp.convertToSnsInfo();
                            Zp.setExposures();
                            int i3 = 0;
                            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                            if (hashMap.containsKey(str)) {
                                i2 = ((Integer) hashMap.get(str)).intValue();
                                i3 = 1;
                            } else {
                                i2 = currentTimeMillis;
                            }
                            if (Zp.field_exposureTime <= 0) {
                                Zp.field_exposureTime = i2;
                                Log.i("MicroMsg.SnsAdStatistic", "update Ad ExposureTime, snsId=" + r.Jb(Zp.field_snsId) + ", exposuretime=" + i2 + "， sys.currentTimeMis=" + System.currentTimeMillis() + ", type=" + i3);
                            }
                            if (convertToSnsInfo != null) {
                                convertToSnsInfo.setExposures();
                            }
                            aj.faO().b(convertToSnsInfo.field_snsId, convertToSnsInfo);
                            aj.faR().b(Zp.field_snsId, Zp);
                        }
                    }
                    AppMethodBeat.o(94994);
                }
            });
            this.Dvq.clear();
            this.Dvr.clear();
            AppMethodBeat.o(95016);
        }

        public final void IR(long j2) {
            AppMethodBeat.i(95017);
            int i2 = 0;
            if (this.Dvv.containsKey(Long.valueOf(j2))) {
                i2 = this.Dvv.get(Long.valueOf(j2)).intValue();
            }
            this.Dvv.put(Long.valueOf(j2), Integer.valueOf(i2 + 1));
            AppMethodBeat.o(95017);
        }

        public final void IS(long j2) {
            AppMethodBeat.i(95018);
            int i2 = 0;
            if (this.Dvw.containsKey(Long.valueOf(j2))) {
                i2 = this.Dvw.get(Long.valueOf(j2)).intValue();
            }
            this.Dvw.put(Long.valueOf(j2), Integer.valueOf(i2 + 1));
            AppMethodBeat.o(95018);
        }

        /* access modifiers changed from: package-private */
        public static class a {
            public long DuE;
            public long DvF;
            public long DvG;
            public long DvH;
            public String DvI;
            public long DvJ;
            public long DvK;
            public long DvL;
            public long DvM;
            public long DvN;
            public String ecF;
            public int jkT;
            public int position;
            public int qcr;

            public a(long j2, long j3, String str, int i2, String str2, int i3, long j4, int i4) {
                this.DvF = j2;
                this.DvG = j3;
                this.DvH = j2;
                this.ecF = str;
                this.position = i2;
                this.DvI = str2;
                this.DuE = j4;
                this.qcr = i3;
                this.jkT = i4;
            }
        }

        public final void IT(final long j2) {
            AppMethodBeat.i(202045);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(202039);
                    l lVar = k.this.Dvn.get(Long.valueOf(j2));
                    if (lVar != null) {
                        lVar.eXt();
                    }
                    AppMethodBeat.o(202039);
                }
            });
            AppMethodBeat.o(202045);
        }

        public final void IU(final long j2) {
            AppMethodBeat.i(202046);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(202040);
                    l lVar = k.this.Dvn.get(Long.valueOf(j2));
                    if (lVar != null && !k.a(k.this)) {
                        lVar.eVQ();
                    }
                    AppMethodBeat.o(202040);
                }
            });
            AppMethodBeat.o(202046);
        }

        public final void ao(final long j2, final long j3) {
            AppMethodBeat.i(202047);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ad.g.k.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(202041);
                    l lVar = k.this.Dvn.get(Long.valueOf(j2));
                    if (lVar != null) {
                        lVar.DvZ = j3;
                    }
                    AppMethodBeat.o(202041);
                }
            });
            AppMethodBeat.o(202047);
        }

        public final long IV(long j2) {
            AppMethodBeat.i(202048);
            try {
                l lVar = this.Dvn.get(Long.valueOf(j2));
                if (lVar != null) {
                    long j3 = lVar.DvZ;
                    AppMethodBeat.o(202048);
                    return j3;
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + th.toString());
            }
            AppMethodBeat.o(202048);
            return 0;
        }

        public final void a(String str, d dVar) {
            AppMethodBeat.i(202049);
            try {
                if (TextUtils.isEmpty(str)) {
                    Log.d("MicroMsg.SnsAdStatistic", "the key or listener is null");
                    AppMethodBeat.o(202049);
                    return;
                }
                this.Dvp.put(str, dVar);
                AppMethodBeat.o(202049);
            } catch (Throwable th) {
                Log.e("MicroMsg.SnsAdStatistic", "addAdRemovedListener exp= " + th.toString());
                AppMethodBeat.o(202049);
            }
        }

        private d aNM(String str) {
            AppMethodBeat.i(202050);
            try {
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.o(202050);
                    return null;
                }
                d remove = this.Dvp.remove(str);
                AppMethodBeat.o(202050);
                return remove;
            } catch (Throwable th) {
                Log.e("MicroMsg.SnsAdStatistic", "removeAdRemovedListener exp= " + th.toString());
                AppMethodBeat.o(202050);
                return null;
            }
        }

        static /* synthetic */ boolean a(k kVar) {
            AppMethodBeat.i(202051);
            boolean z = kVar.activity != null && kVar.activity.isFinishing();
            Log.i("MicroMsg.SnsAdStatistic", "isFinishing:".concat(String.valueOf(z)));
            AppMethodBeat.o(202051);
            return z;
        }
    }
