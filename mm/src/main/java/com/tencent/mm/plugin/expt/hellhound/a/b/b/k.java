package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.o;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.m;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0012\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010*\u001a\u0004\u0018\u00010+H\u0007J\u0014\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0007J\u0006\u0010.\u001a\u00020%J\"\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0007J\"\u00105\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0007J\u001a\u00106\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00103\u001a\u000204H\u0007J\u001a\u00107\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00103\u001a\u000204H\u0007J\u001a\u00108\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00103\u001a\u000204H\u0007J\u001a\u00109\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00103\u001a\u000204H\u0007J\u0006\u0010:\u001a\u00020%J\u001a\u0010;\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>J\u0006\u0010?\u001a\u00020%J\u001a\u0010@\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>J\u0016\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u000202J\u001e\u0010E\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010F\u001a\u0002022\u0006\u0010G\u001a\u000202J\u000e\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u00020%2\u0006\u0010I\u001a\u00020LH\u0007J\u000e\u0010M\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0016J\u0012\u0010N\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010O\u001a\u00020%2\u0006\u0010,\u001a\u00020P2\u0006\u0010Q\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u0010R\u001a\u000202J\u0012\u0010S\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010T\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010U\u001a\u00020%2\b\u0010V\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010W\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010Q\u001a\u0004\u0018\u00010+2\u0006\u00103\u001a\u0002042\u0006\u0010X\u001a\u000202H\u0007J\u0012\u0010Y\u001a\u00020%2\b\u0010Z\u001a\u0004\u0018\u00010'H\u0007J\u0012\u0010[\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\\\u001a\u00020%2\u0006\u0010,\u001a\u00020P2\u0006\u0010Q\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u0010R\u001a\u000202J\u0012\u0010]\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010^\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010_\u001a\u00020%2\b\u0010V\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010`\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010Q\u001a\u0004\u0018\u00010+2\u0006\u00103\u001a\u0002042\u0006\u0010X\u001a\u000202H\u0007J\u000e\u0010a\u001a\u00020%2\u0006\u0010I\u001a\u00020JJ\b\u0010b\u001a\u00020%H\u0007J\u000e\u0010c\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000RN\u0010\u0017\u001aB\u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a0\u00190\u0018j \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a0\u0019`\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback;", "", "()V", "DESC_onScrollStateChanged", "", "DESC_onScrolled", "NAME_onScrollStateChanged", "NAME_onScrolled", "SUPER_NAME", "TAG", "mClickCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "mFinderFragmentCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "mFragmentFeedStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FragmentFeedStatistics;", "mItemDecorationCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "mRefreshLoadMoreCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mShareStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "mSnsFinderMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/SnsFinderMonitor;", "mWaterfallsFlowMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "begin19943OfsnsFinder", "", "session", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "fragmentFeedFlowOnFree", "activityName", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "monitor", "on7Event", "pageName", "hashCode", "", AppMeasurement.Param.TIMESTAMP, "", "on8Event", "onActivityCreate", "onFinderHomeUIPaused", "onFinderHomeUIResumed", "onFinishActivity", "onLoadMoreBegin", "onLoadMoreEnd", "className", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "registerClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "registerFinderFragmentListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "registerListener", "startFinderFragmentMonitor", "startFragmentFeedFlowMonitor", "Landroid/support/v4/app/FragmentActivity;", "fragment", "fragmentEventId", "startItemDecorationMonitor", "startMonitorClick", "startSnsFinderMonitor", "sPageName", "startWaterfallsFlowMonitor", "eventId", "stop19943OfsnsFinder", "curSession", "stopFinderFragmentMonitor", "stopFragmentFeedFlowMonitor", "stopItemDecorationMonitor", "stopMonitorClick", "stopSnsFinderMonitor", "stopWaterfallsFlowMonitor", "unregisterClickListener", "unregisterFinderFragmentListener", "unregisterListener", "RecycylerScrollListener", "plugin-expt_release"})
public final class k {
    private static final List<e> mListeners = new ArrayList();
    private static c sAd = new a();
    private static final HashMap<String, List<Pair<String, String>>> sEh = new HashMap<>();
    private static final l sFQ = new l();
    private static final b sFR = new b();
    private static final m sFS = new m();
    private static final com.tencent.mm.plugin.expt.hellhound.a.b.c sFT = new com.tencent.mm.plugin.expt.hellhound.a.b.c();
    private static final b sFU = new b();
    private static final d sFV = new d();
    private static final a sFW = new a();
    private static final n sFX = new n();
    public static final k sFY = new k();

    static {
        AppMethodBeat.i(220998);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V"));
        arrayList.add(Pair.create("onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V"));
        sEh.put("android/support/v7/widget/RecyclerView$OnScrollListener", arrayList);
        AppMethodBeat.o(220998);
    }

