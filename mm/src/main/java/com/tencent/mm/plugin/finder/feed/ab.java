package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.ah;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract;", "", "()V", "IProfileTimelinePresenter", "ProfileTimelinePresenter", "ProfileTimelineViewCallback", "plugin-finder_release"})
public final class ab {
    public static final ab tPv = new ab();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getDataIndex", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "removeDataAt", "", FirebaseAnalytics.b.INDEX, "plugin-finder_release"})
    public interface a {
        ArrayList<bo> dcH();

        int l(BaseFinderFeed baseFinderFeed);
    }

    static {
        AppMethodBeat.i(165796);
        AppMethodBeat.o(165796);
    }

    private ab() {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002/8\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005B/\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020[J\u0006\u0010\\\u001a\u00020]J\b\u0010^\u001a\u00020\bH\u0016J\b\u0010_\u001a\u00020\nH\u0016J\u0018\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010f\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0016J\u0010\u0010g\u001a\u00020\u00132\u0006\u0010b\u001a\u00020cH\u0016J\u0010\u0010h\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010iH\u0016J\b\u0010k\u001a\u00020BH\u0016J\b\u0010l\u001a\u00020BH\u0016J\u0010\u0010m\u001a\u00020n2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010o\u001a\u00020VH\u0016J\u0018\u0010p\u001a\u00020]2\u0006\u0010q\u001a\u00020r2\u0006\u0010b\u001a\u00020cH\u0003J \u0010s\u001a\u00020]2\u0006\u0010q\u001a\u00020r2\u0006\u0010b\u001a\u00020c2\u0006\u0010\u0007\u001a\u00020tH\u0002J\u0018\u0010u\u001a\u00020]2\u0006\u0010v\u001a\u00020\u00132\b\b\u0002\u0010w\u001a\u00020xJ\b\u0010y\u001a\u00020]H\u0002J\b\u0010z\u001a\u00020\u000eH\u0016J\u0010\u0010{\u001a\u00020]2\u0006\u0010|\u001a\u00020\u0006H\u0016J\u0010\u0010}\u001a\u00020]2\u0006\u0010~\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u00020]H\u0016J'\u0010\u0001\u001a\u00020]2\u0007\u0010b\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u000e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001a\u0010\u0001\u001a\u00020]2\u0006\u0010b\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J%\u0010\u0001\u001a\u00020]2\u0007\u0010b\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J5\u0010\u0001\u001a\u00020]2\u0006\u0010b\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J*\u0010\u0001\u001a\u00020]2\u0006\u0010b\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u000eJ\u0007\u0010\u0001\u001a\u00020]J\u0007\u0010\u0001\u001a\u00020]J\u0012\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u0013H\u0016J\u0007\u0010\u0001\u001a\u00020]J\u0012\u0010\u0001\u001a\u00020]2\u0007\u0010b\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020]2\u0006\u0010b\u001a\u00020cH\u0016R\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0010\u0010.\u001a\u00020/X\u0004¢\u0006\u0004\n\u0002\u00100R\u001b\u00101\u001a\u0002028FX\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u0010\u00107\u001a\u000208X\u0004¢\u0006\u0004\n\u0002\u00109R\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060@X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0002¢\u0006\f\n\u0004\bE\u00106\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020VX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", ch.COL_USERNAME, "", "selfFlag", "", "topicId", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;ZJ)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_REPRINT", "MENU_ID_SET_CANCEL_STICKY", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SET_STICKY", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "scene", "getSelfFlag", "()Z", "stickyComponent", "Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getTopicId", "()J", "getUsername", "()Ljava/lang/String;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLikeLocalFeed", "isPrivate", "onUIPause", "onUIResume", "removeDataAt", FirebaseAnalytics.b.INDEX, "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
    public static final class b implements a, i, com.tencent.mm.plugin.finder.presenter.base.a<c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
        final String TAG = "Finder.ProfileTimelinePresenter";
        boolean dJM;
        public final MMActivity gte;
        final int jUx;
        final int pLU;
        final int pMa;
        int scene;
        final com.tencent.mm.plugin.finder.video.k tCD;
        final int tLD;
        final int tLE;
        final int tLF;
        final int tLG;
        final int tLH;
        final int tLJ;
        final int tLK;
        final int tLL;
        final int tLM;
        private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
        private final com.tencent.mm.plugin.finder.view.e tLT;
        private final com.tencent.mm.plugin.finder.feed.model.d tLy;
        private final com.tencent.mm.plugin.finder.feed.model.f tLz;
        final int tPA;
        final int tPB;
        final int tPC;
        final int tPD;
        private com.tencent.mm.plugin.finder.view.b tPE;
        private final C1120b tPF;
        private final d tPG;
        private final boolean tPH;
        private final kotlin.f tPw = kotlin.g.ah(u.tPT);
        c tPx;
        private final kotlin.f tPy = kotlin.g.ah(new c(this));
        final com.tencent.mm.plugin.finder.feed.component.b tPz;
        Dialog tipDialog;
        final int tqv;
        final long twp;
        final int tzW;
        final String username;

        public final FinderProfileFeedLoader getFeedLoader() {
            AppMethodBeat.i(244071);
            FinderProfileFeedLoader finderProfileFeedLoader = (FinderProfileFeedLoader) this.tPy.getValue();
            AppMethodBeat.o(244071);
            return finderProfileFeedLoader;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class e implements o.f {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;
            final /* synthetic */ com.tencent.mm.ui.widget.a.e tPJ;

            e(b bVar, BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
                this.tPJ = eVar;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lkotlin/Triple;", "", "invoke"})
            static final class a extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, kotlin.x> {
                final /* synthetic */ e tPK;
                final /* synthetic */ com.tencent.mm.ui.base.m tPL;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(e eVar, com.tencent.mm.ui.base.m mVar) {
                    super(1);
                    this.tPK = eVar;
                    this.tPL = mVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ kotlin.x invoke(kotlin.r<? extends String, ? extends String, ? extends String> rVar) {
                    AppMethodBeat.i(165735);
                    kotlin.r<? extends String, ? extends String, ? extends String> rVar2 = rVar;
                    kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                    com.tencent.mm.ui.base.m mVar = this.tPL;
                    kotlin.g.b.p.g(mVar, "menu");
                    mVar.avn().clear();
                    if (!(this.tPK.tEM.feedObject.isOnlySelfSee() || this.tPK.tEM.feedObject.isNotShare())) {
                        this.tPL.a(this.tPK.tPI.pLU, (CharSequence) this.tPK.tPI.gte.getString(R.string.d9p), R.raw.bottomsheet_icon_moment, 0, false);
                    } else {
                        this.tPL.a(this.tPK.tPI.pLU, (CharSequence) rVar2.second, R.raw.bottomsheet_icon_moment, 0, true);
                    }
                    this.tPK.tPJ.fPw();
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(165735);
                    return xVar;
                }
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lkotlin/Triple;", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.ab$b$e$b  reason: collision with other inner class name */
            static final class C1121b extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, kotlin.x> {
                final /* synthetic */ e tPK;
                final /* synthetic */ com.tencent.mm.ui.base.m tPL;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1121b(e eVar, com.tencent.mm.ui.base.m mVar) {
                    super(1);
                    this.tPK = eVar;
                    this.tPL = mVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ kotlin.x invoke(kotlin.r<? extends String, ? extends String, ? extends String> rVar) {
                    AppMethodBeat.i(178253);
                    kotlin.r<? extends String, ? extends String, ? extends String> rVar2 = rVar;
                    kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                    com.tencent.mm.ui.base.m mVar = this.tPL;
                    kotlin.g.b.p.g(mVar, "menu");
                    mVar.avn().clear();
                    if (!(this.tPK.tEM.feedObject.isOnlySelfSee() || this.tPK.tEM.feedObject.isNotShare())) {
                        this.tPL.a(this.tPK.tPI.pLU, (CharSequence) this.tPK.tPI.gte.getString(R.string.d9p), R.raw.bottomsheet_icon_moment, 0, false);
                    } else {
                        this.tPL.a(this.tPK.tPI.pLU, (CharSequence) rVar2.second, R.raw.bottomsheet_icon_moment, 0, true);
                    }
                    this.tPK.tPJ.fPw();
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(178253);
                    return xVar;
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:9:0x0108  */
            @Override // com.tencent.mm.ui.base.o.f
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m r14) {
                /*
                // Method dump skipped, instructions count: 813
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.ab.b.e.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
        static final class h extends kotlin.g.b.q implements kotlin.g.a.b<Integer, LinkedList<Long>> {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(b bVar, BaseFinderFeed baseFinderFeed) {
                super(1);
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ LinkedList<Long> invoke(Integer num) {
                String str;
                String str2;
                com.tencent.mm.view.j jVar;
                AppMethodBeat.i(178254);
                int intValue = num.intValue();
                LinkedList linkedList = new LinkedList();
                ArrayList<bo> dcH = this.tPI.dcH();
                if (dcH == null) {
                    kotlin.g.b.p.hyc();
                }
                Iterator<bo> it = dcH.iterator();
                kotlin.g.b.p.g(it, "getFeedList()!!.iterator()");
                int i2 = 0;
                while (it.hasNext()) {
                    bo next = it.next();
                    kotlin.g.b.p.g(next, "iterator.next()");
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
                        if (kotlin.g.b.p.j(str, str2)) {
                            it.remove();
                            linkedList.add(Long.valueOf(((BaseFinderFeed) boVar).feedObject.m21getCreateTime()));
                            c cVar = this.tPI.tPx;
                            if (!(cVar == null || (jVar = cVar.tMe) == null)) {
                                jVar.onItemRangeRemoved(i2, 1);
                            }
                            Log.i(this.tPI.TAG, "[UNINTEREST] removeAt " + i2 + " subType=" + intValue);
                        }
                    }
                    i2++;
                }
                AppMethodBeat.o(178254);
                return linkedList;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
        static final class l extends kotlin.g.b.q implements kotlin.g.a.m<aze, apg, kotlin.x> {
            final /* synthetic */ Context $context;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            l(Context context) {
                super(2);
                this.$context = context;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ kotlin.x invoke(aze aze, apg apg) {
                AppMethodBeat.i(244057);
                kotlin.g.b.p.h(aze, "req");
                kotlin.g.b.p.h(apg, "ret");
                com.tencent.mm.ui.base.u.a(this.$context, this.$context.getString(R.string.d_j), AnonymousClass1.tPO);
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.a(kotlin.a.v.SXr, 2, "", true);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244057);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
        static final class m extends kotlin.g.b.q implements kotlin.g.a.b<Integer, LinkedList<Long>> {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;
            final /* synthetic */ RecyclerView.a tPP;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            m(b bVar, BaseFinderFeed baseFinderFeed, RecyclerView.a aVar) {
                super(1);
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
                this.tPP = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ LinkedList<Long> invoke(Integer num) {
                String str;
                String str2;
                AppMethodBeat.i(178258);
                num.intValue();
                LinkedList linkedList = new LinkedList();
                ArrayList<bo> dcH = this.tPI.dcH();
                if (dcH == null) {
                    kotlin.g.b.p.hyc();
                }
                Iterator<bo> it = dcH.iterator();
                kotlin.g.b.p.g(it, "getFeedList()!!.iterator()");
                int i2 = 0;
                while (it.hasNext()) {
                    bo next = it.next();
                    kotlin.g.b.p.g(next, "iterator.next()");
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
                        if (kotlin.g.b.p.j(str, str2)) {
                            it.remove();
                            linkedList.add(Long.valueOf(((BaseFinderFeed) boVar).feedObject.m21getCreateTime()));
                            RecyclerView.a aVar = this.tPP;
                            if (aVar != null) {
                                aVar.ck(i2);
                            }
                            Log.i("Finder.ProfileTimeLineCovert", "[UNINTEREST] removeAt ".concat(String.valueOf(i2)));
                        }
                    }
                    i2++;
                }
                AppMethodBeat.o(178258);
                return linkedList;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
        static final class r extends kotlin.g.b.q implements kotlin.g.a.m<aze, apg, kotlin.x> {
            final /* synthetic */ Context $context;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            r(Context context) {
                super(2);
                this.$context = context;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ kotlin.x invoke(aze aze, apg apg) {
                AppMethodBeat.i(244064);
                kotlin.g.b.p.h(aze, "req");
                kotlin.g.b.p.h(apg, "ret");
                com.tencent.mm.ui.base.u.a(this.$context, this.$context.getString(R.string.civ), AnonymousClass1.tPR);
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.a(kotlin.a.v.SXr, 2, "", true);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244064);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
        public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, kotlin.x> {
            final /* synthetic */ b tPI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            v(b bVar) {
                super(1);
                this.tPI = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(IResponse<bo> iResponse) {
                View findViewById;
                TextView textView;
                TextView textView2;
                AppMethodBeat.i(244068);
                kotlin.g.b.p.h(iResponse, LocaleUtil.ITALIAN);
                c cVar = this.tPI.tPx;
                if (cVar != null) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout = cVar.tLS;
                    if (refreshLoadMoreLayout == null) {
                        kotlin.g.b.p.btv("rlLayout");
                    }
                    View loadMoreFooter = refreshLoadMoreLayout.getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView2 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    RefreshLoadMoreLayout refreshLoadMoreLayout2 = cVar.tLS;
                    if (refreshLoadMoreLayout2 == null) {
                        kotlin.g.b.p.btv("rlLayout");
                    }
                    View loadMoreFooter2 = refreshLoadMoreLayout2.getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    RefreshLoadMoreLayout refreshLoadMoreLayout3 = cVar.tLS;
                    if (refreshLoadMoreLayout3 == null) {
                        kotlin.g.b.p.btv("rlLayout");
                    }
                    View loadMoreFooter3 = refreshLoadMoreLayout3.getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(244068);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
        public static final class w extends kotlin.g.b.q implements kotlin.g.a.b<Integer, bo> {
            final /* synthetic */ b tPI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            w(b bVar) {
                super(1);
                this.tPI = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ bo invoke(Integer num) {
                bo boVar;
                BaseFinderFeed baseFinderFeed;
                AppMethodBeat.i(244069);
                int intValue = num.intValue();
                if (intValue < 0 || intValue >= this.tPI.getFeedLoader().getDataListJustForAdapter().size()) {
                    AppMethodBeat.o(244069);
                    return null;
                }
                FinderProfileFeedLoader feedLoader = this.tPI.getFeedLoader();
                if (feedLoader != null) {
                    boVar = (bo) feedLoader.get(intValue);
                } else {
                    boVar = null;
                }
                if (boVar instanceof BaseFinderFeed) {
                    baseFinderFeed = (BaseFinderFeed) boVar;
                } else {
                    baseFinderFeed = null;
                }
                BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
                AppMethodBeat.o(244069);
                return baseFinderFeed2;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
        public static final class x extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>> {
            final /* synthetic */ b tPI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            x(b bVar) {
                super(2);
                this.tPI = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
                Integer num3;
                FinderProfileFeedLoader feedLoader;
                DataBuffer dataListJustForAdapter;
                List a2;
                DataBuffer dataListJustForAdapter2;
                AppMethodBeat.i(244070);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                if (intValue >= 0) {
                    FinderProfileFeedLoader feedLoader2 = this.tPI.getFeedLoader();
                    if (feedLoader2 == null || (dataListJustForAdapter2 = feedLoader2.getDataListJustForAdapter()) == null) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(dataListJustForAdapter2.size());
                    }
                    if (!(intValue2 >= num3.intValue() || (feedLoader = this.tPI.getFeedLoader()) == null || (dataListJustForAdapter = feedLoader.getDataListJustForAdapter()) == null || (a2 = kotlin.a.j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                        LinkedList linkedList = new LinkedList(a2);
                        AppMethodBeat.o(244070);
                        return linkedList;
                    }
                }
                AppMethodBeat.o(244070);
                return null;
            }
        }

        public b(MMActivity mMActivity, com.tencent.mm.plugin.finder.view.e eVar, String str, boolean z2, long j2) {
            int i2 = 1;
            kotlin.g.b.p.h(mMActivity, "context");
            kotlin.g.b.p.h(eVar, "drawer");
            kotlin.g.b.p.h(str, ch.COL_USERNAME);
            AppMethodBeat.i(244077);
            this.gte = mMActivity;
            this.tLT = eVar;
            this.username = str;
            this.tPH = z2;
            this.twp = j2;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderCommentPreloaderUIC.class)).tLy;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            this.tLz = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            this.dJM = this.username.equals(com.tencent.mm.model.z.aUg()) && this.tPH;
            this.scene = !this.dJM ? 2 : i2;
            this.tPz = new com.tencent.mm.plugin.finder.feed.component.b();
            this.tLD = 99;
            this.tzW = 100;
            this.pMa = 101;
            this.tqv = 102;
            this.pLU = 103;
            this.tLE = 104;
            this.tLF = 105;
            this.tLG = 106;
            this.tLH = 107;
            this.jUx = 108;
            this.tPA = 109;
            this.tPB = 110;
            this.tPC = 111;
            this.tPD = 112;
            this.tLJ = 113;
            this.tLM = 114;
            this.tLK = 110;
            this.tLL = 111;
            this.tCD = new com.tencent.mm.plugin.finder.video.k();
            this.tPF = new C1120b(this);
            this.tPG = new d(this);
            AppMethodBeat.o(244077);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(c cVar) {
            AppMethodBeat.i(165755);
            a(cVar);
            AppMethodBeat.o(165755);
        }

        @Override // com.tencent.mm.plugin.finder.feed.ab.a
        public final int l(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(165752);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            int indexOf = getFeedLoader().getDataListJustForAdapter().indexOf(baseFinderFeed);
            AppMethodBeat.o(165752);
            return indexOf;
        }

        public final void a(c cVar) {
            int i2;
            FinderProfileFeedLoader finderProfileFeedLoader;
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            TestPreloadPreview testPreloadPreview;
            AppMethodBeat.i(165754);
            kotlin.g.b.p.h(cVar, "callback");
            this.tPx = cVar;
            if (this.tPH) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            FinderProfileFeedLoader feedLoader = getFeedLoader();
            if (!(feedLoader instanceof FinderProfileFeedLoader)) {
                finderProfileFeedLoader = null;
            } else {
                finderProfileFeedLoader = feedLoader;
            }
            if (finderProfileFeedLoader != null) {
                finderProfileFeedLoader.setFetchEndCallback(new v(this));
            }
            EventCenter.instance.add(this.tPF);
            EventCenter.instance.add(this.tPG);
            this.tPE = new com.tencent.mm.plugin.finder.view.b(getFeedLoader());
            com.tencent.mm.plugin.finder.view.b bVar = this.tPE;
            if (bVar != null) {
                bVar.alive();
            }
            com.tencent.mm.plugin.finder.video.k kVar = this.tCD;
            c cVar2 = this.tPx;
            if (cVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            com.tencent.mm.plugin.finder.video.k.a(kVar, cVar2.gte, new t(this), 4);
            MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
            if ((MediaPreloadCore.uTU) && (testPreloadPreview = (TestPreloadPreview) this.gte.findViewById(R.id.ijo)) != null) {
                testPreloadPreview.setVisibility(0);
                DataBuffer<bo> dataListJustForAdapter = getFeedLoader().getDataListJustForAdapter();
                com.tencent.mm.plugin.finder.video.k kVar2 = this.tCD;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
                testPreloadPreview.a(dataListJustForAdapter, 0, kVar2, fH != null ? FinderReporterUIC.a(fH) : null, -1);
            }
            this.tLy.a(this.scene, i2, new w(this));
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (!(fH2 == null || (a3 = FinderReporterUIC.a(fH2)) == null)) {
                a3.a(this.tLy);
            }
            this.tLz.e(new x(this));
            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
            FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this.gte);
            if (!(fH3 == null || (a2 = FinderReporterUIC.a(fH3)) == null)) {
                a2.a(this.tLz);
            }
            com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
            ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(cVar.getRecyclerView());
            AppMethodBeat.o(165754);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final com.tencent.mm.plugin.finder.video.k getVideoCore() {
            return this.tCD;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
        public static final class t implements k.b {
            final /* synthetic */ b tPI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            t(b bVar) {
                this.tPI = bVar;
            }

            @Override // com.tencent.mm.plugin.finder.video.k.b
            public final RecyclerView dch() {
                AppMethodBeat.i(165742);
                c cVar = this.tPI.tPx;
                if (cVar == null) {
                    kotlin.g.b.p.hyc();
                }
                RecyclerView recyclerView = cVar.getRecyclerView();
                AppMethodBeat.o(165742);
                return recyclerView;
            }

            @Override // com.tencent.mm.plugin.finder.video.k.b
            public final DataBuffer<bo> dci() {
                AppMethodBeat.i(244067);
                DataBuffer<bo> dataList = this.tPI.getFeedLoader().getDataList();
                AppMethodBeat.o(244067);
                return dataList;
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final MMActivity getActivity() {
            return this.gte;
        }

        @Override // com.tencent.mm.plugin.finder.feed.ab.a
        public final ArrayList<bo> dcH() {
            AppMethodBeat.i(244072);
            DataBuffer dataListJustForAdapter = getFeedLoader().getDataListJustForAdapter();
            AppMethodBeat.o(244072);
            return dataListJustForAdapter;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final boolean dbZ() {
            return this.dJM;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        public static final class a implements com.tencent.mm.view.recyclerview.f {
            final /* synthetic */ b tPI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.tPI = bVar;
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                AppMethodBeat.i(165729);
                switch (i2) {
                    case 2:
                    case 3001:
                        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.isOtherEnableFullScreenEnjoy()) {
                            com.tencent.mm.plugin.finder.convert.q qVar = new com.tencent.mm.plugin.finder.convert.q(this.tPI, false, 0, 6);
                            AppMethodBeat.o(165729);
                            return qVar;
                        }
                        com.tencent.mm.plugin.finder.convert.u uVar = new com.tencent.mm.plugin.finder.convert.u(this.tPI, false, 0, 6);
                        AppMethodBeat.o(165729);
                        return uVar;
                    case 4:
                    case 3002:
                        com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.isOtherEnableFullScreenEnjoy()) {
                            com.tencent.mm.plugin.finder.convert.t tVar = new com.tencent.mm.plugin.finder.convert.t(this.tPI.tCD, this.tPI, false, 0, 12);
                            AppMethodBeat.o(165729);
                            return tVar;
                        }
                        ak akVar = new ak(this.tPI.tCD, this.tPI, false, 0, 12);
                        AppMethodBeat.o(165729);
                        return akVar;
                    case 9:
                        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.isOtherEnableFullScreenEnjoy()) {
                            com.tencent.mm.plugin.finder.convert.r rVar = new com.tencent.mm.plugin.finder.convert.r(this.tPI.tCD, this.tPI, 0, 0, 28);
                            AppMethodBeat.o(165729);
                            return rVar;
                        }
                        com.tencent.mm.plugin.finder.convert.x xVar = new com.tencent.mm.plugin.finder.convert.x(this.tPI.tCD, this.tPI);
                        AppMethodBeat.o(165729);
                        return xVar;
                    default:
                        com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        com.tencent.mm.plugin.finder.utils.y.dQ(this.tPI.TAG, i2);
                        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                        AppMethodBeat.o(165729);
                        return fVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(165757);
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
            this.tPx = null;
            EventCenter.instance.removeListener(this.tPF);
            EventCenter.instance.removeListener(this.tPG);
            com.tencent.mm.plugin.finder.view.b bVar = this.tPE;
            if (bVar != null) {
                bVar.dead();
                AppMethodBeat.o(165757);
                return;
            }
            AppMethodBeat.o(165757);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ab$b$b  reason: collision with other inner class name */
        public static final class C1120b extends com.tencent.mm.plugin.finder.view.f {
            final /* synthetic */ b tPI;
            private String tag;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1120b(b bVar) {
                this.tPI = bVar;
                AppMethodBeat.i(165733);
                this.tag = bVar.TAG;
                AppMethodBeat.o(165733);
            }

            @Override // com.tencent.mm.plugin.finder.view.f
            public final String getTag() {
                return this.tag;
            }

            @Override // com.tencent.mm.plugin.finder.view.f
            public final FinderItem EB(long j2) {
                RecyclerView recyclerView;
                AppMethodBeat.i(165731);
                c cVar = this.tPI.tPx;
                if (!(cVar == null || (recyclerView = cVar.getRecyclerView()) == null)) {
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (adapter == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                        AppMethodBeat.o(165731);
                        throw tVar;
                    }
                    RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
                    if (vVar != null) {
                        bo boVar = (bo) this.tPI.getFeedLoader().safeGet(vVar.lR());
                        if (boVar instanceof BaseFinderFeed) {
                            FinderItem finderItem = ((BaseFinderFeed) boVar).feedObject;
                            AppMethodBeat.o(165731);
                            return finderItem;
                        }
                    }
                }
                AppMethodBeat.o(165731);
                return null;
            }

            @Override // com.tencent.mm.plugin.finder.view.f
            public final void a(long j2, azt azt) {
                RecyclerView recyclerView;
                AppMethodBeat.i(165732);
                c cVar = this.tPI.tPx;
                if (cVar == null || (recyclerView = cVar.getRecyclerView()) == null) {
                    AppMethodBeat.o(165732);
                    return;
                }
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                    AppMethodBeat.o(165732);
                    throw tVar;
                }
                RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
                if (vVar != null) {
                    int lR = vVar.lR();
                    RecyclerView.a adapter2 = recyclerView.getAdapter();
                    if (adapter2 != null) {
                        adapter2.b(lR, new kotlin.o(1, azt));
                        AppMethodBeat.o(165732);
                        return;
                    }
                    AppMethodBeat.o(165732);
                    return;
                }
                AppMethodBeat.o(165732);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class d extends IListener<hk> {
            final /* synthetic */ b tPI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(b bVar) {
                this.tPI = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(hk hkVar) {
                AppMethodBeat.i(165734);
                hk hkVar2 = hkVar;
                kotlin.g.b.p.h(hkVar2, "event");
                Log.i(this.tPI.TAG, "feedProgressListener localId:" + hkVar2.dLT.localId + ", progress:" + hkVar2.dLT.progress);
                this.tPI.getFeedLoader().updateProgressByLocalId(hkVar2.dLT.localId);
                AppMethodBeat.o(165734);
                return true;
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.f a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
            AppMethodBeat.i(165760);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            kotlin.g.b.p.h(eVar, "sheet");
            e eVar2 = new e(this, baseFinderFeed, eVar);
            AppMethodBeat.o(165760);
            return eVar2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.f i(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(165761);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            f fVar = new f(this, baseFinderFeed);
            AppMethodBeat.o(165761);
            return fVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class f implements o.f {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;

            f(b bVar, BaseFinderFeed baseFinderFeed) {
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                boolean z;
                boolean z2;
                boolean z3 = false;
                AppMethodBeat.i(165737);
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.h(this.tEM) || !this.tPI.dJM) {
                    com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!com.tencent.mm.plugin.finder.utils.y.h(this.tEM)) {
                        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.C(this.tEM.feedObject)) {
                            int i2 = this.tPI.tLJ;
                            com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                            String x = com.tencent.mm.plugin.finder.utils.y.x(this.tEM);
                            if (!this.tEM.feedObject.isPostFinish() || this.tEM.feedObject.isPostFailed()) {
                                z3 = true;
                            }
                            mVar.a(i2, x, R.raw.finder_bgm_gif_first_page, z3);
                        }
                        mVar.aS(this.tPI.pMa, R.string.f3g, R.raw.icons_outlined_report_problem);
                    }
                } else {
                    mVar.aS(this.tPI.jUx, R.string.tf, R.raw.icons_outlined_delete);
                    if (this.tEM.feedObject.isCommentClose()) {
                        mVar.b(this.tPI.tLH, this.tPI.gte.getString(R.string.cnl), R.raw.icons_outlined_comment);
                    } else {
                        mVar.b(this.tPI.tLG, this.tPI.gte.getString(R.string.cmn), R.raw.finder_feed_discomment);
                    }
                    com.tencent.mm.plugin.finder.utils.q qVar = com.tencent.mm.plugin.finder.utils.q.vWb;
                    kotlin.g.b.p.g(mVar, "menu");
                    MMActivity mMActivity = this.tPI.gte;
                    this.tEM.feedObject.getMediaType();
                    int i3 = this.tPI.tPB;
                    int i4 = this.tPI.tPA;
                    if (this.tEM.feedObject.getPrivate_flag() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.plugin.finder.utils.q.a(mVar, mMActivity, i3, i4, z);
                    MMActivity mMActivity2 = this.tPI.gte;
                    int i5 = this.tPI.tPD;
                    int i6 = this.tPI.tPC;
                    if (this.tEM.feedObject.getStickyTime() != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    kotlin.g.b.p.h(mVar, "menu");
                    kotlin.g.b.p.h(mMActivity2, "context");
                    if (z2) {
                        mVar.b(i5, mMActivity2.getString(R.string.ciu), R.raw.icons_outlined_top_off);
                    } else {
                        mVar.b(i6, mMActivity2.getString(R.string.d99), R.raw.icons_outlined_top);
                    }
                    com.tencent.mm.plugin.finder.utils.y yVar5 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (com.tencent.mm.plugin.finder.utils.y.C(this.tEM.feedObject)) {
                        int i7 = this.tPI.tLJ;
                        com.tencent.mm.plugin.finder.utils.y yVar6 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        String x2 = com.tencent.mm.plugin.finder.utils.y.x(this.tEM);
                        if (!this.tEM.feedObject.isPostFinish() || this.tEM.feedObject.isPostFailed()) {
                            z3 = true;
                        }
                        mVar.a(i7, x2, R.raw.finder_bgm_gif_first_page, z3);
                    }
                    com.tencent.mm.plugin.finder.utils.y yVar7 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!com.tencent.mm.plugin.finder.utils.y.isOtherEnableFullScreenEnjoy()) {
                        com.tencent.mm.plugin.finder.utils.y yVar8 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.isAnyEnableFullScreenEnjoy() && (this.tEM.cxn() == 4 || this.tEM.cxn() == 2)) {
                            mVar.b(this.tPI.tLM, this.tPI.gte.getString(R.string.cno), R.raw.finder_icons_outlined_max_window);
                            AppMethodBeat.o(165737);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(165737);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
        static final class g implements o.g {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;

            g(b bVar, BaseFinderFeed baseFinderFeed) {
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                int i3;
                Object[] objArr;
                RecyclerView recyclerView;
                int i4;
                azr azr = null;
                azr azr2 = null;
                bbn bbn = null;
                bbn bbn2 = null;
                r2 = null;
                RecyclerView.a aVar = null;
                byte[] bArr = null;
                boolean z = true;
                AppMethodBeat.i(165738);
                if (!this.tPI.dJM) {
                    b bVar = this.tPI;
                    kotlin.g.b.p.g(menuItem, "menuItem");
                    BaseFinderFeed baseFinderFeed = this.tEM;
                    Log.i(bVar.TAG, "getMoreMenuItemSelectedListener feed " + baseFinderFeed + " menuItem:" + menuItem.getItemId());
                    int itemId = menuItem.getItemId();
                    if (itemId == bVar.tLD) {
                        int indexOf = bVar.getFeedLoader().getDataListJustForAdapter().indexOf(baseFinderFeed);
                        if (indexOf >= 0) {
                            com.tencent.mm.plugin.finder.feed.logic.c cVar = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
                            com.tencent.mm.plugin.finder.feed.logic.c.a(bVar.gte, baseFinderFeed.feedObject.getId(), baseFinderFeed.feedObject.getObjectNonceId(), new h(bVar, baseFinderFeed));
                            AppMethodBeat.o(165738);
                            return;
                        }
                        Log.i(bVar.TAG, "[UNINTEREST] pos error ".concat(String.valueOf(indexOf)));
                        AppMethodBeat.o(165738);
                        return;
                    }
                    if (itemId != bVar.tzW) {
                        if (itemId == bVar.tqv) {
                            s.a.a(com.tencent.mm.plugin.finder.utils.s.vWt, bVar.gte, baseFinderFeed.feedObject, 3, 4);
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.pLU) {
                            s.a aVar2 = com.tencent.mm.plugin.finder.utils.s.vWt;
                            s.a.a(bVar.gte, baseFinderFeed, 0, 0, 28);
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.tLE) {
                            com.tencent.mm.plugin.finder.utils.g gVar = com.tencent.mm.plugin.finder.utils.g.vVq;
                            com.tencent.mm.plugin.finder.utils.g.a(baseFinderFeed, bVar.gte);
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.pMa) {
                            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                            if (com.tencent.mm.plugin.finder.utils.y.w(baseFinderFeed)) {
                                awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
                                if (liveInfo != null) {
                                    long j2 = liveInfo.liveId;
                                    com.tencent.mm.plugin.finder.feed.logic.a aVar3 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                                    com.tencent.mm.plugin.finder.feed.logic.a.b(bVar.gte, j2, baseFinderFeed.feedObject.getUserName());
                                    AppMethodBeat.o(165738);
                                    return;
                                }
                                AppMethodBeat.o(165738);
                                return;
                            }
                            com.tencent.mm.plugin.finder.feed.logic.a aVar4 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                            com.tencent.mm.plugin.finder.feed.logic.a.a(bVar.gte, baseFinderFeed.feedObject.field_id, 0, 0, 12);
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.tLF) {
                            Intent intent = new Intent();
                            FinderObjectDesc finderObjectDesc = baseFinderFeed.feedObject.getFeedObject().objectDesc;
                            intent.putExtra("postRefMediaList", finderObjectDesc != null ? finderObjectDesc.toByteArray() : null);
                            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                            intent.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.y.u(baseFinderFeed).toByteArray());
                            intent.putExtra("postType", baseFinderFeed.feedObject.getMediaType());
                            intent.putExtra("key_finder_post_from", 5);
                            com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
                            com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(bVar.gte, intent);
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.tLH) {
                            ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(baseFinderFeed.feedObject.getId(), baseFinderFeed.feedObject.getFeedObject(), baseFinderFeed.feedObject.getObjectNonceId(), true, new i(bVar));
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.tLG) {
                            ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(baseFinderFeed.feedObject.getId(), baseFinderFeed.feedObject.getFeedObject(), baseFinderFeed.feedObject.getObjectNonceId(), false, new j(bVar));
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.tLJ) {
                            if (baseFinderFeed.feedObject.isPostFinish()) {
                                FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                                FinderReporterUIC fH = FinderReporterUIC.a.fH(bVar.gte);
                                if (fH != null) {
                                    i4 = fH.tCE;
                                } else {
                                    i4 = 0;
                                }
                                if (i4 != 52) {
                                    e.a aVar7 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                                    e.a.n(baseFinderFeed.feedObject);
                                    com.tencent.mm.plugin.finder.utils.w wVar = com.tencent.mm.plugin.finder.utils.w.vXp;
                                    FinderObjectDesc finderObjectDesc2 = baseFinderFeed.feedObject.getFeedObject().objectDesc;
                                    if (finderObjectDesc2 != null) {
                                        azr2 = finderObjectDesc2.feedBgmInfo;
                                    }
                                    com.tencent.mm.plugin.finder.utils.w.a(azr2, Long.valueOf(baseFinderFeed.feedObject.field_id), 0);
                                } else if (bVar.gte instanceof FinderTopicTimelineUI) {
                                    MMActivity mMActivity = bVar.gte;
                                    if (mMActivity == null) {
                                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                                        AppMethodBeat.o(165738);
                                        throw tVar;
                                    }
                                    ((FinderTopicTimelineUI) mMActivity).onBackPressed();
                                }
                                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                                com.tencent.mm.plugin.finder.report.k.a(bVar.gte, 1, 1, Integer.valueOf(baseFinderFeed.feedObject.field_finderObject.follow_feed_count));
                                AppMethodBeat.o(165738);
                                return;
                            }
                        } else if (itemId == bVar.tLK) {
                            aj ajVar = aj.viU;
                            FinderReporterUIC.a aVar8 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(bVar.gte);
                            if (fH2 != null) {
                                bbn = fH2.dIx();
                            }
                            aj.a(bbn, "fav_in_menu", false, baseFinderFeed.lT());
                            com.tencent.mm.ui.base.u.a(bVar.gte, bVar.gte.getResources().getString(R.string.cp8), new y(bVar, baseFinderFeed));
                            AppMethodBeat.o(165738);
                            return;
                        } else if (itemId == bVar.tLL) {
                            aj ajVar2 = aj.viU;
                            FinderReporterUIC.a aVar9 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH3 = FinderReporterUIC.a.fH(bVar.gte);
                            if (fH3 != null) {
                                bbn2 = fH3.dIx();
                            }
                            aj.a(bbn2, "unfav_in_menu", false, baseFinderFeed.lT());
                            com.tencent.mm.ui.base.u.a(bVar.gte, bVar.gte.getResources().getString(R.string.cp7), new z(bVar, baseFinderFeed));
                        }
                    }
                    AppMethodBeat.o(165738);
                    return;
                }
                b bVar2 = this.tPI;
                kotlin.g.b.p.g(menuItem, "menuItem");
                BaseFinderFeed baseFinderFeed2 = this.tEM;
                MMActivity mMActivity2 = this.tPI.gte;
                int itemId2 = menuItem.getItemId();
                if (itemId2 == bVar2.tqv) {
                    s.a aVar10 = com.tencent.mm.plugin.finder.utils.s.vWt;
                    if (mMActivity2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(165738);
                        throw tVar2;
                    }
                    s.a.a(aVar10, mMActivity2, baseFinderFeed2.feedObject, 3, 4);
                    AppMethodBeat.o(165738);
                } else if (itemId2 == bVar2.pLU) {
                    s.a aVar11 = com.tencent.mm.plugin.finder.utils.s.vWt;
                    if (mMActivity2 == null) {
                        kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(165738);
                        throw tVar3;
                    }
                    s.a.a(mMActivity2, baseFinderFeed2, 0, 0, 28);
                    AppMethodBeat.o(165738);
                } else {
                    if (itemId2 == bVar2.jUx) {
                        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.h(baseFinderFeed2) && baseFinderFeed2.feedObject.isPostFinish()) {
                            if (baseFinderFeed2.feedObject.getLongVideoMediaList().isEmpty()) {
                                z = false;
                            }
                            com.tencent.mm.ui.base.h.a(mMActivity2, z ? R.string.cjq : R.string.d6h, 0, new k(bVar2, baseFinderFeed2, mMActivity2), (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(165738);
                            return;
                        }
                    } else if (itemId2 == bVar2.tLD) {
                        if (bVar2.l(baseFinderFeed2) >= 0) {
                            c cVar2 = bVar2.tPx;
                            if (!(cVar2 == null || (recyclerView = cVar2.getRecyclerView()) == null)) {
                                aVar = recyclerView.getAdapter();
                            }
                            com.tencent.mm.plugin.finder.feed.logic.c cVar3 = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
                            com.tencent.mm.plugin.finder.feed.logic.c.a(mMActivity2, baseFinderFeed2.feedObject.getId(), baseFinderFeed2.feedObject.getObjectNonceId(), new m(bVar2, baseFinderFeed2, aVar));
                            AppMethodBeat.o(165738);
                            return;
                        }
                    } else if (itemId2 == bVar2.pMa) {
                        com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        if (com.tencent.mm.plugin.finder.utils.y.w(baseFinderFeed2)) {
                            awe liveInfo2 = baseFinderFeed2.feedObject.getLiveInfo();
                            if (liveInfo2 != null) {
                                long j3 = liveInfo2.liveId;
                                com.tencent.mm.plugin.finder.feed.logic.a aVar12 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                                com.tencent.mm.plugin.finder.feed.logic.a.b(mMActivity2, j3, baseFinderFeed2.feedObject.getUserName());
                                AppMethodBeat.o(165738);
                                return;
                            }
                            AppMethodBeat.o(165738);
                            return;
                        }
                        com.tencent.mm.plugin.finder.feed.logic.a aVar13 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                        com.tencent.mm.plugin.finder.feed.logic.a.a(mMActivity2, baseFinderFeed2.feedObject.field_id, 0, 0, 12);
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tLH) {
                        ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(baseFinderFeed2.feedObject.getId(), baseFinderFeed2.feedObject.getFeedObject(), baseFinderFeed2.feedObject.getObjectNonceId(), true, new n(mMActivity2));
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tLG) {
                        ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(baseFinderFeed2.feedObject.getId(), baseFinderFeed2.feedObject.getFeedObject(), baseFinderFeed2.feedObject.getObjectNonceId(), false, new o(mMActivity2));
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tPB) {
                        com.tencent.mm.plugin.finder.utils.q qVar = com.tencent.mm.plugin.finder.utils.q.vWb;
                        com.tencent.mm.plugin.finder.utils.q.a(mMActivity2, baseFinderFeed2.feedObject, false);
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tPA) {
                        if (baseFinderFeed2.feedObject.getStickyTime() != 0) {
                            com.tencent.mm.ui.base.u.a(mMActivity2, mMActivity2.getString(R.string.d64), p.tPQ);
                            AppMethodBeat.o(165738);
                            return;
                        }
                        if (!baseFinderFeed2.feedObject.getLongVideoMediaList().isEmpty()) {
                            objArr = 1;
                        } else {
                            objArr = null;
                        }
                        if (objArr != null) {
                            com.tencent.mm.ui.base.h.a(mMActivity2, (int) R.string.cjr, 0, new q(mMActivity2, baseFinderFeed2), (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(165738);
                            return;
                        }
                        com.tencent.mm.plugin.finder.utils.q qVar2 = com.tencent.mm.plugin.finder.utils.q.vWb;
                        com.tencent.mm.plugin.finder.utils.q.a(mMActivity2, baseFinderFeed2.feedObject, true);
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tPD) {
                        bVar2.tPz.a(mMActivity2, baseFinderFeed2.feedObject.getId(), false, baseFinderFeed2.feedObject.getObjectNonceId(), new r(mMActivity2));
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tPC) {
                        if (baseFinderFeed2.feedObject.getPrivate_flag() == 1) {
                            com.tencent.mm.ui.base.u.a(MMApplicationContext.getContext(), mMActivity2.getString(R.string.d_i), s.tPS);
                            AppMethodBeat.o(165738);
                            return;
                        }
                        bVar2.tPz.a(mMActivity2, baseFinderFeed2.feedObject.getId(), true, baseFinderFeed2.feedObject.getObjectNonceId(), new l(mMActivity2));
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tLF) {
                        Intent intent2 = new Intent();
                        FinderObjectDesc finderObjectDesc3 = baseFinderFeed2.feedObject.getFeedObject().objectDesc;
                        if (finderObjectDesc3 != null) {
                            bArr = finderObjectDesc3.toByteArray();
                        }
                        intent2.putExtra("postRefMediaList", bArr);
                        com.tencent.mm.plugin.finder.utils.y yVar5 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        intent2.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.y.u(baseFinderFeed2).toByteArray());
                        intent2.putExtra("postType", baseFinderFeed2.feedObject.getMediaType());
                        intent2.putExtra("key_finder_post_from", 5);
                        com.tencent.mm.plugin.finder.utils.a aVar14 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(mMActivity2, intent2);
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tLE) {
                        com.tencent.mm.plugin.finder.utils.g gVar2 = com.tencent.mm.plugin.finder.utils.g.vVq;
                        if (mMActivity2 == null) {
                            kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(165738);
                            throw tVar4;
                        }
                        com.tencent.mm.plugin.finder.utils.g.a(baseFinderFeed2, mMActivity2);
                        AppMethodBeat.o(165738);
                        return;
                    } else if (itemId2 == bVar2.tLJ) {
                        if (baseFinderFeed2.feedObject.isPostFinish()) {
                            FinderReporterUIC.a aVar15 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH4 = FinderReporterUIC.a.fH(mMActivity2);
                            if (fH4 != null) {
                                i3 = fH4.tCE;
                            } else {
                                i3 = 0;
                            }
                            if (i3 != 52) {
                                e.a aVar16 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                                e.a.n(baseFinderFeed2.feedObject);
                                com.tencent.mm.plugin.finder.utils.w wVar2 = com.tencent.mm.plugin.finder.utils.w.vXp;
                                FinderObjectDesc finderObjectDesc4 = baseFinderFeed2.feedObject.getFeedObject().objectDesc;
                                if (finderObjectDesc4 != null) {
                                    azr = finderObjectDesc4.feedBgmInfo;
                                }
                                com.tencent.mm.plugin.finder.utils.w.a(azr, Long.valueOf(baseFinderFeed2.feedObject.field_id), 0);
                            } else if (mMActivity2 instanceof FinderTopicTimelineUI) {
                                ((FinderTopicTimelineUI) mMActivity2).onBackPressed();
                            }
                            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                            com.tencent.mm.plugin.finder.report.k.a(mMActivity2, 1, 1, Integer.valueOf(baseFinderFeed2.feedObject.field_finderObject.follow_feed_count));
                            AppMethodBeat.o(165738);
                            return;
                        }
                    } else if (itemId2 == bVar2.tLM) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("KEY_FROM_SCENE", 1);
                        intent3.putExtra("KEY_USERNAME", com.tencent.mm.model.z.aUg());
                        intent3.putExtra("KEY_FINDER_SELF_FLAG", true);
                        OccupyFinderUI10.a aVar17 = OccupyFinderUI10.udX;
                        intent3.putExtra(OccupyFinderUI10.dez(), true);
                        OccupyFinderUI10.a aVar18 = OccupyFinderUI10.udX;
                        intent3.putExtra(OccupyFinderUI10.deA(), false);
                        com.tencent.mm.plugin.finder.utils.y yVar6 = com.tencent.mm.plugin.finder.utils.y.vXH;
                        com.tencent.mm.plugin.finder.utils.y.a(0, kotlin.a.j.listOf(baseFinderFeed2), (com.tencent.mm.bw.b) null, intent3);
                        com.tencent.mm.plugin.finder.utils.a aVar19 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.ac(mMActivity2, intent3);
                        AppMethodBeat.o(165738);
                        return;
                    } else {
                        Toast.makeText(mMActivity2, (int) R.string.dad, 1).show();
                    }
                    AppMethodBeat.o(165738);
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final o.g j(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(165762);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            g gVar = new g(this, baseFinderFeed);
            AppMethodBeat.o(165762);
            return gVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        public static final class i implements ai<ayy> {
            final /* synthetic */ b tPI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            i(b bVar) {
                this.tPI = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayy ayy, apg apg) {
                AppMethodBeat.i(165740);
                kotlin.g.b.p.h(ayy, "req");
                kotlin.g.b.p.h(apg, "ret");
                if (apg.retCode == 0) {
                    com.tencent.mm.ui.base.u.makeText(this.tPI.gte, (int) R.string.cnn, 0).show();
                    AppMethodBeat.o(165740);
                    return;
                }
                com.tencent.mm.ui.base.u.makeText(this.tPI.gte, (int) R.string.cnm, 0).show();
                Log.i(this.tPI.TAG, "finder_feed_open_comment_no_ok " + apg.retCode);
                AppMethodBeat.o(165740);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        public static final class j implements ai<ayy> {
            final /* synthetic */ b tPI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            j(b bVar) {
                this.tPI = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayy ayy, apg apg) {
                AppMethodBeat.i(165741);
                kotlin.g.b.p.h(ayy, "req");
                kotlin.g.b.p.h(apg, "ret");
                if (apg.retCode == 0) {
                    com.tencent.mm.ui.base.u.makeText(this.tPI.gte, (int) R.string.cmp, 0).show();
                    AppMethodBeat.o(165741);
                    return;
                }
                com.tencent.mm.ui.base.u.makeText(this.tPI.gte, (int) R.string.cmo, 0).show();
                Log.i(this.tPI.TAG, "finder_feed_close_comment_ok " + apg.retCode);
                AppMethodBeat.o(165741);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        static final class y implements u.b {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;

            y(b bVar, BaseFinderFeed baseFinderFeed) {
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                WeImageView weImageView;
                TextView textView;
                AppMethodBeat.i(260233);
                if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                    textView.setTextSize(1, 14.0f);
                }
                if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                    weImageView.setImageResource(R.raw.icons_filled_done);
                    Context context = weImageView.getContext();
                    kotlin.g.b.p.g(context, "context");
                    weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                }
                this.tPI.a(this.tEM.feedObject, true, null);
                AppMethodBeat.o(260233);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        static final class z implements u.b {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;

            z(b bVar, BaseFinderFeed baseFinderFeed) {
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                WeImageView weImageView;
                TextView textView;
                AppMethodBeat.i(260234);
                if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                    textView.setTextSize(1, 14.0f);
                }
                if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                    weImageView.setImageResource(R.raw.icons_filled_done);
                    Context context = weImageView.getContext();
                    kotlin.g.b.p.g(context, "context");
                    weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                }
                this.tPI.a(this.tEM.feedObject, false, null);
                AppMethodBeat.o(260234);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem, boolean z2, com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(244073);
            kotlin.g.b.p.h(finderItem, "feed");
            com.tencent.mm.plugin.finder.model.r rVar = com.tencent.mm.plugin.finder.model.r.uNW;
            com.tencent.mm.plugin.finder.model.r.a(this.gte, finderItem, z2);
            AppMethodBeat.o(244073);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem) {
            AppMethodBeat.i(244074);
            kotlin.g.b.p.h(finderItem, "feed");
            s.a.a(com.tencent.mm.plugin.finder.utils.s.vWt, this.gte, finderItem, 0, 12);
            AppMethodBeat.o(244074);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void k(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(244075);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
            s.a.a(this.gte, baseFinderFeed, 4, 0, 20);
            AppMethodBeat.o(244075);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final com.tencent.mm.plugin.finder.view.e dcg() {
            return this.tLT;
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(BaseFinderFeed baseFinderFeed, boolean z2, boolean z3, int i2, boolean z4) {
            AppMethodBeat.i(244076);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
            com.tencent.mm.plugin.finder.model.aj ajVar = com.tencent.mm.plugin.finder.model.aj.uOw;
            FinderItem finderItem = baseFinderFeed.feedObject;
            boolean z5 = baseFinderFeed.showLikeTips;
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.model.aj.a(dIx, i2, finderItem, z2, z3, 2, z5, z4, com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact));
            AppMethodBeat.o(244076);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void b(BaseFinderFeed baseFinderFeed, boolean z2) {
            String str;
            int i2;
            String str2;
            int i3;
            String username2;
            String username3;
            AppMethodBeat.i(165764);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx();
            ag agVar = ag.uOs;
            com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
            if (gVar == null || (username3 = gVar.getUsername()) == null) {
                str = "";
            } else {
                str = username3;
            }
            if (z2) {
                bb.a aVar2 = bb.tve;
                i2 = bb.tvb;
            } else {
                bb.a aVar3 = bb.tve;
                i2 = bb.tvc;
            }
            com.tencent.mm.kernel.g.azz().b(ag.a(dIx, str, i2));
            c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g gVar2 = baseFinderFeed.contact;
            if (gVar2 == null || (username2 = gVar2.getUsername()) == null) {
                str2 = "";
            } else {
                str2 = username2;
            }
            if (z2) {
                g.a aVar5 = com.tencent.mm.plugin.finder.api.g.tsD;
                i3 = com.tencent.mm.plugin.finder.api.g.tsB;
            } else {
                g.a aVar6 = com.tencent.mm.plugin.finder.api.g.tsD;
                i3 = com.tencent.mm.plugin.finder.api.g.tsC;
            }
            c.a.du(str2, i3);
            AppMethodBeat.o(165764);
        }

        @Override // com.tencent.mm.vending.e.b
        public final void keep(com.tencent.mm.vending.e.a aVar) {
            AppMethodBeat.i(165766);
            kotlin.g.b.p.h(aVar, "p0");
            this.tLP.add(aVar);
            AppMethodBeat.o(165766);
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final void a(FinderItem finderItem, FinderCommentInfo finderCommentInfo) {
            AppMethodBeat.i(165767);
            kotlin.g.b.p.h(finderItem, "feed");
            kotlin.g.b.p.h(finderCommentInfo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            AppMethodBeat.o(165767);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        static final class k implements DialogInterface.OnClickListener {
            final /* synthetic */ Context $context;
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ b tPI;

            k(b bVar, BaseFinderFeed baseFinderFeed, Context context) {
                this.tPI = bVar;
                this.tEM = baseFinderFeed;
                this.$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(178257);
                String aUg = com.tencent.mm.model.z.aUg();
                kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                final av avVar = new av(aUg, this.tEM.feedObject.getFeedObject());
                Dialog dialog = this.tPI.tipDialog;
                if (dialog != null) {
                    dialog.show();
                } else {
                    b bVar = this.tPI;
                    Context context = this.$context;
                    this.$context.getString(R.string.zb);
                    bVar.tipDialog = com.tencent.mm.ui.base.h.a(context, this.$context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.tPM);
                }
                com.tencent.mm.kernel.g.azz().a(avVar.getType(), new com.tencent.mm.ak.i(this) {
                    /* class com.tencent.mm.plugin.finder.feed.ab.b.k.AnonymousClass1 */
                    final /* synthetic */ k tPN;

                    {
                        this.tPN = r1;
                    }

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(178256);
                        if ((qVar instanceof av) && ((av) qVar).hFK == avVar.hFK) {
                            com.tencent.mm.kernel.g.azz().b(avVar.getType(), this);
                        }
                        Dialog dialog = this.tPN.tPI.tipDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        if (!(i2 == 0 && i3 == 0)) {
                            com.tencent.mm.ui.base.u.makeText(this.tPN.$context, (int) R.string.d6k, 0).show();
                        }
                        AppMethodBeat.o(178256);
                    }
                });
                com.tencent.mm.kernel.g.azz().b(avVar);
                AppMethodBeat.o(178257);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
            static final class a implements DialogInterface.OnCancelListener {
                public static final a tPM = new a();

                static {
                    AppMethodBeat.i(178255);
                    AppMethodBeat.o(178255);
                }

                a() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        public static final class n implements ai<ayy> {
            final /* synthetic */ Context $context;

            n(Context context) {
                this.$context = context;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayy ayy, apg apg) {
                AppMethodBeat.i(178260);
                kotlin.g.b.p.h(ayy, "req");
                kotlin.g.b.p.h(apg, "ret");
                if (apg.retCode == 0) {
                    com.tencent.mm.ui.base.u.makeText(this.$context, (int) R.string.cnn, 0).show();
                    AppMethodBeat.o(178260);
                    return;
                }
                com.tencent.mm.ui.base.u.makeText(this.$context, (int) R.string.cnm, 0).show();
                Log.i("Finder.ProfileTimeLineCovert", "finder_feed_open_comment_no_ok " + apg.retCode);
                AppMethodBeat.o(178260);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$5", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        public static final class o implements ai<ayy> {
            final /* synthetic */ Context $context;

            o(Context context) {
                this.$context = context;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayy ayy, apg apg) {
                AppMethodBeat.i(244058);
                kotlin.g.b.p.h(ayy, "req");
                kotlin.g.b.p.h(apg, "ret");
                if (apg.retCode == 0) {
                    com.tencent.mm.ui.base.u.makeText(this.$context, (int) R.string.cmp, 0).show();
                    AppMethodBeat.o(244058);
                    return;
                }
                com.tencent.mm.ui.base.u.makeText(this.$context, (int) R.string.cmo, 0).show();
                Log.i("Finder.ProfileTimeLineCovert", "finder_feed_close_comment_ok " + apg.retCode);
                AppMethodBeat.o(244058);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        static final class p implements u.b {
            public static final p tPQ = new p();

            static {
                AppMethodBeat.i(244060);
                AppMethodBeat.o(244060);
            }

            p() {
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                TextView textView;
                AppMethodBeat.i(244059);
                if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                    AppMethodBeat.o(244059);
                    return;
                }
                textView.setTextSize(1, 14.0f);
                AppMethodBeat.o(244059);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        static final class q implements DialogInterface.OnClickListener {
            final /* synthetic */ Context $context;
            final /* synthetic */ BaseFinderFeed tEM;

            q(Context context, BaseFinderFeed baseFinderFeed) {
                this.$context = context;
                this.tEM = baseFinderFeed;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(244061);
                com.tencent.mm.plugin.finder.utils.q qVar = com.tencent.mm.plugin.finder.utils.q.vWb;
                com.tencent.mm.plugin.finder.utils.q.a(this.$context, this.tEM.feedObject, true);
                AppMethodBeat.o(244061);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        static final class s implements u.b {
            public static final s tPS = new s();

            static {
                AppMethodBeat.i(244066);
                AppMethodBeat.o(244066);
            }

            s() {
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                TextView textView;
                AppMethodBeat.i(244065);
                if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                    AppMethodBeat.o(244065);
                    return;
                }
                textView.setTextSize(1, 14.0f);
                AppMethodBeat.o(244065);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
        static final class u extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView.m> {
            public static final u tPT = new u();

            static {
                AppMethodBeat.i(165745);
                AppMethodBeat.o(165745);
            }

            u() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ RecyclerView.m invoke() {
                AppMethodBeat.i(165744);
                RecyclerView.m mVar = new RecyclerView.m();
                mVar.aw(1, 10);
                mVar.aw(2, 10);
                AppMethodBeat.o(165744);
                return mVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<FinderProfileFeedLoader> {
            final /* synthetic */ b tPI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super(0);
                this.tPI = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ FinderProfileFeedLoader invoke() {
                AppMethodBeat.i(244054);
                com.tencent.mm.plugin.finder.feed.model.internal.e eVar = com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_PROFILE_TIMELINE;
                String str = this.tPI.username;
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                FinderProfileFeedLoader finderProfileFeedLoader = new FinderProfileFeedLoader(eVar, str, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tPI.gte).get(FinderReporterUIC.class)).dIx());
                finderProfileFeedLoader.setCurTopicId(this.tPI.twp);
                Intent intent = this.tPI.gte.getIntent();
                kotlin.g.b.p.g(intent, "context.intent");
                finderProfileFeedLoader.initFromCache(intent);
                AppMethodBeat.o(244054);
                return finderProfileFeedLoader;
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.i
        public final RecyclerView.m dcf() {
            AppMethodBeat.i(165765);
            RecyclerView.m mVar = (RecyclerView.m) this.tPw.getValue();
            AppMethodBeat.o(165765);
            return mVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020!J\u0010\u0010'\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "isOtherEnableFullScreenEnjoy", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "smoothScrollToNextPosition", "plugin-finder_release"})
    public static final class c implements com.tencent.mm.plugin.finder.presenter.base.c<b> {
        final String TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
        public final MMActivity gte;
        public RecyclerView hak;
        public RefreshLoadMoreLayout tLS;
        public j tMe;
        public final b tPU;
        boolean tPV;
        public final boolean tPW;
        private final f tPX;

        public c(MMActivity mMActivity, final b bVar) {
            p.h(mMActivity, "context");
            p.h(bVar, "presenter");
            AppMethodBeat.i(244090);
            this.gte = mMActivity;
            this.tPU = bVar;
            this.tPV = true;
            y yVar = y.vXH;
            this.tPW = y.isOtherEnableFullScreenEnjoy();
            this.tPX = kotlin.g.ah(a.tQa);
            View findViewById = this.gte.findViewById(R.id.h7t);
            p.g(findViewById, "context.findViewById(R.id.rl_layout)");
            this.tLS = (RefreshLoadMoreLayout) findViewById;
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            this.hak = refreshLoadMoreLayout.getRecyclerView();
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(this.gte);
            if (this.tPW) {
                finderLinearLayoutManager.wsx = 25.0f;
                finderLinearLayoutManager.qOi = 100;
            }
            recyclerView.setLayoutManager(finderLinearLayoutManager);
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            recyclerView2.setRecycledViewPool((RecyclerView.m) this.tPX.getValue());
            RecyclerView recyclerView3 = this.hak;
            if (recyclerView3 == null) {
                p.btv("recyclerView");
            }
            recyclerView3.setAdapter(new WxRecyclerAdapter(new b.a(this.tPU), this.tPU.getFeedLoader().getDataListJustForAdapter()));
            if (this.tPW) {
                com.tencent.mm.plugin.finder.ui.e eVar = new com.tencent.mm.plugin.finder.ui.e();
                RecyclerView recyclerView4 = this.hak;
                if (recyclerView4 == null) {
                    p.btv("recyclerView");
                }
                eVar.f(recyclerView4);
            }
            this.tMe = new j(this) {
                /* class com.tencent.mm.plugin.finder.feed.ab.c.AnonymousClass1 */
                private final /* synthetic */ RefreshLoadMoreLayout tNU;
                final /* synthetic */ c tPY;

                @Override // com.tencent.mm.view.j
                public final void onChanged() {
                    AppMethodBeat.i(244080);
                    this.tNU.onChanged();
                    AppMethodBeat.o(244080);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeChanged(int i2, int i3) {
                    AppMethodBeat.i(244081);
                    this.tNU.onItemRangeChanged(i2, i3);
                    AppMethodBeat.o(244081);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeChanged(int i2, int i3, Object obj) {
                    AppMethodBeat.i(244082);
                    this.tNU.onItemRangeChanged(i2, i3, obj);
                    AppMethodBeat.o(244082);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeInserted(int i2, int i3) {
                    AppMethodBeat.i(244083);
                    this.tNU.onItemRangeInserted(i2, i3);
                    AppMethodBeat.o(244083);
                }

                @Override // com.tencent.mm.view.i
                public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                    AppMethodBeat.i(244084);
                    p.h(cVar, "reason");
                    this.tNU.onPreFinishLoadMore(cVar);
                    AppMethodBeat.o(244084);
                }

                @Override // com.tencent.mm.view.i
                public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                    AppMethodBeat.i(244085);
                    p.h(cVar, "reason");
                    this.tNU.onPreFinishLoadMoreSmooth(cVar);
                    AppMethodBeat.o(244085);
                }

                @Override // com.tencent.mm.view.i
                public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                    AppMethodBeat.i(244086);
                    p.h(cVar, "reason");
                    this.tNU.onPreFinishRefresh(cVar);
                    AppMethodBeat.o(244086);
                }

                {
                    this.tPY = r3;
                    AppMethodBeat.i(244079);
                    this.tNU = c.c(r3);
                    AppMethodBeat.o(244079);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeRemoved(int i2, int i3) {
                    AppMethodBeat.i(244078);
                    c.c(this.tPY).onItemRangeRemoved(i2, i3);
                    RecyclerView.a adapter = c.c(this.tPY).getRecyclerView().getAdapter();
                    if (adapter != null) {
                        if (adapter.getItemCount() < 10) {
                            bVar.getFeedLoader().requestLoadMore();
                        }
                        AppMethodBeat.o(244078);
                        return;
                    }
                    AppMethodBeat.o(244078);
                }
            };
            AppMethodBeat.o(244090);
        }

        public static final /* synthetic */ RecyclerView b(c cVar) {
            AppMethodBeat.i(165794);
            RecyclerView recyclerView = cVar.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            AppMethodBeat.o(165794);
            return recyclerView;
        }

        public static final /* synthetic */ RefreshLoadMoreLayout c(c cVar) {
            AppMethodBeat.i(165795);
            RefreshLoadMoreLayout refreshLoadMoreLayout = cVar.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(165795);
            return refreshLoadMoreLayout;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "plugin-finder_release"})
        public static final class b extends RefreshLoadMoreLayout.a {
            private boolean tMa = true;
            final /* synthetic */ c tPY;

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                AppMethodBeat.i(244088);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(244088);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b(c cVar) {
                this.tPY = cVar;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                AppMethodBeat.i(165783);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                super.cxo();
                Log.i(this.tPY.TAG, "onRequestLoadMore");
                h.RTc.aX(new a(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(165783);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            static final class a implements Runnable {
                final /* synthetic */ b tQb;

                a(b bVar) {
                    this.tQb = bVar;
                }

                public final void run() {
                    AppMethodBeat.i(165782);
                    this.tQb.tPY.tPU.getFeedLoader().requestLoadMore();
                    AppMethodBeat.o(165782);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
                RecyclerView b2;
                AppMethodBeat.i(165784);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.a(cVar);
                Log.i(this.tPY.TAG, "[onLoadMoreEnd] reason=".concat(String.valueOf(cVar)));
                if (!cVar.Rmj && c.b(this.tPY).getChildCount() > 0) {
                    View childAt = c.b(this.tPY).getChildAt(c.b(this.tPY).getChildCount() - 1);
                    RecyclerView.v bu = c.b(this.tPY).bu(childAt);
                    Integer valueOf = bu != null ? Integer.valueOf(bu.lU()) : null;
                    p.g(childAt, "itemView");
                    if (childAt.getHeight() > 0 && ((valueOf != null && valueOf.intValue() == 4) || (valueOf != null && valueOf.intValue() == 8))) {
                        int height = c.a.a(this.tPY).getDisplayMetrics().heightPixels - childAt.getHeight();
                        c.c(this.tPY).setExtraOverScrollFooterDx(height / 3);
                        Log.i(this.tPY.TAG, "extraOverScrollFooterDx=".concat(String.valueOf(height)));
                    }
                }
                if (cVar.Rml && cVar.Rmj && (b2 = c.b(this.tPY)) != null && this.tPY.tPW) {
                    c cVar2 = this.tPY;
                    RecyclerView.LayoutManager layoutManager = b2.getLayoutManager();
                    if (layoutManager == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                        AppMethodBeat.o(165784);
                        throw tVar;
                    }
                    int ks = ((FinderLinearLayoutManager) layoutManager).ks() + 1;
                    Log.i(cVar2.TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(ks)));
                    b2.post(new d(b2, ks));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(165784);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void IF(int i2) {
                AppMethodBeat.i(165785);
                if (this.tMa && i2 > 0) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tPY.gte).get(FinderReporterUIC.class));
                    if (d2 != null) {
                        d2.dap().onScrollStateChanged(c.b(this.tPY), 5);
                    }
                    this.tMa = false;
                }
                AppMethodBeat.o(165785);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(244087);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.onRefreshEnd(cVar);
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.b(c.b(this.tPY), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "1", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_REFRESH);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(244087);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ RecyclerView tDJ;
            final /* synthetic */ int tQg;

            d(RecyclerView recyclerView, int i2) {
                this.tDJ = recyclerView;
                this.tQg = i2;
            }

            public final void run() {
                AppMethodBeat.i(244089);
                RecyclerView recyclerView = this.tDJ;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.tQg, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(244089);
            }
        }

        public final RecyclerView getRecyclerView() {
            AppMethodBeat.i(165791);
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            AppMethodBeat.o(165791);
            return recyclerView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
        static final class a extends q implements kotlin.g.a.a<AnonymousClass1> {
            public static final a tQa = new a();

            static {
                AppMethodBeat.i(165781);
                AppMethodBeat.o(165781);
            }

            a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ AnonymousClass1 invoke() {
                AppMethodBeat.i(165780);
                AnonymousClass1 r0 = new RecyclerView.m() {
                    /* class com.tencent.mm.plugin.finder.feed.ab.c.a.AnonymousClass1 */

                    @Override // android.support.v7.widget.RecyclerView.m
                    public final void q(RecyclerView.v vVar) {
                        AppMethodBeat.i(165778);
                        p.h(vVar, "scrap");
                        super.q(vVar);
                        AppMethodBeat.o(165778);
                    }

                    @Override // android.support.v7.widget.RecyclerView.m
                    public final RecyclerView.v cm(int i2) {
                        AppMethodBeat.i(165779);
                        RecyclerView.v cm = super.cm(i2);
                        AppMethodBeat.o(165779);
                        return cm;
                    }
                };
                r0.aw(4, 8);
                r0.aw(2, 8);
                r0.aw(1, 8);
                r0.aw(8, 8);
                r0.aw(7, 8);
                AppMethodBeat.o(165780);
                return r0;
            }
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ab$c$c  reason: collision with other inner class name */
        public static final class C1122c extends q implements kotlin.g.a.b<Void, x> {
            final /* synthetic */ c tPY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1122c(c cVar) {
                super(1);
                this.tPY = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Void r6) {
                AppMethodBeat.i(165789);
                b bVar = this.tPY.tPU;
                y yVar = y.vXH;
                System.currentTimeMillis();
                AnonymousClass1 r0 = new com.tencent.mm.plugin.finder.feed.model.internal.h(this) {
                    /* class com.tencent.mm.plugin.finder.feed.ab.c.C1122c.AnonymousClass1 */
                    final /* synthetic */ C1122c tQc;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.tQc = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
                    public final void call(int i2) {
                        AppMethodBeat.i(165788);
                        int initPos = this.tQc.tPY.tPU.getFeedLoader().getInitPos();
                        Log.i(this.tQc.tPY.TAG, "onRefreshEnd firstLoadMore " + this.tQc.tPY.tPV + " initPos " + initPos);
                        if (this.tQc.tPY.tPV && initPos >= 0) {
                            this.tQc.tPY.tPV = false;
                            com.tencent.mm.ac.d.h(new a(this, initPos));
                        }
                        AppMethodBeat.o(165788);
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                    /* renamed from: com.tencent.mm.plugin.finder.feed.ab$c$c$1$a */
                    static final class a extends q implements kotlin.g.a.a<x> {
                        final /* synthetic */ AnonymousClass1 tQd;
                        final /* synthetic */ int tQe;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        a(AnonymousClass1 r2, int i2) {
                            super(0);
                            this.tQd = r2;
                            this.tQe = i2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(165787);
                            RecyclerView.LayoutManager layoutManager = c.b(this.tQd.tQc.tPY).getLayoutManager();
                            if (layoutManager == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                                AppMethodBeat.o(165787);
                                throw tVar;
                            }
                            ((FinderLinearLayoutManager) layoutManager).ah(this.tQe, 0);
                            c.b(this.tQd.tQc.tPY).post(new Runnable(this) {
                                /* class com.tencent.mm.plugin.finder.feed.ab.c.C1122c.AnonymousClass1.a.AnonymousClass1 */
                                final /* synthetic */ a tQf;

                                {
                                    this.tQf = r1;
                                }

                                public final void run() {
                                    com.tencent.mm.plugin.finder.event.base.c a2;
                                    AppMethodBeat.i(165786);
                                    RecyclerView.LayoutManager layoutManager = c.b(this.tQf.tQd.tQc.tPY).getLayoutManager();
                                    if (layoutManager == null) {
                                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                                        AppMethodBeat.o(165786);
                                        throw tVar;
                                    }
                                    ((FinderLinearLayoutManager) layoutManager).ah(this.tQf.tQe, 0);
                                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tQf.tQd.tQc.tPY.gte);
                                    if (fH == null || (a2 = FinderReporterUIC.a(fH)) == null) {
                                        AppMethodBeat.o(165786);
                                        return;
                                    }
                                    new ah(a2).doW().KC(this.tQf.tQe);
                                    AppMethodBeat.o(165786);
                                }
                            });
                            x xVar = x.SXb;
                            AppMethodBeat.o(165787);
                            return xVar;
                        }
                    }
                };
                p.h(r0, "initDone");
                bVar.getFeedLoader().setInitDone(r0);
                BaseFeedLoader.requestInit$default(bVar.getFeedLoader(), false, 1, null);
                RefreshLoadMoreLayout.d(c.c(this.tPY));
                x xVar = x.SXb;
                AppMethodBeat.o(165789);
                return xVar;
            }
        }
    }
}
