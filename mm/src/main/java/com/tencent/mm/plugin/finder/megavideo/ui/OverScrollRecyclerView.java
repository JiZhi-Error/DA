package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\rH\u0016R\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/design/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "overScrollBehavior", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "getOverScrollBehavior", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "overScrollBehavior$delegate", "Lkotlin/Lazy;", "getBehavior", "plugin-finder_release"})
public final class OverScrollRecyclerView extends WxRecyclerView implements CoordinatorLayout.a {
    private final f USs = g.ah(a.USt);

    public final OverScrollVerticalBehavior getOverScrollBehavior() {
        AppMethodBeat.i(261244);
        OverScrollVerticalBehavior overScrollVerticalBehavior = (OverScrollVerticalBehavior) this.USs.getValue();
        AppMethodBeat.o(261244);
        return overScrollVerticalBehavior;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverScrollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(248610);
        AppMethodBeat.o(248610);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverScrollRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(248611);
        AppMethodBeat.o(248611);
    }

    @Override // android.support.design.widget.CoordinatorLayout.a
    public final OverScrollVerticalBehavior getBehavior() {
        AppMethodBeat.i(248608);
        OverScrollVerticalBehavior overScrollBehavior = getOverScrollBehavior();
        AppMethodBeat.o(248608);
        return overScrollBehavior;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<OverScrollVerticalBehavior> {
        public static final a USt = new a();

        static {
            AppMethodBeat.i(261243);
            AppMethodBeat.o(261243);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ OverScrollVerticalBehavior invoke() {
            AppMethodBeat.i(261242);
            OverScrollVerticalBehavior overScrollVerticalBehavior = new OverScrollVerticalBehavior();
            AppMethodBeat.o(261242);
            return overScrollVerticalBehavior;
        }
    }
}
