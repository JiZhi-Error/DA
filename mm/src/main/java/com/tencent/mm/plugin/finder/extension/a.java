package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.util.SparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.cgi.ci;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002,-B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J,\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001a\u001a\u0004\u0018\u00010%H\u0017J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Triple;", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "unregister", "Companion", "SyncArgs", "plugin-finder_release"})
public final class a implements i, e {
    private static final String TAG = TAG;
    private static final SparseArray<HashSet<f>> tIT = new SparseArray<>();
    private static final b tIU = new b();
    private static HashSet<Integer> tIV = new HashSet<>();
    public static final C1110a tIW = new C1110a((byte) 0);
    private final ConcurrentLinkedQueue<r<Integer, Integer, b>> tIM = new ConcurrentLinkedQueue<>();
    private int tIN;
    private int tIO;
    private final int tIP = 3;
    private final int tIQ = com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX;
    private final MMHandler tIR = new MMHandler("finder_sync_thread", new c(this));
    private final Runnable tIS = new d(this);

    public a() {
        AppMethodBeat.i(165594);
        AppMethodBeat.o(165594);
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(165596);
        aVar.dar();
        AppMethodBeat.o(165596);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\b0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.extension.a$a  reason: collision with other inner class name */
    public static final class C1110a {
        private C1110a() {
        }

        public /* synthetic */ C1110a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165595);
        AppMethodBeat.o(165595);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class c implements MMHandler.Callback {
        final /* synthetic */ a tJb;

        c(a aVar) {
            this.tJb = aVar;
        }

        public final boolean handleMessage(Message message) {
            boolean z;
            r rVar;
            AppMethodBeat.i(165584);
            if (message != null && message.what == this.tJb.tIQ && this.tJb.tIN == 0) {
                if (!this.tJb.tIM.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (rVar = (r) this.tJb.tIM.peek()) != null) {
                    this.tJb.tIN = rVar.first.intValue();
                    com.tencent.mm.kernel.e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_SYNC_KEYBUF2_STRING_SYNC, "");
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(165584);
                        throw tVar;
                    }
                    g.azz().b(new ci(z.aUg(), Util.decodeHexString((String) obj), this.tJb.tIN, rVar.second.intValue(), rVar.SWY));
                }
            }
            AppMethodBeat.o(165584);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01a0, code lost:
        if ((r1.length == 0) != false) goto L_0x01a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0273  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r12, int r13, java.lang.String r14, com.tencent.mm.ak.q r15) {
        /*
        // Method dump skipped, instructions count: 710
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.a.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private static String Iv(int i2) {
        AppMethodBeat.i(165587);
        StringBuffer stringBuffer = new StringBuffer();
        o<Integer, String>[] cXG = e.a.cXG();
        for (o<Integer, String> oVar : cXG) {
            if ((oVar.first.intValue() & i2) != 0) {
                stringBuffer.append(((String) oVar.second) + " ,");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        p.g(stringBuffer2, "buf.toString()");
        AppMethodBeat.o(165587);
        return stringBuffer2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "", "finderEntranceTipsId", "", "finderCtrlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "nearbyEntranceTipsId", "nearbyCtrlInfoList", "(Ljava/lang/String;Ljava/util/LinkedList;Ljava/lang/String;Ljava/util/LinkedList;)V", "getFinderCtrlInfoList", "()Ljava/util/LinkedList;", "getFinderEntranceTipsId", "()Ljava/lang/String;", "setFinderEntranceTipsId", "(Ljava/lang/String;)V", "getNearbyCtrlInfoList", "getNearbyEntranceTipsId", "setNearbyEntranceTipsId", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
    public static final class b {
        public String tIX;
        public final LinkedList<bbi> tIY;
        public String tIZ;
        public final LinkedList<bbi> tJa;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (kotlin.g.b.p.j(r3.tJa, r4.tJa) != false) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 243479(0x3b717, float:3.41187E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0036
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.extension.a.b
                if (r0 == 0) goto L_0x003b
                com.tencent.mm.plugin.finder.extension.a$b r4 = (com.tencent.mm.plugin.finder.extension.a.b) r4
                java.lang.String r0 = r3.tIX
                java.lang.String r1 = r4.tIX
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.util.LinkedList<com.tencent.mm.protocal.protobuf.bbi> r0 = r3.tIY
                java.util.LinkedList<com.tencent.mm.protocal.protobuf.bbi> r1 = r4.tIY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.lang.String r0 = r3.tIZ
                java.lang.String r1 = r4.tIZ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.util.LinkedList<com.tencent.mm.protocal.protobuf.bbi> r0 = r3.tJa
                java.util.LinkedList<com.tencent.mm.protocal.protobuf.bbi> r1 = r4.tJa
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003b
            L_0x0036:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x003a:
                return r0
            L_0x003b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x003a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(243478);
            String str = this.tIX;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            LinkedList<bbi> linkedList = this.tIY;
            int hashCode2 = ((linkedList != null ? linkedList.hashCode() : 0) + hashCode) * 31;
            String str2 = this.tIZ;
            int hashCode3 = ((str2 != null ? str2.hashCode() : 0) + hashCode2) * 31;
            LinkedList<bbi> linkedList2 = this.tJa;
            if (linkedList2 != null) {
                i2 = linkedList2.hashCode();
            }
            int i3 = hashCode3 + i2;
            AppMethodBeat.o(243478);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(243477);
            String str = "SyncArgs(finderEntranceTipsId=" + this.tIX + ", finderCtrlInfoList=" + this.tIY + ", nearbyEntranceTipsId=" + this.tIZ + ", nearbyCtrlInfoList=" + this.tJa + ")";
            AppMethodBeat.o(243477);
            return str;
        }

        public /* synthetic */ b() {
            this("", new LinkedList(), "", new LinkedList());
            AppMethodBeat.i(243476);
            AppMethodBeat.o(243476);
        }

        private b(String str, LinkedList<bbi> linkedList, String str2, LinkedList<bbi> linkedList2) {
            p.h(str, "finderEntranceTipsId");
            p.h(linkedList, "finderCtrlInfoList");
            p.h(str2, "nearbyEntranceTipsId");
            p.h(linkedList2, "nearbyCtrlInfoList");
            AppMethodBeat.i(243475);
            this.tIX = str;
            this.tIY = linkedList;
            this.tIZ = str2;
            this.tJa = linkedList2;
            AppMethodBeat.o(243475);
        }

        public final void asS(String str) {
            AppMethodBeat.i(243473);
            p.h(str, "<set-?>");
            this.tIX = str;
            AppMethodBeat.o(243473);
        }

        public final void asT(String str) {
            AppMethodBeat.i(243474);
            p.h(str, "<set-?>");
            this.tIZ = str;
            AppMethodBeat.o(243474);
        }
    }

