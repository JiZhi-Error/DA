package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract;", "", "()V", "LbsStreamFeedPresenter", "LbsStreamFeedViewCallback", "plugin-finder_release"})
public final class r {
    public static final r tOt = new r();

    static {
        AppMethodBeat.i(243911);
        AppMethodBeat.o(243911);
    }

    private r() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"})
    public static final class a extends c.a {
        public static final C1164a tOu = new C1164a((byte) 0);

        static {
            AppMethodBeat.i(243903);
            AppMethodBeat.o(243903);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.r$a$a  reason: collision with other inner class name */
        public static final class C1164a {
            private C1164a() {
            }

            public /* synthetic */ C1164a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(243902);
            AppMethodBeat.o(243902);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a, com.tencent.mm.plugin.finder.feed.c.a
        public final /* synthetic */ void onAttach(c.b bVar) {
            AppMethodBeat.i(243899);
            a(bVar);
            AppMethodBeat.o(243899);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void a(c.b bVar) {
            AppMethodBeat.i(243898);
            p.h(bVar, "callback");
            super.onAttach(bVar);
            AppMethodBeat.o(243898);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a, com.tencent.mm.plugin.finder.feed.c.a
        public final void onDetach() {
            AppMethodBeat.i(243901);
            super.onDetach();
            FinderLbsStreamFeedLoader.a aVar = FinderLbsStreamFeedLoader.tVL;
            Log.i(FinderLbsStreamFeedLoader.TAG, "clearCache");
            FinderLbsStreamFeedLoader.tVK.clear();
            AppMethodBeat.o(243901);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            AppMethodBeat.i(243895);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
                AppMethodBeat.o(243895);
                return;
            }
            AppMethodBeat.o(243895);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(243896);
            this.tFM.requestLoadMore();
            AppMethodBeat.o(243896);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcp() {
            AppMethodBeat.i(243897);
            BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
            AppMethodBeat.o(243897);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final f dce() {
            AppMethodBeat.i(243900);
            c.b bVar = this.tMd;
            al dcs = bVar != null ? bVar.dcs() : null;
            if (dcs == null) {
                p.hyc();
            }
            f dcK = dcs.dcK();
            AppMethodBeat.o(243900);
            return dcK;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J$\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
    public static final class b extends c.b {
        private final String TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, int i2, int i3, String str) {
            super(mMActivity, i2, i3);
            p.h(mMActivity, "context");
            p.h(str, "title");
            AppMethodBeat.i(243910);
            this.title = str;
            AppMethodBeat.o(243910);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final boolean dct() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(243904);
            RecyclerView.h itemDecoration = dcs().getItemDecoration();
            AppMethodBeat.o(243904);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(243906);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = dcs().eS(context);
            AppMethodBeat.o(243906);
            return eS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            bbn dIx;
            AppMethodBeat.i(243907);
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < dcq().tFM.getSize()) {
                bo boVar = (bo) dcq().tFM.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof BaseFinderFeed)) {
                    AppMethodBeat.o(243907);
                    return;
                }
                Log.i(this.TAG, "onClick " + size + " id:" + ((BaseFinderFeed) boVar).feedObject.getId() + ", pos:" + size);
                Intent intent = new Intent();
                BaseFeedLoader.saveCache$default(dcq().tFM, intent, size, null, 4, null);
                intent.putExtra("KEY_UI_TITLE", this.title);
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                Context context = view.getContext();
                p.g(context, "view.context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context2 = view.getContext();
                p.g(context2, "view.context");
                com.tencent.mm.plugin.finder.utils.a.Q(context2, intent);
                FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                Context context3 = view.getContext();
                p.g(context3, "view.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                if (!(fH == null || (dIx = fH.dIx()) == null)) {
                    k kVar = k.vfA;
                    k.a(dIx, ((BaseFinderFeed) boVar).feedObject.getId(), this.tLS.getRecyclerView());
                    AppMethodBeat.o(243907);
                    return;
                }
            }
            AppMethodBeat.o(243907);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getHeaderView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243908);
            p.h(cVar, "reason");
            AppMethodBeat.o(243908);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243909);
            p.h(cVar, "reason");
            AppMethodBeat.o(243909);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(243905);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(243905);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
