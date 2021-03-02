package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class b {
    public static final b uLL = new b();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
    public static final class a extends a.AbstractC1222a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, FinderFavMegaVideoLoader finderFavMegaVideoLoader) {
            super(mMActivity, finderFavMegaVideoLoader);
            p.h(mMActivity, "context");
            p.h(finderFavMegaVideoLoader, "feedLoader");
            AppMethodBeat.i(248489);
            AppMethodBeat.o(248489);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.b$a$a  reason: collision with other inner class name */
        public static final class C1228a implements f {
            C1228a() {
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                AppMethodBeat.i(248483);
                com.tencent.mm.plugin.finder.megavideo.convert.b bVar = new com.tencent.mm.plugin.finder.megavideo.convert.b();
                AppMethodBeat.o(248483);
                return bVar;
            }
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final f dce() {
            AppMethodBeat.i(248487);
            C1228a aVar = new C1228a();
            AppMethodBeat.o(248487);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void requestRefresh() {
            AppMethodBeat.i(248484);
            this.uLF.requestRefresh();
            AppMethodBeat.o(248484);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void boE() {
            AppMethodBeat.i(248485);
            this.uLF.requestLoadMore();
            AppMethodBeat.o(248485);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void dcp() {
            AppMethodBeat.i(248486);
            BaseFeedLoader.requestInit$default(this.uLF, false, 1, null);
            AppMethodBeat.o(248486);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a
        public final void dcb() {
            AppMethodBeat.i(248488);
            a.b bVar = this.uLE;
            if (bVar != null) {
                bVar.ab(this.uLF.getDataListJustForAdapter());
                AppMethodBeat.o(248488);
                return;
            }
            AppMethodBeat.o(248488);
        }
    }

    static {
        AppMethodBeat.i(248495);
        AppMethodBeat.o(248495);
    }

    private b() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00050\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0006\u0010\u0014\u001a\u00020\r¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "requestLoadMore", "Companion", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.b$b  reason: collision with other inner class name */
    public static final class C1229b extends a.b {
        public static final a uLM = new a((byte) 0);

        static {
            AppMethodBeat.i(248494);
            AppMethodBeat.o(248494);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.b$b$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1229b(MMActivity mMActivity, View view) {
            super(mMActivity, view);
            p.h(mMActivity, "context");
            p.h(view, "rootView");
            AppMethodBeat.i(248493);
            AppMethodBeat.o(248493);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final void dcv() {
            AppMethodBeat.i(248490);
            if (dkm().uLF.getSize() <= 9) {
                BaseMegaVideoLoader baseMegaVideoLoader = dkm().uLF;
                if (baseMegaVideoLoader == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader");
                    AppMethodBeat.o(248490);
                    throw tVar;
                } else if (((FinderFavMegaVideoLoader) baseMegaVideoLoader).hasMore) {
                    RefreshLoadMoreLayout.c(this.tLS);
                }
            }
            BaseMegaVideoLoader baseMegaVideoLoader2 = dkm().uLF;
            if (baseMegaVideoLoader2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader");
                AppMethodBeat.o(248490);
                throw tVar2;
            }
            FinderFavMegaVideoLoader finderFavMegaVideoLoader = (FinderFavMegaVideoLoader) baseMegaVideoLoader2;
            finderFavMegaVideoLoader.gAZ--;
            finderFavMegaVideoLoader.tUU--;
            AppMethodBeat.o(248490);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final void b(RecyclerView.a<?> aVar, View view, int i2) {
            AppMethodBeat.i(248491);
            p.h(aVar, "adapter");
            p.h(view, "view");
            Log.i("FinderFavMegaVideoUIContract.ViewCallback", "onItemClick: position=".concat(String.valueOf(i2)));
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < dkn().uLF.getSize()) {
                bo boVar = (bo) dkn().uLF.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof bm)) {
                    AppMethodBeat.o(248491);
                    return;
                }
                Log.i("FinderFavMegaVideoUIContract.ViewCallback", "onItemClick " + size + " id:" + boVar.lT() + ", pos:" + size);
                Intent intent = new Intent();
                intent.putExtra("KEY_ROUTER_UI", 1);
                BaseFeedLoader.saveCache$default(dkn().uLF, intent, size, null, 4, null);
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.gte, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = view.getContext();
                p.g(context, "view.context");
                com.tencent.mm.plugin.finder.utils.a.ag(context, intent);
            }
            AppMethodBeat.o(248491);
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.a.b
        public final View getEmptyView() {
            AppMethodBeat.i(248492);
            View findViewById = this.lJI.findViewById(R.id.c3e);
            AppMethodBeat.o(248492);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
