package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.convert.cg;
import com.tencent.mm.plugin.finder.convert.cm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.view.k;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u001d\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000201J\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 J\b\u00108\u001a\u000201H\u0002J\u001a\u00109\u001a\u0002012\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020100J\u001a\u0010<\u001a\u0002012\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020100J\b\u0010=\u001a\u00020;H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearBtn", "Landroid/view/View;", "getClearBtn", "()Landroid/view/View;", "setClearBtn", "(Landroid/view/View;)V", "contentView", "getContentView", "setContentView", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "mSnsScrollListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;)V", "viewCallback", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "getViewCallback", "()Lcom/tencent/mm/view/DefaultViewActionCallback;", "visibilityChangedListener", "Lkotlin/Function1;", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkVisibility", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "refreshClearBtn", "setOnInterceptListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setVisibilityChangedListener", "showSettingMenu", "plugin-finder_release"})
public final class FinderSnsHeaderView extends FrameLayout {
    private final String TAG = "Finder.FinderSnsHeaderView";
    public View contentView;
    public LinearLayoutManager vKp;
    public k woG;
    public HorizontalRecyclerView woN;
    private kotlin.g.a.b<? super Integer, x> woO;
    public View woP;
    private final com.tencent.mm.view.c woQ = new h(this);
    final e woR = new e();

