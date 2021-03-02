package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.ac;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\"\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderRelatedFeedUI extends FinderBaseGridFeedUI<ac.b, ac.a> {
    public static final a ucF = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final int scene = 2;
    public BaseFinderFeedLoader tFM;
    private ato tQh;
    private String title = "";
    private ac.a ucC;
    private ac.b ucD;
    private atp ucE;

    static {
        AppMethodBeat.i(245501);
        AppMethodBeat.o(245501);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245504);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245504);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245503);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245503);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$initOnCreate$1$1"})
    static final class b extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderRelatedFeedUI ucG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderRelatedFeedUI finderRelatedFeedUI) {
            super(1);
            this.ucG = finderRelatedFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245493);
            p.h(iResponse, LocaleUtil.ITALIAN);
            View loadMoreFooter = FinderRelatedFeedUI.a(this.ucG).tLS.getLoadMoreFooter();
            if (loadMoreFooter != null) {
                loadMoreFooter.setVisibility(0);
            }
            View loadMoreFooter2 = FinderRelatedFeedUI.a(this.ucG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter3 = FinderRelatedFeedUI.a(this.ucG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView2 = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.ucG.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter4 = FinderRelatedFeedUI.a(this.ucG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (textView = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter5 = FinderRelatedFeedUI.a(this.ucG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter5 == null || (findViewById = loadMoreFooter5.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245493);
            return xVar;
        }
    }

    public static final /* synthetic */ ac.b a(FinderRelatedFeedUI finderRelatedFeedUI) {
        AppMethodBeat.i(245502);
        ac.b bVar = finderRelatedFeedUI.ucD;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245502);
        return bVar;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ ac.a dcq() {
        AppMethodBeat.i(245496);
        ac.a deq = deq();
        AppMethodBeat.o(245496);
        return deq;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajb;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final void initOnCreate() {
        boolean z = true;
        AppMethodBeat.i(245494);
        ato ato = new ato();
        try {
            ato.parseFrom(getIntent().getByteArrayExtra("SECTION_REQ"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            ato = null;
        }
        this.tQh = ato;
        atp atp = new atp();
        try {
            atp.parseFrom(getIntent().getByteArrayExtra("SECTION_FIRST_RSP"));
        } catch (Exception e3) {
            Log.printDebugStack("safeParser", "", e3);
            atp = null;
        }
        this.ucE = atp;
        if (this.tQh == null || this.ucE == null) {
            StringBuilder append = new StringBuilder("req is null? ").append(this.tQh == null).append(", rsp is null? ");
            if (this.ucE != null) {
                z = false;
            }
            Log.i("Finder.FinderRelatedFeedUI", append.append(z).append(", finish").toString());
            finish();
            this.tQh = new ato();
        }
        String stringExtra = getIntent().getStringExtra("UI_TITLE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.title = stringExtra;
        setMMTitle(this.title);
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
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderRelatedLoader finderRelatedLoader = new FinderRelatedLoader(i2, commentScene, f2, f3, bcc, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderRelatedLoader.initFromCache(intent);
        finderRelatedLoader.fetchEndCallback = new b(this);
        this.tFM = finderRelatedLoader;
        FinderRelatedFeedUI finderRelatedFeedUI = this;
        getCommentScene();
        BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
        if (baseFinderFeedLoader == null) {
            p.btv("feedLoader");
        }
        this.ucC = new ac.a(finderRelatedFeedUI, baseFinderFeedLoader);
        FinderRelatedFeedUI finderRelatedFeedUI2 = this;
        int i3 = this.scene;
        int commentScene2 = getCommentScene();
        ato ato6 = this.tQh;
        if (ato6 == null) {
            p.hyc();
        }
        this.ucD = new ac.b(finderRelatedFeedUI2, i3, commentScene2, ato6, this.title);
        ac.b bVar = this.ucD;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        ac.a aVar2 = this.ucC;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        AppMethodBeat.o(245494);
    }

    private ac.a deq() {
        AppMethodBeat.i(245495);
        ac.a aVar = this.ucC;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(245495);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245498);
        int intExtra = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
        if (intExtra == 2) {
            AppMethodBeat.o(245498);
            return 28;
        } else if (intExtra == 1) {
            AppMethodBeat.o(245498);
            return 30;
        } else {
            AppMethodBeat.o(245498);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        AppMethodBeat.i(245499);
        int intExtra = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
        if (intExtra == 2 || intExtra == 1) {
            AppMethodBeat.o(245499);
            return 3;
        }
        AppMethodBeat.o(245499);
        return 0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        RecyclerView recyclerView;
        AppMethodBeat.i(245500);
        if (i2 == 501 && i3 == -1 && intent != null) {
            ac.a deq = deq();
            p.h(intent, "data");
            c.b bVar = deq.tMd;
            if (bVar == null || (recyclerView = bVar.tLS.getRecyclerView()) == null) {
                AppMethodBeat.o(245500);
                return;
            }
            y yVar = y.vXH;
            y.a(intent, recyclerView, deq.tFM);
            AppMethodBeat.o(245500);
            return;
        }
        AppMethodBeat.o(245500);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
    public final /* synthetic */ ac.b ddS() {
        AppMethodBeat.i(245497);
        ac.b bVar = this.ucD;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        ac.b bVar2 = bVar;
        AppMethodBeat.o(245497);
        return bVar2;
    }
}
