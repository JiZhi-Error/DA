package com.tencent.mm.plugin.finder.live;

import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveContract;", "", "Presenter", "ViewCallback", "plugin-finder_release"})
public interface c {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "canLoadMore", "", "flingUpType", "isEnableNestedScroll", "loadMoreData", "", "preloadData", "newPos", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "plugin-finder_release"})
    public interface a extends com.tencent.mm.plugin.finder.presenter.base.a<b> {
        boolean IX(int i2);

        void boE();

        boolean deK();

        boolean deL();

        boolean deM();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0004H&J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000bH&J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH&J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0018\u001a\u00020\u0004H&¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "initView", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "keyboardChange", "show", "", "height", "", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onInit", "onLoadMoreResult", "pullType", "incrementSize", "onNewIntent", "intent", "onPreloadResult", "onUninit", "plugin-finder_release"})
    public interface b extends com.tencent.mm.plugin.finder.presenter.base.c<a> {
    }
}