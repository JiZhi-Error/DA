package com.tencent.mm.plugin.finder.nearby.video;

import android.support.v7.widget.RecyclerView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.nearby.video.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
public final class NearbyVideoPresenter$tagViewActionCallback$1 implements j {
    final /* synthetic */ NearbyVideoPresenter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NearbyVideoPresenter$tagViewActionCallback$1(NearbyVideoPresenter nearbyVideoPresenter) {
        this.this$0 = nearbyVideoPresenter;
    }

    public final WxRecyclerAdapter<?> getAdapter() {
        AppMethodBeat.i(249421);
        RecyclerView.a adapter = this.this$0.getViewCallback().getRecyclerView().getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
            AppMethodBeat.o(249421);
            throw tVar;
        }
        WxRecyclerAdapter<?> wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
        AppMethodBeat.o(249421);
        return wxRecyclerAdapter;
    }

    @Override // com.tencent.mm.view.j
    public final void onChanged() {
        RefreshLoadMoreLayout dcQ;
        AppMethodBeat.i(249422);
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
            AppMethodBeat.o(249422);
            return;
        }
        dcQ.onChanged();
        AppMethodBeat.o(249422);
    }

    @Override // com.tencent.mm.view.j
    public final void onItemRangeChanged(int i2, int i3) {
        RefreshLoadMoreLayout dcQ;
        int i4;
        AppMethodBeat.i(249423);
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
            AppMethodBeat.o(249423);
            return;
        }
        WxRecyclerAdapter<?> adapter = getAdapter();
        if (adapter != null) {
            i4 = adapter.RqM.size();
        } else {
            i4 = 0;
        }
        dcQ.onItemRangeChanged(i4 + i2, i3);
        AppMethodBeat.o(249423);
    }

    @Override // com.tencent.mm.view.j
    public final void onItemRangeChanged(int i2, int i3, Object obj) {
        RefreshLoadMoreLayout dcQ;
        int i4;
        AppMethodBeat.i(249424);
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
            AppMethodBeat.o(249424);
            return;
        }
        WxRecyclerAdapter<?> adapter = getAdapter();
        if (adapter != null) {
            i4 = adapter.RqM.size();
        } else {
            i4 = 0;
        }
        dcQ.onItemRangeChanged(i4 + i2, i3, obj);
        AppMethodBeat.o(249424);
    }

    @Override // com.tencent.mm.view.j
    public final void onItemRangeInserted(int i2, int i3) {
        RefreshLoadMoreLayout dcQ;
        int i4;
        AppMethodBeat.i(249425);
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
            AppMethodBeat.o(249425);
            return;
        }
        WxRecyclerAdapter<?> adapter = getAdapter();
        if (adapter != null) {
            i4 = adapter.RqM.size();
        } else {
            i4 = 0;
        }
        dcQ.onItemRangeInserted(i4 + i2, i3);
        AppMethodBeat.o(249425);
    }

    @Override // com.tencent.mm.view.j
    public final void onItemRangeRemoved(int i2, int i3) {
        RefreshLoadMoreLayout dcQ;
        int i4;
        AppMethodBeat.i(249426);
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
            AppMethodBeat.o(249426);
            return;
        }
        WxRecyclerAdapter<?> adapter = getAdapter();
        if (adapter != null) {
            i4 = adapter.RqM.size();
        } else {
            i4 = 0;
        }
        dcQ.onItemRangeRemoved(i4 + i2, i3);
        AppMethodBeat.o(249426);
    }

    public final void onItemRangeMoved(int i2, int i3, int i4) {
        RefreshLoadMoreLayout dcQ;
        int i5;
        RecyclerView.a adapter;
        int i6 = 0;
        AppMethodBeat.i(249427);
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
            AppMethodBeat.o(249427);
            return;
        }
        WxRecyclerAdapter<?> adapter2 = getAdapter();
        if (adapter2 != null) {
            i5 = adapter2.RqM.size();
        } else {
            i5 = 0;
        }
        int i7 = i5 + i2;
        WxRecyclerAdapter<?> adapter3 = getAdapter();
        if (adapter3 != null) {
            i6 = adapter3.RqM.size();
        }
        int i8 = i6 + i3;
        if (i4 <= 0 || (adapter = dcQ.getRecyclerView().getAdapter()) == null) {
            AppMethodBeat.o(249427);
            return;
        }
        adapter.ar(i7, i8);
        AppMethodBeat.o(249427);
    }

    @Override // com.tencent.mm.view.i
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249428);
        p.h(cVar, "reason");
        this.this$0.getViewCallback().dcQ().onPreFinishRefresh(cVar);
        AppMethodBeat.o(249428);
    }

    @Override // com.tencent.mm.view.i
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249429);
        p.h(cVar, "reason");
        this.this$0.getViewCallback().dcQ().onPreFinishLoadMore(cVar);
        AppMethodBeat.o(249429);
    }

    @Override // com.tencent.mm.view.i
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249430);
        p.h(cVar, "reason");
        this.this$0.getViewCallback().dcQ().onPreFinishLoadMoreSmooth(cVar);
        AppMethodBeat.o(249430);
    }
}
