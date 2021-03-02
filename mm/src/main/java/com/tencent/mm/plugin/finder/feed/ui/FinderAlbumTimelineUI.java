package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.m;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 F2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002FGB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010?\u001a\u00020\u0007H\u0016J\b\u0010@\u001a\u00020\u0007H\u0014J\b\u0010A\u001a\u00020\u0002H\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\b\u0010D\u001a\u00020\u0003H\u0016J\b\u0010E\u001a\u00020<H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010\u001f\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R#\u0010(\u001a\n **\u0004\u0018\u00010)0)8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b0\u00101R\u000e\u00103\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b5\u0010\u001aR\u001b\u00107\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b:\u0010\u000e\u001a\u0004\b8\u00109¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "MENU_ID_SHARE_TO_CHAT", "", "MENU_ID_SHARE_TO_SNS", "cardId", "", "getCardId", "()J", "cardId$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "feedLoader$delegate", "fromShareScene", "getFromShareScene", "()I", "fromShareScene$delegate", "getRelatedScene", "getGetRelatedScene", "getRelatedScene$delegate", "p", "getP", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "p$delegate", "relatedRequest", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "getRelatedRequest", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "relatedRequest$delegate", "sharedUsername", "", "kotlin.jvm.PlatformType", "getSharedUsername", "()Ljava/lang/String;", "sharedUsername$delegate", "streamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getStreamCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "streamCard$delegate", "title", "txtCardIndex", "getTxtCardIndex", "txtCardIndex$delegate", "vc", "getVc", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "vc$delegate", "clickMoreMenu", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "Companion", "RelatedRequest", "plugin-finder_release"})
public final class FinderAlbumTimelineUI extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a> {
    private static final String TAG = TAG;
    public static final a tZc = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final kotlin.f tPy = kotlin.g.ah(new h(this));
    private final kotlin.f tYS = kotlin.g.ah(new p(this));
    private final kotlin.f tYT = kotlin.g.ah(new u(this));
    private final kotlin.f tYU = kotlin.g.ah(new g(this));
    private final kotlin.f tYV = kotlin.g.ah(new j(this));
    private final kotlin.f tYW = kotlin.g.ah(new s(this));
    private final kotlin.f tYX = kotlin.g.ah(new t(this));
    private final kotlin.f tYY = kotlin.g.ah(new c(this));
    private final kotlin.f tYZ = kotlin.g.ah(new i(this));
    private final kotlin.f tZa = kotlin.g.ah(new r(this));
    private final kotlin.f tZb = kotlin.g.ah(new q(this));
    private String title;
    private final int tqv = 101;
    private final int tzY = 102;

    private final m.a ddD() {
        AppMethodBeat.i(245066);
        m.a aVar = (m.a) this.tYS.getValue();
        AppMethodBeat.o(245066);
        return aVar;
    }

    private final m.b ddE() {
        AppMethodBeat.i(245067);
        m.b bVar = (m.b) this.tYT.getValue();
        AppMethodBeat.o(245067);
        return bVar;
    }

    private final int ddF() {
        AppMethodBeat.i(245068);
        int intValue = ((Number) this.tYV.getValue()).intValue();
        AppMethodBeat.o(245068);
        return intValue;
    }

    private final bcu ddG() {
        AppMethodBeat.i(245069);
        bcu bcu = (bcu) this.tYW.getValue();
        AppMethodBeat.o(245069);
        return bcu;
    }

    private final long ddH() {
        AppMethodBeat.i(245070);
        long longValue = ((Number) this.tYY.getValue()).longValue();
        AppMethodBeat.o(245070);
        return longValue;
    }

    private final b ddI() {
        AppMethodBeat.i(245071);
        b bVar = (b) this.tZb.getValue();
        AppMethodBeat.o(245071);
        return bVar;
    }

