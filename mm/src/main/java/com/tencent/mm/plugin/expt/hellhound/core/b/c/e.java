package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010#J\u0006\u0010&\u001a\u00020\u001dJ\b\u0010'\u001a\u00020\u001dH\u0007J\u0012\u0010(\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\b\u0010)\u001a\u00020\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor;", "", "()V", "TAG", "", "mGestureCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "getMGestureCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "mGestureCallback$delegate", "Lkotlin/Lazy;", "mHorizontalCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "getMHorizontalCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "mHorizontalCallback$delegate", "mListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1;", "mViewMap", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mViewOpCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "getMViewOpCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "mViewOpCallback$delegate", "addView2PageFlow", "", "pageItem", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", FirebaseAnalytics.b.INDEX, "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "callback", "view", "monitor", "monitorHorizontalScroll", "onMonitorCallback", "unmonitorHorizontalScroll", "plugin-expt_release"})
public final class e {
    private static final Map<String, WeakReference<View>> mViewMap = new LinkedHashMap();
    public static final f sAQ = g.ah(d.sAX);
    public static final f sAR = g.ah(a.sAV);
    private static final f sAS = g.ah(b.sAW);
    public static final c sAT = new c();
    public static final e sAU = new e();

    private static b cOo() {
        AppMethodBeat.i(220770);
        b bVar = (b) sAS.getValue();
        AppMethodBeat.o(220770);
        return bVar;
    }

    static {
        AppMethodBeat.i(220775);
        AppMethodBeat.o(220775);
    }

    private e() {
        AppMethodBeat.i(184341);
        AppMethodBeat.o(184341);
    }

    public static final void cOp() {
        AppMethodBeat.i(220771);
        b cOo = cOo();
        cOo.sAr = sAT;
        cOo.afB = -1;
        ArrayList arrayList = new ArrayList();
        Pair create = Pair.create("onPageChange", "(IZ)V");
        p.g(create, "Pair.create(METHOD_NAME, METHOD_DESC)");
        arrayList.add(create);
        cOo.sAz.put("com/tencent/mm/view/RecyclerHorizontalViewPager", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(cOo.sAz, cOo.sAA);
        AppMethodBeat.o(220771);
    }

    public static final void cOq() {
        AppMethodBeat.i(220772);
        b cOo = cOo();
        cOo.afB = -1;
        cOo.sAr = null;
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.b(cOo.sAz, cOo.sAA);
        AppMethodBeat.o(220772);
    }

    public static void a(erd erd) {
        AppMethodBeat.i(220773);
        sAT.a(null, erd);
        AppMethodBeat.o(220773);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onEvent", "", "view", "Landroid/view/View;", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "plugin-expt_release"})
    public static final class c implements c {
        c() {
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.core.b.c.c
        public final void a(View view, erd erd) {
            AppMethodBeat.i(220767);
            if (erd == null) {
                AppMethodBeat.o(220767);
                return;
            }
            if (view != null) {
                e eVar = e.sAU;
                e.mViewMap.put(erd.id + "|" + erd.aHK + "|" + erd.timestamp, new WeakReference(view));
            }
            erd.NoO = System.currentTimeMillis() - erd.timestamp;
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(800, erd);
            AppMethodBeat.o(220767);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(com.tencent.mm.protocal.protobuf.erd r7) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.core.b.c.e.b(com.tencent.mm.protocal.protobuf.erd):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<f> {
        public static final d sAX = new d();

        static {
            AppMethodBeat.i(220769);
            AppMethodBeat.o(220769);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ f invoke() {
            AppMethodBeat.i(220768);
            f fVar = new f();
            AppMethodBeat.o(220768);
            return fVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<a> {
        public static final a sAV = new a();

        static {
            AppMethodBeat.i(220764);
            AppMethodBeat.o(220764);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(220763);
            a aVar = new a();
            AppMethodBeat.o(220763);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<b> {
        public static final b sAW = new b();

        static {
            AppMethodBeat.i(220766);
            AppMethodBeat.o(220766);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(220765);
            b bVar = new b();
            AppMethodBeat.o(220765);
            return bVar;
        }
    }
}
