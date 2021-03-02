package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/design/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBehavior", "Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "getBehavior", "ui-multitask_release"})
public final class OverScrollMultiTaskRecyclerView extends WxRecyclerView implements CoordinatorLayout.a {
    private final OverScrollMultiTaskVerticalBehavior Afh = new OverScrollMultiTaskVerticalBehavior();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverScrollMultiTaskRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(236596);
        AppMethodBeat.o(236596);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverScrollMultiTaskRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(236597);
        AppMethodBeat.o(236597);
    }

    @Override // android.support.design.widget.CoordinatorLayout.a
    public final OverScrollMultiTaskVerticalBehavior getBehavior() {
        return this.Afh;
    }
}