    private final FinderFeedRelTimelineLoader ddJ() {
        AppMethodBeat.i(245072);
        FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = (FinderFeedRelTimelineLoader) this.tPy.getValue();
        AppMethodBeat.o(245072);
        return finderFeedRelTimelineLoader;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245090);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245090);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245089);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245089);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$2"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(1);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            AppMethodBeat.i(245056);
            kotlin.g.b.p.h(iResponse, LocaleUtil.ITALIAN);
            View loadMoreFooter = FinderAlbumTimelineUI.b(this.tZd).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter2 = FinderAlbumTimelineUI.b(this.tZd).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (findViewById = loadMoreFooter2.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245056);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$3"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;
        final /* synthetic */ FinderFeedRelTimelineLoader tZf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderFeedRelTimelineLoader finderFeedRelTimelineLoader, FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(1);
            this.tZf = finderFeedRelTimelineLoader;
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(245057);
            kotlin.g.b.p.h(iResponse, "resp");
            if (this.tZf.getSize() == 0) {
                FrameLayout frameLayout = (FrameLayout) this.tZd._$_findCachedViewById(R.id.c2i);
                kotlin.g.b.p.g(frameLayout, "emptyView");
                frameLayout.setVisibility(0);
            } else {
                FrameLayout frameLayout2 = (FrameLayout) this.tZd._$_findCachedViewById(R.id.c2i);
                kotlin.g.b.p.g(frameLayout2, "emptyView");
                frameLayout2.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245057);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$4"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;
        final /* synthetic */ FinderFeedRelTimelineLoader tZf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(FinderFeedRelTimelineLoader finderFeedRelTimelineLoader, FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(1);
            this.tZf = finderFeedRelTimelineLoader;
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(245058);
            kotlin.g.b.p.h(iResponse, "resp");
            if (this.tZf.getSize() == 0) {
                FrameLayout frameLayout = (FrameLayout) this.tZd._$_findCachedViewById(R.id.c2i);
                kotlin.g.b.p.g(frameLayout, "emptyView");
                frameLayout.setVisibility(0);
            } else {
                FrameLayout frameLayout2 = (FrameLayout) this.tZd._$_findCachedViewById(R.id.c2i);
                kotlin.g.b.p.g(frameLayout2, "emptyView");
                frameLayout2.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245058);
            return xVar;
        }
    }

    public FinderAlbumTimelineUI() {
        AppMethodBeat.i(245077);
        AppMethodBeat.o(245077);
    }

    public static final /* synthetic */ m.b b(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245080);
        m.b ddE = finderAlbumTimelineUI.ddE();
        AppMethodBeat.o(245080);
        return ddE;
    }

    public static final /* synthetic */ int e(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245081);
        int ddF = finderAlbumTimelineUI.ddF();
        AppMethodBeat.o(245081);
        return ddF;
    }

    public static final /* synthetic */ bcu f(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245082);
        bcu ddG = finderAlbumTimelineUI.ddG();
        AppMethodBeat.o(245082);
        return ddG;
    }

    public static final /* synthetic */ long h(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245084);
        long ddH = finderAlbumTimelineUI.ddH();
        AppMethodBeat.o(245084);
        return ddH;
    }

    public static final /* synthetic */ m.a i(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245085);
        m.a ddD = finderAlbumTimelineUI.ddD();
        AppMethodBeat.o(245085);
        return ddD;
    }

    public static final /* synthetic */ b k(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245087);
        b ddI = finderAlbumTimelineUI.ddI();
        AppMethodBeat.o(245087);
        return ddI;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$Companion;", "", "()V", "REQUEST_TYPE_SHARE", "", "REQUEST_TYPE_TAB_STREAM", "REQUEST_TYPE_TXT_CARD", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245078);
        AppMethodBeat.o(245078);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "", "scene", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getScene", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class b {
        final int scene;
        final ato tta;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.tta, r4.tta) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 245045(0x3bd35, float:3.43381E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI.b
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI$b r4 = (com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI.b) r4
                int r0 = r3.scene
                int r1 = r4.scene
                if (r0 != r1) goto L_0x0023
                com.tencent.mm.protocal.protobuf.ato r0 = r3.tta
                com.tencent.mm.protocal.protobuf.ato r1 = r4.tta
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(245044);
            int i2 = this.scene * 31;
            ato ato = this.tta;
            int hashCode = (ato != null ? ato.hashCode() : 0) + i2;
            AppMethodBeat.o(245044);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(245043);
            String str = "RelatedRequest(scene=" + this.scene + ", request=" + this.tta + ")";
            AppMethodBeat.o(245043);
            return str;
        }

        public b(int i2, ato ato) {
            kotlin.g.b.p.h(ato, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            AppMethodBeat.i(245042);
            this.scene = i2;
            this.tta = ato;
            AppMethodBeat.o(245042);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        com.tencent.mm.bw.b bVar = null;
        boolean z = true;
        AppMethodBeat.i(245073);
        String stringExtra = getIntent().getStringExtra("TITLE_WORDING");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.title = stringExtra;
        String str = this.title;
        if (str == null) {
            kotlin.g.b.p.btv("title");
        }
        setMMTitle(str);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvy().value().intValue() == 1) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, new o(this));
        }
        bcu ddG = ddG();
        if (ddG != null) {
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            LinkedList<FinderObject> linkedList = ddG.object;
            kotlin.g.b.p.g(linkedList, "it.`object`");
            e.a.k(51, linkedList);
            LinkedList<FinderObject> linkedList2 = ddG.object;
            kotlin.g.b.p.g(linkedList2, "it.`object`");
            for (T t2 : linkedList2) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.e(t2.id, 51, t2.sessionBuffer);
            }
        }
        b ddI = ddI();
        if (ddI != null && ddI.scene == 3) {
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            int intValue = ((Number) this.tYZ.getValue()).intValue();
            String str2 = (String) this.tZa.getValue();
            kotlin.g.b.p.g(str2, "sharedUsername");
            long ddH = ddH();
            kotlin.g.b.p.h(str2, "fromUser");
            bq bqVar = new bq();
            String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            bqVar.jP(cMD);
            bqVar.eq((long) intValue);
            bqVar.er(5);
            bqVar.jQ(str2);
            bqVar.jV(com.tencent.mm.ac.d.zs(ddH));
            bqVar.bfK();
            com.tencent.mm.plugin.finder.report.k.a(bqVar);
        }
        String str3 = TAG;
        StringBuilder sb = new StringBuilder("[initOnCreate] relatedRequest=");
        b ddI2 = ddI();
        StringBuilder append = sb.append(ddI2 != null ? Integer.valueOf(ddI2.scene) : null).append(" getRelatedScene=").append(ddF()).append(" title=");
        String str4 = this.title;
        if (str4 == null) {
            kotlin.g.b.p.btv("title");
        }
        StringBuilder append2 = append.append(str4).append(' ').append("streamCardId=");
        bcu ddG2 = ddG();
        StringBuilder append3 = append2.append(com.tencent.mm.ac.d.zs(ddG2 != null ? ddG2.id : 0)).append(" cardId=").append(com.tencent.mm.ac.d.zs(ddH())).append(' ').append("continueAtTheEnd=");
        bcu ddG3 = ddG();
        StringBuilder append4 = append3.append(ddG3 != null ? Boolean.valueOf(ddG3.uOm) : null).append(" streamCard cardBuffer=");
        bcu ddG4 = ddG();
        if (ddG4 != null) {
            bVar = ddG4.tVe;
        }
        Log.i(str3, append4.append(bVar != null).toString());
        FinderFeedRelTimelineLoader ddJ = ddJ();
        Intent intent = getIntent();
        kotlin.g.b.p.g(intent, "intent");
        ddJ.initFromCache(intent);
        ddJ.setInitDone(new k(ddJ, this));
        ddJ.fetchEndCallback = new l(this);
        ddJ.tVa = new m(ddJ, this);
        ddJ.tVb = new n(ddJ, this);
        b ddI3 = ddI();
        if (ddI3 != null && ddI3.scene == 3) {
            ddJ().requestRefresh();
        }
        FinderFeedRelTimelineLoader ddJ2 = ddJ();
        bcu ddG5 = ddG();
        if (ddG5 != null) {
            z = ddG5.uOm;
        }
        ddJ2.tVc = z;
        AppMethodBeat.o(245073);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class o implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        o(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            this.tZd = finderAlbumTimelineUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245059);
            FinderAlbumTimelineUI.a(this.tZd);
            AppMethodBeat.o(245059);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class k implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderAlbumTimelineUI tZd;
        final /* synthetic */ FinderFeedRelTimelineLoader tZf;

        k(FinderFeedRelTimelineLoader finderFeedRelTimelineLoader, FinderAlbumTimelineUI finderAlbumTimelineUI) {
            this.tZf = finderFeedRelTimelineLoader;
            this.tZd = finderAlbumTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245055);
            if (i2 == 0) {
                FrameLayout frameLayout = (FrameLayout) this.tZd._$_findCachedViewById(R.id.c2i);
                kotlin.g.b.p.g(frameLayout, "emptyView");
                frameLayout.setVisibility(0);
            } else {
                FrameLayout frameLayout2 = (FrameLayout) this.tZd._$_findCachedViewById(R.id.c2i);
                kotlin.g.b.p.g(frameLayout2, "emptyView");
                frameLayout2.setVisibility(8);
            }
            RecyclerView.LayoutManager layoutManager = FinderAlbumTimelineUI.b(this.tZd).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                AppMethodBeat.o(245055);
            } else if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(245055);
                throw tVar;
            } else {
                ((FinderLinearLayoutManager) layoutManager).ah(this.tZf.getInitPos(), 0);
                AppMethodBeat.o(245055);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        d(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            this.tZd = finderAlbumTimelineUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(245047);
            kotlin.g.b.p.g(mVar, "menu");
            if (mVar.gKQ()) {
                AppCompatActivity context = this.tZd.getContext();
                kotlin.g.b.p.g(context, "context");
                mVar.a(this.tZd.tqv, (CharSequence) this.tZd.getContext().getString(R.string.yz), R.raw.finder_icons_filled_share, context.getResources().getColor(R.color.Brand), false);
                mVar.a(this.tZd.tzY, (CharSequence) this.tZd.getContext().getString(R.string.d9p), R.raw.bottomsheet_icon_moment, 0, false);
            }
            AppMethodBeat.o(245047);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        e(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            this.tZd = finderAlbumTimelineUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(245048);
            String str = FinderAlbumTimelineUI.TAG;
            StringBuilder sb = new StringBuilder("[clickMoreMenu] itemId=");
            kotlin.g.b.p.g(menuItem, "menuItem");
            Log.i(str, sb.append(menuItem.getItemId()).append(" getRelatedScene=").append(FinderAlbumTimelineUI.e(this.tZd)).append(" streamCard=").append(FinderAlbumTimelineUI.f(this.tZd) != null).toString());
            if (menuItem.getItemId() != this.tZd.tqv) {
                if (menuItem.getItemId() == this.tZd.tzY) {
                    if (FinderAlbumTimelineUI.e(this.tZd) == 10 || FinderAlbumTimelineUI.e(this.tZd) == 11) {
                        com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                        bcu f2 = FinderAlbumTimelineUI.f(this.tZd);
                        if (f2 != null) {
                            s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
                            cVar.jle = s.a.b(f2);
                        }
                        com.tencent.mm.plugin.finder.utils.s.vWt.a(this.tZd, cVar, FinderAlbumTimelineUI.g(this.tZd));
                        AppMethodBeat.o(245048);
                        return;
                    } else if (FinderAlbumTimelineUI.e(this.tZd) == 14) {
                        com.tencent.mm.modelsns.c cVar2 = new com.tencent.mm.modelsns.c();
                        byte[] byteArrayExtra = this.tZd.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
                        if (byteArrayExtra != null) {
                            cVar2.jle.parseFrom(byteArrayExtra);
                        }
                        com.tencent.mm.plugin.finder.utils.s.vWt.a(this.tZd, cVar2, FinderAlbumTimelineUI.g(this.tZd));
                    }
                }
                AppMethodBeat.o(245048);
            } else if (FinderAlbumTimelineUI.e(this.tZd) == 10 || FinderAlbumTimelineUI.e(this.tZd) == 11) {
                bcu f3 = FinderAlbumTimelineUI.f(this.tZd);
                if (f3 != null) {
                    s.a aVar2 = com.tencent.mm.plugin.finder.utils.s.vWt;
                    FinderAlbumTimelineUI finderAlbumTimelineUI = this.tZd;
                    bbn g2 = FinderAlbumTimelineUI.g(this.tZd);
                    kotlin.g.b.p.h(finderAlbumTimelineUI, "context");
                    kotlin.g.b.p.h(f3, "card");
                    com.tencent.mm.plugin.i.a.d dVar = new com.tencent.mm.plugin.i.a.d();
                    bcf b2 = s.a.b(f3);
                    kotlin.g.b.p.h(b2, "<set-?>");
                    dVar.jle = b2;
                    aVar2.a(finderAlbumTimelineUI, dVar, g2);
                    AppMethodBeat.o(245048);
                    return;
                }
                AppMethodBeat.o(245048);
            } else {
                if (FinderAlbumTimelineUI.e(this.tZd) == 14) {
                    com.tencent.mm.plugin.i.a.d dVar2 = new com.tencent.mm.plugin.i.a.d();
                    byte[] byteArrayExtra2 = this.tZd.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
                    if (byteArrayExtra2 != null) {
                        dVar2.jle.parseFrom(byteArrayExtra2);
                    }
                    com.tencent.mm.plugin.finder.utils.s.vWt.a(this.tZd, dVar2, FinderAlbumTimelineUI.g(this.tZd));
                }
                AppMethodBeat.o(245048);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class f implements e.b {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        f(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            this.tZd = finderAlbumTimelineUI;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(245049);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(FinderAlbumTimelineUI.h(this.tZd), 0, 3, "", 0, FinderAlbumTimelineUI.g(this.tZd));
            AppMethodBeat.o(245049);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ab2;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 51;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<m.a> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ m.a invoke() {
            AppMethodBeat.i(245060);
            m.a aVar = new m.a(this.tZd, 2, false);
            AppMethodBeat.o(245060);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<m.b> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ m.b invoke() {
            AppMethodBeat.i(245065);
            m.b bVar = new m.b(this.tZd, FinderAlbumTimelineUI.i(this.tZd), 2, 51);
            AppMethodBeat.o(245065);
            return bVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<bbn> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ bbn invoke() {
            AppMethodBeat.i(245050);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tZd).get(FinderReporterUIC.class)).dIx();
            AppMethodBeat.o(245050);
            return dIx;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245054);
            Integer valueOf = Integer.valueOf(this.tZd.getIntent().getIntExtra("GET_REL_SCENE", 0));
            AppMethodBeat.o(245054);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<bcu> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ bcu invoke() {
            AppMethodBeat.i(245063);
            byte[] byteArrayExtra = this.tZd.getIntent().getByteArrayExtra("STREAM_CARD");
            if (byteArrayExtra == null) {
                AppMethodBeat.o(245063);
                return null;
            }
            bcu bcu = new bcu();
            bcu.parseFrom(byteArrayExtra);
            AppMethodBeat.o(245063);
            return bcu;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245064);
            Integer valueOf = Integer.valueOf(this.tZd.getIntent().getIntExtra("STREAM_TXT_CARD_INDEX", 0));
            AppMethodBeat.o(245064);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Long> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(245046);
            Long valueOf = Long.valueOf(this.tZd.getIntent().getLongExtra("CARD_ID", 0));
            AppMethodBeat.o(245046);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245053);
            Integer valueOf = Integer.valueOf(this.tZd.getIntent().getIntExtra("FROM_SHARE_SCENE", 0));
            AppMethodBeat.o(245053);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245062);
            String stringExtra = this.tZd.getIntent().getStringExtra("SHARED_USERNAME");
            AppMethodBeat.o(245062);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<b> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            bcv bcv;
            ato ato;
            bcv bcv2;
            ato ato2;
            com.tencent.mm.bw.b bVar;
            AppMethodBeat.i(245061);
            switch (FinderAlbumTimelineUI.e(this.tZd)) {
                case 10:
                case 11:
                    if (this.tZd.getIntent().hasExtra("STREAM_CARD")) {
                        bcu f2 = FinderAlbumTimelineUI.f(this.tZd);
                        if (!(f2 == null || (bcv2 = f2.LMa) == null || (ato2 = bcv2.LMc) == null)) {
                            bcu f3 = FinderAlbumTimelineUI.f(this.tZd);
                            if (f3 != null) {
                                bVar = f3.tVe;
                            } else {
                                bVar = null;
                            }
                            ato2.lastBuffer = bVar;
                            kotlin.g.b.p.g(ato2, "this");
                            b bVar2 = new b(1, ato2);
                            AppMethodBeat.o(245061);
                            return bVar2;
                        }
                    } else if (this.tZd.getIntent().hasExtra("STREAM_TXT_CARD")) {
                        bdb bdb = new bdb();
                        bdb.parseFrom(this.tZd.getIntent().getByteArrayExtra("STREAM_TXT_CARD"));
                        LinkedList<bcv> linkedList = bdb.LMS;
                        if (!(linkedList == null || (bcv = linkedList.get(FinderAlbumTimelineUI.j(this.tZd))) == null || (ato = bcv.LMc) == null)) {
                            kotlin.g.b.p.g(ato, "this");
                            b bVar3 = new b(2, ato);
                            AppMethodBeat.o(245061);
                            return bVar3;
                        }
                    } else {
                        AppMethodBeat.o(245061);
                        return null;
                    }
                case 14:
                    if (this.tZd.getIntent().hasExtra("STREAM_CARD_BUFFER")) {
                        ato ato3 = new ato();
                        ato3.scene = 14;
                        ato3.lastBuffer = new com.tencent.mm.bw.b(this.tZd.getIntent().getByteArrayExtra("STREAM_CARD_BUFFER"));
                        b bVar4 = new b(3, ato3);
                        AppMethodBeat.o(245061);
                        return bVar4;
                    }
                    AppMethodBeat.o(245061);
                    return null;
            }
            AppMethodBeat.o(245061);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<FinderFeedRelTimelineLoader> {
        final /* synthetic */ FinderAlbumTimelineUI tZd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderAlbumTimelineUI finderAlbumTimelineUI) {
            super(0);
            this.tZd = finderAlbumTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderFeedRelTimelineLoader invoke() {
            int i2;
            blo blo;
            com.tencent.mm.bw.b bVar;
            boolean z;
            ato ato;
            ato ato2;
            ato ato3;
            AppMethodBeat.i(245052);
            b k = FinderAlbumTimelineUI.k(this.tZd);
            if (k == null || (ato3 = k.tta) == null) {
                i2 = 11;
            } else {
                i2 = ato3.scene;
            }
            b k2 = FinderAlbumTimelineUI.k(this.tZd);
            if (k2 == null || (ato2 = k2.tta) == null) {
                blo = null;
            } else {
                blo = ato2.tVd;
            }
            b k3 = FinderAlbumTimelineUI.k(this.tZd);
            if (k3 == null || (ato = k3.tta) == null) {
                bVar = null;
            } else {
                bVar = ato.lastBuffer;
            }
            FinderAlbumTimelineUI$feedLoader$2$1 finderAlbumTimelineUI$feedLoader$2$1 = new FinderAlbumTimelineUI$feedLoader$2$1(this, i2, blo, bVar, FinderAlbumTimelineUI.a(this.tZd, FinderAlbumTimelineUI.h(this.tZd)), FinderAlbumTimelineUI.g(this.tZd));
            bcu f2 = FinderAlbumTimelineUI.f(this.tZd);
            if (f2 != null) {
                z = f2.uOm;
            } else {
                z = true;
            }
            finderAlbumTimelineUI$feedLoader$2$1.tVc = z;
            AppMethodBeat.o(245052);
            return finderAlbumTimelineUI$feedLoader$2$1;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ m.a ddK() {
        AppMethodBeat.i(245074);
        m.a ddD = ddD();
        AppMethodBeat.o(245074);
        return ddD;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ m.b ddL() {
        AppMethodBeat.i(245075);
        m.b ddE = ddE();
        AppMethodBeat.o(245075);
        return ddE;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderFeedRelTimelineLoader ddM() {
        AppMethodBeat.i(245076);
        FinderFeedRelTimelineLoader ddJ = ddJ();
        AppMethodBeat.o(245076);
        return ddJ;
    }

    public static final /* synthetic */ void a(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245079);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderAlbumTimelineUI, 0, false);
        eVar.a(new d(finderAlbumTimelineUI));
        eVar.a(new e(finderAlbumTimelineUI));
        eVar.b(new f(finderAlbumTimelineUI));
        eVar.dGm();
        AppMethodBeat.o(245079);
    }

    public static final /* synthetic */ bbn g(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245083);
        bbn bbn = (bbn) finderAlbumTimelineUI.tYU.getValue();
        AppMethodBeat.o(245083);
        return bbn;
    }

    public static final /* synthetic */ int j(FinderAlbumTimelineUI finderAlbumTimelineUI) {
        AppMethodBeat.i(245086);
        int intValue = ((Number) finderAlbumTimelineUI.tYX.getValue()).intValue();
        AppMethodBeat.o(245086);
        return intValue;
    }

    public static final /* synthetic */ ecq a(FinderAlbumTimelineUI finderAlbumTimelineUI, long j2) {
        AppMethodBeat.i(245088);
        ecq ecq = new ecq();
        ecq.NcN = new epf();
        ecq.NcM = new mp();
        ecq.NcO = new cxr();
        ecq.hFK = j2;
        ecq.tCE = 51;
        bcu ddG = finderAlbumTimelineUI.ddG();
        ecq.sessionBuffer = ddG != null ? ddG.sessionBuffer : null;
        ecq.finderUsername = z.aUg();
        ecq.NcP = cl.aWA();
        ecq.mediaType = 11;
        AppMethodBeat.o(245088);
        return ecq;
    }
}
