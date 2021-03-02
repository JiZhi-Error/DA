package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.l;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFeedRelTimelineUI extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, l.b, l.a> {
    private final String TAG = "Finder.FinderFeedRelTimelineUI";
    private HashMap _$_findViewCache;
    private int dLS;
    private long feedId;
    private final int scene = 2;
    private l.a tZU;
    private l.b tZV;
    private FinderFeedRelTimelineLoader tZW;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245169);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245169);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245168);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245168);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI$initOnCreate$1$1"})
    static final class a extends q implements b<IResponse<bo>, x> {
        final /* synthetic */ FinderFeedRelTimelineUI tZX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderFeedRelTimelineUI finderFeedRelTimelineUI) {
            super(1);
            this.tZX = finderFeedRelTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245162);
            p.h(iResponse, LocaleUtil.ITALIAN);
            View loadMoreFooter = FinderFeedRelTimelineUI.a(this.tZX).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderFeedRelTimelineUI.a(this.tZX).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.tZX.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderFeedRelTimelineUI.a(this.tZX).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderFeedRelTimelineUI.a(this.tZX).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245162);
            return xVar;
        }
    }

    public static final /* synthetic */ l.b a(FinderFeedRelTimelineUI finderFeedRelTimelineUI) {
        AppMethodBeat.i(245167);
        l.b bVar = finderFeedRelTimelineUI.tZV;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        AppMethodBeat.o(245167);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245163);
        this.feedId = getIntent().getLongExtra("FEED_ID", 0);
        this.dLS = getIntent().getIntExtra("TAB_TYPE", 0);
        setMMTitle("");
        this.tZU = new l.a(this, this.feedId, this.scene);
        FinderFeedRelTimelineUI finderFeedRelTimelineUI = this;
        l.a aVar = this.tZU;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        this.tZV = new l.b(finderFeedRelTimelineUI, aVar, this.scene);
        long j2 = this.feedId;
        int i2 = this.dLS;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = new FinderFeedRelTimelineLoader(j2, "", i2, null, 0, false, null, null, null, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx(), 0.0f, 0.0f, 28664);
        finderFeedRelTimelineLoader.fetchEndCallback = new a(this);
        this.tZW = finderFeedRelTimelineLoader;
        AppMethodBeat.o(245163);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ab1;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 20;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ l.a ddK() {
        AppMethodBeat.i(245164);
        l.a aVar = this.tZU;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        l.a aVar2 = aVar;
        AppMethodBeat.o(245164);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ l.b ddL() {
        AppMethodBeat.i(245165);
        l.b bVar = this.tZV;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        l.b bVar2 = bVar;
        AppMethodBeat.o(245165);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderFeedRelTimelineLoader ddM() {
        AppMethodBeat.i(245166);
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = this.tZW;
        if (finderFeedRelTimelineLoader == null) {
            p.btv("feedLoader");
        }
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader2 = finderFeedRelTimelineLoader;
        AppMethodBeat.o(245166);
        return finderFeedRelTimelineLoader2;
    }
}
