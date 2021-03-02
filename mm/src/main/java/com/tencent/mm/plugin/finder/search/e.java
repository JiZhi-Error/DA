package com.tencent.mm.plugin.finder.search;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.bbz;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract;", "", "Presenter", "ViewCallback", "plugin-finder_release"})
public interface e {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000fH&J\b\u0010\u0017\u001a\u00020\u0018H&J*\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "", "type", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "jumpToLive", "feed", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "startSearchQuery", SearchIntents.EXTRA_QUERY, "isFromHistory", "isFromHot", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
    public interface a extends com.tencent.mm.plugin.finder.presenter.base.a<b> {
        void K(long j2, int i2);

        void a(bbz bbz, int i2);

        void ae(String str, int i2, int i3);

        List<BaseFinderFeed> cYD();

        List<bbz> dpA();

        void dpB();

        boolean dpC();

        void q(BaseFinderFeed baseFinderFeed);

        void r(BaseFinderFeed baseFinderFeed);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0004H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "notifyItemChanged", "", "position", "", "onSearchCallback", "originContactSize", "originFeedSize", "onStartSearch", "onTextChange", SearchIntents.EXTRA_QUERY, "", "plugin-finder_release"})
    public interface b extends c<a> {
        void ci(int i2);

        void dpE();

        void gg(int i2, int i3);
    }
}
