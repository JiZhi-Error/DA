package com.tencent.mm.ui.chatting.monitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.Keep;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.expt.hellhound.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.g.a;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed;
import com.tencent.mm.view.d;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010&\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010(\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010)\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010'H\u0002J,\u0010*\u001a\u00020#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0007J\"\u0010/\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001aH\u0002J$\u00101\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u00010\tH\u0007J\b\u00104\u001a\u00020#H\u0002J\u0012\u00105\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/ui/chatting/monitor/ChatFeedMonitor;", "", "()V", "TAG", "", "chatFooterHeight", "", "listeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "Lkotlin/collections/ArrayList;", "mActionBarHeight", "mChatFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "Lkotlin/collections/HashMap;", "mFirstPostion", "mScreenHeight", "mScreenRealHeight", "mStatusBarHeight", "mVisibleItemCount", "virtualKeyHeight", "_getHellFeed", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "feedView", "Landroid/view/View;", "position", "listView", "Landroid/widget/AbsListView;", "firstPos", "_getLiveFeedUIParams", "view", "getY", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "initActionBarHeight", "Landroid/app/Activity;", "initScreenHeight", "initStatusBarHeight", "monitor", "adapter", "Landroid/widget/BaseAdapter;", "firstPostion", "visibleItemCount", "onFeedAppear", "feed", "onFeedDisappear", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "resetCache", "unregisterListener", "app_release"})
public final class ChatFeedMonitor {
    public static final ChatFeedMonitor INSTANCE = new ChatFeedMonitor();
    private static final String TAG = "HABBYGE-MALI.ChatFeedMonitor";
    private static int chatFooterHeight;
    private static final ArrayList<a> listeners = new ArrayList<>();
    private static int mActionBarHeight;
    private static final HashMap<String, c> mChatFeedCache = new HashMap<>();
    private static int mFirstPostion = -1;
    private static int mScreenHeight;
    private static int mScreenRealHeight;
    private static int mStatusBarHeight;
    private static int mVisibleItemCount = -1;
    private static int virtualKeyHeight;

    static {
        AppMethodBeat.i(231335);
        AppMethodBeat.o(231335);
    }

    private ChatFeedMonitor() {
    }

    @Keep
    public static final void monitor(AbsListView absListView, BaseAdapter baseAdapter, int i2, int i3) {
        com.tencent.mm.vending.j.c<c, Boolean> _getHellFeed;
        AppMethodBeat.i(231322);
        if (absListView == null) {
            AppMethodBeat.o(231322);
        } else if (baseAdapter == null) {
            AppMethodBeat.o(231322);
        } else {
            if (mScreenHeight <= 0) {
                ChatFeedMonitor chatFeedMonitor = INSTANCE;
                Context context = absListView.getContext();
                if (!(context instanceof AppCompatActivity)) {
                    context = null;
                }
                chatFeedMonitor.init((AppCompatActivity) context);
            }
            if (i2 >= 0 && i3 > 0) {
                mFirstPostion = i2;
                mVisibleItemCount = i3;
            }
            int i4 = mVisibleItemCount;
            for (int i5 = 0; i5 < i4; i5++) {
                View childAt = absListView.getChildAt(i5);
                if (!(childAt == null || (_getHellFeed = INSTANCE._getHellFeed(childAt, i5, absListView, mFirstPostion)) == null)) {
                    c hdM = _getHellFeed.hdM();
                    Boolean hdN = _getHellFeed.hdN();
                    p.g(hdN, "isShow");
                    if (hdN.booleanValue()) {
                        if (!mChatFeedCache.containsKey(hdM.msgId)) {
                            String str = hdM.msgId;
                            p.g(str, "chatFeed.msgId");
                            p.g(hdM, "chatFeed");
                            mChatFeedCache.put(str, hdM);
                            INSTANCE.onFeedAppear(baseAdapter, hdM, childAt);
                        }
                    } else if (mChatFeedCache.containsKey(hdM.msgId)) {
                        mChatFeedCache.remove(hdM.msgId);
                        ChatFeedMonitor chatFeedMonitor2 = INSTANCE;
                        p.g(hdM, "chatFeed");
                        chatFeedMonitor2.onFeedDisappear(baseAdapter, hdM, childAt);
                    }
                }
            }
            AppMethodBeat.o(231322);
        }
    }

