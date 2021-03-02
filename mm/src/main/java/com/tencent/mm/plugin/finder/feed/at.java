package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.ap;
import com.tencent.mm.plugin.finder.convert.as;
import com.tencent.mm.plugin.finder.convert.bd;
import com.tencent.mm.plugin.finder.convert.bx;
import com.tencent.mm.plugin.finder.convert.ch;
import com.tencent.mm.plugin.finder.convert.cj;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.bh;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFavAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class at extends com.tencent.mm.plugin.finder.event.base.d implements ai.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
    private static final int jUx = 108;
    private static final int pLU = 103;
    private static final int pMa = 101;
    private static final int tLD = 99;
    private static final int tLE = 104;
    private static final int tLF = 105;
    private static final int tLG = 106;
    private static final int tLH = 107;
    private static final int tLJ = 109;
    private static final int tLK = 110;
    private static final int tLL = 111;
    private static final int tLM = 112;
    private static ConcurrentHashMap<String, RefreshLoadMoreLayout.c<Object>> tSr = new ConcurrentHashMap<>();
    public static final b tSs = new b((byte) 0);
    private static final int tqv = 102;
    private static final int tzW = 100;
    private final String TAG;
    private boolean canTimelineRefresh;
    final int dLS;
    public final MMActivity gte;
    private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
    public final com.tencent.mm.plugin.finder.video.k tCD;
    private RecyclerView.m tLO;
    private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
    private final kotlin.f tLX;
    private com.tencent.mm.view.j tMe;
    private com.tencent.mm.plugin.finder.view.b tPE;
    private final com.tencent.mm.plugin.finder.model.i tRH;
    private ai.b tRV;
    private FinderHomeTabStateVM.a tRW;
    private final kotlin.f tRX;
    private final kotlin.f tRY;
    private final g tRZ;
    private final FinderHomeTabFragment tRb;
    public final FinderTimelineFeedLoader tRo;
    private final boolean tSa;
    private final kotlin.f tSb;
    private boolean tSc;
    private boolean tSd;
    private final i tSe;
    private final bh tSf;
    private final com.tencent.mm.plugin.finder.model.k tSg;
    private g.b tSh;
    private g.b tSi;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.model.f> tSj;
    private final ah tSk;
    private final int tSl;
    private boolean tSn;
    private boolean tSo;
    private final j tSp;
    private final v tSq;
    private Dialog tipDialog;
    private final FinderHomeTabStateVM tlCache;

    private final com.tencent.mm.plugin.finder.feed.model.d dcW() {
        AppMethodBeat.i(244376);
        com.tencent.mm.plugin.finder.feed.model.d dVar = (com.tencent.mm.plugin.finder.feed.model.d) this.tRX.getValue();
        AppMethodBeat.o(244376);
        return dVar;
    }

    private final com.tencent.mm.plugin.finder.feed.model.f dcX() {
        AppMethodBeat.i(244377);
        com.tencent.mm.plugin.finder.feed.model.f fVar = (com.tencent.mm.plugin.finder.feed.model.f) this.tRY.getValue();
        AppMethodBeat.o(244377);
        return fVar;
    }

    private final FinderWhatsNewView dcY() {
        AppMethodBeat.i(165899);
        FinderWhatsNewView finderWhatsNewView = (FinderWhatsNewView) this.tSb.getValue();
        AppMethodBeat.o(165899);
        return finderWhatsNewView;
    }

    private final boolean dck() {
        AppMethodBeat.i(244389);
        boolean booleanValue = ((Boolean) this.tLX.getValue()).booleanValue();
        AppMethodBeat.o(244389);
        return booleanValue;
    }

    /* access modifiers changed from: package-private */
    public static final class l implements o.f {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ com.tencent.mm.ui.widget.a.e tPJ;
        final /* synthetic */ at tSt;

        l(at atVar, BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
            this.tSt = atVar;
            this.tEM = baseFinderFeed;
            this.tPJ = eVar;
        }

        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, kotlin.x> {
            final /* synthetic */ com.tencent.mm.ui.base.m tPL;
            final /* synthetic */ l tSH;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(l lVar, com.tencent.mm.ui.base.m mVar) {
                super(1);
                this.tSH = lVar;
                this.tPL = mVar;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(kotlin.r<? extends String, ? extends String, ? extends String> rVar) {
                AppMethodBeat.i(165870);
                kotlin.r<? extends String, ? extends String, ? extends String> rVar2 = rVar;
                kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                com.tencent.mm.ui.base.m mVar = this.tPL;
                kotlin.g.b.p.g(mVar, "menu");
                mVar.avn().clear();
                if (!(this.tSH.tEM.feedObject.isOnlySelfSee() || this.tSH.tEM.feedObject.isNotShare())) {
                    com.tencent.mm.ui.base.m mVar2 = this.tPL;
                    b bVar = at.tSs;
                    mVar2.a(at.pLU, (CharSequence) this.tSH.tSt.gte.getString(R.string.d9p), R.raw.bottomsheet_icon_moment, 0, false);
                } else {
                    com.tencent.mm.ui.base.m mVar3 = this.tPL;
                    b bVar2 = at.tSs;
                    mVar3.a(at.pLU, (CharSequence) rVar2.second, R.raw.bottomsheet_icon_moment, 0, true);
                }
                this.tSH.tPJ.fPw();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(165870);
                return xVar;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x015e  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0112  */
        @Override // com.tencent.mm.ui.base.o.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m r14) {
            /*
            // Method dump skipped, instructions count: 515
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.at.l.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
        }
    }

    static final class t extends kotlin.g.b.q implements kotlin.g.a.b<Integer, bo> {
        final /* synthetic */ ai.b tSN;
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(at atVar, ai.b bVar) {
            super(1);
            this.tSt = atVar;
            this.tSN = bVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ bo invoke(Integer num) {
            int i2;
            BaseFinderFeed baseFinderFeed;
            AppMethodBeat.i(244364);
            int intValue = num.intValue();
            RecyclerView.a adapter = this.tSN.getRecyclerView().getAdapter();
            if (adapter == null) {
                i2 = -1;
            } else if (adapter == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(244364);
                throw tVar;
            } else {
                i2 = intValue - ((com.tencent.mm.view.recyclerview.g) adapter).RqM.size();
            }
            Log.d("Finder.FinderCommentPreloader", "preloadFirstPageComment, pos: ".concat(String.valueOf(i2)));
            if (i2 < 0 || i2 >= this.tSt.tRo.getDataListJustForAdapter().size()) {
                AppMethodBeat.o(244364);
                return null;
            }
            bo boVar = (bo) this.tSt.tRo.get(i2);
            if (boVar instanceof BaseFinderFeed) {
                baseFinderFeed = (BaseFinderFeed) boVar;
            } else {
                baseFinderFeed = null;
            }
            BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
            AppMethodBeat.o(244364);
            return baseFinderFeed2;
        }
    }

    static final class u extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(at atVar) {
            super(2);
            this.tSt = atVar;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
            Integer num3;
            FinderTimelineFeedLoader finderTimelineFeedLoader;
            DataBuffer dataListJustForAdapter;
            List a2;
            DataBuffer dataListJustForAdapter2;
            AppMethodBeat.i(244365);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (intValue >= 0) {
                FinderTimelineFeedLoader finderTimelineFeedLoader2 = this.tSt.tRo;
                if (finderTimelineFeedLoader2 == null || (dataListJustForAdapter2 = finderTimelineFeedLoader2.getDataListJustForAdapter()) == null) {
                    num3 = null;
                } else {
                    num3 = Integer.valueOf(dataListJustForAdapter2.size());
                }
                if (!(intValue2 >= num3.intValue() || (finderTimelineFeedLoader = this.tSt.tRo) == null || (dataListJustForAdapter = finderTimelineFeedLoader.getDataListJustForAdapter()) == null || (a2 = kotlin.a.j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                    LinkedList<bo> linkedList = new LinkedList<>(a2);
                    AppMethodBeat.o(244365);
                    return linkedList;
                }
            }
            AppMethodBeat.o(244365);
            return null;
        }
    }

    public static final class z extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final z tSP = new z();

        static {
            AppMethodBeat.i(244368);
            AppMethodBeat.o(244368);
        }

        z() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ kotlin.x invoke() {
            return kotlin.x.SXb;
        }
    }

    public static final /* synthetic */ void a(at atVar, long j2, boolean z2) {
        AppMethodBeat.i(165924);
        atVar.s(j2, z2);
        AppMethodBeat.o(165924);
    }

    public static final /* synthetic */ boolean b(at atVar) {
        AppMethodBeat.i(244396);
        boolean dck = atVar.dck();
        AppMethodBeat.o(244396);
        return dck;
    }

    public static final /* synthetic */ com.tencent.mm.view.recyclerview.g d(at atVar) {
        AppMethodBeat.i(165926);
        com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> dda = atVar.dda();
        AppMethodBeat.o(165926);
        return dda;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(ai.b bVar) {
        TestPreloadPreview testPreloadPreview;
        int i2 = 0;
        AppMethodBeat.i(165898);
        ai.b bVar2 = bVar;
        kotlin.g.b.p.h(bVar2, "viewCallback");
        this.tRV = bVar2;
        bVar2.c(this.tRo.getDataListJustForAdapter(), this.dLS);
        this.tCD.a(this.gte, new r(this, bVar2), true);
        this.tRZ.alive();
        FinderTimelineFeedLoader finderTimelineFeedLoader = this.tRo;
        RecyclerView recyclerView = bVar2.getRecyclerView();
        finderTimelineFeedLoader.hak = recyclerView;
        if (recyclerView != null) {
            recyclerView.addOnAttachStateChangeListener(new FinderTimelineFeedLoader.g(recyclerView));
        }
        this.tRo.register(this.tMe);
        if (!com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.dLS, 0, 2)) {
            FinderHomeTabFragment finderHomeTabFragment = this.tRb;
            if (finderHomeTabFragment != null) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(bVar2.getRecyclerView());
            } else {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(bVar2.getRecyclerView());
            }
        }
        if (this.dLS == 1) {
            com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
            com.tencent.mm.plugin.finder.extension.reddot.h.daX().observe(this.gte, new s(this));
        }
        dcW().a(2, 3, new t(this, bVar2));
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MF = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).MF(this.dLS);
        if (MF != null) {
            MF.a(this);
            MF.a(dcW());
        }
        dcX().e(new u(this));
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MF2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).MF(this.dLS);
        if (MF2 != null) {
            MF2.a(this);
            MF2.a(dcX());
        }
        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
        this.tRW = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(this.dLS);
        EventCenter.instance.add(this.tSe);
        EventCenter.instance.add(this.tSp);
        if (this.dLS == 1 || this.dLS == 4) {
            this.tPE = new com.tencent.mm.plugin.finder.view.b(this.tRo);
            com.tencent.mm.plugin.finder.view.b bVar3 = this.tPE;
            if (bVar3 != null) {
                bVar3.alive();
            }
        }
        BaseFeedLoader.requestInit$default(this.tRo, false, 1, null);
        MediaPreloadCore.a aVar6 = MediaPreloadCore.uTV;
        if (!(MediaPreloadCore.uTU) || (testPreloadPreview = (TestPreloadPreview) bVar2.getRootView().findViewById(R.id.ijo)) == null) {
            AppMethodBeat.o(165898);
            return;
        }
        if (dck()) {
            int eu = au.eu(testPreloadPreview.getContext()) + au.getStatusBarHeight(testPreloadPreview.getContext());
            ViewGroup.LayoutParams layoutParams = testPreloadPreview.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(165898);
                throw tVar;
            }
            ((FrameLayout.LayoutParams) layoutParams).topMargin = eu;
        }
        testPreloadPreview.setVisibility(0);
        com.tencent.mm.ui.component.a aVar7 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MF3 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).MF(this.dLS);
        if (MF3 != null) {
            DataBuffer<bo> dataListJustForAdapter = this.tRo.getDataListJustForAdapter();
            com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> dda = dda();
            if (dda != null) {
                i2 = dda.RqM.size();
            }
            testPreloadPreview.a(dataListJustForAdapter, i2, this.tCD, MF3, this.dLS);
            AppMethodBeat.o(165898);
            return;
        }
        AppMethodBeat.o(165898);
    }

    public at(MMActivity mMActivity, FinderHomeTabFragment finderHomeTabFragment) {
        int i2;
        int i3;
        boolean z2 = true;
        kotlin.g.b.p.h(mMActivity, "context");
        AppMethodBeat.i(244395);
        this.gte = mMActivity;
        this.tRb = finderHomeTabFragment;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        FinderHomeTabFragment finderHomeTabFragment2 = this.tRb;
        if (finderHomeTabFragment2 != null) {
            i2 = finderHomeTabFragment2.dLS;
        } else {
            i2 = 0;
        }
        this.dLS = i2;
        this.canTimelineRefresh = this.tlCache.JN(this.dLS);
        e.a aVar2 = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
        com.tencent.mm.plugin.finder.feed.model.internal.e IO = e.a.IO(this.dLS);
        if (this.canTimelineRefresh) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        FinderTimelineFeedLoader finderTimelineFeedLoader = new FinderTimelineFeedLoader(IO, i3, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).Mz(this.dLS));
        finderTimelineFeedLoader.setInitDone(new a(finderTimelineFeedLoader, this));
        this.tRo = finderTimelineFeedLoader;
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        this.tLO = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(this.gte).get(FinderRecyclerViewPool.class)).tLO;
        this.tCD = new com.tencent.mm.plugin.finder.video.k(this.dLS);
        this.tRX = kotlin.g.ah(new h(this));
        this.tRY = kotlin.g.ah(new k(this));
        this.tRZ = new g(this);
        this.TAG = "Finder.TimelinePresenter#" + this.dLS;
        this.tMe = new com.tencent.mm.view.j(this) {
            /* class com.tencent.mm.plugin.finder.feed.at.AnonymousClass1 */
            final /* synthetic */ at tSt;

            {
                this.tSt = r1;
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(165859);
                kotlin.g.b.p.h(cVar, "reason");
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.duz().value().intValue() == 1) {
                    ArrayList<bo> arrayList = new ArrayList();
                    for (Object obj : this.tSt.tRo.getDataList()) {
                        bo boVar = (bo) obj;
                        if ((boVar instanceof BaseFinderFeed) && ((BaseFinderFeed) boVar).showCommentEdu) {
                            arrayList.add(obj);
                        }
                    }
                    for (bo boVar2 : arrayList) {
                        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (boVar2 == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                            AppMethodBeat.o(165859);
                            throw tVar;
                        }
                        com.tencent.mm.plugin.finder.utils.y.Gh(((BaseFinderFeed) boVar2).feedObject.field_id);
                    }
                }
                at.b(this.tSt, cVar);
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(165859);
                    return;
                }
                dcQ.onPreFinishRefresh(cVar);
                AppMethodBeat.o(165859);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(244345);
                kotlin.g.b.p.h(cVar, "reason");
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(244345);
                    return;
                }
                dcQ.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(244345);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(165860);
                kotlin.g.b.p.h(cVar, "reason");
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(165860);
                    return;
                }
                dcQ.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(165860);
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(165861);
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(165861);
                    return;
                }
                dcQ.onChanged();
                AppMethodBeat.o(165861);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                RefreshLoadMoreLayout dcQ;
                int i4;
                AppMethodBeat.i(244346);
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(244346);
                    return;
                }
                com.tencent.mm.view.recyclerview.g d2 = at.d(this.tSt);
                if (d2 != null) {
                    i4 = d2.RqM.size();
                } else {
                    i4 = 0;
                }
                dcQ.onItemRangeChanged(i4 + i2, i3);
                AppMethodBeat.o(244346);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                RefreshLoadMoreLayout dcQ;
                int i4;
                AppMethodBeat.i(165862);
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(165862);
                    return;
                }
                com.tencent.mm.view.recyclerview.g d2 = at.d(this.tSt);
                if (d2 != null) {
                    i4 = d2.RqM.size();
                } else {
                    i4 = 0;
                }
                dcQ.onItemRangeChanged(i4 + i2, i3, obj);
                AppMethodBeat.o(165862);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                RefreshLoadMoreLayout dcQ;
                int i4;
                AppMethodBeat.i(165863);
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(165863);
                    return;
                }
                com.tencent.mm.view.recyclerview.g d2 = at.d(this.tSt);
                if (d2 != null) {
                    i4 = d2.RqM.size();
                } else {
                    i4 = 0;
                }
                dcQ.onItemRangeInserted(i4 + i2, i3);
                AppMethodBeat.o(165863);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                RefreshLoadMoreLayout dcQ;
                int i4;
                AppMethodBeat.i(165864);
                ai.b bVar = this.tSt.tRV;
                if (bVar == null || (dcQ = bVar.dcQ()) == null) {
                    AppMethodBeat.o(165864);
                    return;
                }
                com.tencent.mm.view.recyclerview.g d2 = at.d(this.tSt);
                if (d2 != null) {
                    i4 = d2.RqM.size();
                } else {
                    i4 = 0;
                }
                dcQ.onItemRangeRemoved(i4 + i2, i3);
                AppMethodBeat.o(165864);
            }
        };
        this.tSa = this.tRb == null ? false : z2;
        this.tSb = kotlin.g.ah(new ae(this));
        this.tSe = new i(this);
        this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
        this.tSf = new bh();
        this.tRH = new com.tencent.mm.plugin.finder.model.i();
        this.tSg = new com.tencent.mm.plugin.finder.model.k();
        this.tSh = new com.tencent.mm.plugin.finder.model.g();
        this.tSi = new com.tencent.mm.plugin.finder.model.e();
        this.tSj = new ConcurrentLinkedQueue<>();
        this.tSk = new ah(this.msgNotifyData, this.tSf, this.tSj);
        this.tLX = kotlin.g.ah(new p(this));
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        this.tSl = aAh.azQ().getInt(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_NUM_INT_SYNC, 3);
        this.tSp = new j(this);
        this.tSq = new v(this);
        AppMethodBeat.o(244395);
    }

    public static final class a implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderTimelineFeedLoader tRq;
        final /* synthetic */ at tSt;

        a(FinderTimelineFeedLoader finderTimelineFeedLoader, at atVar) {
            this.tRq = finderTimelineFeedLoader;
            this.tSt = atVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            String str;
            Class<?> cls;
            Bundle bundle;
            boolean z = true;
            AppMethodBeat.i(244344);
            FinderHomeTabFragment finderHomeTabFragment = this.tSt.tRb;
            if (finderHomeTabFragment == null || (bundle = finderHomeTabFragment.Ew) == null || bundle.getInt("RequestScene", -1) != 1) {
                z = false;
            }
            if (z) {
                Log.i(this.tRq.getTAG(), "IInitDone come from hot card.");
                FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tSt.tCD.weS;
                if (finderVideoAutoPlayManager != null) {
                    StringBuilder sb = new StringBuilder();
                    FinderHomeTabFragment finderHomeTabFragment2 = this.tSt.tRb;
                    if (finderHomeTabFragment2 == null || (cls = finderHomeTabFragment2.getClass()) == null) {
                        str = null;
                    } else {
                        str = cls.getSimpleName();
                    }
                    FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, sb.append(str).append("#onAttach").toString(), false);
                    AppMethodBeat.o(244344);
                    return;
                }
                AppMethodBeat.o(244344);
                return;
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.feed.at.a.AnonymousClass1 */
                final /* synthetic */ a tSu;

                {
                    this.tSu = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    RecyclerView.a aVar;
                    RecyclerView recyclerView;
                    RecyclerView recyclerView2;
                    FinderVideoAutoPlayManager finderVideoAutoPlayManager;
                    String str;
                    Class<?> cls;
                    RecyclerView recyclerView3;
                    AppMethodBeat.i(244343);
                    ai.b bVar = this.tSu.tSt.tRV;
                    RecyclerView.LayoutManager layoutManager = (bVar == null || (recyclerView3 = bVar.getRecyclerView()) == null) ? null : recyclerView3.getLayoutManager();
                    if (layoutManager == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                        AppMethodBeat.o(244343);
                        throw tVar;
                    }
                    final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    if (this.tSu.tSt.canTimelineRefresh && (finderVideoAutoPlayManager = this.tSu.tSt.tCD.weS) != null) {
                        StringBuilder sb = new StringBuilder();
                        FinderHomeTabFragment finderHomeTabFragment = this.tSu.tSt.tRb;
                        if (finderHomeTabFragment == null || (cls = finderHomeTabFragment.getClass()) == null) {
                            str = null;
                        } else {
                            str = cls.getSimpleName();
                        }
                        FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, sb.append(str).append("#onAttach").toString(), true);
                    }
                    FinderHomeTabStateVM.a aVar2 = this.tSu.tSt.tRW;
                    if (aVar2 != null) {
                        ai.b bVar2 = this.tSu.tSt.tRV;
                        if (bVar2 == null || (recyclerView2 = bVar2.getRecyclerView()) == null) {
                            aVar = null;
                        } else {
                            aVar = recyclerView2.getAdapter();
                        }
                        if (aVar == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                            AppMethodBeat.o(244343);
                            throw tVar2;
                        }
                        final int size = aVar2.wuf + ((com.tencent.mm.view.recyclerview.g) aVar).RqM.size();
                        final int i2 = aVar2.wug;
                        Log.i(this.tSu.tRq.getTAG(), "TimelineInit initdone canTimelineRefresh tabType=" + this.tSu.tSt.dLS + ' ' + this.tSu.tSt.canTimelineRefresh + " lastPos:" + size + " fromTopPixel:" + i2);
                        if (size > 0) {
                            linearLayoutManager.ah(size, i2);
                            ai.b bVar3 = this.tSu.tSt.tRV;
                            if (!(bVar3 == null || (recyclerView = bVar3.getRecyclerView()) == null)) {
                                recyclerView.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.finder.feed.at.a.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(244342);
                                        linearLayoutManager.ah(size, i2);
                                        AppMethodBeat.o(244342);
                                    }
                                });
                            }
                        } else {
                            at.a(this.tSu.tSt, 0L, false);
                        }
                        b bVar4 = at.tSs;
                        RefreshLoadMoreLayout.c cVar = (RefreshLoadMoreLayout.c) at.tSr.get(this.tSu.tSt.dcZ());
                        if (cVar != null && !cVar.Rmj) {
                            at.a(this.tSu.tSt, cVar);
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(244343);
                    return xVar;
                }
            });
            AppMethodBeat.o(244344);
        }
    }

    public static final class g extends IListener<hs> {
        final /* synthetic */ at tSt;

        g(at atVar) {
            this.tSt = atVar;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hs hsVar) {
            hs.a aVar;
            cd cdVar;
            hs.a aVar2;
            cd cdVar2;
            hs.a aVar3;
            cd cdVar3;
            AppMethodBeat.i(244354);
            hs hsVar2 = hsVar;
            if (1 == this.tSt.dLS) {
                if (!(hsVar2 == null || (aVar3 = hsVar2.dMm) == null || (cdVar3 = aVar3.dMo) == null || cdVar3.field_state != -1)) {
                    com.tencent.mm.ac.d.i(new b(this));
                }
                if (!(hsVar2 == null || (aVar = hsVar2.dMm) == null || (cdVar = aVar.dMo) == null || cdVar.field_state != -1 || (aVar2 = hsVar2.dMm) == null)) {
                    int i2 = aVar2.opType;
                    a.C1279a aVar4 = com.tencent.mm.plugin.finder.storage.a.vwq;
                    if (i2 == com.tencent.mm.plugin.finder.storage.a.vwp) {
                        for (com.tencent.mm.plugin.finder.model.f fVar : this.tSt.tSj) {
                            long j2 = fVar.feedId;
                            hs.a aVar5 = hsVar2.dMm;
                            if (aVar5 != null && j2 == aVar5.feedId) {
                                hs.a aVar6 = hsVar2.dMm;
                                fVar.uNO = (aVar6 == null || (cdVar2 = aVar6.dMo) == null) ? 0 : cdVar2.field_canRemove;
                                if (!at.b(this.tSt)) {
                                    com.tencent.mm.ac.d.h(new a(fVar, this, hsVar2));
                                }
                            }
                        }
                        if (at.b(this.tSt)) {
                            com.tencent.mm.ac.d.h(new c(this));
                        }
                    }
                }
            }
            AppMethodBeat.o(244354);
            return false;
        }

        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ com.tencent.mm.plugin.finder.model.f tSD;
            final /* synthetic */ g tSE;
            final /* synthetic */ hs tSF;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(com.tencent.mm.plugin.finder.model.f fVar, g gVar, hs hsVar) {
                super(0);
                this.tSD = fVar;
                this.tSE = gVar;
                this.tSF = hsVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                RecyclerView.a aVar;
                RecyclerView recyclerView;
                AppMethodBeat.i(244350);
                ai.b bVar = this.tSE.tSt.tRV;
                if (bVar == null || (recyclerView = bVar.getRecyclerView()) == null) {
                    aVar = null;
                } else {
                    aVar = recyclerView.getAdapter();
                }
                if (!(aVar instanceof WxRecyclerAdapter)) {
                    aVar = null;
                }
                WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
                if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.Or((long) this.tSD.hashCode());
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244350);
                return xVar;
            }
        }

        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ g tSE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(g gVar) {
                super(0);
                this.tSE = gVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(244353);
                FinderHomeTabFragment finderHomeTabFragment = this.tSE.tSt.tRb;
                if (finderHomeTabFragment != null) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ((FinderActionBarOverlayUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderActionBarOverlayUIC.class)).dHW();
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244353);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ g tSE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(g gVar) {
                super(0);
                this.tSE = gVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(244352);
                ConcurrentLinkedQueue concurrentLinkedQueue = this.tSE.tSt.tSj;
                for (T t : ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().dqi()) {
                    concurrentLinkedQueue.add(new com.tencent.mm.plugin.finder.model.f(t.feedId, t.objectNonceId, (byte) 0));
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.at.g.b.AnonymousClass1 */
                    final /* synthetic */ b tSG;

                    {
                        this.tSG = r2;
                    }

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        RecyclerView recyclerView;
                        AppMethodBeat.i(244351);
                        if (at.b(this.tSG.tSE.tSt)) {
                            FinderHomeTabFragment finderHomeTabFragment = this.tSG.tSE.tSt.tRb;
                            if (finderHomeTabFragment != null) {
                                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                ((FinderActionBarOverlayUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderActionBarOverlayUIC.class)).dHW();
                            }
                        } else {
                            for (com.tencent.mm.plugin.finder.model.f fVar : this.tSG.tSE.tSt.tSj) {
                                ai.b bVar = this.tSG.tSE.tSt.tRV;
                                RecyclerView.a adapter = (bVar == null || (recyclerView = bVar.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
                                if (!(adapter instanceof WxRecyclerAdapter)) {
                                    adapter = null;
                                }
                                WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
                                if (wxRecyclerAdapter != null) {
                                    kotlin.g.b.p.g(fVar, LocaleUtil.ITALIAN);
                                    wxRecyclerAdapter.a((com.tencent.mm.view.recyclerview.g) fVar, (g.b) true);
                                }
                            }
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(244351);
                        return xVar;
                    }
                });
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244352);
                return xVar;
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165897);
        AppMethodBeat.o(165897);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final int getTabType() {
        return this.dLS;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final com.tencent.mm.plugin.finder.view.e dcg() {
        AppMethodBeat.i(244378);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.view.e eVar = ((FinderCommentDrawerUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderCommentDrawerUIC.class)).tLT;
        AppMethodBeat.o(244378);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final RecyclerView.m dcf() {
        return this.tLO;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final com.tencent.mm.plugin.finder.video.k getVideoCore() {
        return this.tCD;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final boolean dbZ() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final String cND() {
        AppMethodBeat.i(244379);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        String str = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).sGQ;
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(244379);
        return str;
    }

    public static final class r implements k.b {
        final /* synthetic */ ai.b tSN;
        final /* synthetic */ at tSt;

        r(at atVar, ai.b bVar) {
            this.tSt = atVar;
            this.tSN = bVar;
        }

        @Override // com.tencent.mm.plugin.finder.video.k.b
        public final RecyclerView dch() {
            AppMethodBeat.i(165879);
            RecyclerView recyclerView = this.tSN.getRecyclerView();
            AppMethodBeat.o(165879);
            return recyclerView;
        }

        @Override // com.tencent.mm.plugin.finder.video.k.b
        public final DataBuffer<bo> dci() {
            AppMethodBeat.i(244362);
            DataBuffer<bo> dataListJustForAdapter = this.tSt.tRo.getDataListJustForAdapter();
            AppMethodBeat.o(244362);
            return dataListJustForAdapter;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        boolean z2;
        FinderHomeTabFragment finderHomeTabFragment;
        RecyclerView recyclerView;
        RefreshLoadMoreLayout dcQ;
        RefreshLoadMoreLayout dcQ2;
        FinderWhatsNewView dcY;
        Class<?> cls;
        RecyclerView recyclerView2 = null;
        AppMethodBeat.i(165900);
        kotlin.g.b.p.h(cVar, "reason");
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.gS(cND(), "EndCgi");
        FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tCD.weS;
        if (finderVideoAutoPlayManager != null) {
            StringBuilder sb = new StringBuilder();
            FinderHomeTabFragment finderHomeTabFragment2 = this.tRb;
            FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, sb.append((finderHomeTabFragment2 == null || (cls = finderHomeTabFragment2.getClass()) == null) ? null : cls.getSimpleName()).append("#onAttach").toString(), false);
        }
        Log.i(this.TAG, "[onRefreshEnd] reason=".concat(String.valueOf(cVar)));
        if (dcY() == null || (dcY = dcY()) == null || !dcY.isAttachedToWindow()) {
            if (cVar.Rmk > 0) {
                s(0, false);
            } else if (!dck()) {
                ai.b bVar = this.tRV;
                if (!(bVar == null || (dcQ2 = bVar.dcQ()) == null)) {
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    dcQ2.b(com.tencent.mm.plugin.finder.storage.c.dsb(), new y(this));
                }
            } else {
                ai.b bVar2 = this.tRV;
                if (!(bVar2 == null || (dcQ = bVar2.dcQ()) == null)) {
                    dcQ.b(0, z.tSP);
                }
            }
            checkEmptyHeader(cVar);
            ai.b bVar3 = this.tRV;
            if (!(bVar3 == null || (recyclerView = bVar3.getRecyclerView()) == null)) {
                recyclerView.post(new aa(this));
            }
            a(cVar, true);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) ah).getRedDotManager();
            switch (this.dLS) {
                case 1:
                    redDotManager.gI("TLRecommendTab", "onRefreshEnd");
                    redDotManager.asV("TLRecommendTab");
                    break;
                case 3:
                    redDotManager.gI("TLFollow", "onRefreshEnd");
                    redDotManager.asV("TLFollow");
                    break;
                case 4:
                    redDotManager.gI("finder_tl_hot_tab", "onRefreshEnd");
                    redDotManager.asV("finder_tl_hot_tab");
                    break;
            }
            DataBuffer dataListJustForAdapter = this.tRo.getDataListJustForAdapter();
            if (dataListJustForAdapter.size() <= 0 || ((bo) dataListJustForAdapter.get(0)).cxn() != 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            int i2 = this.dLS;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.report.h.a(i2, false, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), z2);
            if (com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.dLS, 0, 2) && (finderHomeTabFragment = this.tRb) != null) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                FinderFullFeedGuideUIC finderFullFeedGuideUIC = (FinderFullFeedGuideUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderFullFeedGuideUIC.class);
                ai.b bVar4 = this.tRV;
                if (bVar4 != null) {
                    recyclerView2 = bVar4.getRecyclerView();
                }
                finderFullFeedGuideUIC.setRecyclerView(recyclerView2);
                finderFullFeedGuideUIC.e((bo) kotlin.a.j.L(this.tRo.getDataListJustForAdapter(), 1));
                finderFullFeedGuideUIC.dIc();
            }
            this.tSo = true;
            AppMethodBeat.o(165900);
            return;
        }
        FinderWhatsNewView dcY2 = dcY();
        if (dcY2 != null) {
            dcY2.setDetachFinish(new x(this, cVar));
            AppMethodBeat.o(165900);
            return;
        }
        AppMethodBeat.o(165900);
    }

    public static final class aa implements Runnable {
        final /* synthetic */ at tSt;

        aa(at atVar) {
            this.tSt = atVar;
        }

        public final void run() {
            com.tencent.mm.plugin.finder.event.base.f MC;
            RecyclerView.c cVar;
            AppMethodBeat.i(244369);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tSt.gte);
            if (fH == null || (MC = fH.MC(this.tSt.dLS)) == null || (cVar = MC.tIo) == null) {
                AppMethodBeat.o(244369);
                return;
            }
            cVar.onChanged();
            AppMethodBeat.o(244369);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        ai.b bVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        AppMethodBeat.i(165901);
        kotlin.g.b.p.h(cVar, "reason");
        checkEmptyHeader(cVar);
        ai.b bVar2 = this.tRV;
        if (!(bVar2 == null || (recyclerView2 = bVar2.getRecyclerView()) == null)) {
            recyclerView2.post(new w(this));
        }
        com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, this.dLS, false, null, 12);
        Log.i(this.TAG, "[onLoadMoreEnd] reason=" + cVar + " isAutoLoadingMore=" + this.tSn);
        if (cVar.Rml && cVar.Rmj && (bVar = this.tRV) != null && (recyclerView = bVar.getRecyclerView()) != null && dck()) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(165901);
                throw tVar;
            }
            int ks = ((FinderLinearLayoutManager) layoutManager).ks() + 1;
            Log.i(this.TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(ks)));
            recyclerView.post(new ad(recyclerView, ks));
        }
        a(cVar, false);
        this.tSn = false;
        this.tSo = cVar.Rmj;
        AppMethodBeat.o(165901);
    }

    static final class w implements Runnable {
        final /* synthetic */ at tSt;

        w(at atVar) {
            this.tSt = atVar;
        }

        public final void run() {
            com.tencent.mm.plugin.finder.event.base.f MC;
            RecyclerView.c cVar;
            AppMethodBeat.i(178272);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tSt.gte);
            if (fH == null || (MC = fH.MC(this.tSt.dLS)) == null || (cVar = MC.tIo) == null) {
                AppMethodBeat.o(178272);
                return;
            }
            cVar.onChanged();
            AppMethodBeat.o(178272);
        }
    }

    static final class ad implements Runnable {
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ int tQg;

        ad(RecyclerView recyclerView, int i2) {
            this.tDJ = recyclerView;
            this.tQg = i2;
        }

        public final void run() {
            AppMethodBeat.i(244375);
            RecyclerView recyclerView = this.tDJ;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.tQg, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(244375);
        }
    }

    private final void s(long j2, boolean z2) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.LayoutManager layoutManager2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        AppMethodBeat.i(165902);
        ai.b bVar = this.tRV;
        RecyclerView.a adapter = (bVar == null || (recyclerView3 = bVar.getRecyclerView()) == null) ? null : recyclerView3.getAdapter();
        if (!(adapter instanceof WxRecyclerAdapter)) {
            adapter = null;
        }
        WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
        if (wxRecyclerAdapter == null || wxRecyclerAdapter.a(this.tRH)) {
            ai.b bVar2 = this.tRV;
            if (bVar2 == null || (recyclerView2 = bVar2.getRecyclerView()) == null) {
                layoutManager = null;
            } else {
                layoutManager = recyclerView2.getLayoutManager();
            }
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager2 = null;
            } else {
                layoutManager2 = layoutManager;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
            com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> dda = dda();
            if (dda == null || dda.a(this.tRH)) {
                if (!z2 && linearLayoutManager != null) {
                    linearLayoutManager.ah(1, 0);
                }
                ai.b bVar3 = this.tRV;
                if (bVar3 == null || (recyclerView = bVar3.getRecyclerView()) == null) {
                    AppMethodBeat.o(165902);
                    return;
                }
                recyclerView.postDelayed(new o(this, z2, linearLayoutManager, j2), j2);
                AppMethodBeat.o(165902);
                return;
            }
            AppMethodBeat.o(165902);
            return;
        }
        AppMethodBeat.o(165902);
    }

    public static final class o implements Runnable {
        final /* synthetic */ long $delay;
        final /* synthetic */ boolean tSM;
        final /* synthetic */ at tSt;
        final /* synthetic */ LinearLayoutManager tSy;

        o(at atVar, boolean z, LinearLayoutManager linearLayoutManager, long j2) {
            this.tSt = atVar;
            this.tSM = z;
            this.tSy = linearLayoutManager;
            this.$delay = j2;
        }

        public final void run() {
            com.tencent.mm.view.recyclerview.h hVar;
            RecyclerView recyclerView;
            AppMethodBeat.i(165877);
            com.tencent.mm.view.recyclerview.g d2 = at.d(this.tSt);
            if (d2 == null || (hVar = (com.tencent.mm.view.recyclerview.h) d2.V((long) this.tSt.tRH.hashCode(), false)) == null) {
                AppMethodBeat.o(165877);
                return;
            }
            Rect rect = new Rect();
            if (hVar.aus.getGlobalVisibleRect(rect) && rect.height() > 0) {
                if (this.tSM) {
                    ai.b bVar = this.tSt.tRV;
                    if (!(bVar == null || (recyclerView = bVar.getRecyclerView()) == null)) {
                        recyclerView.smoothScrollBy(0, rect.height());
                    }
                } else {
                    LinearLayoutManager linearLayoutManager = this.tSy;
                    if (linearLayoutManager != null) {
                        linearLayoutManager.ah(1, 0);
                    }
                }
                Log.i(this.tSt.TAG, "[hideSearchBar] to hide search bar. delay=" + this.$delay + " isSmooth=" + this.tSM + " height=" + rect.height());
            }
            AppMethodBeat.o(165877);
        }
    }

    static /* synthetic */ void a(at atVar) {
        AppMethodBeat.i(165904);
        atVar.checkEmptyHeader(null);
        AppMethodBeat.o(165904);
    }

    private final void checkEmptyHeader(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(165903);
        com.tencent.mm.ac.d.h(new e(this, cVar));
        AppMethodBeat.o(165903);
    }

    static /* synthetic */ void a(at atVar, RefreshLoadMoreLayout.c cVar) {
        AppMethodBeat.i(244381);
        atVar.a((RefreshLoadMoreLayout.c<Object>) cVar, false);
        AppMethodBeat.o(244381);
    }

    private final void a(RefreshLoadMoreLayout.c<Object> cVar, boolean z2) {
        RecyclerView.a aVar;
        int i2;
        RefreshLoadMoreLayout dcQ;
        RecyclerView recyclerView;
        boolean z3 = false;
        AppMethodBeat.i(244380);
        ai.b bVar = this.tRV;
        RecyclerView.a adapter = (bVar == null || (recyclerView = bVar.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
        if (!(adapter instanceof WxRecyclerAdapter)) {
            aVar = null;
        } else {
            aVar = adapter;
        }
        WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
        if (wxRecyclerAdapter != null) {
            i2 = wxRecyclerAdapter.hgt();
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            z3 = true;
        }
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsd() || !z3) {
            if ((this.dLS == 3 || this.dLS == 1) && cVar != null) {
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dsd() || (!z3 && !cVar.Rmj)) {
                    this.tSd = true;
                    com.tencent.mm.ac.d.h(new f(this, z3, cVar, wxRecyclerAdapter, z2));
                    tSr.put(dcZ(), cVar);
                    AppMethodBeat.o(244380);
                    return;
                } else if (z2 && wxRecyclerAdapter != null && wxRecyclerAdapter.b(this.tSi)) {
                    wxRecyclerAdapter.U(this.tSi.lT(), true);
                    ai.b bVar2 = this.tRV;
                    if (!(bVar2 == null || (dcQ = bVar2.dcQ()) == null)) {
                        dcQ.setEnableLoadMore(true);
                        AppMethodBeat.o(244380);
                        return;
                    }
                }
            }
            AppMethodBeat.o(244380);
            return;
        }
        AppMethodBeat.o(244380);
    }

    public final String dcZ() {
        AppMethodBeat.i(244382);
        List listOfType = this.tRo.getListOfType(BaseFinderFeed.class);
        boolean z2 = listOfType.size() == 0;
        String sb = new StringBuilder().append(this.dLS).append('_').append(z2 ? 0 : ((BaseFinderFeed) listOfType.get(0)).feedObject.getId()).append('_').append(z2 ? 0 : ((BaseFinderFeed) listOfType.get(listOfType.size() - 1)).feedObject.getId()).append('_').append(listOfType.size()).toString();
        AppMethodBeat.o(244382);
        return sb;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void requestRefresh() {
        long j2;
        AppMethodBeat.i(165905);
        ArrayList arrayList = new ArrayList();
        if (this.dLS == 3 || this.dLS == 1) {
            List listOfType = this.tRo.getListOfType(BaseFinderFeed.class);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            List a2 = com.tencent.mm.plugin.finder.utils.y.a(this.tRo.getDataList().getBuffer(), BaseFinderFeed.class);
            Log.i(this.TAG, "[requestRefresh] tabType=" + this.dLS + ", dataList=" + listOfType.size() + " buffer=" + a2.size());
            listOfType.addAll(a2);
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            arrayList.addAll(com.tencent.mm.plugin.finder.utils.y.u(listOfType, this.dLS));
            for (BaseFinderFeed baseFinderFeed : kotlin.a.j.m(arrayList)) {
                this.tRo.remove(baseFinderFeed.feedObject.field_id, true);
            }
            String str = this.TAG;
            StringBuilder append = new StringBuilder("[requestRefresh] tabType=").append(this.dLS).append(", unreadList=").append(arrayList.size()).append(" first=");
            BaseFinderFeed baseFinderFeed2 = (BaseFinderFeed) kotlin.a.j.kv(arrayList);
            if (baseFinderFeed2 != null) {
                j2 = baseFinderFeed2.lT();
            } else {
                j2 = 0;
            }
            Log.i(str, append.append(com.tencent.mm.ac.d.zs(j2)).append(" isFirstLoad=").append(this.tRo.tXs).toString());
        }
        com.tencent.mm.ac.d.i(new ac(this, arrayList));
        AppMethodBeat.o(165905);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void a(BaseFinderFeed baseFinderFeed, BaseFinderFeed baseFinderFeed2, int i2, List<? extends BaseFinderFeed> list, boolean z2, atn atn) {
        AppMethodBeat.i(244383);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        kotlin.g.b.p.h(baseFinderFeed2, "centerFeed");
        kotlin.g.b.p.h(list, "hasReadFeeds");
        FinderTimelineFeedLoader.b bVar = new FinderTimelineFeedLoader.b();
        bVar.tNO = baseFinderFeed;
        bVar.tXy = baseFinderFeed2;
        bVar.tXA = z2;
        bVar.tXx = i2;
        bVar.tuo = atn;
        this.tRo.requestInsert(bVar);
        AppMethodBeat.o(244383);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void boE() {
        AppMethodBeat.i(165906);
        com.tencent.mm.ac.d.i(new q(this));
        AppMethodBeat.o(165906);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final boolean onBackPressed() {
        boolean onBackPressed;
        AppMethodBeat.i(244384);
        if (this.tRV == null) {
            onBackPressed = false;
        } else {
            ai.b bVar = this.tRV;
            if (bVar == null) {
                kotlin.g.b.p.hyc();
            }
            onBackPressed = bVar.onBackPressed();
        }
        AppMethodBeat.o(244384);
        return onBackPressed;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(FinderItem finderItem, boolean z2, com.tencent.mm.view.recyclerview.h hVar) {
        Bitmap bitmap;
        float height;
        AppMethodBeat.i(244385);
        kotlin.g.b.p.h(finderItem, "feed");
        com.tencent.mm.plugin.finder.model.r rVar = com.tencent.mm.plugin.finder.model.r.uNW;
        com.tencent.mm.plugin.finder.model.r.a(this.gte, finderItem, z2);
        if (z2) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtS().value().intValue() == 1 && hVar != null) {
                int[] iArr = new int[2];
                switch (hVar.lU()) {
                    case 2:
                        RecyclerHorizontalViewPager pagerView = ((FinderMediaBanner) hVar.Mn(R.id.fbd)).getPagerView();
                        RecyclerView.LayoutManager layoutManager = pagerView.getLayoutManager();
                        if (layoutManager != null) {
                            RecyclerView.v ch = pagerView.ch(((LinearLayoutManager) layoutManager).ks());
                            if (ch != null) {
                                ImageView imageView = (ImageView) ((com.tencent.mm.view.recyclerview.h) ch).Mn(R.id.ckc);
                                kotlin.g.b.p.g(imageView, "view");
                                Drawable drawable = imageView.getDrawable();
                                if (drawable != null) {
                                    Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                                    imageView.getLocationInWindow(iArr);
                                    bitmap = bitmap2;
                                    break;
                                } else {
                                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                                    AppMethodBeat.o(244385);
                                    throw tVar;
                                }
                            } else {
                                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
                                AppMethodBeat.o(244385);
                                throw tVar2;
                            }
                        } else {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                            AppMethodBeat.o(244385);
                            throw tVar3;
                        }
                    case 3:
                    default:
                        bitmap = null;
                        break;
                    case 4:
                        FinderVideoLayout finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd);
                        Bitmap bitmap3 = finderVideoLayout.getBitmap();
                        finderVideoLayout.getLocationInWindow(iArr);
                        bitmap = bitmap3;
                        break;
                }
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                FinderFavAnimUIC finderFavAnimUIC = (FinderFavAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFavAnimUIC.class);
                kotlin.g.b.p.h(iArr, "startViewLocation");
                finderFavAnimUIC.wvN = iArr;
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                Rect rect = finderFavAnimUIC.wvM;
                kotlin.g.b.p.h(rect, "outRect");
                int[] iArr2 = new int[2];
                View findViewById = ((FinderHomeActionBarUIC) com.tencent.mm.ui.component.a.b(finderFavAnimUIC.getActivity()).get(FinderHomeActionBarUIC.class)).findViewById(R.id.ga5);
                if (findViewById != null) {
                    findViewById.getLocationInWindow(iArr2);
                    rect.set(iArr2[0], iArr2[1], iArr2[0] + findViewById.getWidth(), findViewById.getHeight() + iArr2[1]);
                }
                int[] iArr3 = finderFavAnimUIC.wvN;
                if (iArr3 == null) {
                    kotlin.g.b.p.btv("startLocation");
                }
                if (iArr3[1] < finderFavAnimUIC.wvM.bottom || bitmap == null) {
                    Log.i("FinderFavAnimUIC", "animFav: only animate star, bitmap = ".concat(String.valueOf(bitmap)));
                    finderFavAnimUIC.dIa();
                    AppMethodBeat.o(244385);
                    return;
                }
                Log.i("FinderFavAnimUIC", "[animFrameImage]");
                if (finderFavAnimUIC.wvF == null) {
                    FinderFavAnimUIC finderFavAnimUIC2 = finderFavAnimUIC;
                    finderFavAnimUIC2.wvF = new ImageView(finderFavAnimUIC2.getActivity());
                    kotlin.x xVar = kotlin.x.SXb;
                }
                ImageView imageView2 = finderFavAnimUIC.wvF;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(bitmap);
                    if (bitmap.getWidth() > bitmap.getHeight()) {
                        height = ((float) finderFavAnimUIC.wvH) / ((float) bitmap.getWidth());
                    } else {
                        height = ((float) finderFavAnimUIC.wvH) / ((float) bitmap.getHeight());
                    }
                    finderFavAnimUIC.wvL = height;
                    finderFavAnimUIC.wvP.start();
                }
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FAV_ANIM_TIMES_INT, 0);
                if (i2 < 3) {
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_FINDER_FAV_ANIM_TIMES_INT, Integer.valueOf(i2 + 1));
                }
                AppMethodBeat.o(244385);
                return;
            }
        }
        AppMethodBeat.o(244385);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(FinderItem finderItem) {
        AppMethodBeat.i(244386);
        kotlin.g.b.p.h(finderItem, "feed");
        s.a.a(com.tencent.mm.plugin.finder.utils.s.vWt, this.gte, finderItem, 0, 12);
        AppMethodBeat.o(244386);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void k(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(244387);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
        s.a.a(this.gte, baseFinderFeed, 4, 0, 20);
        AppMethodBeat.o(244387);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(BaseFinderFeed baseFinderFeed, boolean z2, boolean z3, int i2, boolean z4) {
        AppMethodBeat.i(244388);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
        aj ajVar = aj.uOw;
        FinderItem finderItem = baseFinderFeed.feedObject;
        boolean z5 = baseFinderFeed.showLikeTips;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aj.a(dIx, i2, finderItem, z2, z3, 2, z5, z4, com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact));
        AppMethodBeat.o(244388);
    }

    public static final class i extends com.tencent.mm.plugin.finder.view.f {
        final /* synthetic */ at tSt;
        private String tag;

        i(at atVar) {
            this.tSt = atVar;
            AppMethodBeat.i(244356);
            this.tag = atVar.TAG;
            AppMethodBeat.o(244356);
        }

        @Override // com.tencent.mm.plugin.finder.view.f
        public final String getTag() {
            return this.tag;
        }

        @Override // com.tencent.mm.plugin.finder.view.f
        public final FinderItem EB(long j2) {
            RecyclerView recyclerView;
            AppMethodBeat.i(165867);
            ai.b bVar = this.tSt.tRV;
            if (!(bVar == null || (recyclerView = bVar.getRecyclerView()) == null)) {
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                    AppMethodBeat.o(165867);
                    throw tVar;
                }
                RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
                if (vVar != null) {
                    int lR = vVar.lR();
                    RecyclerView.a adapter2 = recyclerView.getAdapter();
                    if (adapter2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                        AppMethodBeat.o(165867);
                        throw tVar2;
                    }
                    bo boVar = (bo) this.tSt.tRo.safeGet(lR - ((com.tencent.mm.view.recyclerview.g) adapter2).RqM.size());
                    if (boVar instanceof BaseFinderFeed) {
                        FinderItem finderItem = ((BaseFinderFeed) boVar).feedObject;
                        AppMethodBeat.o(165867);
                        return finderItem;
                    }
                }
            }
            AppMethodBeat.o(165867);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.view.f
        public final void a(long j2, azt azt) {
            RecyclerView recyclerView;
            AppMethodBeat.i(165868);
            ai.b bVar = this.tSt.tRV;
            if (bVar == null || (recyclerView = bVar.getRecyclerView()) == null) {
                AppMethodBeat.o(165868);
                return;
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(165868);
                throw tVar;
            }
            RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
            if (vVar != null) {
                int lR = vVar.lR();
                RecyclerView.a adapter2 = recyclerView.getAdapter();
                if (adapter2 != null) {
                    adapter2.b(lR, new kotlin.o(1, azt));
                    AppMethodBeat.o(165868);
                    return;
                }
                AppMethodBeat.o(165868);
                return;
            }
            AppMethodBeat.o(165868);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final List<g.b> getHeaderInfo() {
        FinderHomeTabFragment finderHomeTabFragment;
        AppMethodBeat.i(165909);
        LinkedList linkedList = new LinkedList();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, 0);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        int i3 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
        int i4 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, 0);
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
        int i5 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, 0);
        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
        this.msgNotifyData.count = aAh5.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, 0) + i2 + i3 + i4 + i5;
        com.tencent.mm.plugin.finder.model.h hVar = this.msgNotifyData;
        com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
        Object obj = aAh6.azQ().get(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(165909);
            throw tVar;
        }
        hVar.setAvatar((String) obj);
        Log.i(this.TAG, "commentCnt " + i2 + ", likeCnt " + i3 + " objectLikeLikeCnt " + i4 + " objectRecommendLikeCnt " + i5 + " avatar: " + this.msgNotifyData.uNR + " tabType " + this.dLS);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (!((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            af finderUtilApi = ((com.tencent.mm.plugin.i.a.aj) ah).getFinderUtilApi();
            kotlin.g.b.p.g(finderUtilApi, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
            if (!finderUtilApi.dDf()) {
                linkedList.add(this.tRH);
            }
        }
        if (1 == this.dLS) {
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af2).dxX()) {
                linkedList.add(this.msgNotifyData);
                ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.model.f> concurrentLinkedQueue = this.tSj;
                for (T t2 : ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().dqi()) {
                    concurrentLinkedQueue.add(new com.tencent.mm.plugin.finder.model.f(t2.feedId, t2.objectNonceId, (byte) 0));
                }
                linkedList.addAll(this.tSj);
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dtG().value().intValue() > 0) {
                    linkedList.add(this.tSf);
                }
            }
        }
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtX().value().intValue() != 0 && this.dLS == 4) {
            linkedList.add(this.tSg);
        }
        if (dck()) {
            linkedList.clear();
            if (1 == this.dLS) {
                com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
                kotlin.g.b.p.g(af3, "MMKernel.service(IFinder…enModeConfig::class.java)");
                if (!((com.tencent.mm.plugin.i.a.ad) af3).dxX() && (finderHomeTabFragment = this.tRb) != null) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    FinderActionBarOverlayUIC finderActionBarOverlayUIC = (FinderActionBarOverlayUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderActionBarOverlayUIC.class);
                    ah ahVar = this.tSk;
                    kotlin.g.b.p.h(ahVar, "headerFullMergedData");
                    finderActionBarOverlayUIC.tSk = ahVar;
                    ViewGroup viewGroup = (ViewGroup) finderActionBarOverlayUIC.findViewById(R.id.c3);
                    kotlin.g.b.p.g(viewGroup, "parent");
                    viewGroup.setVisibility(0);
                    View inflate = com.tencent.mm.ui.aa.jQ(finderActionBarOverlayUIC.getContext()).inflate(R.layout.f3115e, viewGroup, false);
                    viewGroup.addView(inflate);
                    com.tencent.mm.view.recyclerview.h hVar2 = new com.tencent.mm.view.recyclerview.h(inflate);
                    hVar2.setRecyclerView(finderActionBarOverlayUIC.getRecyclerView());
                    finderActionBarOverlayUIC.wvg = hVar2;
                    com.tencent.mm.view.recyclerview.h hVar3 = finderActionBarOverlayUIC.wvg;
                    if (hVar3 != null) {
                        finderActionBarOverlayUIC.wvf.a(finderActionBarOverlayUIC.getRecyclerView(), hVar3, TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE);
                        hVar3.et(ahVar);
                        finderActionBarOverlayUIC.wvf.a(hVar3, ahVar, 0);
                    }
                }
            }
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(165909);
        return linkedList2;
    }

    public static final class c implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ at tSt;

        c(at atVar) {
            this.tSt = atVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            int i3;
            AppMethodBeat.i(165865);
            switch (i2) {
                case -7:
                    com.tencent.mm.plugin.finder.convert.ac acVar = new com.tencent.mm.plugin.finder.convert.ac(this.tSt.dLS);
                    AppMethodBeat.o(165865);
                    return acVar;
                case -6:
                    bx bxVar = new bx();
                    AppMethodBeat.o(165865);
                    return bxVar;
                case -5:
                    com.tencent.mm.plugin.finder.convert.ab abVar = new com.tencent.mm.plugin.finder.convert.ab();
                    AppMethodBeat.o(165865);
                    return abVar;
                case -4:
                    com.tencent.mm.plugin.finder.convert.i iVar = new com.tencent.mm.plugin.finder.convert.i();
                    AppMethodBeat.o(165865);
                    return iVar;
                case -3:
                    ag agVar = new ag();
                    AppMethodBeat.o(165865);
                    return agVar;
                case -1:
                    com.tencent.mm.plugin.finder.convert.m mVar = new com.tencent.mm.plugin.finder.convert.m(new a(this));
                    AppMethodBeat.o(165865);
                    return mVar;
                case 1:
                    com.tencent.mm.plugin.finder.convert.ad adVar = new com.tencent.mm.plugin.finder.convert.ad(this.tSt, false, this.tSt.dLS, 2);
                    AppMethodBeat.o(165865);
                    return adVar;
                case 2:
                    if (at.b(this.tSt)) {
                        com.tencent.mm.plugin.finder.convert.q qVar = new com.tencent.mm.plugin.finder.convert.q(this.tSt, false, this.tSt.dLS, 2);
                        AppMethodBeat.o(165865);
                        return qVar;
                    }
                    com.tencent.mm.plugin.finder.convert.u uVar = new com.tencent.mm.plugin.finder.convert.u(this.tSt, false, this.tSt.dLS, 2);
                    AppMethodBeat.o(165865);
                    return uVar;
                case 4:
                    if (at.b(this.tSt)) {
                        com.tencent.mm.plugin.finder.convert.t tVar = new com.tencent.mm.plugin.finder.convert.t(this.tSt.tCD, this.tSt, false, this.tSt.dLS, 4);
                        AppMethodBeat.o(165865);
                        return tVar;
                    }
                    ak akVar = new ak(this.tSt.tCD, this.tSt, false, this.tSt.dLS, 4);
                    AppMethodBeat.o(165865);
                    return akVar;
                case 7:
                    com.tencent.mm.plugin.finder.convert.ai aiVar = new com.tencent.mm.plugin.finder.convert.ai(this.tSt, false, this.tSt.dLS, 2);
                    AppMethodBeat.o(165865);
                    return aiVar;
                case 8:
                    com.tencent.mm.plugin.finder.convert.aa aaVar = new com.tencent.mm.plugin.finder.convert.aa(this.tSt.tCD, this.tSt, false, this.tSt.dLS, 4);
                    AppMethodBeat.o(165865);
                    return aaVar;
                case 9:
                    if (at.b(this.tSt)) {
                        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tSt.gte);
                        if (fH != null) {
                            i3 = fH.tCE;
                        } else {
                            i3 = 0;
                        }
                        com.tencent.mm.plugin.finder.convert.r rVar = new com.tencent.mm.plugin.finder.convert.r(this.tSt.tCD, this.tSt, this.tSt.dLS, i3, 4);
                        AppMethodBeat.o(165865);
                        return rVar;
                    }
                    com.tencent.mm.plugin.finder.convert.x xVar = new com.tencent.mm.plugin.finder.convert.x(this.tSt.tCD, this.tSt);
                    AppMethodBeat.o(165865);
                    return xVar;
                case 2002:
                    bd bdVar = new bd();
                    AppMethodBeat.o(165865);
                    return bdVar;
                case 2003:
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.convert.y yVar = new com.tencent.mm.plugin.finder.convert.y(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tSt.gte).get(FinderReporterUIC.class)).dIx(), this.tSt.dLS);
                    AppMethodBeat.o(165865);
                    return yVar;
                case 2010:
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    cj cjVar = new cj(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tSt.gte).get(FinderReporterUIC.class)).dIx(), this.tSt.dLS);
                    AppMethodBeat.o(165865);
                    return cjVar;
                case 2011:
                    ap apVar = new ap(this.tSt.dLS);
                    AppMethodBeat.o(165865);
                    return apVar;
                case 2012:
                    com.tencent.mm.plugin.finder.convert.ar arVar = new com.tencent.mm.plugin.finder.convert.ar();
                    AppMethodBeat.o(165865);
                    return arVar;
                case 2013:
                    ch chVar = new ch(this.tSt, this.tSt.dLS);
                    AppMethodBeat.o(165865);
                    return chVar;
                case TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET:
                    com.tencent.mm.plugin.finder.convert.p pVar = new com.tencent.mm.plugin.finder.convert.p();
                    AppMethodBeat.o(165865);
                    return pVar;
                case TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE:
                    com.tencent.mm.plugin.finder.convert.s sVar = new com.tencent.mm.plugin.finder.convert.s();
                    AppMethodBeat.o(165865);
                    return sVar;
                case 3001:
                    if (this.tSt.dLS == 1) {
                        as asVar = new as();
                        AppMethodBeat.o(165865);
                        return asVar;
                    }
                    com.tencent.mm.plugin.finder.convert.u uVar2 = new com.tencent.mm.plugin.finder.convert.u(this.tSt, false, this.tSt.dLS, 2);
                    AppMethodBeat.o(165865);
                    return uVar2;
                case 3002:
                    if (this.tSt.dLS == 1) {
                        as asVar2 = new as();
                        AppMethodBeat.o(165865);
                        return asVar2;
                    }
                    ak akVar2 = new ak(this.tSt.tCD, this.tSt, false, this.tSt.dLS, 4);
                    AppMethodBeat.o(165865);
                    return akVar2;
                default:
                    com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    com.tencent.mm.plugin.finder.utils.y.dQ(this.tSt.TAG, i2);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(165865);
                    return fVar;
            }
        }

        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ c tSx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(0);
                this.tSx = cVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(244347);
                this.tSx.tSt.tRo.requestRefresh();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244347);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final com.tencent.mm.view.recyclerview.f dce() {
        AppMethodBeat.i(165910);
        c cVar = new c(this);
        AppMethodBeat.o(165910);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void onUIPause() {
        AppMethodBeat.i(178274);
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnT();
        AppMethodBeat.o(178274);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void onUserVisibleFocused() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        bbn bbn;
        bbn bbn2;
        FinderHomeTabFragment finderHomeTabFragment;
        Bundle bundle;
        RecyclerView recyclerView4;
        AppMethodBeat.i(244390);
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.s dpl = com.tencent.mm.plugin.finder.report.live.k.dpl();
        ai.b bVar = this.tRV;
        if (bVar != null) {
            recyclerView = bVar.getRecyclerView();
        } else {
            recyclerView = null;
        }
        dpl.vmq = new WeakReference<>(recyclerView);
        switch (this.dLS) {
            case 1:
                ai.b bVar2 = this.tRV;
                if (!(bVar2 == null || (recyclerView3 = bVar2.getRecyclerView()) == null)) {
                    recyclerView3.a(this.tSq);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                ai.b bVar3 = this.tRV;
                com.tencent.mm.plugin.finder.report.live.k.b(bVar3 != null ? bVar3.getRecyclerView() : null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
                break;
            case 4:
                ai.b bVar4 = this.tRV;
                if (!(bVar4 == null || (recyclerView2 = bVar4.getRecyclerView()) == null)) {
                    recyclerView2.a(this.tSq);
                    break;
                }
        }
        dcO();
        if (this.dLS == 4 && (finderHomeTabFragment = this.tRb) != null && (bundle = finderHomeTabFragment.Ew) != null && bundle.getInt("RequestScene", -1) == 1) {
            this.tRo.requestInit(true);
            Bundle bundle2 = this.tRb.Ew;
            int i2 = bundle2 != null ? bundle2.getInt("ScrollPosition", -1) : -1;
            Log.i(this.TAG, "[onUserVisibleFocused] requestInit after scroll to position[" + i2 + ']');
            com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> dda = dda();
            int size = (dda != null ? dda.RqM.size() : 0) + i2;
            ai.b bVar5 = this.tRV;
            RecyclerView.LayoutManager layoutManager = (bVar5 == null || (recyclerView4 = bVar5.getRecyclerView()) == null) ? null : recyclerView4.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.ah(size, 0);
            }
            Bundle bundle3 = this.tRb.Ew;
            if (bundle3 != null && bundle3.getBoolean("RequestLoadMore", false)) {
                ddb();
            }
        }
        if (this.dLS == 3 && this.tRo.tXq) {
            Log.i(this.TAG, "postFeedFlag true");
            Intent intent = this.gte.getIntent();
            if (intent != null) {
                intent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", true);
            }
            this.tRo.tXq = false;
        }
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah).getRedDotManager().asX("TLWxBubble");
        bdo atl = asX != null ? asX.atl("TLWxBubble") : null;
        if (!(1 != this.dLS || asX == null || atl == null)) {
            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            com.tencent.mm.plugin.finder.report.j.a("7", asX, atl, 1, fH != null ? fH.dIx() : null, 0, 0, 96);
            com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
            int i3 = atl.xGz;
            int i4 = this.msgNotifyData.count;
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (fH2 != null) {
                bbn2 = fH2.dIx();
            } else {
                bbn2 = null;
            }
            com.tencent.mm.plugin.finder.report.k.a("7", 5, 1, i3, 0, i4, (String) null, (String) null, 0, bbn2, 0, 0, 3520);
        }
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.k asX2 = ((PluginFinder) ah2).getRedDotManager().asX("TLWxPrivateMsgBubble");
        bdo atl2 = asX2 != null ? asX2.atl("TLWxPrivateMsgBubble") : null;
        if (!(1 != this.dLS || asX2 == null || atl2 == null)) {
            com.tencent.mm.plugin.finder.report.j jVar2 = com.tencent.mm.plugin.finder.report.j.vft;
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this.gte);
            if (fH3 != null) {
                bbn = fH3.dIx();
            } else {
                bbn = null;
            }
            com.tencent.mm.plugin.finder.report.j.a("7", asX2, atl2, 1, bbn, 0, 0, 96);
        }
        AppMethodBeat.o(244390);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void M(boolean z2, boolean z3) {
        int i2;
        RecyclerView.LayoutManager layoutManager;
        ai.b bVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        AppMethodBeat.i(244392);
        if (this.tlCache.JN(this.dLS) || z2) {
            ai.b bVar2 = this.tRV;
            RecyclerView.LayoutManager layoutManager2 = (bVar2 == null || (recyclerView3 = bVar2.getRecyclerView()) == null) ? null : recyclerView3.getLayoutManager();
            if (!(layoutManager2 instanceof LinearLayoutManager)) {
                layoutManager2 = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
            if (linearLayoutManager != null) {
                i2 = linearLayoutManager.ks();
            } else {
                i2 = 0;
            }
            Log.i(this.TAG, "[checkAutoFlingToRefresh] isHard=" + z2 + " isWithRefresh=" + z3 + " offset=" + i2);
            ai.b bVar3 = this.tRV;
            if (bVar3 == null || (recyclerView2 = bVar3.getRecyclerView()) == null) {
                layoutManager = null;
            } else {
                layoutManager = recyclerView2.getLayoutManager();
            }
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager2 != null) {
                linearLayoutManager2.ah(0, 0);
            }
            if (!(i2 >= 0 || (bVar = this.tRV) == null || (recyclerView = bVar.getRecyclerView()) == null)) {
                recyclerView.post(new d(linearLayoutManager2));
            }
            if (z3) {
                com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
                com.tencent.mm.plugin.finder.report.h.Kl(this.dLS);
                ai.b bVar4 = this.tRV;
                if (bVar4 != null) {
                    bVar4.dcP();
                }
            }
            this.canTimelineRefresh = false;
        }
        com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnT();
        AppMethodBeat.o(244392);
    }

    static final class d implements Runnable {
        final /* synthetic */ LinearLayoutManager tSy;

        d(LinearLayoutManager linearLayoutManager) {
            this.tSy = linearLayoutManager;
        }

        public final void run() {
            AppMethodBeat.i(244348);
            LinearLayoutManager linearLayoutManager = this.tSy;
            if (linearLayoutManager != null) {
                linearLayoutManager.ah(0, 0);
                AppMethodBeat.o(244348);
                return;
            }
            AppMethodBeat.o(244348);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void onUIResume() {
        boolean z2 = true;
        AppMethodBeat.i(165911);
        dcO();
        com.tencent.mm.plugin.finder.utils.p pVar = com.tencent.mm.plugin.finder.utils.p.vVY;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.dCB()) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            if (!(aAh.azQ().getInt(ar.a.USERINFO_MY_FINDER_ORIGINAL_REDDOT_FLAG2_INT_SYNC, 0) == 1) && com.tencent.mm.plugin.finder.utils.p.dBV() && !com.tencent.mm.plugin.finder.utils.p.dBZ()) {
                com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager();
                bbi bbi = new bbi();
                bbi.LKM = String.valueOf(cl.aWA());
                bbi.priority = SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
                bbi.type = 1000;
                bdo bdo = new bdo();
                bdo.xGz = 1;
                bdo.LNm = 1;
                bdo.path = "ProfileEntrance";
                bbi.GaM.add(bdo);
                bdo bdo2 = new bdo();
                bdo2.xGz = 1;
                bdo2.LNm = 1;
                bdo2.path = "FinderSetting";
                bbi.GaM.add(bdo2);
                bdo bdo3 = new bdo();
                bdo3.xGz = 1;
                bdo3.LNm = 1;
                bdo3.path = "OriginalEntrance";
                bbi.GaM.add(bdo3);
                com.tencent.mm.plugin.finder.extension.reddot.f.a(redDotManager, bbi, "checkInsertOriginalRedDot", null, true, null, 20);
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_REDDOT_FLAG2_INT_SYNC, (Object) 1);
                Log.i(com.tencent.mm.plugin.finder.utils.p.TAG, "insertOriginalRedDot");
            }
        }
        if (this.dLS == 3) {
            long longExtra = this.gte.getIntent().getLongExtra("key_finder_post_local_id", -1);
            if (!this.gte.getIntent().getBooleanExtra("key_form_sns", false) && !this.gte.getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false)) {
                z2 = false;
            }
            boolean booleanExtra = this.gte.getIntent().getBooleanExtra("KEY_FROM_SDK_SHARE", false);
            if (longExtra != -1 && (z2 || booleanExtra)) {
                this.tRo.onPostStart(longExtra, z2);
            }
            this.gte.getIntent().removeExtra("key_finder_post_local_id");
        }
        AppMethodBeat.o(165911);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void dcO() {
        AppMethodBeat.i(244393);
        com.tencent.mm.ac.d.i(new ab(this));
        AppMethodBeat.o(244393);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        View view;
        AppMethodBeat.i(165913);
        Log.i(this.TAG, "onDestroy");
        com.tencent.mm.plugin.finder.storage.data.f.vGd.clearCache();
        this.tRZ.dead();
        ai.b bVar = this.tRV;
        if (bVar != null) {
            RecyclerView.LayoutManager layoutManager = bVar.getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(165913);
                throw tVar;
            }
            int ks = ((LinearLayoutManager) layoutManager).ks();
            com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> dda = dda();
            int size = ks - (dda != null ? dda.RqM.size() : 0);
            RecyclerView.v cg = bVar.getRecyclerView().cg(ks);
            int top = (cg == null || (view = cg.aus) == null) ? 0 : view.getTop();
            for (bo boVar : this.tRo.getDataListJustForAdapter()) {
                if (boVar instanceof BaseFinderFeed) {
                    ((BaseFinderFeed) boVar).dku();
                }
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderHomeTabStateVM.a((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class), this.dLS, size, top, this.tRo.getDataListJustForAdapter());
        }
        Iterator<T> it = this.tLP.iterator();
        while (it.hasNext()) {
            it.next().dead();
        }
        this.tLP.clear();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MF = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).MF(this.dLS);
        if (MF != null) {
            MF.b(this);
            MF.b(dcW());
        }
        dcW().onDetach();
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MF2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).MF(this.dLS);
        if (MF2 != null) {
            MF2.b(this);
            MF2.b(dcX());
        }
        dcX().onDetach();
        this.tRo.unregister(this.tMe);
        EventCenter.instance.removeListener(this.tSe);
        EventCenter.instance.removeListener(this.tSp);
        com.tencent.mm.plugin.finder.view.b bVar2 = this.tPE;
        if (bVar2 != null) {
            bVar2.dead();
        }
        this.tRV = null;
        AppMethodBeat.o(165913);
    }

    private final com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> dda() {
        RecyclerView recyclerView;
        AppMethodBeat.i(165914);
        ai.b bVar = this.tRV;
        RecyclerView.a adapter = (bVar == null || (recyclerView = bVar.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
        if (!(adapter instanceof com.tencent.mm.view.recyclerview.g)) {
            adapter = null;
        }
        com.tencent.mm.view.recyclerview.g<com.tencent.mm.view.recyclerview.h> gVar = (com.tencent.mm.view.recyclerview.g) adapter;
        AppMethodBeat.o(165914);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final o.f a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
        AppMethodBeat.i(165915);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        kotlin.g.b.p.h(eVar, "sheet");
        l lVar = new l(this, baseFinderFeed, eVar);
        AppMethodBeat.o(165915);
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0020, code lost:
            if (r0 == null) goto L_0x0022;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.d invoke() {
            /*
                r3 = this;
                r2 = 244355(0x3ba83, float:3.42414E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.mm.plugin.finder.feed.at r0 = r3.tSt
                com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment r0 = com.tencent.mm.plugin.finder.feed.at.c(r0)
                if (r0 == 0) goto L_0x0022
                com.tencent.mm.ui.component.a r1 = com.tencent.mm.ui.component.a.PRN
                android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
                android.arch.lifecycle.ViewModelProvider r0 = com.tencent.mm.ui.component.a.of(r0)
                java.lang.Class<com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC> r1 = com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC.class
                android.arch.lifecycle.ViewModel r0 = r0.get(r1)
                com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC r0 = (com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC) r0
                com.tencent.mm.plugin.finder.feed.model.d r0 = r0.tLy
                if (r0 != 0) goto L_0x003a
            L_0x0022:
                com.tencent.mm.ui.component.a r0 = com.tencent.mm.ui.component.a.PRN
                com.tencent.mm.plugin.finder.feed.at r0 = r3.tSt
                com.tencent.mm.ui.MMActivity r0 = com.tencent.mm.plugin.finder.feed.at.g(r0)
                android.support.v7.app.AppCompatActivity r0 = (android.support.v7.app.AppCompatActivity) r0
                android.arch.lifecycle.ViewModelProvider r0 = com.tencent.mm.ui.component.a.b(r0)
                java.lang.Class<com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC> r1 = com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC.class
                android.arch.lifecycle.ViewModel r0 = r0.get(r1)
                com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC r0 = (com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC) r0
                com.tencent.mm.plugin.finder.feed.model.d r0 = r0.tLy
            L_0x003a:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.at.h.invoke():java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.f> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0020, code lost:
            if (r0 == null) goto L_0x0022;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.f invoke() {
            /*
                r3 = this;
                r2 = 244357(0x3ba85, float:3.42417E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.mm.plugin.finder.feed.at r0 = r3.tSt
                com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment r0 = com.tencent.mm.plugin.finder.feed.at.c(r0)
                if (r0 == 0) goto L_0x0022
                com.tencent.mm.ui.component.a r1 = com.tencent.mm.ui.component.a.PRN
                android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
                android.arch.lifecycle.ViewModelProvider r0 = com.tencent.mm.ui.component.a.of(r0)
                java.lang.Class<com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC> r1 = com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC.class
                android.arch.lifecycle.ViewModel r0 = r0.get(r1)
                com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC r0 = (com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC) r0
                com.tencent.mm.plugin.finder.feed.model.f r0 = r0.wyi
                if (r0 != 0) goto L_0x003a
            L_0x0022:
                com.tencent.mm.ui.component.a r0 = com.tencent.mm.ui.component.a.PRN
                com.tencent.mm.plugin.finder.feed.at r0 = r3.tSt
                com.tencent.mm.ui.MMActivity r0 = com.tencent.mm.plugin.finder.feed.at.g(r0)
                android.support.v7.app.AppCompatActivity r0 = (android.support.v7.app.AppCompatActivity) r0
                android.arch.lifecycle.ViewModelProvider r0 = com.tencent.mm.ui.component.a.b(r0)
                java.lang.Class<com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC> r1 = com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC.class
                android.arch.lifecycle.ViewModel r0 = r0.get(r1)
                com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC r0 = (com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC) r0
                com.tencent.mm.plugin.finder.feed.model.f r0 = r0.wyi
            L_0x003a:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.at.k.invoke():java.lang.Object");
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final o.f i(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(165916);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        m mVar = new m(this, baseFinderFeed);
        AppMethodBeat.o(165916);
        return mVar;
    }

    static final class m implements o.f {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ at tSt;

        m(at atVar, BaseFinderFeed baseFinderFeed) {
            this.tSt = atVar;
            this.tEM = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(165872);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.C(this.tEM.feedObject)) {
                b bVar = at.tSs;
                int i2 = at.tLJ;
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                mVar.a(i2, com.tencent.mm.plugin.finder.utils.y.x(this.tEM), R.raw.finder_bgm_gif_first_page, !this.tEM.feedObject.isPostFinish() || this.tEM.feedObject.isPostFailed());
            }
            if (!at.n(this.tEM)) {
                if (!(this.tSt.dLS == 3 || this.tSt.dLS == 1)) {
                    b bVar2 = at.tSs;
                    mVar.b(at.tLD, this.tSt.gte.getString(R.string.f3j), R.raw.finder_feed_dislike);
                }
                b bVar3 = at.tSs;
                mVar.b(at.pMa, this.tSt.gte.getString(R.string.f3g), R.raw.icons_outlined_report_problem);
            } else {
                com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.w(this.tEM)) {
                    b bVar4 = at.tSs;
                    mVar.aS(at.jUx, R.string.tf, R.raw.icons_outlined_delete);
                    if (this.tEM.feedObject.isCommentClose()) {
                        b bVar5 = at.tSs;
                        mVar.b(at.tLH, this.tSt.gte.getString(R.string.cnl), R.raw.icons_outlined_comment);
                    } else {
                        b bVar6 = at.tSs;
                        mVar.b(at.tLG, this.tSt.gte.getString(R.string.cmn), R.raw.finder_feed_discomment);
                    }
                    if (!at.b(this.tSt)) {
                        com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.isAnyEnableFullScreenEnjoy() && (this.tEM.cxn() == 4 || this.tEM.cxn() == 2)) {
                            b bVar7 = at.tSs;
                            mVar.b(at.tLM, this.tSt.gte.getString(R.string.cno), R.raw.finder_icons_outlined_max_window);
                        }
                    }
                }
            }
            int indexOf = this.tSt.tRo.getDataListJustForAdapter().indexOf(this.tEM);
            if (indexOf < 0) {
                Log.i(this.tSt.TAG, "pos is error " + indexOf + ' ' + this.tEM);
                if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "pos is error " + indexOf + ' ' + this.tEM + ' ', 1).show();
                }
            }
            AppMethodBeat.o(165872);
        }
    }

    public static final class n implements o.g {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ at tSt;

        n(at atVar, BaseFinderFeed baseFinderFeed) {
            this.tSt = atVar;
            this.tEM = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, final int i2) {
            Object[] objArr;
            azr azr = null;
            azr azr2 = null;
            bbn bbn = null;
            bbn bbn2 = null;
            int i3 = 0;
            AppMethodBeat.i(165876);
            String str = this.tSt.TAG;
            StringBuilder append = new StringBuilder("[getMoreMenuItemSelectedListener] feed ").append(this.tEM).append(' ').append(i2).append(" menuItem:");
            kotlin.g.b.p.g(menuItem, "menuItem");
            Log.i(str, append.append(menuItem.getItemId()).toString());
            int itemId = menuItem.getItemId();
            b bVar = at.tSs;
            if (itemId == at.tLD) {
                final List listOfType = this.tSt.tRo.getListOfType(BaseFinderFeed.class);
                int indexOf = listOfType.indexOf(this.tEM);
                if (indexOf >= 0) {
                    com.tencent.mm.plugin.finder.feed.logic.c cVar = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
                    com.tencent.mm.plugin.finder.feed.logic.c.a(this.tSt.gte, this.tEM.feedObject.getId(), this.tEM.feedObject.getObjectNonceId(), new kotlin.g.a.b<Integer, LinkedList<Long>>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass1 */
                        final /* synthetic */ n tSI;

                        {
                            this.tSI = r2;
                        }

                        @Override // kotlin.g.a.b
                        public final /* synthetic */ LinkedList<Long> invoke(Integer num) {
                            AppMethodBeat.i(178266);
                            LinkedList<Long> II = II(num.intValue());
                            AppMethodBeat.o(178266);
                            return II;
                        }

                        private LinkedList<Long> II(int i2) {
                            AppMethodBeat.i(244358);
                            LinkedList<Long> linkedList = new LinkedList<>();
                            LinkedList<kotlin.o> linkedList2 = new LinkedList();
                            List list = listOfType;
                            synchronized (list) {
                                try {
                                    int i3 = 0;
                                    for (Object obj : list) {
                                        int i4 = i3 + 1;
                                        if (i3 < 0) {
                                            kotlin.a.j.hxH();
                                        }
                                        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) obj;
                                        if ((baseFinderFeed instanceof BaseFinderFeed) && baseFinderFeed.feedObject.getId() == this.tSI.tEM.feedObject.getId()) {
                                            linkedList2.add(0, new kotlin.o(Integer.valueOf(i3), baseFinderFeed));
                                        }
                                        i3 = i4;
                                    }
                                    kotlin.x xVar = kotlin.x.SXb;
                                } catch (Throwable th) {
                                    AppMethodBeat.o(244358);
                                    throw th;
                                }
                            }
                            for (kotlin.o oVar : linkedList2) {
                                Log.i(this.tSI.tSt.TAG, "[not interested] removeAt " + i2 + " subType=" + i2 + ' ' + oVar.second.feedObject);
                                this.tSI.tSt.tRo.getDataListJustForAdapter().remove(oVar.second);
                                linkedList.add(Long.valueOf(oVar.second.feedObject.m21getCreateTime()));
                                this.tSI.tSt.tMe.onItemRangeRemoved(oVar.first.intValue(), 1);
                            }
                            Log.i(this.tSI.tSt.TAG, "[not interested] feed " + this.tSI.tEM);
                            at.a(this.tSI.tSt);
                            AppMethodBeat.o(244358);
                            return linkedList;
                        }
                    });
                    AppMethodBeat.o(165876);
                    return;
                }
                Log.i(this.tSt.TAG, "[not interested] pos error=" + indexOf + ", feed=" + this.tEM + ", dataList=" + listOfType);
                AppMethodBeat.o(165876);
                return;
            }
            b bVar2 = at.tSs;
            if (itemId != at.jUx) {
                b bVar3 = at.tSs;
                if (itemId != at.tzW) {
                    b bVar4 = at.tSs;
                    if (itemId == at.tqv) {
                        new Bundle();
                        com.tencent.mm.plugin.finder.utils.s.vWt.a(this.tSt.gte, this.tEM.feedObject, 3);
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar5 = at.tSs;
                    if (itemId == at.pLU) {
                        s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
                        s.a.a(this.tSt.gte, this.tEM, 0, 0, 28);
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar6 = at.tSs;
                    if (itemId == at.tLE) {
                        com.tencent.mm.plugin.finder.utils.g gVar = com.tencent.mm.plugin.finder.utils.g.vVq;
                        com.tencent.mm.plugin.finder.utils.g.a(this.tEM, this.tSt.gte);
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar7 = at.tSs;
                    if (itemId == at.pMa) {
                        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.w(this.tEM)) {
                            awe liveInfo = this.tEM.feedObject.getLiveInfo();
                            if (liveInfo != null) {
                                long j2 = liveInfo.liveId;
                                com.tencent.mm.plugin.finder.feed.logic.a aVar2 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                                com.tencent.mm.plugin.finder.feed.logic.a.b(this.tSt.gte, j2, this.tEM.feedObject.getUserName());
                                AppMethodBeat.o(165876);
                                return;
                            }
                            AppMethodBeat.o(165876);
                            return;
                        }
                        com.tencent.mm.plugin.finder.feed.logic.a aVar3 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                        com.tencent.mm.plugin.finder.feed.logic.a.a(this.tSt.gte, this.tEM.feedObject.field_id, 0, 0, 12);
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar8 = at.tSs;
                    if (itemId == at.tLF) {
                        Intent intent = new Intent();
                        FinderObjectDesc finderObjectDesc = this.tEM.feedObject.getFeedObject().objectDesc;
                        intent.putExtra("postRefMediaList", finderObjectDesc != null ? finderObjectDesc.toByteArray() : null);
                        com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        intent.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.y.u(this.tEM).toByteArray());
                        intent.putExtra("postType", this.tEM.feedObject.getMediaType());
                        intent.putExtra("key_finder_post_from", 5);
                        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this.tSt.gte, intent);
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar9 = at.tSs;
                    if (itemId == at.tLH) {
                        ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(this.tEM.feedObject.getId(), this.tEM.feedObject.getFeedObject(), this.tEM.feedObject.getObjectNonceId(), true, new com.tencent.mm.plugin.i.a.ai<ayy>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass3 */
                            final /* synthetic */ n tSI;

                            {
                                this.tSI = r1;
                            }

                            @Override // com.tencent.mm.plugin.i.a.ai
                            public final /* synthetic */ void a(ayy ayy, apg apg) {
                                AppMethodBeat.i(165875);
                                kotlin.g.b.p.h(ayy, "req");
                                kotlin.g.b.p.h(apg, "ret");
                                if (apg.retCode == 0) {
                                    com.tencent.mm.ui.base.u.makeText(this.tSI.tSt.gte, (int) R.string.cnn, 0).show();
                                    AppMethodBeat.o(165875);
                                    return;
                                }
                                com.tencent.mm.ui.base.u.makeText(this.tSI.tSt.gte, (int) R.string.cnm, 0).show();
                                Log.i(this.tSI.tSt.TAG, "finder_feed_open_comment_no_ok " + apg.retCode);
                                AppMethodBeat.o(165875);
                            }
                        });
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar10 = at.tSs;
                    if (itemId == at.tLG) {
                        ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(this.tEM.feedObject.getId(), this.tEM.feedObject.getFeedObject(), this.tEM.feedObject.getObjectNonceId(), false, new com.tencent.mm.plugin.i.a.ai<ayy>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass4 */
                            final /* synthetic */ n tSI;

                            {
                                this.tSI = r1;
                            }

                            @Override // com.tencent.mm.plugin.i.a.ai
                            public final /* synthetic */ void a(ayy ayy, apg apg) {
                                AppMethodBeat.i(178270);
                                kotlin.g.b.p.h(ayy, "req");
                                kotlin.g.b.p.h(apg, "ret");
                                if (apg.retCode == 0) {
                                    com.tencent.mm.ui.base.u.makeText(this.tSI.tSt.gte, (int) R.string.cmp, 0).show();
                                    AppMethodBeat.o(178270);
                                    return;
                                }
                                com.tencent.mm.ui.base.u.makeText(this.tSI.tSt.gte, (int) R.string.cmo, 0).show();
                                Log.i(this.tSI.tSt.TAG, "finder_feed_close_comment_ok " + apg.retCode);
                                AppMethodBeat.o(178270);
                            }
                        });
                        AppMethodBeat.o(165876);
                        return;
                    }
                    b bVar11 = at.tSs;
                    if (itemId != at.tLJ) {
                        b bVar12 = at.tSs;
                        if (itemId == at.tLK) {
                            com.tencent.mm.plugin.finder.report.aj ajVar = com.tencent.mm.plugin.finder.report.aj.viU;
                            FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tSt.gte);
                            if (fH != null) {
                                bbn = fH.dIx();
                            }
                            com.tencent.mm.plugin.finder.report.aj.a(bbn, "fav_in_menu", false, this.tEM.lT());
                            com.tencent.mm.ui.base.u.a(this.tSt.gte, this.tSt.gte.getResources().getString(R.string.cp8), new u.b(this) {
                                /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass5 */
                                final /* synthetic */ n tSI;

                                {
                                    this.tSI = r1;
                                }

                                @Override // com.tencent.mm.ui.base.u.b
                                public final void dU(View view) {
                                    WeImageView weImageView;
                                    TextView textView;
                                    AppMethodBeat.i(244359);
                                    if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                                        textView.setTextSize(1, 14.0f);
                                    }
                                    if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                                        weImageView.setImageResource(R.raw.icons_filled_done);
                                        Context context = weImageView.getContext();
                                        kotlin.g.b.p.g(context, "context");
                                        weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                                    }
                                    this.tSI.tSt.a(this.tSI.tEM.feedObject, true, (com.tencent.mm.view.recyclerview.h) null);
                                    AppMethodBeat.o(244359);
                                }
                            });
                            AppMethodBeat.o(165876);
                            return;
                        }
                        b bVar13 = at.tSs;
                        if (itemId == at.tLL) {
                            com.tencent.mm.plugin.finder.report.aj ajVar2 = com.tencent.mm.plugin.finder.report.aj.viU;
                            FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.tSt.gte);
                            if (fH2 != null) {
                                bbn2 = fH2.dIx();
                            }
                            com.tencent.mm.plugin.finder.report.aj.a(bbn2, "unfav_in_menu", false, this.tEM.lT());
                            com.tencent.mm.ui.base.u.a(this.tSt.gte, this.tSt.gte.getResources().getString(R.string.cp7), new u.b(this) {
                                /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass6 */
                                final /* synthetic */ n tSI;

                                {
                                    this.tSI = r1;
                                }

                                @Override // com.tencent.mm.ui.base.u.b
                                public final void dU(View view) {
                                    WeImageView weImageView;
                                    TextView textView;
                                    AppMethodBeat.i(244360);
                                    if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                                        textView.setTextSize(1, 14.0f);
                                    }
                                    if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                                        weImageView.setImageResource(R.raw.icons_filled_done);
                                        Context context = weImageView.getContext();
                                        kotlin.g.b.p.g(context, "context");
                                        weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                                    }
                                    this.tSI.tSt.a(this.tSI.tEM.feedObject, false, (com.tencent.mm.view.recyclerview.h) null);
                                    AppMethodBeat.o(244360);
                                }
                            });
                            AppMethodBeat.o(165876);
                            return;
                        }
                        b bVar14 = at.tSs;
                        if (itemId != at.tLJ) {
                            b bVar15 = at.tSs;
                            if (itemId == at.tLM) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("KEY_FROM_SCENE", 1);
                                intent2.putExtra("KEY_USERNAME", com.tencent.mm.model.z.aUg());
                                intent2.putExtra("KEY_FINDER_SELF_FLAG", true);
                                OccupyFinderUI10.a aVar7 = OccupyFinderUI10.udX;
                                intent2.putExtra(OccupyFinderUI10.udV, true);
                                OccupyFinderUI10.a aVar8 = OccupyFinderUI10.udX;
                                intent2.putExtra(OccupyFinderUI10.udW, false);
                                com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                                com.tencent.mm.plugin.finder.utils.y.a(0, kotlin.a.j.listOf(this.tEM), (com.tencent.mm.bw.b) null, intent2);
                                com.tencent.mm.plugin.finder.utils.a aVar9 = com.tencent.mm.plugin.finder.utils.a.vUU;
                                com.tencent.mm.plugin.finder.utils.a.ac(this.tSt.gte, intent2);
                            }
                        } else if (this.tEM.feedObject.isPostFinish()) {
                            FinderReporterUIC.a aVar10 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this.tSt.gte);
                            if (fH3 != null) {
                                i3 = fH3.tCE;
                            }
                            if (i3 != 52) {
                                e.a aVar11 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                                e.a.n(this.tEM.feedObject);
                                com.tencent.mm.plugin.finder.utils.w wVar = com.tencent.mm.plugin.finder.utils.w.vXp;
                                FinderObjectDesc finderObjectDesc2 = this.tEM.feedObject.getFeedObject().objectDesc;
                                if (finderObjectDesc2 != null) {
                                    azr = finderObjectDesc2.feedBgmInfo;
                                }
                                com.tencent.mm.plugin.finder.utils.w.a(azr, Long.valueOf(this.tEM.feedObject.field_id), this.tSt.dLS);
                            } else if (this.tSt.gte instanceof FinderTopicTimelineUI) {
                                MMActivity mMActivity = this.tSt.gte;
                                if (mMActivity == null) {
                                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                                    AppMethodBeat.o(165876);
                                    throw tVar;
                                }
                                ((FinderTopicTimelineUI) mMActivity).onBackPressed();
                            }
                            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                            com.tencent.mm.plugin.finder.report.k.a(this.tSt.gte, 1, 1, Integer.valueOf(this.tEM.feedObject.field_finderObject.follow_feed_count));
                            AppMethodBeat.o(165876);
                            return;
                        }
                    } else if (this.tEM.feedObject.isPostFinish()) {
                        FinderReporterUIC.a aVar12 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH4 = FinderReporterUIC.a.fH(this.tSt.gte);
                        if (fH4 != null) {
                            i3 = fH4.tCE;
                        }
                        if (i3 != 52) {
                            e.a aVar13 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                            e.a.n(this.tEM.feedObject);
                            com.tencent.mm.plugin.finder.utils.w wVar2 = com.tencent.mm.plugin.finder.utils.w.vXp;
                            FinderObjectDesc finderObjectDesc3 = this.tEM.feedObject.getFeedObject().objectDesc;
                            if (finderObjectDesc3 != null) {
                                azr2 = finderObjectDesc3.feedBgmInfo;
                            }
                            com.tencent.mm.plugin.finder.utils.w.a(azr2, Long.valueOf(this.tEM.feedObject.field_id), this.tSt.dLS);
                        } else if (this.tSt.gte instanceof FinderTopicTimelineUI) {
                            MMActivity mMActivity2 = this.tSt.gte;
                            if (mMActivity2 == null) {
                                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                                AppMethodBeat.o(165876);
                                throw tVar2;
                            }
                            ((FinderTopicTimelineUI) mMActivity2).onBackPressed();
                        }
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.report.k.a(this.tSt.gte, 1, 1, Integer.valueOf(this.tEM.feedObject.field_finderObject.follow_feed_count));
                        AppMethodBeat.o(165876);
                        return;
                    }
                }
            } else if (this.tEM.feedObject.isPostFinish()) {
                if (!this.tEM.feedObject.getLongVideoMediaList().isEmpty()) {
                    objArr = 1;
                } else {
                    objArr = null;
                }
                com.tencent.mm.ui.base.h.a(this.tSt.gte, objArr != null ? R.string.cjq : R.string.d6h, 0, new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass2 */
                    final /* synthetic */ n tSI;

                    {
                        this.tSI = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(178269);
                        String aUg = com.tencent.mm.model.z.aUg();
                        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                        final av avVar = new av(aUg, this.tSI.tEM.feedObject.getFeedObject());
                        Dialog dialog = this.tSI.tSt.tipDialog;
                        if (dialog != null) {
                            dialog.show();
                        } else {
                            at atVar = this.tSI.tSt;
                            atVar.gte.getString(R.string.zb);
                            atVar.tipDialog = com.tencent.mm.ui.base.h.a((Context) atVar.gte, atVar.gte.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.tSK);
                        }
                        com.tencent.mm.kernel.g.azz().a(avVar.getType(), new com.tencent.mm.ak.i(this) {
                            /* class com.tencent.mm.plugin.finder.feed.at.n.AnonymousClass2.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass2 tSL;

                            {
                                this.tSL = r1;
                            }

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                                AppMethodBeat.i(178268);
                                if ((qVar instanceof av) && ((av) qVar).hFK == avVar.hFK) {
                                    com.tencent.mm.kernel.g.azz().b(avVar.getType(), this);
                                }
                                Dialog dialog = this.tSL.tSI.tSt.tipDialog;
                                if (dialog != null) {
                                    dialog.dismiss();
                                }
                                if (!(i2 == 0 && i3 == 0)) {
                                    com.tencent.mm.ui.base.u.makeText(this.tSL.tSI.tSt.gte, (int) R.string.d6k, 0).show();
                                }
                                AppMethodBeat.o(178268);
                            }
                        });
                        com.tencent.mm.kernel.g.azz().b(avVar);
                        AppMethodBeat.o(178269);
                    }

                    /* renamed from: com.tencent.mm.plugin.finder.feed.at$n$2$a */
                    static final class a implements DialogInterface.OnCancelListener {
                        public static final a tSK = new a();

                        static {
                            AppMethodBeat.i(178267);
                            AppMethodBeat.o(178267);
                        }

                        a() {
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(165876);
                return;
            }
            AppMethodBeat.o(165876);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final o.g j(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(165917);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        n nVar = new n(this, baseFinderFeed);
        AppMethodBeat.o(165917);
        return nVar;
    }

    static final class s<T> implements Observer<h.a> {
        final /* synthetic */ at tSt;

        s(at atVar) {
            this.tSt = atVar;
        }

        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            AppMethodBeat.i(244363);
            if (at.b(this.tSt)) {
                FinderHomeTabFragment finderHomeTabFragment = this.tSt.tRb;
                if (finderHomeTabFragment != null) {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    ((FinderActionBarOverlayUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderActionBarOverlayUIC.class)).dHW();
                    AppMethodBeat.o(244363);
                    return;
                }
                AppMethodBeat.o(244363);
                return;
            }
            com.tencent.mm.view.recyclerview.g d2 = at.d(this.tSt);
            if (d2 != null) {
                d2.Or((long) this.tSt.tSf.hashCode());
                AppMethodBeat.o(244363);
                return;
            }
            AppMethodBeat.o(244363);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<FinderWhatsNewView> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ae(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderWhatsNewView invoke() {
            AppMethodBeat.i(165896);
            FinderWhatsNewView finderWhatsNewView = (FinderWhatsNewView) this.tSt.gte.findViewById(R.id.d46);
            AppMethodBeat.o(165896);
            return finderWhatsNewView;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void b(BaseFinderFeed baseFinderFeed, boolean z2) {
        String str;
        int i2;
        String str2;
        int i3;
        String username;
        String username2;
        AppMethodBeat.i(165918);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
        com.tencent.mm.plugin.finder.model.ag agVar = com.tencent.mm.plugin.finder.model.ag.uOs;
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar == null || (username2 = gVar.getUsername()) == null) {
            str = "";
        } else {
            str = username2;
        }
        if (z2) {
            bb.a aVar2 = bb.tve;
            i2 = bb.tvb;
        } else {
            bb.a aVar3 = bb.tve;
            i2 = bb.tvc;
        }
        com.tencent.mm.kernel.g.azz().b(com.tencent.mm.plugin.finder.model.ag.a(dIx, str, i2));
        c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g gVar2 = baseFinderFeed.contact;
        if (gVar2 == null || (username = gVar2.getUsername()) == null) {
            str2 = "";
        } else {
            str2 = username;
        }
        if (z2) {
            g.a aVar5 = com.tencent.mm.plugin.finder.api.g.tsD;
            i3 = com.tencent.mm.plugin.finder.api.g.tsB;
        } else {
            g.a aVar6 = com.tencent.mm.plugin.finder.api.g.tsD;
            i3 = com.tencent.mm.plugin.finder.api.g.tsC;
        }
        c.a.du(str2, i3);
        AppMethodBeat.o(165918);
    }

    public static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $reason;
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(at atVar, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.tSt = atVar;
            this.$reason = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RefreshLoadMoreLayout dcQ;
            AppMethodBeat.i(165893);
            ai.b bVar = this.tSt.tRV;
            if (!(bVar == null || (dcQ = bVar.dcQ()) == null)) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                dcQ.postDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.feed.at.x.AnonymousClass1 */
                    final /* synthetic */ x tSO;

                    {
                        this.tSO = r1;
                    }

                    public final void run() {
                        RefreshLoadMoreLayout dcQ;
                        AppMethodBeat.i(165892);
                        ai.b bVar = this.tSO.tSt.tRV;
                        if (!(bVar == null || (dcQ = bVar.dcQ()) == null)) {
                            RefreshLoadMoreLayout.b(dcQ);
                        }
                        this.tSO.tSt.onRefreshEnd(this.tSO.$reason);
                        AppMethodBeat.o(165892);
                    }
                }, com.tencent.mm.plugin.finder.storage.c.dsb());
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165893);
            return xVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ab, code lost:
        if (r0 == com.tencent.mm.plugin.finder.event.a.C1104a.tHq) goto L_0x00ad;
     */
    @Override // com.tencent.mm.plugin.finder.event.base.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.finder.event.base.b r8) {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.at.a(com.tencent.mm.plugin.finder.event.base.b):void");
    }

    public static final class y extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(165894);
            at.a(this.tSt, 160L, true);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165894);
            return xVar;
        }
    }

    private void ddb() {
        RefreshLoadMoreLayout dcQ;
        AppMethodBeat.i(244394);
        if (!this.tSn) {
            ai.b bVar = this.tRV;
            if (!(bVar == null || (dcQ = bVar.dcQ()) == null)) {
                dcQ.DE(true);
            }
            this.tSn = true;
        }
        AppMethodBeat.o(244394);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(165920);
        kotlin.g.b.p.h(cVar, "dispatcher");
        kotlin.g.b.p.h(bVar, "event");
        if (bVar instanceof com.tencent.mm.plugin.finder.event.base.h) {
            if (((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 5) {
                AppMethodBeat.o(165920);
                return true;
            }
            AppMethodBeat.o(165920);
            return false;
        } else if (bVar instanceof a.C1104a) {
            int i2 = ((a.C1104a) bVar).type;
            a.C1104a.C1105a aVar = a.C1104a.tHJ;
            if (i2 != a.C1104a.tHp) {
                int i3 = ((a.C1104a) bVar).type;
                a.C1104a.C1105a aVar2 = a.C1104a.tHJ;
                if (i3 != a.C1104a.tHq) {
                    AppMethodBeat.o(165920);
                    return false;
                }
            }
            AppMethodBeat.o(165920);
            return true;
        } else {
            AppMethodBeat.o(165920);
            return false;
        }
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(165921);
        kotlin.g.b.p.h(aVar, "p0");
        this.tLP.add(aVar);
        AppMethodBeat.o(165921);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(FinderItem finderItem, FinderCommentInfo finderCommentInfo) {
        AppMethodBeat.i(165922);
        kotlin.g.b.p.h(finderItem, "feed");
        kotlin.g.b.p.h(finderCommentInfo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        AppMethodBeat.o(165922);
    }

    public static final class j extends IListener<hk> {
        final /* synthetic */ at tSt;

        j(at atVar) {
            this.tSt = atVar;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hk hkVar) {
            AppMethodBeat.i(165869);
            hk hkVar2 = hkVar;
            kotlin.g.b.p.h(hkVar2, "event");
            this.tSt.tRo.updateProgressByLocalId(hkVar2.dLT.localId);
            AppMethodBeat.o(165869);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final MMActivity getActivity() {
        return this.gte;
    }

    public static final class v extends RecyclerView.l {
        final /* synthetic */ at tSt;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(244367);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(244367);
        }

        v(at atVar) {
            this.tSt = atVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(244366);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            switch (this.tSt.dLS) {
                case 1:
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(244366);
        }
    }

    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $r;
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(at atVar, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.tSt = atVar;
            this.$r = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RefreshLoadMoreLayout.c cVar;
            int i2;
            boolean z;
            RefreshLoadMoreLayout dcQ;
            RefreshLoadMoreLayout dcQ2;
            RecyclerView recyclerView;
            boolean z2 = false;
            AppMethodBeat.i(165866);
            RefreshLoadMoreLayout.c cVar2 = this.$r;
            if (cVar2 == null) {
                RefreshLoadMoreLayout.c cVar3 = new RefreshLoadMoreLayout.c(0);
                Context context = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                cVar3.Rmi = context.getResources().getString(R.string.daa);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            ai.b bVar = this.tSt.tRV;
            RecyclerView.a adapter = (bVar == null || (recyclerView = bVar.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            at atVar = this.tSt;
            if (wxRecyclerAdapter != null) {
                i2 = wxRecyclerAdapter.hgt();
            } else {
                i2 = 0;
            }
            if (i2 <= 0) {
                z = true;
            } else {
                z = false;
            }
            atVar.tSc = z;
            Log.i(this.tSt.TAG, "[checkEmptyHeader] isEmpty=" + this.tSt.tSc + " reason=" + cVar);
            if (this.tSt.tSc) {
                ai.b bVar2 = this.tSt.tRV;
                if (!(bVar2 == null || (dcQ = bVar2.dcQ()) == null)) {
                    dcQ.setEnableLoadMore(false);
                }
                if (this.tSt.tSh instanceof com.tencent.mm.plugin.finder.model.g) {
                    g.b bVar3 = this.tSt.tSh;
                    if (bVar3 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FeedHeaderEmptyData");
                        AppMethodBeat.o(165866);
                        throw tVar;
                    }
                    Context context2 = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                    String string = context2.getResources().getString(R.string.d3g);
                    kotlin.g.b.p.g(string, "MMApplicationContext.get…g.finder_no_more_content)");
                    ((com.tencent.mm.plugin.finder.model.g) bVar3).P(string);
                    g.b bVar4 = this.tSt.tSh;
                    if (bVar4 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FeedHeaderEmptyData");
                        AppMethodBeat.o(165866);
                        throw tVar2;
                    }
                    ((com.tencent.mm.plugin.finder.model.g) bVar4).type = cVar.Rmh;
                    g.b bVar5 = this.tSt.tSh;
                    if (bVar5 == null) {
                        kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FeedHeaderEmptyData");
                        AppMethodBeat.o(165866);
                        throw tVar3;
                    }
                    ((com.tencent.mm.plugin.finder.model.g) bVar5).dLS = this.tSt.dLS;
                }
                if (wxRecyclerAdapter != null && !wxRecyclerAdapter.a(this.tSt.tSh)) {
                    wxRecyclerAdapter.a(this.tSt.tSh, false);
                } else if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.Or(this.tSt.tSh.lT());
                }
            } else if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.T(this.tSt.tSh.lT(), false);
            }
            ai.b bVar6 = this.tSt.tRV;
            if (!(bVar6 == null || (dcQ2 = bVar6.dcQ()) == null)) {
                if (cVar.Rmh != -1 || !this.tSt.tSc) {
                    z2 = true;
                }
                dcQ2.setEnableNestedScroll(z2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165866);
            return xVar;
        }
    }

    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ RefreshLoadMoreLayout.c tSA;
        final /* synthetic */ WxRecyclerAdapter tSB;
        final /* synthetic */ boolean tSC;
        final /* synthetic */ at tSt;
        final /* synthetic */ boolean tSz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(at atVar, boolean z, RefreshLoadMoreLayout.c cVar, WxRecyclerAdapter wxRecyclerAdapter, boolean z2) {
            super(0);
            this.tSt = atVar;
            this.tSz = z;
            this.tSA = cVar;
            this.tSB = wxRecyclerAdapter;
            this.tSC = z2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RefreshLoadMoreLayout dcQ;
            AppMethodBeat.i(244349);
            if (this.tSB != null) {
                if (!this.tSB.b(this.tSt.tSi)) {
                    com.tencent.mm.view.recyclerview.g.b(this.tSB, this.tSt.tSi);
                }
                String str = this.tSt.TAG;
                StringBuilder sb = new StringBuilder("[checkNoMoreFooter] EMPTY_FOOTER_IGNORE_CHECK=");
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                Log.i(str, sb.append(com.tencent.mm.plugin.finder.storage.c.dsd()).toString());
                ai.b bVar = this.tSt.tRV;
                if (!(bVar == null || (dcQ = bVar.dcQ()) == null)) {
                    dcQ.setEnableLoadMore(false);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(244349);
            return xVar;
        }
    }

    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ List tSW;
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(at atVar, List list) {
            super(0);
            this.tSt = atVar;
            this.tSW = list;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(244374);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.gS(this.tSt.cND(), "StartCgi");
            i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            int i2 = this.tSt.dLS;
            MMActivity mMActivity = this.tSt.gte;
            kotlin.g.b.p.h(mMActivity, "context");
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(mMActivity);
            if (fH != null) {
                bbn dIx = fH.dIx();
                int i3 = fH.wtW;
                switch (i2) {
                    case 1:
                        i.a aVar3 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                        i.a.a(2, dIx, i3, false);
                        break;
                    case 3:
                        i.a aVar4 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                        i.a.b(2, dIx, i3, false);
                        break;
                    case 4:
                        i.a aVar5 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                        i.a.c(2, dIx, i3, false);
                        break;
                }
            }
            this.tSt.tRo.dX(this.tSW);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(244374);
            return xVar;
        }
    }

    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(165878);
            this.tSt.tRo.requestLoadMore();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165878);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(244361);
            Boolean valueOf = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.tSt.dLS, 0, 2));
            AppMethodBeat.o(244361);
            return valueOf;
        }
    }

    public static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ at tSt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(at atVar) {
            super(0);
            this.tSt = atVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            boolean z = false;
            AppMethodBeat.i(244373);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            int i3 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            int i4 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            int i5 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            final int i6 = i2 + i3 + i4 + i5 + aAh5.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            Object obj = aAh6.azQ().get(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, "");
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(244373);
                throw tVar;
            }
            final String str = (String) obj;
            if (this.tSt.msgNotifyData.count != i6 || (!kotlin.g.b.p.j(this.tSt.msgNotifyData.uNR, str))) {
                z = true;
            }
            Log.i(this.tSt.TAG, "isNeedRefresh=" + z + " refreshMsgNotify commentCnt " + i2 + ", likeCnt " + i3 + " objectLikeLikeCnt " + i4 + " objectRecommendLikeCnt " + i5 + " tabType " + this.tSt.dLS);
            if (z) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.at.ab.AnonymousClass1 */
                    final /* synthetic */ ab tSQ;

                    {
                        this.tSQ = r2;
                    }

                    /* access modifiers changed from: package-private */
                    /* renamed from: com.tencent.mm.plugin.finder.feed.at$ab$1$a */
                    public static final class a implements Runnable {
                        final /* synthetic */ RecyclerView tST;
                        final /* synthetic */ AnonymousClass1 tSU;

                        a(RecyclerView recyclerView, AnonymousClass1 r2) {
                            this.tST = recyclerView;
                            this.tSU = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(244371);
                            Log.i(this.tSU.tSQ.tSt.TAG, "notifyChanged,msgNotifyData");
                            if (at.b(this.tSU.tSQ.tSt)) {
                                FinderHomeTabFragment finderHomeTabFragment = this.tSU.tSQ.tSt.tRb;
                                if (finderHomeTabFragment != null) {
                                    this.tSU.tSQ.tSt.msgNotifyData.count = i6;
                                    this.tSU.tSQ.tSt.msgNotifyData.setAvatar(str);
                                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                    ((FinderActionBarOverlayUIC) com.tencent.mm.ui.component.a.of(finderHomeTabFragment).get(FinderActionBarOverlayUIC.class)).dHW();
                                    AppMethodBeat.o(244371);
                                    return;
                                }
                                AppMethodBeat.o(244371);
                                return;
                            }
                            at atVar = this.tSU.tSQ.tSt;
                            RecyclerView recyclerView = this.tST;
                            com.tencent.mm.plugin.finder.model.h unused = this.tSU.tSQ.tSt.msgNotifyData;
                            at.a(atVar, recyclerView, new kotlin.g.a.a<kotlin.x>(this) {
                                /* class com.tencent.mm.plugin.finder.feed.at.ab.AnonymousClass1.a.AnonymousClass1 */
                                final /* synthetic */ a tSV;

                                {
                                    this.tSV = r2;
                                }

                                @Override // kotlin.g.a.a
                                public final /* synthetic */ kotlin.x invoke() {
                                    AppMethodBeat.i(244370);
                                    this.tSV.tSU.tSQ.tSt.msgNotifyData.count = i6;
                                    this.tSV.tSU.tSQ.tSt.msgNotifyData.setAvatar(str);
                                    kotlin.x xVar = kotlin.x.SXb;
                                    AppMethodBeat.o(244370);
                                    return xVar;
                                }
                            });
                            AppMethodBeat.o(244371);
                        }
                    }

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        RecyclerView recyclerView;
                        AppMethodBeat.i(244372);
                        ai.b bVar = this.tSQ.tSt.tRV;
                        if (!(bVar == null || (recyclerView = bVar.getRecyclerView()) == null)) {
                            recyclerView.post(new a(recyclerView, this));
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(244372);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(244373);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.finder.feed.ai.a
    public final void onUserVisibleUnFocused() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        AppMethodBeat.i(244391);
        switch (this.dLS) {
            case 1:
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                ai.b bVar = this.tRV;
                com.tencent.mm.plugin.finder.report.live.k.b(bVar != null ? bVar.getRecyclerView() : null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
                ai.b bVar2 = this.tRV;
                if (bVar2 == null || (recyclerView2 = bVar2.getRecyclerView()) == null) {
                    AppMethodBeat.o(244391);
                    return;
                }
                recyclerView2.b(this.tSq);
                AppMethodBeat.o(244391);
                return;
            case 4:
                ai.b bVar3 = this.tRV;
                if (!(bVar3 == null || (recyclerView = bVar3.getRecyclerView()) == null)) {
                    recyclerView.b(this.tSq);
                    AppMethodBeat.o(244391);
                    return;
                }
        }
        AppMethodBeat.o(244391);
    }

    public static final /* synthetic */ void a(at atVar, RecyclerView recyclerView, kotlin.g.a.a aVar) {
        AppMethodBeat.i(244397);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(244397);
            throw tVar;
        }
        RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(512, false);
        Integer valueOf = vVar != null ? Integer.valueOf(vVar.lR()) : null;
        Log.i(atVar.TAG, "notifyChanged,pos = " + valueOf + ", isInLayout=" + recyclerView.isInLayout());
        if (valueOf != null) {
            valueOf.intValue();
            aVar.invoke();
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.ci(valueOf.intValue());
                AppMethodBeat.o(244397);
                return;
            }
            AppMethodBeat.o(244397);
            return;
        }
        AppMethodBeat.o(244397);
    }

    public static final /* synthetic */ boolean n(BaseFinderFeed baseFinderFeed) {
        String str;
        AppMethodBeat.i(165927);
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar != null) {
            str = gVar.field_username;
        } else {
            str = null;
        }
        boolean I = kotlin.n.n.I(str, com.tencent.mm.model.z.aUg(), false);
        AppMethodBeat.o(165927);
        return I;
    }

    public static final /* synthetic */ void b(at atVar, RefreshLoadMoreLayout.c cVar) {
        AppMethodBeat.i(244398);
        if (atVar.dLS == 3 && cVar.Rmk <= 0) {
            E e2 = cVar.iMa;
            if (!(e2 instanceof com.tencent.mm.plugin.finder.feed.model.internal.k)) {
                e2 = null;
            }
            E e3 = e2;
            if (e3 == null) {
                AppMethodBeat.o(244398);
                return;
            } else if (e3.tYG) {
                Log.i(atVar.TAG, "[checkDataReplace] data replace true");
                cVar.Rmk++;
            }
        }
        AppMethodBeat.o(244398);
    }
}
