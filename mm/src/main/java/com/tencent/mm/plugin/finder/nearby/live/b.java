package com.tencent.mm.plugin.finder.nearby.live;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract;", "", "Presenter", "ViewCallback", "plugin-finder_release"})
public interface b {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0006H&J\u0016\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\b\u0010\u001a\u001a\u00020\u0006H&J\b\u0010\u001b\u001a\u00020\u0006H&¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getReportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onActionbarClick", "isDouble", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
    public interface a<T extends com.tencent.mm.view.recyclerview.a> extends com.tencent.mm.plugin.finder.presenter.base.a<AbstractC1238b<T>> {
        int getCommentScene();

        void onLoadMore();

        void onRefresh();

        void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000fH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootScrollParent", "Landroid/view/View;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.live.b$b  reason: collision with other inner class name */
    public interface AbstractC1238b<T extends com.tencent.mm.view.recyclerview.a> extends c<a<T>> {
        void ab(ArrayList<T> arrayList);

        RefreshLoadMoreLayout dcQ();

        View dlo();

        RecyclerView getRecyclerView();
    }
}
