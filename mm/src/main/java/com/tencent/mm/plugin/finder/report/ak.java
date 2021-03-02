package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\u0017\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00020\rH&¢\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\rH&¢\u0006\u0002\u0010(J\u000e\u0010*\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010+\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\rH\u0016J \u0010-\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0016R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "ID", "Data", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "statisticUtil", "Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "(Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;)V", "exposeStatisticUtil", "getExposeStatisticUtil", "()Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "setExposeStatisticUtil", "firstVisibleItemPosition", "", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "attachRecyclerView", "", "isStatistic", "", "detachRecyclerView", "getData", FirebaseAnalytics.b.INDEX, "(I)Ljava/lang/Object;", "getId", "handleData", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-finder_release"})
public abstract class ak<ID, Data> extends RecyclerView.l {
    RecyclerView hak;
    private int ptb = -1;
    private int ptc = -1;
    int tIA = -1;
    int tIy = -1;
    public a<ID> viV = new a<>();

    public abstract ID KG(int i2);

    public void b(RecyclerView recyclerView, boolean z) {
        p.h(recyclerView, "recyclerView");
        this.hak = recyclerView;
        recyclerView.a(this);
        a<ID> aVar = this.viV;
        if (aVar != null) {
            aVar.vcL = true;
        }
        if (z) {
            q(recyclerView);
        }
    }

    public void doY() {
        this.hak = null;
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            recyclerView.b(this);
        }
        a<ID> aVar = this.viV;
        if (aVar != null) {
            aVar.vcL = false;
            aVar.vcM = null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        p.h(recyclerView, "recyclerView");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        p.h(recyclerView, "recyclerView");
        q(recyclerView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    }

    private void q(RecyclerView recyclerView) {
        p.h(recyclerView, "recyclerView");
        recyclerView.post(new a(this, recyclerView));
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ID", "Data", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ ak viW;

        a(ak akVar, RecyclerView recyclerView) {
            this.viW = akVar;
            this.tDJ = recyclerView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x0138  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 362
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.ak.a.run():void");
        }
    }
}
