package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 .2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020\u0012H\u0016J\b\u0010&\u001a\u00020\u0012H\u0014J\b\u0010'\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0016\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u001eR#\u0010 \u001a\n !*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b\"\u0010\u001eR\u000e\u0010$\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "feedLoader", "fromScene", "", "getFromScene", "()I", "fromScene$delegate", "isSelfFlag", "", "()Z", "isSelfFlag$delegate", "presenter", "requestAtScene", "title", "getTitle", "()Ljava/lang/String;", "title$delegate", ch.COL_USERNAME, "kotlin.jvm.PlatformType", "getUsername", "username$delegate", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderAtTimelineUI extends FinderLoaderFeedUI<FinderAtFeedLoader, a.c, a.b> {
    private static ConcurrentHashMap<Long, FinderItem> tZo = new ConcurrentHashMap<>();
    public static final a tZp = new a((byte) 0);
    private final String TAG = "Finder.FinderAtTimelineUI";
    private HashMap _$_findViewCache;
    private final int tLA = 2;
    private final kotlin.f tYU = kotlin.g.ah(new b(this));
    private a.b tZg;
    private a.c tZh;
    private FinderAtFeedLoader tZi;
    private long tZj;
    private final kotlin.f tZk = kotlin.g.ah(new i(this));
    private final kotlin.f tZl = kotlin.g.ah(new g(this));
    private final kotlin.f tZm = kotlin.g.ah(new h(this));
    private final kotlin.f tZn = kotlin.g.ah(new c(this));

    private final bbn getContextObj() {
        AppMethodBeat.i(245100);
        bbn bbn = (bbn) this.tYU.getValue();
        AppMethodBeat.o(245100);
        return bbn;
    }

    private final int getFromScene() {
        AppMethodBeat.i(245103);
        int intValue = ((Number) this.tZn.getValue()).intValue();
        AppMethodBeat.o(245103);
        return intValue;
    }

    private final String getTitle() {
        AppMethodBeat.i(245102);
        String str = (String) this.tZm.getValue();
        AppMethodBeat.o(245102);
        return str;
    }

    private final String getUsername() {
        AppMethodBeat.i(245099);
        String str = (String) this.tZk.getValue();
        AppMethodBeat.o(245099);
        return str;
    }

    private final boolean isSelfFlag() {
        AppMethodBeat.i(245101);
        boolean booleanValue = ((Boolean) this.tZl.getValue()).booleanValue();
        AppMethodBeat.o(245101);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245115);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245115);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245114);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245114);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$2"})
    static final class e extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderAtTimelineUI finderAtTimelineUI) {
            super(1);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(245094);
            p.h(iResponse, LocaleUtil.ITALIAN);
            if (FinderAtTimelineUI.b(this.tZq).getSize() <= 0) {
                FrameLayout frameLayout = (FrameLayout) this.tZq._$_findCachedViewById(R.id.eps);
                p.g(frameLayout, "loading_state_container");
                frameLayout.setVisibility(0);
                TextView textView = (TextView) this.tZq._$_findCachedViewById(R.id.ipb);
                p.g(textView, "tips_no_content");
                textView.setVisibility(0);
                ProgressBar progressBar = (ProgressBar) this.tZq._$_findCachedViewById(R.id.ip_);
                p.g(progressBar, "tips_loading");
                progressBar.setVisibility(8);
            } else {
                FrameLayout frameLayout2 = (FrameLayout) this.tZq._$_findCachedViewById(R.id.eps);
                p.g(frameLayout2, "loading_state_container");
                frameLayout2.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245094);
            return xVar;
        }
    }

    public FinderAtTimelineUI() {
        AppMethodBeat.i(245110);
        AppMethodBeat.o(245110);
    }

    public static final /* synthetic */ a.c a(FinderAtTimelineUI finderAtTimelineUI) {
        AppMethodBeat.i(245112);
        a.c cVar = finderAtTimelineUI.tZh;
        if (cVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245112);
        return cVar;
    }

    public static final /* synthetic */ FinderAtFeedLoader b(FinderAtTimelineUI finderAtTimelineUI) {
        AppMethodBeat.i(245113);
        FinderAtFeedLoader finderAtFeedLoader = finderAtTimelineUI.tZi;
        if (finderAtFeedLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(245113);
        return finderAtFeedLoader;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245111);
        AppMethodBeat.o(245111);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        boolean z;
        int i2;
        AppMethodBeat.i(245104);
        if (getTitle().length() == 0) {
            setMMTitle(R.string.ci0);
        } else {
            setMMTitle(getTitle());
        }
        this.tZj = getIntent().getLongExtra("KEY_CACHE_ID", 0);
        Log.i(this.TAG, "[initOnCreate] cacheId:" + this.tZj + " username=" + getUsername() + " fromScene=" + getFromScene());
        tZo.clear();
        if (getFromScene() == 1) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[2];
            if (p.j(getUsername(), z.aUg())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = 2;
            hVar.a(21206, objArr);
        }
        boolean isSelfFlag = isSelfFlag();
        String username = getUsername();
        p.g(username, ch.COL_USERNAME);
        this.tZg = new a.b(this, isSelfFlag, username, this.tLA, getFromScene(), getContextObj());
        FinderAtTimelineUI finderAtTimelineUI = this;
        a.b bVar = this.tZg;
        if (bVar == null) {
            p.btv("presenter");
        }
        int i3 = this.tLA;
        int commentScene = getCommentScene();
        if (getFromScene() != 1) {
            z = true;
        } else {
            z = false;
        }
        this.tZh = new a.c(finderAtTimelineUI, bVar, i3, commentScene, z);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.eps);
        p.g(frameLayout, "loading_state_container");
        frameLayout.setVisibility(0);
        com.tencent.mm.plugin.finder.feed.model.internal.e eVar = com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_AT_TIMELINE;
        String username2 = getUsername();
        p.g(username2, ch.COL_USERNAME);
        FinderAtFeedLoader finderAtFeedLoader = new FinderAtFeedLoader(eVar, username2, getContextObj());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderAtFeedLoader.initFromCache(intent);
        finderAtFeedLoader.tTS = new d(this);
        finderAtFeedLoader.tVa = new e(this);
        finderAtFeedLoader.setInitDone(new f(finderAtFeedLoader, this));
        this.tZi = finderAtFeedLoader;
        AppMethodBeat.o(245104);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class f implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderAtTimelineUI tZq;
        final /* synthetic */ FinderAtFeedLoader tZr;

        f(FinderAtFeedLoader finderAtFeedLoader, FinderAtTimelineUI finderAtTimelineUI) {
            this.tZr = finderAtFeedLoader;
            this.tZq = finderAtTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245095);
            RecyclerView.LayoutManager layoutManager = FinderAtTimelineUI.a(this.tZq).tLS.getRecyclerView().getLayoutManager();
            if (!(layoutManager instanceof FinderLinearLayoutManager)) {
                layoutManager = null;
            }
            FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
            if (finderLinearLayoutManager != null) {
                finderLinearLayoutManager.ah(this.tZr.getInitPos(), 0);
            }
            if (i2 > 0) {
                FrameLayout frameLayout = (FrameLayout) this.tZq._$_findCachedViewById(R.id.eps);
                p.g(frameLayout, "loading_state_container");
                frameLayout.setVisibility(8);
                AppMethodBeat.o(245095);
                return;
            }
            FrameLayout frameLayout2 = (FrameLayout) this.tZq._$_findCachedViewById(R.id.eps);
            p.g(frameLayout2, "loading_state_container");
            frameLayout2.setVisibility(0);
            ProgressBar progressBar = (ProgressBar) this.tZq._$_findCachedViewById(R.id.ip_);
            p.g(progressBar, "tips_loading");
            progressBar.setVisibility(0);
            AppMethodBeat.o(245095);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245105);
        super.onDestroy();
        tZo.clear();
        AppMethodBeat.o(245105);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a9d;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245109);
        if (getFromScene() != 1) {
            AppMethodBeat.o(245109);
            return 13;
        } else if (isSelfFlag()) {
            AppMethodBeat.o(245109);
            return 62;
        } else {
            AppMethodBeat.o(245109);
            return 63;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderAtTimelineUI finderAtTimelineUI) {
            super(0);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245098);
            String stringExtra = this.tZq.getIntent().getStringExtra("KEY_USERNAME");
            if (stringExtra == null) {
                stringExtra = z.aUg();
            }
            AppMethodBeat.o(245098);
            return stringExtra;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<bbn> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderAtTimelineUI finderAtTimelineUI) {
            super(0);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ bbn invoke() {
            AppMethodBeat.i(245091);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tZq).get(FinderReporterUIC.class)).dIx();
            AppMethodBeat.o(245091);
            return dIx;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderAtTimelineUI finderAtTimelineUI) {
            super(0);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(245096);
            Boolean valueOf = Boolean.valueOf(this.tZq.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(245096);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderAtTimelineUI finderAtTimelineUI) {
            super(0);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245097);
            String stringExtra = this.tZq.getIntent().getStringExtra("KEY_TITLE");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(245097);
            return stringExtra;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderAtTimelineUI finderAtTimelineUI) {
            super(0);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245092);
            Integer valueOf = Integer.valueOf(this.tZq.getIntent().getIntExtra("KEY_FROM_SCENE", 0));
            AppMethodBeat.o(245092);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$1"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderAtTimelineUI tZq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderAtTimelineUI finderAtTimelineUI) {
            super(0);
            this.tZq = finderAtTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245093);
            View loadMoreFooter = FinderAtTimelineUI.a(this.tZq).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderAtTimelineUI.a(this.tZq).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.tZq.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderAtTimelineUI.a(this.tZq).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderAtTimelineUI.a(this.tZq).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245093);
            return xVar;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ a.b ddK() {
        AppMethodBeat.i(245106);
        a.b bVar = this.tZg;
        if (bVar == null) {
            p.btv("presenter");
        }
        a.b bVar2 = bVar;
        AppMethodBeat.o(245106);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ a.c ddL() {
        AppMethodBeat.i(245107);
        a.c cVar = this.tZh;
        if (cVar == null) {
            p.btv("viewCallback");
        }
        a.c cVar2 = cVar;
        AppMethodBeat.o(245107);
        return cVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderAtFeedLoader ddM() {
        AppMethodBeat.i(245108);
        FinderAtFeedLoader finderAtFeedLoader = this.tZi;
        if (finderAtFeedLoader == null) {
            p.btv("feedLoader");
        }
        FinderAtFeedLoader finderAtFeedLoader2 = finderAtFeedLoader;
        AppMethodBeat.o(245108);
        return finderAtFeedLoader2;
    }
}
