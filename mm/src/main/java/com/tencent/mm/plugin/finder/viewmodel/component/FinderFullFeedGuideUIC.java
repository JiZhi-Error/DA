package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runnable", "Ljava/lang/Runnable;", "showGuideFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onCheckShowGuide", "", "onDestroy", "setRecyclerView", "setShowGuideFeed", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Companion", "plugin-finder_release"})
public final class FinderFullFeedGuideUIC extends UIComponent {
    public static final a wws = new a((byte) 0);
    private final Runnable dQN = new b(this);
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private RecyclerView hak;
    private BaseFinderFeed wwr;

    static {
        AppMethodBeat.i(255546);
        AppMethodBeat.o(255546);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFullFeedGuideUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255544);
        AppMethodBeat.o(255544);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFullFeedGuideUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255545);
        AppMethodBeat.o(255545);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderFullFeedGuideUIC wwt;

        b(FinderFullFeedGuideUIC finderFullFeedGuideUIC) {
            this.wwt = finderFullFeedGuideUIC;
        }

        public final void run() {
            RecyclerView recyclerView;
            RecyclerView.a adapter;
            AppMethodBeat.i(255537);
            RecyclerView recyclerView2 = this.wwt.hak;
            int itemCount = (recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null) ? 0 : adapter.getItemCount();
            Log.i("Finder.FullFeedGuideUIC", "[videoComplete] count=".concat(String.valueOf(itemCount)));
            if (itemCount <= 0 || (recyclerView = this.wwt.hak) == null) {
                AppMethodBeat.o(255537);
                return;
            }
            if (recyclerView.getAdapter() instanceof WxRecyclerAdapter) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_FINDER_FULL_FEED_GUIDE_BOOLEAN, Boolean.TRUE);
                Context context = recyclerView.getContext();
                p.g(context, "it.context");
                recyclerView.smoothScrollBy(0, (int) context.getResources().getDimension(R.dimen.c1));
            }
            AppMethodBeat.o(255537);
        }
    }

    public final void e(bo boVar) {
        RecyclerView.a aVar;
        boolean z = false;
        AppMethodBeat.i(255540);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (!aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FULL_FEED_GUIDE_BOOLEAN, false)) {
            z = true;
        }
        if (z && (boVar instanceof BaseFinderFeed)) {
            ((BaseFinderFeed) boVar).isShowGuideTips = 1;
            this.wwr = (BaseFinderFeed) boVar;
            RecyclerView recyclerView = this.hak;
            if (recyclerView != null) {
                aVar = recyclerView.getAdapter();
            } else {
                aVar = null;
            }
            if (!(aVar instanceof WxRecyclerAdapter)) {
                aVar = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.Or(boVar.lT());
                AppMethodBeat.o(255540);
                return;
            }
        }
        AppMethodBeat.o(255540);
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        AppMethodBeat.i(255541);
        this.hak = recyclerView;
        if (recyclerView != null) {
            recyclerView.a(new c(this));
            AppMethodBeat.o(255541);
            return;
        }
        AppMethodBeat.o(255541);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000o\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isShouldDismiss", "", "()Z", "setShouldDismiss", "(Z)V", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        private float offset = 100.0f;
        private View view;
        final /* synthetic */ FinderFullFeedGuideUIC wwt;
        private boolean wwu;

        c(FinderFullFeedGuideUIC finderFullFeedGuideUIC) {
            this.wwt = finderFullFeedGuideUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            View findViewByPosition;
            AppMethodBeat.i(255538);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                if (this.view == null) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    this.view = (layoutManager == null || (findViewByPosition = layoutManager.findViewByPosition(1)) == null) ? null : findViewByPosition.findViewById(R.id.dmn);
                    View view2 = this.view;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                } else if (this.wwu) {
                    View view3 = this.view;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    BaseFinderFeed baseFinderFeed = this.wwt.wwr;
                    if (baseFinderFeed != null) {
                        baseFinderFeed.isShowGuideTips = -1;
                    }
                }
            } else if (this.view != null && i2 == 1) {
                this.wwu = true;
            }
            if (i2 == 1) {
                this.wwt.hAk.removeCallbacksAndMessages(null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(255538);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(255539);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            View view2 = this.view;
            if (view2 != null) {
                this.offset -= ((float) i3) / 5.0f;
                this.offset = android.support.v4.b.a.p(this.offset, 0.0f, 100.0f);
                view2.setAlpha(this.offset / 100.0f);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(255539);
        }
    }

    public final void dIc() {
        boolean z = false;
        AppMethodBeat.i(255542);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (!aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FULL_FEED_GUIDE_BOOLEAN, false)) {
            z = true;
        }
        Log.i("Finder.FullFeedGuideUIC", "[onCheckShowGuide] isFirst=" + z + ' ');
        if (z) {
            this.hAk.postUIDelayed(this.dQN, 2000);
        }
        AppMethodBeat.o(255542);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255543);
        super.onDestroy();
        this.hAk.removeCallbacksAndMessages(null);
        AppMethodBeat.o(255543);
    }
}
