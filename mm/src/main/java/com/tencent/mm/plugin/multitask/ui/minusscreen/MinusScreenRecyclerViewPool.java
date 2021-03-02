package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "gridViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getGridViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setGridViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "timelinePool", "getTimelinePool", "Companion", "ui-multitask_release"})
public final class MinusScreenRecyclerViewPool extends ViewModel {
    public static final a AdP = new a((byte) 0);
    private final RecyclerView.m wuu = new b();
    private RecyclerView.m wux = new RecyclerView.m();

    static {
        AppMethodBeat.i(236455);
        AppMethodBeat.o(236455);
    }

    public MinusScreenRecyclerViewPool() {
        AppMethodBeat.i(236454);
        AppMethodBeat.o(236454);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenRecyclerViewPool$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getRecycledView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewType", "", "putRecycledView", "", "scrap", "ui-multitask_release"})
    public static final class b extends RecyclerView.m {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.m
        public final void q(RecyclerView.v vVar) {
            AppMethodBeat.i(236452);
            p.h(vVar, "scrap");
            super.q(vVar);
            if (Log.getLogLevel() <= 1) {
                Log.d("Finder.RecyclerViewPoolVM", "putRecycledView hash=" + vVar.aus.hashCode() + " viewType=" + vVar.lU() + " size=" + cl(vVar.lU()));
            }
            AppMethodBeat.o(236452);
        }

        @Override // android.support.v7.widget.RecyclerView.m
        public final RecyclerView.v cm(int i2) {
            AppMethodBeat.i(236453);
            RecyclerView.v cm = super.cm(i2);
            if (Log.getLogLevel() <= 1) {
                StringBuilder sb = new StringBuilder("getRecycledView hash=");
                View view = cm != null ? cm.aus : null;
                Log.d("Finder.RecyclerViewPoolVM", sb.append(view != null ? view.hashCode() : 0).append(" viewType=").append(i2).append(" size=").append(cl(i2)).toString());
            }
            AppMethodBeat.o(236453);
            return cm;
        }
    }
}
