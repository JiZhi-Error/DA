package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.convert.s;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 >2\u00020\u0001:\u0002=>B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020$J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020'J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020$H\u0016J\u000e\u00101\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0013J\"\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u00106\u001a\u000207J\u0018\u00108\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0003J\u0018\u00109\u001a\u00020$2\u0006\u00103\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionBarOverlayLayout", "Landroid/view/ViewGroup;", "getActionBarOverlayLayout", "()Landroid/view/ViewGroup;", "actionBarOverlayLayout$delegate", "Lkotlin/Lazy;", "feedFullMergedHeaderConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "feedFullMergedHeaderHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "headerFullMergedData", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "maxPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowStreamDividerTip", "", "hideCompleted", "isBegin", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "notifyHeaderFullMergedView", "onActionbarClick", "isDouble", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setHeaderFullMergedData", "showActionBarTip", "isShow", "content", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "showCompleted", "showTips", "transOffset", "y", "", "Action", "Companion", "plugin-finder_release"})
public final class FinderActionBarOverlayUIC extends UIComponent {
    private static final int wvh;
    public static final b wvi = new b((byte) 0);
    private final MMHandler hAk;
    public ah tSk;
    private final kotlin.f vPc;
    private final kotlin.f vau = kotlin.g.ah(new e(this));
    public final kotlin.f wvc = kotlin.g.ah(new c(this));
    private final FinderHomeTabStateVM wvd;
    private int wve;
    public final s wvf;
    public com.tencent.mm.view.recyclerview.h wvg;