    @Override // com.tencent.mm.plugin.finder.api.e
    public final void fX(int i2, int i3) {
        bbi bbi;
        bbi bbi2;
        AppMethodBeat.i(165588);
        String aUg = z.aUg();
        h.INSTANCE.a(19122, Integer.valueOf(i3), Util.getStack());
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1292, 1, 1, false);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1292, (long) (i3 + 10), 1, false);
        b bVar = new b();
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) ah).getRedDotManager();
        k asX = redDotManager.asX("FinderEntrance");
        if (!(asX == null || (bbi2 = asX.field_ctrInfo) == null)) {
            String str = bbi2.LKM;
            if (str == null) {
                str = "";
            }
            bVar.asS(str);
        }
        k asX2 = redDotManager.asX("FinderEntrance");
        if (asX2 != null) {
            bVar.tIY.add(asX2.field_ctrInfo);
        }
        k asX3 = redDotManager.asX("TLFollow");
        if (asX3 != null) {
            int i4 = 0;
            Iterator<bbi> it = bVar.tIY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i4 = -1;
                    break;
                } else if (p.j(asX3.field_tipsId, it.next().LKM)) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 < 0) {
                bVar.tIY.add(asX3.field_ctrInfo);
            }
        }
        k asX4 = redDotManager.asX("TLRecommendTab");
        if (asX4 != null) {
            int i5 = 0;
            Iterator<bbi> it2 = bVar.tIY.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i5 = -1;
                    break;
                } else if (p.j(asX4.field_tipsId, it2.next().LKM)) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                bVar.tIY.add(asX4.field_ctrInfo);
            }
        }
        k asX5 = redDotManager.asX("finder_tl_hot_tab");
        if (asX5 != null) {
            int i6 = 0;
            Iterator<bbi> it3 = bVar.tIY.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    i6 = -1;
                    break;
                } else if (p.j(asX5.field_tipsId, it3.next().LKM)) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                bVar.tIY.add(asX5.field_ctrInfo);
            }
        }
        k asX6 = redDotManager.asX("finder_tl_nearby_tab");
        if (asX6 != null) {
            int i7 = 0;
            Iterator<bbi> it4 = bVar.tIY.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    i7 = -1;
                    break;
                } else if (p.j(asX6.field_tipsId, it4.next().LKM)) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 < 0) {
                bVar.tIY.add(asX6.field_ctrInfo);
            }
        }
        k asX7 = redDotManager.asX("NearbyEntrance");
        if (!(asX7 == null || (bbi = asX7.field_ctrInfo) == null)) {
            String str2 = bbi.LKM;
            if (str2 == null) {
                str2 = "";
            }
            bVar.asT(str2);
        }
        k asX8 = redDotManager.asX("NearbyEntrance");
        if (asX8 != null) {
            bVar.tJa.add(asX8.field_ctrInfo);
        }
        k asX9 = redDotManager.asX("NearbyFeedTab");
        if (asX9 != null) {
            int i8 = 0;
            Iterator<bbi> it5 = bVar.tJa.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    i8 = -1;
                    break;
                } else if (p.j(asX9.field_tipsId, it5.next().LKM)) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i8 < 0) {
                bVar.tJa.add(asX9.field_ctrInfo);
            }
        }
        k asX10 = redDotManager.asX("NearbyLiveTab");
        if (asX10 != null) {
            int i9 = 0;
            Iterator<bbi> it6 = bVar.tJa.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    i9 = -1;
                    break;
                } else if (p.j(asX10.field_tipsId, it6.next().LKM)) {
                    break;
                } else {
                    i9++;
                }
            }
            if (i9 < 0) {
                bVar.tJa.add(asX10.field_ctrInfo);
            }
        }
        k asX11 = redDotManager.asX("NearbyPeopleTab");
        if (asX11 != null) {
            int i10 = 0;
            Iterator<bbi> it7 = bVar.tJa.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    i10 = -1;
                    break;
                } else if (p.j(asX11.field_tipsId, it7.next().LKM)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                bVar.tJa.add(asX11.field_ctrInfo);
            }
        }
        Log.i(TAG, "sync selector[" + i2 + '=' + Iv(i2) + "] finderCtrlInfoList=" + bVar.tIY.size() + " nearbyCtrlInfoList=" + bVar.tJa.size() + "myFinderUser[" + aUg + "] waitLinkedQueue=" + this.tIM.size());
        this.tIM.add(new r<>(Integer.valueOf(i2), Integer.valueOf(i3), bVar));
        daq();
        AppMethodBeat.o(165588);
    }

    private final void daq() {
        AppMethodBeat.i(243480);
        this.tIR.sendEmptyMessage(this.tIQ);
        AppMethodBeat.o(243480);
    }

    @Override // com.tencent.mm.plugin.finder.api.e
    public final void a(int i2, f fVar) {
        AppMethodBeat.i(165589);
        p.h(fVar, "handler");
        if (tIT.get(i2) == null) {
            tIT.append(i2, new HashSet<>());
            x xVar = x.SXb;
        }
        tIT.get(i2).add(fVar);
        AppMethodBeat.o(165589);
    }

    @Override // com.tencent.mm.plugin.finder.api.e
    public final void b(int i2, f fVar) {
        AppMethodBeat.i(165590);
        p.h(fVar, "handler");
        HashSet<f> hashSet = tIT.get(i2);
        if (hashSet != null) {
            hashSet.remove(fVar);
            AppMethodBeat.o(165590);
            return;
        }
        AppMethodBeat.o(165590);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ a tJb;

        d(a aVar) {
            this.tJb = aVar;
        }

        public final void run() {
            AppMethodBeat.i(165585);
            this.tJb.fX(47613, 2);
            a.d(this.tJb);
            AppMethodBeat.o(165585);
        }
    }

    private final void dar() {
        AppMethodBeat.i(165591);
        if (this.tIO >= this.tIP) {
            Log.i(TAG, "checkLoop finderAliveUI " + tIV.size() + " sync_fail_count " + this.tIO + " so ignore checkloop");
        }
        if (tIV.size() > 0) {
            this.tIR.removeCallbacks(this.tIS);
            MMHandler mMHandler = this.tIR;
            Runnable runnable = this.tIS;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            mMHandler.postDelayed(runnable, (long) com.tencent.mm.plugin.finder.storage.c.drc());
        }
        AppMethodBeat.o(165591);
    }

    @Override // com.tencent.mm.plugin.finder.api.e
    public final void a(MMFinderUI mMFinderUI) {
        AppMethodBeat.i(165592);
        p.h(mMFinderUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (!tIV.contains(Integer.valueOf(mMFinderUI.hashCode()))) {
            tIV.add(Integer.valueOf(mMFinderUI.hashCode()));
            String str = TAG;
            StringBuilder sb = new StringBuilder("Start msg Looper ");
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            Log.i(str, sb.append(com.tencent.mm.plugin.finder.storage.c.drc()).append(" size: ").append(tIV.size()).append(' ').append(this.tIO).toString());
            this.tIO = 0;
            dar();
        }
        AppMethodBeat.o(165592);
    }

    @Override // com.tencent.mm.plugin.finder.api.e
    public final void b(MMFinderUI mMFinderUI) {
        AppMethodBeat.i(165593);
        p.h(mMFinderUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        tIV.remove(Integer.valueOf(mMFinderUI.hashCode()));
        String str = TAG;
        StringBuilder sb = new StringBuilder("unregister Looper ");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i(str, sb.append(com.tencent.mm.plugin.finder.storage.c.drc()).append(" size: ").append(tIV.size()).append(' ').append(this.tIO).toString());
        AppMethodBeat.o(165593);
    }
}
