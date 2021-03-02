package com.tencent.mm.plugin.finder.nearby.video;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
public final class NearbyVideoPresenter$onAttach$1 extends RecyclerView.l {
    private byte _hellAccFlag_;
    final /* synthetic */ NearbyVideoPresenter this$0;

    @Override // android.support.v7.widget.RecyclerView.l
    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(249403);
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        super.onScrollStateChanged(recyclerView, i2);
        a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(249403);
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NearbyVideoPresenter$onAttach$1(NearbyVideoPresenter nearbyVideoPresenter) {
        this.this$0 = nearbyVideoPresenter;
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(249402);
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        p.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        NearbyVideoPresenter nearbyVideoPresenter = this.this$0;
        nearbyVideoPresenter.totalDy = nearbyVideoPresenter.totalDy - i3;
        a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(249402);
    }
}
