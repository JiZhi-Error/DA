package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "feedNonceId", "foldedType", "", "isFullScreen", "", "()Z", "isFullScreen$delegate", "Lkotlin/Lazy;", "mPresenter", "mViewCallback", "nickname", "scene", ch.COL_USERNAME, "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "isOtherEnableFullScreenEnjoy", "plugin-finder_release"})
public final class FinderFriendFoldedTimelineUI extends FinderLoaderFeedUI<FinderFriendFoldedFeedLoader, n.b, n.a> {
    private final String TAG = "Finder.FinderFriendFoldedTimelineUI";
    private HashMap _$_findViewCache;
    private long feedId;
    private String nickname;
    private final int scene = 2;
    private String uaa = "";
    private n.a uau;
    private n.b uav;
    private FinderFriendFoldedFeedLoader uaw;
    private int uax;
    private final f uay = g.ah(new c(this));
    private String username;

    private final boolean isFullScreen() {
        AppMethodBeat.i(245220);
        boolean booleanValue = ((Boolean) this.uay.getValue()).booleanValue();
        AppMethodBeat.o(245220);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245229);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245229);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245228);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245228);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$2"})
    static final class b extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFriendFoldedTimelineUI uaA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFriendFoldedTimelineUI finderFriendFoldedTimelineUI) {
            super(1);
            this.uaA = finderFriendFoldedTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            View findViewById2;
            View findViewById3;
            View findViewById4;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245218);
            p.h(iResponse, LocaleUtil.ITALIAN);
            View loadMoreFooter = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.uaA.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById4 = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById4.setVisibility(0);
            }
            View loadMoreFooter5 = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter5 == null || (findViewById3 = loadMoreFooter5.findViewById(R.id.aq8)) == null)) {
                findViewById3.setBackground(this.uaA.getDrawable(R.drawable.z2));
            }
            View loadMoreFooter6 = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter6 == null || (findViewById2 = loadMoreFooter6.findViewById(R.id.ea_)) == null)) {
                AppCompatActivity context = this.uaA.getContext();
                p.g(context, "context");
                findViewById2.setBackgroundColor(context.getResources().getColor(R.color.v1));
            }
            View loadMoreFooter7 = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter7 == null || (findViewById = loadMoreFooter7.findViewById(R.id.h76)) == null)) {
                AppCompatActivity context2 = this.uaA.getContext();
                p.g(context2, "context");
                findViewById.setBackgroundColor(context2.getResources().getColor(R.color.v1));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245218);
            return xVar;
        }
    }

    public FinderFriendFoldedTimelineUI() {
        AppMethodBeat.i(245226);
        AppMethodBeat.o(245226);
    }

    public static final /* synthetic */ n.b a(FinderFriendFoldedTimelineUI finderFriendFoldedTimelineUI) {
        AppMethodBeat.i(245227);
        n.b bVar = finderFriendFoldedTimelineUI.uav;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        AppMethodBeat.o(245227);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(245221);
        String stringExtra = getIntent().getStringExtra("USERNAME");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.username = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("NICKNAME");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.nickname = stringExtra2;
        this.feedId = getIntent().getLongExtra("FEED_ID", 0);
        String stringExtra3 = getIntent().getStringExtra("FEED_NONCE_ID");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.uaa = stringExtra3;
        this.uax = getIntent().getIntExtra("FOLED_TYPE", 1);
        if (this.uax == 1) {
            Object[] objArr = new Object[1];
            AppCompatActivity context = getContext();
            String str = this.nickname;
            if (str == null) {
                p.btv("nickname");
            }
            objArr[0] = com.tencent.mm.pluginsdk.ui.span.l.c(context, str);
            setMMTitle(getString(R.string.co6, objArr));
        } else if (this.uax == 2) {
            Object[] objArr2 = new Object[1];
            AppCompatActivity context2 = getContext();
            String str2 = this.nickname;
            if (str2 == null) {
                p.btv("nickname");
            }
            objArr2[0] = com.tencent.mm.pluginsdk.ui.span.l.c(context2, str2);
            setMMTitle(getString(R.string.cnk, objArr2));
        } else {
            setMMTitle("");
        }
        FinderFriendFoldedTimelineUI finderFriendFoldedTimelineUI = this;
        long j2 = this.feedId;
        String str3 = this.username;
        if (str3 == null) {
            p.btv(ch.COL_USERNAME);
        }
        this.uau = new n.a(finderFriendFoldedTimelineUI, j2, str3, this.scene, isFullScreen());
        FinderFriendFoldedTimelineUI finderFriendFoldedTimelineUI2 = this;
        n.a aVar = this.uau;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        this.uav = new n.b(finderFriendFoldedTimelineUI2, aVar, this.scene);
        String str4 = this.username;
        if (str4 == null) {
            p.btv(ch.COL_USERNAME);
        }
        long j3 = this.feedId;
        String str5 = this.uaa;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderFriendFoldedFeedLoader finderFriendFoldedFeedLoader = new FinderFriendFoldedFeedLoader(str4, j3, str5, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderFriendFoldedFeedLoader.initFromCache(intent);
        finderFriendFoldedFeedLoader.setInitDone(new a(finderFriendFoldedFeedLoader, this));
        finderFriendFoldedFeedLoader.fetchEndCallback = new b(this);
        this.uaw = finderFriendFoldedFeedLoader;
        AppMethodBeat.o(245221);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements h {
        final /* synthetic */ FinderFriendFoldedTimelineUI uaA;
        final /* synthetic */ FinderFriendFoldedFeedLoader uaz;

        a(FinderFriendFoldedFeedLoader finderFriendFoldedFeedLoader, FinderFriendFoldedTimelineUI finderFriendFoldedTimelineUI) {
            this.uaz = finderFriendFoldedFeedLoader;
            this.uaA = finderFriendFoldedTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245217);
            RecyclerView.LayoutManager layoutManager = FinderFriendFoldedTimelineUI.a(this.uaA).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                AppMethodBeat.o(245217);
            } else if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(245217);
                throw tVar;
            } else {
                ((FinderLinearLayoutManager) layoutManager).ah(this.uaz.getInitPos(), 0);
                AppMethodBeat.o(245217);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final boolean isOtherEnableFullScreenEnjoy() {
        AppMethodBeat.i(245222);
        boolean isFullScreen = isFullScreen();
        AppMethodBeat.o(245222);
        return isFullScreen;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.abh;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 14;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderFriendFoldedTimelineUI uaA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFriendFoldedTimelineUI finderFriendFoldedTimelineUI) {
            super(0);
            this.uaA = finderFriendFoldedTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(245219);
            Boolean valueOf = Boolean.valueOf(this.uaA.getIntent().getBooleanExtra("IS_FULL_SCREEN", false));
            AppMethodBeat.o(245219);
            return valueOf;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ n.a ddK() {
        AppMethodBeat.i(245223);
        n.a aVar = this.uau;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        n.a aVar2 = aVar;
        AppMethodBeat.o(245223);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ n.b ddL() {
        AppMethodBeat.i(245224);
        n.b bVar = this.uav;
        if (bVar == null) {
            p.btv("mViewCallback");
        }
        n.b bVar2 = bVar;
        AppMethodBeat.o(245224);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderFriendFoldedFeedLoader ddM() {
        AppMethodBeat.i(245225);
        FinderFriendFoldedFeedLoader finderFriendFoldedFeedLoader = this.uaw;
        if (finderFriendFoldedFeedLoader == null) {
            p.btv("feedLoader");
        }
        FinderFriendFoldedFeedLoader finderFriendFoldedFeedLoader2 = finderFriendFoldedFeedLoader;
        AppMethodBeat.o(245225);
        return finderFriendFoldedFeedLoader2;
    }
}
