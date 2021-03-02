package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class b {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007*\u00011\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010B\u001a\u00020CH&J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J \u0010K\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\nH\u0017J\b\u0010O\u001a\u00020\bH\u0016J\b\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020S2\u0006\u0010F\u001a\u00020G2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020S2\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010N\u001a\u00020\nH&J\b\u0010Y\u001a\u000206H\u0016J\b\u0010Z\u001a\u000206H\u0016J\u0010\u0010[\u001a\u00020\\2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010]\u001a\u00020<H\u0016J\b\u0010^\u001a\u00020_H\u0016J\u000e\u0010`\u001a\b\u0012\u0004\u0012\u00020X0aH&J\b\u0010b\u001a\u00020EH\u0002J\b\u0010c\u001a\u00020EH&J\b\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020eH\u0016J\u0012\u0010g\u001a\u00020E2\b\u0010h\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010i\u001a\u00020EH&J\u0010\u0010j\u001a\u00020E2\u0006\u0010k\u001a\u00020\u0002H\u0016J\b\u0010l\u001a\u00020EH\u0016J\b\u0010m\u001a\u00020EH\u0016J\"\u0010n\u001a\u00020E2\u0006\u0010F\u001a\u00020o2\u0006\u0010p\u001a\u00020e2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0018\u0010s\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010t\u001a\u00020eH\u0016J \u0010u\u001a\u00020E2\u0006\u0010F\u001a\u00020o2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020eH\u0016J0\u0010y\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010x\u001a\u00020e2\u0006\u0010z\u001a\u00020e2\u0006\u0010{\u001a\u00020\n2\u0006\u0010|\u001a\u00020eH\u0016J\u0017\u0010}\u001a\u00020E2\r\u0010~\u001a\t\u0012\u0005\u0012\u00030\u00010H\u0016J\t\u0010\u0001\u001a\u00020EH\u0016J\t\u0010\u0001\u001a\u00020EH\u0016J\t\u0010\u0001\u001a\u00020EH\u0016J\t\u0010\u0001\u001a\u00020EH&J\u0011\u0010\u0001\u001a\u00020E2\u0006\u0010F\u001a\u00020oH\u0016J\u0011\u0010\u0001\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016R\u0014\u0010\f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u0014\u0010\u001f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0014\u0010!\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000eR\u0014\u0010#\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000eR\u0014\u0010%\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u0014\u0010'\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u0014\u0010)\u001a\u00020*XD¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u000201X\u0004¢\u0006\u0004\n\u0002\u00102R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000504X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "getMENU_ID_CANCEL_FAV_TO_FINDER", "()I", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "getMENU_ID_FAV_TO_FINDER", "MENU_ID_FOLLOW_PAT", "getMENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "getMENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "tabType", "getTabType", "setTabType", "(I)V", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "createSecondMenu", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isEnableFullScreenEnjoyByScene", "", "isFinderSelfScene", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
    public static abstract class a implements ab.a, i, com.tencent.mm.plugin.finder.presenter.base.a<AbstractC1134b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
        private final String TAG;
        public int dLS;
        public final MMActivity gte;
        final int pLU;
        final int pMa;
        public final k tCD;
        public final int tCE;
        final int tLD;
        private final int tLE;
        private final int tLF;
        final int tLG;
        final int tLH;
        final int tLI;
        final int tLJ;
        final int tLK;
        final int tLL;
        final int tLM;
        public AbstractC1134b tLN;
        private RecyclerView.m tLO;
        private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
        private final f tLQ;
        final int tqv;
        private final int tzW;

        public abstract bo IE(int i2);

        public abstract void boE();

        public abstract void dcb();

        public abstract DataBuffer<bo> dcc();

        public abstract com.tencent.mm.view.recyclerview.f dce();

        public abstract void requestRefresh();

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.b$a$a  reason: collision with other inner class name */
        public static final class C1132a extends q implements kotlin.g.a.b<Integer, LinkedList<Long>> {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tLR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1132a(a aVar, BaseFinderFeed baseFinderFeed) {
                super(1);
                this.tLR = aVar;
                this.tEM = baseFinderFeed;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ LinkedList<Long> invoke(Integer num) {
                String str;
                String str2;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(178220);
                int intValue = num.intValue();
                LinkedList linkedList = new LinkedList();
                ArrayList<bo> dcH = this.tLR.dcH();
                if (dcH == null) {
                    p.hyc();
                }
                Iterator<bo> it = dcH.iterator();
                p.g(it, "getFeedList()!!.iterator()");
                int i2 = 0;
                while (it.hasNext()) {
                    bo next = it.next();
                    p.g(next, "iterator.next()");
                    bo boVar = next;
                    if (boVar instanceof BaseFinderFeed) {
                        com.tencent.mm.plugin.finder.api.g gVar = ((BaseFinderFeed) boVar).contact;
                        if (gVar != null) {
                            str = gVar.field_username;
                        } else {
                            str = null;
                        }
                        com.tencent.mm.plugin.finder.api.g gVar2 = this.tEM.contact;
                        if (gVar2 != null) {
                            str2 = gVar2.field_username;
                        } else {
                            str2 = null;
                        }
                        if (p.j(str, str2)) {
                            it.remove();
                            linkedList.add(Long.valueOf(((BaseFinderFeed) boVar).feedObject.m21getCreateTime()));
                            AbstractC1134b bVar = this.tLR.tLN;
                            if (!(bVar == null || (adapter = bVar.getAdapter()) == null)) {
                                adapter.ck(i2);
                            }
                            Log.i(this.tLR.getTAG(), "[UNINTEREST] removeAt " + i2 + " subType=" + intValue);
                        }
                    }
                    i2++;
                }
                AppMethodBeat.o(178220);
                return linkedList;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ a(com.tencent.mm.ui.MMActivity r2) {
            /*
                r1 = this;
                com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC$a r0 = com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.wzC
                r0 = r2
                android.content.Context r0 = (android.content.Context) r0
                com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC r0 = com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a.fH(r0)
                if (r0 == 0) goto L_0x0011
                int r0 = r0.tCE
            L_0x000d:
                r1.<init>(r2, r0)
                return
            L_0x0011:
                r0 = 0
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.b.a.<init>(com.tencent.mm.ui.MMActivity):void");
        }

        private a(MMActivity mMActivity, int i2) {
            p.h(mMActivity, "context");
            this.gte = mMActivity;
            this.tCE = i2;
            this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
            this.tLD = 99;
            this.tzW = 100;
            this.pMa = 101;
            this.tqv = 102;
            this.pLU = 103;
            this.tLE = 104;
            this.tLF = 105;
            this.tLG = 106;
            this.tLH = 107;
            this.tLI = 108;
            this.tLJ = 109;
            this.tLK = 110;
            this.tLL = 111;
            this.tLM = 112;
            this.tLP = new CopyOnWriteArraySet<>();
            this.tLO = new RecyclerView.m();
            this.tLO.aw(1, 10);
            this.tLO.aw(2, 10);
            this.tCD = new k();
            this.tLQ = new f(this);
        }

        public String getTAG() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public boolean dbZ() {
            return false;
        }

        public boolean dca() {
            y yVar = y.vXH;
            return y.gr(this.dLS, this.tCE);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final MMActivity getActivity() {
            return this.gte;
        }

        /* renamed from: a */
        public void onAttach(AbstractC1134b bVar) {
            p.h(bVar, "callback");
            this.tLN = bVar;
            dcb();
            EventCenter.instance.add(this.tLQ);
            k kVar = this.tCD;
            AbstractC1134b bVar2 = this.tLN;
            if (bVar2 == null) {
                p.hyc();
            }
            k.a(kVar, bVar2.gte, new j(this), 4);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            com.tencent.mm.plugin.finder.view.e dcm;
            com.tencent.mm.plugin.finder.storage.data.f.vGd.clearCache();
            Iterator<T> it = this.tLP.iterator();
            while (it.hasNext()) {
                it.next().dead();
            }
            this.tLP.clear();
            EventCenter.instance.removeListener(this.tLQ);
            this.tLN = null;
            AbstractC1134b bVar = this.tLN;
            if (bVar != null && (dcm = bVar.dcm()) != null) {
                dcm.onDetach();
            }
        }

        public void dcd() {
        }

        public void a(RefreshLoadMoreLayout.c<Object> cVar) {
            p.h(cVar, "reason");
        }

        public final void onUIResume() {
            com.tencent.mm.plugin.finder.view.e dcm;
            AbstractC1134b bVar = this.tLN;
            if (bVar != null && (dcm = bVar.dcm()) != null) {
                dcm.onUIResume();
            }
        }

        public final void onUIPause() {
            AbstractC1134b bVar = this.tLN;
            if (bVar != null) {
                bVar.dcm();
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final k getVideoCore() {
            return this.tCD;
        }

        public final void onBackPressed() {
            MMActivity mMActivity;
            FinderLikeDrawer dcj;
            FinderLikeDrawer dcn;
            TouchMediaPreviewLayout touchMediaPreviewLayout;
            com.tencent.mm.plugin.finder.view.e dcm;
            AbstractC1134b bVar = this.tLN;
            if (bVar == null || (dcm = bVar.dcm()) == null || !dcm.dGs()) {
                AbstractC1134b bVar2 = this.tLN;
                if (bVar2 == null || (touchMediaPreviewLayout = bVar2.tLW) == null || !touchMediaPreviewLayout.QFs) {
                    AbstractC1134b bVar3 = this.tLN;
                    if (bVar3 == null || (dcn = bVar3.dcn()) == null || !dcn.dGs()) {
                        AbstractC1134b bVar4 = this.tLN;
                        if (bVar4 == null || (dcj = bVar4.dcj()) == null || !dcj.dGs()) {
                            AbstractC1134b bVar5 = this.tLN;
                            if (bVar5 != null && (mMActivity = bVar5.gte) != null) {
                                mMActivity.finish();
                                return;
                            }
                            return;
                        }
                        dcj.dGr();
                        return;
                    }
                    dcn.dGr();
                    return;
                }
                touchMediaPreviewLayout.gZk();
                return;
            }
            dcm.dGr();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
        public static final class j implements k.b {
            final /* synthetic */ a tLR;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            j(a aVar) {
                this.tLR = aVar;
            }

            @Override // com.tencent.mm.plugin.finder.video.k.b
            public final RecyclerView dch() {
                AppMethodBeat.i(165616);
                AbstractC1134b bVar = this.tLR.tLN;
                if (bVar == null) {
                    p.hyc();
                }
                RecyclerView recyclerView = bVar.tLS.getRecyclerView();
                AppMethodBeat.o(165616);
                return recyclerView;
            }

            @Override // com.tencent.mm.plugin.finder.video.k.b
            public final DataBuffer<bo> dci() {
                AppMethodBeat.i(243676);
                DataBuffer<bo> dcc = this.tLR.dcc();
                AppMethodBeat.o(243676);
                return dcc;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class g implements o.f {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tLR;

            g(a aVar, BaseFinderFeed baseFinderFeed) {
                this.tLR = aVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                boolean z;
                com.tencent.mm.plugin.finder.event.a b2;
                AppMethodBeat.i(165613);
                a aVar = this.tLR;
                BaseFinderFeed baseFinderFeed = this.tEM;
                p.g(mVar, "menu");
                p.h(baseFinderFeed, "feed");
                p.h(mVar, "menu");
                String string = aVar.gte.getString(R.string.yz);
                p.g(string, "context.getString(R.string.app_share_to_weixin)");
                String string2 = aVar.gte.getString(R.string.d9p);
                p.g(string2, "context.getString(R.string.finder_share_timeline)");
                p.g(aVar.gte.getString(R.string.c8z), "context.getString(R.string.favorite)");
                boolean z2 = false;
                if (baseFinderFeed.feedObject.isOnlySelfSee() || baseFinderFeed.feedObject.isNotShare()) {
                    y yVar = y.vXH;
                    string = y.dP("FinderSafeSelfSeeForward", R.string.d8u);
                    y yVar2 = y.vXH;
                    string2 = y.dP("FinderSafeSelfSeeShare", R.string.d8v);
                    y yVar3 = y.vXH;
                    y.dP("FinderSafeSelfSeeCollect", R.string.d8t);
                    z2 = true;
                    z = true;
                } else {
                    z = false;
                }
                mVar.a(aVar.tqv, string, R.raw.finder_icons_filled_share, aVar.gte.getResources().getColor(R.color.Brand), z2);
                mVar.a(aVar.pLU, string2, R.raw.bottomsheet_icon_moment, 0, z);
                if (aVar.dca()) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
                    if (!com.tencent.mm.plugin.finder.upload.action.c.vTZ.k(baseFinderFeed.feedObject.getFeedObject())) {
                        mVar.a(aVar.tLK, aVar.gte.getString(R.string.c8z), R.raw.finder_icons_filled_star2, aVar.gte.getResources().getColor(R.color.a3b));
                    } else {
                        mVar.a(aVar.tLL, aVar.gte.getString(R.string.cir), R.raw.finder_icons_filled_unstar2, aVar.gte.getResources().getColor(R.color.a3b));
                    }
                }
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.I(baseFinderFeed.lT(), aVar.tCE);
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(aVar.gte);
                if (fH == null || (b2 = FinderReporterUIC.b(fH)) == null) {
                    AppMethodBeat.o(165613);
                    return;
                }
                b2.cZR().Ew(baseFinderFeed.lT());
                AppMethodBeat.o(165613);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.f a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
            p.h(baseFinderFeed, "feed");
            p.h(eVar, "sheet");
            return new g(this, baseFinderFeed);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class h implements o.f {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tLR;

            h(a aVar, BaseFinderFeed baseFinderFeed) {
                this.tLR = aVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(165614);
                a aVar = this.tLR;
                BaseFinderFeed baseFinderFeed = this.tEM;
                p.g(mVar, "menu");
                aVar.a(baseFinderFeed, mVar);
                AppMethodBeat.o(165614);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public o.f i(BaseFinderFeed baseFinderFeed) {
            p.h(baseFinderFeed, "feed");
            return new h(this, baseFinderFeed);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
        static final class i implements o.g {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tLR;

            i(a aVar, BaseFinderFeed baseFinderFeed) {
                this.tLR = aVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(165615);
                a aVar = this.tLR;
                BaseFinderFeed baseFinderFeed = this.tEM;
                p.g(menuItem, "menuItem");
                aVar.a(baseFinderFeed, menuItem, i2);
                AppMethodBeat.o(165615);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.g j(BaseFinderFeed baseFinderFeed) {
            p.h(baseFinderFeed, "feed");
            return new i(this, baseFinderFeed);
        }

        public void a(BaseFinderFeed baseFinderFeed, m mVar) {
            p.h(baseFinderFeed, "feed");
            p.h(mVar, "menu");
            y yVar = y.vXH;
            if (y.C(baseFinderFeed.feedObject)) {
                int i2 = this.tLJ;
                y yVar2 = y.vXH;
                mVar.a(i2, y.x(baseFinderFeed), R.raw.finder_bgm_gif_first_page, !baseFinderFeed.feedObject.isPostFinish() || baseFinderFeed.feedObject.isPostFailed());
            }
            y yVar3 = y.vXH;
            if (!y.h(baseFinderFeed)) {
                mVar.b(this.pMa, this.gte.getString(R.string.f3g), R.raw.icons_outlined_report_problem);
            } else if (!dca()) {
                y yVar4 = y.vXH;
                if (!y.isAnyEnableFullScreenEnjoy()) {
                    return;
                }
                if (baseFinderFeed.cxn() == 4 || baseFinderFeed.cxn() == 2) {
                    mVar.b(this.tLM, this.gte.getString(R.string.cno), R.raw.finder_icons_outlined_max_window);
                }
            }
        }

        @SuppressLint({"ResourceType"})
        public void a(BaseFinderFeed baseFinderFeed, MenuItem menuItem, int i2) {
            int i3;
            bbn bbn = null;
            azr azr = null;
            bbn bbn2 = null;
            p.h(baseFinderFeed, "feed");
            p.h(menuItem, "menuItem");
            Log.i(getTAG(), "getMoreMenuItemSelectedListener feed " + baseFinderFeed + ' ' + i2 + " menuItem:" + menuItem.getItemId());
            int itemId = menuItem.getItemId();
            if (itemId == this.tLD) {
                int l = l(baseFinderFeed);
                if (l >= 0) {
                    com.tencent.mm.plugin.finder.feed.logic.c cVar = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
                    com.tencent.mm.plugin.finder.feed.logic.c.a(this.gte, baseFinderFeed.feedObject.getId(), baseFinderFeed.feedObject.getObjectNonceId(), new C1132a(this, baseFinderFeed));
                    return;
                }
                Log.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(l)));
            } else if (itemId == this.tzW) {
            } else {
                if (itemId == this.tqv) {
                    new Bundle();
                    s.a.a(s.vWt, this.gte, baseFinderFeed.feedObject, 3, 4);
                } else if (itemId == this.pLU) {
                    s.a aVar = s.vWt;
                    s.a.a(this.gte, baseFinderFeed, 0, 0, 28);
                } else if (itemId == this.tLE) {
                    com.tencent.mm.plugin.finder.utils.g gVar = com.tencent.mm.plugin.finder.utils.g.vVq;
                    com.tencent.mm.plugin.finder.utils.g.a(baseFinderFeed, this.gte);
                } else if (itemId == this.pMa) {
                    y yVar = y.vXH;
                    if (y.w(baseFinderFeed)) {
                        awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
                        if (liveInfo != null) {
                            long j2 = liveInfo.liveId;
                            com.tencent.mm.plugin.finder.feed.logic.a aVar2 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                            com.tencent.mm.plugin.finder.feed.logic.a.b(this.gte, j2, baseFinderFeed.feedObject.getUserName());
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.plugin.finder.feed.logic.a aVar3 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                    com.tencent.mm.plugin.finder.feed.logic.a.a(this.gte, baseFinderFeed.feedObject.field_id, 0, 0, 12);
                } else if (itemId == this.tLF) {
                    Intent intent = new Intent();
                    FinderObjectDesc finderObjectDesc = baseFinderFeed.feedObject.getFeedObject().objectDesc;
                    intent.putExtra("postRefMediaList", finderObjectDesc != null ? finderObjectDesc.toByteArray() : null);
                    y yVar2 = y.vXH;
                    intent.putExtra("postRefFeedInfo", y.u(baseFinderFeed).toByteArray());
                    intent.putExtra("postType", baseFinderFeed.feedObject.getMediaType());
                    intent.putExtra("key_finder_post_from", 5);
                    com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this.gte, intent);
                } else if (itemId == this.tLH) {
                    ((v) com.tencent.mm.kernel.g.af(v.class)).a(baseFinderFeed.feedObject.getId(), baseFinderFeed.feedObject.getFeedObject(), baseFinderFeed.feedObject.getObjectNonceId(), true, new C1133b(this));
                } else if (itemId == this.tLG) {
                    ((v) com.tencent.mm.kernel.g.af(v.class)).a(baseFinderFeed.feedObject.getId(), baseFinderFeed.feedObject.getFeedObject(), baseFinderFeed.feedObject.getObjectNonceId(), false, new c(this));
                } else if (itemId == this.tLJ) {
                    if (baseFinderFeed.feedObject.isPostFinish()) {
                        FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
                        if (fH != null) {
                            i3 = fH.tCE;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 52) {
                            e.a aVar6 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                            e.a.n(baseFinderFeed.feedObject);
                            w wVar = w.vXp;
                            FinderObjectDesc finderObjectDesc2 = baseFinderFeed.feedObject.getFeedObject().objectDesc;
                            if (finderObjectDesc2 != null) {
                                azr = finderObjectDesc2.feedBgmInfo;
                            }
                            w.a(azr, Long.valueOf(baseFinderFeed.feedObject.field_id), 0);
                        } else if (this.gte instanceof FinderTopicTimelineUI) {
                            MMActivity mMActivity = this.gte;
                            if (mMActivity == null) {
                                throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                            }
                            ((FinderTopicTimelineUI) mMActivity).onBackPressed();
                        }
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.report.k.a(this.gte, 1, 1, Integer.valueOf(baseFinderFeed.feedObject.field_finderObject.follow_feed_count));
                    }
                } else if (itemId == this.tLK) {
                    aj ajVar = aj.viU;
                    FinderReporterUIC.a aVar7 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
                    if (fH2 != null) {
                        bbn2 = fH2.dIx();
                    }
                    aj.a(bbn2, "fav_in_menu", false, baseFinderFeed.lT());
                    u.a(this.gte, this.gte.getResources().getString(R.string.cp8), new d(this, baseFinderFeed));
                } else if (itemId == this.tLL) {
                    aj ajVar2 = aj.viU;
                    FinderReporterUIC.a aVar8 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this.gte);
                    if (fH3 != null) {
                        bbn = fH3.dIx();
                    }
                    aj.a(bbn, "unfav_in_menu", false, baseFinderFeed.lT());
                    u.a(this.gte, this.gte.getResources().getString(R.string.cp7), new e(this, baseFinderFeed));
                } else if (itemId == this.tLM) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("KEY_FROM_SCENE", 1);
                    intent2.putExtra("KEY_USERNAME", z.aUg());
                    intent2.putExtra("KEY_FINDER_SELF_FLAG", true);
                    OccupyFinderUI10.a aVar9 = OccupyFinderUI10.udX;
                    intent2.putExtra(OccupyFinderUI10.dez(), true);
                    OccupyFinderUI10.a aVar10 = OccupyFinderUI10.udX;
                    intent2.putExtra(OccupyFinderUI10.deA(), false);
                    y yVar3 = y.vXH;
                    y.a(0, kotlin.a.j.listOf(baseFinderFeed), (com.tencent.mm.bw.b) null, intent2);
                    com.tencent.mm.plugin.finder.utils.a aVar11 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.ac(this.gte, intent2);
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.b$a$b  reason: collision with other inner class name */
        public static final class C1133b implements ai<ayy> {
            final /* synthetic */ a tLR;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1133b(a aVar) {
                this.tLR = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayy ayy, apg apg) {
                AppMethodBeat.i(165608);
                p.h(ayy, "req");
                p.h(apg, "ret");
                if (apg.retCode == 0) {
                    u.makeText(this.tLR.gte, (int) R.string.cnn, 0).show();
                    AppMethodBeat.o(165608);
                    return;
                }
                u.makeText(this.tLR.gte, (int) R.string.cnm, 0).show();
                Log.i(this.tLR.getTAG(), "finder_feed_open_comment_no_ok " + apg.retCode);
                AppMethodBeat.o(165608);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        public static final class c implements ai<ayy> {
            final /* synthetic */ a tLR;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(a aVar) {
                this.tLR = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayy ayy, apg apg) {
                AppMethodBeat.i(165609);
                p.h(ayy, "req");
                p.h(apg, "ret");
                if (apg.retCode == 0) {
                    u.makeText(this.tLR.gte, (int) R.string.cmp, 0).show();
                    AppMethodBeat.o(165609);
                    return;
                }
                u.makeText(this.tLR.gte, (int) R.string.cmo, 0).show();
                Log.i(this.tLR.getTAG(), "finder_feed_close_comment_ok " + apg.retCode);
                AppMethodBeat.o(165609);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        public static final class d implements u.b {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tLR;

            d(a aVar, BaseFinderFeed baseFinderFeed) {
                this.tLR = aVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                WeImageView weImageView;
                TextView textView;
                AppMethodBeat.i(243674);
                if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                    textView.setTextSize(1, 14.0f);
                }
                if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                    weImageView.setImageResource(R.raw.icons_filled_done);
                    Context context = weImageView.getContext();
                    p.g(context, "context");
                    weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                }
                this.tLR.a(this.tEM.feedObject, true, (com.tencent.mm.view.recyclerview.h) null);
                AppMethodBeat.o(243674);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        public static final class e implements u.b {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tLR;

            e(a aVar, BaseFinderFeed baseFinderFeed) {
                this.tLR = aVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                WeImageView weImageView;
                TextView textView;
                AppMethodBeat.i(243675);
                if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                    textView.setTextSize(1, 14.0f);
                }
                if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                    weImageView.setImageResource(R.raw.icons_filled_done);
                    Context context = weImageView.getContext();
                    p.g(context, "context");
                    weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                }
                this.tLR.a(this.tEM.feedObject, false, (com.tencent.mm.view.recyclerview.h) null);
                AppMethodBeat.o(243675);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final RecyclerView.m dcf() {
            return this.tLO;
        }

        @Override // com.tencent.mm.vending.e.b
        public void keep(com.tencent.mm.vending.e.a aVar) {
            this.tLP.add(aVar);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem, boolean z, com.tencent.mm.view.recyclerview.h hVar) {
            p.h(finderItem, "feed");
            r rVar = r.uNW;
            r.a(this.gte, finderItem, z);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem) {
            p.h(finderItem, "feed");
            s.a.a(s.vWt, this.gte, finderItem, 0, 12);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void k(BaseFinderFeed baseFinderFeed) {
            p.h(baseFinderFeed, "feed");
            s.a aVar = s.vWt;
            s.a.a(this.gte, baseFinderFeed, 4, 0, 20);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final com.tencent.mm.plugin.finder.view.e dcg() {
            com.tencent.mm.plugin.finder.view.e dcm;
            AbstractC1134b bVar = this.tLN;
            return (bVar == null || (dcm = bVar.dcm()) == null) ? new com.tencent.mm.plugin.finder.view.e() : dcm;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(BaseFinderFeed baseFinderFeed, boolean z, boolean z2, int i2, boolean z3) {
            p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
            com.tencent.mm.plugin.finder.model.aj ajVar = com.tencent.mm.plugin.finder.model.aj.uOw;
            FinderItem finderItem = baseFinderFeed.feedObject;
            boolean z4 = baseFinderFeed.showLikeTips;
            y yVar = y.vXH;
            com.tencent.mm.plugin.finder.model.aj.a(dIx, i2, finderItem, z, z2, 2, z4, z3, y.i(baseFinderFeed.contact));
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void b(BaseFinderFeed baseFinderFeed, boolean z) {
            String str;
            int i2;
            String str2;
            int i3;
            String username;
            String username2;
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
            c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
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
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem, FinderCommentInfo finderCommentInfo) {
            p.h(finderItem, "feed");
            p.h(finderCommentInfo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
        public static final class f extends com.tencent.mm.plugin.finder.view.f {
            final /* synthetic */ a tLR;
            private String tag;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            f(a aVar) {
                this.tLR = aVar;
                AppMethodBeat.i(165612);
                this.tag = aVar.getTAG();
                AppMethodBeat.o(165612);
            }

            @Override // com.tencent.mm.plugin.finder.view.f
            public final String getTag() {
                return this.tag;
            }

            @Override // com.tencent.mm.plugin.finder.view.f
            public final FinderItem EB(long j2) {
                RecyclerView recyclerView;
                AppMethodBeat.i(165610);
                AbstractC1134b bVar = this.tLR.tLN;
                if (!(bVar == null || (recyclerView = bVar.tLS.getRecyclerView()) == null)) {
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (adapter == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                        AppMethodBeat.o(165610);
                        throw tVar;
                    }
                    RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
                    if (vVar != null) {
                        int lR = vVar.lR();
                        AbstractC1134b bVar2 = this.tLR.tLN;
                        if (bVar2 == null) {
                            p.hyc();
                        }
                        bo IE = this.tLR.IE(lR - bVar2.sHN);
                        if (IE instanceof BaseFinderFeed) {
                            FinderItem finderItem = ((BaseFinderFeed) IE).feedObject;
                            AppMethodBeat.o(165610);
                            return finderItem;
                        }
                    }
                }
                AppMethodBeat.o(165610);
                return null;
            }

            @Override // com.tencent.mm.plugin.finder.view.f
            public final void a(long j2, azt azt) {
                RecyclerView recyclerView;
                AppMethodBeat.i(165611);
                AbstractC1134b bVar = this.tLR.tLN;
                if (bVar == null || (recyclerView = bVar.tLS.getRecyclerView()) == null) {
                    AppMethodBeat.o(165611);
                    return;
                }
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                    AppMethodBeat.o(165611);
                    throw tVar;
                }
                RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
                if (vVar != null) {
                    int lR = vVar.lR();
                    RecyclerView.a adapter2 = recyclerView.getAdapter();
                    if (adapter2 != null) {
                        adapter2.b(lR, new kotlin.o(1, azt));
                        AppMethodBeat.o(165611);
                        return;
                    }
                    AppMethodBeat.o(165611);
                    return;
                }
                AppMethodBeat.o(165611);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u00101\u001a\u00020\u0004H\u0016J\f\u00102\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\n\u00104\u001a\u0004\u0018\u000105H&J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001bH\u0016J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u00020;H\u0016J\u0006\u0010<\u001a\u00020%J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0016\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0016J\u0016\u0010D\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0016J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0007H\u0016J\u0018\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020JH&J\u0018\u0010K\u001a\u00020@2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020JH&J\u0018\u0010L\u001a\u00020@2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020JH&J\b\u0010M\u001a\u00020@H&R\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012X.¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b \u0010\u0014R\u000e\u0010#\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000eR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "isEnableFullScreenEnjoy", "isEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRfLayout", "getSnapHelper", "Landroid/support/v7/widget/SnapHelper;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC1134b implements com.tencent.mm.plugin.finder.presenter.base.c<a> {
        final MMActivity gte;
        int sHN;
        private final int scene;
        public final int tCE;
        private WxRecyclerAdapter<?> tFp;
        public RefreshLoadMoreLayout tLS;
        private com.tencent.mm.plugin.finder.view.e tLT;
        private FinderLikeDrawer tLU;
        public FinderLikeDrawer tLV;
        public TouchMediaPreviewLayout tLW;
        private final f tLX;
        final a tLY;
        private final boolean tLZ;

        public abstract void dbY();

        public final boolean dck() {
            return ((Boolean) this.tLX.getValue()).booleanValue();
        }

        public abstract View getEmptyView();

        public /* synthetic */ AbstractC1134b(MMActivity mMActivity, a aVar, int i2, int i3) {
            this(mMActivity, aVar, i2, i3, false);
        }

        public AbstractC1134b(MMActivity mMActivity, a aVar, int i2, int i3, boolean z) {
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
            this.gte = mMActivity;
            this.tLY = aVar;
            this.scene = i2;
            this.tCE = i3;
            this.tLZ = z;
            View findViewById = this.gte.findViewById(R.id.h7t);
            p.g(findViewById, "context.findViewById(R.id.rl_layout)");
            this.tLS = (RefreshLoadMoreLayout) findViewById;
            this.tLX = kotlin.g.ah(new C1137b(this));
        }

        public final FinderLikeDrawer dcj() {
            FinderLikeDrawer finderLikeDrawer = this.tLV;
            if (finderLikeDrawer == null) {
                p.btv("friendLikeDrawer");
            }
            return finderLikeDrawer;
        }

        public final void ab(ArrayList<bo> arrayList) {
            p.h(arrayList, "data");
            e.a aVar = com.tencent.mm.plugin.finder.view.e.wky;
            Window window = this.gte.getWindow();
            p.g(window, "getActivity().window");
            View decorView = window.getDecorView();
            p.g(decorView, "getActivity().window.decorView");
            this.tLT = e.a.a(this.gte, decorView, this.scene, this.tLZ, 0, 16);
            FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
            Window window2 = this.gte.getWindow();
            p.g(window2, "getActivity().window");
            FinderLikeDrawer.a aVar3 = FinderLikeDrawer.wnm;
            this.tLU = FinderLikeDrawer.a.a(this.gte, window2, FinderLikeDrawer.tvm);
            FinderLikeDrawer.a aVar4 = FinderLikeDrawer.wnm;
            Window window3 = this.gte.getWindow();
            p.g(window3, "getActivity().window");
            FinderLikeDrawer.a aVar5 = FinderLikeDrawer.wnm;
            this.tLV = FinderLikeDrawer.a.a(this.gte, window3, FinderLikeDrawer.tvl);
            aa(arrayList);
        }

        public RecyclerView.h getItemDecoration() {
            return new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(c.a.a(this).getColor(R.color.f3043a)), (int) c.a.a(this).getDimension(R.dimen.a4f));
        }

        public void aa(ArrayList<bo> arrayList) {
            com.tencent.mm.plugin.finder.ui.e eVar;
            p.h(arrayList, "data");
            RecyclerView recyclerView = this.tLS.getRecyclerView();
            FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(this.gte);
            if (dck()) {
                finderLinearLayoutManager.wsx = 25.0f;
                finderLinearLayoutManager.qOi = 100;
            }
            recyclerView.setLayoutManager(finderLinearLayoutManager);
            if (dck()) {
                eVar = new com.tencent.mm.plugin.finder.ui.e();
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.f(recyclerView);
            }
            this.tFp = new WxRecyclerAdapter<>(this.tLY.dce(), arrayList);
            WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            recyclerView.setAdapter(wxRecyclerAdapter);
            if (!dck()) {
                recyclerView.b(getItemDecoration());
            }
            this.tLS.setActionCallback(new a(this, recyclerView));
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class));
            if (d2 != null) {
                d2.m(recyclerView);
            }
            dbY();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.b$b$a */
        public static final class a extends RefreshLoadMoreLayout.a {
            final /* synthetic */ RecyclerView tDJ;
            private boolean tMa = true;
            final /* synthetic */ AbstractC1134b tMb;

            a(AbstractC1134b bVar, RecyclerView recyclerView) {
                this.tMb = bVar;
                this.tDJ = recyclerView;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
                int i2;
                RecyclerView recyclerView;
                RecyclerView recyclerView2;
                AppMethodBeat.i(243679);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.onRefreshEnd(cVar);
                View emptyView = this.tMb.getEmptyView();
                if (emptyView != null) {
                    RecyclerView.a adapter = this.tMb.tLS.getRecyclerView().getAdapter();
                    if (!(adapter instanceof WxRecyclerAdapter)) {
                        adapter = null;
                    }
                    WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
                    if (wxRecyclerAdapter != null) {
                        i2 = wxRecyclerAdapter.hgt();
                    } else {
                        i2 = 0;
                    }
                    if (i2 <= 0) {
                        emptyView.setVisibility(0);
                        if (!(wxRecyclerAdapter == null || (recyclerView2 = wxRecyclerAdapter.getRecyclerView()) == null)) {
                            recyclerView2.setVisibility(8);
                        }
                        View findViewById = emptyView.findViewById(R.id.h5w);
                        if (findViewById != null) {
                            findViewById.setVisibility(0);
                        }
                        View findViewById2 = emptyView.findViewById(R.id.gl7);
                        if (findViewById2 != null) {
                            findViewById2.setVisibility(8);
                        }
                    } else {
                        emptyView.setVisibility(8);
                        if (!(wxRecyclerAdapter == null || (recyclerView = wxRecyclerAdapter.getRecyclerView()) == null)) {
                            recyclerView.setVisibility(0);
                        }
                    }
                }
                this.tMb.tLY.dcd();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(243679);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                AppMethodBeat.i(243680);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                h.RTc.aX(new RunnableC1136b(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(243680);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.b$b$a$b  reason: collision with other inner class name */
            static final class RunnableC1136b implements Runnable {
                final /* synthetic */ a tMc;

                RunnableC1136b(a aVar) {
                    this.tMc = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(243678);
                    this.tMc.tMb.tLY.requestRefresh();
                    AppMethodBeat.o(243678);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                AppMethodBeat.i(243681);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                super.cxo();
                h.RTc.aX(new RunnableC1135a(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(243681);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.b$b$a$a  reason: collision with other inner class name */
            static final class RunnableC1135a implements Runnable {
                final /* synthetic */ a tMc;

                RunnableC1135a(a aVar) {
                    this.tMc = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(243677);
                    this.tMc.tMb.tLY.boE();
                    AppMethodBeat.o(243677);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243682);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                this.tMb.tLY.a(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(243682);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void IF(int i2) {
                AppMethodBeat.i(243683);
                this.tMb.IF(i2);
                if (this.tMa && i2 > 0) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tMb.gte).get(FinderReporterUIC.class));
                    if (d2 != null) {
                        d2.dap().onScrollStateChanged(this.tDJ, 5);
                    }
                    this.tMa = false;
                }
                AppMethodBeat.o(243683);
            }
        }

        public final com.tencent.mm.plugin.finder.view.e dcm() {
            com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
            if (eVar == null) {
                p.btv("drawer");
            }
            return eVar;
        }

        public final FinderLikeDrawer dcn() {
            FinderLikeDrawer finderLikeDrawer = this.tLU;
            if (finderLikeDrawer == null) {
                p.btv("likeDrawer");
            }
            return finderLikeDrawer;
        }

        public final WxRecyclerAdapter<?> getAdapter() {
            WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            return wxRecyclerAdapter;
        }

        public void IF(int i2) {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.b$b$b  reason: collision with other inner class name */
        static final class C1137b extends q implements kotlin.g.a.a<Boolean> {
            final /* synthetic */ AbstractC1134b tMb;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1137b(AbstractC1134b bVar) {
                super(0);
                this.tMb = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(243684);
                Boolean valueOf = Boolean.valueOf(this.tMb.tLY.dca());
                AppMethodBeat.o(243684);
                return valueOf;
            }
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
