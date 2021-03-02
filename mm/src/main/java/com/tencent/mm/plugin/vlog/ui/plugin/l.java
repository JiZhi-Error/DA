package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.vlog.model.effect.e;
import com.tencent.mm.plugin.vlog.model.effect.f;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTitleItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class l extends j {
    private final TextView hbb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(191310);
        View findViewById = view.findViewById(R.id.e31);
        p.g(findViewById, "itemView.findViewById(R.id.item_magic_panel_title)");
        this.hbb = (TextView) findViewById;
        AppMethodBeat.o(191310);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.j
    public final void a(e eVar) {
        e eVar2;
        AppMethodBeat.i(191309);
        p.h(eVar, "item");
        if (!(eVar instanceof f)) {
            eVar2 = null;
        } else {
            eVar2 = eVar;
        }
        f fVar = (f) eVar2;
        if (fVar != null) {
            this.hbb.setText(fVar.title);
            AppMethodBeat.o(191309);
            return;
        }
        AppMethodBeat.o(191309);
    }
}
