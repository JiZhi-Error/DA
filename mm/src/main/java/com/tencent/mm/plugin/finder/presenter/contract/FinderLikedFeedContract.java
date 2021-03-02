package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract;", "", "()V", "isOtherEnableFullScreenEnjoy", "", "()Z", "isOtherEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "LikedTimelinePresenter", "LikedTimelineViewCallback", "plugin-finder_release"})
public final class FinderLikedFeedContract {
    private static final f uXa = g.ah(FinderLikedFeedContract$isOtherEnableFullScreenEnjoy$2.uXp);
    public static final FinderLikedFeedContract uXb = new FinderLikedFeedContract();

    static {
        AppMethodBeat.i(166532);
        AppMethodBeat.o(166532);
    }

    private FinderLikedFeedContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\tH\u0016J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010F\u001a\u00020*H\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010I\u001a\u000205H\u0016J\b\u0010J\u001a\u00020<H\u0002J\b\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020L2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\u0005H\u0016J\u0006\u0010P\u001a\u00020<J\u0010\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u0002H\u0016J\b\u0010S\u001a\u00020<H\u0016J\"\u0010T\u001a\u00020<2\u0006\u0010A\u001a\u00020U2\u0006\u0010V\u001a\u00020L2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0018\u0010Y\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010Z\u001a\u00020LH\u0016J \u0010[\u001a\u00020<2\u0006\u0010A\u001a\u00020U2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020LH\u0016J0\u0010_\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010^\u001a\u00020L2\u0006\u0010`\u001a\u00020L2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020LH\u0016J\u0006\u0010c\u001a\u00020<J\u0010\u0010d\u001a\u00020<2\u0006\u0010A\u001a\u00020UH\u0016J\u0010\u0010e\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001a\u0010/\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPool$delegate", "Lkotlin/Lazy;", "unLikeCount", "getUnLikeCount", "()I", "setUnLikeCount", "(I)V", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "initVideoAbout", "isFinderSelfScene", "", "isSelf", "keep", "p0", "loadInitData", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
    public static final class LikedTimelinePresenter implements i, a<LikedTimelineViewCallback>, b<com.tencent.mm.vending.e.a> {
        private final String TAG;
        final MMActivity gte;
        private final int pLU;
        private final int pMa;
        private final k tCD;
        private final int tLE;
        private final int tLF;
        private final int tLG;
        private final int tLH;
        private final int tLJ;
        private final int tLK;
        private final int tLL;
        private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
        private final e tLT;
        private final d tLy;
        private final com.tencent.mm.plugin.finder.feed.model.f tLz;
        private final int tqv;
        public final FinderLikedFeedLoader uXc;
        private final f uXd;
        private int uXe;
        private LikedTimelineViewCallback uXf;
        private final FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1 uXg;