    private k() {
    }

    public static void cMH() {
        AppMethodBeat.i(220966);
        Log.i("HABBYGE-MALI.RecyclerCallback", "monitor...");
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(sEh, sAd);
        m mVar = sFS;
        Log.i("HABBYGE-MALI.RefreshLoadMoreCallback", "startMonitor...");
        i iVar = new i();
        Log.i("HABBYGE-MALI.RLBeginCallback", "startMonitor...");
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(iVar.sEh, iVar.sFK);
        j jVar = new j(mVar);
        Log.i("HABBYGE-MALI.RLEndCallback", "startMonitor...");
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(jVar.sEh, jVar.sFM);
        o oVar = new o(mVar);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(oVar.sEh, oVar.sGr);
        new h();
        f.sHi.reset();
        f.sHi.cPr();
        AppMethodBeat.o(220966);
    }

    public final synchronized void a(e eVar) {
        AppMethodBeat.i(220967);
        p.h(eVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!mListeners.contains(eVar)) {
            mListeners.add(eVar);
        }
        AppMethodBeat.o(220967);
    }

    public final synchronized void b(e eVar) {
        AppMethodBeat.i(220968);
        p.h(eVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        mListeners.remove(eVar);
        AppMethodBeat.o(220968);
    }

    public static final void apN(String str) {
        AppMethodBeat.i(220969);
        l lVar = sFQ;
        if (!l.apW(str)) {
            Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "monitor");
            WeakReference<RecyclerView> weakReference = lVar.sCb;
            if (weakReference != null) {
                weakReference.clear();
            }
            com.tencent.mm.hellhoundlib.a.axP();
            com.tencent.mm.hellhoundlib.a.c(lVar.sEh, lVar.sFZ);
        }
        AppMethodBeat.o(220969);
    }

    public static final void apO(String str) {
        RecyclerView recyclerView;
        AppMethodBeat.i(220970);
        l lVar = sFQ;
        if (!l.apW(str)) {
            Log.i("HABBYGE-MALI.RecyclerItemDecorationCallback", "unmonitor");
            WeakReference<RecyclerView> weakReference = lVar.sCb;
            if (!(weakReference == null || (recyclerView = weakReference.get()) == null)) {
                recyclerView.b(lVar.sGa);
            }
            WeakReference<RecyclerView> weakReference2 = lVar.sCb;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
            lVar.sCb = null;
            com.tencent.mm.hellhoundlib.a.axP();
            com.tencent.mm.hellhoundlib.a.d(lVar.sEh, lVar.sFZ);
        }
        AppMethodBeat.o(220970);
    }

