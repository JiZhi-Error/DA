package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract;", "", "()V", "LikeFeedPresenter", "LikeFeedViewCallback", "plugin-finder_release"})
public final class u {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
    public static final class a extends c.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(243975);
            AppMethodBeat.o(243975);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            AppMethodBeat.i(243970);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
                AppMethodBeat.o(243970);
                return;
            }
            AppMethodBeat.o(243970);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
            AppMethodBeat.i(243971);
            this.tFM.requestRefresh();
            AppMethodBeat.o(243971);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(243972);
            this.tFM.requestLoadMore();
            AppMethodBeat.o(243972);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcp() {
            AppMethodBeat.i(243973);
            this.tFM.requestInit(true);
            AppMethodBeat.o(243973);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final f dce() {
            AppMethodBeat.i(243974);
            c.b bVar = this.tMd;
            al dcs = bVar != null ? bVar.dcs() : null;
            if (dcs == null) {
                p.hyc();
            }
            f dcK = dcs.dcK();
            AppMethodBeat.o(243974);
            return dcK;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J$\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
    public static final class b extends c.b {
        private final String TAG;

        public /* synthetic */ b(MMActivity mMActivity, int i2, int i3, byte b2) {
            this(mMActivity, i2, i3);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private b(MMActivity mMActivity, int i2, int i3) {
            super(mMActivity, i2, i3, false);
            p.h(mMActivity, "context");
            AppMethodBeat.i(243983);
            this.TAG = "Finder.FinderLikeFeedUIContract.LikeFeedViewCallback";
            AppMethodBeat.o(243983);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(243976);
            RecyclerView.h itemDecoration = dcs().getItemDecoration();
            AppMethodBeat.o(243976);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
            TextView textView;
            AppMethodBeat.i(243977);
            if (dcr().tFM.getSize() <= this.att * 3) {
                BaseFinderFeedLoader baseFinderFeedLoader = dcr().tFM;
                if (baseFinderFeedLoader == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
                    AppMethodBeat.o(243977);
                    throw tVar;
                } else if (((FinderLikedFeedLoader) baseFinderFeedLoader).hasMore) {
                    RefreshLoadMoreLayout.c(this.tLS);
                }
            }
            BaseFinderFeedLoader baseFinderFeedLoader2 = dcr().tFM;
            if (baseFinderFeedLoader2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
                AppMethodBeat.o(243977);
                throw tVar2;
            }
            FinderLikedFeedLoader finderLikedFeedLoader = (FinderLikedFeedLoader) baseFinderFeedLoader2;
            finderLikedFeedLoader.gAZ--;
            int i2 = finderLikedFeedLoader.gAZ;
            View view = this.tMl;
            if (view == null || (textView = (TextView) view.findViewById(R.id.bmr)) == null) {
                AppMethodBeat.o(243977);
                return;
            }
            textView.setText(this.gte.getResources().getString(R.string.cmh, Integer.valueOf(i2)));
            AppMethodBeat.o(243977);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(243979);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = dcs().eS(context);
            AppMethodBeat.o(243979);
            return eS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            AppMethodBeat.i(243980);
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < dcq().tFM.getSize()) {
                bo boVar = (bo) dcq().tFM.getDataListJustForAdapter().get(size);
                if (boVar instanceof BaseFinderFeed) {
                    Log.i(this.TAG, "onClick " + size + " id:" + ((BaseFinderFeed) boVar).feedObject.getId() + ", pos:" + size);
                    Intent intent = new Intent();
                    BaseFeedLoader.saveCache$default(dcr().tFM, intent, size, null, 4, null);
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC.a.a(this.gte, intent, 0, 0, false, 124);
                    com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context = view.getContext();
                    p.g(context, "view.context");
                    com.tencent.mm.plugin.finder.utils.a.U(context, intent);
                }
            }
            AppMethodBeat.o(243980);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getHeaderView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243981);
            p.h(cVar, "reason");
            AppMethodBeat.o(243981);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243982);
            p.h(cVar, "reason");
            AppMethodBeat.o(243982);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(243978);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(243978);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
