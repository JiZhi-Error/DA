package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager;
import com.tencent.mm.plugin.multitask.ui.minusscreen.c.a;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout;
import com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView;
import com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskVerticalBehavior;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class MultiTaskMinusScreenUIC extends MultiTaskUIComponent implements com.tencent.mm.plugin.ball.c.d {
    public static final a Afu = new a((byte) 0);
    static final String TAG = TAG;
    final int Afl = 100;
    private final long Afm = 1000;
    final ArrayList<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> Afn = new ArrayList<>();
    MultiTaskCoordinatorLayout Afo;
    public b Afp;
    private final kotlin.f Afq;
    com.tencent.mm.plugin.multitask.ui.minusscreen.a Afr;
    WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> Afs;
    private final j Aft;
    private volatile boolean IZj;
    private View kgo;
    private int lastOrientation;
    private long mRS;
    private Point pbD;
    private final int tMh;
    WxRecyclerView ufR;
    final Rect vPN = new Rect();

    public interface b {
        void a(View view, View view2, int i2, MultiTaskInfo multiTaskInfo, boolean z);

        void j(MultiTaskInfo multiTaskInfo);

        void k(MultiTaskInfo multiTaskInfo);
    }

    private RecyclerView.LayoutManager erJ() {
        AppMethodBeat.i(236621);
        RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.Afq.getValue();
        AppMethodBeat.o(236621);
        return layoutManager;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskMinusScreenUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236637);
        this.Afq = kotlin.g.ah(new k(this, appCompatActivity));
        this.Afr = new com.tencent.mm.plugin.multitask.ui.minusscreen.c(this.Afn, (byte) 0);
        this.lastOrientation = -1;
        this.pbD = new Point();
        this.Aft = new j(this);
        AppMethodBeat.o(236637);
    }

    public static final /* synthetic */ void a(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC, List list) {
        AppMethodBeat.i(236639);
        multiTaskMinusScreenUIC.a((List<? extends MultiTaskInfo>) list, true, false, false);
        AppMethodBeat.o(236639);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(236638);
        AppMethodBeat.o(236638);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(236622);
        super.onCreate(bundle);
        AppMethodBeat.o(236622);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(258184);
        super.onDestroy();
        ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(this);
        AppMethodBeat.o(258184);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dk(Object obj) {
        WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter;
        OverScrollMultiTaskVerticalBehavior behavior;
        ViewTreeObserver viewTreeObserver;
        AppMethodBeat.i(236623);
        super.dk(obj);
        ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(this);
        FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.fpr);
        p.g(frameLayout, "titleView");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(236623);
            throw tVar;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = au.D(getActivity(), -1);
        frameLayout.setLayoutParams(layoutParams2);
        this.Afr.a(this.Aft);
        this.ufR = (WxRecyclerView) getRootView().findViewById(R.id.fpo);
        this.Afo = (MultiTaskCoordinatorLayout) getRootView().findViewById(R.id.fpp);
        MultiTaskCoordinatorLayout multiTaskCoordinatorLayout = this.Afo;
        if (!(multiTaskCoordinatorLayout == null || (viewTreeObserver = multiTaskCoordinatorLayout.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new i(this));
        }
        FrameLayout frameLayout2 = new FrameLayout(getActivity());
        MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
        frameLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, MultiTaskUIC.Agl));
        this.kgo = frameLayout2;
        RecyclerView.LayoutManager erJ = erJ();
        if (erJ == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager");
            AppMethodBeat.o(236623);
            throw tVar2;
        }
        ((MinusScreenGridLayoutManager) erJ).AdM = this.ufR;
        WxRecyclerView wxRecyclerView = this.ufR;
        if (!(wxRecyclerView instanceof OverScrollMultiTaskRecyclerView)) {
            wxRecyclerView = null;
        }
        OverScrollMultiTaskRecyclerView overScrollMultiTaskRecyclerView = (OverScrollMultiTaskRecyclerView) wxRecyclerView;
        if (!(overScrollMultiTaskRecyclerView == null || (behavior = overScrollMultiTaskRecyclerView.getBehavior()) == null)) {
            behavior.Afi = this.Aft;
        }
        this.Afs = new c(this, this.Afr.dcK(), this.Afn);
        WxRecyclerView wxRecyclerView2 = this.ufR;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setLayoutManager(erJ());
            wxRecyclerView2.setItemAnimator(new com.tencent.mm.plugin.multitask.ui.minusscreen.a.a(wxRecyclerView2, this.Aft));
            wxRecyclerView2.setAdapter(this.Afs);
        }
        this.Afr.setAdapter(this.Afs);
        View view = this.kgo;
        if (!(view == null || (wxRecyclerAdapter = this.Afs) == null)) {
            g.b unused = wxRecyclerAdapter.f(view, this.tMh, true);
        }
        WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter2 = this.Afs;
        if (wxRecyclerAdapter2 != null) {
            wxRecyclerAdapter2.RqP = new d(this);
        }
        WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter3 = this.Afs;
        if (wxRecyclerAdapter3 != null) {
            wxRecyclerAdapter3.RrA = new e(this);
        }
        WxRecyclerView wxRecyclerView3 = this.ufR;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.a(new f(this));
        }
        com.tencent.mm.ac.d.c("MultiTask_Thread", new g(this));
        AppMethodBeat.o(236623);
    }

    @Override // com.tencent.mm.plugin.ball.c.d
    public final void a(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(258185);
        p.h(list, "ballInfoList");
        Log.i(TAG, "dataChanged");
        gcP();
        AppMethodBeat.o(258185);
    }

    private final void gcP() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(258186);
        if (this.IZj) {
            Log.i(TAG, "convertFloatBallInfo, is Already done!");
            AppMethodBeat.o(258186);
            return;
        }
        List<BallInfo> chR = ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chR();
        Log.i(TAG, "convertFloatBallInfo,size:%d", Integer.valueOf(chR.size()));
        p.g(chR, "floatBallList");
        for (BallInfo ballInfo : kotlin.a.j.m(chR)) {
            com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
            if (com.tencent.mm.plugin.multitask.f.a.Js(ballInfo.type)) {
                this.IZj = true;
                MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
                multiTaskInfo.field_type = ballInfo.type;
                multiTaskInfo.field_id = ballInfo.key;
                multiTaskInfo.field_showData = new cru();
                multiTaskInfo.field_showData.nickname = ballInfo.name;
                multiTaskInfo.field_showData.title = ballInfo.desc;
                multiTaskInfo.field_showData.MwR = ballInfo.icon;
                a.C1527a aVar2 = com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.Aeo;
                p.g(ballInfo, "ballInfo");
                Bundle bundle = ballInfo.jkf;
                p.g(bundle, "ballInfo.extra");
                a.C1527a.a(multiTaskInfo, ballInfo, bundle);
                String str = multiTaskInfo.field_id;
                p.g(str, "multiTaskInfo.field_id");
                int i2 = multiTaskInfo.field_type;
                cru erh = multiTaskInfo.erh();
                p.g(erh, "multiTaskInfo.showData");
                ((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).addTaskInfoByBitmap(str, i2, erh, null, multiTaskInfo.field_data, null);
                Log.i(TAG, "convertFloatBallInfo, type:" + ballInfo.type + ", id:" + ballInfo.key + ", nickname:" + ballInfo.name);
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (chR.size() > 0 && z2) {
            Log.i(TAG, "convertFloatBallInfo, clearData");
            com.tencent.mm.plugin.ball.service.e.ciJ().clear();
        }
        AppMethodBeat.o(258186);
    }

    private final void a(List<? extends MultiTaskInfo> list, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(236624);
        com.tencent.mm.ac.d.h(new h(this, list, z3, z, z2));
        AppMethodBeat.o(236624);
    }

    public static final class i implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        i(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            this.Afv = multiTaskMinusScreenUIC;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            AppMethodBeat.i(236613);
            MultiTaskCoordinatorLayout multiTaskCoordinatorLayout = this.Afv.Afo;
            if (!(multiTaskCoordinatorLayout == null || (viewTreeObserver = multiTaskCoordinatorLayout.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(236613);
        }

        static final class a implements Runnable {
            final /* synthetic */ i Afz;

            a(i iVar) {
                this.Afz = iVar;
            }

            public final void run() {
                AppMethodBeat.i(236612);
                View findViewById = this.Afz.Afv.getRootView().findViewById(R.id.fnm);
                p.g(findViewById, "targetView");
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(236612);
                    throw tVar;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                marginLayoutParams.leftMargin = MultiTaskUIC.AfX;
                MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                marginLayoutParams.topMargin = MultiTaskUIC.Agl;
                MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                marginLayoutParams.width = MultiTaskUIC.Aga;
                MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                marginLayoutParams.height = (int) (((float) marginLayoutParams.width) * MultiTaskUIC.Agn);
                findViewById.setLayoutParams(marginLayoutParams);
                AppMethodBeat.o(236612);
            }
        }
    }

    public static final class c extends WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC, com.tencent.mm.view.recyclerview.f fVar, ArrayList arrayList) {
            super(fVar, arrayList, true);
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(RecyclerView.v vVar) {
            AppMethodBeat.i(236605);
            n((com.tencent.mm.view.recyclerview.h) vVar);
            AppMethodBeat.o(236605);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(236604);
            p.h(hVar, "holder");
            super.n(hVar);
            MultiTaskMinusScreenUIC.q(hVar);
            Log.d("RecyclerViewAdapterEx", "onViewAttachedToWindow, posttion: " + hVar.lQ());
            AppMethodBeat.o(236604);
        }
    }

    public static final class d implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        d(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            View findViewById;
            RecyclerView.v ch;
            View view2;
            crt crt = null;
            AppMethodBeat.i(236606);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            if (MultiTaskMinusScreenUIC.a(this.Afv)) {
                a aVar2 = MultiTaskMinusScreenUIC.Afu;
                Log.i(MultiTaskMinusScreenUIC.TAG, "onItemClick: double click check");
                AppMethodBeat.o(236606);
                return;
            }
            int size = i2 - ((com.tencent.mm.view.recyclerview.g) aVar).RqM.size();
            if (size >= 0 && size < this.Afv.Afn.size()) {
                com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar3 = this.Afv.Afn.get(size);
                p.g(aVar3, "multiTaskInfoList[fixPos]");
                com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar4 = aVar3;
                if (this.Afv.Afn.size() <= 2) {
                    WxRecyclerView wxRecyclerView = this.Afv.ufR;
                    findViewById = (wxRecyclerView == null || (ch = wxRecyclerView.ch(1)) == null || (view2 = ch.aus) == null) ? null : view2.findViewById(R.id.fnq);
                } else {
                    findViewById = this.Afv.getRootView().findViewById(R.id.fnm);
                }
                b bVar = this.Afv.Afp;
                if (bVar != null) {
                    bVar.a(findViewById, view, size, aVar4.Aen, true);
                }
                SecDataUIC.a aVar5 = SecDataUIC.CWq;
                Context context = view.getContext();
                p.g(context, "view.context");
                SecDataUIC gU = SecDataUIC.a.gU(context);
                if (gU != null) {
                    crt = (crt) gU.Xh(5);
                }
                if (!(crt == null || crt.MwO == null)) {
                    a aVar6 = MultiTaskMinusScreenUIC.Afu;
                    Log.d(MultiTaskMinusScreenUIC.TAG, "Item Clicked, itemId: %s, pos: %s", aVar4.Aen.field_id, Integer.valueOf(size));
                    com.tencent.mm.plugin.multitask.d.a aVar7 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                    com.tencent.mm.plugin.multitask.d.a.a(aVar4.Aen, crt.sGQ, (long) size, 2, "");
                    AppMethodBeat.o(236606);
                    return;
                }
            }
            AppMethodBeat.o(236606);
        }
    }

    public static final class e implements com.tencent.mm.view.recyclerview.l {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        e(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // com.tencent.mm.view.recyclerview.l
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.j jVar) {
            AppMethodBeat.i(236607);
            p.h(recyclerView, "recyclerView");
            p.h(jVar, "data");
            int i2 = 0;
            for (T t : jVar.Rrn) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                if (t2.Rrp instanceof com.tencent.mm.plugin.multitask.ui.minusscreen.b.a) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    if (((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.Afv.getActivity()).get(MultiTaskUIC.class)).erO()) {
                        com.tencent.mm.view.recyclerview.a aVar2 = t2.Rrp;
                        if (aVar2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.minusscreen.data.RVMultiTaskData");
                            AppMethodBeat.o(236607);
                            throw tVar;
                        }
                        MultiTaskInfo multiTaskInfo = ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a) aVar2).Aen;
                        if (multiTaskInfo != null) {
                            SecDataUIC.a aVar3 = SecDataUIC.CWq;
                            Context context = recyclerView.getContext();
                            p.g(context, "recyclerView.context");
                            SecDataUIC gU = SecDataUIC.a.gU(context);
                            crt crt = gU != null ? (crt) gU.Xh(5) : null;
                            if (crt != null) {
                                long aGQ = (long) this.Afv.aGQ(multiTaskInfo.field_id);
                                a aVar4 = MultiTaskMinusScreenUIC.Afu;
                                Log.d(MultiTaskMinusScreenUIC.TAG, "Item Exposed, itemId: %s, pos: %s", multiTaskInfo.field_id, Long.valueOf(aGQ));
                                com.tencent.mm.plugin.multitask.d.a aVar5 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                                String str = multiTaskInfo.field_id;
                                p.g(str, "multiTaskInfo.field_id");
                                com.tencent.mm.plugin.multitask.d.a.bb(str, cl.aWA());
                                com.tencent.mm.plugin.multitask.d.a aVar6 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                                com.tencent.mm.plugin.multitask.d.a.a(multiTaskInfo, crt.sGQ, aGQ, 1, "");
                            }
                            b bVar = this.Afv.Afp;
                            if (bVar != null) {
                                bVar.k(multiTaskInfo);
                                i2 = i3;
                            } else {
                                i2 = i3;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            AppMethodBeat.o(236607);
        }
    }

    public static final class f extends RecyclerView.l {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(236609);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(236609);
        }

        f(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(236608);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof MinusScreenGridLayoutManager)) {
                layoutManager = null;
            }
            MinusScreenGridLayoutManager minusScreenGridLayoutManager = (MinusScreenGridLayoutManager) layoutManager;
            if (minusScreenGridLayoutManager != null) {
                this.Afv.a(recyclerView, minusScreenGridLayoutManager);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(236608);
        }
    }

    public final void erK() {
        AppMethodBeat.i(236625);
        WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter = this.Afs;
        if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.onPause();
        }
        WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter2 = this.Afs;
        if (wxRecyclerAdapter2 != null) {
            wxRecyclerAdapter2.onResume();
            AppMethodBeat.o(236625);
            return;
        }
        AppMethodBeat.o(236625);
    }

    public final boolean isDataEmpty() {
        AppMethodBeat.i(236626);
        if (this.Afn.size() == 0) {
            AppMethodBeat.o(236626);
            return true;
        }
        AppMethodBeat.o(236626);
        return false;
    }

    public static /* synthetic */ boolean a(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC, MultiTaskInfo multiTaskInfo, boolean z) {
        AppMethodBeat.i(236628);
        boolean a2 = multiTaskMinusScreenUIC.a(multiTaskInfo, z, true);
        AppMethodBeat.o(236628);
        return a2;
    }

    public final boolean a(MultiTaskInfo multiTaskInfo, boolean z, boolean z2) {
        AppMethodBeat.i(236627);
        int size = this.Afn.size();
        if (size <= 1) {
            MultiTaskCoordinatorLayout multiTaskCoordinatorLayout = this.Afo;
            if (multiTaskCoordinatorLayout != null) {
                MultiTaskCoordinatorLayout.a aVar = MultiTaskCoordinatorLayout.Afg;
                multiTaskCoordinatorLayout.setMode(MultiTaskCoordinatorLayout.Afe);
            }
        } else {
            MultiTaskCoordinatorLayout multiTaskCoordinatorLayout2 = this.Afo;
            if (multiTaskCoordinatorLayout2 != null) {
                MultiTaskCoordinatorLayout.a aVar2 = MultiTaskCoordinatorLayout.Afg;
                multiTaskCoordinatorLayout2.setMode(MultiTaskCoordinatorLayout.Aff);
            }
        }
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent aGP = bVar.aGP(com.tencent.mm.plugin.multitask.g.eqx());
            if (aGP != null && (aGP instanceof SnapShotMultiTaskUIC)) {
                SnapShotMultiTaskUIC snapShotMultiTaskUIC = (SnapShotMultiTaskUIC) aGP;
                snapShotMultiTaskUIC.Agu = multiTaskInfo;
                com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.ui.component.a.b(snapShotMultiTaskUIC.getActivity()).get(MultiTaskUIC.class);
                if (MultiTaskUIC.RU(multiTaskInfo != null ? multiTaskInfo.field_type : -1)) {
                    Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, teenmode!, forceShow:%b", Boolean.valueOf(z2));
                } else {
                    if (size == 1) {
                        com.tencent.mm.plugin.multitask.f.c cVar = com.tencent.mm.plugin.multitask.f.c.AgL;
                        if (com.tencent.mm.plugin.multitask.f.c.esD()) {
                            if (z2) {
                                snapShotMultiTaskUIC.m(multiTaskInfo);
                            }
                            Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, only one size!, forceShow:%b", Boolean.valueOf(z2));
                            AppMethodBeat.o(236627);
                            return true;
                        }
                    }
                    if (z) {
                        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                        ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(snapShotMultiTaskUIC.getActivity()).get(MultiTaskUIC.class)).sk(true);
                        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, force hide!");
                    } else {
                        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitask_show_timeout, 15);
                        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        String obj = aAh.azQ().get(ar.a.USERINFO_MULTITASK_LAST_SHOW_ID_AND_TIME_STRING_SYNC, "").toString();
                        List<String> a3 = kotlin.n.n.a(obj, new String[]{"|"});
                        if (a3.size() == 2) {
                            String str = a3.get(0);
                            long parseLong = Long.parseLong(a3.get(1));
                            MultiTaskInfo multiTaskInfo2 = snapShotMultiTaskUIC.Agu;
                            if (str != null && multiTaskInfo2 != null && cl.aWA() - parseLong <= ((long) (a2 * 60 * 1000)) && TextUtils.equals(str, multiTaskInfo2.field_id)) {
                                Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, in timeout!: ".concat(String.valueOf(a2)));
                                AppMethodBeat.o(236627);
                                return true;
                            }
                        }
                        if (!snapShotMultiTaskUIC.bJw()) {
                            Object[] objArr = new Object[3];
                            objArr[0] = obj;
                            MultiTaskInfo multiTaskInfo3 = snapShotMultiTaskUIC.Agu;
                            objArr[1] = multiTaskInfo3 != null ? multiTaskInfo3.field_id : null;
                            objArr[2] = Integer.valueOf(a2);
                            Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, is hide!, lastShowInfo:%s, currentShowId:%s, timeout: %d", objArr);
                        } else {
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = obj;
                            MultiTaskInfo multiTaskInfo4 = snapShotMultiTaskUIC.Agu;
                            objArr2[1] = multiTaskInfo4 != null ? multiTaskInfo4.field_id : null;
                            objArr2[2] = Integer.valueOf(a2);
                            Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, return false, lastShowInfo:%s, currentShowId:%s, timeout: %d", objArr2);
                            AppMethodBeat.o(236627);
                            return false;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(236627);
        return false;
    }

    public final int aGQ(String str) {
        AppMethodBeat.i(236629);
        if (str != null) {
            int i2 = 0;
            for (T t : this.Afn) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                if (p.j(t.Aen.field_id, str)) {
                    AppMethodBeat.o(236629);
                    return i2;
                }
                i2 = i3;
            }
        }
        AppMethodBeat.o(236629);
        return -1;
    }

    public final void erL() {
        AppMethodBeat.i(236630);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        boolean erO = ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).erO();
        if (erO && isDataEmpty()) {
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            MultiTaskUIC.a((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class));
        }
        erM();
        if (!erO) {
            nw nwVar = new nw();
            nwVar.dTY.isVisible = this.Afn.size() != 0;
            EventCenter.instance.publish(nwVar);
        }
        AppMethodBeat.o(236630);
    }

    public final void erM() {
        AppMethodBeat.i(236631);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        if (((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).erO()) {
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).RT(0);
            AppMethodBeat.o(236631);
        } else if (isDataEmpty()) {
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).RT(1);
            AppMethodBeat.o(236631);
        } else {
            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
            if (!((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).erU()) {
                com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).RT(2);
            }
            AppMethodBeat.o(236631);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(MStorageEventData mStorageEventData) {
        String str;
        boolean z;
        List<MultiTaskInfo> list = null;
        AppMethodBeat.i(236632);
        if (mStorageEventData != null) {
            Object obj = mStorageEventData.obj;
            if (obj == null) {
                obj = null;
            } else if (!(obj instanceof MultiTaskInfo)) {
                obj = null;
            }
            if (!(obj instanceof MultiTaskInfo)) {
                obj = null;
            }
            MultiTaskInfo multiTaskInfo = (MultiTaskInfo) obj;
            String str2 = TAG;
            StringBuilder append = new StringBuilder("onMultiTaskChange ").append(mStorageEventData.eventId).append(' ');
            if (multiTaskInfo != null) {
                str = multiTaskInfo.field_id;
            } else {
                str = null;
            }
            Log.i(str2, append.append(str).toString());
            switch (mStorageEventData.eventId) {
                case 2:
                    com.tencent.mm.ac.d.h(new l(multiTaskInfo, this));
                    AppMethodBeat.o(236632);
                    return;
                case 3:
                    com.tencent.mm.ac.d.h(new n(multiTaskInfo, this));
                    AppMethodBeat.o(236632);
                    return;
                case 5:
                    com.tencent.mm.ac.d.h(new m(multiTaskInfo, this));
                    AppMethodBeat.o(236632);
                    return;
                case 8:
                    com.tencent.mm.plugin.multitask.model.a multiTaskStorage = ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
                    if (multiTaskStorage != null) {
                        list = multiTaskStorage.eri();
                    }
                    if ((list == null || list.size() != 2) && (list == null || list.size() != 3)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    a((List<? extends MultiTaskInfo>) list, false, true, z);
                    break;
            }
            AppMethodBeat.o(236632);
            return;
        }
        AppMethodBeat.o(236632);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bdl;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_SINGLE_SCENE;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 0;
    }

    public static final class j implements com.tencent.mm.plugin.multitask.ui.minusscreen.d.a {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        j(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.d.a
        public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, com.tencent.mm.view.recyclerview.h hVar) {
            MultiTaskInfo multiTaskInfo;
            AppMethodBeat.i(236614);
            p.h(hVar, "holder");
            if (aVar == null || (multiTaskInfo = aVar.Aen) == null) {
                AppMethodBeat.o(236614);
                return;
            }
            ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).removeTaskInfoAndCoverImg(multiTaskInfo.field_id);
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            SecDataUIC gU = SecDataUIC.a.gU(context);
            crt crt = gU != null ? (crt) gU.Xh(5) : null;
            if (crt != null) {
                long aGQ = (long) this.Afv.aGQ(aVar.Aen.field_id);
                a aVar3 = MultiTaskMinusScreenUIC.Afu;
                Log.d(MultiTaskMinusScreenUIC.TAG, "Item deleted!, itemId: %s, pos: %s", aVar.Aen.field_id, Long.valueOf(aGQ));
                com.tencent.mm.plugin.multitask.d.a aVar4 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                com.tencent.mm.plugin.multitask.d.a.a(aVar.Aen, crt.sGQ, aGQ, 3, "");
            }
            AppMethodBeat.o(236614);
        }

        @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.d.a
        public final void ac(RecyclerView.v vVar) {
            RecyclerView.LayoutManager layoutManager;
            View view;
            View view2;
            RecyclerView.a adapter;
            int i2 = 0;
            AppMethodBeat.i(236615);
            p.h(vVar, "viewHolder");
            MultiTaskMinusScreenUIC multiTaskMinusScreenUIC = this.Afv;
            p.h(vVar, "viewHolder");
            WxRecyclerView wxRecyclerView = multiTaskMinusScreenUIC.ufR;
            if (((wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) ? 0 : adapter.getItemCount()) <= 3) {
                View findViewById = vVar.aus.findViewById(R.id.fns);
                View findViewById2 = vVar.aus.findViewById(R.id.fnn);
                if (!(findViewById == null || findViewById2 == null)) {
                    findViewById.setTranslationY(0.0f);
                    if (!(findViewById2 instanceof MinusScreenRoundFrameLayout)) {
                        view2 = null;
                    } else {
                        view2 = findViewById2;
                    }
                    if (((MinusScreenRoundFrameLayout) view2) != null) {
                        ((MinusScreenRoundFrameLayout) findViewById2).RS(0);
                    }
                }
                AppMethodBeat.o(236615);
                return;
            }
            WxRecyclerView wxRecyclerView2 = multiTaskMinusScreenUIC.ufR;
            if (wxRecyclerView2 != null) {
                layoutManager = wxRecyclerView2.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (!(layoutManager instanceof MinusScreenGridLayoutManager)) {
                layoutManager = null;
            }
            MinusScreenGridLayoutManager minusScreenGridLayoutManager = (MinusScreenGridLayoutManager) layoutManager;
            if (minusScreenGridLayoutManager != null) {
                int ks = minusScreenGridLayoutManager.ks();
                View findViewById3 = vVar.aus.findViewById(R.id.fns);
                View findViewById4 = vVar.aus.findViewById(R.id.fnq);
                if (!(findViewById3 == null || findViewById4 == null)) {
                    findViewById4.getLocalVisibleRect(multiTaskMinusScreenUIC.vPN);
                    MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                    int height = MultiTaskUIC.Agb - multiTaskMinusScreenUIC.vPN.height();
                    MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                    if (((float) height) <= ((float) MultiTaskUIC.Agb) * 0.8f && vVar.lR() <= ks + 1) {
                        i2 = height;
                    }
                    findViewById3.setTranslationY((float) i2);
                    View findViewById5 = vVar.aus.findViewById(R.id.fnn);
                    if (!(findViewById5 instanceof MinusScreenRoundFrameLayout)) {
                        view = null;
                    } else {
                        view = findViewById5;
                    }
                    if (((MinusScreenRoundFrameLayout) view) != null) {
                        ((MinusScreenRoundFrameLayout) findViewById5).RS(i2);
                    }
                }
                AppMethodBeat.o(236615);
                return;
            }
            AppMethodBeat.o(236615);
        }

        @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.d.a
        public final void erE() {
            RecyclerView.LayoutManager layoutManager;
            AppMethodBeat.i(236616);
            MultiTaskMinusScreenUIC multiTaskMinusScreenUIC = this.Afv;
            WxRecyclerView wxRecyclerView = multiTaskMinusScreenUIC.ufR;
            if (wxRecyclerView != null) {
                layoutManager = wxRecyclerView.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (!(layoutManager instanceof MinusScreenGridLayoutManager)) {
                layoutManager = null;
            }
            MinusScreenGridLayoutManager minusScreenGridLayoutManager = (MinusScreenGridLayoutManager) layoutManager;
            if (minusScreenGridLayoutManager != null) {
                WxRecyclerView wxRecyclerView2 = multiTaskMinusScreenUIC.ufR;
                if (wxRecyclerView2 != null) {
                    multiTaskMinusScreenUIC.a(wxRecyclerView2, minusScreenGridLayoutManager);
                    AppMethodBeat.o(236616);
                    return;
                }
                AppMethodBeat.o(236616);
                return;
            }
            AppMethodBeat.o(236616);
        }
    }

    public final long getTaskCount() {
        AppMethodBeat.i(236633);
        long size = (long) this.Afn.size();
        AppMethodBeat.o(236633);
        return size;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(236634);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Point point = this.pbD;
        Point az = ao.az(getContext());
        p.g(az, "UIUtils.getDisplayRealSize(context)");
        this.pbD = az;
        if (ao.gJN() && aw.kB(getContext())) {
            this.pbD.x = ao.getDeviceWidth();
        }
        if (ao.gJK()) {
            this.pbD.x = ao.getDeviceHeight();
        }
        Log.i(TAG, "onConfigurationChanged lastOrientation:" + this.lastOrientation + ",orientation:" + configuration.orientation + ", screenResolution:" + this.pbD.x + ", lastScreenResolution:" + point.x);
        if (!(this.lastOrientation == configuration.orientation && (point == null || (point.x == this.pbD.x && point.y == this.pbD.y)))) {
            this.lastOrientation = configuration.orientation;
            eoD();
        }
        AppMethodBeat.o(236634);
    }

    private final void eoD() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.v vVar;
        View findViewById;
        RecyclerView.a adapter;
        AppMethodBeat.i(236635);
        WxRecyclerView wxRecyclerView = this.ufR;
        if (wxRecyclerView != null) {
            layoutManager = wxRecyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (!(layoutManager instanceof MinusScreenGridLayoutManager)) {
            layoutManager = null;
        }
        MinusScreenGridLayoutManager minusScreenGridLayoutManager = (MinusScreenGridLayoutManager) layoutManager;
        if (minusScreenGridLayoutManager != null) {
            int ks = minusScreenGridLayoutManager.ks();
            int ku = minusScreenGridLayoutManager.ku();
            if (ks <= ku) {
                while (true) {
                    WxRecyclerView wxRecyclerView2 = this.ufR;
                    if (wxRecyclerView2 != null) {
                        vVar = wxRecyclerView2.cg(ks);
                    } else {
                        vVar = null;
                    }
                    if (!(vVar instanceof com.tencent.mm.view.recyclerview.h)) {
                        vVar = null;
                    }
                    com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) vVar;
                    if (hVar != null) {
                        WxRecyclerView wxRecyclerView3 = this.ufR;
                        int itemCount = (wxRecyclerView3 == null || (adapter = wxRecyclerView3.getAdapter()) == null) ? 0 : adapter.getItemCount();
                        Log.i(TAG, "refreshLayout itemCount:" + itemCount + ", pos:" + ks);
                        if (itemCount == 2) {
                            View findViewById2 = hVar.aus.findViewById(R.id.e24);
                            if (findViewById2 != null) {
                                MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                                findViewById2.setTranslationX((float) MultiTaskUIC.Agf);
                                MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                                findViewById2.setTranslationY((float) MultiTaskUIC.Age);
                                ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                                MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                                layoutParams.height = MultiTaskUIC.AfZ;
                                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                                MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                                layoutParams2.width = MultiTaskUIC.AfY;
                                RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                                if (roundedCornerFrameLayout != null) {
                                    ViewGroup.LayoutParams layoutParams3 = roundedCornerFrameLayout.getLayoutParams();
                                    MultiTaskUIC.a aVar5 = MultiTaskUIC.Ago;
                                    layoutParams3.height = MultiTaskUIC.Agd;
                                }
                                findViewById2.requestLayout();
                            }
                        } else if (itemCount == 3) {
                            View findViewById3 = hVar.aus.findViewById(R.id.e24);
                            if (findViewById3 != null) {
                                MultiTaskUIC.a aVar6 = MultiTaskUIC.Ago;
                                findViewById3.setTranslationY((float) MultiTaskUIC.Agh);
                                ViewGroup.LayoutParams layoutParams4 = findViewById3.getLayoutParams();
                                MultiTaskUIC.a aVar7 = MultiTaskUIC.Ago;
                                layoutParams4.height = MultiTaskUIC.kn;
                                ViewGroup.LayoutParams layoutParams5 = findViewById3.getLayoutParams();
                                MultiTaskUIC.a aVar8 = MultiTaskUIC.Ago;
                                layoutParams5.width = MultiTaskUIC.qmd;
                                RoundedCornerFrameLayout roundedCornerFrameLayout2 = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                                if (roundedCornerFrameLayout2 != null) {
                                    ViewGroup.LayoutParams layoutParams6 = roundedCornerFrameLayout2.getLayoutParams();
                                    MultiTaskUIC.a aVar9 = MultiTaskUIC.Ago;
                                    layoutParams6.height = MultiTaskUIC.Agb;
                                }
                                findViewById3.requestLayout();
                            }
                        } else if (itemCount >= 4 && (findViewById = hVar.aus.findViewById(R.id.e24)) != null) {
                            ViewGroup.LayoutParams layoutParams7 = findViewById.getLayoutParams();
                            MultiTaskUIC.a aVar10 = MultiTaskUIC.Ago;
                            layoutParams7.height = MultiTaskUIC.kn;
                            ViewGroup.LayoutParams layoutParams8 = findViewById.getLayoutParams();
                            MultiTaskUIC.a aVar11 = MultiTaskUIC.Ago;
                            layoutParams8.width = MultiTaskUIC.qmd;
                            RoundedCornerFrameLayout roundedCornerFrameLayout3 = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                            if (roundedCornerFrameLayout3 != null) {
                                ViewGroup.LayoutParams layoutParams9 = roundedCornerFrameLayout3.getLayoutParams();
                                MultiTaskUIC.a aVar12 = MultiTaskUIC.Ago;
                                layoutParams9.height = MultiTaskUIC.Agb;
                            }
                            findViewById.requestLayout();
                        }
                    }
                    if (ks == ku) {
                        break;
                    }
                    ks++;
                }
            }
            AppMethodBeat.o(236635);
            return;
        }
        AppMethodBeat.o(236635);
    }

    public final void a(RecyclerView recyclerView, MinusScreenGridLayoutManager minusScreenGridLayoutManager) {
        int i2;
        View view;
        AppMethodBeat.i(236636);
        p.h(recyclerView, "recyclerView");
        p.h(minusScreenGridLayoutManager, "layoutManager");
        if (minusScreenGridLayoutManager.getItemCount() <= 3) {
            AppMethodBeat.o(236636);
            return;
        }
        int ks = minusScreenGridLayoutManager.ks();
        int ku = minusScreenGridLayoutManager.ku();
        if (ks <= ku) {
            int i3 = ks;
            while (true) {
                RecyclerView.v cg = recyclerView.cg(i3);
                if (!(cg instanceof com.tencent.mm.view.recyclerview.h)) {
                    cg = null;
                }
                com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) cg;
                if (hVar != null) {
                    View findViewById = hVar.aus.findViewById(R.id.fns);
                    View findViewById2 = hVar.aus.findViewById(R.id.fnq);
                    if (!(findViewById == null || findViewById2 == null)) {
                        findViewById2.getLocalVisibleRect(this.vPN);
                        if (minusScreenGridLayoutManager.getItemCount() == 2) {
                            MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                            i2 = MultiTaskUIC.Agd;
                        } else {
                            MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                            i2 = MultiTaskUIC.Agb;
                        }
                        int height = i2 - this.vPN.height();
                        if (((float) height) > ((float) i2) * 0.8f || i3 > ks + 1) {
                            height = 0;
                        }
                        findViewById.setTranslationY((float) height);
                        View findViewById3 = hVar.aus.findViewById(R.id.fnn);
                        if (!(findViewById3 instanceof MinusScreenRoundFrameLayout)) {
                            view = null;
                        } else {
                            view = findViewById3;
                        }
                        if (((MinusScreenRoundFrameLayout) view) != null) {
                            ((MinusScreenRoundFrameLayout) findViewById3).RS(height);
                        }
                    }
                }
                if (i3 == ku) {
                    break;
                }
                i3++;
            }
        }
        AppMethodBeat.o(236636);
    }

    static final class k extends q implements kotlin.g.a.a<RecyclerView.LayoutManager> {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC, AppCompatActivity appCompatActivity) {
            super(0);
            this.Afv = multiTaskMinusScreenUIC;
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView.LayoutManager invoke() {
            AppMethodBeat.i(236617);
            RecyclerView.LayoutManager eS = this.Afv.Afr.eS(this.uQi);
            AppMethodBeat.o(236617);
            return eS;
        }
    }

    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            super(0);
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236610);
            com.tencent.mm.plugin.multitask.model.a multiTaskStorage = ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
            MultiTaskMinusScreenUIC.a(this.Afv, multiTaskStorage != null ? multiTaskStorage.eri() : null);
            MultiTaskMinusScreenUIC.b(this.Afv);
            x xVar = x.SXb;
            AppMethodBeat.o(236610);
            return xVar;
        }
    }

    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;
        final /* synthetic */ List Afw;
        final /* synthetic */ boolean Afx;
        final /* synthetic */ boolean Afy;
        final /* synthetic */ boolean vcK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC, List list, boolean z, boolean z2, boolean z3) {
            super(0);
            this.Afv = multiTaskMinusScreenUIC;
            this.Afw = list;
            this.vcK = z;
            this.Afx = z2;
            this.Afy = z3;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            WxRecyclerView wxRecyclerView;
            RecyclerView.m recycledViewPool;
            AppMethodBeat.i(236611);
            this.Afv.Afn.clear();
            List<MultiTaskInfo> list = this.Afw;
            if (list != null) {
                for (MultiTaskInfo multiTaskInfo : list) {
                    com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
                    if (com.tencent.mm.plugin.multitask.f.a.Js(multiTaskInfo.field_type)) {
                        this.Afv.Afn.add(new com.tencent.mm.plugin.multitask.ui.minusscreen.b.a(multiTaskInfo));
                    }
                }
            }
            if (this.vcK) {
                WxRecyclerView wxRecyclerView2 = this.Afv.ufR;
                if (wxRecyclerView2 != null) {
                    wxRecyclerView2.removeAllViewsInLayout();
                }
                WxRecyclerView wxRecyclerView3 = this.Afv.ufR;
                if (!(wxRecyclerView3 == null || (recycledViewPool = wxRecyclerView3.getRecycledViewPool()) == null)) {
                    recycledViewPool.clear();
                }
                WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter = this.Afv.Afs;
                if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.Rru.clear();
                }
                a aVar2 = MultiTaskMinusScreenUIC.Afu;
                Log.i(MultiTaskMinusScreenUIC.TAG, "clear Pool and RemoveAllViews");
            }
            WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter2 = this.Afv.Afs;
            if (wxRecyclerAdapter2 != null) {
                wxRecyclerAdapter2.notifyDataSetChanged();
            }
            if (this.Afx) {
                this.Afv.erL();
                if (this.Afv.Afn.size() == 1) {
                    MultiTaskMinusScreenUIC.a(this.Afv, this.Afv.Afn.get(0).Aen, true);
                } else {
                    MultiTaskMinusScreenUIC.a(this.Afv, (MultiTaskInfo) null, true);
                }
            }
            if (this.Afy && (wxRecyclerView = this.Afv.ufR) != null) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initDataUI$1", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
                wxRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initDataUI$1", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (this.Afw != null) {
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).fg(this.Afw);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236611);
            return xVar;
        }
    }

    static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTaskInfo AfA;
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(MultiTaskInfo multiTaskInfo, MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            super(0);
            this.AfA = multiTaskInfo;
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236618);
            MultiTaskInfo multiTaskInfo = this.AfA;
            if (multiTaskInfo != null) {
                this.Afv.Afn.add(0, new com.tencent.mm.plugin.multitask.ui.minusscreen.b.a(multiTaskInfo));
                WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter = this.Afv.Afs;
                if (wxRecyclerAdapter != null) {
                    WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter2 = this.Afv.Afs;
                    wxRecyclerAdapter.cj(wxRecyclerAdapter2 != null ? wxRecyclerAdapter2.RqM.size() : 1);
                }
                if (this.Afv.Afn.size() == 1) {
                    this.Afv.a(this.Afv.Afn.get(0).Aen, false, true);
                } else {
                    this.Afv.a((MultiTaskInfo) null, true, false);
                }
                WxRecyclerView wxRecyclerView = this.Afv.ufR;
                if (wxRecyclerView != null) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$onMultiTaskChange$$inlined$let$lambda$1", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
                    wxRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$onMultiTaskChange$$inlined$let$lambda$1", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
                }
                this.Afv.erL();
                int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitask_max_item_num, this.Afv.Afl);
                if (this.Afv.Afn.size() > a3) {
                    int size = this.Afv.Afn.size();
                    for (int i2 = a3; i2 < size; i2++) {
                        com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar = this.Afv.Afn.get(i2);
                        p.g(aVar, "multiTaskInfoList[i]");
                        ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).removeTaskInfoAndCoverImg(aVar.Aen.field_id);
                    }
                }
                a aVar2 = MultiTaskMinusScreenUIC.Afu;
                Log.i(MultiTaskMinusScreenUIC.TAG, "maxNum: " + a3 + ", curSize: " + this.Afv.Afn.size());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236618);
            return xVar;
        }
    }

    static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTaskInfo AfA;
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(MultiTaskInfo multiTaskInfo, MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            super(0);
            this.AfA = multiTaskInfo;
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int aGQ;
            AppMethodBeat.i(236619);
            MultiTaskInfo multiTaskInfo = this.AfA;
            if (multiTaskInfo != null && (aGQ = this.Afv.aGQ(multiTaskInfo.field_id)) >= 0) {
                this.Afv.Afn.remove(aGQ);
                WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter = this.Afv.Afs;
                int size = (wxRecyclerAdapter != null ? wxRecyclerAdapter.RqM.size() : 1) + aGQ;
                WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter2 = this.Afv.Afs;
                if (wxRecyclerAdapter2 != null) {
                    wxRecyclerAdapter2.ck(size);
                }
                if (this.Afv.Afn.size() == 1) {
                    this.Afv.a(this.Afv.Afn.get(0).Aen, false, false);
                } else {
                    this.Afv.a((MultiTaskInfo) null, true, false);
                }
                this.Afv.erL();
                b bVar = this.Afv.Afp;
                if (bVar != null) {
                    bVar.j(multiTaskInfo);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236619);
            return xVar;
        }
    }

    static final class n extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTaskInfo AfA;
        final /* synthetic */ MultiTaskMinusScreenUIC Afv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MultiTaskInfo multiTaskInfo, MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
            super(0);
            this.AfA = multiTaskInfo;
            this.Afv = multiTaskMinusScreenUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int aGQ;
            AppMethodBeat.i(236620);
            MultiTaskInfo multiTaskInfo = this.AfA;
            if (multiTaskInfo != null && (aGQ = this.Afv.aGQ(multiTaskInfo.field_id)) >= 0) {
                this.Afv.Afn.set(aGQ, new com.tencent.mm.plugin.multitask.ui.minusscreen.b.a(multiTaskInfo));
                WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter = this.Afv.Afs;
                int size = (wxRecyclerAdapter != null ? wxRecyclerAdapter.RqM.size() : 1) + aGQ;
                WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> wxRecyclerAdapter2 = this.Afv.Afs;
                if (wxRecyclerAdapter2 != null) {
                    wxRecyclerAdapter2.ci(size);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236620);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
        AppMethodBeat.i(258187);
        Log.i(TAG, "initBallInfo");
        multiTaskMinusScreenUIC.gcP();
        AppMethodBeat.o(258187);
    }

    public static final /* synthetic */ void q(com.tencent.mm.view.recyclerview.h hVar) {
        View findViewById;
        RecyclerView.a adapter;
        AppMethodBeat.i(236641);
        RecyclerView recyclerView = hVar.getRecyclerView();
        int itemCount = (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) ? 0 : adapter.getItemCount();
        if (itemCount == 2) {
            View findViewById2 = hVar.aus.findViewById(R.id.e24);
            if (findViewById2 != null) {
                int i2 = findViewById2.getLayoutParams().width;
                MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                if (i2 != MultiTaskUIC.AfY) {
                    MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                    findViewById2.setTranslationX((float) MultiTaskUIC.Agf);
                    MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                    findViewById2.setTranslationY((float) MultiTaskUIC.Age);
                    ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                    MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                    layoutParams.height = MultiTaskUIC.AfZ;
                    ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                    MultiTaskUIC.a aVar5 = MultiTaskUIC.Ago;
                    layoutParams2.width = MultiTaskUIC.AfY;
                    RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                    if (roundedCornerFrameLayout != null) {
                        ViewGroup.LayoutParams layoutParams3 = roundedCornerFrameLayout.getLayoutParams();
                        MultiTaskUIC.a aVar6 = MultiTaskUIC.Ago;
                        layoutParams3.height = MultiTaskUIC.Agd;
                    }
                    findViewById2.requestLayout();
                }
                AppMethodBeat.o(236641);
                return;
            }
            AppMethodBeat.o(236641);
        } else if (itemCount == 3) {
            View findViewById3 = hVar.aus.findViewById(R.id.e24);
            if (findViewById3 != null) {
                int i3 = findViewById3.getLayoutParams().width;
                MultiTaskUIC.a aVar7 = MultiTaskUIC.Ago;
                if (i3 != MultiTaskUIC.qmd) {
                    MultiTaskUIC.a aVar8 = MultiTaskUIC.Ago;
                    findViewById3.setTranslationY((float) MultiTaskUIC.Agh);
                    ViewGroup.LayoutParams layoutParams4 = findViewById3.getLayoutParams();
                    MultiTaskUIC.a aVar9 = MultiTaskUIC.Ago;
                    layoutParams4.height = MultiTaskUIC.kn;
                    ViewGroup.LayoutParams layoutParams5 = findViewById3.getLayoutParams();
                    MultiTaskUIC.a aVar10 = MultiTaskUIC.Ago;
                    layoutParams5.width = MultiTaskUIC.qmd;
                    RoundedCornerFrameLayout roundedCornerFrameLayout2 = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                    if (roundedCornerFrameLayout2 != null) {
                        ViewGroup.LayoutParams layoutParams6 = roundedCornerFrameLayout2.getLayoutParams();
                        MultiTaskUIC.a aVar11 = MultiTaskUIC.Ago;
                        layoutParams6.height = MultiTaskUIC.Agb;
                    }
                    findViewById3.requestLayout();
                }
                AppMethodBeat.o(236641);
                return;
            }
            AppMethodBeat.o(236641);
        } else if (itemCount < 4 || (findViewById = hVar.aus.findViewById(R.id.e24)) == null) {
            AppMethodBeat.o(236641);
        } else {
            int i4 = findViewById.getLayoutParams().width;
            MultiTaskUIC.a aVar12 = MultiTaskUIC.Ago;
            if (i4 != MultiTaskUIC.qmd) {
                ViewGroup.LayoutParams layoutParams7 = findViewById.getLayoutParams();
                MultiTaskUIC.a aVar13 = MultiTaskUIC.Ago;
                layoutParams7.height = MultiTaskUIC.kn;
                ViewGroup.LayoutParams layoutParams8 = findViewById.getLayoutParams();
                MultiTaskUIC.a aVar14 = MultiTaskUIC.Ago;
                layoutParams8.width = MultiTaskUIC.qmd;
                RoundedCornerFrameLayout roundedCornerFrameLayout3 = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                if (roundedCornerFrameLayout3 != null) {
                    ViewGroup.LayoutParams layoutParams9 = roundedCornerFrameLayout3.getLayoutParams();
                    MultiTaskUIC.a aVar15 = MultiTaskUIC.Ago;
                    layoutParams9.height = MultiTaskUIC.Agb;
                }
                findViewById.requestLayout();
            }
            AppMethodBeat.o(236641);
        }
    }

    public static final /* synthetic */ boolean a(MultiTaskMinusScreenUIC multiTaskMinusScreenUIC) {
        AppMethodBeat.i(236642);
        boolean z = false;
        if (System.currentTimeMillis() - multiTaskMinusScreenUIC.mRS < multiTaskMinusScreenUIC.Afm) {
            z = true;
        }
        multiTaskMinusScreenUIC.mRS = System.currentTimeMillis();
        AppMethodBeat.o(236642);
        return z;
    }
}
