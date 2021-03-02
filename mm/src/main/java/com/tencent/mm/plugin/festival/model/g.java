package com.tencent.mm.plugin.festival.model;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.b.e;
import com.tencent.mm.plugin.festival.b.i;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.plugin.festival.model.d;
import com.tencent.mm.plugin.festival.model.l;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.a.j;
import kotlin.g.a.r;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002J\b\u0010'\u001a\u00020#H\u0016J\u001a\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\fH\u0002J,\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u00101\u001a\u00020#2\b\b\u0002\u0010 \u001a\u00020!J\u0006\u00102\u001a\u00020#R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalFinderLiveHeartbeatLogic;", "Lcom/tencent/mm/plugin/festival/model/IFestivalDataProviderContract;", "()V", "IO_SERIAL_TAG", "", "curResp", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishHeartbeatResp;", "getCurResp", "()Lcom/tencent/mm/plugin/festival/proto/FestivalWishHeartbeatResp;", "setCurResp", "(Lcom/tencent/mm/plugin/festival/proto/FestivalWishHeartbeatResp;)V", "<set-?>", "", "hasVisitedLive", "getHasVisitedLive", "()Z", "setHasVisitedLive", "(Z)V", "hasVisitedLive$delegate", "Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "Lcom/tencent/mm/protobuf/ByteString;", "heartbeatContext", "getHeartbeatContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setHeartbeatContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "heartbeatContext$delegate", "heartbeatTimer", "Lcom/tencent/mm/plugin/festival/model/HeartbeatTimer;", "value", "isInFloatBallMode", "setInFloatBallMode", "source", "", "batchGetWishList", "", "pbList", "", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "debugClearCacheData", "mayResetTimeInterval", "_interval", "", "forceStart", "onHeartbeatCgiBack", "errType", "errCode", "errMsg", "resp", "startHeartbeat", "stopHeartbeat", "plugin-festival_release"})
public final class g implements af {
    private static final p UxU = new p(Boolean.FALSE, f.a.HasVisitedFestivalLive);
    private static final p UxV = new p(new com.tencent.mm.bw.b(new byte[0]), f.a.CGIHeartbeatContext);
    private static boolean UxW;
    private static com.tencent.mm.plugin.festival.b.g UxX;
    private static final ae UxY = new ae(b.Uyc);
    public static final g UxZ = new g();
    static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(g.class), "hasVisitedLive", "getHasVisitedLive()Z")), aa.a(new v(aa.bp(g.class), "heartbeatContext", "getHeartbeatContext()Lcom/tencent/mm/protobuf/ByteString;"))};
    private static int source;

    private final void f(com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(262951);
        UxV.a(this, cLI[1], bVar);
        AppMethodBeat.o(262951);
    }

    private final com.tencent.mm.bw.b gWB() {
        AppMethodBeat.i(262950);
        com.tencent.mm.bw.b bVar = (com.tencent.mm.bw.b) UxV.a(this, cLI[1]);
        AppMethodBeat.o(262950);
        return bVar;
    }

    private final boolean gWj() {
        AppMethodBeat.i(262949);
        boolean booleanValue = ((Boolean) UxU.a(this, cLI[0])).booleanValue();
        AppMethodBeat.o(262949);
        return booleanValue;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/festival/proto/BatchGetFestivalWishResp;", "invoke"})
    public static final class a extends q implements r<Integer, Integer, String, com.tencent.mm.plugin.festival.b.b, x> {
        public static final a Uya = new a();

        static {
            AppMethodBeat.i(262938);
            AppMethodBeat.o(262938);
        }

        a() {
            super(4);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, Integer num2, String str, com.tencent.mm.plugin.festival.b.b bVar) {
            AppMethodBeat.i(262937);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            final com.tencent.mm.plugin.festival.b.b bVar2 = bVar;
            if (intValue == 0 && intValue2 == 0 && bVar2 != null) {
                h.RTc.aY(new Runnable() {
                    /* class com.tencent.mm.plugin.festival.model.g.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(262936);
                        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
                        p.g(ah, "plugin(PluginFestival::class.java)");
                        ((PluginFestival) ah).getFestivalWishStorage().kV(bVar2.UAr);
                        AppMethodBeat.o(262936);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262937);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0017\u0010\t\u001a\u0013\u0018\u00010\n¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0017\u0010\f\u001a\u0013\u0018\u00010\r¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0002\b\u000f"}, hxF = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "errType", "p2", "errCode", "p3", "", "errMsg", "p4", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishHeartbeatResp;", "resp", "invoke"})
    public static final /* synthetic */ class d extends n implements r<Integer, Integer, String, com.tencent.mm.plugin.festival.b.g, x> {
        d(g gVar) {
            super(4, gVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(262947);
            kotlin.l.b bp = aa.bp(g.class);
            AppMethodBeat.o(262947);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "onHeartbeatCgiBack";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "onHeartbeatCgiBack(IILjava/lang/String;Lcom/tencent/mm/plugin/festival/proto/FestivalWishHeartbeatResp;)V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, Integer num2, String str, com.tencent.mm.plugin.festival.b.g gVar) {
            AppMethodBeat.i(262946);
            g.a((g) this.SYl, num.intValue(), num2.intValue(), gVar);
            x xVar = x.SXb;
            AppMethodBeat.o(262946);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(262948);
        AppMethodBeat.o(262948);
    }

    private g() {
    }

    public static final /* synthetic */ com.tencent.mm.bw.b a(g gVar) {
        AppMethodBeat.i(262957);
        com.tencent.mm.bw.b gWB = gVar.gWB();
        AppMethodBeat.o(262957);
        return gWB;
    }

    public static final /* synthetic */ void a(g gVar, com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(262958);
        gVar.f(bVar);
        AppMethodBeat.o(262958);
    }

    public static void Fl(boolean z) {
        int i2;
        AppMethodBeat.i(262952);
        if (UxW != z) {
            UxW = z;
            if (UxY.isStarted) {
                if (z) {
                    i2 = z.Uzb.hRC().UAL;
                } else {
                    i2 = z.Uzb.hRC().UAC;
                }
                W((long) i2, false);
            }
        }
        AppMethodBeat.o(262952);
    }

    public static void a(com.tencent.mm.plugin.festival.b.g gVar) {
        UxX = gVar;
    }

    public static com.tencent.mm.plugin.festival.b.g gWC() {
        return UxX;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.festival.b.g Uyd;

        c(com.tencent.mm.plugin.festival.b.g gVar) {
            this.Uyd = gVar;
        }

        public final void run() {
            HashSet<z.a> hashSet;
            AppMethodBeat.i(262945);
            g gVar = g.UxZ;
            g.a(this.Uyd);
            g gVar2 = g.UxZ;
            com.tencent.mm.bw.b bVar = this.Uyd.GaF;
            p.g(bVar, "resp.context");
            g.a(gVar2, bVar);
            if (this.Uyd.UAU != null) {
                z zVar = z.Uzb;
                e eVar = this.Uyd.UAU;
                p.g(eVar, "resp.config");
                p.h(eVar, "config");
                e hRC = zVar.hRC();
                String str = eVar.UAI;
                if (str == null || str.length() == 0) {
                    String str2 = hRC.UAI;
                    if (!(str2 == null || str2.length() == 0)) {
                        eVar.UAI = hRC.UAI;
                    }
                }
                String str3 = eVar.UAJ;
                if (str3 == null || str3.length() == 0) {
                    String str4 = hRC.UAJ;
                    if (!(str4 == null || str4.length() == 0)) {
                        eVar.UAJ = hRC.UAJ;
                    }
                }
                zVar.b(eVar);
                synchronized (z.listeners) {
                    try {
                        hashSet = new HashSet(z.listeners);
                    } catch (Throwable th) {
                        AppMethodBeat.o(262945);
                        throw th;
                    }
                }
                for (z.a aVar : hashSet) {
                    aVar.a(eVar);
                }
            }
            l lVar = l.Uyp;
            String str5 = this.Uyd.UAt;
            String str6 = this.Uyd.UAx;
            String str7 = str5;
            if (!(str7 == null || str7.length() == 0)) {
                if (!p.j(str5, l.a.Uyt.hbw())) {
                    Log.i("MicroMsg.FestivalLiveCanvasDataProvider", "notifyNewDataUrl url:" + str5 + ", md5:" + str6 + ", last_url:" + l.a.Uyt.hbw());
                }
                o oVar = new o(l.gWT(), MD5Util.getMD5String(str5) + "_cvs.dat");
                if (l.h(oVar, str6)) {
                    Log.d("MicroMsg.FestivalLiveCanvasDataProvider", "notifyNewDataUrl direct callback url:" + str5 + " md5:" + str6);
                    l.g(oVar, str5);
                } else {
                    b bVar2 = b.Uxz;
                    b.a(str5, oVar, new l.b(oVar, str6, str5));
                }
            }
            LinkedList<com.tencent.mm.plugin.festival.b.c> linkedList = this.Uyd.UAV;
            if (!(linkedList == null || linkedList.isEmpty())) {
                o oVar2 = o.Uyw;
                o.kT(this.Uyd.UAV);
            }
            LinkedList<i> linkedList2 = this.Uyd.UAX;
            if (!(linkedList2 == null || linkedList2.isEmpty())) {
                q qVar = q.UyB;
                LinkedList<i> linkedList3 = this.Uyd.UAX;
                p.g(linkedList3, "resp.musiclist");
                q.k(linkedList3, TimeUnit.SECONDS.toMillis((long) this.Uyd.UAU.UAC));
            }
            LinkedList<com.tencent.mm.plugin.festival.b.c> linkedList4 = this.Uyd.UAR;
            if (!(linkedList4 == null || linkedList4.isEmpty())) {
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
                p.g(ah, "plugin(PluginFestival::class.java)");
                ad festivalWishStorage = ((PluginFestival) ah).getFestivalWishStorage();
                LinkedList<com.tencent.mm.plugin.festival.b.c> linkedList5 = this.Uyd.UAR;
                p.g(linkedList5, "resp.mywishlist");
                festivalWishStorage.kW(j.a((Iterable) linkedList5, (Comparator) new a()));
            }
            LinkedList<com.tencent.mm.plugin.festival.b.c> linkedList6 = this.Uyd.UAS;
            if (!(linkedList6 == null || linkedList6.isEmpty())) {
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFestival.class);
                p.g(ah2, "plugin(PluginFestival::class.java)");
                ad festivalWishStorage2 = ((PluginFestival) ah2).getFestivalWishStorage();
                LinkedList<com.tencent.mm.plugin.festival.b.c> linkedList7 = this.Uyd.UAS;
                p.g(linkedList7, "resp.friendwishlist");
                festivalWishStorage2.kW(j.a((Iterable) linkedList7, (Comparator) new b()));
                g gVar3 = g.UxZ;
                g.kS(this.Uyd.UAS);
            }
            LinkedList<com.tencent.mm.plugin.festival.b.j> linkedList8 = this.Uyd.UAW;
            if (!(linkedList8 == null || linkedList8.isEmpty())) {
                com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFestival.class);
                p.g(ah3, "plugin(PluginFestival::class.java)");
                ((PluginFestival) ah3).getTopicStorage().kU(this.Uyd.UAW);
            }
            AppMethodBeat.o(262945);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                AppMethodBeat.i(262943);
                int a2 = kotlin.b.a.a(Long.valueOf(com.tencent.mm.plugin.festival.c.e.awJ(t.createtime)), Long.valueOf(com.tencent.mm.plugin.festival.c.e.awJ(t2.createtime)));
                AppMethodBeat.o(262943);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        public static final class b<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                AppMethodBeat.i(262944);
                int a2 = kotlin.b.a.a(Long.valueOf(com.tencent.mm.plugin.festival.c.e.awJ(t.createtime)), Long.valueOf(com.tencent.mm.plugin.festival.c.e.awJ(t2.createtime)));
                AppMethodBeat.o(262944);
                return a2;
            }
        }
    }

    private static void W(long j2, boolean z) {
        AppMethodBeat.i(262953);
        long millis = TimeUnit.SECONDS.toMillis(j2);
        if (z || (!UxY.ifP && (!UxY.isStarted || UxY.UzL != millis))) {
            UxY.startTimer(millis);
        }
        AppMethodBeat.o(262953);
    }

    public final void awB(int i2) {
        int i3;
        AppMethodBeat.i(262954);
        i iVar = i.Uyl;
        i.log("startHeartbeat");
        source = i2;
        Fl(false);
        v vVar = v.UyU;
        d.a aVar = d.b.UxC;
        p.g(aVar, "FestivalConstants.Protocol.FestivalHeartbeat");
        com.tencent.mm.plugin.festival.b.f fVar = new com.tencent.mm.plugin.festival.b.f();
        fVar.GaF = UxZ.gWB();
        if (UxZ.gWj()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        fVar.scene = i3;
        fVar.qwL = (int) Util.nowMilliSecond();
        fVar.source = i2;
        v.b(aVar, fVar, new com.tencent.mm.plugin.festival.b.g(), new d(this));
        if (z.Uzb.hRC().UAC > 0) {
            W((long) z.Uzb.hRC().UAC, true);
        }
        AppMethodBeat.o(262954);
    }

    public final void gWK() {
        AppMethodBeat.i(262955);
        i iVar = i.Uyl;
        i.log("stopHeartbeat");
        UxY.stopTimer();
        source = 0;
        Fl(false);
        AppMethodBeat.o(262955);
    }

    @Override // com.tencent.mm.plugin.festival.model.af
    public final void debugClearCacheData() {
        AppMethodBeat.i(262956);
        gWK();
        UxU.a(this, cLI[0], Boolean.FALSE);
        f(new com.tencent.mm.bw.b(new byte[0]));
        AppMethodBeat.o(262956);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b Uyc = new b();

        static {
            AppMethodBeat.i(262942);
            AppMethodBeat.o(262942);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262941);
            v vVar = v.UyU;
            d.a aVar = d.b.UxC;
            p.g(aVar, "FestivalConstants.Protocol.FestivalHeartbeat");
            com.tencent.mm.plugin.festival.b.f fVar = new com.tencent.mm.plugin.festival.b.f();
            fVar.GaF = g.a(g.UxZ);
            fVar.scene = 3;
            fVar.qwL = (int) Util.nowMilliSecond();
            g gVar = g.UxZ;
            fVar.source = g.source;
            v.b(aVar, fVar, new com.tencent.mm.plugin.festival.b.g(), new r<Integer, Integer, String, com.tencent.mm.plugin.festival.b.g, x>(g.UxZ) {
                /* class com.tencent.mm.plugin.festival.model.g.b.AnonymousClass1 */

                @Override // kotlin.g.b.e
                public final kotlin.l.d Rs() {
                    AppMethodBeat.i(262940);
                    kotlin.l.b bp = aa.bp(g.class);
                    AppMethodBeat.o(262940);
                    return bp;
                }

                @Override // kotlin.l.a, kotlin.g.b.e
                public final String getName() {
                    return "onHeartbeatCgiBack";
                }

                @Override // kotlin.g.b.e
                public final String getSignature() {
                    return "onHeartbeatCgiBack(IILjava/lang/String;Lcom/tencent/mm/plugin/festival/proto/FestivalWishHeartbeatResp;)V";
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.r
                public final /* synthetic */ x invoke(Integer num, Integer num2, String str, com.tencent.mm.plugin.festival.b.g gVar) {
                    AppMethodBeat.i(262939);
                    g.a((g) this.SYl, num.intValue(), num2.intValue(), gVar);
                    x xVar = x.SXb;
                    AppMethodBeat.o(262939);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(262941);
            return xVar;
        }
    }

    public static final /* synthetic */ void kS(List list) {
        AppMethodBeat.i(262959);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.festival.b.c cVar = (com.tencent.mm.plugin.festival.b.c) it.next();
                String str = cVar != null ? cVar.UAv : null;
                if (!(str == null || str.length() == 0)) {
                    linkedList.add(cVar.UAv);
                }
            }
            if (!(linkedList.isEmpty())) {
                v vVar = v.UyU;
                d.a aVar = d.b.UxH;
                p.g(aVar, "FestivalConstants.Protocol.BatchGetWish");
                com.tencent.mm.plugin.festival.b.a aVar2 = new com.tencent.mm.plugin.festival.b.a();
                aVar2.UAp.addAll(linkedList);
                v.b(aVar, aVar2, new com.tencent.mm.plugin.festival.b.b(), a.Uya);
            }
        }
        AppMethodBeat.o(262959);
    }

    public static final /* synthetic */ void a(g gVar, int i2, int i3, com.tencent.mm.plugin.festival.b.g gVar2) {
        int i4;
        AppMethodBeat.i(262960);
        if (i3 != 0) {
            gVar.gWK();
            EventCenter.instance.publish(new n(i2, i3));
        }
        if (i2 == 0 && i3 == 0) {
            if (gVar2 == null) {
                p.hyc();
            }
            h.RTc.b(new c(gVar2), "festival_heartbeat_write_cgi_resp_thread");
            if (UxW) {
                i4 = gVar2.UAU.UAL;
            } else {
                i4 = gVar2.UAU.UAC;
            }
            W((long) i4, false);
        }
        AppMethodBeat.o(262960);
    }
}
