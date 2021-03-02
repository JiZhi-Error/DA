package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.vlog.model.effect.b;
import com.tencent.mm.plugin.vlog.model.effect.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicAddEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "order", "Landroid/widget/TextView;", "getOrder", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class g extends j {
    private final ImageView kc;
    private final TextView utK;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(191279);
        View findViewById = view.findViewById(R.id.e2z);
        p.g(findViewById, "itemView.findViewById(R.id.item_magic_panel_icon)");
        this.kc = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.e30);
        p.g(findViewById2, "itemView.findViewById(R.id.item_magic_panel_order)");
        this.utK = (TextView) findViewById2;
        AppMethodBeat.o(191279);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.j
    public final void a(e eVar) {
        e eVar2;
        AppMethodBeat.i(191278);
        p.h(eVar, "item");
        if (!(eVar instanceof b)) {
            eVar2 = null;
        } else {
            eVar2 = eVar;
        }
        b bVar = (b) eVar2;
        if (bVar != null) {
            com.tencent.mm.loader.e eVar3 = com.tencent.mm.loader.e.hXU;
            com.tencent.mm.loader.e.aJs().He(bVar.GAm.icon).c(this.kc);
            this.utK.setText(String.valueOf(bVar.order));
            AppMethodBeat.o(191278);
            return;
        }
        AppMethodBeat.o(191278);
    }
}
