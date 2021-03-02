package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.dj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.aa;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.t;
import kotlin.x;

public final class OccupyFinderUI10 extends FinderLoaderFeedUI<FinderAtFeedLoader, aa.c, aa.b> {
    private static ConcurrentHashMap<Long, FinderItem> tZo = new ConcurrentHashMap<>();
    private static String udV = "KEY_IS_FULLSCREEN";
    private static String udW = "KEY_ENABLE_SWITCH_PREVIEW_MODE";
    public static final a udX = new a((byte) 0);
    private final String TAG = "Finder.FinderPreviewAtTimelineUI";
    private HashMap _$_findViewCache;
    private final int tLA = 2;
    private final kotlin.f tYU = kotlin.g.ah(new c(this));
    private FinderAtFeedLoader tZi;
    private long tZj;
    private final kotlin.f tZk = kotlin.g.ah(new q(this));
    private final kotlin.f tZl = kotlin.g.ah(new m(this));
    private final kotlin.f tZn = kotlin.g.ah(new f(this));
    private aa.b udJ;
    private aa.c udK;
    private final kotlin.f udL = kotlin.g.ah(new p(this));
    private final int udM = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 45);
    private final kotlin.f udN = kotlin.g.ah(new n(this));
    private final kotlin.f udO = kotlin.g.ah(new d(this));
    private final kotlin.f udP = kotlin.g.ah(new e(this));
    private final kotlin.f udQ = kotlin.g.ah(new b(this));
    private final kotlin.f udR = kotlin.g.ah(new o(this));
    private Intent udS;
    public boolean udT = true;
    private boolean udU = true;

    private final int deu() {
        AppMethodBeat.i(245637);
        int intValue = ((Number) this.udL.getValue()).intValue();
        AppMethodBeat.o(245637);
        return intValue;
    }

    private final View dev() {
        AppMethodBeat.i(245638);
        View view = (View) this.udN.getValue();
        AppMethodBeat.o(245638);
        return view;
    }

    private final View dew() {
        AppMethodBeat.i(245639);
        View view = (View) this.udO.getValue();
        AppMethodBeat.o(245639);
        return view;
    }

    private final View dex() {
        AppMethodBeat.i(245640);
        View view = (View) this.udP.getValue();
        AppMethodBeat.o(245640);
        return view;
    }

    private final TextView dey() {
        AppMethodBeat.i(245642);
        TextView textView = (TextView) this.udR.getValue();
        AppMethodBeat.o(245642);
        return textView;
    }

    private final WeImageView getCloseIcon() {
        AppMethodBeat.i(245641);
        WeImageView weImageView = (WeImageView) this.udQ.getValue();
        AppMethodBeat.o(245641);
        return weImageView;
    }

    private final bbn getContextObj() {
        AppMethodBeat.i(245634);
        bbn bbn = (bbn) this.tYU.getValue();
        AppMethodBeat.o(245634);
        return bbn;
    }

    private final int getFromScene() {
        AppMethodBeat.i(245636);
        int intValue = ((Number) this.tZn.getValue()).intValue();
        AppMethodBeat.o(245636);
        return intValue;
    }

    private final String getUsername() {
        AppMethodBeat.i(245633);
        String str = (String) this.tZk.getValue();
        AppMethodBeat.o(245633);
        return str;
    }

    private final boolean isSelfFlag() {
        AppMethodBeat.i(245635);
        boolean booleanValue = ((Boolean) this.tZl.getValue()).booleanValue();
        AppMethodBeat.o(245635);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245655);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245655);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245654);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245654);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static final class h extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(OccupyFinderUI10 occupyFinderUI10) {
            super(1);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(245623);
            kotlin.g.b.p.h(iResponse, LocaleUtil.ITALIAN);
            if (OccupyFinderUI10.b(this.udY).getSize() <= 0) {
                FrameLayout frameLayout = (FrameLayout) this.udY._$_findCachedViewById(R.id.eps);
                kotlin.g.b.p.g(frameLayout, "loading_state_container");
                frameLayout.setVisibility(0);
                TextView textView = (TextView) this.udY._$_findCachedViewById(R.id.ipb);
                kotlin.g.b.p.g(textView, "tips_no_content");
                textView.setVisibility(0);
                ProgressBar progressBar = (ProgressBar) this.udY._$_findCachedViewById(R.id.ip_);
                kotlin.g.b.p.g(progressBar, "tips_loading");
                progressBar.setVisibility(8);
            } else {
                FrameLayout frameLayout2 = (FrameLayout) this.udY._$_findCachedViewById(R.id.eps);
                kotlin.g.b.p.g(frameLayout2, "loading_state_container");
                frameLayout2.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245623);
            return xVar;
        }
    }

    public OccupyFinderUI10() {
        AppMethodBeat.i(245650);
        AppMethodBeat.o(245650);
    }

    public static final /* synthetic */ FinderAtFeedLoader b(OccupyFinderUI10 occupyFinderUI10) {
        AppMethodBeat.i(245652);
        FinderAtFeedLoader finderAtFeedLoader = occupyFinderUI10.tZi;
        if (finderAtFeedLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        AppMethodBeat.o(245652);
        return finderAtFeedLoader;
    }

    public static final /* synthetic */ aa.c c(OccupyFinderUI10 occupyFinderUI10) {
        AppMethodBeat.i(245653);
        aa.c cVar = occupyFinderUI10.udK;
        if (cVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        AppMethodBeat.o(245653);
        return cVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245651);
        AppMethodBeat.o(245651);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final boolean isOtherEnableFullScreenEnjoy() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.ui.MMFragmentActivity
    public final boolean isHideStatusBar() {
        return this.udT;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245643);
        Window window = getWindow();
        kotlin.g.b.p.g(window, "window");
        View decorView = window.getDecorView();
        kotlin.g.b.p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        Window window2 = getWindow();
        kotlin.g.b.p.g(window2, "window");
        window2.setStatusBarColor(0);
        getWindow().addFlags(67108864);
        this.udS = getIntent();
        super.onCreate(bundle);
        AppMethodBeat.o(245643);
    }

    static final class j implements View.OnClickListener {
        final /* synthetic */ OccupyFinderUI10 udY;

        j(OccupyFinderUI10 occupyFinderUI10) {
            this.udY = occupyFinderUI10;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245625);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.udY.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245625);
        }
    }

    static final class k implements View.OnClickListener {
        final /* synthetic */ OccupyFinderUI10 udY;

        k(OccupyFinderUI10 occupyFinderUI10) {
            this.udY = occupyFinderUI10;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(245626);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = this.udY.udS;
            if (intent != null) {
                this.udY.finish();
                a aVar = OccupyFinderUI10.udX;
                String str = OccupyFinderUI10.udV;
                if (!this.udY.udT) {
                    z = true;
                } else {
                    z = false;
                }
                intent.putExtra(str, z);
                y yVar = y.vXH;
                y.a(0, OccupyFinderUI10.b(this.udY).getDataList(), (com.tencent.mm.bw.b) null, intent);
                OccupyFinderUI10 occupyFinderUI10 = this.udY;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.udY.udS);
                com.tencent.mm.hellhoundlib.a.a.a(occupyFinderUI10, bl.axQ(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                occupyFinderUI10.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(occupyFinderUI10, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245626);
        }
    }

    static final class l implements Runnable {
        final /* synthetic */ OccupyFinderUI10 udY;

        l(OccupyFinderUI10 occupyFinderUI10) {
            this.udY = occupyFinderUI10;
        }

        public final void run() {
            AppMethodBeat.i(245627);
            OccupyFinderUI10.c(this.udY).tLS.setEnableLoadMore(false);
            OccupyFinderUI10.c(this.udY).tLS.setEnableRefresh(false);
            OccupyFinderUI10.c(this.udY).tLS.setEnablePullDownHeader(false);
            AppMethodBeat.o(245627);
        }
    }

    public static final class i implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderAtFeedLoader tZr;
        final /* synthetic */ OccupyFinderUI10 udY;

        i(FinderAtFeedLoader finderAtFeedLoader, OccupyFinderUI10 occupyFinderUI10) {
            this.tZr = finderAtFeedLoader;
            this.udY = occupyFinderUI10;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(245624);
            Object kt = kotlin.a.j.kt(this.tZr.getDataList());
            if (!(kt instanceof ad)) {
                kt = null;
            }
            ad adVar = (ad) kt;
            if (adVar != null) {
                adVar.uOq = this.udY.udT;
                adVar.feedObject.setPostFinish();
                cjl cjl = adVar.feedObject.getMediaList().get(0);
                if (adVar.isPreview && cjl.MfU != null) {
                    acn acn = cjl.MfU;
                    if (acn == null) {
                        kotlin.g.b.p.hyc();
                    }
                    kotlin.g.b.p.g(acn, "media.videoCompositionInfo!!");
                    aco aco = acn.Gxw;
                    if (aco == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (this.udY.udT) {
                        cjl.width = (float) aco.xlg;
                        cjl.height = (float) aco.xlh;
                    } else {
                        aty aty = cjl.MoU;
                        if (aty != null) {
                            cjl.width = aty.right - aty.left;
                            cjl.height = aty.bottom - aty.top;
                        }
                    }
                }
            }
            Object kt2 = kotlin.a.j.kt(this.tZr.getDataList());
            if (!(kt2 instanceof u)) {
                kt2 = null;
            }
            u uVar = (u) kt2;
            if (uVar != null && uVar.isPreview) {
                uVar.feedObject.setPostFinish();
            }
            RecyclerView.LayoutManager layoutManager = OccupyFinderUI10.c(this.udY).tLS.getRecyclerView().getLayoutManager();
            if (!(layoutManager instanceof FinderLinearLayoutManager)) {
                layoutManager = null;
            }
            FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
            if (finderLinearLayoutManager != null) {
                finderLinearLayoutManager.ah(this.tZr.getInitPos(), 0);
                finderLinearLayoutManager.wtl = false;
            }
            Object kt3 = kotlin.a.j.kt(this.tZr.getDataList());
            if (!(kt3 instanceof BaseFinderFeed)) {
                kt3 = null;
            }
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) kt3;
            if (baseFinderFeed != null && baseFinderFeed.isPreview) {
                com.tencent.mm.plugin.vlog.report.a aVar = com.tencent.mm.plugin.vlog.report.a.GDl;
                dj fCt = com.tencent.mm.plugin.vlog.report.a.fCt();
                fCt.jE(this.udY.udT ? 1 : 2);
                fCt.jF(2);
                fCt.bfK();
            }
            if (i2 > 0) {
                FrameLayout frameLayout = (FrameLayout) this.udY._$_findCachedViewById(R.id.eps);
                kotlin.g.b.p.g(frameLayout, "loading_state_container");
                frameLayout.setVisibility(8);
                AppMethodBeat.o(245624);
                return;
            }
            FrameLayout frameLayout2 = (FrameLayout) this.udY._$_findCachedViewById(R.id.eps);
            kotlin.g.b.p.g(frameLayout2, "loading_state_container");
            frameLayout2.setVisibility(0);
            ProgressBar progressBar = (ProgressBar) this.udY._$_findCachedViewById(R.id.ip_);
            kotlin.g.b.p.g(progressBar, "tips_loading");
            progressBar.setVisibility(0);
            AppMethodBeat.o(245624);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245645);
        super.onDestroy();
        tZo.clear();
        AppMethodBeat.o(245645);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ain;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245649);
        if (getFromScene() != 1) {
            AppMethodBeat.o(245649);
            return 13;
        } else if (isSelfFlag()) {
            AppMethodBeat.o(245649);
            return 62;
        } else {
            AppMethodBeat.o(245649);
            return 63;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245632);
            String stringExtra = this.udY.getIntent().getStringExtra("KEY_USERNAME");
            if (stringExtra == null) {
                stringExtra = z.aUg();
            }
            AppMethodBeat.o(245632);
            return stringExtra;
        }
    }

    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<bbn> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ bbn invoke() {
            AppMethodBeat.i(245618);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.udY).get(FinderReporterUIC.class)).dIx();
            AppMethodBeat.o(245618);
            return dIx;
        }
    }

    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(245628);
            Boolean valueOf = Boolean.valueOf(this.udY.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(245628);
            return valueOf;
        }
    }

    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245621);
            Integer valueOf = Integer.valueOf(this.udY.getIntent().getIntExtra("KEY_FROM_SCENE", 0));
            AppMethodBeat.o(245621);
            return valueOf;
        }
    }

    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int statusBarHeight;
            AppMethodBeat.i(245631);
            int identifier = this.udY.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                statusBarHeight = this.udY.getResources().getDimensionPixelSize(identifier);
            } else {
                statusBarHeight = au.getStatusBarHeight(this.udY.getContext());
            }
            Integer valueOf = Integer.valueOf(statusBarHeight);
            AppMethodBeat.o(245631);
            return valueOf;
        }
    }

    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(245629);
            View findViewById = this.udY.findViewById(R.id.iub);
            AppMethodBeat.o(245629);
            return findViewById;
        }
    }

    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(245619);
            View findViewById = this.udY.findViewById(R.id.bg3);
            AppMethodBeat.o(245619);
            return findViewById;
        }
    }

    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(245620);
            View findViewById = this.udY.findViewById(R.id.d1d);
            AppMethodBeat.o(245620);
            return findViewById;
        }
    }

    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(245617);
            WeImageView weImageView = (WeImageView) this.udY.findViewById(R.id.b4d);
            AppMethodBeat.o(245617);
            return weImageView;
        }
    }

    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(245630);
            TextView textView = (TextView) this.udY.findViewById(R.id.ggn);
            AppMethodBeat.o(245630);
            return textView;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(245644);
        getController().p(this, getResources().getColor(R.color.ac_));
        com.tencent.mm.ui.b.e(this, false);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
            supportActionBar.hide();
        }
        this.udT = getIntent().getBooleanExtra(udV, false);
        this.udT = this.udT;
        if (this.udT) {
            TextView dey = dey();
            kotlin.g.b.p.g(dey, "previewModeText");
            dey.setText(getString(R.string.f4z));
            dex().setPadding(0, deu(), 0, 0);
            View dex = dex();
            kotlin.g.b.p.g(dex, "finderActionBar");
            View dex2 = dex();
            kotlin.g.b.p.g(dex2, "finderActionBar");
            ViewGroup.LayoutParams layoutParams = dex2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(245644);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.height = View.MeasureSpec.makeMeasureSpec(this.udM + deu(), 1073741824);
            dex.setLayoutParams(marginLayoutParams);
            View dev = dev();
            kotlin.g.b.p.g(dev, "mainContainer");
            View dev2 = dev();
            kotlin.g.b.p.g(dev2, "mainContainer");
            ViewGroup.LayoutParams layoutParams2 = dev2.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(245644);
                throw tVar2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.topMargin = 0;
            dev.setLayoutParams(marginLayoutParams2);
        } else {
            TextView dey2 = dey();
            kotlin.g.b.p.g(dey2, "previewModeText");
            dey2.setText(getString(R.string.f4y));
            dex().setPadding(0, deu(), 0, 0);
            View dex3 = dex();
            kotlin.g.b.p.g(dex3, "finderActionBar");
            View dex4 = dex();
            kotlin.g.b.p.g(dex4, "finderActionBar");
            ViewGroup.LayoutParams layoutParams3 = dex4.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(245644);
                throw tVar3;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
            marginLayoutParams3.height = View.MeasureSpec.makeMeasureSpec(this.udM + deu(), 1073741824);
            dex3.setLayoutParams(marginLayoutParams3);
            View dev3 = dev();
            kotlin.g.b.p.g(dev3, "mainContainer");
            View dev4 = dev();
            kotlin.g.b.p.g(dev4, "mainContainer");
            ViewGroup.LayoutParams layoutParams4 = dev4.getLayoutParams();
            if (layoutParams4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(245644);
                throw tVar4;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
            marginLayoutParams4.topMargin = deu() + this.udM;
            dev3.setLayoutParams(marginLayoutParams4);
        }
        if (this.udT || ao.isDarkMode()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            TextView dey3 = dey();
            kotlin.g.b.p.g(dey3, "previewModeText");
            dey3.setBackground(com.tencent.mm.cb.a.l(getContext(), R.drawable.a2y));
            getCloseIcon().setIconColor(-1);
            View dex5 = dex();
            kotlin.g.b.p.g(dex5, "finderActionBar");
            dex5.setBackground(new ColorDrawable(0));
            dev().setBackgroundResource(R.color.y);
            dew().setBackgroundResource(R.color.y);
            setNavigationbarColor(WebView.NIGHT_MODE_COLOR);
            getController().updataStatusBarIcon(true);
        } else {
            TextView dey4 = dey();
            kotlin.g.b.p.g(dey4, "previewModeText");
            dey4.setBackground(com.tencent.mm.cb.a.l(getContext(), R.drawable.a2x));
            getCloseIcon().setIconColor(WebView.NIGHT_MODE_COLOR);
            View dex6 = dex();
            kotlin.g.b.p.g(dex6, "finderActionBar");
            dex6.setBackground(new ColorDrawable(getResources().getColor(R.color.BW_93)));
            dev().setBackgroundResource(R.color.am);
            dew().setBackgroundResource(R.color.af);
            setNavigationbarColor(-1);
            getController().updataStatusBarIcon(ao.isDarkMode());
        }
        this.udU = getIntent().getBooleanExtra(udW, true);
        TextView dey5 = dey();
        kotlin.g.b.p.g(dey5, "previewModeText");
        dey5.setVisibility(this.udU ? 0 : 4);
        getCloseIcon().setOnClickListener(new j(this));
        dey().setOnClickListener(new k(this));
        this.tZj = getIntent().getLongExtra("KEY_CACHE_ID", 0);
        Log.i(this.TAG, "[initOnCreate] cacheId:" + this.tZj + " username=" + getUsername() + " fromScene=" + getFromScene());
        tZo.clear();
        if (getFromScene() == 1) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(kotlin.g.b.p.j(getUsername(), z.aUg()) ? 1 : 0);
            objArr[1] = 2;
            hVar.a(21206, objArr);
        }
        boolean isSelfFlag = isSelfFlag();
        String username = getUsername();
        kotlin.g.b.p.g(username, ch.COL_USERNAME);
        this.udJ = new aa.b(this, isSelfFlag, username, this.tLA, getFromScene(), getContextObj());
        OccupyFinderUI10 occupyFinderUI10 = this;
        aa.b bVar = this.udJ;
        if (bVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        int i2 = this.tLA;
        int commentScene = getCommentScene();
        if (getFromScene() != 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.udK = new aa.c(occupyFinderUI10, bVar, i2, commentScene, z2);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.eps);
        kotlin.g.b.p.g(frameLayout, "loading_state_container");
        frameLayout.setVisibility(0);
        aa.c cVar = this.udK;
        if (cVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        cVar.tLS.post(new l(this));
        com.tencent.mm.plugin.finder.feed.model.internal.e eVar = com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_AT_TIMELINE;
        String username2 = getUsername();
        kotlin.g.b.p.g(username2, ch.COL_USERNAME);
        FinderAtFeedLoader finderAtFeedLoader = new FinderAtFeedLoader(eVar, username2, getContextObj());
        Intent intent = getIntent();
        kotlin.g.b.p.g(intent, "intent");
        finderAtFeedLoader.initFromCache(intent);
        finderAtFeedLoader.tTS = new g(this);
        finderAtFeedLoader.tVa = new h(this);
        finderAtFeedLoader.setInitDone(new i(finderAtFeedLoader, this));
        this.tZi = finderAtFeedLoader;
        AppMethodBeat.o(245644);
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI10 udY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(OccupyFinderUI10 occupyFinderUI10) {
            super(0);
            this.udY = occupyFinderUI10;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245622);
            View loadMoreFooter = OccupyFinderUI10.c(this.udY).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = OccupyFinderUI10.c(this.udY).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.udY.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = OccupyFinderUI10.c(this.udY).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = OccupyFinderUI10.c(this.udY).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245622);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ aa.b ddK() {
        AppMethodBeat.i(245646);
        aa.b bVar = this.udJ;
        if (bVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        aa.b bVar2 = bVar;
        AppMethodBeat.o(245646);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ aa.c ddL() {
        AppMethodBeat.i(245647);
        aa.c cVar = this.udK;
        if (cVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        aa.c cVar2 = cVar;
        AppMethodBeat.o(245647);
        return cVar2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderAtFeedLoader ddM() {
        AppMethodBeat.i(245648);
        FinderAtFeedLoader finderAtFeedLoader = this.tZi;
        if (finderAtFeedLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        FinderAtFeedLoader finderAtFeedLoader2 = finderAtFeedLoader;
        AppMethodBeat.o(245648);
        return finderAtFeedLoader2;
    }
}
