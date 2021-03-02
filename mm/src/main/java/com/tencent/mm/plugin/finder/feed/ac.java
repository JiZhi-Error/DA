package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class ac {

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\rH\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
    public static final class a extends c.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(244095);
            AppMethodBeat.o(244095);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            AppMethodBeat.i(244091);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
                AppMethodBeat.o(244091);
                return;
            }
            AppMethodBeat.o(244091);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(244092);
            this.tFM.requestLoadMore();
            AppMethodBeat.o(244092);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcp() {
            AppMethodBeat.i(244093);
            BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
            AppMethodBeat.o(244093);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final f dce() {
            AppMethodBeat.i(244094);
            c.b bVar = this.tMd;
            al dcs = bVar != null ? bVar.dcs() : null;
            if (dcs == null) {
                p.hyc();
            }
            f dcK = dcs.dcK();
            AppMethodBeat.o(244094);
            return dcK;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u0004\u0018\u00010\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J$\u0010%\u001a\u00020&2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020-H\u0016R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
    public static final class b extends c.b {
        private final String TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
        private al tMj;
        private final ato tQh;
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, int i2, int i3, ato ato, String str) {
            super(mMActivity, i2, i3);
            p.h(mMActivity, "context");
            p.h(ato, "req");
            p.h(str, "title");
            AppMethodBeat.i(244102);
            this.tQh = ato;
            this.title = str;
            this.tMj = new com.tencent.mm.plugin.finder.storage.p(mMActivity);
            AppMethodBeat.o(244102);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final al dcs() {
            return this.tMj;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final boolean dct() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            AppMethodBeat.i(244099);
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < dcq().tFM.getSize()) {
                bo boVar = (bo) dcq().tFM.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof BaseFinderFeed)) {
                    AppMethodBeat.o(244099);
                    return;
                }
                Log.i(this.TAG, "onClick " + size + " id:" + ((BaseFinderFeed) boVar).feedObject.getId() + ", pos:" + size);
                Intent intent = new Intent();
                BaseFeedLoader.saveCache$default(dcq().tFM, intent, size, null, 4, null);
                intent.putExtra("KEY_TITLE", this.title);
                intent.putExtra("KEY_REQUEST_PB", this.tQh.toByteArray());
                intent.putExtra("KEY_MORE_ACTION_TYPE", this.gte.getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0));
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                Context context = view.getContext();
                p.g(context, "view.context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.S(this.gte, intent);
            }
            AppMethodBeat.o(244099);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getHeaderView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244100);
            p.h(cVar, "reason");
            AppMethodBeat.o(244100);
            return "";
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244101);
            p.h(cVar, "reason");
            AppMethodBeat.o(244101);
            return "";
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(244096);
            RecyclerView.h itemDecoration = this.tMj.getItemDecoration();
            AppMethodBeat.o(244096);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(244097);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(244097);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(244098);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = this.tMj.eS(context);
            AppMethodBeat.o(244098);
            return eS;
        }
    }
}