    public static final void apP(String str) {
        AppMethodBeat.i(220971);
        b bVar = sFR;
        bVar.sDY = str;
        if (!(!p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", str)) || !(!p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", str))) {
            Log.i("HABBYGE-MALI.FinderFragmentCallback", "monitor...");
            bVar.afB = -1;
            bVar.sEa = true;
            bVar.sEb = false;
            com.tencent.mm.hellhoundlib.a.axP();
            com.tencent.mm.hellhoundlib.a.c(bVar.sEh, bVar.sEi);
        }
        AppMethodBeat.o(220971);
    }

    public static final void apQ(String str) {
        AppMethodBeat.i(220972);
        b bVar = sFR;
        bVar.sDZ = str;
        if (!(!p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", str)) || !(!p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", str))) {
            Log.i("HABBYGE-MALI.FinderFragmentCallback", "unmonitor...");
            bVar.sEa = false;
            bVar.sEb = true;
            com.tencent.mm.hellhoundlib.a.axP();
            com.tencent.mm.hellhoundlib.a.d(bVar.sEh, bVar.sEi);
        }
        AppMethodBeat.o(220972);
    }

    public static final void a(com.tencent.mm.plugin.expt.hellhound.core.d dVar) {
        AppMethodBeat.i(220973);
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        b bVar = sFR;
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        com.tencent.mm.plugin.expt.hellhound.a.b.b bVar2 = bVar.sEc;
        if (bVar2 != null) {
            p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            bVar2.szZ = dVar;
            AppMethodBeat.o(220973);
            return;
        }
        AppMethodBeat.o(220973);
    }

    public static final Fragment cOk() {
        UIComponentFragment uIComponentFragment;
        UIComponentActivity uIComponentActivity;
        AppMethodBeat.i(220974);
        b bVar = sFR;
        com.tencent.mm.plugin.expt.hellhound.a.b.b bVar2 = bVar.sEc;
        if (bVar2 != null) {
            WeakReference<Fragment> weakReference = bVar2.sCC;
            uIComponentFragment = weakReference != null ? weakReference.get() : null;
        } else {
            uIComponentFragment = null;
        }
        if (uIComponentFragment == null) {
            WeakReference<UIComponentActivity> weakReference2 = bVar.sEd;
            if (weakReference2 != null) {
                uIComponentActivity = weakReference2.get();
            } else {
                uIComponentActivity = null;
            }
            uIComponentFragment = bVar.l(uIComponentActivity, -1);
        }
        AppMethodBeat.o(220974);
        return uIComponentFragment;
    }

    public static final Fragment ab(Activity activity) {
        Class<?> cls;
        String name;
        UIComponentFragment uIComponentFragment = null;
        AppMethodBeat.i(220975);
        b bVar = sFR;
        if (!(activity == null || (cls = activity.getClass()) == null || (name = cls.getName()) == null)) {
            p.g(name, "activity?.javaClass?.name ?: return null");
            if (!(!p.j(name, "com.tencent.mm.plugin.finder.ui.FinderHomeUI")) || !(!p.j(name, "com.tencent.mm.plugin.finder.ui.FinderConversationUI"))) {
                uIComponentFragment = bVar.l(null, -1);
            }
        }
        UIComponentFragment uIComponentFragment2 = uIComponentFragment;
        AppMethodBeat.o(220975);
        return uIComponentFragment2;
    }

    public static final void d(Activity activity, long j2) {
        String str;
        Class<?> cls;
        String name;
        boolean z;
        String aoE;
        Class<?> cls2;
        AppMethodBeat.i(220976);
        if (activity == null || (cls2 = activity.getClass()) == null) {
            str = null;
        } else {
            str = cls2.getName();
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -2055689330:
                    if (str.equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
                        b bVar = sFR;
                        if (activity == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(220976);
                            throw tVar;
                        }
                        bVar.b((FragmentActivity) activity, j2);
                        AppMethodBeat.o(220976);
                        return;
                    }
                    break;
                case -2013384910:
                    if (str.equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
                        b bVar2 = sFR;
                        if (activity == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(220976);
                            throw tVar2;
                        }
                        bVar2.b((FragmentActivity) activity, j2);
                        AppMethodBeat.o(220976);
                        return;
                    }
                    break;
                case -936307702:
                    if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
                        b bVar3 = sFR;
                        if (activity == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(220976);
                            throw tVar3;
                        }
                        p.h((FragmentActivity) activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                        com.tencent.mm.plugin.expt.hellhound.a.b.b bVar4 = bVar3.sEc;
                        if (bVar4 != null) {
                            bVar4.sCF = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
                            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar5 = bVar4.sCF;
                            if (bVar5 == null) {
                                p.btv("statyTimeStaticLbsList");
                            }
                            bVar5.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
                            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar6 = bVar4.sCF;
                            if (bVar6 == null) {
                                p.btv("statyTimeStaticLbsList");
                            }
                            bVar6.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
                            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar7 = bVar4.sCF;
                            if (bVar7 == null) {
                                p.btv("statyTimeStaticLbsList");
                            }
                            bVar7.sGC = j2;
                            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar8 = bVar4.sCF;
                            if (bVar8 == null) {
                                p.btv("statyTimeStaticLbsList");
                            }
                            bVar8.sGF = "143";
                            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar9 = bVar4.sCF;
                            if (bVar9 == null) {
                                p.btv("statyTimeStaticLbsList");
                            }
                            bVar9.dYn = c.b.EXPOSURE.value;
                            Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIResume...");
                            AppMethodBeat.o(220976);
                            return;
                        }
                        AppMethodBeat.o(220976);
                        return;
                    }
                    break;
            }
        }
        d dVar = sFV;
        if (activity != null) {
            String name2 = activity.getClass().getName();
            p.g(name2, "activity.javaClass.name");
            c.a aVar = c.sFa;
            if (c.sEV.contains(name2) && dVar.sHb == null && (aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(name2)) != null) {
                p.g(aoE, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
                int hashCode = activity.hashCode();
                String stringExtra = activity.getIntent().getStringExtra("key_extra_info");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                d.a(aoE, hashCode, j2, stringExtra);
                Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, sPage=" + aoE + ", hashCode=" + hashCode);
                if (f.sHi.dm(aoE, hashCode) == null) {
                    cym cym = new cym();
                    cym.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
                    cym.dMl = aoE;
                    cym.aHK = hashCode;
                    cym.sGC = j2;
                    b.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
                    cym.sGF = b.a.cPQ();
                    cym.dYn = c.b.INOUT.value;
                    cym.extraInfo = stringExtra;
                    f.sHi.c(cym);
                    Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV2, YES, sPage=" + aoE + ", hashCode=" + hashCode);
                    dVar.sHb = aoE;
                }
            }
        }
        if (activity == null || (cls = activity.getClass()) == null || (name = cls.getName()) == null) {
            AppMethodBeat.o(220976);
            return;
        }
        p.g(name, "activity?.javaClass?.name ?: return");
        c.a aVar3 = c.sFa;
        if (c.sEU.contains(name) && (dVar.sHa == null || !(!p.j(name, dVar.sHa)))) {
            dVar.sHa = name;
            dVar.sGZ = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar10 = dVar.sGZ;
            if (bVar10 == null) {
                p.btv("mStayTime");
            }
            bVar10.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar11 = dVar.sGZ;
            if (bVar11 == null) {
                p.btv("mStayTime");
            }
            bVar11.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(name);
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar12 = dVar.sGZ;
            if (bVar12 == null) {
                p.btv("mStayTime");
            }
            bVar12.sGC = j2;
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar13 = dVar.sGZ;
            if (bVar13 == null) {
                p.btv("mStayTime");
            }
            b.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
            bVar13.sGF = b.a.cPQ();
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar14 = dVar.sGZ;
            if (bVar14 == null) {
                p.btv("mStayTime");
            }
            bVar14.dYn = c.b.EXPOSURE.value;
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar15 = dVar.sGZ;
            if (bVar15 == null) {
                p.btv("mStayTime");
            }
            String stringExtra2 = activity.getIntent().getStringExtra("key_extra_info");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            bVar15.extraInfo = stringExtra2;
            if (p.j(name, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar16 = dVar.sGZ;
                if (bVar16 == null) {
                    p.btv("mStayTime");
                }
                c.a aVar5 = c.sFa;
                if (c.sEX == c.d.Poi.value) {
                    z = true;
                } else {
                    z = false;
                }
                bVar16.sGG = z;
            } else {
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar17 = dVar.sGZ;
                if (bVar17 == null) {
                    p.btv("mStayTime");
                }
                bVar17.sGG = false;
            }
            StringBuilder sb = new StringBuilder("doPageResume: ");
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar18 = dVar.sGZ;
            if (bVar18 == null) {
                p.btv("mStayTime");
            }
            Log.i("HABBYGE-MALI.FinderShareStatistics", sb.append(bVar18.dMl).toString());
        }
        AppMethodBeat.o(220976);
    }

    public static final void e(Activity activity, long j2) {
        String str;
        boolean z;
        Class<?> cls;
        String name;
        Class<?> cls2;
        AppMethodBeat.i(220977);
        if (activity == null || (cls2 = activity.getClass()) == null) {
            str = null;
        } else {
            str = cls2.getName();
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -2055689330:
                    if (str.equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI")) {
                        b bVar = sFR;
                        if (activity == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(220977);
                            throw tVar;
                        }
                        bVar.c((FragmentActivity) activity, j2);
                        AppMethodBeat.o(220977);
                        return;
                    }
                    break;
                case -2013384910:
                    if (str.equals("com.tencent.mm.plugin.finder.ui.FinderConversationUI")) {
                        b bVar2 = sFR;
                        if (activity == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(220977);
                            throw tVar2;
                        }
                        bVar2.c((FragmentActivity) activity, j2);
                        AppMethodBeat.o(220977);
                        return;
                    }
                    break;
                case -936307702:
                    if (str.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")) {
                        b bVar3 = sFR;
                        if (activity == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(220977);
                            throw tVar3;
                        }
                        p.h((FragmentActivity) activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                        com.tencent.mm.plugin.expt.hellhound.a.b.b bVar4 = bVar3.sEc;
                        if (bVar4 != null) {
                            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
                            if (bVar4.sCF != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar5 = bVar4.sCF;
                                if (bVar5 == null) {
                                    p.btv("statyTimeStaticLbsList");
                                }
                                if (p.j(bVar5.dMl, aoE)) {
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar6 = bVar4.sCF;
                                    if (bVar6 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    bVar6.sGD = j2;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar7 = bVar4.sCF;
                                    if (bVar7 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    long j3 = bVar7.sGD;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar8 = bVar4.sCF;
                                    if (bVar8 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    long j4 = j3 - bVar8.sGC;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar9 = bVar4.sCF;
                                    if (bVar9 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    bVar9.sGB = j4;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar10 = bVar4.sCF;
                                    if (bVar10 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    bVar10.sGF = "143";
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar11 = bVar4.sCF;
                                    if (bVar11 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    bVar11.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
                                    a.C1016a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar12 = bVar4.sCF;
                                    if (bVar12 == null) {
                                        p.btv("statyTimeStaticLbsList");
                                    }
                                    a.C1016a.a(bVar12);
                                    Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderLbsStreamListUIPause...");
                                }
                            }
                            AppMethodBeat.o(220977);
                            return;
                        }
                        AppMethodBeat.o(220977);
                        return;
                    }
                    break;
            }
        }
        d dVar = sFV;
        if (activity == null || (cls = activity.getClass()) == null || (name = cls.getName()) == null) {
            AppMethodBeat.o(220977);
            return;
        }
        p.g(name, "activity?.javaClass?.name ?: return");
        c.a aVar2 = c.sFa;
        if (c.sEU.contains(name)) {
            if (dVar.sHa == null) {
                AppMethodBeat.o(220977);
                return;
            } else if (!(!p.j(name, dVar.sHa))) {
                if (dVar.sHb == null) {
                    dVar.sHa = null;
                }
                String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(name);
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar13 = dVar.sGZ;
                if (bVar13 == null) {
                    p.btv("mStayTime");
                }
                if (p.j(bVar13.dMl, aoE2)) {
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar14 = dVar.sGZ;
                    if (bVar14 == null) {
                        p.btv("mStayTime");
                    }
                    bVar14.sGD = j2;
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar15 = dVar.sGZ;
                    if (bVar15 == null) {
                        p.btv("mStayTime");
                    }
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar16 = dVar.sGZ;
                    if (bVar16 == null) {
                        p.btv("mStayTime");
                    }
                    long j5 = bVar16.sGD;
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar17 = dVar.sGZ;
                    if (bVar17 == null) {
                        p.btv("mStayTime");
                    }
                    bVar15.sGB = j5 - bVar17.sGC;
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar18 = dVar.sGZ;
                    if (bVar18 == null) {
                        p.btv("mStayTime");
                    }
                    bVar18.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar19 = dVar.sGZ;
                    if (bVar19 == null) {
                        p.btv("mStayTime");
                    }
                    String stringExtra = activity.getIntent().getStringExtra("key_enter_source_info");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    bVar19.sGH = stringExtra;
                    a.C1016a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
                    com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar20 = dVar.sGZ;
                    if (bVar20 == null) {
                        p.btv("mStayTime");
                    }
                    a.C1016a.a(bVar20);
                    Log.i("HABBYGE-MALI.FinderShareStatistics", "onPagePaused: ".concat(String.valueOf(aoE2)));
                }
            }
        }
        AppMethodBeat.o(220977);
    }

    public static final void cPn() {
    }

    public static final void f(Activity activity, long j2) {
        long j3 = 0;
        AppMethodBeat.i(220978);
        d dVar = sFV;
        if (activity == null) {
            AppMethodBeat.o(220978);
            return;
        }
        String name = activity.getClass().getName();
        p.g(name, "activity.javaClass.name");
        c.a aVar = c.sFa;
        if (c.sEV.contains(name)) {
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(name);
            if (aoE == null) {
                AppMethodBeat.o(220978);
                return;
            }
            p.g(aoE, "HellhoundUtil.getShortNa…fPage(pageName) ?: return");
            int hashCode = activity.hashCode();
            String stringExtra = activity.getIntent().getStringExtra("key_enter_source_info");
            if (stringExtra == null) {
                stringExtra = "";
            }
            dVar.sHb = null;
            Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: sPage=" + aoE + ", hashCode=" + hashCode + ", enterSourceInfo=" + stringExtra);
            cym dk = f.sHi.dk(aoE, hashCode);
            if (dk != null) {
                Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: compare, " + dk.dMl + " == " + aoE + ", " + dk.aHK + " == " + hashCode);
                dk.sGD = j2;
                long j4 = dk.sGD - dk.sGC;
                LinkedList<Long> linkedList = dk.MDv;
                p.g(linkedList, "statistics.stayTimeOnBackground");
                long ab = j4 - d.ab(linkedList);
                if (ab >= 0) {
                    j3 = ab;
                }
                dk.sGB = j3;
                dk.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
                dk.dYn = c.b.INOUT_WITHOUT_78EVENT.value;
                dk.sGH = stringExtra;
                a.C1016a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
                a.C1016a.a(d.a(dk, c.b.INOUT_WITHOUT_78EVENT.value));
                f.sHi.dl(aoE, hashCode);
                Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV1: report, " + aoE + ", " + hashCode);
            }
            Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: sPage=" + aoE + ", hashCode=" + hashCode + ", enterSourceInfo=" + stringExtra);
            cym dm = f.sHi.dm(aoE, hashCode);
            if (dm == null) {
                AppMethodBeat.o(220978);
                return;
            }
            Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: compare, " + dm.dMl + " == " + aoE + ", " + dm.aHK + " == " + hashCode);
            dm.sGD = j2;
            dm.sGB = dm.sGD - dm.sGC;
            dm.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
            dm.dYn = c.b.INOUT.value;
            dm.sGH = stringExtra;
            a.C1016a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
            a.C1016a.a(d.a(dm, c.b.INOUT.value));
            f.sHi.dn(aoE, hashCode);
            Log.i("HABBYGE-MALI.FinderShareStatistics", "onFinishActivityV2: report, " + aoE + ", " + hashCode);
        }
        AppMethodBeat.o(220978);
    }

    public static final void a(Activity activity, Fragment fragment, long j2, int i2) {
        String name;
        Class<?> cls;
        Class<?> cls2;
        AppMethodBeat.i(220981);
        com.tencent.mm.plugin.expt.hellhound.a.b.c cVar = sFT;
        if (fragment == null) {
            name = (activity == null || (cls2 = activity.getClass()) == null) ? null : cls2.getName();
        } else {
            name = fragment.getClass().getName();
        }
        c.a aVar = c.sFa;
        if (c.sEW.contains(name)) {
            Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", "monitor: poageName=".concat(String.valueOf(name)));
            cVar.sCH = name;
            sFY.a(cVar.sCJ);
            cVar.sCI = new j(activity, fragment);
            j jVar = cVar.sCI;
            if (jVar != null) {
                if (fragment != null) {
                    switch (i2) {
                        case 0:
                            Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, resume !!");
                            jVar.n(fragment, j2);
                            break;
                        case 1:
                        default:
                            Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
                            break;
                        case 2:
                            Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 7Event !!");
                            jVar.n(fragment, j2);
                            break;
                    }
                } else {
                    String name2 = (activity == null || (cls = activity.getClass()) == null) ? null : cls.getName();
                    if (!p.j(name2, c.sEQ)) {
                        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: Back to activity !!");
                        jVar.n(activity, j2);
                    } else if (p.j(name2, c.sES)) {
                        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: 7Event !!");
                        jVar.n(activity, j2);
                    } else {
                        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, ACTION: startActivity !!");
                    }
                    c.sER = null;
                    c.sEQ = null;
                }
                c.b bVar = jVar.sHI.sGV;
                p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                sFW.a(bVar);
                AppMethodBeat.o(220981);
                return;
            }
        }
        AppMethodBeat.o(220981);
    }

    public static final void b(Activity activity, Fragment fragment, long j2, int i2) {
        String name;
        boolean z;
        Class<?> cls;
        Class<?> cls2;
        AppMethodBeat.i(220982);
        com.tencent.mm.plugin.expt.hellhound.a.b.c cVar = sFT;
        if (fragment == null) {
            name = (activity == null || (cls2 = activity.getClass()) == null) ? null : cls2.getName();
        } else {
            name = fragment.getClass().getName();
        }
        c.a aVar = c.sFa;
        if (c.sEW.contains(name)) {
            Log.i("HABBYGE-MALI.WaterfallsFlowMonitor", "unmonitor: poageName=".concat(String.valueOf(name)));
            sFY.b(cVar.sCJ);
            j jVar = cVar.sCI;
            if (jVar != null) {
                if (fragment != null) {
                    switch (i2) {
                        case 1:
                            Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, pause !!");
                            jVar.sHC = 1;
                            jVar.o(fragment, j2);
                            break;
                        case 2:
                        default:
                            Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", new NullPointerException("startCompute, fragment, miss !!"), "", new Object[0]);
                            break;
                        case 3:
                            Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "startCompute, fragment, 8Event !!");
                            jVar.sHC = 2;
                            jVar.o(fragment, j2);
                            break;
                    }
                } else {
                    String name2 = (activity == null || (cls = activity.getClass()) == null) ? null : cls.getName();
                    Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: pageName=".concat(String.valueOf(name2)));
                    if (p.j(name2, c.sER)) {
                        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: finish cur page !");
                        jVar.sHC = 1;
                        z = true;
                    } else if (!(!p.j(name2, c.sEQ)) || c.sEQ == null) {
                        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: 8Event !");
                        jVar.sHC = 2;
                        z = false;
                    } else {
                        Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "stopCompute: ACTION: startActivity another page !");
                        jVar.sHC = 1;
                        z = false;
                    }
                    jVar.o(activity, j2);
                    if (z) {
                        c.a aVar2 = c.sFa;
                        c.a.cPj();
                    }
                }
                c.b bVar = jVar.sHI.sGV;
                p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                sFW.b(bVar);
            }
            cVar.sCI = null;
        }
        AppMethodBeat.o(220982);
    }

    public static final void apR(String str) {
        AppMethodBeat.i(220983);
        if (p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", str) || p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", str)) {
            com.tencent.mm.plugin.expt.hellhound.a.a.b bVar = sFU;
            Log.i("HABBYGE-MALI.FragmentFeedStatistics", "stop: free...");
            o oVar = bVar.sBG;
            if (oVar != null) {
                oVar.free();
            }
            bVar.sBG = null;
            o oVar2 = bVar.sBH;
            if (oVar2 != null) {
                oVar2.free();
            }
            bVar.sBH = null;
            o oVar3 = bVar.sBI;
            if (oVar3 != null) {
                oVar3.free();
            }
            bVar.sBI = null;
        }
        AppMethodBeat.o(220983);
    }

    public static final void apS(String str) {
        AppMethodBeat.i(220984);
        if (p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", str) || p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", str)) {
            sFW.cMH();
            AppMethodBeat.o(220984);
            return;
        }
        b.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
        String cPQ = b.a.cPQ();
        if ((p.j(cPQ, "999") || p.j(cPQ, "101") || p.j(cPQ, "102") || p.j(cPQ, "123")) && (p.j("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", str) || p.j("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", str) || p.j("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", str))) {
            sFW.cMH();
        }
        AppMethodBeat.o(220984);
    }

    public static final void apT(String str) {
        AppMethodBeat.i(220985);
        if (str == null) {
            AppMethodBeat.o(220985);
            return;
        }
        switch (str.hashCode()) {
            case 521671213:
                if (str.equals("SnsTimeLineUI")) {
                    sFX.cMH();
                    AppMethodBeat.o(220985);
                    return;
                }
                break;
            case 1994393452:
                if (str.equals("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI")) {
                    sFX.cMH();
                    break;
                }
                break;
        }
        AppMethodBeat.o(220985);
    }

    public static final void apU(String str) {
        AppMethodBeat.i(220986);
        if (p.j("SnsTimeLineUI", str) || p.j("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", str)) {
            sFX.cOG();
        }
        AppMethodBeat.o(220986);
    }

    public static final void a(cyl cyl) {
        AppMethodBeat.i(220987);
        n.c(cyl);
        AppMethodBeat.o(220987);
    }

    public static final void b(cyl cyl) {
        AppMethodBeat.i(220988);
        n.d(cyl);
        AppMethodBeat.o(220988);
    }

    public static final void apV(String str) {
        AppMethodBeat.i(220989);
        if (p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", str) || p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", str)) {
            sFW.cOG();
            AppMethodBeat.o(220989);
            return;
        }
        b.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
        String cPQ = b.a.cPQ();
        if ((p.j(cPQ, "999") || p.j(cPQ, "101") || p.j(cPQ, "102") || p.j(cPQ, "123")) && (p.j("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", str) || p.j("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", str) || p.j("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", str))) {
            sFW.cOG();
        }
        AppMethodBeat.o(220989);
    }

    public static void a(FragmentActivity fragmentActivity, Fragment fragment, int i2) {
        AppMethodBeat.i(220990);
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(fragment, "fragment");
        com.tencent.mm.plugin.expt.hellhound.a.a.b bVar = sFU;
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(fragment, "fragment");
        String name = fragment.getClass().getName();
        p.g(name, "fragment.javaClass.name");
        Log.d("HABBYGE-MALI.FragmentFeedStatistics", "start: fragment:" + name + ", event=" + i2);
        switch (name.hashCode()) {
            case -1817116115:
                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment")) {
                    if (bVar.sBI == null) {
                        bVar.sBI = new com.tencent.mm.plugin.expt.hellhound.a.b.a.j(fragmentActivity);
                    }
                    o oVar = bVar.sBI;
                    if (oVar != null) {
                        oVar.startMonitor();
                        AppMethodBeat.o(220990);
                        return;
                    }
                }
                break;
            case 839202232:
                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
                    if (bVar.sBH == null) {
                        bVar.sBH = new g(fragmentActivity);
                    }
                    o oVar2 = bVar.sBH;
                    if (oVar2 != null) {
                        oVar2.startMonitor();
                        AppMethodBeat.o(220990);
                        return;
                    }
                    AppMethodBeat.o(220990);
                    return;
                }
                break;
            case 1218751173:
                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment")) {
                    if (bVar.sBG == null) {
                        bVar.sBG = new com.tencent.mm.plugin.expt.hellhound.a.b.a.f(fragmentActivity);
                    }
                    o oVar3 = bVar.sBG;
                    if (oVar3 != null) {
                        oVar3.startMonitor();
                        AppMethodBeat.o(220990);
                        return;
                    }
                    AppMethodBeat.o(220990);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220990);
    }

    public static void b(FragmentActivity fragmentActivity, Fragment fragment, int i2) {
        o oVar;
        AppMethodBeat.i(220991);
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(fragment, "fragment");
        com.tencent.mm.plugin.expt.hellhound.a.a.b bVar = sFU;
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(fragment, "fragment");
        String name = fragment.getClass().getName();
        p.g(name, "fragment.javaClass.name");
        Log.d("HABBYGE-MALI.FragmentFeedStatistics", "stop: fragment:" + name + ", event=" + i2);
        switch (name.hashCode()) {
            case -1817116115:
                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment") && (oVar = bVar.sBI) != null) {
                    oVar.stopMonitor();
                    AppMethodBeat.o(220991);
                    return;
                }
            case 839202232:
                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
                    o oVar2 = bVar.sBH;
                    if (oVar2 != null) {
                        oVar2.stopMonitor();
                        AppMethodBeat.o(220991);
                        return;
                    }
                    AppMethodBeat.o(220991);
                    return;
                }
                break;
            case 1218751173:
                if (name.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment")) {
                    o oVar3 = bVar.sBG;
                    if (oVar3 != null) {
                        oVar3.stopMonitor();
                        AppMethodBeat.o(220991);
                        return;
                    }
                    AppMethodBeat.o(220991);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220991);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ:\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    static final class a implements com.tencent.mm.hellhoundlib.a.c {
        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(220965);
            if (str != null && n.J(str, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$", false)) {
                AppMethodBeat.o(220965);
            } else if (!p.j("onScrollStateChanged", str2) || !p.j("(Landroid/support/v7/widget/RecyclerView;I)V", str3)) {
                if (p.j("onScrolled", str2) && p.j("(Landroid/support/v7/widget/RecyclerView;II)V", str3) && objArr != null && objArr.length >= 3) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof RecyclerView) {
                        k kVar = k.sFY;
                        RecyclerView recyclerView = (RecyclerView) obj2;
                        Object obj3 = objArr[1];
                        if (obj3 == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(220965);
                            throw tVar;
                        }
                        ((Integer) obj3).intValue();
                        Object obj4 = objArr[2];
                        if (obj4 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(220965);
                            throw tVar2;
                        }
                        kVar.e(recyclerView, ((Integer) obj4).intValue());
                    }
                }
                AppMethodBeat.o(220965);
            } else if (objArr != null) {
                if (objArr.length >= 2) {
                    Object obj5 = objArr[0];
                    if (obj5 instanceof RecyclerView) {
                        k kVar2 = k.sFY;
                        RecyclerView recyclerView2 = (RecyclerView) obj5;
                        Object obj6 = objArr[1];
                        if (obj6 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(220965);
                            throw tVar3;
                        }
                        kVar2.onScrollStateChanged(recyclerView2, ((Integer) obj6).intValue());
                    }
                }
                AppMethodBeat.o(220965);
            } else {
                AppMethodBeat.o(220965);
            }
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    public final synchronized void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(220992);
        p.h(recyclerView, "recyclerView");
        for (e eVar : mListeners) {
            eVar.onScrollStateChanged(recyclerView, i2);
        }
        AppMethodBeat.o(220992);
    }

    public final synchronized void e(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(220993);
        p.h(recyclerView, "recyclerView");
        for (e eVar : mListeners) {
            eVar.e(recyclerView, i2);
        }
        AppMethodBeat.o(220993);
    }

    public final synchronized void cOE() {
        AppMethodBeat.i(220994);
        for (e eVar : mListeners) {
            eVar.cOE();
        }
        AppMethodBeat.o(220994);
    }

    public final synchronized void a(m.a aVar) {
        AppMethodBeat.i(220995);
        for (e eVar : mListeners) {
            eVar.a(aVar);
        }
        AppMethodBeat.o(220995);
    }

    public final synchronized void cxo() {
        AppMethodBeat.i(220996);
        Iterator<e> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(220996);
    }

    public final synchronized void cOF() {
        AppMethodBeat.i(220997);
        for (e eVar : mListeners) {
            eVar.cOF();
        }
        AppMethodBeat.o(220997);
    }

    public static final void m(String str, int i2, long j2) {
        AppMethodBeat.i(220979);
        d.p(str, i2, j2);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2: pageName=" + str + ", hashCode=" + i2);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
            f.sHi.cPr();
            AppMethodBeat.o(220979);
            return;
        }
        cym cPq = f.sHi.cPq();
        if (cPq == null) {
            AppMethodBeat.o(220979);
            return;
        }
        cPq.sGD = j2;
        cPq.sGB = cPq.sGD - cPq.sGC;
        cPq.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
        cPq.dYn = c.b.INOUT.value;
        Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV2, statics: " + cPq.dMl + ", " + cPq.aHK);
        a.C1016a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
        a.C1016a.a(d.a(cPq, c.b.INOUT.value));
        cPq.dYn = 8;
        f.sHi.d(cPq);
        AppMethodBeat.o(220979);
    }

    public static final void n(String str, int i2, long j2) {
        AppMethodBeat.i(220980);
        d.o(str, i2, j2);
        d.q(str, i2, j2);
        AppMethodBeat.o(220980);
    }
}
