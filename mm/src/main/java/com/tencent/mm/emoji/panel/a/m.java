package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.t;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/ExpandPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "getIcon", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class m extends q<t> {
    private final View hax;
    private final TextView hbb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105674);
        View findViewById = view.findViewById(R.id.c0r);
        p.g(findViewById, "itemView.findViewById(R.…_panel_item_expand_title)");
        this.hbb = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.c0q);
        p.g(findViewById2, "itemView.findViewById(R.…i_panel_item_expand_icon)");
        this.hax = findViewById2;
        AppMethodBeat.o(105674);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(105673);
        p.h(acVar, "item");
        super.a(acVar);
        t tVar = (t) this.hbh;
        if (tVar == null) {
            AppMethodBeat.o(105673);
        } else if (tVar.gYL) {
            this.hbb.setText(R.string.bt0);
            this.hax.setRotation(180.0f);
            AppMethodBeat.o(105673);
        } else {
            this.hbb.setText(R.string.bt1);
            this.hax.setRotation(0.0f);
            AppMethodBeat.o(105673);
        }
    }
}
