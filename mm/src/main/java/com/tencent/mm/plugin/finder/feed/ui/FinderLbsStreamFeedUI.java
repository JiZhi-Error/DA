package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.r;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamFeedUI extends FinderBaseGridFeedUI<r.b, r.a> {
    private final String TAG = "Finder.LbsStreamFeedUI";
    private HashMap _$_findViewCache;
    private final int scene = 2;
    public BaseFinderFeedLoader tFM;
    private String title = "";
    private r.a uaZ;
    private r.b uba;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245297);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245297);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245296);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245296);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI$initOnCreate$1$1"})
    static final class a extends q implements b<IResponse<bo>, x> {
        final /* synthetic */ FinderLbsStreamFeedUI ubb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderLbsStreamFeedUI finderLbsStreamFeedUI) {
            super(1);
            this.ubb = finderLbsStreamFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            View view;
            TextView textView4;
            AppMethodBeat.i(245289);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            BaseFinderFeedLoader ddZ = this.ubb.ddZ();
            if (ddZ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader");
                AppMethodBeat.o(245289);
                throw tVar;
            }
            if (!(((FinderLbsStreamFeedLoader) ddZ).gAZ == 0 || (view = FinderLbsStreamFeedUI.a(this.ubb).tMl) == null || (textView4 = (TextView) view.findViewById(R.id.bmr)) == null)) {
                AppCompatActivity context = this.ubb.getContext();
                p.g(context, "context");
                Resources resources = context.getResources();
                Object[] objArr = new Object[1];
                BaseFinderFeedLoader ddZ2 = this.ubb.ddZ();
                if (ddZ2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader");
                    AppMethodBeat.o(245289);
                    throw tVar2;
                }
                objArr[0] = Integer.valueOf(((FinderLbsStreamFeedLoader) ddZ2).gAZ);
                textView4.setText(resources.getString(R.string.cmh, objArr));
            }
            if (!((FinderLbsStreamFeedLoader.c) iResponse2).getHasMore()) {
                View loadMoreFooter = FinderLbsStreamFeedUI.a(this.ubb).tLS.getLoadMoreFooter();
                if (loadMoreFooter != null) {
                    loadMoreFooter.setVisibility(0);
                }
                View loadMoreFooter2 = FinderLbsStreamFeedUI.a(this.ubb).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView3.setText(R.string.d0m);
                }
                View loadMoreFooter3 = FinderLbsStreamFeedUI.a(this.ubb).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter3 == null || (textView2 = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                    textView2.setTextColor(this.ubb.getResources().getColor(R.color.FG_2));
                }
                View loadMoreFooter4 = FinderLbsStreamFeedUI.a(this.ubb).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter4 == null || (textView = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                View loadMoreFooter5 = FinderLbsStreamFeedUI.a(this.ubb).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter5 == null || (findViewById = loadMoreFooter5.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245289);
            return xVar;
        }
    }

    public static final /* synthetic */ r.b a(FinderLbsStreamFeedUI finderLbsStreamFeedUI) {
        AppMethodBeat.i(245295);
        r.b bVar = finderLbsStreamFeedUI.uba;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245295);
        return bVar;
    }

    public final BaseFinderFeedLoader ddZ() {
        AppMethodBeat.i(245290);
        BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
        if (baseFinderFeedLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(245290);
        return baseFinderFeedLoader;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ack;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245291);
        String stringExtra = getIntent().getStringExtra("KEY_UI_TITLE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.title = stringExtra;
        setMMTitle(this.title);
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderLbsStreamFeedLoader finderLbsStreamFeedLoader = new FinderLbsStreamFeedLoader(aUg, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderLbsStreamFeedLoader.initFromCache(intent);
        finderLbsStreamFeedLoader.fetchEndCallback = new a(this);
        this.tFM = finderLbsStreamFeedLoader;
        FinderLbsStreamFeedUI finderLbsStreamFeedUI = this;
        getCommentScene();
        BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
        if (baseFinderFeedLoader == null) {
            p.btv("feedLoader");
        }
        this.uaZ = new r.a(finderLbsStreamFeedUI, baseFinderFeedLoader);
        this.uba = new r.b(this, this.scene, getCommentScene(), this.title);
        r.b bVar = this.uba;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        r.a aVar2 = this.uaZ;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        AppMethodBeat.o(245291);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245294);
        c cVar = c.vCb;
        if (c.dtX().value().intValue() != 0) {
            AppMethodBeat.o(245294);
            return 43;
        }
        AppMethodBeat.o(245294);
        return 16;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ r.a dcq() {
        AppMethodBeat.i(245292);
        r.a aVar = this.uaZ;
        if (aVar == null) {
            p.btv("presenter");
        }
        r.a aVar2 = aVar;
        AppMethodBeat.o(245292);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ r.b ddS() {
        AppMethodBeat.i(245293);
        r.b bVar = this.uba;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        r.b bVar2 = bVar;
        AppMethodBeat.o(245293);
        return bVar2;
    }
}
