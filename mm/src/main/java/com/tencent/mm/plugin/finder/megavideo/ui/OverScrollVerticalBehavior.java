package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0003JH\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J8\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J(\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "Landroid/support/design/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "deltaX", "", "getDeltaX", "()I", "setDeltaX", "(I)V", "deltaY", "getDeltaY", "setDeltaY", "pullDownListener", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "getPullDownListener", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "setPullDownListener", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;)V", "scrollThreshold", "getScrollThreshold", "setScrollThreshold", "onNestedScroll", "", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "Companion", "PullDownListener", "plugin-finder_release"})
public final class OverScrollVerticalBehavior extends CoordinatorLayout.Behavior<WxRecyclerView> {
    public static final a uMM = new a((byte) 0);
    private int DfV;
    private int USu;
    b USv;
    private int uML;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "", "onPullDown", "", "plugin-finder_release"})
    public interface b {
        void bQy();
    }

    static {
        AppMethodBeat.i(248615);
        AppMethodBeat.o(248615);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View, int] */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, WxRecyclerView wxRecyclerView, View view, int i2) {
        b bVar;
        AppMethodBeat.i(248614);
        WxRecyclerView wxRecyclerView2 = wxRecyclerView;
        p.h(coordinatorLayout, "coordinatorLayout");
        p.h(wxRecyclerView2, "child");
        p.h(view, "target");
        if (i2 == 0) {
            if (this.uML == 0) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
                p.g(viewConfiguration, "ViewConfiguration.get(target.context)");
                this.uML = viewConfiguration.getScaledTouchSlop() * 10;
            }
            if (wxRecyclerView2.getTranslationY() < 0.0f) {
                Log.i("OverScrollVerticalBehavior", "onStopNestedScroll: start anim translateY = " + wxRecyclerView2.getTranslationY());
                wxRecyclerView2.animate().translationY(0.0f).start();
                if (Math.abs(wxRecyclerView2.getTranslationY()) > ((float) this.uML)) {
                    RecyclerView.LayoutManager layoutManager = wxRecyclerView2.getLayoutManager();
                    if (!(layoutManager instanceof LinearLayoutManager)) {
                        layoutManager = null;
                    }
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    if (linearLayoutManager != null) {
                        RecyclerView.v cg = wxRecyclerView2.cg(linearLayoutManager.ku());
                        if (!(cg instanceof h)) {
                            cg = null;
                        }
                        h hVar = (h) cg;
                        if (hVar != null && !(hVar.hgv() instanceof bn)) {
                            u.makeText(wxRecyclerView2.getContext(), (int) R.string.d0m, 0).show();
                        }
                    }
                }
            }
            if (this.USu < 0 && Math.abs(this.USu) > Math.abs(this.DfV) && Math.abs(this.USu) > this.uML && (bVar = this.USv) != null) {
                bVar.bQy();
            }
            this.USu = 0;
            this.DfV = 0;
        }
        AppMethodBeat.o(248614);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View, int, int, int, int, int] */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, WxRecyclerView wxRecyclerView, View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(248613);
        WxRecyclerView wxRecyclerView2 = wxRecyclerView;
        p.h(coordinatorLayout, "coordinatorLayout");
        p.h(wxRecyclerView2, "child");
        p.h(view, "target");
        if (wxRecyclerView2 == view) {
            RecyclerView.LayoutManager layoutManager = wxRecyclerView2.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(248613);
                throw tVar;
            }
            int ku = ((LinearLayoutManager) layoutManager).ku();
            RecyclerView.a adapter = wxRecyclerView2.getAdapter();
            if (ku == (adapter != null ? adapter.getItemCount() : -1) - 1) {
                if (i5 > 0 && i6 == 0) {
                    Log.i("OverScrollVerticalBehavior", "onNestedScroll: start nested scroll dyUnconsumed = " + i5 + ", currTranslateY = " + wxRecyclerView2.getTranslationY());
                    wxRecyclerView2.animate().cancel();
                    wxRecyclerView2.setTranslationY(wxRecyclerView2.getTranslationY() - ((float) (i5 / 2)));
                    this.USu = 0;
                }
                this.DfV += i4;
                this.USu += i5;
            }
        }
        AppMethodBeat.o(248613);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int] */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, WxRecyclerView wxRecyclerView, View view, View view2, int i2, int i3) {
        AppMethodBeat.i(248612);
        WxRecyclerView wxRecyclerView2 = wxRecyclerView;
        p.h(coordinatorLayout, "coordinatorLayout");
        p.h(wxRecyclerView2, "child");
        p.h(view, "directTargetChild");
        p.h(view2, "target");
        this.DfV = 0;
        this.USu = 0;
        if (wxRecyclerView2 == view2 && (i2 & 2) != 0 && i3 == 0) {
            AppMethodBeat.o(248612);
            return true;
        }
        AppMethodBeat.o(248612);
        return false;
    }
}
