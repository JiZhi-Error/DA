package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0005\u0004\f\u0012\u0016\u001a\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u001eJ\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R8\u0010\u0006\u001a,\u0012\u0004\u0012\u00020\b\u0012\"\u0012 \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\t0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR8\u0010\u000e\u001a,\u0012\u0004\u0012\u00020\b\u0012\"\u0012 \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\t0\u00100\u000f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R8\u0010\u0014\u001a,\u0012\u0004\u0012\u00020\b\u0012\"\u0012 \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\t0\u00100\u000f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R,\u0010\u0018\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\t0\u00100\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR8\u0010\u001c\u001a,\u0012\u0004\u0012\u00020\b\u0012\"\u0012 \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\t0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a {
    private static final List<d> mListeners = new ArrayList();
    public static final C1013a sDW = new C1013a((byte) 0);
    private final HashMap<String, Pair<String, List<Pair<String, String>>>> sDM = new HashMap<>();
    private final HashMap<String, Map<String, List<Pair<String, String>>>> sDN = new HashMap<>();
    private final HashMap<String, List<Pair<String, String>>> sDO = new HashMap<>();
    private final HashMap<String, Pair<String, List<Pair<String, String>>>> sDP = new HashMap<>();
    private final HashMap<String, Map<String, List<Pair<String, String>>>> sDQ = new HashMap<>();
    private final b sDR;
    private final c sDS;
    private final e sDT;
    private final f sDU;
    private final d sDV;

    public a() {
        AppMethodBeat.i(220898);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
        this.sDM.put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair<>("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V"));
        arrayList2.add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", arrayList2);
        this.sDN.put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", hashMap);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
        this.sDO.put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
        this.sDP.put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", new Pair<>("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", arrayList4));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", arrayList5);
        this.sDQ.put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", hashMap2);
        this.sDR = new b(this);
        this.sDS = new c(this);
        this.sDT = new e(this);
        this.sDU = new f(this);
        this.sDV = new d(this);
        AppMethodBeat.o(220898);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$Companion;", "", "()V", "FAV_CLASS_HEADER", "", "FAV_METHOD_DESC", "FAV_METHOD_NAME", "FAV_SUPER", "LBS_CLASS_HEADER", "LBS_INTERFACE", "LBS_METHOD_DESC", "LBS_METHOD_DESC2", "LBS_METHOD_NAME", "MIXSEARCH_CLASS_HEADER", "MIXSEARCH_INTERFACE", "MIXSEARCH_METHOD_DESC", "MIXSEARCH_METHOD_NAME", "PROFILE_CLASS", "PROFILE_METHOD_DESC", "PROFILE_METHOD_NAME", "TAG", "TOPIC_CLASS_HEADER", "TOPIC_METHOD_DESC", "TOPIC_METHOD_NAME", "TOPIC_SUPER", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.b.a$a  reason: collision with other inner class name */
    public static final class C1013a {
        private C1013a() {
        }

        public /* synthetic */ C1013a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(220899);
        AppMethodBeat.o(220899);
    }

    public final void cMH() {
        AppMethodBeat.i(220893);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.c(this.sDM, this.sDR);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.e(this.sDN, this.sDS);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(this.sDO, this.sDT);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.c(this.sDP, this.sDU);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.e(this.sDQ, this.sDV);
        AppMethodBeat.o(220893);
    }

    public final void cOG() {
        AppMethodBeat.i(220894);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.d(this.sDM, this.sDR);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.f(this.sDN, this.sDS);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.b(this.sDO, this.sDT);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.d(this.sDP, this.sDU);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.f(this.sDQ, this.sDV);
        AppMethodBeat.o(220894);
    }

    public final synchronized void a(d dVar) {
        AppMethodBeat.i(220895);
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!mListeners.contains(dVar)) {
            mListeners.add(dVar);
        }
        AppMethodBeat.o(220895);
    }

    public final synchronized void b(d dVar) {
        AppMethodBeat.i(220896);
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        mListeners.remove(dVar);
        AppMethodBeat.o(220896);
    }

    public final synchronized void k(Object obj, int i2) {
        AppMethodBeat.i(220897);
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().k(obj, i2);
        }
        AppMethodBeat.o(220897);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class b implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a sDX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.sDX = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            View view;
            AppMethodBeat.i(220888);
            if (str == null || !n.J(str, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", false) || !p.j(str2, "onGridItemClick") || !p.j(str3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V") || objArr == null) {
                AppMethodBeat.o(220888);
                return;
            }
            if (objArr.length >= 3) {
                if (!(objArr[0] instanceof RecyclerView.a) || objArr[0] != null) {
                    if (objArr[1] instanceof View) {
                        Object obj2 = objArr[1];
                        if (obj2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.View");
                            AppMethodBeat.o(220888);
                            throw tVar;
                        }
                        view = (View) obj2;
                    } else {
                        view = null;
                    }
                    int i2 = -1;
                    if (objArr[2] instanceof Integer) {
                        Object obj3 = objArr[2];
                        if (obj3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(220888);
                            throw tVar2;
                        }
                        i2 = ((Integer) obj3).intValue();
                    }
                    this.sDX.k(view, i2);
                } else {
                    t tVar3 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
                    AppMethodBeat.o(220888);
                    throw tVar3;
                }
            }
            AppMethodBeat.o(220888);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class c implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a sDX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.sDX = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            View view;
            AppMethodBeat.i(220889);
            if (str == null || !n.J(str, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", false) || !p.j(str2, "onItemClick") || ((!p.j(str3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V") && !p.j(str3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V")) || objArr == null)) {
                AppMethodBeat.o(220889);
                return;
            }
            if (objArr.length >= 3) {
                if (!(objArr[0] instanceof RecyclerView.a) || objArr[0] != null) {
                    if (objArr[1] instanceof View) {
                        Object obj2 = objArr[1];
                        if (obj2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.View");
                            AppMethodBeat.o(220889);
                            throw tVar;
                        }
                        view = (View) obj2;
                    } else {
                        view = null;
                    }
                    int i2 = -1;
                    if (objArr[2] instanceof Integer) {
                        Object obj3 = objArr[2];
                        if (obj3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(220889);
                            throw tVar2;
                        }
                        i2 = ((Integer) obj3).intValue();
                    }
                    this.sDX.k(view, i2);
                } else {
                    t tVar3 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
                    AppMethodBeat.o(220889);
                    throw tVar3;
                }
            }
            AppMethodBeat.o(220889);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class e implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a sDX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(a aVar) {
            this.sDX = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(220891);
            if (!p.j(str, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter") || !p.j(str2, "jumpProfileTimeline") || !p.j(str3, "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V") || objArr == null) {
                AppMethodBeat.o(220891);
                return;
            }
            if (objArr.length >= 2) {
                int i2 = -1;
                if (objArr[0] instanceof Integer) {
                    Object obj2 = objArr[0];
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(220891);
                        throw tVar;
                    }
                    i2 = ((Integer) obj2).intValue();
                }
                this.sDX.k(objArr[1], i2);
            }
            AppMethodBeat.o(220891);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class f implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a sDX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(a aVar) {
            this.sDX = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            Object obj2;
            View view = null;
            AppMethodBeat.i(220892);
            if (str == null || !n.J(str, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", false) || !p.j(str2, "onGridItemClick") || !p.j(str3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V") || objArr == null) {
                AppMethodBeat.o(220892);
                return;
            }
            if (objArr.length >= 3) {
                if (objArr[0] instanceof RecyclerView.a) {
                    Object obj3 = objArr[0];
                    if (obj3 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
                        AppMethodBeat.o(220892);
                        throw tVar;
                    }
                    obj2 = (RecyclerView.a) obj3;
                } else {
                    obj2 = null;
                }
                if (objArr[1] instanceof View) {
                    Object obj4 = objArr[1];
                    if (obj4 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(220892);
                        throw tVar2;
                    }
                    view = (View) obj4;
                }
                int i2 = -1;
                if (objArr[2] instanceof Integer) {
                    Object obj5 = objArr[2];
                    if (obj5 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(220892);
                        throw tVar3;
                    }
                    int intValue = ((Integer) obj5).intValue();
                    if (obj2 instanceof g) {
                        i2 = intValue - ((g) obj2).RqM.size();
                    } else {
                        i2 = intValue;
                    }
                }
                this.sDX.k(view, i2);
            }
            AppMethodBeat.o(220892);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class d implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a sDX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.sDX = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(220890);
            if (str != null && n.J(str, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", false) && p.j(str2, "onFeedItemClick") && p.j(str3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V") && objArr != null) {
                this.sDX.k(objArr[0], -1);
            }
            AppMethodBeat.o(220890);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }
}