        public LikedTimelinePresenter(MMActivity mMActivity, e eVar) {
            p.h(mMActivity, "context");
            p.h(eVar, "drawer");
            AppMethodBeat.i(249794);
            this.gte = mMActivity;
            this.tLT = eVar;
            com.tencent.mm.plugin.finder.feed.model.internal.e eVar2 = com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_LIKED_TIMELINE;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderLikedFeedLoader finderLikedFeedLoader = new FinderLikedFeedLoader(true, eVar2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx());
            Intent intent = this.gte.getIntent();
            p.g(intent, "context.intent");
            finderLikedFeedLoader.initFromCache(intent);
            finderLikedFeedLoader.setInitDone(new FinderLikedFeedContract$LikedTimelinePresenter$$special$$inlined$apply$lambda$1(finderLikedFeedLoader, this));
            finderLikedFeedLoader.tTS = new FinderLikedFeedContract$LikedTimelinePresenter$$special$$inlined$apply$lambda$2(this);
            this.uXc = finderLikedFeedLoader;
            this.uXd = g.ah(FinderLikedFeedContract$LikedTimelinePresenter$mediaBannerViewPool$2.uXk);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            this.tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderCommentPreloaderUIC.class)).tLy;
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            this.tLz = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            this.tqv = 101;
            this.pLU = 102;
            this.tLE = 103;
            this.tLF = 104;
            this.tLG = 106;
            this.tLH = 107;
            this.pMa = 108;
            this.tLJ = 109;
            this.tLK = 110;
            this.tLL = 111;
            this.TAG = "Finder.FinderLikedFeedContract.LikedTimelinePresenter";
            this.tCD = new k();
            this.uXg = new FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1(this);
            AppMethodBeat.o(249794);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(LikedTimelineViewCallback likedTimelineViewCallback) {
            AppMethodBeat.i(166513);
            a(likedTimelineViewCallback);
            AppMethodBeat.o(166513);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final MMActivity getActivity() {
            AppMethodBeat.i(166505);
            MMActivity mMActivity = this.gte;
            AppMethodBeat.o(166505);
            return mMActivity;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final boolean dbZ() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.f a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
            AppMethodBeat.i(166506);
            p.h(baseFinderFeed, "feed");
            p.h(eVar, "sheet");
            FinderLikedFeedContract$LikedTimelinePresenter$getCreateMoreMenuListener$1 finderLikedFeedContract$LikedTimelinePresenter$getCreateMoreMenuListener$1 = new FinderLikedFeedContract$LikedTimelinePresenter$getCreateMoreMenuListener$1(this, baseFinderFeed);
            AppMethodBeat.o(166506);
            return finderLikedFeedContract$LikedTimelinePresenter$getCreateMoreMenuListener$1;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final e dcg() {
            return this.tLT;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final k getVideoCore() {
            return this.tCD;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.f i(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(166507);
            p.h(baseFinderFeed, "feed");
            FinderLikedFeedContract$LikedTimelinePresenter$getCreateSecondMoreMenuListener$1 finderLikedFeedContract$LikedTimelinePresenter$getCreateSecondMoreMenuListener$1 = new FinderLikedFeedContract$LikedTimelinePresenter$getCreateSecondMoreMenuListener$1(this, baseFinderFeed);
            AppMethodBeat.o(166507);
            return finderLikedFeedContract$LikedTimelinePresenter$getCreateSecondMoreMenuListener$1;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.g j(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(166508);
            p.h(baseFinderFeed, "feed");
            FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 finderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 = new FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1(this, baseFinderFeed);
            AppMethodBeat.o(166508);
            return finderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem, boolean z, h hVar) {
            AppMethodBeat.i(249790);
            p.h(finderItem, "feed");
            r rVar = r.uNW;
            r.a(this.gte, finderItem, z);
            AppMethodBeat.o(249790);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem) {
            AppMethodBeat.i(249791);
            p.h(finderItem, "feed");
            s.a aVar = s.vWt;
            LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
            if (likedTimelineViewCallback == null) {
                p.hyc();
            }
            s.a.a(aVar, likedTimelineViewCallback.gte, finderItem, 0, 12);
            AppMethodBeat.o(249791);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void k(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(249792);
            p.h(baseFinderFeed, "feed");
            s.a aVar = s.vWt;
            LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
            if (likedTimelineViewCallback == null) {
                p.hyc();
            }
            s.a.a(likedTimelineViewCallback.gte, baseFinderFeed, 4, 0, 20);
            AppMethodBeat.o(249792);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(BaseFinderFeed baseFinderFeed, boolean z, boolean z2, int i2, boolean z3) {
            AppMethodBeat.i(249793);
            p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
            aj ajVar = aj.uOw;
            FinderItem finderItem = baseFinderFeed.feedObject;
            boolean z4 = baseFinderFeed.showLikeTips;
            y yVar = y.vXH;
            aj.a(dIx, i2, finderItem, z, z2, 2, z4, z3, y.i(baseFinderFeed.contact));
            if (z) {
                this.uXe--;
                AppMethodBeat.o(249793);
                return;
            }
            this.uXe++;
            AppMethodBeat.o(249793);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void b(BaseFinderFeed baseFinderFeed, boolean z) {
            String str;
            int i2;
            String str2;
            int i3;
            String username;
            String username2;
            AppMethodBeat.i(166510);
            p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
            ag agVar = ag.uOs;
            com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
            if (gVar == null || (username2 = gVar.getUsername()) == null) {
                str = "";
            } else {
                str = username2;
            }
            if (z) {
                bb.a aVar2 = bb.tve;
                i2 = bb.tvb;
            } else {
                bb.a aVar3 = bb.tve;
                i2 = bb.tvc;
            }
            com.tencent.mm.kernel.g.azz().b(ag.a(dIx, str, i2));
            c.a aVar4 = c.tsp;
            com.tencent.mm.plugin.finder.api.g gVar2 = baseFinderFeed.contact;
            if (gVar2 == null || (username = gVar2.getUsername()) == null) {
                str2 = "";
            } else {
                str2 = username;
            }
            if (z) {
                g.a aVar5 = com.tencent.mm.plugin.finder.api.g.tsD;
                i3 = com.tencent.mm.plugin.finder.api.g.tsB;
            } else {
                g.a aVar6 = com.tencent.mm.plugin.finder.api.g.tsD;
                i3 = com.tencent.mm.plugin.finder.api.g.tsC;
            }
            c.a.du(str2, i3);
            AppMethodBeat.o(166510);
        }

        public final void a(LikedTimelineViewCallback likedTimelineViewCallback) {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(166512);
            p.h(likedTimelineViewCallback, "callback");
            this.uXf = likedTimelineViewCallback;
            EventCenter.instance.addListener(this.uXg);
            k kVar = this.tCD;
            LikedTimelineViewCallback likedTimelineViewCallback2 = this.uXf;
            if (likedTimelineViewCallback2 == null) {
                p.hyc();
            }
            k.a(kVar, likedTimelineViewCallback2.gte, new FinderLikedFeedContract$LikedTimelinePresenter$initVideoAbout$1(this), 4);
            this.tLy.a(2, 2, new FinderLikedFeedContract$LikedTimelinePresenter$onAttach$1(this));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.a(this.tLy);
            }
            this.tLz.e(new FinderLikedFeedContract$LikedTimelinePresenter$onAttach$2(this));
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
                a2.a(this.tLz);
            }
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(likedTimelineViewCallback.getRecyclerView());
            AppMethodBeat.o(166512);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(166515);
            this.tLy.onDetach();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.b(this.tLy);
            }
            this.tLz.onDetach();
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
                a2.b(this.tLz);
            }
            com.tencent.mm.plugin.finder.storage.data.f.vGd.clearCache();
            Iterator<T> it = this.tLP.iterator();
            while (it.hasNext()) {
                it.next().dead();
            }
            this.tLP.clear();
            this.uXf = null;
            EventCenter.instance.removeListener(this.uXg);
            AppMethodBeat.o(166515);
        }

        @Override // com.tencent.mm.vending.e.b
        public final void keep(com.tencent.mm.vending.e.a aVar) {
            AppMethodBeat.i(166516);
            p.h(aVar, "p0");
            this.tLP.add(aVar);
            AppMethodBeat.o(166516);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem, FinderCommentInfo finderCommentInfo) {
            AppMethodBeat.i(166517);
            p.h(finderItem, "feed");
            p.h(finderCommentInfo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            AppMethodBeat.o(166517);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final RecyclerView.m dcf() {
            AppMethodBeat.i(166511);
            RecyclerView.m mVar = (RecyclerView.m) this.uXd.getValue();
            AppMethodBeat.o(166511);
            return mVar;
        }

        public static final /* synthetic */ boolean o(BaseFinderFeed baseFinderFeed) {
            String str;
            AppMethodBeat.i(166519);
            com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
            if (gVar != null) {
                str = gVar.field_username;
            } else {
                str = null;
            }
            boolean I = n.I(str, z.aUg(), false);
            AppMethodBeat.o(166519);
            return I;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;)V", "TAG", "", "context", "mEmptyView", "Landroid/view/View;", "getMEmptyView", "()Landroid/view/View;", "setMEmptyView", "(Landroid/view/View;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getActivity", "getEmptyView", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getRecyclerView", "initView", "", "onUIAttach", "onUIDestroy", "smoothScrollToNextPosition", "plugin-finder_release"})
    public static final class LikedTimelineViewCallback implements com.tencent.mm.plugin.finder.presenter.base.c<LikedTimelinePresenter> {
        public View GQ;
        private final String TAG = "Finder.FinderProfileContract.LikedTimelineViewCallback";
        public final MMActivity gte;
        public RecyclerView hak;
        public RefreshLoadMoreLayout tLS;
        public final LikedTimelinePresenter uXl;

        public LikedTimelineViewCallback(MMActivity mMActivity, LikedTimelinePresenter likedTimelinePresenter) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(likedTimelinePresenter, "presenter");
            AppMethodBeat.i(166530);
            this.uXl = likedTimelinePresenter;
            this.gte = mMActivity;
            AppMethodBeat.o(166530);
        }

        public static final /* synthetic */ RecyclerView d(LikedTimelineViewCallback likedTimelineViewCallback) {
            AppMethodBeat.i(166531);
            RecyclerView recyclerView = likedTimelineViewCallback.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            AppMethodBeat.o(166531);
            return recyclerView;
        }

        public static final /* synthetic */ BaseFinderFeedLoader e(LikedTimelineViewCallback likedTimelineViewCallback) {
            AppMethodBeat.i(249799);
            BaseFinderFeedLoader ddM = likedTimelineViewCallback.ddM();
            AppMethodBeat.o(249799);
            return ddM;
        }

        public final RefreshLoadMoreLayout getRlLayout() {
            AppMethodBeat.i(166527);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(166527);
            return refreshLoadMoreLayout;
        }

        public final BaseFinderFeedLoader ddM() {
            return this.uXl.uXc;
        }

        public final RecyclerView getRecyclerView() {
            AppMethodBeat.i(166529);
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            AppMethodBeat.o(166529);
            return recyclerView;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        public static final /* synthetic */ void a(LikedTimelineViewCallback likedTimelineViewCallback, RecyclerView recyclerView) {
            AppMethodBeat.i(249798);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                AppMethodBeat.o(249798);
                throw tVar;
            }
            int ks = ((FinderLinearLayoutManager) layoutManager).ks() + 1;
            Log.i(likedTimelineViewCallback.TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(ks)));
            recyclerView.post(new FinderLikedFeedContract$LikedTimelineViewCallback$smoothScrollToNextPosition$1(recyclerView, ks));
            AppMethodBeat.o(249798);
        }
    }

    public static final /* synthetic */ boolean dlU() {
        AppMethodBeat.i(249802);
        boolean booleanValue = ((Boolean) uXa.getValue()).booleanValue();
        AppMethodBeat.o(249802);
        return booleanValue;
    }
}
