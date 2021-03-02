package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1", "Landroid/support/v7/widget/GridLayoutManager;", "canScrollVertically", "", "plugin-taskbar_release"})
public final class TaskBarSectionOtherView$layoutManager$1 extends GridLayoutManager {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskBarSectionOtherView$layoutManager$1(Context context) {
        super(3, 1);
        this.$context = context;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        return false;
    }
}
