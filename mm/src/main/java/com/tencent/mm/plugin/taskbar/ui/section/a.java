package com.tencent.mm.plugin.taskbar.ui.section;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarBaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;)V", "getItemView", "plugin-taskbar_release"})
public final class a extends RecyclerView.v {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(bVar);
        p.h(bVar, "itemView");
        AppMethodBeat.i(238493);
        bVar.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        AppMethodBeat.o(238493);
    }

    public final b fvh() {
        AppMethodBeat.i(238492);
        View view = this.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.ui.section.TaskBarSectionBaseView");
            AppMethodBeat.o(238492);
            throw tVar;
        }
        b bVar = (b) view;
        AppMethodBeat.o(238492);
        return bVar;
    }
}
