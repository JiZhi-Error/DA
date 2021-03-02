package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a implements e {
    private List<Pair<String, String>> sCM;
    private f sCN;
    WeakReference<g> sCO = null;
    p sCP;
    final RunnableC1012a sCQ = new RunnableC1012a(this, (byte) 0);
    private final RecyclerView.c sCR = new RecyclerView.c() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.a.AnonymousClass1 */

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(220455);
            super.onChanged();
            a.a(a.this);
            AppMethodBeat.o(220455);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(220456);
            super.onItemRangeChanged(i2, i3);
            a.a(a.this);
            AppMethodBeat.o(220456);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(220457);
            super.onItemRangeChanged(i2, i3, obj);
            a.a(a.this);
            AppMethodBeat.o(220457);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(220458);
            super.onItemRangeInserted(i2, i3);
            a.a(a.this);
            AppMethodBeat.o(220458);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(220459);
            super.onItemRangeRemoved(i2, i3);
            a.a(a.this);
            AppMethodBeat.o(220459);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            AppMethodBeat.i(220460);
            super.onItemRangeMoved(i2, i3, i4);
            a.a(a.this);
            AppMethodBeat.o(220460);
        }
    };
    private final b sCS = new b() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.a.AnonymousClass2 */

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
            g gVar;
            g gVar2;
            AppMethodBeat.i(220461);
            if (str.equals("android/support/v7/widget/RecyclerView") || str.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")) {
                if (a.this.sCP == null) {
                    AppMethodBeat.o(220461);
                    return;
                } else if (str2.equals("smoothScrollToPosition") && "(I)V".equals(str3)) {
                    if (!(a.this.sCO == null || (gVar2 = a.this.sCO.get()) == null)) {
                        a.this.sCQ.sCU = true;
                        gVar2.getRecyclerView().post(a.this.sCQ);
                    }
                    AppMethodBeat.o(220461);
                    return;
                } else if (str2.equals("scrollToPosition") && "(I)V".equals(str3) && a.this.sCO != null && (gVar = a.this.sCO.get()) != null) {
                    a.this.sCQ.sCU = true;
                    gVar.getRecyclerView().post(a.this.sCQ);
                }
            }
            AppMethodBeat.o(220461);
        }
    };

    public a() {
        AppMethodBeat.i(220463);
        AppMethodBeat.o(220463);
    }

    public final void a(f fVar, p pVar) {
        AppMethodBeat.i(220464);
        k.sFY.a(this);
        this.sCM = new ArrayList();
        this.sCM.add(Pair.create("smoothScrollToPosition", "(I)V"));
        this.sCM.add(Pair.create("scrollToPosition", "(I)V"));
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(this.sCM, this.sCS);
        this.sCN = fVar;
        this.sCP = pVar;
        AppMethodBeat.o(220464);
    }

    public final void stopMonitor() {
        g gVar;
        AppMethodBeat.i(220465);
        k.sFY.b(this);
        this.sCN = null;
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.b(this.sCM, this.sCS);
        this.sCP = null;
        if (!(this.sCO == null || (gVar = this.sCO.get()) == null)) {
            gVar.b(this.sCR);
            this.sCO.clear();
            this.sCO = null;
        }
        AppMethodBeat.o(220465);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrollStateChanged(android.support.v7.widget.RecyclerView r5, int r6) {
        /*
            r4 = this;
            r3 = 220466(0x35d32, float:3.08939E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            android.support.v7.widget.LinearLayoutManager r0 = l(r5)
            if (r0 != 0) goto L_0x0010
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x000f:
            return
        L_0x0010:
            r0 = 0
            java.lang.ref.WeakReference<com.tencent.mm.view.recyclerview.g> r1 = r4.sCO
            if (r1 == 0) goto L_0x004c
            java.lang.ref.WeakReference<com.tencent.mm.view.recyclerview.g> r0 = r4.sCO
            java.lang.Object r0 = r0.get()
            com.tencent.mm.view.recyclerview.g r0 = (com.tencent.mm.view.recyclerview.g) r0
            if (r0 != 0) goto L_0x0031
            r1 = r0
        L_0x0020:
            android.support.v7.widget.RecyclerView$a r0 = r5.getAdapter()
            boolean r2 = r0 instanceof com.tencent.mm.view.recyclerview.g
            if (r2 == 0) goto L_0x004a
            com.tencent.mm.view.recyclerview.g r0 = (com.tencent.mm.view.recyclerview.g) r0
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r0)
            r4.sCO = r1
        L_0x0031:
            if (r0 == 0) goto L_0x003d
            android.support.v7.widget.RecyclerView$c r1 = r4.sCR
            r0.b(r1)
            android.support.v7.widget.RecyclerView$c r1 = r4.sCR
            r0.a(r1)
        L_0x003d:
            com.tencent.mm.plugin.expt.hellhound.a.a.f r0 = r4.sCN
            if (r0 == 0) goto L_0x0046
            com.tencent.mm.plugin.expt.hellhound.a.a.f r0 = r4.sCN
            r0.k(r5, r6)
        L_0x0046:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x000f
        L_0x004a:
            r0 = r1
            goto L_0x0031
        L_0x004c:
            r1 = r0
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.a.a.onScrollStateChanged(android.support.v7.widget.RecyclerView, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(android.support.v7.widget.RecyclerView r9, int r10) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.a.a.e(android.support.v7.widget.RecyclerView, int):void");
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
    public final void cOE() {
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
    public final void a(m.a aVar) {
        g gVar;
        AppMethodBeat.i(220468);
        if (aVar == null) {
            AppMethodBeat.o(220468);
            return;
        }
        List<?> list = aVar.incrementList;
        if (list == null || list.isEmpty()) {
            Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
            AppMethodBeat.o(220468);
            return;
        }
        Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", Integer.valueOf(aVar.pullType), Integer.valueOf(list.size()));
        if (!(this.sCO == null || (gVar = this.sCO.get()) == null)) {
            this.sCQ.sCU = false;
            gVar.getRecyclerView().post(this.sCQ);
        }
        AppMethodBeat.o(220468);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
    public final void cOF() {
        g gVar;
        AppMethodBeat.i(220469);
        if (!(this.sCO == null || (gVar = this.sCO.get()) == null)) {
            this.sCQ.sCU = false;
            gVar.getRecyclerView().post(this.sCQ);
        }
        AppMethodBeat.o(220469);
    }

    private static LinearLayoutManager l(RecyclerView recyclerView) {
        AppMethodBeat.i(220470);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            AppMethodBeat.o(220470);
            return null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        AppMethodBeat.o(220470);
        return linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.a.a$a  reason: collision with other inner class name */
    public final class RunnableC1012a implements Runnable {
        boolean sCU;

        private RunnableC1012a() {
            this.sCU = false;
        }

        /* synthetic */ RunnableC1012a(a aVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(220462);
            if (a.this.sCP != null) {
                a.this.sCP.md(this.sCU);
            }
            AppMethodBeat.o(220462);
        }
    }

    static /* synthetic */ void a(a aVar) {
        g gVar;
        AppMethodBeat.i(220471);
        if (!(aVar.sCO == null || (gVar = aVar.sCO.get()) == null)) {
            aVar.sCQ.sCU = false;
            gVar.getRecyclerView().post(aVar.sCQ);
        }
        AppMethodBeat.o(220471);
    }
}
