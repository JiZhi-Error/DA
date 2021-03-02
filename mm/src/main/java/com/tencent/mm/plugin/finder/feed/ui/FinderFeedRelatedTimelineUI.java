package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.m;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0011\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0014J\b\u0010&\u001a\u00020$H\u0014J\b\u0010'\u001a\u00020$H\u0014J\b\u0010(\u001a\u00020$H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "TAG", "", "autoRefresh", "", "emptyView", "Landroid/view/View;", "feedId", "", "feedLoader", "feedNonceId", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1;", "mPresenter", "mViewCallback", "relatedScene", "", "getRelatedScene", "()I", "relatedScene$delegate", "Lkotlin/Lazy;", "scene", "title", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "updateTitle", "plugin-finder_release"})
public final class FinderFeedRelatedTimelineUI extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a> {
    private final String TAG = "Finder.FinderFeedReletedTimelineUI";
    private final f UIE = g.ah(new e(this));
    private HashMap _$_findViewCache;
    private long feedId;
    private View poS;
    private final int scene = 2;
    private FinderFeedRelTimelineLoader tZW;
    private m.a tZY;
    private m.b tZZ;
    private String title = "";
    private boolean uW;
    private String uaa = "";
    private final d uac = new d(this);

    private final int hSK() {
        AppMethodBeat.i(260257);
        int intValue = ((Number) this.UIE.getValue()).intValue();
        AppMethodBeat.o(260257);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245188);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245188);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245187);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245187);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$3"})
    static final class b extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFeedRelatedTimelineUI uad;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
            super(1);
            this.uad = finderFeedRelatedTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245171);
            p.h(iResponse, LocaleUtil.ITALIAN);
            FinderFeedRelatedTimelineUI.b(this.uad).setVisibility(8);
            View loadMoreFooter = FinderFeedRelatedTimelineUI.a(this.uad).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderFeedRelatedTimelineUI.a(this.uad).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.uad.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderFeedRelatedTimelineUI.a(this.uad).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderFeedRelatedTimelineUI.a(this.uad).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245171);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$4"})
    static final class c extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFeedRelatedTimelineUI uad;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
            super(1);
            this.uad = finderFeedRelatedTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(245172);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            FinderFeedRelatedTimelineUI.b(this.uad).setVisibility(8);
            if ((iResponse2 instanceof FinderFeedRelTimelineLoader.b) && !Util.isNullOrNil(((FinderFeedRelTimelineLoader.b) iResponse2).title)) {
                this.uad.title = ((FinderFeedRelTimelineLoader.b) iResponse2).title;
                FinderFeedRelatedTimelineUI.c(this.uad);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245172);
            return xVar;
        }
    }

    public FinderFeedRelatedTimelineUI() {
        AppMethodBeat.i(245183);
        AppMethodBeat.o(245183);
    }

    public static final /* synthetic */ m.b a(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
        AppMethodBeat.i(245184);
        m.b bVar = finderFeedRelatedTimelineUI.tZZ;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        AppMethodBeat.o(245184);
        return bVar;
    }

    public static final /* synthetic */ View b(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
        AppMethodBeat.i(245185);
        View view = finderFeedRelatedTimelineUI.poS;
        if (view == null) {
            p.btv("emptyView");
        }
        AppMethodBeat.o(245185);
        return view;
    }

    public static final /* synthetic */ void c(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
        AppMethodBeat.i(245186);
        finderFeedRelatedTimelineUI.updateTitle();
        AppMethodBeat.o(245186);
    }

    public static final /* synthetic */ int d(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
        AppMethodBeat.i(260259);
        int hSK = finderFeedRelatedTimelineUI.hSK();
        AppMethodBeat.o(260259);
        return hSK;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        h cache;
        ArrayList<bo> arrayList;
        ArrayList<bo> arrayList2;
        AppMethodBeat.i(245175);
        this.feedId = getIntent().getLongExtra("FEED_ID", 0);
        String stringExtra = getIntent().getStringExtra("FEED_NONCE_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.uaa = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("TITLE_WORDING");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.title = stringExtra2;
        this.uW = getIntent().getBooleanExtra("AUTO_REFRESH", false);
        float floatExtra = getIntent().getFloatExtra("POI_LATITUDE", 0.0f);
        float floatExtra2 = getIntent().getFloatExtra("POI_LONGITUDE", 0.0f);
        View findViewById = findViewById(R.id.c2i);
        p.g(findViewById, "findViewById(R.id.emptyView)");
        this.poS = findViewById;
        if (this.uW) {
            View view = this.poS;
            if (view == null) {
                p.btv("emptyView");
            }
            view.setVisibility(0);
        }
        updateTitle();
        this.tZY = new m.a(this, this.scene, this.uW);
        FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI = this;
        m.a aVar = this.tZY;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        this.tZZ = new m.b(finderFeedRelatedTimelineUI, aVar, this.scene, getCommentScene());
        long j2 = this.feedId;
        String str = this.uaa;
        int hSK = hSK();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = new FinderFeedRelTimelineLoader(j2, str, 0, null, hSK, false, null, null, null, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx(), floatExtra, floatExtra2, 4072);
        if (!this.uW) {
            Intent intent = getIntent();
            p.g(intent, "intent");
            finderFeedRelTimelineLoader.initFromCache(intent);
            if (!(17 != hSK() || (cache = finderFeedRelTimelineLoader.getCache()) == null || (arrayList = cache.kgc) == null)) {
                if (!arrayList.isEmpty()) {
                    h cache2 = finderFeedRelTimelineLoader.getCache();
                    bo boVar = (cache2 == null || (arrayList2 = cache2.kgc) == null) ? null : arrayList2.get(0);
                    if (!(boVar instanceof BaseFinderFeed)) {
                        boVar = null;
                    }
                    BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
                    if (baseFinderFeed != null) {
                        FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                        k kVar = k.vfA;
                        k.e(feedObject.id, getCommentScene(), feedObject.sessionBuffer);
                    }
                }
            }
        }
        finderFeedRelTimelineLoader.setInitDone(new a(finderFeedRelTimelineLoader, this));
        finderFeedRelTimelineLoader.fetchEndCallback = new b(this);
        finderFeedRelTimelineLoader.tVa = new c(this);
        this.tZW = finderFeedRelTimelineLoader;
        m.b bVar = this.tZZ;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        bVar.tLS.getRecyclerView().a(this.uac);
        AppMethodBeat.o(245175);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderFeedRelTimelineLoader tZf;
        final /* synthetic */ FinderFeedRelatedTimelineUI uad;

        a(FinderFeedRelTimelineLoader finderFeedRelTimelineLoader, FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
            this.tZf = finderFeedRelTimelineLoader;
            this.uad = finderFeedRelatedTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245170);
            RecyclerView.LayoutManager layoutManager = FinderFeedRelatedTimelineUI.a(this.uad).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                AppMethodBeat.o(245170);
            } else if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(245170);
                throw tVar;
            } else {
                ((FinderLinearLayoutManager) layoutManager).ah(this.tZf.getInitPos(), 0);
                AppMethodBeat.o(245170);
            }
        }
    }

    private final void updateTitle() {
        AppMethodBeat.i(245176);
        setMMTitle(this.title);
        AppMethodBeat.o(245176);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ab2;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(260258);
        if (17 == hSK()) {
            AppMethodBeat.o(260258);
            return 96;
        }
        AppMethodBeat.o(260258);
        return 40;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245180);
        m.b bVar = this.tZZ;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        bVar.tLS.getRecyclerView().b(this.uac);
        super.onDestroy();
        AppMethodBeat.o(245180);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245181);
        super.onResume();
        if (17 == hSK()) {
            AppMethodBeat.o(245181);
            return;
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        m.b bVar = this.tZZ;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        com.tencent.mm.plugin.finder.report.live.k.b(bVar.tLS.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "40", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(245181);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245182);
        super.onPause();
        if (17 == hSK()) {
            AppMethodBeat.o(245182);
            return;
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        m.b bVar = this.tZZ;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        com.tencent.mm.plugin.finder.report.live.k.b(bVar.tLS.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "40", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(245182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class d extends RecyclerView.l {
        final /* synthetic */ FinderFeedRelatedTimelineUI uad;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245174);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245174);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
            this.uad = finderFeedRelatedTimelineUI;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245173);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (17 == FinderFeedRelatedTimelineUI.d(this.uad)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(245173);
                return;
            }
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "40", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245173);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderFeedRelatedTimelineUI uad;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFeedRelatedTimelineUI finderFeedRelatedTimelineUI) {
            super(0);
            this.uad = finderFeedRelatedTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260256);
            Integer valueOf = Integer.valueOf(this.uad.getIntent().getIntExtra("GET_REL_SCENE", 5));
            AppMethodBeat.o(260256);
            return valueOf;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ m.a ddK() {
        AppMethodBeat.i(245177);
        m.a aVar = this.tZY;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        m.a aVar2 = aVar;
        AppMethodBeat.o(245177);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ m.b ddL() {
        AppMethodBeat.i(245178);
        m.b bVar = this.tZZ;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        m.b bVar2 = bVar;
        AppMethodBeat.o(245178);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderFeedRelTimelineLoader ddM() {
        AppMethodBeat.i(245179);
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = this.tZW;
        if (finderFeedRelTimelineLoader == null) {
            p.btv("feedLoader");
        }
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader2 = finderFeedRelTimelineLoader;
        AppMethodBeat.o(245179);
        return finderFeedRelTimelineLoader2;
    }
}
