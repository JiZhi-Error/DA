package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.vlog.model.effect.d;
import com.tencent.mm.plugin.vlog.model.effect.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class h extends j {
    private final ImageView kc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(191281);
        View findViewById = view.findViewById(R.id.e2z);
        p.g(findViewById, "itemView.findViewById(R.id.item_magic_panel_icon)");
        this.kc = (ImageView) findViewById;
        AppMethodBeat.o(191281);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.j
    public final void a(e eVar) {
        e eVar2;
        AppMethodBeat.i(191280);
        p.h(eVar, "item");
        if (!(eVar instanceof d)) {
            eVar2 = null;
        } else {
            eVar2 = eVar;
        }
        d dVar = (d) eVar2;
        if (dVar != null) {
            com.tencent.mm.loader.e eVar3 = com.tencent.mm.loader.e.hXU;
            com.tencent.mm.loader.e.aJs().He(dVar.GAm.icon).c(this.kc);
            AppMethodBeat.o(191280);
            return;
        }
        AppMethodBeat.o(191280);
    }
}
