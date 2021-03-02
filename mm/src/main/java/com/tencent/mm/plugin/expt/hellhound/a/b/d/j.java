package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.hellhound.a.a.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 T2\u00020\u0001:\u0001TB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0010\u0010)\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010+J\u0016\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0017J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0010\u00101\u001a\u00020'2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0010\u00102\u001a\u00020'2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0018\u00103\u001a\u00020'2\u0006\u00100\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0019H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00104\u001a\u00020\u0019H\u0002J\"\u00106\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u001bH\u0002J \u0010:\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0019J\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110<J\u0010\u0010=\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010>\u001a\u00020'2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010?\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010@\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0010\u0010A\u001a\u00020B2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0010\u0010C\u001a\u00020B2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020B2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0010\u0010E\u001a\u00020B2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0010\u0010F\u001a\u00020'2\u0006\u00100\u001a\u00020\u0011H\u0002J\u001c\u0010G\u001a\u00020'2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110<H\u0002J$\u0010I\u001a\u00020'2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110<2\u0006\u00104\u001a\u00020\u0019H\u0002J\u001e\u0010J\u001a\u00020'2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00100L2\u0006\u00104\u001a\u00020\u0019H\u0002J*\u0010M\u001a\u00020'2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\fJ\u001a\u0010O\u001a\u00020'2\b\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020\u0019H\u0002J\u0018\u0010Q\u001a\u00020'2\u0006\u00100\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0019H\u0002J*\u0010R\u001a\u00020'2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\fJ\u001a\u0010S\u001a\u00020'2\b\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020\u0019H\u0002R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/app/Activity;Landroid/support/v4/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", AppMeasurement.Param.TIMESTAMP, "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j {
    public static int sHN;
    public static final a sHO = new a((byte) 0);
    private WeakReference<Activity> mActivityRef;
    private int mScene;
    b sBo;
    public WeakReference<RecyclerView> sCb;
    public long sHA;
    public final long sHB = System.currentTimeMillis();
    public int sHC;
    private float sHD;
    private float sHE;
    public float sHF;
    public float sHG;
    private float sHH;
    public final c sHI;
    public WeakReference<StaggeredGridLayoutManager> sHJ;
    public HashMap<String, i> sHK;
    public long sHL;
    public int sHM;
    public final HashMap<String, i> sHy = new HashMap<>();
    private String sHz;

    static {
        AppMethodBeat.i(221113);
        AppMethodBeat.o(221113);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public j(Activity activity, Fragment fragment) {
        Activity activity2;
        Display display;
        int i2;
        AppMethodBeat.i(221112);
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        }
        this.sHz = c.cPU().cMD();
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 != null) {
            try {
                Object systemService = MMApplicationContext.getContext().getSystemService("window");
                if (systemService != null) {
                    display = ((WindowManager) systemService).getDefaultDisplay();
                    Point point = new Point();
                    if (Build.VERSION.SDK_INT >= 13 && display != null) {
                        display.getSize(point);
                    }
                    Point point2 = new Point();
                    if (Build.VERSION.SDK_INT >= 17 && display != null) {
                        display.getRealSize(point2);
                    }
                    this.sHD = (float) point.x;
                    this.sHE = this.sHD / 2.0f;
                    float f2 = (float) point.y;
                    int i3 = point2.y;
                    float O = com.tencent.mm.plugin.expt.hellhound.core.b.O(activity2);
                    int max = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.u(activity2), activity2.getResources().getDimensionPixelSize(R.dimen.b9));
                    this.sHF = ((float) max) + O;
                    this.sHG = f2;
                    this.sHH = this.sHD * (this.sHG - this.sHF);
                    c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEI = this.sHH;
                    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.sHE + '\n' + "mScreenWidth=" + this.sHD + '\n' + "screenRealHeight=" + i3 + '\n' + "screenHeight=" + f2 + '\n' + "statusBarHeight=" + O + '\n' + "actionBarHeight=" + max + '\n' + "mScreenTop=" + this.sHF + '\n' + "mScreenBottom=" + this.sHG + '\n' + "mScreenArea=" + this.sHH);
                    if (fragment != null) {
                        String name = fragment.getClass().getName();
                        switch (name.hashCode()) {
                            case -1010168201:
                                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment")) {
                                    this.sBo = new f();
                                    sHN = 0;
                                    this.mScene = c.f.LBS.value;
                                    break;
                                }
                            default:
                                Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", new NullPointerException("initFragmentFeedParamsCatcher miss !!"), "initFragmentFeedParamsCatcher miss !!", new Object[0]);
                                break;
                        }
                    } else {
                        String name2 = activity2.getClass().getName();
                        switch (name2.hashCode()) {
                            case -1796598533:
                                if (name2.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI")) {
                                    this.sBo = new f();
                                    sHN = 0;
                                    this.mScene = c.f.LBS.value;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            case -1577760806:
                                if (name2.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
                                    this.sBo = new f();
                                    sHN = 0;
                                    this.mScene = c.f.LBS.value;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            case -1570624296:
                                if (name2.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
                                    this.sBo = new b();
                                    sHN = 0;
                                    this.mScene = c.f.FAVORITE.value;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            case 395150120:
                                if (name2.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
                                    this.sBo = new g(activity2);
                                    sHN = 1;
                                    this.mScene = c.f.OTHER_PROFILE.value;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            case 782364972:
                                if (name2.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
                                    this.sBo = new h();
                                    sHN = 1;
                                    c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                    if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEX == c.d.Poi.value) {
                                        i2 = c.f.POI.value;
                                    } else {
                                        i2 = c.f.TOPIC.value;
                                    }
                                    this.mScene = i2;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            case 786042180:
                                if (name2.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
                                    this.sBo = new f();
                                    sHN = 0;
                                    this.mScene = c.f.LBS.value;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            case 1251839313:
                                if (name2.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
                                    this.sBo = new e(activity2);
                                    sHN = 5;
                                    this.mScene = c.f.SEARCH.value;
                                    break;
                                }
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                            default:
                                Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + activity2.getClass().getName());
                                break;
                        }
                    }
                } else {
                    t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
                    AppMethodBeat.o(221112);
                    throw tVar;
                }
            } catch (Exception e2) {
                WindowManager windowManager = activity2.getWindowManager();
                p.g(windowManager, "activity.windowManager");
                display = windowManager.getDefaultDisplay();
            }
        }
        this.sHI = new c(this);
        this.sHK = new HashMap<>();
        this.sHL = -1;
        this.sHM = -1;
        AppMethodBeat.o(221112);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics$Companion;", "", "()V", "HEADER_COUNT", "", "TAG", "", "WATERFALLS_FLOW_COUNT", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void cPu() {
        AppMethodBeat.i(221101);
        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
        AppMethodBeat.o(221101);
    }

    public final void c(List<String> list, long j2) {
        long j3;
        AppMethodBeat.i(221102);
        if (this.sHy.isEmpty()) {
            AppMethodBeat.o(221102);
            return;
        }
        Iterator<Map.Entry<String, i>> it = this.sHy.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, i> next = it.next();
            i value = next.getValue();
            if (!list.contains(next.getKey()) && value.sHt > 0) {
                value.sHu = j2;
                value.sHw = value.sHu - value.sHt;
                this.sHC = 0;
                value.sHv = this.sHC;
                if (value.sGJ <= 0) {
                    if (this.sHA <= 0) {
                        j3 = this.sHB;
                    } else {
                        j3 = this.sHA;
                    }
                    value.sGJ = j3;
                }
                a.C1016a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
                a.C1016a.a(value);
                it.remove();
            }
        }
        AppMethodBeat.o(221102);
    }

    public final i a(View view, int i2, RecyclerView recyclerView) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(221103);
        b bVar = this.sBo;
        if (bVar != null) {
            bVar.setRecyclerView(recyclerView);
        }
        b bVar2 = this.sBo;
        String ac = bVar2 != null ? bVar2.ac(view, i2) : null;
        if (ac == null) {
            AppMethodBeat.o(221103);
            return null;
        }
        i iVar = this.sHy.get(ac);
        if (iVar == null) {
            i iVar2 = new i((byte) 0);
            iVar2.feedId = ac;
            b bVar3 = this.sBo;
            if (bVar3 != null) {
                str3 = bVar3.ad(view, i2);
            } else {
                str3 = null;
            }
            iVar2.userName = str3;
            b bVar4 = this.sBo;
            if (bVar4 != null) {
                str4 = bVar4.ae(view, i2);
            } else {
                str4 = null;
            }
            iVar2.nickName = str4;
            b bVar5 = this.sBo;
            if (bVar5 != null) {
                str5 = bVar5.GY(i2);
            }
            iVar2.sGR = com.tencent.mm.plugin.expt.hellhound.core.b.aoU(str5);
            String str6 = this.sHz;
            if (str6 == null) {
                str6 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
            }
            iVar2.sessionId = str6;
            iVar2.scene = this.mScene;
            iVar2.sGQ = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
            Pair<Float, Float> dK = com.tencent.mm.plugin.expt.hellhound.core.b.dK(view);
            Object obj = dK.first;
            p.g(obj, "widthHeightPair.first");
            iVar2.width = ((Number) obj).floatValue();
            Object obj2 = dK.second;
            p.g(obj2, "widthHeightPair.second");
            iVar2.height = ((Number) obj2).floatValue();
            this.sHy.put(ac, iVar2);
            iVar = iVar2;
        } else if (iVar.sGR == null || iVar.height <= 0.0f || iVar.y <= 0) {
            iVar.feedId = ac;
            b bVar6 = this.sBo;
            if (bVar6 != null) {
                str = bVar6.ad(view, i2);
            } else {
                str = null;
            }
            iVar.userName = str;
            b bVar7 = this.sBo;
            if (bVar7 != null) {
                str2 = bVar7.ae(view, i2);
            } else {
                str2 = null;
            }
            iVar.nickName = str2;
            b bVar8 = this.sBo;
            if (bVar8 != null) {
                str5 = bVar8.GY(i2);
            }
            iVar.sGR = com.tencent.mm.plugin.expt.hellhound.core.b.aoU(str5);
            String str7 = this.sHz;
            if (str7 == null) {
                str7 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
            }
            iVar.sessionId = str7;
            iVar.scene = this.mScene;
            iVar.sGQ = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
            Pair<Float, Float> dK2 = com.tencent.mm.plugin.expt.hellhound.core.b.dK(view);
            Object obj3 = dK2.first;
            p.g(obj3, "widthHeightPair.first");
            iVar.width = ((Number) obj3).floatValue();
            Object obj4 = dK2.second;
            p.g(obj4, "widthHeightPair.second");
            iVar.height = ((Number) obj4).floatValue();
        }
        AppMethodBeat.o(221103);
        return iVar;
    }

    public static void b(i iVar) {
        boolean z;
        AppMethodBeat.i(221104);
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        if (!kotlin.a.j.a((Iterable) com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEJ, (Object) iVar.feedId)) {
            z = false;
        } else if (iVar.kf < 0) {
            z = true;
        } else {
            AppMethodBeat.o(221104);
            return;
        }
        if (!z) {
            c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            List list = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEJ;
            String str = iVar.feedId;
            if (str == null) {
                p.hyc();
            }
            list.add(str);
        }
        c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        iVar.kf = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEJ, (Object) iVar.feedId);
        AppMethodBeat.o(221104);
    }

    public final void d(i iVar) {
        float f2 = 0.0f;
        int i2 = iVar.y;
        float f3 = ((float) i2) + iVar.height;
        if (((float) i2) < this.sHF) {
            if (f3 > this.sHG) {
                f2 = this.sHG - this.sHF;
            } else if (f3 > this.sHF) {
                f2 = f3 - this.sHF;
            }
        } else if (f3 <= this.sHG) {
            f2 = iVar.height;
        } else if (((float) i2) < this.sHG) {
            f2 = this.sHG - ((float) i2);
        }
        iVar.sGL = (f2 * 100.0f) / iVar.height;
        iVar.sGM = ((f2 * iVar.width) * 100.0f) / this.sHH;
    }

    public final void n(Object obj, long j2) {
        Map<? extends String, ? extends i> map;
        long j3;
        AppMethodBeat.i(221106);
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        if (obj == null) {
            map = null;
        } else {
            Map<? extends String, ? extends i> map2 = (Map) com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEm.get(Integer.valueOf(obj.hashCode()));
            if (map2 == null) {
                map2 = (Map) com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEn.get(obj.getClass().getName());
            }
            map = map2;
        }
        if (map == null) {
            AppMethodBeat.o(221106);
            return;
        }
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + map.size());
        if (!map.isEmpty()) {
            this.sHy.clear();
            this.sHy.putAll(map);
            c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            if (obj != null) {
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEm.remove(Integer.valueOf(obj.hashCode()));
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEn.remove(obj.getClass().getName());
            }
            for (Map.Entry<String, i> entry : this.sHy.entrySet()) {
                i value = entry.getValue();
                value.sHt = j2;
                value.sHu = 0;
                value.sHw = 0;
                value.sHv = 0;
                if (value.sGJ <= 0) {
                    if (this.sHA <= 0) {
                        j3 = this.sHB;
                    } else {
                        j3 = this.sHA;
                    }
                    value.sGJ = j3;
                }
            }
        }
        AppMethodBeat.o(221106);
    }

    public final void o(Object obj, long j2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        AppMethodBeat.i(221107);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.sHy);
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i iVar = (i) entry.getValue();
            WeakReference<StaggeredGridLayoutManager> weakReference = this.sHJ;
            if (!(weakReference == null || (staggeredGridLayoutManager = weakReference.get()) == null)) {
                p.g(staggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
                View findViewByPosition = staggeredGridLayoutManager.findViewByPosition(sHN + iVar.position);
                if (findViewByPosition != null) {
                    Pair<Integer, Integer> dJ = com.tencent.mm.plugin.expt.hellhound.core.b.dJ(findViewByPosition);
                    Object obj2 = dJ.first;
                    p.g(obj2, "xy.first");
                    iVar.x = ((Number) obj2).intValue();
                    Object obj3 = dJ.second;
                    p.g(obj3, "xy.second");
                    iVar.y = ((Number) obj3).intValue();
                    Pair<Float, Float> dK = com.tencent.mm.plugin.expt.hellhound.core.b.dK(findViewByPosition);
                    Object obj4 = dK.first;
                    p.g(obj4, "widthHeightPair.first");
                    iVar.width = ((Number) obj4).floatValue();
                    Object obj5 = dK.second;
                    p.g(obj5, "widthHeightPair.second");
                    iVar.height = ((Number) obj5).floatValue();
                    d(iVar);
                }
            }
            if (((i) entry.getValue()).sGL <= 0.0f) {
                it.remove();
            }
        }
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        HashMap hashMap2 = hashMap;
        p.h(hashMap2, "feedMap");
        if (obj != null) {
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEm.put(Integer.valueOf(obj.hashCode()), hashMap2);
            Map map = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEn;
            String name = obj.getClass().getName();
            p.g(name, "page.javaClass.name");
            map.put(name, hashMap2);
        }
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + hashMap.size() + ", mFeedMap=" + this.sHy.size());
        a(this.sHy, j2);
        AppMethodBeat.o(221107);
    }

    public final Map<String, i> cPv() {
        AppMethodBeat.i(221109);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.sHy);
        af(hashMap);
        HashMap hashMap2 = hashMap;
        AppMethodBeat.o(221109);
        return hashMap2;
    }

    public final void af(Map<String, i> map) {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        AppMethodBeat.i(221110);
        WeakReference<StaggeredGridLayoutManager> weakReference = this.sHJ;
        if (weakReference == null || (staggeredGridLayoutManager = weakReference.get()) == null) {
            AppMethodBeat.o(221110);
            return;
        }
        p.g(staggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
        for (Map.Entry<String, i> entry : map.entrySet()) {
            View findViewByPosition = staggeredGridLayoutManager.findViewByPosition(entry.getValue().position + sHN);
            if (findViewByPosition != null) {
                Pair<Integer, Integer> dJ = com.tencent.mm.plugin.expt.hellhound.core.b.dJ(findViewByPosition);
                Object obj = dJ.first;
                p.g(obj, "xy.first");
                entry.getValue().x = ((Number) obj).intValue();
                Object obj2 = dJ.second;
                p.g(obj2, "xy.second");
                entry.getValue().y = ((Number) obj2).intValue();
                Pair<Float, Float> dK = com.tencent.mm.plugin.expt.hellhound.core.b.dK(findViewByPosition);
                Object obj3 = dK.first;
                p.g(obj3, "widthHeightPair.first");
                entry.getValue().width = ((Number) obj3).floatValue();
                Object obj4 = dK.second;
                p.g(obj4, "widthHeightPair.second");
                entry.getValue().height = ((Number) obj4).floatValue();
                d(entry.getValue());
            }
        }
        AppMethodBeat.o(221110);
    }

    /* access modifiers changed from: package-private */
    public final void Do(long j2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        RecyclerView recyclerView;
        long j3;
        long j4;
        AppMethodBeat.i(221111);
        WeakReference<StaggeredGridLayoutManager> weakReference = this.sHJ;
        if (weakReference == null || (staggeredGridLayoutManager = weakReference.get()) == null) {
            AppMethodBeat.o(221111);
            return;
        }
        p.g(staggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
        WeakReference<RecyclerView> weakReference2 = this.sCb;
        if (weakReference2 == null || (recyclerView = weakReference2.get()) == null) {
            AppMethodBeat.o(221111);
            return;
        }
        p.g(recyclerView, "mRecyclerViewRef?.get() ?: return");
        int[] n = staggeredGridLayoutManager.n(null);
        int min = Math.min(n[0], n[1]);
        int[] o = staggeredGridLayoutManager.o(null);
        int max = Math.max(Math.max(o[0], o[1]) - sHN, 0);
        int max2 = Math.max(min, sHN) - sHN;
        ArrayList arrayList = new ArrayList();
        int i2 = max + 1;
        for (int i3 = max2; i3 < i2; i3++) {
            View findViewByPosition = staggeredGridLayoutManager.findViewByPosition(sHN + i3);
            if (findViewByPosition != null) {
                Pair<Integer, Integer> dJ = com.tencent.mm.plugin.expt.hellhound.core.b.dJ(findViewByPosition);
                p.g(dJ, "HellhoundUtil.getCoordinateOnScreen(feedView)");
                Integer num = (Integer) dJ.first;
                Integer num2 = (Integer) dJ.second;
                i a2 = a(findViewByPosition, i3, recyclerView);
                if (!(a2 == null || a2.feedId == null)) {
                    String str = a2.feedId;
                    if (str == null) {
                        p.hyc();
                    }
                    arrayList.add(str);
                    if (this.sHA <= 0) {
                        j3 = this.sHB;
                    } else {
                        j3 = this.sHA;
                    }
                    a2.sGJ = j3;
                    p.g(num, "x");
                    a2.x = num.intValue();
                    p.g(num2, "y");
                    a2.y = num2.intValue();
                    a2.position = i3;
                    b(a2);
                    c(a2);
                    d(a2);
                    if (!e(a2)) {
                        HashMap<String, i> hashMap = this.sHy;
                        String str2 = a2.feedId;
                        if (hashMap == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                            AppMethodBeat.o(221111);
                            throw tVar;
                        }
                        af.fd(hashMap).remove(str2);
                    } else {
                        a2.sHt = this.sHB;
                        a2.sHu = j2;
                        b bVar = this.sBo;
                        a2.sGR = com.tencent.mm.plugin.expt.hellhound.core.b.aoU(bVar != null ? bVar.GY(a2.position) : null);
                        a2.sHw = a2.sHu - a2.sHt;
                        a2.ddZ = true;
                        this.sHC = 1;
                        a2.sHv = 1;
                        if (a2.sGJ <= 0) {
                            if (this.sHA <= 0) {
                                j4 = this.sHB;
                            } else {
                                j4 = this.sHA;
                            }
                            a2.sGJ = j4;
                        }
                        String str3 = this.sHz;
                        if (str3 == null) {
                            str3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
                        }
                        a2.sessionId = str3;
                        a2.scene = this.mScene;
                        a2.sGQ = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
                    }
                }
            }
        }
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        c.a.cPk();
        AppMethodBeat.o(221111);
    }

    public final void a(Map<String, i> map, long j2) {
        long j3;
        AppMethodBeat.i(221108);
        for (Map.Entry<String, i> entry : map.entrySet()) {
            i value = entry.getValue();
            value.sHu = j2;
            value.sHw = value.sHu - value.sHt;
            value.sHv = this.sHC;
            if (value.sGJ <= 0) {
                if (this.sHA <= 0) {
                    j3 = this.sHB;
                } else {
                    j3 = this.sHA;
                }
                value.sGJ = j3;
            }
            a.C1016a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
            a.C1016a.a(value);
        }
        map.clear();
        AppMethodBeat.o(221108);
    }

    public final void c(i iVar) {
        int i2;
        AppMethodBeat.i(221105);
        if (((float) iVar.x) <= this.sHE) {
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            if (!kotlin.a.j.a((Iterable) com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEK, (Object) iVar.feedId)) {
                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                List list = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEK;
                String str = iVar.feedId;
                if (str == null) {
                    p.hyc();
                }
                list.add(str);
            }
            c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            iVar.sGS = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEK, (Object) iVar.feedId);
            i2 = 0;
        } else {
            c.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            if (!kotlin.a.j.a((Iterable) com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEL, (Object) iVar.feedId)) {
                c.a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                List list2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEL;
                String str2 = iVar.feedId;
                if (str2 == null) {
                    p.hyc();
                }
                list2.add(str2);
            }
            c.a aVar6 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            iVar.sGS = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEL, (Object) iVar.feedId);
            i2 = 1;
        }
        iVar.sHx = i2;
        AppMethodBeat.o(221105);
    }

    public final boolean e(i iVar) {
        int i2 = iVar.y;
        return ((float) i2) < this.sHG && ((float) i2) + iVar.height > this.sHF;
    }
}
