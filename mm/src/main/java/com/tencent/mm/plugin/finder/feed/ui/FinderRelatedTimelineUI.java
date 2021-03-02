package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.ad;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedTimelineUI extends FinderLoaderFeedUI<FinderRelatedLoader, ad.b, ad.a> {
    private final String TAG = "Finder.FinderRelatedTimelineUI";
    private HashMap _$_findViewCache;
    private final int scene = 2;
    private ato tQh;
    private String title = "";
    private ad.a ucH;
    private ad.b ucI;
    private FinderRelatedLoader ucJ;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245515);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245515);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245514);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245514);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$2"})
    static final class b extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderRelatedTimelineUI ucL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderRelatedTimelineUI finderRelatedTimelineUI) {
            super(1);
            this.ucL = finderRelatedTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245506);
            p.h(iResponse, LocaleUtil.ITALIAN);
            View loadMoreFooter = FinderRelatedTimelineUI.a(this.ucL).tLS.getLoadMoreFooter();
            if (loadMoreFooter != null) {
                loadMoreFooter.setVisibility(0);
            }
            View loadMoreFooter2 = FinderRelatedTimelineUI.a(this.ucL).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter3 = FinderRelatedTimelineUI.a(this.ucL).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView2 = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.ucL.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter4 = FinderRelatedTimelineUI.a(this.ucL).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (textView = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter5 = FinderRelatedTimelineUI.a(this.ucL).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter5 == null || (findViewById = loadMoreFooter5.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245506);
            return xVar;
        }
    }

    public static final /* synthetic */ ad.b a(FinderRelatedTimelineUI finderRelatedTimelineUI) {
        AppMethodBeat.i(245513);
        ad.b bVar = finderRelatedTimelineUI.ucI;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245513);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245507);
        String stringExtra = getIntent().getStringExtra("KEY_TITLE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.title = stringExtra;
        setMMTitle(this.title);
        ato ato = new ato();
        try {
            ato.parseFrom(getIntent().getByteArrayExtra("KEY_REQUEST_PB"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            ato = null;
        }
        this.tQh = ato;
        if (this.tQh == null) {
            Log.i(this.TAG, "req is null, finish");
            finish();
            this.tQh = new ato();
        }
        this.ucH = new ad.a(this, this.scene);
        FinderRelatedTimelineUI finderRelatedTimelineUI = this;
        ad.a aVar = this.ucH;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.ucI = new ad.b(finderRelatedTimelineUI, aVar, this.scene, getCommentScene());
        ato ato2 = this.tQh;
        if (ato2 == null) {
            p.hyc();
        }
        int i2 = ato2.dLS;
        int commentScene = getCommentScene();
        ato ato3 = this.tQh;
        if (ato3 == null) {
            p.hyc();
        }
        float f2 = ato3.dTj;
        ato ato4 = this.tQh;
        if (ato4 == null) {
            p.hyc();
        }
        float f3 = ato4.latitude;
        ato ato5 = this.tQh;
        if (ato5 == null) {
            p.hyc();
        }
        bcc bcc = ato5.tvs;
        if (bcc == null) {
            bcc = new bcc();
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderRelatedLoader finderRelatedLoader = new FinderRelatedLoader(i2, commentScene, f2, f3, bcc, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderRelatedLoader.initFromCache(intent);
        finderRelatedLoader.setInitDone(new a(finderRelatedLoader, this));
        finderRelatedLoader.fetchEndCallback = new b(this);
        this.ucJ = finderRelatedLoader;
        AppMethodBeat.o(245507);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements h {
        final /* synthetic */ FinderRelatedLoader ucK;
        final /* synthetic */ FinderRelatedTimelineUI ucL;

        a(FinderRelatedLoader finderRelatedLoader, FinderRelatedTimelineUI finderRelatedTimelineUI) {
            this.ucK = finderRelatedLoader;
            this.ucL = finderRelatedTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245505);
            RecyclerView.LayoutManager layoutManager = FinderRelatedTimelineUI.a(this.ucL).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                AppMethodBeat.o(245505);
            } else if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(245505);
                throw tVar;
            } else {
                ((FinderLinearLayoutManager) layoutManager).ah(this.ucK.getInitPos(), 0);
                AppMethodBeat.o(245505);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajc;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245511);
        int intExtra = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
        if (intExtra == 2) {
            AppMethodBeat.o(245511);
            return 29;
        } else if (intExtra == 1) {
            AppMethodBeat.o(245511);
            return 31;
        } else {
            AppMethodBeat.o(245511);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245512);
        ad.b bVar = this.ucI;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView.LayoutManager layoutManager = bVar.tLS.getRecyclerView().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            y yVar = y.vXH;
            FinderRelatedLoader finderRelatedLoader = this.ucJ;
            if (finderRelatedLoader == null) {
                p.btv("feedLoader");
            }
            setResult(-1, y.a(finderRelatedLoader, (LinearLayoutManager) layoutManager));
        }
        super.finish();
        AppMethodBeat.o(245512);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ ad.a ddK() {
        AppMethodBeat.i(245508);
        ad.a aVar = this.ucH;
        if (aVar == null) {
            p.btv("presenter");
        }
        ad.a aVar2 = aVar;
        AppMethodBeat.o(245508);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ ad.b ddL() {
        AppMethodBeat.i(245509);
        ad.b bVar = this.ucI;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        ad.b bVar2 = bVar;
        AppMethodBeat.o(245509);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderRelatedLoader ddM() {
        AppMethodBeat.i(245510);
        FinderRelatedLoader finderRelatedLoader = this.ucJ;
        if (finderRelatedLoader == null) {
            p.btv("feedLoader");
        }
        FinderRelatedLoader finderRelatedLoader2 = finderRelatedLoader;
        AppMethodBeat.o(245510);
        return finderRelatedLoader2;
    }
}
