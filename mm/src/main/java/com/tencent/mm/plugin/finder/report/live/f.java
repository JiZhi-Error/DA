package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.h;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u000f&\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J(\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0002J@\u0010-\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000605\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000605042\u0006\u00106\u001a\u0002072\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0002J(\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u0002082\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0002J(\u0010-\u001a\u00020\u00062\u0006\u00109\u001a\u00020:2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0002J(\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020;2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0002J(\u0010<\u001a\u00020\u00062\u0006\u00109\u001a\u00020:2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0002J\b\u0010=\u001a\u00020>H\u0002J \u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020A2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0002J \u0010B\u001a\u00020>2\u0006\u0010@\u001a\u00020A2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0002JL\u0010C\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u0002032\u0006\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020K2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u001aH\u0002J\b\u0010M\u001a\u00020>H\u0002J4\u0010N\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u0002032\u0006\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020KH\u0002J4\u0010O\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u0002032\u0006\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010P\u001a\u00020>H\u0002J\b\u0010Q\u001a\u00020>H\u0002J\b\u0010R\u001a\u00020>H\u0002J\u0018\u0010S\u001a\u00020>2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020>H\u0002J,\u0010Y\u001a\u00020>2\n\u0010F\u001a\u00060\u001eR\u00020\u001f2\u0006\u0010Z\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0002J,\u0010Y\u001a\u00020>2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010Z\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0002J,\u0010[\u001a\u00020>2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010Z\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0002J\u0010\u0010\\\u001a\u00020>2\u0006\u0010T\u001a\u00020UH\u0002J(\u0010]\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010J\u001a\u00020K2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006JR\u0010]\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010^\u001a\u00020_2\u0006\u0010H\u001a\u0002032\u0006\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020K2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\b\u0012\u00060\u001eR\u00020\u001f\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R*\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!`\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#X\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020)X.¢\u0006\u0002\n\u0000¨\u0006a"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;)V", "TAG", "", "mAbsActionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "mAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getMCallback", "()Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "mChatListener", "com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mChatListener$1;", "mCommentscene", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mItemCache", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "mLastVisible", "", "mLayoutRef", "Landroid/support/v7/widget/LinearLayoutManager;", "mMixSearchAdapterRef", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "mShareCaseList", "", "[Ljava/lang/String;", "mSnsListener", "com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mSnsListener$1;", "monitor_method", "Ljava/lang/reflect/Method;", "onPauseState", "register_method", "unregister_method", "_doOnScroll", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "actionType", "commentscene", "pos", "", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "_doOnScrollHorizontal", "doDisappear", "", "doRunOnScroll", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "doRunOnScrollHorizontal", "doSnsEvent", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "firstVisibleItem", "visibleItemCount", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "isSns", "doSnsHorAppear", "handleChat", "handleSns", "onDestroy", "onFeedAllDisappear", "onItemAllDisappear", "onLiveFeedAppear", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onMixSearchAllDisappear", "onScroll", "layoutManager", "onScrollHorizontal", "onSnsAdLiveFeedAppear", "run", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "headerShow", "plugin-finder_release"})
public final class f {
    private final String TAG = "HABBYGE-MALI.HellFeedSingleExposure";
    s.p vjA = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
    String vjB = "";
    final String[] vjC = {"61", "temp_6"};
    Method vjD;
    Method vjE;
    Method vjF;
    boolean vjG;
    final a vjH;
    final b vjI;
    WeakReference<LinearLayoutManager> vjn;
    WeakReference<WxRecyclerAdapter<?>> vjo;
    private final HashMap<String, h> vjt = new HashMap<>();
    private final HashMap<String, j> vju = new HashMap<>();
    final HashMap<String, h> vjv = new HashMap<>();
    final r vjw;
    WeakReference<FinderContactSearchUI.a> vjx;
    private final HashMap<String, i> vjy = new HashMap<>();
    boolean vjz;

    public f(r rVar) {
        AppMethodBeat.i(250929);
        this.vjw = rVar;
        try {
            Class<?> cls = Class.forName("com.tencent.mm.ui.chatting.monitor.ChatFeedMonitor");
            p.g(cls, "Class.forName(className)");
            Method declaredMethod = cls.getDeclaredMethod("monitor", AbsListView.class, BaseAdapter.class, Integer.TYPE, Integer.TYPE);
            p.g(declaredMethod, "monitor_clazz.getDeclare…         Int::class.java)");
            this.vjD = declaredMethod;
            Method method = this.vjD;
            if (method == null) {
                p.btv("monitor_method");
            }
            method.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod("registerListener", com.tencent.mm.plugin.expt.hellhound.a.g.a.class);
            p.g(declaredMethod2, "monitor_clazz.getDeclare…FeedListener::class.java)");
            this.vjE = declaredMethod2;
            Method method2 = this.vjE;
            if (method2 == null) {
                p.btv("register_method");
            }
            method2.setAccessible(true);
            Method declaredMethod3 = cls.getDeclaredMethod("unregisterListener", com.tencent.mm.plugin.expt.hellhound.a.g.a.class);
            p.g(declaredMethod3, "monitor_clazz.getDeclare…FeedListener::class.java)");
            this.vjF = declaredMethod3;
            Method method3 = this.vjF;
            if (method3 == null) {
                p.btv("unregister_method");
            }
            method3.setAccessible(true);
        } catch (Exception e2) {
            Log.e(this.TAG, "init crash: " + e2.getMessage());
        }
        this.vjH = new a(this);
        this.vjI = new b(this);
        AppMethodBeat.o(250929);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mChatListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.plugin.expt.hellhound.a.g.a {
        final /* synthetic */ f vjJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(f fVar) {
            this.vjJ = fVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.g.a
        public final void a(BaseAdapter baseAdapter, c cVar, View view) {
            h.b bVar;
            AppMethodBeat.i(250918);
            if (cVar == null) {
                AppMethodBeat.o(250918);
                return;
            }
            String str = cVar.sBK.userName;
            int i2 = cVar.position;
            String str2 = cVar.sBK.feedId;
            p.g(str2, "hellFeed.feed.feedId");
            long safeParseLong = Util.safeParseLong(cVar.sBK.feedId);
            long safeParseLong2 = Util.safeParseLong(cVar.hJs);
            s.p pVar = this.vjJ.vjA;
            String str3 = this.vjJ.vjB;
            String str4 = cVar.sBK.nickName;
            if (str4 == null) {
                str4 = "";
            }
            if (cVar.liveStatus == 1) {
                bVar = h.b.ING;
            } else {
                bVar = h.b.NOT;
            }
            h hVar = new h(null, str, i2, str2, safeParseLong, safeParseLong2, pVar, str3, -1, str4, bVar, true, true, s.ba.Chat.type);
            r rVar = this.vjJ.vjw;
            if (rVar != null) {
                rVar.a(hVar, false);
                AppMethodBeat.o(250918);
                return;
            }
            AppMethodBeat.o(250918);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure$mSnsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "onAppear", "", "adapter", "Landroid/widget/BaseAdapter;", "hellFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "view", "Landroid/view/View;", "onDisappear", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.plugin.expt.hellhound.a.g.a {
        final /* synthetic */ f vjJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(f fVar) {
            this.vjJ = fVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.g.a
        public final void a(BaseAdapter baseAdapter, c cVar, View view) {
            axf axf;
            h.b bVar;
            AppMethodBeat.i(250919);
            if (baseAdapter == null) {
                AppMethodBeat.o(250919);
            } else if (cVar == null) {
                AppMethodBeat.o(250919);
            } else if (view == null) {
                AppMethodBeat.o(250919);
            } else if (!(baseAdapter instanceof com.tencent.mm.plugin.sns.ui.a.c)) {
                AppMethodBeat.o(250919);
            } else if (!(view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                AppMethodBeat.o(250919);
            } else if (TextUtils.isEmpty(cVar.finderLiveId)) {
                f fVar = this.vjJ;
                Object tag = view.getTag();
                if (!(tag instanceof c.a)) {
                    tag = null;
                }
                c.a aVar = (c.a) tag;
                if (aVar == null) {
                    AppMethodBeat.o(250919);
                    return;
                }
                TimeLineObject timeLineObject = aVar.timeLineObject;
                if (timeLineObject == null) {
                    AppMethodBeat.o(250919);
                    return;
                }
                adp adp = timeLineObject.ContentObj;
                if (adp == null || (axf = adp.Lpc) == null) {
                    AppMethodBeat.o(250919);
                    return;
                }
                String str = axf.username;
                int i2 = cVar.position;
                String str2 = axf.feedId;
                p.g(str2, "finderLiveShareObject.feedId");
                long safeParseLong = Util.safeParseLong(axf.feedId);
                long safeParseLong2 = Util.safeParseLong(axf.hJs);
                s.p pVar = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
                String str3 = fVar.vjB;
                String str4 = axf.nickName;
                p.g(str4, "finderLiveShareObject.nickName");
                if (axf.liveStatus == 1) {
                    bVar = h.b.ING;
                } else {
                    bVar = h.b.NOT;
                }
                h hVar = new h(null, str, i2, str2, safeParseLong, safeParseLong2, pVar, str3, -1, str4, bVar, true, true, s.ba.Chat.type);
                r rVar = fVar.vjw;
                if (rVar != null) {
                    rVar.a(hVar, false);
                    AppMethodBeat.o(250919);
                    return;
                }
                AppMethodBeat.o(250919);
            } else {
                f fVar2 = this.vjJ;
                String str5 = cVar.sBN;
                int i3 = cVar.position;
                String str6 = cVar.sBK.feedId;
                p.g(str6, "hellFeed.feed.feedId");
                long safeParseLong3 = Util.safeParseLong(cVar.sBK.feedId);
                long safeParseLong4 = Util.safeParseLong(cVar.hJs);
                s.p pVar2 = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
                String str7 = cVar.sBK.userName;
                p.g(str7, "hellFeed.feed.userName");
                h hVar2 = new h(null, str5, i3, str6, safeParseLong3, safeParseLong4, pVar2, "37", -1, str7, h.b.ING, true, true, s.ba.Chat.type);
                r rVar2 = fVar2.vjw;
                if (rVar2 != null) {
                    rVar2.a(hVar2, false);
                    AppMethodBeat.o(250919);
                    return;
                }
                AppMethodBeat.o(250919);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dpc() {
        AppMethodBeat.i(250920);
        if (!this.vjv.isEmpty()) {
            for (Map.Entry<String, h> entry : this.vjv.entrySet()) {
                h value = entry.getValue();
                p.g(value, "iterator.next().value");
                h hVar = value;
                r rVar = this.vjw;
                if (rVar != null) {
                    rVar.a(hVar, true);
                }
            }
        }
        AppMethodBeat.o(250920);
    }

    /* access modifiers changed from: package-private */
    public final void dpd() {
        AppMethodBeat.i(250921);
        if (!this.vjv.isEmpty()) {
            for (Map.Entry<String, h> entry : this.vjv.entrySet()) {
                h value = entry.getValue();
                p.g(value, "iterator.next().value");
                h hVar = value;
                r rVar = this.vjw;
                if (rVar != null) {
                    rVar.a(hVar);
                }
            }
        }
        AppMethodBeat.o(250921);
    }

    /* access modifiers changed from: package-private */
    public final void a(WxRecyclerAdapter<?> wxRecyclerAdapter, LinearLayoutManager linearLayoutManager, s.p pVar, String str) {
        int i2;
        int i3;
        AppMethodBeat.i(250922);
        int ks = linearLayoutManager.ks();
        int ku = linearLayoutManager.ku();
        if (ks != 0) {
            i2 = ks - 1;
            i3 = ku - 1;
        } else if (ku >= 2) {
            i2 = ks;
            i3 = ku - 1;
        } else {
            i2 = ks;
            i3 = ku;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<D> arrayList2 = wxRecyclerAdapter.data;
        if ((!arrayList2.isEmpty()) && i2 <= i3) {
            int i4 = i2;
            while (true) {
                if (arrayList2.size() > i4) {
                    D d2 = arrayList2.get(i4);
                    if (!(d2 instanceof bo)) {
                        d2 = null;
                    }
                    bo boVar = (bo) d2;
                    if (boVar != null) {
                        long lT = boVar.lT();
                        String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(lT);
                        p.g(zs, "HellhoundUtil.long2UnsignedString(feedIdL)");
                        if (!this.vjv.containsKey(zs)) {
                            h.a aVar = h.vjR;
                            d<Long, Integer, Boolean> a2 = h.a.a(boVar);
                            String str2 = "";
                            if (boVar instanceof BaseFinderFeed) {
                                str2 = ((BaseFinderFeed) boVar).feedObject.getUserName();
                            }
                            Long hdM = a2.hdM();
                            p.g(hdM, "liveIdTuple3.`$1`()");
                            long longValue = hdM.longValue();
                            Integer hdN = a2.hdN();
                            p.g(hdN, "liveIdTuple3.`$2`()");
                            int intValue = hdN.intValue();
                            h.a aVar2 = h.vjR;
                            h hVar = new h(boVar, str2, i4, zs, lT, longValue, pVar, str, intValue, h.a.b(boVar), h.b.UNDEFINE, true, false, 12288, (byte) 0);
                            this.vjv.put(zs, hVar);
                            this.vjt.put(zs, hVar);
                            r rVar = this.vjw;
                            if (rVar != null) {
                                rVar.a(hVar, true);
                            }
                        }
                        arrayList.add(zs);
                    }
                }
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        Iterator<Map.Entry<String, h>> it = this.vjv.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, h> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, h> entry = next;
            if (!arrayList.contains(entry.getKey())) {
                it.remove();
                this.vjt.remove(entry.getKey());
                r rVar2 = this.vjw;
                if (rVar2 != null) {
                    h value = entry.getValue();
                    p.g(value, "hellFeedPair.value");
                    rVar2.a(value);
                }
            }
        }
        arrayList.clear();
        AppMethodBeat.o(250922);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.view.recyclerview.WxRecyclerAdapter<?> r31, android.support.v7.widget.LinearLayoutManager r32, com.tencent.mm.plugin.finder.report.live.s.p r33, java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 778
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.f.b(com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.LinearLayoutManager, com.tencent.mm.plugin.finder.report.live.s$p, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(FinderContactSearchUI.a aVar, LinearLayoutManager linearLayoutManager, s.p pVar, String str) {
        String str2;
        String str3;
        AppMethodBeat.i(250924);
        int ks = linearLayoutManager.ks();
        int ku = linearLayoutManager.ku();
        ArrayList arrayList = new ArrayList();
        ArrayList a2 = FinderContactSearchUI.a(FinderContactSearchUI.this);
        if ((!a2.isEmpty()) && ks <= ku) {
            while (true) {
                if (linearLayoutManager.findViewByPosition(ks) != null && a2.size() > ks) {
                    Object obj = a2.get(ks);
                    p.g(obj, "dataList[pos]");
                    bbz bbz = (bbz) obj;
                    FinderContact finderContact = bbz.contact;
                    if (finderContact == null || (str2 = finderContact.username) == null) {
                        str2 = "";
                    } else {
                        p.g(str2, "feed.contact?.username ?: return \"\"");
                        if (!this.vju.containsKey(str2)) {
                            FinderContact finderContact2 = bbz.contact;
                            boolean z = finderContact2 != null && finderContact2.liveStatus == 1;
                            FinderContact finderContact3 = bbz.contact;
                            if (finderContact3 == null || (str3 = finderContact3.nickname) == null) {
                                str3 = "";
                            }
                            j jVar = new j(bbz, ks, str2, pVar, str, z, str3);
                            this.vju.put(str2, jVar);
                            r rVar = this.vjw;
                            if (rVar != null) {
                                rVar.a(jVar);
                            }
                        }
                    }
                    arrayList.add(str2);
                }
                if (ks == ku) {
                    break;
                }
                ks++;
            }
        }
        Iterator<Map.Entry<String, j>> it = this.vju.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, j> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, j> entry = next;
            if (!arrayList.contains(entry.getKey())) {
                it.remove();
                r rVar2 = this.vjw;
                if (rVar2 != null) {
                    j value = entry.getValue();
                    p.g(value, "hellFeedPair.value");
                    rVar2.b(value);
                }
            }
        }
        arrayList.clear();
        AppMethodBeat.o(250924);
    }

    private final com.tencent.mm.vending.j.c<List<String>, List<String>> a(x xVar, s.p pVar, String str, int i2) {
        AppMethodBeat.i(250925);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<y> it = xVar.dtS.iterator();
        while (it.hasNext()) {
            y next = it.next();
            long j2 = next.uOo.id;
            String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2);
            p.g(zs, "HellhoundUtil.long2UnsignedString(feedIdL)");
            if (this.vjv.containsKey(zs)) {
                if (!this.vjt.containsKey(zs)) {
                    h.a aVar = h.vjR;
                    p.g(next, "subRvFeed");
                    d<Long, Integer, Boolean> a2 = h.a.a(next);
                    y yVar = next;
                    String str2 = next.uOo.username;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Long hdM = a2.hdM();
                    p.g(hdM, "liveIdTuple3.`$1`()");
                    long longValue = hdM.longValue();
                    Integer hdN = a2.hdN();
                    p.g(hdN, "liveIdTuple3.`$2`()");
                    int intValue = hdN.intValue();
                    h.a aVar2 = h.vjR;
                    String b2 = h.a.b(next);
                    h.b bVar = h.b.UNDEFINE;
                    Boolean hdO = a2.hdO();
                    p.g(hdO, "liveIdTuple3.`$3`()");
                    h hVar = new h(yVar, str2, i2, zs, j2, longValue, pVar, str, intValue, b2, bVar, hdO.booleanValue(), false, 12288, (byte) 0);
                    this.vjt.put(zs, hVar);
                    r rVar = this.vjw;
                    if (rVar != null) {
                        rVar.a(hVar, true);
                    }
                }
                arrayList.add(zs);
            } else {
                arrayList2.add(zs);
            }
        }
        com.tencent.mm.vending.j.c<List<String>, List<String>> Q = com.tencent.mm.vending.j.a.Q(arrayList, arrayList2);
        p.g(Q, "Tuple.make(retIdList, needDelList)");
        AppMethodBeat.o(250925);
        return Q;
    }

    /* access modifiers changed from: package-private */
    public final void dpa() {
        AppMethodBeat.i(250926);
        String cNi = com.tencent.mm.plugin.expt.hellhound.a.cNi();
        if (p.j(cNi, "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI3") || p.j(cNi, "OccupyFinderUI3")) {
            AppMethodBeat.o(250926);
            return;
        }
        Iterator<Map.Entry<String, h>> it = this.vjt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, h> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, h> entry = next;
            it.remove();
            r rVar = this.vjw;
            if (rVar != null) {
                h value = entry.getValue();
                p.g(value, "hellFeedPair.value");
                rVar.a(value);
            }
        }
        AppMethodBeat.o(250926);
    }

    /* access modifiers changed from: package-private */
    public final void dpe() {
        AppMethodBeat.i(250927);
        Iterator<Map.Entry<String, i>> it = this.vjy.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, i> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, i> entry = next;
            it.remove();
            r rVar = this.vjw;
            if (rVar != null) {
                i value = entry.getValue();
                p.g(value, "hellFeedPair.value");
                rVar.b(value);
            }
        }
        AppMethodBeat.o(250927);
    }

    /* access modifiers changed from: package-private */
    public final void dpb() {
        AppMethodBeat.i(250928);
        Iterator<Map.Entry<String, j>> it = this.vju.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, j> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, j> entry = next;
            it.remove();
            r rVar = this.vjw;
            if (rVar != null) {
                j value = entry.getValue();
                p.g(value, "hellFeedPair.value");
                rVar.b(value);
            }
        }
        AppMethodBeat.o(250928);
    }
}
