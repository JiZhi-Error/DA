package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Pair;
import android.view.View;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.m;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J*\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J*\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "monitor", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", AppMeasurement.Param.TIMESTAMP, "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class c {
    public static final a sCK = new a((byte) 0);
    public String sCH;
    public j sCI;
    public final b sCJ = new b(this);

    static {
        AppMethodBeat.i(220825);
        AppMethodBeat.o(220825);
    }

    public c() {
        AppMethodBeat.i(220824);
        AppMethodBeat.o(220824);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
    public static final class b implements e {
        final /* synthetic */ c sCL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(c cVar) {
            this.sCL = cVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(220819);
            p.h(recyclerView, "recyclerView");
            AppMethodBeat.o(220819);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
        public final void e(RecyclerView recyclerView, int i2) {
            long j2;
            boolean e2;
            boolean z;
            boolean z2;
            boolean z3;
            long j3;
            AppMethodBeat.i(220820);
            p.h(recyclerView, "recyclerView");
            StaggeredGridLayoutManager k = c.k(recyclerView);
            if (k == null) {
                AppMethodBeat.o(220820);
                return;
            }
            j jVar = this.sCL.sCI;
            if (jVar != null) {
                p.h(recyclerView, "recyclerView");
                p.h(k, "layoutManager");
                if (k.ki() == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    WeakReference<StaggeredGridLayoutManager> weakReference = jVar.sHJ;
                    if ((weakReference != null ? weakReference.get() : null) == null) {
                        jVar.sHJ = new WeakReference<>(k);
                    }
                    WeakReference<RecyclerView> weakReference2 = jVar.sCb;
                    if ((weakReference2 != null ? weakReference2.get() : null) == null) {
                        jVar.sCb = new WeakReference<>(recyclerView);
                    }
                    int[] n = k.n(null);
                    int min = Math.min(n[0], n[1]);
                    int[] o = k.o(null);
                    int max = Math.max(Math.max(o[0], o[1]) - j.sHN, 0);
                    int max2 = Math.max(min, j.sHN) - j.sHN;
                    ArrayList arrayList = new ArrayList();
                    int i3 = max + 1;
                    for (int i4 = max2; i4 < i3; i4++) {
                        View findViewByPosition = k.findViewByPosition(j.sHN + i4);
                        if (findViewByPosition != null) {
                            Pair<Integer, Integer> dJ = com.tencent.mm.plugin.expt.hellhound.core.b.dJ(findViewByPosition);
                            p.g(dJ, "HellhoundUtil.getCoordinateOnScreen(feedView)");
                            Integer num = (Integer) dJ.first;
                            Integer num2 = (Integer) dJ.second;
                            i a2 = jVar.a(findViewByPosition, i4, recyclerView);
                            if (!(a2 == null || a2.feedId == null)) {
                                String str = a2.feedId;
                                if (str == null) {
                                    p.hyc();
                                }
                                arrayList.add(str);
                                if (jVar.sHA <= 0) {
                                    j2 = jVar.sHB;
                                } else {
                                    j2 = jVar.sHA;
                                }
                                a2.sGJ = j2;
                                p.g(num, "x");
                                a2.x = num.intValue();
                                p.g(num2, "y");
                                a2.y = num2.intValue();
                                a2.position = i4;
                                j.b(a2);
                                jVar.c(a2);
                                jVar.d(a2);
                                if (a2.ddZ) {
                                    e2 = false;
                                } else {
                                    e2 = jVar.e(a2);
                                    a2.ddZ = e2;
                                }
                                if (e2 && a2.sHt <= 0) {
                                    a2.sHt = currentTimeMillis;
                                }
                                if (!a2.ddZ) {
                                    z3 = false;
                                } else {
                                    int i5 = a2.y;
                                    float f2 = ((float) i5) + a2.height;
                                    if (((float) i5) >= jVar.sHG || f2 <= jVar.sHF) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    a2.ddZ = z2;
                                    z3 = z;
                                }
                                if (z3 || a2.sGL <= 0.0f) {
                                    if (a2.sGL <= 0.0f) {
                                        a2.ddZ = false;
                                    }
                                    if (a2.sHt > 0 && a2.sHu <= 0) {
                                        a2.sHu = currentTimeMillis;
                                        a2.sHw = a2.sHu - a2.sHt;
                                        jVar.sHC = 0;
                                        a2.sHv = 0;
                                        if (a2.sGJ <= 0) {
                                            if (jVar.sHA <= 0) {
                                                j3 = jVar.sHB;
                                            } else {
                                                j3 = jVar.sHA;
                                            }
                                            a2.sGJ = j3;
                                        }
                                        a.C1016a aVar = a.sGv;
                                        a.C1016a.a(a2);
                                        HashMap<String, i> hashMap = jVar.sHy;
                                        String str2 = a2.feedId;
                                        if (hashMap == null) {
                                            t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                                            AppMethodBeat.o(220820);
                                            throw tVar;
                                        }
                                        af.fd(hashMap).remove(str2);
                                    }
                                }
                            }
                        }
                    }
                    jVar.c(arrayList, currentTimeMillis);
                    c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    c.a.cPk();
                }
                AppMethodBeat.o(220820);
                return;
            }
            AppMethodBeat.o(220820);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
        public final void cOE() {
            AppMethodBeat.i(220821);
            j jVar = this.sCL.sCI;
            if (jVar != null) {
                Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
                long currentTimeMillis = System.currentTimeMillis();
                jVar.sHM = jVar.sHC;
                jVar.sHL = jVar.sHA;
                jVar.sHA = currentTimeMillis;
                jVar.sHC = 3;
                jVar.sHK.putAll(jVar.sHy);
                jVar.sHy.clear();
                c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEM.clear();
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEM.addAll(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEJ);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEN.clear();
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEN.addAll(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEK);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEO.clear();
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEO.addAll(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEL);
                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                c.a.cPj();
                AppMethodBeat.o(220821);
                return;
            }
            AppMethodBeat.o(220821);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
        public final void a(m.a aVar) {
            List<?> list;
            AppMethodBeat.i(220822);
            j jVar = this.sCL.sCI;
            if (jVar != null) {
                Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd...");
                if (aVar != null) {
                    list = aVar.incrementList;
                } else {
                    list = null;
                }
                if (list != null) {
                    List<?> list2 = aVar.incrementList;
                    if (list2 == null) {
                        p.hyc();
                    }
                    if (!list2.isEmpty()) {
                        jVar.af(jVar.sHK);
                        jVar.a(jVar.sHK, System.currentTimeMillis());
                        AppMethodBeat.o(220822);
                        return;
                    }
                }
                Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
                jVar.sHy.putAll(jVar.sHK);
                jVar.sHK.clear();
                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEJ.addAll(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEM);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEK.addAll(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEN);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEL.addAll(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEO);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEM.clear();
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEN.clear();
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEO.clear();
                jVar.sHC = jVar.sHM;
                jVar.sHA = jVar.sHL;
                AppMethodBeat.o(220822);
                return;
            }
            AppMethodBeat.o(220822);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.e
        public final void cOF() {
            AppMethodBeat.i(220823);
            if (this.sCL.sCI != null) {
                j.cPu();
            }
            AppMethodBeat.o(220823);
        }
    }

    public static final /* synthetic */ StaggeredGridLayoutManager k(RecyclerView recyclerView) {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        AppMethodBeat.i(220826);
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
                AppMethodBeat.o(220826);
                throw tVar;
            }
            staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        } else {
            staggeredGridLayoutManager = null;
        }
        if (staggeredGridLayoutManager == null || staggeredGridLayoutManager.ki() >= 2) {
            AppMethodBeat.o(220826);
            return staggeredGridLayoutManager;
        }
        AppMethodBeat.o(220826);
        return null;
    }
}
