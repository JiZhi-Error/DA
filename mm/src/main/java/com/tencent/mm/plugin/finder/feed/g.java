package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract;", "", "()V", "FavFeedPresenter", "FavFeedViewCallback", "plugin-finder_release"})
public final class g {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0013H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
    public static final class a extends c.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(243763);
            AppMethodBeat.o(243763);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a, com.tencent.mm.plugin.finder.feed.c.a
        public final /* synthetic */ void onAttach(c.b bVar) {
            AppMethodBeat.i(243760);
            a(bVar);
            AppMethodBeat.o(243760);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void a(c.b bVar) {
            AppMethodBeat.i(243759);
            p.h(bVar, "callback");
            super.onAttach(bVar);
            AppMethodBeat.o(243759);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a, com.tencent.mm.plugin.finder.feed.c.a
        public final void onDetach() {
            AppMethodBeat.i(243762);
            super.onDetach();
            AppMethodBeat.o(243762);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            AppMethodBeat.i(243755);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
                AppMethodBeat.o(243755);
                return;
            }
            AppMethodBeat.o(243755);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
            AppMethodBeat.i(243756);
            this.tFM.requestRefresh();
            AppMethodBeat.o(243756);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(243757);
            this.tFM.requestLoadMore();
            AppMethodBeat.o(243757);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcp() {
            AppMethodBeat.i(243758);
            BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
            AppMethodBeat.o(243758);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final f dce() {
            AppMethodBeat.i(243761);
            c.b bVar = this.tMd;
            al dcs = bVar != null ? bVar.dcs() : null;
            if (dcs == null) {
                p.hyc();
            }
            f dcK = dcs.dcK();
            AppMethodBeat.o(243761);
            return dcK;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J$\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
    public static class b extends c.b {
        private final String TAG;

        public /* synthetic */ b(MMActivity mMActivity, int i2, int i3, byte b2) {
            this(mMActivity, i2, i3);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private b(MMActivity mMActivity, int i2, int i3) {
            super(mMActivity, i2, i3, false);
            p.h(mMActivity, "context");
            AppMethodBeat.i(243771);
            this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
            AppMethodBeat.o(243771);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(243764);
            RecyclerView.h itemDecoration = dcs().getItemDecoration();
            AppMethodBeat.o(243764);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
            TextView textView;
            AppMethodBeat.i(243765);
            if (dcr().tFM.getSize() <= this.att * 3) {
                BaseFinderFeedLoader baseFinderFeedLoader = dcr().tFM;
                if (baseFinderFeedLoader == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
                    AppMethodBeat.o(243765);
                    throw tVar;
                } else if (((FinderFavFeedLoader) baseFinderFeedLoader).hasMore) {
                    RefreshLoadMoreLayout.c(this.tLS);
                }
            }
            BaseFinderFeedLoader baseFinderFeedLoader2 = dcr().tFM;
            if (baseFinderFeedLoader2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
                AppMethodBeat.o(243765);
                throw tVar2;
            }
            FinderFavFeedLoader finderFavFeedLoader = (FinderFavFeedLoader) baseFinderFeedLoader2;
            finderFavFeedLoader.gAZ--;
            int i2 = finderFavFeedLoader.gAZ;
            View view = this.tMl;
            if (view == null || (textView = (TextView) view.findViewById(R.id.bmr)) == null) {
                AppMethodBeat.o(243765);
                return;
            }
            textView.setText(this.gte.getResources().getString(R.string.cmh, Integer.valueOf(i2)));
            AppMethodBeat.o(243765);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(243766);
            View findViewById = findViewById(R.id.c3e);
            if (!(findViewById instanceof View)) {
                findViewById = null;
            }
            AppMethodBeat.o(243766);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(243767);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = dcs().eS(context);
            AppMethodBeat.o(243767);
            return eS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            AppMethodBeat.i(243768);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(aVar);
            bVar.bm(view);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, bVar.axR());
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((com.tencent.mm.view.recyclerview.g) aVar).RqM.size();
            if (size >= 0 && size < dcq().tFM.getSize()) {
                bo boVar = (bo) dcq().tFM.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof BaseFinderFeed)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
                    AppMethodBeat.o(243768);
                    return;
                }
                Log.i(this.TAG, "onClick " + size + " id:" + ((BaseFinderFeed) boVar).feedObject.getId() + ", pos:" + size);
                Intent intent = new Intent();
                BaseFeedLoader.saveCache$default(dcq().tFM, intent, size, null, 4, null);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.b((Activity) this.gte, intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
            AppMethodBeat.o(243768);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getHeaderView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243769);
            p.h(cVar, "reason");
            String string = this.gte.getResources().getString(R.string.cmi);
            AppMethodBeat.o(243769);
            return string;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243770);
            p.h(cVar, "reason");
            if (cVar.iMa == null) {
                AppMethodBeat.o(243770);
                return null;
            } else if (cVar.iMa instanceof Integer) {
                Resources resources = this.gte.getResources();
                Object[] objArr = new Object[1];
                E e2 = cVar.iMa;
                if (e2 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(243770);
                    throw tVar;
                }
                objArr[0] = e2;
                String string = resources.getString(R.string.cmh, objArr);
                AppMethodBeat.o(243770);
                return string;
            } else {
                AppMethodBeat.o(243770);
                return null;
            }
        }
    }
}