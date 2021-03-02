package com.tencent.mm.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.view.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;

public final class f {
    private static final HashMap<Integer, g> RiU = new HashMap<>();

    public static final /* synthetic */ g apO(int i2) {
        AppMethodBeat.i(204944);
        g apN = apN(i2);
        AppMethodBeat.o(204944);
        return apN;
    }

    public static final /* synthetic */ void b(int i2, g gVar) {
        AppMethodBeat.i(204943);
        a(i2, gVar);
        AppMethodBeat.o(204943);
    }

    static {
        AppMethodBeat.i(204942);
        AppMethodBeat.o(204942);
    }

    private static final void a(int i2, g gVar) {
        AppMethodBeat.i(204937);
        if (!RiU.containsKey(Integer.valueOf(i2))) {
            RiU.put(Integer.valueOf(i2), gVar);
            a aVar = new a(gVar);
            if (gVar.view.getTag(R.id.c6t) == null) {
                gVar.view.setTag(R.id.c6t, aVar);
                gVar.view.addOnAttachStateChangeListener(aVar);
            }
            Object tag = gVar.view.getTag(R.id.c6t);
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View.OnAttachStateChangeListener");
                AppMethodBeat.o(204937);
                throw tVar;
            }
            gVar.Rjb = (View.OnAttachStateChangeListener) tag;
            e eVar = e.RiQ;
            e.apM(RiU.size());
        }
        AppMethodBeat.o(204937);
    }

    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ g RiV;

        a(g gVar) {
            this.RiV = gVar;
        }

        public final void onViewAttachedToWindow(View view) {
            AppMethodBeat.i(204931);
            p.h(view, "v");
            if (p.j(this.RiV.view, view)) {
                f.b(view.hashCode(), this.RiV);
            }
            AppMethodBeat.o(204931);
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.i(204932);
            p.h(view, "v");
            if (p.j(this.RiV.view, view)) {
                f.apO(view.hashCode());
                e.b bVar = this.RiV.Rjc;
                if (bVar != null) {
                    bVar.p(view, false);
                }
                e.c cVar = this.RiV.Rjd;
                if (cVar != null) {
                    cVar.b(view, v.SXr);
                    AppMethodBeat.o(204932);
                    return;
                }
            }
            AppMethodBeat.o(204932);
        }
    }

    private static final g apN(int i2) {
        AppMethodBeat.i(204938);
        g remove = RiU.remove(Integer.valueOf(i2));
        if (remove != null) {
            remove.Rja = -1;
            remove.Rjb = null;
        }
        e eVar = e.RiQ;
        e.apM(RiU.size());
        AppMethodBeat.o(204938);
        return remove;
    }

    private static final g hF(View view) {
        AppMethodBeat.i(204939);
        g gVar = RiU.get(Integer.valueOf(view.hashCode()));
        AppMethodBeat.o(204939);
        return gVar;
    }

    public static final void a(View view, e.b bVar) {
        AppMethodBeat.i(204940);
        p.h(view, "$this$setOnViewExposedListener");
        if (bVar != null) {
            g hF = hF(view);
            if (hF != null) {
                hF.Rjc = bVar;
                AppMethodBeat.o(204940);
                return;
            }
            g gVar = new g(view);
            gVar.Rjc = bVar;
            a(view.hashCode(), gVar);
            AppMethodBeat.o(204940);
            return;
        }
        g hF2 = hF(view);
        if (hF2 != null) {
            hF2.Rjc = null;
            if (hF2.Rjc == null && hF2.Rjd == null) {
                hF2.view.removeOnAttachStateChangeListener(hF2.Rjb);
                apN(view.hashCode());
            }
            AppMethodBeat.o(204940);
            return;
        }
        AppMethodBeat.o(204940);
    }

    public static final void a(RecyclerView recyclerView, e.a aVar) {
        AppMethodBeat.i(204941);
        p.h(recyclerView, "$this$setOnRecyclerViewChildExposedListener");
        z.d dVar = new z.d();
        dVar.SYE = 0;
        Object tag = recyclerView.getTag(R.id.c6u);
        if (tag != null && (tag instanceof RecyclerView.l)) {
            recyclerView.b((RecyclerView.l) tag);
        }
        c cVar = new c(dVar);
        recyclerView.a(cVar);
        recyclerView.setTag(R.id.c6u, cVar);
        RecyclerView recyclerView2 = recyclerView;
        b bVar = new b(recyclerView, aVar, true, dVar);
        p.h(recyclerView2, "$this$setOnViewGroupChildExposedListener");
        g hF = hF(recyclerView2);
        if (hF != null) {
            hF.Rjd = bVar;
            AppMethodBeat.o(204941);
            return;
        }
        g gVar = new g(recyclerView2);
        gVar.Rjd = bVar;
        a(recyclerView2.hashCode(), gVar);
        AppMethodBeat.o(204941);
    }

    public static final class c extends RecyclerView.l {
        final /* synthetic */ z.d RiZ;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(204936);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(204936);
        }

        c(z.d dVar) {
            this.RiZ = dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(204935);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            this.RiZ.SYE = i2;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(204935);
        }
    }

    public static final class b extends e.c {
        final /* synthetic */ RecyclerView RiW;
        final /* synthetic */ e.a RiX;
        final /* synthetic */ boolean RiY = true;
        final /* synthetic */ z.d RiZ;

        b(RecyclerView recyclerView, e.a aVar, boolean z, z.d dVar) {
            this.RiW = recyclerView;
            this.RiX = aVar;
            this.RiZ = dVar;
        }

        @Override // com.tencent.mm.view.e.c
        public final void b(View view, List<? extends View> list) {
            AppMethodBeat.i(204933);
            p.h(view, "parent");
            p.h(list, "exposedChildren");
            LinkedList linkedList = new LinkedList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                RecyclerView.v bu = this.RiW.bu(it.next());
                if (bu != null) {
                    linkedList.add(bu);
                }
            }
            this.RiX.b(this.RiW, linkedList);
            AppMethodBeat.o(204933);
        }

        @Override // com.tencent.mm.view.e.c
        public final boolean hfA() {
            return this.RiY && this.RiZ.SYE == 2;
        }

        @Override // com.tencent.mm.view.e.c
        public final long hE(View view) {
            AppMethodBeat.i(204934);
            p.h(view, "view");
            System.nanoTime();
            long ae = this.RiX.ae(this.RiW.bu(view));
            AppMethodBeat.o(204934);
            return ae;
        }
    }
}
