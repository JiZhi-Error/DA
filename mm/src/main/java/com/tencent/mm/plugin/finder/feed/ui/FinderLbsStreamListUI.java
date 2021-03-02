package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.s;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0014J\b\u0010\u001c\u001a\u00020\u0013H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "feedLoader", "onHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1;", "presenter", "saveResult", "", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLbsStreamListUI extends FinderLoaderFeedUI<FinderLbsStreamFeedLoader, s.b, s.a> {
    private final String TAG = "Finder.StreamTimelineUI";
    private HashMap _$_findViewCache;
    private final int scene = 2;
    private s.a ubc;
    private s.b ubd;
    private FinderLbsStreamFeedLoader ube;
    private boolean ubf;
    private final c ubg = new c();

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245314);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245314);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245313);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245313);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$2"})
    static final class b extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderLbsStreamListUI ubi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLbsStreamListUI finderLbsStreamListUI) {
            super(1);
            this.ubi = finderLbsStreamListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(245300);
            p.h(iResponse, LocaleUtil.ITALIAN);
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI.b.AnonymousClass1 */
                final /* synthetic */ b ubj;

                {
                    this.ubj = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    View findViewById;
                    TextView textView;
                    TextView textView2;
                    TextView textView3;
                    AppMethodBeat.i(245299);
                    View loadMoreFooter = FinderLbsStreamListUI.a(this.ubj.ubi).tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView3.setText(R.string.d0m);
                    }
                    View loadMoreFooter2 = FinderLbsStreamListUI.a(this.ubj.ubi).tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView2.setTextColor(this.ubj.ubi.getResources().getColor(R.color.FG_2));
                    }
                    View loadMoreFooter3 = FinderLbsStreamListUI.a(this.ubj.ubi).tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter4 = FinderLbsStreamListUI.a(this.ubj.ubi).tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(245299);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(245300);
            return xVar;
        }
    }

    public FinderLbsStreamListUI() {
        AppMethodBeat.i(245311);
        AppMethodBeat.o(245311);
    }

    public static final /* synthetic */ s.b a(FinderLbsStreamListUI finderLbsStreamListUI) {
        AppMethodBeat.i(245312);
        s.b bVar = finderLbsStreamListUI.ubd;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245312);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245303);
        String stringExtra = getIntent().getStringExtra("KEY_UI_TITLE");
        setTitle(stringExtra != null ? stringExtra : "");
        setMMTitle(getTitle());
        this.ubf = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
        this.ubc = new s.a(this, this.scene, (byte) 0);
        FinderLbsStreamListUI finderLbsStreamListUI = this;
        s.a aVar = this.ubc;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.ubd = new s.b(finderLbsStreamListUI, aVar, this.scene);
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderLbsStreamFeedLoader finderLbsStreamFeedLoader = new FinderLbsStreamFeedLoader(aUg, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderLbsStreamFeedLoader.initFromCache(intent);
        finderLbsStreamFeedLoader.setInitDone(new a(finderLbsStreamFeedLoader, this));
        finderLbsStreamFeedLoader.fetchEndCallback = new b(this);
        this.ube = finderLbsStreamFeedLoader;
        s.b bVar = this.ubd;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        bVar.tLS.getRecyclerView().a(this.ubg);
        AppMethodBeat.o(245303);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements h {
        final /* synthetic */ FinderLbsStreamFeedLoader ubh;
        final /* synthetic */ FinderLbsStreamListUI ubi;

        a(FinderLbsStreamFeedLoader finderLbsStreamFeedLoader, FinderLbsStreamListUI finderLbsStreamListUI) {
            this.ubh = finderLbsStreamFeedLoader;
            this.ubi = finderLbsStreamListUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245298);
            RecyclerView.LayoutManager layoutManager = FinderLbsStreamListUI.a(this.ubi).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                AppMethodBeat.o(245298);
            } else if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(245298);
                throw tVar;
            } else {
                ((FinderLinearLayoutManager) layoutManager).ah(this.ubh.getInitPos(), 0);
                AppMethodBeat.o(245298);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.acl;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 16;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245307);
        if (this.ubf) {
            s.b bVar = this.ubd;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RecyclerView.LayoutManager layoutManager = bVar.tLS.getRecyclerView().getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                y yVar = y.vXH;
                FinderLbsStreamFeedLoader finderLbsStreamFeedLoader = this.ube;
                if (finderLbsStreamFeedLoader == null) {
                    p.btv("feedLoader");
                }
                setResult(-1, y.a(finderLbsStreamFeedLoader, (LinearLayoutManager) layoutManager));
            }
        }
        super.finish();
        AppMethodBeat.o(245307);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245308);
        super.onResume();
        k kVar = k.vkd;
        k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "16", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(245308);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245309);
        super.onPause();
        k kVar = k.vkd;
        k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "16", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(245309);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245310);
        s.b bVar = this.ubd;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        bVar.tLS.getRecyclerView().b(this.ubg);
        super.onDestroy();
        AppMethodBeat.o(245310);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245302);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245302);
        }

        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245301);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            k kVar = k.vkd;
            k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "16", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245301);
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ s.a ddK() {
        AppMethodBeat.i(245304);
        s.a aVar = this.ubc;
        if (aVar == null) {
            p.btv("presenter");
        }
        s.a aVar2 = aVar;
        AppMethodBeat.o(245304);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ s.b ddL() {
        AppMethodBeat.i(245305);
        s.b bVar = this.ubd;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        s.b bVar2 = bVar;
        AppMethodBeat.o(245305);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderLbsStreamFeedLoader ddM() {
        AppMethodBeat.i(245306);
        FinderLbsStreamFeedLoader finderLbsStreamFeedLoader = this.ube;
        if (finderLbsStreamFeedLoader == null) {
            p.btv("feedLoader");
        }
        FinderLbsStreamFeedLoader finderLbsStreamFeedLoader2 = finderLbsStreamFeedLoader;
        AppMethodBeat.o(245306);
        return finderLbsStreamFeedLoader2;
    }
}