    private final int getTabType() {
        AppMethodBeat.i(255421);
        int intValue = ((Number) this.vPc.getValue()).intValue();
        AppMethodBeat.o(255421);
        return intValue;
    }

    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(255420);
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        AppMethodBeat.o(255420);
        return recyclerView;
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(255437);
        b(false, aVar);
        AppMethodBeat.o(255437);
    }

    public static final /* synthetic */ void a(FinderActionBarOverlayUIC finderActionBarOverlayUIC, a aVar) {
        AppMethodBeat.i(255436);
        finderActionBarOverlayUIC.c(false, aVar);
        AppMethodBeat.o(255436);
    }

    public static final /* synthetic */ void a(FinderActionBarOverlayUIC finderActionBarOverlayUIC, boolean z, a aVar) {
        AppMethodBeat.i(255434);
        finderActionBarOverlayUIC.a(z, aVar);
        AppMethodBeat.o(255434);
    }

    public static final /* synthetic */ RecyclerView b(FinderActionBarOverlayUIC finderActionBarOverlayUIC) {
        AppMethodBeat.i(255433);
        RecyclerView recyclerView = finderActionBarOverlayUIC.getRecyclerView();
        AppMethodBeat.o(255433);
        return recyclerView;
    }

    public static final /* synthetic */ int e(FinderActionBarOverlayUIC finderActionBarOverlayUIC) {
        AppMethodBeat.i(255435);
        int tabType = finderActionBarOverlayUIC.getTabType();
        AppMethodBeat.o(255435);
        return tabType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActionBarOverlayUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255430);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.wvd = (FinderHomeTabStateVM) viewModel;
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.vPc = kotlin.g.ah(new k(this));
        this.wvf = new s();
        AppMethodBeat.o(255430);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActionBarOverlayUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255431);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.wvd = (FinderHomeTabStateVM) viewModel;
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.vPc = kotlin.g.ah(new k(this));
        this.wvf = new s();
        AppMethodBeat.o(255431);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Companion;", "", "()V", "OFFSET", "", "OFFSET_DISTANCE", "getOFFSET_DISTANCE", "()I", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(255432);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        p.g(resources, "MMApplicationContext.getContext().resources");
        wvh = resources.getDisplayMetrics().heightPixels * 2;
        AppMethodBeat.o(255432);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "", "type", "", "(I)V", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getDuration", "()J", "setDuration", "(J)V", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "getType", "()I", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "Companion", "plugin-finder_release"})
    public static final class a {
        public static final C1351a wvj = new C1351a((byte) 0);
        long duration = 5000;
        CharSequence title;
        final int type;

        static {
            AppMethodBeat.i(255406);
            AppMethodBeat.o(255406);
        }

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof a) && this.type == ((a) obj).type);
        }

        public final int hashCode() {
            return this.type;
        }

        public final String toString() {
            AppMethodBeat.i(255407);
            String str = "Action(type=" + this.type + ")";
            AppMethodBeat.o(255407);
            return str;
        }

        public a(int i2) {
            this.type = i2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action$Companion;", "", "()V", "TYPE_DOUBLE_CLICK_TIPS", "", "TYPE_HISTORY_TIPS", "TYPE_NORMAL_TIPS", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC$a$a  reason: collision with other inner class name */
        public static final class C1351a {
            private C1351a() {
            }

            public /* synthetic */ C1351a(byte b2) {
                this();
            }
        }
    }

    public final void dHW() {
        AppMethodBeat.i(255422);
        y yVar = y.vXH;
        com.tencent.mm.view.recyclerview.h hVar = this.wvg;
        ah ahVar = this.tSk;
        if (!(hVar == null || ahVar == null)) {
            this.wvf.a(hVar, ahVar, 0);
        }
        AppMethodBeat.o(255422);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(255423);
        super.onCreateAfter(bundle);
        getRecyclerView().a(new d(this, (ViewGroup) findViewById(R.id.c3)));
        AppMethodBeat.o(255423);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "checkHeaderFullMergedShow", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class d extends RecyclerView.l {
        private final Rect rect = new Rect();
        final /* synthetic */ FinderActionBarOverlayUIC wvk;
        final /* synthetic */ ViewGroup wvl;

        d(FinderActionBarOverlayUIC finderActionBarOverlayUIC, ViewGroup viewGroup) {
            this.wvk = finderActionBarOverlayUIC;
            this.wvl = viewGroup;
            AppMethodBeat.i(255412);
            AppMethodBeat.o(255412);
        }

        private final void dHY() {
            AppMethodBeat.i(255409);
            if (this.wvk.tSk == null) {
                AppMethodBeat.o(255409);
                return;
            }
            RecyclerView.LayoutManager layoutManager = FinderActionBarOverlayUIC.b(this.wvk).getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(255409);
                throw tVar;
            }
            int ks = ((LinearLayoutManager) layoutManager).ks();
            if (ks == 0) {
                ViewGroup viewGroup = this.wvl;
                p.g(viewGroup, "mergedLayout");
                if (viewGroup.getVisibility() != 0) {
                    ViewGroup viewGroup2 = this.wvl;
                    p.g(viewGroup2, "mergedLayout");
                    viewGroup2.setVisibility(0);
                }
            }
            if (ks == 0) {
                ViewGroup viewGroup3 = this.wvl;
                p.g(viewGroup3, "mergedLayout");
                if (viewGroup3.getHeight() > 0) {
                    RecyclerView.v ch = FinderActionBarOverlayUIC.b(this.wvk).ch(0);
                    if (ch != null) {
                        FinderActionBarOverlayUIC.b(this.wvk);
                        RecyclerView.getDecoratedBoundsWithMargins(ch.aus, this.rect);
                        this.rect.top = Math.max(0, this.rect.top);
                        this.rect.bottom = Math.max(0, this.rect.bottom);
                        if (this.rect.height() > 0) {
                            ViewGroup viewGroup4 = this.wvl;
                            p.g(viewGroup4, "mergedLayout");
                            View view = ch.aus;
                            p.g(view, "it.itemView");
                            viewGroup4.setAlpha((1.0f * ((float) this.rect.height())) / ((float) view.getHeight()));
                            AppMethodBeat.o(255409);
                            return;
                        }
                        ViewGroup viewGroup5 = this.wvl;
                        p.g(viewGroup5, "mergedLayout");
                        viewGroup5.setVisibility(8);
                        AppMethodBeat.o(255409);
                        return;
                    }
                    ViewGroup viewGroup6 = this.wvl;
                    p.g(viewGroup6, "mergedLayout");
                    viewGroup6.setVisibility(8);
                    AppMethodBeat.o(255409);
                    return;
                }
            }
            if (ks > 0) {
                ViewGroup viewGroup7 = this.wvl;
                p.g(viewGroup7, "mergedLayout");
                viewGroup7.setVisibility(8);
            }
            AppMethodBeat.o(255409);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(255410);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            dHY();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(255410);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(255411);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(255411);
                throw tVar;
            }
            int ks = ((LinearLayoutManager) layoutManager).ks();
            if (this.wvk.wve < ks) {
                this.wvk.wve = ks;
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
                AppMethodBeat.o(255411);
                throw tVar2;
            }
            if (ks <= ((WxRecyclerAdapter) adapter).RqM.size()) {
                FinderActionBarOverlayUIC.a(this.wvk, false, new a(1));
                this.wvk.wve = 0;
            } else if (this.wvk.wve - ks >= 2 && this.wvk.wvd.Mr(FinderActionBarOverlayUIC.e(this.wvk))) {
                FinderActionBarOverlayUIC.a(this.wvk, true, new a(1));
            }
            if (i2 == 0) {
                dHY();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(255411);
        }
    }

    public final void dHX() {
        AppMethodBeat.i(255424);
        a(false, new a(1));
        FinderHomeTabStateVM.gu(getTabType(), 10000);
        AppMethodBeat.o(255424);
    }

    private final void a(boolean z, a aVar) {
        AppMethodBeat.i(255426);
        if (z) {
            View findViewById = findViewById(R.id.c5);
            if (findViewById != null) {
                findViewById.animate().cancel();
                c(true, aVar);
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                    findViewById.setAlpha(0.0f);
                    findViewById.animate().alpha(1.0f).setDuration(300).setListener(new i(this, aVar)).start();
                }
                AppMethodBeat.o(255426);
                return;
            }
            AppMethodBeat.o(255426);
            return;
        }
        View findViewById2 = findViewById(R.id.c5);
        if (findViewById2 != null) {
            findViewById2.animate().cancel();
            if (findViewById2.getVisibility() == 0) {
                b(true, aVar);
                findViewById2.animate().alpha(0.0f).setDuration(300).setListener(new j(findViewById2, this, aVar)).start();
            }
            AppMethodBeat.o(255426);
            return;
        }
        AppMethodBeat.o(255426);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;
        final /* synthetic */ a wvn;

        i(FinderActionBarOverlayUIC finderActionBarOverlayUIC, a aVar) {
            this.wvk = finderActionBarOverlayUIC;
            this.wvn = aVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255417);
            FinderActionBarOverlayUIC.a(this.wvk, this.wvn);
            AppMethodBeat.o(255417);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class j implements Animator.AnimatorListener {
        final /* synthetic */ View tCl;
        final /* synthetic */ FinderActionBarOverlayUIC wvk;
        final /* synthetic */ a wvn;

        j(View view, FinderActionBarOverlayUIC finderActionBarOverlayUIC, a aVar) {
            this.tCl = view;
            this.wvk = finderActionBarOverlayUIC;
            this.wvn = aVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255418);
            this.tCl.setVisibility(8);
            FinderActionBarOverlayUIC.a(this.wvn);
            AppMethodBeat.o(255418);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private static void b(boolean z, a aVar) {
        AppMethodBeat.i(255427);
        Log.i("Finder.DoubleClickTipUIC", "[hideCompleted] isBegin=" + z + " action=" + aVar.type);
        AppMethodBeat.o(255427);
    }

    @SuppressLint({"ResourceType"})
    private final void c(boolean z, a aVar) {
        AppMethodBeat.i(255428);
        Log.i("Finder.DoubleClickTipUIC", "[showCompleted] isBegin=" + z + " action=" + aVar.type);
        if (aVar.type == 1) {
            if (z) {
                TextView textView = (TextView) findViewById(R.id.ip5);
                if (textView != null) {
                    textView.setText(getContext().getResources().getString(R.string.clj));
                    textView.setVisibility(0);
                }
                WeImageView weImageView = (WeImageView) findViewById(R.id.ip8);
                if (weImageView != null) {
                    weImageView.setVisibility(0);
                    weImageView.setIconColor(getContext().getResources().getColor(R.color.v9));
                    weImageView.setRotation(-90.0f);
                    weImageView.setImageResource(R.raw.finder_self_feed_like_arrow);
                    AppMethodBeat.o(255428);
                    return;
                }
                AppMethodBeat.o(255428);
                return;
            }
            Fragment fragment = getFragment();
            if (fragment == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                AppMethodBeat.o(255428);
                throw tVar;
            }
            FinderHomeTabStateVM.Ms(((FinderHomeTabFragment) fragment).dLS);
            this.hAk.postDelayed(new f(this, aVar), aVar.duration);
            AppMethodBeat.o(255428);
        } else if (aVar.type == 2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(22077, "");
            TextView textView2 = (TextView) findViewById(R.id.ip5);
            if (textView2 != null) {
                textView2.setText(getContext().getResources().getString(R.string.d3h));
                textView2.setVisibility(0);
            }
            WeImageView weImageView2 = (WeImageView) findViewById(R.id.ip8);
            if (weImageView2 != null) {
                weImageView2.setVisibility(8);
            }
            this.hAk.postDelayed(new g(this, aVar), aVar.duration);
            AppMethodBeat.o(255428);
        } else {
            if (aVar.type == 0) {
                TextView textView3 = (TextView) findViewById(R.id.ip5);
                if (textView3 != null) {
                    textView3.setText(aVar.title);
                    textView3.setVisibility(0);
                }
                WeImageView weImageView3 = (WeImageView) findViewById(R.id.ip8);
                if (weImageView3 != null) {
                    weImageView3.setVisibility(8);
                }
                this.hAk.postDelayed(new h(this, aVar), aVar.duration);
            }
            AppMethodBeat.o(255428);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;
        final /* synthetic */ a wvm;

        f(FinderActionBarOverlayUIC finderActionBarOverlayUIC, a aVar) {
            this.wvk = finderActionBarOverlayUIC;
            this.wvm = aVar;
        }

        public final void run() {
            AppMethodBeat.i(255414);
            FinderActionBarOverlayUIC.a(this.wvk, false, this.wvm);
            AppMethodBeat.o(255414);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;
        final /* synthetic */ a wvm;

        g(FinderActionBarOverlayUIC finderActionBarOverlayUIC, a aVar) {
            this.wvk = finderActionBarOverlayUIC;
            this.wvm = aVar;
        }

        public final void run() {
            AppMethodBeat.i(255415);
            FinderActionBarOverlayUIC.a(this.wvk, false, this.wvm);
            AppMethodBeat.o(255415);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;
        final /* synthetic */ a wvm;

        h(FinderActionBarOverlayUIC finderActionBarOverlayUIC, a aVar) {
            this.wvk = finderActionBarOverlayUIC;
            this.wvm = aVar;
        }

        public final void run() {
            AppMethodBeat.i(255416);
            FinderActionBarOverlayUIC.a(this.wvk, false, this.wvm);
            AppMethodBeat.o(255416);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255429);
        super.onDestroy();
        this.hAk.removeCallbacksAndMessages(null);
        AppMethodBeat.o(255429);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderActionBarOverlayUIC finderActionBarOverlayUIC) {
            super(0);
            this.wvk = finderActionBarOverlayUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(255413);
            View findViewById = this.wvk.getRootView().findViewById(R.id.h7t);
            if (findViewById == null) {
                p.hyc();
            }
            RecyclerView recyclerView = ((RefreshLoadMoreLayout) findViewById).getRecyclerView();
            AppMethodBeat.o(255413);
            return recyclerView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderActionBarOverlayUIC finderActionBarOverlayUIC) {
            super(0);
            this.wvk = finderActionBarOverlayUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(255408);
            ViewGroup viewGroup = (ViewGroup) this.wvk.getRootView().findViewById(R.id.c4);
            AppMethodBeat.o(255408);
            return viewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderActionBarOverlayUIC wvk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderActionBarOverlayUIC finderActionBarOverlayUIC) {
            super(0);
            this.wvk = finderActionBarOverlayUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(255419);
            Fragment fragment = this.wvk.getFragment();
            if (fragment == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                AppMethodBeat.o(255419);
                throw tVar;
            }
            Integer valueOf = Integer.valueOf(((FinderHomeTabFragment) fragment).dLS);
            AppMethodBeat.o(255419);
            return valueOf;
        }
    }

    public static /* synthetic */ void a(FinderActionBarOverlayUIC finderActionBarOverlayUIC, CharSequence charSequence) {
        AppMethodBeat.i(255425);
        a aVar = new a(0);
        aVar.title = charSequence;
        aVar.duration = 3000;
        finderActionBarOverlayUIC.a(true, aVar);
        AppMethodBeat.o(255425);
    }
}
