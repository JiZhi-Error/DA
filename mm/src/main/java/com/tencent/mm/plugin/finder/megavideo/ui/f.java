package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.megavideo.convert.a;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.Iterator;
import kotlin.g.b.q;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J2\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\t2\b\b\u0002\u0010R\u001a\u00020*2\b\b\u0002\u0010S\u001a\u00020*J \u0010T\u001a\u00020L2\u0006\u00105\u001a\u0002062\u0006\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020*H\u0016J\b\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020LH\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010O\u001a\u00020PH\u0007J\b\u0010\\\u001a\u00020]H\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0018\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020N2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020a2\u0006\u0010b\u001a\u00020NH\u0016J\b\u0010f\u001a\u0004\u0018\u00010gJ\b\u0010h\u001a\u000204H\u0016J\u0018\u0010i\u001a\u00020j2\u0006\u0010b\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010k\u001a\u00020HH\u0016J\b\u0010l\u001a\u00020JH\u0016J\u0006\u0010m\u001a\u00020LJ\u0018\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020LH\u0016J\b\u0010t\u001a\u00020LH\u0016J\u0018\u0010u\u001a\u00020L2\u0006\u0010!\u001a\u00020\"2\u0006\u0010v\u001a\u00020JH\u0016J\u0010\u0010u\u001a\u00020L2\u0006\u0010v\u001a\u00020JH\u0016J\u0010\u0010w\u001a\u00020*2\u0006\u0010x\u001a\u00020*H\u0016J\u0010\u0010y\u001a\u00020L2\u0006\u0010z\u001a\u00020*H\u0016J\b\u0010{\u001a\u00020LH\u0016J\u0010\u0010|\u001a\u00020L2\u0006\u0010}\u001a\u00020rH\u0016J#\u0010~\u001a\u00020L2\u0006\u0010\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J,\u0010\u0001\u001a\u00020L2\u0006\u0010b\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010\u001a\u00020NH\u0016J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010\u001a\u00020NH\u0016J'\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\u00012\u0006\u0010S\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001f\u0010\u0015R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001b\u0010>\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0017\u001a\u0004\b@\u0010AR\u000e\u0010C\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX.¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "context", "Landroid/support/v7/app/AppCompatActivity;", "uic", "Lcom/tencent/mm/ui/component/UIComponent;", "(Landroid/support/v7/app/AppCompatActivity;Lcom/tencent/mm/ui/component/UIComponent;)V", "MENU_ID_ADD_TO_MULTITASK", "", "MENU_ID_CLOSE_BULLET", "MENU_ID_DELETE", "MENU_ID_DELETE_TO_MULTITASK", "MENU_ID_EXPOSE", "MENU_ID_OPEN_BULLET", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "addToHistoryOffset", "getAddToHistoryOffset", "()I", "addToHistoryOffset$delegate", "Lkotlin/Lazy;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "configPosition", "deleteFromHistoryOffset", "getDeleteFromHistoryOffset", "deleteFromHistoryOffset$delegate", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isAutoLoadingMore", "", "isInMultiTask", "()Z", "setInMultiTask", "(Z)V", "isSelfProfile", "setSelfProfile", "loadingFooterData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "oldStatus", "getOldStatus", "setOldStatus", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "tipDialog", "Landroid/app/Dialog;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "addToMultiTask", "", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "videoCurrPlayTimes", "isHistory", "isUpdate", "bindMultiTaskInfo", "info", "isMultiTask", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkEmpty", "genMultiTaskCover", "Landroid/graphics/Bitmap;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentSnapshotView", "Landroid/view/View;", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getViewCallback", "initViewCallback", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onDetach", "onEventHappen", "ev", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "likeAction", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "requestRefresh", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isFromMultiTask", "Companion", "plugin-finder_release"})
public final class f extends com.tencent.mm.plugin.finder.event.base.d implements h.a {
    public static final a uMm = new a((byte) 0);
    private final int jUx;
    private final int pLU;
    private final int pMa;
    private final com.tencent.mm.plugin.finder.video.k tCD = new com.tencent.mm.plugin.finder.video.k();
    private RecyclerView.m tLO;
    private com.tencent.mm.view.j tMe;
    private final int tPA;
    private final int tPB;
    private final kotlin.f tRX;
    private final int tSl;
    private boolean tSn;
    private Dialog tipDialog;
    private final int tqv;
    private BaseMegaVideoLoader uLF;
    public h.b uLW;
    public com.tencent.mm.plugin.finder.megavideo.multitask.a uLX;
    private cnu uLY;
    public boolean uLZ;
    private boolean uMa;
    private final kotlin.f uMb;
    private final kotlin.f uMc;
    private final int uMd;
    private final int uMe;
    private final int uMf;
    private final int uMg;
    private g.b uMh;
    private boolean uMi;
    private final kotlin.f uMj;
    public final AppCompatActivity uMk;
    private final UIComponent uMl;

    static {
        AppMethodBeat.i(248589);
        AppMethodBeat.o(248589);
    }

