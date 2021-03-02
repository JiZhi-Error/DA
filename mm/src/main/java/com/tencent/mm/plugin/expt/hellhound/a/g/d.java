package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.expt.hellhound.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010'\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH\u0002J\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0(2\u0006\u00101\u001a\u00020+H\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00101\u001a\u00020+H\u0002J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0012\u00107\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000108H\u0002J\u0012\u00109\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000108H\u0003J\u0012\u0010:\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000108H\u0002J*\u0010;\u001a\u0002042\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001bJ\"\u0010@\u001a\u0002042\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010A\u001a\u00020!2\u0006\u00101\u001a\u00020+H\u0002J$\u0010B\u001a\u0002042\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010A\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010C\u001a\u0002042\b\u0010D\u001a\u0004\u0018\u00010\u0018J\b\u0010E\u001a\u000204H\u0002J\u0010\u0010F\u001a\u0002042\b\u0010D\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!`\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/SnsFeedMonitor;", "", "()V", "AdSnsInfoClassName", "", "IdName", "SnsInfoClassName", "TAG", "TimeLineObjectClassName", "UserNameName", "adCardActionBtnInfoField", "Ljava/lang/reflect/Field;", "adsnsinfoField", "adsnsinfoName", "finderLiveIdField", "finderUsernameField", "getAdXmlMethod", "Ljava/lang/reflect/Method;", "getAdXmlMethodName", "getTimeLineMethod", "getTimeLineMethodName", "idField", "listeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "Lkotlin/collections/ArrayList;", "mActionBarHeight", "", "mFirstPostion", "mScreenHeight", "mScreenRealHeight", "mSnsFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "Lkotlin/collections/HashMap;", "mStatusBarHeight", "mVisibleItemCount", "userNameField", "virtualKeyHeight", "_getHellFeed", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "feedView", "Landroid/view/View;", "position", "listView", "Landroid/widget/AbsListView;", "firstPos", "_getUIParams", "view", "getY", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "initActionBarHeight", "Landroid/app/Activity;", "initScreenHeight", "initStatusBarHeight", "monitor", "adapter", "Landroid/widget/BaseAdapter;", "firstPostion", "visibleItemCount", "onFeedAppear", "feed", "onFeedDisappear", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "resetCache", "unregisterListener", "plugin-expt_release"})
public final class d {
    public static final ArrayList<a> listeners = new ArrayList<>();
    public static int mActionBarHeight;
    public static int mFirstPostion = -1;
    public static int mScreenHeight;
    public static int mScreenRealHeight;
    public static int mStatusBarHeight;
    public static int mVisibleItemCount = -1;
    private static Method sBS;
    private static Field sBT;
    public static final HashMap<String, c> sJk = new HashMap<>();
    private static Field sJl;
    private static Field sJm;
    private static Method sJn;
    private static Field sJo;
    private static Field sJp;
    private static Field sJq;
    public static final d sJr = new d();
    public static int virtualKeyHeight;

