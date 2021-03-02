package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.util.Pair;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.e;
import com.tencent.mm.plugin.expt.hellhound.b.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher;", "", "()V", "Companion", "plugin-expt_release"})
public final class d {
    public static final a sIO = new a((byte) 0);

    static {
        AppMethodBeat.i(221135);
        AppMethodBeat.o(221135);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ8\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher$Companion;", "", "()V", "TAG", "", "addView2FuzzyPath", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "catchBizParams2ViewNode", "view", "Landroid/view/View;", "catchParams", "pageObj", "pathId", "", "matchPageList", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "catchViewParam", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void c(erd erd) {
            boolean z;
            AppMethodBeat.i(221132);
            if (erd == null) {
                AppMethodBeat.o(221132);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.d.a aVar = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
            Pair<dve, Integer> cPC = com.tencent.mm.plugin.expt.hellhound.a.d.a.cPC();
            if (cPC == null) {
                AppMethodBeat.o(221132);
                return;
            }
            dve dve = (dve) cPC.first;
            Integer num = (Integer) cPC.second;
            Iterator<bgb> it = dve.LPC.iterator();
            while (it.hasNext()) {
                bgb next = it.next();
                if (next != null && !next.LPK.isEmpty()) {
                    String aoE = b.aoE(next.LPJ.dMl);
                    LinkedList<bga> linkedList = next.LPK;
                    p.g(linkedList, "path.pages");
                    bga last = linkedList.getLast();
                    String aoE2 = b.aoE(last.name);
                    if (p.j(aoE2, aoE)) {
                        last.LPH.add(erd);
                    } else {
                        Iterator<dvg> it2 = next.LPI.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            dvg next2 = it2.next();
                            if (next2 != null && p.j(aoE2, b.aoE(next2.dMl))) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            last.LPH.add(erd);
                        }
                    }
                }
            }
            com.tencent.mm.plugin.expt.hellhound.a.d.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
            p.g(num, FirebaseAnalytics.b.INDEX);
            com.tencent.mm.plugin.expt.hellhound.a.d.a.a(dve, num.intValue());
            AppMethodBeat.o(221132);
        }

        public static void b(View view, erd erd) {
            ArrayList arrayList;
            AppMethodBeat.i(221133);
            if (erd == null) {
                AppMethodBeat.o(221133);
                return;
            }
            Object cNw = a.cNw();
            if (cNw == null) {
                AppMethodBeat.o(221133);
                return;
            }
            p.g(com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cQe(), "HellSessionPageCloudConfig.getInstance()");
            dvh cQf = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cQf();
            if (cQf == null) {
                Log.e("HABBYGE-MALI.HellViewParamsCatcher", "HellViewParamsCatcher, catchBizParams2ViewNode, config is NULL !!");
                AppMethodBeat.o(221133);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            p.g(cPO, "HellSessionMonitor.getInstance()");
            String cPQ = cPO.cPQ();
            Iterator<dvk> it = cQf.MWn.iterator();
            while (it.hasNext()) {
                dvk next = it.next();
                if (next != null && (!(!p.j(next.sGF, cPQ)) || !(!p.j("-1", next.sGF)))) {
                    String name = cNw.getClass().getName();
                    p.g(name, "pageObj.javaClass.name");
                    e.a aVar = e.sIP;
                    p.h(name, "curPageName");
                    p.h(next, "pathConfig");
                    String aoE = b.aoE(name);
                    if (aoE == null) {
                        arrayList = null;
                    } else {
                        p.g(aoE, "HellhoundUtil.getShortNa…rPageName) ?: return null");
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<dvg> it2 = next.MWr.iterator();
                        while (it2.hasNext()) {
                            dvg next2 = it2.next();
                            String aoE2 = b.aoE(next2.dMl);
                            if (aoE2 != null && p.j(aoE, aoE2)) {
                                arrayList2.add(next2);
                            }
                        }
                        arrayList = arrayList2;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        a.C1023a aVar2 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
                        String str = erd.id;
                        p.g(str, "viewNode.id");
                        erd.NoL = a.C1023a.b(str, arrayList, erd.NoL);
                        a(cNw, view, erd, next.LPN, arrayList);
                    }
                }
            }
            AppMethodBeat.o(221133);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x009f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void a(java.lang.Object r9, android.view.View r10, com.tencent.mm.protocal.protobuf.erd r11, long r12, java.util.List<? extends com.tencent.mm.protocal.protobuf.dvg> r14) {
            /*
            // Method dump skipped, instructions count: 186
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a.a(java.lang.Object, android.view.View, com.tencent.mm.protocal.protobuf.erd, long, java.util.List):void");
        }
    }
}