    private final com.tencent.mm.plugin.finder.feed.model.d dcW() {
        AppMethodBeat.i(248566);
        com.tencent.mm.plugin.finder.feed.model.d dVar = (com.tencent.mm.plugin.finder.feed.model.d) this.tRX.getValue();
        AppMethodBeat.o(248566);
        return dVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    static final class j extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ f uMn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(f fVar) {
            super(1);
            this.uMn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            RecyclerView recyclerView;
            AppMethodBeat.i(248557);
            IResponse<bo> iResponse2 = iResponse;
            kotlin.g.b.p.h(iResponse2, LocaleUtil.ITALIAN);
            h.b a2 = f.a(this.uMn);
            RecyclerView.a adapter = (a2 == null || (recyclerView = a2.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            final WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (iResponse2.getHasMore()) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.megavideo.ui.f.j.AnonymousClass1 */
                    final /* synthetic */ j uMu;

                    {
                        this.uMu = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(248555);
                        WxRecyclerAdapter wxRecyclerAdapter = wxRecyclerAdapter;
                        if (wxRecyclerAdapter != null && !wxRecyclerAdapter.b(this.uMu.uMn.uMh)) {
                            com.tencent.mm.view.recyclerview.g.b(wxRecyclerAdapter, this.uMu.uMn.uMh);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(248555);
                        return xVar;
                    }
                });
            } else {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.megavideo.ui.f.j.AnonymousClass2 */
                    final /* synthetic */ j uMu;

                    {
                        this.uMu = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(248556);
                        WxRecyclerAdapter wxRecyclerAdapter = wxRecyclerAdapter;
                        if (wxRecyclerAdapter != null && wxRecyclerAdapter.b(this.uMu.uMn.uMh)) {
                            wxRecyclerAdapter.U(this.uMu.uMn.uMh.lT(), true);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(248556);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248557);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
    public static final class l extends q implements kotlin.g.a.b<Integer, bo> {
        final /* synthetic */ f uMn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(f fVar) {
            super(1);
            this.uMn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bo invoke(Integer num) {
            bm bmVar;
            AppMethodBeat.i(248560);
            int intValue = num.intValue();
            if (intValue < 0 || intValue >= f.d(this.uMn).getDataListJustForAdapter().size()) {
                AppMethodBeat.o(248560);
                return null;
            }
            bo boVar = (bo) f.d(this.uMn).get(intValue);
            if (boVar instanceof bm) {
                bmVar = (bm) boVar;
            } else {
                bmVar = null;
            }
            bm bmVar2 = bmVar;
            AppMethodBeat.o(248560);
            return bmVar2;
        }
    }

    public f(AppCompatActivity appCompatActivity, UIComponent uIComponent) {
        kotlin.g.b.p.h(appCompatActivity, "context");
        kotlin.g.b.p.h(uIComponent, "uic");
        AppMethodBeat.i(248588);
        this.uMk = appCompatActivity;
        this.uMl = uIComponent;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        this.tLO = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(this.uMk).get(FinderRecyclerViewPool.class)).tLO;
        this.tRX = kotlin.g.ah(new e(this));
        this.uMb = kotlin.g.ah(b.uMo);
        this.uMc = kotlin.g.ah(C1233f.uMp);
        this.tqv = 102;
        this.pLU = 103;
        this.jUx = 104;
        this.uMd = 105;
        this.uMe = 106;
        this.tPA = 107;
        this.tPB = 108;
        this.pMa = 109;
        this.uMf = 110;
        this.uMg = 111;
        this.tMe = new com.tencent.mm.view.j(this) {
            /* class com.tencent.mm.plugin.finder.megavideo.ui.f.AnonymousClass1 */
            final /* synthetic */ f uMn;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uMn = r1;
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(248533);
                kotlin.g.b.p.h(cVar, "reason");
                this.uMn.tSn = false;
                AppMethodBeat.o(248533);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(248534);
                kotlin.g.b.p.h(cVar, "reason");
                this.uMn.tSn = false;
                AppMethodBeat.o(248534);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(248535);
                kotlin.g.b.p.h(cVar, "reason");
                this.uMn.tSn = false;
                AppMethodBeat.o(248535);
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
                AppMethodBeat.i(248536);
                RecyclerView.a adapter = f.a(this.uMn).getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    AppMethodBeat.o(248536);
                    return;
                }
                AppMethodBeat.o(248536);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                RecyclerView.a adapter;
                AppMethodBeat.i(248537);
                Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged fromPosition:" + i2 + " itemCount" + i3);
                if (i3 <= 0 || (adapter = f.a(this.uMn).getRecyclerView().getAdapter()) == null) {
                    AppMethodBeat.o(248537);
                    return;
                }
                adapter.aq(i2, i3);
                AppMethodBeat.o(248537);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                RecyclerView.a adapter;
                AppMethodBeat.i(248538);
                Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged payload fromPosition:" + i2 + " itemCount" + i3);
                if (i3 <= 0 || (adapter = f.a(this.uMn).getRecyclerView().getAdapter()) == null) {
                    AppMethodBeat.o(248538);
                    return;
                }
                adapter.e(i2, i3, obj);
                AppMethodBeat.o(248538);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                AppMethodBeat.i(248539);
                Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeInserted fromPosition:" + i2 + " itemCount" + i3);
                if (i3 > 0) {
                    RecyclerView recyclerView = f.a(this.uMn).getRecyclerView();
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.as(i2, i3);
                    }
                    recyclerView.post(new a(recyclerView, i2));
                }
                AppMethodBeat.o(248539);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.f$1$a */
            static final class a implements Runnable {
                final /* synthetic */ RecyclerView tST;
                final /* synthetic */ int tYg;

                a(RecyclerView recyclerView, int i2) {
                    this.tST = recyclerView;
                    this.tYg = i2;
                }

                public final void run() {
                    AppMethodBeat.i(248532);
                    RecyclerView recyclerView = this.tST;
                    RecyclerView.LayoutManager layoutManager = this.tST.getLayoutManager();
                    if (layoutManager == null) {
                        t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                        AppMethodBeat.o(248532);
                        throw tVar;
                    }
                    RecyclerView.v cg = recyclerView.cg(((LinearLayoutManager) layoutManager).ku());
                    if (!(cg instanceof com.tencent.mm.view.recyclerview.h)) {
                        cg = null;
                    }
                    com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) cg;
                    if (hVar != null) {
                        if (hVar.hgv() instanceof bn) {
                            RecyclerView recyclerView2 = this.tST;
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.tYg, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a2.axQ(), "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1$onItemRangeInserted$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                            recyclerView2.scrollToPosition(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1$onItemRangeInserted$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                        }
                        AppMethodBeat.o(248532);
                        return;
                    }
                    AppMethodBeat.o(248532);
                }
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                AppMethodBeat.i(248540);
                Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeRemoved fromPosition:" + i2 + " itemCount" + i3);
                if (i3 > 0) {
                    RecyclerView.a adapter = f.a(this.uMn).getRecyclerView().getAdapter();
                    if (adapter != null) {
                        adapter.at(i2, i3);
                    }
                    f.o(this.uMn);
                }
                AppMethodBeat.o(248540);
            }
        };
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        this.tSl = aAh.azQ().getInt(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_NUM_INT_SYNC, 0);
        this.uMh = new bn();
        this.uMj = kotlin.g.ah(o.uMx);
        AppMethodBeat.o(248588);
    }

    public static final /* synthetic */ h.b a(f fVar) {
        AppMethodBeat.i(248590);
        h.b bVar = fVar.uLW;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        AppMethodBeat.o(248590);
        return bVar;
    }

    public static final /* synthetic */ BaseMegaVideoLoader d(f fVar) {
        AppMethodBeat.i(248591);
        BaseMegaVideoLoader baseMegaVideoLoader = fVar.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        AppMethodBeat.o(248591);
        return baseMegaVideoLoader;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(h.b bVar) {
        AppMethodBeat.i(248572);
        a(bVar);
        AppMethodBeat.o(248572);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        Object obj;
        boolean z;
        AppMethodBeat.i(248567);
        kotlin.g.b.p.h(bVar, "ev");
        if (bVar instanceof com.tencent.mm.plugin.finder.event.base.h) {
            switch (((com.tencent.mm.plugin.finder.event.base.h) bVar).type) {
                case 0:
                    if (this.tSl > 0) {
                        h.b bVar2 = this.uLW;
                        if (bVar2 == null) {
                            kotlin.g.b.p.btv("viewCallback");
                        }
                        RecyclerView.a adapter = bVar2.getRecyclerView().getAdapter();
                        if (!(adapter instanceof com.tencent.mm.view.recyclerview.g)) {
                            adapter = null;
                        }
                        com.tencent.mm.view.recyclerview.g gVar = (com.tencent.mm.view.recyclerview.g) adapter;
                        int itemCount = gVar != null ? gVar.getItemCount() - gVar.RqN.size() : 0;
                        int i2 = itemCount - this.tSl;
                        if (((com.tencent.mm.plugin.finder.event.base.h) bVar).tIA >= i2 && itemCount >= 4) {
                            Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.tSl + ", lastVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIA + ", preLoadBeginPosition=" + i2 + ", count=" + itemCount + " isAutoLoadingMore=" + this.tSn);
                            if (!this.tSn) {
                                boE();
                                break;
                            }
                        }
                    }
                    break;
                case 1:
                case 2:
                    Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
                    this.uMk.setRequestedOrientation(1);
                    break;
            }
            if (((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 4) {
                h.b bVar3 = this.uLW;
                if (bVar3 == null) {
                    kotlin.g.b.p.btv("viewCallback");
                }
                RecyclerView.v cg = bVar3.getRecyclerView().cg(((com.tencent.mm.plugin.finder.event.base.h) bVar).tIy);
                if (!(cg instanceof com.tencent.mm.view.recyclerview.h)) {
                    cg = null;
                }
                com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) cg;
                if (hVar != null) {
                    if (hVar.hgv() instanceof bn) {
                        Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.tSl + ", firstVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIy + ",  isAutoLoadingMore=" + this.tSn);
                        if (!this.tSn) {
                            boE();
                        }
                    } else {
                        View Mn = hVar.Mn(R.id.izw);
                        if (Mn != null) {
                            if (Mn.getVisibility() == 0) {
                                Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation unspecified");
                                this.uMk.setRequestedOrientation(-1);
                            } else {
                                Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
                                this.uMk.setRequestedOrientation(1);
                            }
                        }
                    }
                }
            }
        }
        if (bVar instanceof c.a) {
            switch (((c.a) bVar).type) {
                case 2:
                    com.tencent.mm.ac.d.h(new n(this));
                    AppMethodBeat.o(248567);
                    return;
                case 3:
                    BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
                    if (baseMegaVideoLoader == null) {
                        kotlin.g.b.p.btv("feedLoader");
                    }
                    Iterator it = baseMegaVideoLoader.getDataListJustForAdapter().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (((bo) next).lT() == ((c.a) bVar).feedId) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                obj = next;
                            }
                        } else {
                            obj = null;
                        }
                    }
                    bo boVar = (bo) obj;
                    if (!(boVar instanceof bm)) {
                        boVar = null;
                    }
                    bm bmVar = (bm) boVar;
                    if (bmVar != null) {
                        if (((c.a) bVar).offset >= ((Number) this.uMb.getValue()).intValue() && !bmVar.uOU) {
                            Log.i("FinderLongVideoTLPresenter", "onEventHappen: add to history, offset = " + ((c.a) bVar).offset + ", feedId = " + ((c.a) bVar).feedId);
                            bmVar.uOU = true;
                            com.tencent.mm.ac.d.h(new m(this, bVar));
                        }
                        if (((c.a) bVar).offset >= ((c.a) bVar).jcu - ((Number) this.uMc.getValue()).intValue() && !bmVar.uOT) {
                            Log.i("FinderLongVideoTLPresenter", "onEventHappen: delete from history, offset = " + ((c.a) bVar).offset + ", total = " + ((c.a) bVar).jcu + ", feedId = " + ((c.a) bVar).feedId);
                            bmVar.uOT = true;
                        }
                        AppMethodBeat.o(248567);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(248567);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(248568);
        kotlin.g.b.p.h(cVar, "dispatcher");
        kotlin.g.b.p.h(bVar, "event");
        if (bVar instanceof com.tencent.mm.plugin.finder.event.base.h) {
            if (((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 1 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 2 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 4) {
                AppMethodBeat.o(248568);
                return true;
            }
            AppMethodBeat.o(248568);
            return false;
        } else if (!(bVar instanceof c.a) || !(((c.a) bVar).type == 2 || ((c.a) bVar).type == 3)) {
            AppMethodBeat.o(248568);
            return false;
        } else {
            AppMethodBeat.o(248568);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class d implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ f uMn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(f fVar) {
            this.uMn = fVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(248544);
            if (i2 == bn.class.hashCode()) {
                com.tencent.mm.plugin.finder.megavideo.convert.c cVar = new com.tencent.mm.plugin.finder.megavideo.convert.c(this.uMn);
                AppMethodBeat.o(248544);
                return cVar;
            }
            com.tencent.mm.plugin.finder.megavideo.convert.a aVar = new com.tencent.mm.plugin.finder.megavideo.convert.a(this.uMn.tCD, this.uMn);
            AppMethodBeat.o(248544);
            return aVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final com.tencent.mm.view.recyclerview.f dce() {
        AppMethodBeat.i(248569);
        d dVar = new d(this);
        AppMethodBeat.o(248569);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final void a(BaseMegaVideoLoader baseMegaVideoLoader, h.b bVar) {
        AppMethodBeat.i(248570);
        kotlin.g.b.p.h(baseMegaVideoLoader, "feedLoader");
        kotlin.g.b.p.h(bVar, "callback");
        this.uLF = baseMegaVideoLoader;
        baseMegaVideoLoader.fetchEndCallback = new j(this);
        a(bVar);
        AppMethodBeat.o(248570);
    }

    private void a(h.b bVar) {
        bbn dIx;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(248571);
        kotlin.g.b.p.h(bVar, "callback");
        this.uLW = bVar;
        dcb();
        com.tencent.mm.plugin.finder.video.k.a(this.tCD, this.uMk, new k(this), 4);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c a2 = FinderReporterUIC.a((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uMk).get(FinderReporterUIC.class));
        if (a2 != null) {
            a2.a(this);
            a2.a(dcW());
        }
        MediaPreloadCore.a aVar2 = MediaPreloadCore.uTV;
        if (MediaPreloadCore.uTU) {
            h.b bVar2 = this.uLW;
            if (bVar2 == null) {
                kotlin.g.b.p.btv("viewCallback");
            }
            TestPreloadPreview testPreloadPreview = (TestPreloadPreview) bVar2.getRootView().findViewById(R.id.ijo);
            if (testPreloadPreview != null) {
                testPreloadPreview.setVisibility(0);
                com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(dcl()).get(FinderReporterUIC.class));
                if (d2 != null) {
                    BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
                    if (baseMegaVideoLoader == null) {
                        kotlin.g.b.p.btv("feedLoader");
                    }
                    DataBuffer<bo> dataListJustForAdapter = baseMegaVideoLoader.getDataListJustForAdapter();
                    RecyclerView.a adapter = bVar.getRecyclerView().getAdapter();
                    if (!(adapter instanceof WxRecyclerAdapter)) {
                        adapter = null;
                    }
                    WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
                    if (wxRecyclerAdapter != null) {
                        i2 = wxRecyclerAdapter.RqM.size();
                    } else {
                        i2 = 0;
                    }
                    testPreloadPreview.a(dataListJustForAdapter, i2, this.tCD, d2.tId, -1);
                }
            }
        }
        com.tencent.mm.plugin.finder.feed.model.d dcW = dcW();
        int i4 = this.uLZ ? 1 : 2;
        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uMk);
        if (!(fH == null || (dIx = fH.dIx()) == null)) {
            i3 = dIx.tCE;
        }
        dcW.a(i4, i3, new l(this));
        AppMethodBeat.o(248571);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onAttach$2", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
    public static final class k implements k.b {
        final /* synthetic */ f uMn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(f fVar) {
            this.uMn = fVar;
        }

        @Override // com.tencent.mm.plugin.finder.video.k.b
        public final RecyclerView dch() {
            AppMethodBeat.i(248558);
            RecyclerView recyclerView = f.a(this.uMn).getRecyclerView();
            AppMethodBeat.o(248558);
            return recyclerView;
        }

        @Override // com.tencent.mm.plugin.finder.video.k.b
        public final DataBuffer<bo> dci() {
            AppMethodBeat.i(248559);
            DataBuffer<bo> dataListJustForAdapter = f.d(this.uMn).getDataListJustForAdapter();
            AppMethodBeat.o(248559);
            return dataListJustForAdapter;
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final h.b dko() {
        AppMethodBeat.i(248573);
        h.b bVar = this.uLW;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        AppMethodBeat.o(248573);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(248574);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MA = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uMk).get(FinderReporterUIC.class)).MA(-1);
        if (MA != null) {
            MA.b(this);
            MA.b(dcW());
        }
        BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        if (this.uLW == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        baseMegaVideoLoader.unregister(this.tMe);
        dcW().onDetach();
        AppMethodBeat.o(248574);
    }

    private void dcb() {
        AppMethodBeat.i(248575);
        if (this.uLW == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        baseMegaVideoLoader.register(this.tMe);
        h.b bVar = this.uLW;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        BaseMegaVideoLoader baseMegaVideoLoader2 = this.uLF;
        if (baseMegaVideoLoader2 == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        bVar.ab(baseMegaVideoLoader2.getDataListJustForAdapter());
        AppMethodBeat.o(248575);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final void a(com.tencent.mm.plugin.finder.megavideo.multitask.a aVar, cnu cnu, boolean z) {
        AppMethodBeat.i(248576);
        kotlin.g.b.p.h(aVar, "multiTaskHelper");
        kotlin.g.b.p.h(cnu, "info");
        this.uLY = cnu;
        this.uLX = aVar;
        this.uMa = z;
        f fVar = this;
        com.tencent.mm.plugin.multitask.a.a aVar2 = aVar.Aak;
        if (!(aVar2 instanceof com.tencent.mm.plugin.finder.megavideo.multitask.b)) {
            aVar2 = null;
        }
        com.tencent.mm.plugin.finder.megavideo.multitask.b bVar = (com.tencent.mm.plugin.finder.megavideo.multitask.b) aVar2;
        if (bVar != null) {
            bVar.uKk = fVar;
        }
        aVar.uKk = fVar;
        AppMethodBeat.o(248576);
    }

    public static /* synthetic */ void a(f fVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(248578);
        fVar.a(bmVar, hVar, i2, false, false);
        AppMethodBeat.o(248578);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x013d, code lost:
        if (r0 != false) goto L_0x013f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.finder.model.bm r9, com.tencent.mm.view.recyclerview.h r10, int r11, boolean r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.ui.f.a(com.tencent.mm.plugin.finder.model.bm, com.tencent.mm.view.recyclerview.h, int, boolean, boolean):void");
    }

    public final kotlin.o<Boolean, Boolean> O(boolean z, boolean z2) {
        AppMethodBeat.i(248579);
        h.b bVar = this.uLW;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar.getRecyclerView();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(248579);
            throw tVar;
        }
        RecyclerView.v ch = recyclerView.ch(((LinearLayoutManager) layoutManager).ks());
        if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
            ch = null;
        }
        com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
        if (hVar != null) {
            Object hgv = hVar.hgv();
            if ((hgv instanceof bm) && (((bm) hgv).uOU || z2 || this.uMa)) {
                FinderVideoLayout finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd);
                a((bm) hgv, hVar, finderVideoLayout != null ? finderVideoLayout.getCurrentPosSec() : 0, true, z);
                kotlin.o<Boolean, Boolean> oVar = new kotlin.o<>(Boolean.TRUE, Boolean.valueOf(((bm) hgv).uOT));
                AppMethodBeat.o(248579);
                return oVar;
            }
        }
        Boolean bool = Boolean.FALSE;
        kotlin.o<Boolean, Boolean> oVar2 = new kotlin.o<>(bool, bool);
        AppMethodBeat.o(248579);
        return oVar2;
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final void nI(boolean z) {
        boolean z2;
        bbn bbn;
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(248580);
        Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = ".concat(String.valueOf(z)));
        if (this.uMi == z) {
            AppMethodBeat.o(248580);
            return;
        }
        this.uMi = z;
        h.b bVar = this.uLW;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        RecyclerView.LayoutManager layoutManager = bVar.getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof FinderLinearLayoutManager)) {
            layoutManager = null;
        }
        FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
        if (finderLinearLayoutManager != null) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            finderLinearLayoutManager.wtl = z2;
            int ks = finderLinearLayoutManager.ks();
            Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = " + z + ", firstIndex = " + ks);
            h.b bVar2 = this.uLW;
            if (bVar2 == null) {
                kotlin.g.b.p.btv("viewCallback");
            }
            RecyclerView.v cg = bVar2.getRecyclerView().cg(ks);
            if (!(cg instanceof com.tencent.mm.view.recyclerview.h)) {
                cg = null;
            }
            com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) cg;
            if (hVar != null) {
                a.C1214a aVar = com.tencent.mm.plugin.finder.megavideo.convert.a.uKl;
                kotlin.g.b.p.h(hVar, "holder");
                if (z) {
                    View Mn = hVar.Mn(R.id.fd_);
                    kotlin.g.b.p.g(Mn, "holder.getView<View>(R.id.menu_layout)");
                    Mn.setVisibility(8);
                    View Mn2 = hVar.Mn(R.id.bn9);
                    kotlin.g.b.p.g(Mn2, "holder.getView<View>(R.id.description_tv)");
                    Mn2.setVisibility(8);
                    View Mn3 = hVar.Mn(R.id.jj5);
                    kotlin.g.b.p.g(Mn3, "holder.getView<View>(R.id.warn_layout)");
                    Mn3.setVisibility(8);
                    View Mn4 = hVar.Mn(R.id.fcd);
                    kotlin.g.b.p.g(Mn4, "holder.getView<View>(R.id.mega_video_op_layout)");
                    Mn4.setVisibility(8);
                    View Mn5 = hVar.Mn(R.id.izw);
                    kotlin.g.b.p.g(Mn5, "holder.getView<View>(R.id.unfold_video_button)");
                    Mn5.setVisibility(8);
                    View Mn6 = hVar.Mn(R.id.d7g);
                    kotlin.g.b.p.g(Mn6, "holder.getView<View>(R.id.fold_video_button)");
                    Mn6.setVisibility(0);
                    View Mn7 = hVar.Mn(R.id.d8j);
                    kotlin.g.b.p.g(Mn7, "holder.getView<View>(R.id.footer_layout)");
                    Mn7.setVisibility(0);
                    ((LinearLayout) hVar.Mn(R.id.dof)).setPadding(0, 0, 0, 0);
                    if (ao.aQ(hVar.getContext())) {
                        View Mn8 = hVar.Mn(R.id.fce);
                        int aP = ao.aP(hVar.getContext());
                        kotlin.g.b.p.g(Mn8, LocaleUtil.ITALIAN);
                        Mn8.setPadding(aP, Mn8.getPaddingTop(), 0, Mn8.getPaddingBottom());
                    }
                } else {
                    View Mn9 = hVar.Mn(R.id.d8j);
                    kotlin.g.b.p.g(Mn9, "holder.getView<View>(R.id.footer_layout)");
                    if (Mn9.getVisibility() == 0) {
                        View Mn10 = hVar.Mn(R.id.fd_);
                        kotlin.g.b.p.g(Mn10, "holder.getView<View>(R.id.menu_layout)");
                        Mn10.setVisibility(0);
                        View Mn11 = hVar.Mn(R.id.izw);
                        kotlin.g.b.p.g(Mn11, "holder.getView<View>(R.id.unfold_video_button)");
                        Mn11.setVisibility(0);
                    } else {
                        View Mn12 = hVar.Mn(R.id.fd_);
                        kotlin.g.b.p.g(Mn12, "holder.getView<View>(R.id.menu_layout)");
                        Mn12.setVisibility(8);
                        View Mn13 = hVar.Mn(R.id.izw);
                        kotlin.g.b.p.g(Mn13, "holder.getView<View>(R.id.unfold_video_button)");
                        Mn13.setVisibility(8);
                    }
                    View Mn14 = hVar.Mn(R.id.bn9);
                    kotlin.g.b.p.g(Mn14, "holder.getView<View>(R.id.description_tv)");
                    Mn14.setVisibility(0);
                    TextView textView = (TextView) hVar.Mn(R.id.jj8);
                    kotlin.g.b.p.g(textView, "this");
                    if (!TextUtils.isEmpty(textView.getText())) {
                        View Mn15 = hVar.Mn(R.id.jj5);
                        kotlin.g.b.p.g(Mn15, "holder.getView<View>(R.id.warn_layout)");
                        Mn15.setVisibility(0);
                    }
                    View Mn16 = hVar.Mn(R.id.fcd);
                    kotlin.g.b.p.g(Mn16, "holder.getView<View>(R.id.mega_video_op_layout)");
                    Mn16.setVisibility(0);
                    View Mn17 = hVar.Mn(R.id.d7g);
                    kotlin.g.b.p.g(Mn17, "holder.getView<View>(R.id.fold_video_button)");
                    Mn17.setVisibility(8);
                    Context context = hVar.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    ((LinearLayout) hVar.Mn(R.id.dof)).setPadding(0, context.getResources().getDimensionPixelOffset(R.dimen.cm), 0, 0);
                    View Mn18 = hVar.Mn(R.id.fce);
                    kotlin.g.b.p.g(Mn18, LocaleUtil.ITALIAN);
                    Mn18.setPadding(0, Mn18.getPaddingTop(), 0, Mn18.getPaddingBottom());
                    Context context2 = hVar.getContext();
                    if (context2 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(248580);
                        throw tVar;
                    }
                    Window window = ((Activity) context2).getWindow();
                    kotlin.g.b.p.g(window, "(holder.context as Activity).window");
                    View decorView = window.getDecorView();
                    kotlin.g.b.p.g(decorView, "(holder.context as Activity).window.decorView");
                    Context context3 = hVar.getContext();
                    if (context3 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(248580);
                        throw tVar2;
                    }
                    Window window2 = ((Activity) context3).getWindow();
                    kotlin.g.b.p.g(window2, "(holder.context as Activity).window");
                    View decorView2 = window2.getDecorView();
                    kotlin.g.b.p.g(decorView2, "(holder.context as Activity).window.decorView");
                    decorView.setSystemUiVisibility(decorView2.getSystemUiVisibility() & -2055);
                }
                a.C1214a.p(hVar);
                FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
                BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
                if (baseMegaVideoLoader == null) {
                    kotlin.g.b.p.btv("feedLoader");
                }
                Object obj = baseMegaVideoLoader.getDataList().get(ks);
                if (obj == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
                    AppMethodBeat.o(248580);
                    throw tVar3;
                }
                bm bmVar = (bm) obj;
                cjl cjl = (cjl) kotlin.a.j.kt(bmVar.dkV());
                if (cjl == null) {
                    Log.e("FinderLongVideoTLPresenter", "onConfigurationChanged: mega video media is null, id = " + bmVar.lT());
                    AppMethodBeat.o(248580);
                    return;
                }
                y yVar = y.vXH;
                r<Integer, Integer, Integer> a2 = y.a(this.uMk, cjl.width, cjl.height);
                int intValue = a2.second.intValue();
                int intValue2 = a2.SWY.intValue();
                Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: resize width = " + intValue + ", height = " + intValue2 + ", firstIndex = " + ks);
                ViewGroup.LayoutParams layoutParams = finderMediaBanner.getPagerView().getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(intValue, intValue2);
                }
                layoutParams.width = intValue;
                layoutParams.height = intValue2;
                FinderVideoLayout finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd);
                com.tencent.mm.plugin.finder.video.r videoView = finderVideoLayout != null ? finderVideoLayout.getVideoView() : null;
                if (!(videoView instanceof View)) {
                    videoView = null;
                }
                View view = (View) videoView;
                if (view != null) {
                    view.getLayoutParams().width = intValue;
                    view.getLayoutParams().height = intValue2;
                    if (view instanceof FinderThumbPlayerProxy) {
                        FinderThumbPlayerProxy finderThumbPlayerProxy = (FinderThumbPlayerProxy) view;
                        MMThumbPlayerTextureView mMThumbPlayerTextureView = finderThumbPlayerProxy.wdE;
                        if (mMThumbPlayerTextureView == null) {
                            kotlin.g.b.p.btv("textureView");
                        }
                        mMThumbPlayerTextureView.getLayoutParams().width = intValue;
                        MMThumbPlayerTextureView mMThumbPlayerTextureView2 = finderThumbPlayerProxy.wdE;
                        if (mMThumbPlayerTextureView2 == null) {
                            kotlin.g.b.p.btv("textureView");
                        }
                        mMThumbPlayerTextureView2.getLayoutParams().height = intValue2;
                        MMThumbPlayerTextureView mMThumbPlayerTextureView3 = finderThumbPlayerProxy.wdE;
                        if (mMThumbPlayerTextureView3 == null) {
                            kotlin.g.b.p.btv("textureView");
                        }
                        mMThumbPlayerTextureView3.jk(intValue, intValue2);
                        MMThumbPlayerTextureView mMThumbPlayerTextureView4 = finderThumbPlayerProxy.wdE;
                        if (mMThumbPlayerTextureView4 == null) {
                            kotlin.g.b.p.btv("textureView");
                        }
                        mMThumbPlayerTextureView4.requestLayout();
                    }
                }
                finderMediaBanner.requestLayout();
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uMk);
                if (fH != null) {
                    bbn = fH.dIx();
                } else {
                    bbn = null;
                }
                af afVar = af.viA;
                String zs = com.tencent.mm.ac.d.zs(bmVar.dkW());
                String zs2 = com.tencent.mm.ac.d.zs(bmVar.lT());
                int i2 = z ? 1 : 2;
                if (bbn == null || (str = bbn.sessionId) == null) {
                    str = "";
                }
                if (bbn == null || (str2 = bbn.sGQ) == null) {
                    str2 = "";
                }
                if (bbn == null || (str3 = bbn.sGE) == null) {
                    str3 = "";
                }
                af.a(zs, zs2, 2, i2, str, str2, str3);
                AppMethodBeat.o(248580);
                return;
            }
            AppMethodBeat.o(248580);
            return;
        }
        AppMethodBeat.o(248580);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final void requestRefresh() {
        AppMethodBeat.i(248581);
        BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        baseMegaVideoLoader.requestRefresh();
        AppMethodBeat.o(248581);
    }

    private void boE() {
        AppMethodBeat.i(248582);
        BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        baseMegaVideoLoader.requestLoadMore();
        this.tSn = true;
        AppMethodBeat.o(248582);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final void dcp() {
        AppMethodBeat.i(248583);
        BaseMegaVideoLoader baseMegaVideoLoader = this.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        BaseFeedLoader.requestInit$default(baseMegaVideoLoader, false, 1, null);
        AppMethodBeat.o(248583);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final boolean nJ(boolean z) {
        boolean z2;
        AppMethodBeat.i(248584);
        kotlin.o<Boolean, Boolean> O = O(true, false);
        boolean booleanValue = O.first.booleanValue();
        boolean booleanValue2 = O.second.booleanValue();
        if (booleanValue || this.uMa) {
            com.tencent.mm.plugin.finder.megavideo.multitask.a aVar = this.uLX;
            if (aVar == null) {
                kotlin.g.b.p.btv("multiTaskHelper");
            }
            z2 = aVar.O(z ? 1 : 2, booleanValue2);
        } else {
            z2 = false;
        }
        if (!z2 || !this.uMa) {
            AppMethodBeat.o(248584);
            return false;
        }
        AppMethodBeat.o(248584);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class g implements o.f {
        final /* synthetic */ f uMn;
        final /* synthetic */ bm uMq;

        public g(f fVar, bm bmVar) {
            this.uMn = fVar;
            this.uMq = bmVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00f8  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0070  */
        @Override // com.tencent.mm.ui.base.o.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m r12) {
            /*
            // Method dump skipped, instructions count: 259
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.ui.f.g.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class h implements o.f {
        final /* synthetic */ f uMn;
        final /* synthetic */ bm uMq;

        public h(f fVar, bm bmVar) {
            this.uMn = fVar;
            this.uMq = bmVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(248549);
            mVar.b(this.uMn.uMf, this.uMn.uMk.getString(R.string.bx1), R.raw.icons_outlined_multitask);
            y yVar = y.vXH;
            if (y.b(this.uMq)) {
                mVar.aS(this.uMn.jUx, R.string.tf, R.raw.icons_outlined_delete);
                com.tencent.mm.plugin.finder.utils.q qVar = com.tencent.mm.plugin.finder.utils.q.vWb;
                kotlin.g.b.p.g(mVar, "menu");
                kotlin.a.j.kt(this.uMq.dkV());
                com.tencent.mm.plugin.finder.utils.q.a(mVar, this.uMn.uMk, this.uMn.tPB, this.uMn.tPA, this.uMq.isPrivate(), this.uMq.dkZ());
                AppMethodBeat.o(248549);
                return;
            }
            mVar.b(this.uMn.pMa, this.uMn.uMk.getString(R.string.f3g), R.raw.icons_outlined_report_problem);
            AppMethodBeat.o(248549);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class i implements o.g {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ f uMn;
        final /* synthetic */ bm uMq;

        i(f fVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uMn = fVar;
            this.uMq = bmVar;
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            int i3 = 0;
            AppMethodBeat.i(248554);
            kotlin.g.b.p.h(menuItem, "menuItem");
            Log.i("FinderLongVideoTLPresenter", "[getMoreMenuItemSelectedListener] feed " + this.uMq + ' ' + i2 + " menuItem:" + menuItem.getItemId());
            int itemId = menuItem.getItemId();
            if (itemId == this.uMn.tqv) {
                s.a aVar = s.vWt;
                AppCompatActivity appCompatActivity = this.uMn.uMk;
                FinderItem.a aVar2 = FinderItem.Companion;
                s.a.a(aVar, appCompatActivity, FinderItem.a.a(this.uMq.getFeedObject(), 32768), 3, 4);
                AppMethodBeat.o(248554);
            } else if (itemId == this.uMn.pLU) {
                s.a aVar3 = s.vWt;
                AppCompatActivity appCompatActivity2 = this.uMn.uMk;
                FinderItem.a aVar4 = FinderItem.Companion;
                s.a.a(appCompatActivity2, new ad(FinderItem.a.a(this.uMq.getFeedObject(), 32768)), 2, 0, 20);
                AppMethodBeat.o(248554);
            } else if (itemId == this.uMn.jUx) {
                com.tencent.mm.ui.base.h.a(this.uMn.uMk, (int) R.string.cl_, 0, new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.megavideo.ui.f.i.AnonymousClass1 */
                    final /* synthetic */ i uMr;

                    {
                        this.uMr = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(248552);
                        String aUg = z.aUg();
                        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                        cng cng = this.uMr.uMq.tuP;
                        if (cng == null) {
                            cng = new cng();
                        }
                        final av avVar = new av(aUg, cng);
                        Dialog dialog = this.uMr.uMn.tipDialog;
                        if (dialog != null) {
                            dialog.show();
                        } else {
                            f fVar = this.uMr.uMn;
                            fVar.uMk.getString(R.string.zb);
                            fVar.tipDialog = com.tencent.mm.ui.base.h.a((Context) fVar.uMk, fVar.uMk.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.uMs);
                        }
                        com.tencent.mm.kernel.g.azz().a(avVar.getType(), new com.tencent.mm.ak.i(this) {
                            /* class com.tencent.mm.plugin.finder.megavideo.ui.f.i.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 uMt;

                            {
                                this.uMt = r1;
                            }

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                                AppMethodBeat.i(248551);
                                if ((qVar instanceof av) && ((av) qVar).hFK == avVar.hFK) {
                                    com.tencent.mm.kernel.g.azz().b(avVar.getType(), this);
                                    if (!(i2 == 0 && i3 == 0)) {
                                        u.makeText(this.uMt.uMr.uMn.uMk, (int) R.string.d6k, 0).show();
                                    }
                                }
                                Dialog dialog = this.uMt.uMr.uMn.tipDialog;
                                if (dialog != null) {
                                    dialog.dismiss();
                                    AppMethodBeat.o(248551);
                                    return;
                                }
                                AppMethodBeat.o(248551);
                            }
                        });
                        com.tencent.mm.kernel.g.azz().b(avVar);
                        AppMethodBeat.o(248552);
                    }

                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
                    /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.f$i$1$a */
                    static final class a implements DialogInterface.OnCancelListener {
                        public static final a uMs = new a();

                        static {
                            AppMethodBeat.i(248550);
                            AppMethodBeat.o(248550);
                        }

                        a() {
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(248554);
            } else if (itemId == this.uMn.tPB) {
                e.a aVar5 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                e.a.j(this.uMq.getFeedObject());
                com.tencent.mm.plugin.finder.utils.q qVar = com.tencent.mm.plugin.finder.utils.q.vWb;
                com.tencent.mm.plugin.finder.utils.q.a((Context) this.uMn.uMk, this.uMq.lT(), this.uMq.dkW(), this.uMq.dkX(), false);
                AppMethodBeat.o(248554);
            } else if (itemId == this.uMn.tPA) {
                e.a aVar6 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                e.a.j(this.uMq.getFeedObject());
                com.tencent.mm.ui.base.h.a(this.uMn.uMk, (int) R.string.d90, 0, new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.megavideo.ui.f.i.AnonymousClass2 */
                    final /* synthetic */ i uMr;

                    {
                        this.uMr = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(248553);
                        com.tencent.mm.plugin.finder.utils.q qVar = com.tencent.mm.plugin.finder.utils.q.vWb;
                        com.tencent.mm.plugin.finder.utils.q.a((Context) this.uMr.uMn.uMk, this.uMr.uMq.lT(), this.uMr.uMq.dkW(), this.uMr.uMq.dkX(), true);
                        AppMethodBeat.o(248553);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(248554);
            } else if (itemId == this.uMn.pMa) {
                com.tencent.mm.plugin.finder.feed.logic.a aVar7 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                com.tencent.mm.plugin.finder.feed.logic.a.a(this.uMn.uMk, this.uMq.lT(), 0, 0, 12);
                AppMethodBeat.o(248554);
            } else {
                if (itemId == this.uMn.uMf) {
                    FinderVideoLayout finderVideoLayout = (FinderVideoLayout) this.qhp.Mn(R.id.ckd);
                    if (finderVideoLayout != null) {
                        i3 = finderVideoLayout.getCurrentPosSec();
                    }
                    f.a(this.uMn, this.uMq, this.qhp, i3);
                }
                AppMethodBeat.o(248554);
            }
        }
    }

    public final o.g a(bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(248585);
        kotlin.g.b.p.h(bmVar, "feed");
        kotlin.g.b.p.h(hVar, "holder");
        i iVar = new i(this, bmVar, hVar);
        AppMethodBeat.o(248585);
        return iVar;
    }

    public final MMFragmentActivity dcl() {
        AppMethodBeat.i(248586);
        AppCompatActivity appCompatActivity = this.uMk;
        if (appCompatActivity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(248586);
            throw tVar;
        }
        MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) appCompatActivity;
        AppMethodBeat.o(248586);
        return mMFragmentActivity;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class p implements Runnable {
        final /* synthetic */ f uMn;

        p(f fVar) {
            this.uMn = fVar;
        }

        public final void run() {
            AppMethodBeat.i(248565);
            FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.uMn.tCD.weS;
            if (finderVideoAutoPlayManager != null) {
                finderVideoAutoPlayManager.awI("FinderLongVideoTLPresenter");
                AppMethodBeat.o(248565);
                return;
            }
            AppMethodBeat.o(248565);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.a
    public final void dkp() {
        AppMethodBeat.i(248587);
        h.b bVar = this.uLW;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        bVar.getRecyclerView().post(new p(this));
        AppMethodBeat.o(248587);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d> {
        final /* synthetic */ f uMn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar) {
            super(0);
            this.uMn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.d invoke() {
            AppMethodBeat.i(248545);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.d dVar = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.uMn.uMk).get(FinderCommentPreloaderUIC.class)).tLy;
            AppMethodBeat.o(248545);
            return dVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Integer> {
        public static final b uMo = new b();

        static {
            AppMethodBeat.i(248542);
            AppMethodBeat.o(248542);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(248541);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            Integer valueOf = Integer.valueOf(com.tencent.mm.plugin.finder.storage.c.dxi().value().intValue());
            AppMethodBeat.o(248541);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.f$f  reason: collision with other inner class name */
    static final class C1233f extends q implements kotlin.g.a.a<Integer> {
        public static final C1233f uMp = new C1233f();

        static {
            AppMethodBeat.i(248547);
            AppMethodBeat.o(248547);
        }

        C1233f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(248546);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            Integer valueOf = Integer.valueOf(com.tencent.mm.plugin.finder.storage.c.dxj().value().intValue());
            AppMethodBeat.o(248546);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uMn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(f fVar) {
            super(0);
            this.uMn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int kt;
            AppMethodBeat.i(248562);
            RecyclerView recyclerView = f.a(this.uMn).getRecyclerView();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null && (kt = linearLayoutManager.kt()) >= 0) {
                Log.i("FinderLongVideoTLPresenter", "onEventHappen: scroll to position = " + (kt + 1));
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(kt + 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onEventHappen$2", "invoke", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onEventHappen$2", "invoke", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248562);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onEventHappen$3$1"})
    static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uMn;
        final /* synthetic */ com.tencent.mm.plugin.finder.event.base.b uMw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(f fVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            super(0);
            this.uMn = fVar;
            this.uMw = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248561);
            this.uMn.O(false, false);
            x xVar = x.SXb;
            AppMethodBeat.o(248561);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uMn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.uMn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248543);
            com.tencent.mm.plugin.finder.megavideo.multitask.a aVar = this.uMn.uLX;
            if (aVar == null) {
                kotlin.g.b.p.btv("multiTaskHelper");
            }
            aVar.ic(true);
            x xVar = x.SXb;
            AppMethodBeat.o(248543);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
    static final class o extends q implements kotlin.g.a.a<Paint> {
        public static final o uMx = new o();

        static {
            AppMethodBeat.i(248564);
            AppMethodBeat.o(248564);
        }

        o() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Paint invoke() {
            AppMethodBeat.i(248563);
            Paint paint = new Paint();
            AppMethodBeat.o(248563);
            return paint;
        }
    }

    public static final /* synthetic */ void o(f fVar) {
        AppMethodBeat.i(248592);
        BaseMegaVideoLoader baseMegaVideoLoader = fVar.uLF;
        if (baseMegaVideoLoader == null) {
            kotlin.g.b.p.btv("feedLoader");
        }
        if (baseMegaVideoLoader.getDataListJustForAdapter().size() == 0) {
            fVar.uMk.finish();
        }
        AppMethodBeat.o(248592);
    }
}