    static {
        AppMethodBeat.i(221149);
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.sns.storage.SnsInfo");
            p.g(cls, "Class.forName(SnsInfoClassName)");
            Method declaredMethod = cls.getDeclaredMethod("getTimeLine", new Class[0]);
            sBS = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
            Class<?> cls2 = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
            p.g(cls2, "Class.forName(TimeLineObjectClassName)");
            Field declaredField = cls2.getDeclaredField("Id");
            sBT = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls2.getDeclaredField("UserName");
            sJl = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Field declaredField3 = cls.getDeclaredField("adsnsinfo");
            sJm = declaredField3;
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
            }
            Class<?> cls3 = Class.forName("com.tencent.mm.plugin.sns.storage.AdSnsInfo");
            p.g(cls3, "Class.forName(AdSnsInfoClassName)");
            Method declaredMethod2 = cls3.getDeclaredMethod("getAdXml", new Class[0]);
            sJn = declaredMethod2;
            if (declaredMethod2 != null) {
                declaredMethod2.setAccessible(true);
            }
            Class<?> cls4 = Class.forName("com.tencent.mm.plugin.sns.storage.ADXml");
            p.g(cls4, "Class.forName(\"com.tence…lugin.sns.storage.ADXml\")");
            Field declaredField4 = cls4.getDeclaredField("adCardActionBtnInfo");
            sJo = declaredField4;
            if (declaredField4 != null) {
                declaredField4.setAccessible(true);
            }
            Class<?> cls5 = Class.forName("com.tencent.mm.plugin.sns.storage.ADXml$AdCardActionBtnInfo");
            p.g(cls5, "Class.forName(\"com.tence…ml\\$AdCardActionBtnInfo\")");
            Field declaredField5 = cls5.getDeclaredField("finderUsername");
            sJp = declaredField5;
            if (declaredField5 != null) {
                declaredField5.setAccessible(true);
            }
            Field declaredField6 = cls5.getDeclaredField("finderLiveId");
            sJq = declaredField6;
            if (declaredField6 != null) {
                declaredField6.setAccessible(true);
                AppMethodBeat.o(221149);
                return;
            }
            AppMethodBeat.o(221149);
        } catch (Exception e2) {
            Log.e("HABBYGE-MALI.SnsFeedMonitor", "SnsFeedMonitor, init-1, crash: " + e2.getMessage());
            AppMethodBeat.o(221149);
        }
    }

    private d() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.vending.j.c<com.tencent.mm.plugin.expt.hellhound.a.a.c, java.lang.Boolean> _getHellFeed(android.view.View r10, int r11, android.widget.AbsListView r12, int r13) {
        /*
        // Method dump skipped, instructions count: 507
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.g.d._getHellFeed(android.view.View, int, android.widget.AbsListView, int):com.tencent.mm.vending.j.c");
    }

    public static void registerListener(a aVar) {
        AppMethodBeat.i(221144);
        if (aVar == null) {
            AppMethodBeat.o(221144);
            return;
        }
        if (!listeners.contains(aVar)) {
            listeners.add(aVar);
        }
        AppMethodBeat.o(221144);
    }

    public static void onFeedAppear(BaseAdapter baseAdapter, c cVar, View view) {
        AppMethodBeat.i(221145);
        Iterator<a> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdapter, cVar, view);
        }
        AppMethodBeat.o(221145);
    }

    public static void cQU() {
        AppMethodBeat.i(221146);
        Iterator<a> it = listeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(221146);
    }

    public static void initActionBarHeight(Activity activity) {
        AppMethodBeat.i(221147);
        if (activity == null) {
            AppMethodBeat.o(221147);
            return;
        }
        try {
            if (activity instanceof AppCompatActivity) {
                ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
                View customView = supportActionBar != null ? supportActionBar.getCustomView() : null;
                mActionBarHeight = customView != null ? customView.getHeight() : -1;
                AppMethodBeat.o(221147);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SnsFeedMonitor", e2, "initBarHeight", new Object[0]);
        }
        AppMethodBeat.o(221147);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static void initScreenHeight(Activity activity) {
        Display display;
        Display display2 = null;
        AppMethodBeat.i(221148);
        if (activity == null) {
            AppMethodBeat.o(221148);
            return;
        }
        try {
            Object systemService = MMApplicationContext.getContext().getSystemService("window");
            if (!(systemService instanceof WindowManager)) {
                systemService = null;
            }
            WindowManager windowManager = (WindowManager) systemService;
            display = windowManager != null ? windowManager.getDefaultDisplay() : null;
        } catch (Exception e2) {
            WindowManager windowManager2 = activity.getWindowManager();
            if (windowManager2 != null) {
                display2 = windowManager2.getDefaultDisplay();
            }
            display = display2;
        }
        if (display == null) {
            AppMethodBeat.o(221148);
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
        AppMethodBeat.o(221148);
    }
}
