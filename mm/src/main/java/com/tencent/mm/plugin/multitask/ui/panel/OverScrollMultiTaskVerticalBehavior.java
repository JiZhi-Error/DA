package com.tencent.mm.plugin.multitask.ui.panel;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.c.a.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J8\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "Landroid/support/design/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "mMultiTaskItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onNestedScroll", "", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "setMultiTaskItemListener", "itemListener", "Companion", "ui-multitask_release"})
public final class OverScrollMultiTaskVerticalBehavior extends CoordinatorLayout.Behavior<WxRecyclerView> {
    public static final a Afj = new a((byte) 0);
    public com.tencent.mm.plugin.multitask.ui.minusscreen.d.a Afi;

    static {
        AppMethodBeat.i(236603);
        AppMethodBeat.o(236603);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View, int] */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, WxRecyclerView wxRecyclerView, View view, int i2) {
        AppMethodBeat.i(236602);
        WxRecyclerView wxRecyclerView2 = wxRecyclerView;
        p.h(coordinatorLayout, "coordinatorLayout");
        p.h(wxRecyclerView2, "child");
        p.h(view, "target");
        if (i2 == 0) {
            if (wxRecyclerView2.getTranslationY() < 0.0f) {
                Log.d("OverScrollMultiTaskVerticalBehavior", "onStopNestedScroll Up : start anim translateY = " + wxRecyclerView2.getTranslationY());
                com.tencent.mm.ui.c.a.a.gu(wxRecyclerView2).co(0.0f).a(new b(this)).start();
                AppMethodBeat.o(236602);
                return;
            } else if (wxRecyclerView2.getTranslationY() > 0.0f) {
                Log.d("OverScrollMultiTaskVerticalBehavior", "onStopNestedScroll Down: start anim translateY = " + wxRecyclerView2.getTranslationY());
                com.tencent.mm.ui.c.a.a.gu(wxRecyclerView2).co(0.0f).a(new c(this)).start();
            }
        }
        AppMethodBeat.o(236602);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View, int, int, int, int, int] */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, WxRecyclerView wxRecyclerView, View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(236601);
        WxRecyclerView wxRecyclerView2 = wxRecyclerView;
        p.h(coordinatorLayout, "coordinatorLayout");
        p.h(wxRecyclerView2, "child");
        p.h(view, "target");
        if (wxRecyclerView2 == view) {
            RecyclerView.LayoutManager layoutManager = wxRecyclerView2.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(236601);
                throw tVar;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int ku = linearLayoutManager.ku();
            RecyclerView.a adapter = wxRecyclerView2.getAdapter();
            if (ku == (adapter != null ? adapter.getItemCount() : -1) - 1 || linearLayoutManager.ks() == 0) {
                if (i5 > 0 && i6 == 0) {
                    Log.d("OverScrollMultiTaskVerticalBehavior", "onNestedScroll: start nested scroll Up dyUnconsumed = " + i5 + ", currTranslateY = " + wxRecyclerView2.getTranslationY());
                    wxRecyclerView2.animate().cancel();
                    wxRecyclerView2.setTranslationY(wxRecyclerView2.getTranslationY() - ((float) (i5 / 2)));
                    com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar = this.Afi;
                    if (aVar != null) {
                        aVar.erE();
                        AppMethodBeat.o(236601);
                        return;
                    }
                    AppMethodBeat.o(236601);
                    return;
                } else if (i5 < 0 && i6 == 0) {
                    Log.d("OverScrollMultiTaskVerticalBehavior", "onNestedScroll: start nested scroll Down dyUnconsumed = " + i5 + ", currTranslateY = " + wxRecyclerView2.getTranslationY());
                    wxRecyclerView2.animate().cancel();
                    wxRecyclerView2.setTranslationY(wxRecyclerView2.getTranslationY() - ((float) (i5 / 2)));
                    com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar2 = this.Afi;
                    if (aVar2 != null) {
                        aVar2.erE();
                        AppMethodBeat.o(236601);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(236601);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int] */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, WxRecyclerView wxRecyclerView, View view, View view2, int i2, int i3) {
        AppMethodBeat.i(236600);
        WxRecyclerView wxRecyclerView2 = wxRecyclerView;
        p.h(coordinatorLayout, "coordinatorLayout");
        p.h(wxRecyclerView2, "child");
        p.h(view, "directTargetChild");
        p.h(view2, "target");
        if (wxRecyclerView2 == view2 && (i2 & 2) != 0 && i3 == 0) {
            AppMethodBeat.o(236600);
            return true;
        }
        AppMethodBeat.o(236600);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onUpdate"})
    static final class b implements b.a {
        final /* synthetic */ OverScrollMultiTaskVerticalBehavior Afk;

        b(OverScrollMultiTaskVerticalBehavior overScrollMultiTaskVerticalBehavior) {
            this.Afk = overScrollMultiTaskVerticalBehavior;
        }

        @Override // com.tencent.mm.ui.c.a.b.a
        public final void by(float f2) {
            AppMethodBeat.i(236598);
            com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar = this.Afk.Afi;
            if (aVar != null) {
                aVar.erE();
                AppMethodBeat.o(236598);
                return;
            }
            AppMethodBeat.o(236598);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onUpdate"})
    static final class c implements b.a {
        final /* synthetic */ OverScrollMultiTaskVerticalBehavior Afk;

        c(OverScrollMultiTaskVerticalBehavior overScrollMultiTaskVerticalBehavior) {
            this.Afk = overScrollMultiTaskVerticalBehavior;
        }

        @Override // com.tencent.mm.ui.c.a.b.a
        public final void by(float f2) {
            AppMethodBeat.i(236599);
            com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar = this.Afk.Afi;
            if (aVar != null) {
                aVar.erE();
                AppMethodBeat.o(236599);
                return;
            }
            AppMethodBeat.o(236599);
        }
    }
}