    public static final /* synthetic */ void b(FinderSnsHeaderView finderSnsHeaderView) {
        AppMethodBeat.i(254961);
        finderSnsHeaderView.dHe();
        AppMethodBeat.o(254961);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderSnsHeaderView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(254957);
        AppMethodBeat.o(254957);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderSnsHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254958);
        AppMethodBeat.o(254958);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderSnsHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254959);
        AppMethodBeat.o(254959);
    }

    public final k getPresenter() {
        AppMethodBeat.i(254942);
        k kVar = this.woG;
        if (kVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(254942);
        return kVar;
    }

    public final void setPresenter(k kVar) {
        AppMethodBeat.i(254943);
        p.h(kVar, "<set-?>");
        this.woG = kVar;
        AppMethodBeat.o(254943);
    }

    public final HorizontalRecyclerView getRecyclerView() {
        AppMethodBeat.i(254944);
        HorizontalRecyclerView horizontalRecyclerView = this.woN;
        if (horizontalRecyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(254944);
        return horizontalRecyclerView;
    }

    public final void setRecyclerView(HorizontalRecyclerView horizontalRecyclerView) {
        AppMethodBeat.i(254945);
        p.h(horizontalRecyclerView, "<set-?>");
        this.woN = horizontalRecyclerView;
        AppMethodBeat.o(254945);
    }

    public final LinearLayoutManager getLayoutManager() {
        AppMethodBeat.i(254946);
        LinearLayoutManager linearLayoutManager = this.vKp;
        if (linearLayoutManager == null) {
            p.btv("layoutManager");
        }
        AppMethodBeat.o(254946);
        return linearLayoutManager;
    }

    public final void setLayoutManager(LinearLayoutManager linearLayoutManager) {
        AppMethodBeat.i(254947);
        p.h(linearLayoutManager, "<set-?>");
        this.vKp = linearLayoutManager;
        AppMethodBeat.o(254947);
    }

    public final View getContentView() {
        AppMethodBeat.i(254948);
        View view = this.contentView;
        if (view == null) {
            p.btv("contentView");
        }
        AppMethodBeat.o(254948);
        return view;
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(254949);
        p.h(view, "<set-?>");
        this.contentView = view;
        AppMethodBeat.o(254949);
    }

    public final View getClearBtn() {
        AppMethodBeat.i(254950);
        View view = this.woP;
        if (view == null) {
            p.btv("clearBtn");
        }
        AppMethodBeat.o(254950);
        return view;
    }

    public final void setClearBtn(View view) {
        AppMethodBeat.i(254951);
        p.h(view, "<set-?>");
        this.woP = view;
        AppMethodBeat.o(254951);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class c implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ WxRecyclerAdapter tDq;
        final /* synthetic */ FinderSnsHeaderView woS;
        final /* synthetic */ k woT;

        c(WxRecyclerAdapter wxRecyclerAdapter, FinderSnsHeaderView finderSnsHeaderView, k kVar) {
            this.tDq = wxRecyclerAdapter;
            this.woS = finderSnsHeaderView;
            this.woT = kVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            Object obj;
            AppMethodBeat.i(254923);
            com.tencent.mm.view.recyclerview.h hVar2 = hVar;
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar2, "holder");
            int size = i2 - this.tDq.RqM.size();
            String str = this.woS.TAG;
            StringBuilder sb = new StringBuilder("click item ");
            if (size < 0 || size >= this.woT.kgc.size()) {
                obj = "";
            } else {
                obj = this.woT.kgc.get(size);
                p.g(obj, "presenter.dataList[clickPos]");
            }
            Log.i(str, sb.append(obj).append(" pos:").append(size).toString());
            bo boVar = (bo) hVar2.hgv();
            if (boVar != null) {
                this.woT.c(boVar);
                AppMethodBeat.o(254923);
                return;
            }
            AppMethodBeat.o(254923);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class d extends RecyclerView.l {
        final /* synthetic */ k woU;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(254925);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(254925);
        }

        d(k kVar) {
            this.woU = kVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int size;
            AppMethodBeat.i(254924);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null && (size = this.woU.kgc.size() - linearLayoutManager.kv()) >= 0 && 5 >= size) {
                com.tencent.mm.plugin.finder.feed.model.g gVar = this.woU.woJ;
                if (!gVar.tUq && com.tencent.mm.plugin.finder.feed.model.g.tuG) {
                    Log.i(gVar.TAG, "begin loadMore");
                    gVar.tUq = true;
                    ch chVar = new ch(com.tencent.mm.plugin.finder.feed.model.g.lastBuffer, gVar.ttO);
                    chVar.pullType = 2;
                    gVar.tXj = chVar;
                    com.tencent.mm.kernel.g.azz().b(gVar.tXj);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(254924);
        }
    }

    /* access modifiers changed from: package-private */
    public final void dHe() {
        AppMethodBeat.i(254952);
        View view = this.woP;
        if (view == null) {
            p.btv("clearBtn");
        }
        view.setVisibility(0);
        View view2 = this.woP;
        if (view2 == null) {
            p.btv("clearBtn");
        }
        view2.post(new f(this));
        View view3 = this.woP;
        if (view3 == null) {
            p.btv("clearBtn");
        }
        view3.setOnClickListener(new g(this));
        AppMethodBeat.o(254952);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ FinderSnsHeaderView woS;

        f(FinderSnsHeaderView finderSnsHeaderView) {
            this.woS = finderSnsHeaderView;
        }

        public final void run() {
            AppMethodBeat.i(254928);
            Rect rect = new Rect();
            this.woS.getClearBtn().getHitRect(rect);
            rect.inset(rect.width() * -2, -rect.width());
            ViewParent parent = this.woS.getClearBtn().getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(254928);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.woS.getClearBtn()));
            AppMethodBeat.o(254928);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ FinderSnsHeaderView woS;

        g(FinderSnsHeaderView finderSnsHeaderView) {
            this.woS = finderSnsHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254931);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.woS.getContext(), 1, true);
            eVar.a(new a(this));
            eVar.a(new b(this));
            eVar.dGm();
            ArrayList aO = this.woS.getPresenter().aO(y.class);
            StringBuilder append = new StringBuilder().append(System.currentTimeMillis()).append(",1,");
            ArrayList<y> arrayList = aO;
            ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
            for (y yVar : arrayList) {
                awe awe = yVar.uOo.liveInfo;
                arrayList2.add(Long.valueOf(awe != null ? awe.liveId : 0));
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21530, append.append(j.a(arrayList2, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)).append(',').append(((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD()).toString());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254931);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2$1$1"})
        static final class a implements o.f {
            final /* synthetic */ g woV;
            final /* synthetic */ int woW = 1;
            final /* synthetic */ int woX = 2;

            a(g gVar) {
                this.woV = gVar;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(254929);
                int i2 = this.woW;
                Context context = this.woV.woS.getContext();
                p.g(context, "context");
                mVar.a(i2, context.getResources().getColor(R.color.Red), this.woV.woS.getContext().getString(R.string.t2));
                if (FinderSnsHeaderView.dHf()) {
                    mVar.kV(this.woX, R.string.d_7);
                }
                AppMethodBeat.o(254929);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2$1$2"})
        static final class b implements o.g {
            final /* synthetic */ g woV;
            final /* synthetic */ int woW = 1;
            final /* synthetic */ int woX = 2;

            b(g gVar) {
                this.woV = gVar;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                String str;
                LinkedList<FinderContact> linkedList;
                AppMethodBeat.i(254930);
                p.g(menuItem, "menuItem");
                int itemId = menuItem.getItemId();
                if (itemId == this.woW) {
                    k presenter = this.woV.woS.getPresenter();
                    ArrayList aO = presenter.aO(y.class);
                    p.h(aO, "exposed");
                    com.tencent.mm.ac.d.c("FinderSnsLiveListExpose", new k.b(aO));
                    StringBuilder append = new StringBuilder().append(System.currentTimeMillis()).append(",2,");
                    ArrayList<y> arrayList = aO;
                    ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
                    for (y yVar : arrayList) {
                        awe awe = yVar.uOo.liveInfo;
                        arrayList2.add(Long.valueOf(awe != null ? awe.liveId : 0));
                    }
                    StringBuilder append2 = append.append(j.a(arrayList2, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)).append(',').append(((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD()).append(',');
                    ArrayList<y> arrayList3 = aO;
                    ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
                    for (y yVar2 : arrayList3) {
                        bcq bcq = yVar2.uOo.snsShareInfo;
                        if (bcq == null || (linkedList = bcq.LLL) == null) {
                            str = null;
                        } else {
                            LinkedList<FinderContact> linkedList2 = linkedList;
                            ArrayList arrayList5 = new ArrayList(j.a(linkedList2, 10));
                            Iterator<T> it = linkedList2.iterator();
                            while (it.hasNext()) {
                                arrayList5.add(it.next().username);
                            }
                            str = j.a(arrayList5, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
                        }
                        arrayList4.add(str);
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21530, append2.append(j.a(arrayList4, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)).toString());
                    com.tencent.mm.plugin.finder.feed.model.g gVar = presenter.woJ;
                    gVar.kgc.clear();
                    gVar.tXl.onChanged();
                    AppMethodBeat.o(254930);
                    return;
                }
                if (itemId == this.woX) {
                    k presenter2 = this.woV.woS.getPresenter();
                    ae aeVar = ae.SYK;
                    String format = String.format("%s,%s", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), 3}, 2));
                    p.g(format, "java.lang.String.format(format, *args)");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21529, format);
                    Activity activity = presenter2.dKq;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(presenter2.dKq, SettingsPrivacyUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                AppMethodBeat.o(254930);
            }
        }
    }

    public final void setOnInterceptListener(kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(254953);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HorizontalRecyclerView horizontalRecyclerView = this.woN;
        if (horizontalRecyclerView == null) {
            p.btv("recyclerView");
        }
        horizontalRecyclerView.setOnInterceptChangedListener(bVar);
        AppMethodBeat.o(254953);
    }

    public final void setVisibilityChangedListener(kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(254954);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.woO = bVar;
        AppMethodBeat.o(254954);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class b extends RecyclerView.h {
        final /* synthetic */ FinderSnsHeaderView woS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderSnsHeaderView finderSnsHeaderView) {
            this.woS = finderSnsHeaderView;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(254922);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            Context context = view.getContext();
            p.g(context, "view.context");
            int dimension = (int) context.getResources().getDimension(R.dimen.c5);
            Context context2 = view.getContext();
            p.g(context2, "view.context");
            int dimension2 = (int) context2.getResources().getDimension(R.dimen.bs);
            int bw = RecyclerView.bw(view);
            RecyclerView.a adapter = this.woS.getRecyclerView().getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            if (bw == 0) {
                rect.left = dimension;
                rect.right = dimension2;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(254922);
            } else if (bw == itemCount - 1) {
                rect.left = dimension2;
                rect.right = dimension;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(254922);
            } else {
                rect.left = dimension2;
                rect.right = dimension2;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(254922);
            }
        }
    }

    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(254955);
        b bVar = new b(this);
        AppMethodBeat.o(254955);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ FinderSnsHeaderView woS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderSnsHeaderView finderSnsHeaderView) {
            this.woS = finderSnsHeaderView;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(254921);
            switch (i2) {
                case 2004:
                    cg cgVar = new cg();
                    AppMethodBeat.o(254921);
                    return cgVar;
                case 2015:
                    cm cmVar = new cm();
                    cmVar.tHg = 1;
                    Context context = this.woS.getContext();
                    p.g(context, "context");
                    Resources resources = context.getResources();
                    p.g(resources, "context.resources");
                    int i3 = resources.getDisplayMetrics().widthPixels;
                    Context context2 = this.woS.getContext();
                    p.g(context2, "context");
                    Resources resources2 = context2.getResources();
                    p.g(resources2, "context.resources");
                    float min = ((float) (Math.min(resources2.getDisplayMetrics().heightPixels, i3) - com.tencent.mm.cb.a.fromDPToPix(this.woS.getContext(), 16))) / 3.5f;
                    if (min <= 0.0f) {
                        Context context3 = this.woS.getContext();
                        p.g(context3, "context");
                        min = context3.getResources().getDimension(R.dimen.bz);
                    }
                    cmVar.lineHeight = (int) ((min * 4.0f) / 3.0f);
                    cm cmVar2 = cmVar;
                    AppMethodBeat.o(254921);
                    return cmVar2;
                default:
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    com.tencent.mm.plugin.finder.utils.y.dQ(this.woS.TAG, i2);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(254921);
                    return fVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$viewCallback$1", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
    public static final class h extends com.tencent.mm.view.c {
        final /* synthetic */ FinderSnsHeaderView woS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderSnsHeaderView finderSnsHeaderView) {
            this.woS = finderSnsHeaderView;
        }

        @Override // com.tencent.mm.view.c, com.tencent.mm.view.j
        public final void onChanged() {
            AppMethodBeat.i(254937);
            com.tencent.mm.ac.d.h(new a(this));
            AppMethodBeat.o(254937);
        }

        @Override // com.tencent.mm.view.c, com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(254938);
            com.tencent.mm.ac.d.h(new b(this, i2, i3));
            AppMethodBeat.o(254938);
        }

        @Override // com.tencent.mm.view.c, com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(254939);
            com.tencent.mm.ac.d.h(new c(this, i2, i3, obj));
            AppMethodBeat.o(254939);
        }

        @Override // com.tencent.mm.view.c, com.tencent.mm.view.j
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(254940);
            com.tencent.mm.ac.d.h(new d(this, i2, i3));
            AppMethodBeat.o(254940);
        }

        @Override // com.tencent.mm.view.c, com.tencent.mm.view.j
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(254941);
            com.tencent.mm.ac.d.h(new e(this, i2, i3));
            AppMethodBeat.o(254941);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ h woY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(h hVar) {
                super(0);
                this.woY = hVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254932);
                RecyclerView.a adapter = this.woY.woS.getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                RecyclerView.LayoutManager layoutManager = this.woY.woS.getRecyclerView().getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null) {
                    linearLayoutManager.ah(0, 0);
                }
                this.woY.woS.dHd();
                FinderSnsHeaderView.b(this.woY.woS);
                x xVar = x.SXb;
                AppMethodBeat.o(254932);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;
            final /* synthetic */ h woY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(h hVar, int i2, int i3) {
                super(0);
                this.woY = hVar;
                this.tYg = i2;
                this.tYh = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254933);
                RecyclerView.a adapter = this.woY.woS.getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.aq(this.tYg, this.tYh);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254933);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;
            final /* synthetic */ Object tYi;
            final /* synthetic */ h woY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(h hVar, int i2, int i3, Object obj) {
                super(0);
                this.woY = hVar;
                this.tYg = i2;
                this.tYh = i3;
                this.tYi = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254934);
                RecyclerView.a adapter = this.woY.woS.getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.e(this.tYg, this.tYh, this.tYi);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254934);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;
            final /* synthetic */ h woY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(h hVar, int i2, int i3) {
                super(0);
                this.woY = hVar;
                this.tYg = i2;
                this.tYh = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                RecyclerView.a adapter;
                AppMethodBeat.i(254935);
                RecyclerView.a adapter2 = this.woY.woS.getRecyclerView().getAdapter();
                if (adapter2 != null) {
                    adapter2.as(this.tYg, this.tYh);
                }
                if (this.tYg > 0 && (adapter = this.woY.woS.getRecyclerView().getAdapter()) != null) {
                    adapter.ci(this.tYg - 1);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254935);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class e extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;
            final /* synthetic */ h woY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(h hVar, int i2, int i3) {
                super(0);
                this.woY = hVar;
                this.tYg = i2;
                this.tYh = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254936);
                RecyclerView.a adapter = this.woY.woS.getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.at(this.tYg, this.tYh);
                }
                this.woY.woS.dHd();
                x xVar = x.SXb;
                AppMethodBeat.o(254936);
                return xVar;
            }
        }
    }

    public final com.tencent.mm.view.c getViewCallback() {
        return this.woQ;
    }

    public final void dHd() {
        AppMethodBeat.i(254956);
        boolean z = (z.aUd() & 17592186044416L) == 0;
        k kVar = this.woG;
        if (kVar == null) {
            p.btv("presenter");
        }
        if (kVar.kgc.isEmpty() || !z) {
            View view = this.contentView;
            if (view == null) {
                p.btv("contentView");
            }
            view.setVisibility(8);
            Context context = getContext();
            p.g(context, "context");
            setPadding(0, (int) context.getResources().getDimension(R.dimen.ci), 0, 0);
        } else {
            View view2 = this.contentView;
            if (view2 == null) {
                p.btv("contentView");
            }
            view2.setVisibility(0);
            setPadding(0, 0, 0, 0);
        }
        kotlin.g.a.b<? super Integer, x> bVar = this.woO;
        if (bVar != null) {
            View view3 = this.contentView;
            if (view3 == null) {
                p.btv("contentView");
            }
            bVar.invoke(Integer.valueOf(view3.getVisibility()));
            AppMethodBeat.o(254956);
            return;
        }
        AppMethodBeat.o(254956);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(254927);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(254927);
        }

        e() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(254926);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, "61", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL_HORIZONTAL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(254926);
        }
    }

    public static final /* synthetic */ boolean dHf() {
        AppMethodBeat.i(254960);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_FINDER_SNS_LIVE_LIST_SETTING_ENABLE_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(254960);
            throw tVar;
        } else if (((Integer) obj).intValue() == 1) {
            AppMethodBeat.o(254960);
            return true;
        } else {
            AppMethodBeat.o(254960);
            return false;
        }
    }
}
