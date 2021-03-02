package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.e;
import com.tencent.mm.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0002\u001a$\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\t*\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"TAG", "", "updateTimeRecord", "", "set", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "setExposeTimeRecordListener", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Landroid/support/v7/widget/RecyclerView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "libmmui_release"})
public final class c {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0016R&\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, hxF = {"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedRecordsAll", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "getExposedRecordsAll", "()Ljava/util/Set;", "setExposedRecordsAll", "(Ljava/util/Set;)V", "getExposedId", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"})
    public static final class a extends e.a {
        private Set<b<T>> RqB = new HashSet();
        final /* synthetic */ d RqC;

        a(d dVar) {
            this.RqC = dVar;
            AppMethodBeat.i(205036);
            AppMethodBeat.o(205036);
        }

        @Override // com.tencent.mm.view.e.a
        public final void b(View view, List<? extends RecyclerView.v> list) {
            AppMethodBeat.i(205034);
            p.h(view, "parent");
            p.h(list, "exposedHolders");
            if (list.isEmpty()) {
                Log.i("MicroMsg.ExposeTimeRecordListener", "current exposed exposeHolders is empty");
                c.y(this.RqB);
                d dVar = this.RqC;
                if (dVar != null) {
                    dVar.l(this.RqB);
                }
                this.RqB.clear();
                AppMethodBeat.o(205034);
                return;
            }
            HashSet hashSet = new HashSet();
            ArrayList<h> arrayList = new ArrayList();
            for (T t : list) {
                if (t instanceof h) {
                    arrayList.add(t);
                }
            }
            for (h hVar : arrayList) {
                Object hgv = hVar.hgv();
                p.g(hgv, "holder.getAssociatedObject()");
                b bVar = new b((a) hgv);
                if (!this.RqB.contains(bVar)) {
                    bVar.startTime = cl.aWA();
                    bVar.Qgj = hVar.lR();
                    this.RqB.add(bVar);
                    Log.i("MicroMsg.ExposeTimeRecordListener", "add new record: ".concat(String.valueOf(bVar)));
                    d dVar2 = this.RqC;
                    if (dVar2 != null) {
                        dVar2.a(bVar);
                    }
                }
                hashSet.add(bVar);
            }
            if (this.RqB.size() > hashSet.size()) {
                Set a2 = ak.a(this.RqB, hashSet);
                Log.i("MicroMsg.ExposeTimeRecordListener", "find diff record: size = " + a2.size());
                c.y(a2);
                d dVar3 = this.RqC;
                if (dVar3 != null) {
                    dVar3.l(a2);
                }
                Set<b<T>> a3 = ak.a(this.RqB, a2);
                if (!af.fa(a3)) {
                    a3 = null;
                }
                if (a3 != null) {
                    this.RqB = a3;
                    AppMethodBeat.o(205034);
                    return;
                }
            }
            AppMethodBeat.o(205034);
        }

        @Override // com.tencent.mm.view.e.a
        public final long ae(RecyclerView.v vVar) {
            a aVar = null;
            AppMethodBeat.i(205035);
            if (this.RqC != null) {
                h hVar = (h) (!(vVar instanceof h) ? null : vVar);
                a aVar2 = hVar != null ? (a) hVar.hgv() : null;
                if (aVar2 instanceof a) {
                    aVar = aVar2;
                }
                if (aVar != null) {
                    long lT = aVar.lT();
                    AppMethodBeat.o(205035);
                    return lT;
                }
                AppMethodBeat.o(205035);
                return 0;
            }
            long ae = super.ae(vVar);
            AppMethodBeat.o(205035);
            return ae;
        }
    }

    public static final <T extends a> void a(RecyclerView recyclerView, d<T> dVar) {
        AppMethodBeat.i(205039);
        p.h(recyclerView, "$this$setExposeTimeRecordListener");
        f.a(recyclerView, new a(dVar));
        f.a(recyclerView, new b(recyclerView));
        AppMethodBeat.o(205039);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"})
    public static final class b extends e.b {
        final /* synthetic */ RecyclerView RqD;

        b(RecyclerView recyclerView) {
            this.RqD = recyclerView;
        }

        @Override // com.tencent.mm.view.e.b
        public final void p(View view, boolean z) {
            AppMethodBeat.i(205037);
            p.h(view, "view");
            AppMethodBeat.o(205037);
        }

        @Override // com.tencent.mm.view.e.b
        public final long hE(View view) {
            AppMethodBeat.i(205038);
            p.h(view, "view");
            long hashCode = (long) this.RqD.hashCode();
            AppMethodBeat.o(205038);
            return hashCode;
        }
    }

    public static final /* synthetic */ void y(Set set) {
        AppMethodBeat.i(205040);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            bVar.endTime = cl.aWA();
            bVar.wVY = bVar.endTime - bVar.startTime;
            Log.i("MicroMsg.ExposeTimeRecordListener", "updateTimeRecord: ".concat(String.valueOf(bVar)));
        }
        AppMethodBeat.o(205040);
    }
}