    private final com.tencent.mm.vending.j.c<c, Boolean> _getHellFeed(View view, int i2, AbsListView absListView, int i3) {
        int i4;
        AppMethodBeat.i(231323);
        if (((ListAdapter) absListView.getAdapter()) == null) {
            AppMethodBeat.o(231323);
            return null;
        }
        int i5 = i3 + i2;
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        p.g(listAdapter, "listView.adapter");
        if (i5 >= listAdapter.getCount()) {
            AppMethodBeat.o(231323);
            return null;
        }
        Object item = ((ListAdapter) absListView.getAdapter()).getItem(i5);
        if (item == null) {
            AppMethodBeat.o(231323);
            return null;
        } else if (!(item instanceof ca)) {
            AppMethodBeat.o(231323);
            return null;
        } else if (view.getTag() == null) {
            AppMethodBeat.o(231323);
            return null;
        } else if (!(view.getTag() instanceof ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)) {
            AppMethodBeat.o(231323);
            return null;
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder");
                AppMethodBeat.o(231323);
                throw tVar;
            }
            com.tencent.mm.ui.chatting.viewitems.c cVar = ((ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder) tag).chattingItem;
            if (cVar == null) {
                AppMethodBeat.o(231323);
                return null;
            }
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            if ((cVar instanceof ChatingItemAppMsgFinderLiveFeed.b) || (cVar instanceof ChatingItemAppMsgFinderLiveFeed.a)) {
                String content = ((ca) item).getContent();
                if (content != null) {
                    k.b aD = k.b.aD(content, ((ca) item).ajQ());
                    if (aD != null) {
                        b bVar = (b) aD.as(b.class);
                        if (bVar == null) {
                            AppMethodBeat.o(231323);
                            return null;
                        }
                        axf axf = bVar.wDV;
                        str = axf.feedId;
                        str2 = axf.hJs;
                        str3 = axf.username;
                        String str5 = axf.nickName;
                        i4 = axf.liveStatus;
                        str4 = str5;
                    } else {
                        i4 = -1;
                    }
                    com.tencent.mm.vending.j.c<Integer, Integer> _getLiveFeedUIParams = _getLiveFeedUIParams(view);
                    Integer hdM = _getLiveFeedUIParams.hdM();
                    Integer hdN = _getLiveFeedUIParams.hdN();
                    c cVar2 = new c();
                    cVar2.msgId = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((ca) item).ajL());
                    cVar2.sBK = new dzv();
                    cVar2.sBK.feedId = str;
                    cVar2.hJs = str2;
                    cVar2.liveStatus = i4;
                    cVar2.sBK.userName = str3;
                    cVar2.sBK.nickName = str4;
                    if (TextUtils.isEmpty(cVar2.sBK.feedId)) {
                        cVar2.sBK.feedId = String.valueOf(absListView.getItemIdAtPosition(i5));
                    }
                    dzv dzv = cVar2.sBK;
                    p.g(hdM, "y");
                    dzv.y = hdM.intValue();
                    dzv dzv2 = cVar2.sBK;
                    p.g(hdN, "height");
                    dzv2.height = hdN.intValue();
                    cVar2.sBK.mEY = mScreenRealHeight;
                    cVar2.sBK.virtualKeyHeight = mScreenRealHeight - mScreenHeight;
                    cVar2.sBK.CHZ = mStatusBarHeight;
                    cVar2.sBK.udM = mActionBarHeight <= 0 ? 144 : mActionBarHeight;
                    cVar2.position = i5;
                    cVar2.sBL = i2;
                    cVar2.chatFooterHeight = chatFooterHeight;
                    com.tencent.mm.vending.j.c<c, Boolean> Q = com.tencent.mm.vending.j.a.Q(cVar2, Boolean.valueOf(cVar2.cOA()));
                    AppMethodBeat.o(231323);
                    return Q;
                }
                AppMethodBeat.o(231323);
                return null;
            }
            AppMethodBeat.o(231323);
            return null;
        }
    }

    private final com.tencent.mm.vending.j.c<Integer, Integer> _getLiveFeedUIParams(View view) {
        AppMethodBeat.i(231324);
        int y = getY(view);
        float y2 = view.getY();
        int e2 = d.e(view.getContext(), 6.0f);
        int max = Math.max(y, (int) y2) + e2;
        int i2 = 721 - (e2 * 2);
        if (view.getHeight() > 721) {
            max += 107;
        }
        com.tencent.mm.vending.j.c<Integer, Integer> Q = com.tencent.mm.vending.j.a.Q(Integer.valueOf(max), Integer.valueOf(i2));
        p.g(Q, "Tuple.make(y, height)");
        AppMethodBeat.o(231324);
        return Q;
    }

    private final int getY(View view) {
        AppMethodBeat.i(231325);
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < 2; i2++) {
            iArr[i2] = -1;
        }
        view.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        AppMethodBeat.o(231325);
        return i3;
    }

    private final void onFeedAppear(BaseAdapter baseAdapter, c cVar, View view) {
        AppMethodBeat.i(231326);
        Iterator<a> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdapter, cVar, view);
        }
        AppMethodBeat.o(231326);
    }

    private final void onFeedDisappear(BaseAdapter baseAdapter, c cVar, View view) {
        AppMethodBeat.i(231327);
        Iterator<a> it = listeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(231327);
    }

    private final void init(AppCompatActivity appCompatActivity) {
        AppMethodBeat.i(231328);
        initStatusBarHeight(appCompatActivity);
        initActionBarHeight(appCompatActivity);
        initScreenHeight(appCompatActivity);
        Log.i(TAG, "init: mScreenRealHeight=" + mScreenRealHeight + ", mScreenHeight=" + mScreenHeight + ", mStatusBarHeight=" + mStatusBarHeight + ", mActionBarHeight=" + mActionBarHeight + ", chatFooterHeight=" + chatFooterHeight + ", virtualKeyHeight=" + virtualKeyHeight);
        AppMethodBeat.o(231328);
    }

    private final void initStatusBarHeight(Activity activity) {
        AppMethodBeat.i(231329);
        if (activity == null) {
            AppMethodBeat.o(231329);
            return;
        }
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        mStatusBarHeight = dimensionPixelSize;
        if (dimensionPixelSize <= 0) {
            mStatusBarHeight = resources.getDimensionPixelSize(R.dimen.a3n);
        }
        AppMethodBeat.o(231329);
    }

    private final void initActionBarHeight(Activity activity) {
        AppMethodBeat.i(231330);
        if (activity == null) {
            AppMethodBeat.o(231330);
            return;
        }
        try {
            if (activity instanceof AppCompatActivity) {
                ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
                View customView = supportActionBar != null ? supportActionBar.getCustomView() : null;
                mActionBarHeight = customView != null ? customView.getHeight() : -1;
                AppMethodBeat.o(231330);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "initBarHeight", new Object[0]);
        }
        AppMethodBeat.o(231330);
    }

    private final void initScreenHeight(Activity activity) {
        Display display;
        int e2;
        Display display2 = null;
        AppMethodBeat.i(231331);
        if (activity == null) {
            AppMethodBeat.o(231331);
            return;
        }
        try {
            Object systemService = MMApplicationContext.getContext().getSystemService("window");
            if (!(systemService instanceof WindowManager)) {
                systemService = null;
            }
            WindowManager windowManager = (WindowManager) systemService;
            display = windowManager != null ? windowManager.getDefaultDisplay() : null;
        } catch (Exception e3) {
            WindowManager windowManager2 = activity.getWindowManager();
            if (windowManager2 != null) {
                display2 = windowManager2.getDefaultDisplay();
            }
            display = display2;
        }
        if (display == null) {
            AppMethodBeat.o(231331);
            return;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(point);
        }
        Point point2 = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(point2);
        }
        mScreenHeight = point.y;
        int i2 = point2.y;
        mScreenRealHeight = i2;
        int i3 = i2 - mScreenHeight;
        if (i3 <= 0) {
            i3 = 0;
        }
        virtualKeyHeight = i3;
        Resources resources = activity.getResources();
        if (resources != null) {
            e2 = resources.getDimensionPixelSize(R.dimen.cp);
        } else {
            e2 = d.e(MMApplicationContext.getContext(), 56.0f);
        }
        chatFooterHeight = e2;
        AppMethodBeat.o(231331);
    }

    @Keep
    public static final void registerListener(a aVar) {
        AppMethodBeat.i(231332);
        if (aVar == null) {
            AppMethodBeat.o(231332);
            return;
        }
        if (!listeners.contains(aVar)) {
            listeners.add(aVar);
        }
        AppMethodBeat.o(231332);
    }

    @Keep
    public static final void unregisterListener(a aVar) {
        AppMethodBeat.i(231333);
        INSTANCE.resetCache();
        if (aVar == null) {
            AppMethodBeat.o(231333);
            return;
        }
        listeners.remove(aVar);
        AppMethodBeat.o(231333);
    }

    private final void resetCache() {
        AppMethodBeat.i(231334);
        mFirstPostion = -1;
        mVisibleItemCount = -1;
        mChatFeedCache.clear();
        AppMethodBeat.o(231334);
    }
}
