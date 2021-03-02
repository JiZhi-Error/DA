package com.tencent.mm.view;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/view/ExposeElves;", "", "()V", "CHECK_TIME_NS", "", "TAG", "", "lastCheckTime", "", "rect", "Landroid/graphics/Rect;", "watchSize", "getWatchSize", "()I", "setWatchSize", "(I)V", "checkExpose", "", "target", "Landroid/view/View;", "exposedData", "Lcom/tencent/mm/view/ExposedData;", "checkGroupExpose", "OnRecyclerViewChildExposedListener", "OnViewExposedListener", "OnViewGroupChildExposedListener", "libmmui_release"})
public final class e {
    private static int RiP;
    public static final e RiQ = new e();
    private static long lastCheckTime;
    private static final Rect rect = new Rect();

    static {
        AppMethodBeat.i(204929);
        final d dVar = d.RiS;
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (!p.j(currentThread, mainLooper.getThread())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.view.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(204923);
                    dVar.invoke();
                    AppMethodBeat.o(204923);
                }
            });
            AppMethodBeat.o(204929);
            return;
        }
        dVar.invoke();
        AppMethodBeat.o(204929);
    }

    private e() {
    }

    public static void apM(int i2) {
        RiP = i2;
    }

    public static int hfy() {
        return RiP;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"})
    public static abstract class b {
        public abstract void p(View view, boolean z);

        public long hE(View view) {
            p.h(view, "view");
            return (long) view.hashCode();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "ignoreExposeChanged", "", "onChildExposeChanged", "", "parent", "exposedChildren", "", "libmmui_release"})
    public static abstract class c {
        public abstract void b(View view, List<? extends View> list);

        public boolean hfA() {
            return false;
        }

        public long hE(View view) {
            p.h(view, "view");
            return (long) view.hashCode();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "", "()V", "getExposedId", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"})
    public static abstract class a {
        public abstract void b(View view, List<? extends RecyclerView.v> list);

        public long ae(RecyclerView.v vVar) {
            View view = vVar != null ? vVar.aus : null;
            return (long) (view != null ? view.hashCode() : 0);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        public static final d RiS = new d();

        static {
            AppMethodBeat.i(204927);
            AppMethodBeat.o(204927);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(204926);
            Looper.myQueue().addIdleHandler(AnonymousClass1.RiT);
            x xVar = x.SXb;
            AppMethodBeat.o(204926);
            return xVar;
        }
    }

    private static void a(View view, g gVar) {
        AppMethodBeat.i(204928);
        c cVar = gVar.Rjd;
        if (cVar == null) {
            AppMethodBeat.o(204928);
        } else if (cVar.hfA()) {
            AppMethodBeat.o(204928);
        } else if (!(view instanceof ViewGroup)) {
            AppMethodBeat.o(204928);
        } else {
            LinkedList linkedList = new LinkedList();
            long j2 = 0;
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ((ViewGroup) view).getChildAt(i2);
                p.g(childAt, "child");
                long hE = cVar.hE(childAt);
                if (childAt.isShown() && childAt.getAlpha() > 0.0f && childAt.getGlobalVisibleRect(rect)) {
                    linkedList.add(childAt);
                    j2 += hE;
                }
            }
            if (gVar.Rje != j2) {
                gVar.Rje = j2;
                c cVar2 = gVar.Rjd;
                if (cVar2 != null) {
                    cVar2.b(view, linkedList);
                    AppMethodBeat.o(204928);
                    return;
                }
            }
            AppMethodBeat.o(204928);
        }
    }

    public static final /* synthetic */ void hfz() {
        AppMethodBeat.i(204930);
        long nanoTime = System.nanoTime();
        if (nanoTime - lastCheckTime >= 250000000) {
            for (Map.Entry entry : f.hfB().entrySet()) {
                View view = ((g) entry.getValue()).view;
                g gVar = (g) entry.getValue();
                p.h(view, "target");
                p.h(gVar, "exposedData");
                if (view.isShown() && view.getAlpha() > 0.0f && view.getGlobalVisibleRect(rect)) {
                    b bVar = gVar.Rjc;
                    long hE = bVar != null ? bVar.hE(view) : -1;
                    a(view, gVar);
                    if (gVar.Rja != hE) {
                        b bVar2 = gVar.Rjc;
                        if (bVar2 != null) {
                            bVar2.p(gVar.view, true);
                        }
                        gVar.Rja = hE;
                    }
                } else if (gVar.Rja != -1) {
                    a(view, gVar);
                    b bVar3 = gVar.Rjc;
                    if (bVar3 != null) {
                        bVar3.p(gVar.view, false);
                    }
                    gVar.Rja = -1;
                }
            }
            lastCheckTime = nanoTime;
        }
        AppMethodBeat.o(204930);
    }
}
