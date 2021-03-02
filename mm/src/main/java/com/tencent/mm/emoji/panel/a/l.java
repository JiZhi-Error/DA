package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class l extends q<m> {
    private final ImageView kc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105672);
        View findViewById = view.findViewById(R.id.ur);
        p.g(findViewById, "itemView.findViewById(R.id.art_emoji_icon_iv)");
        this.kc = (ImageView) findViewById;
        AppMethodBeat.o(105672);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(105671);
        p.h(acVar, "item");
        super.a(acVar);
        e.cG(this.kc.getContext());
        m mVar = (m) this.hbh;
        if (mVar == null) {
            AppMethodBeat.o(105671);
        } else if (mVar.gYH == 0) {
            this.kc.setImageDrawable(ar.m(this.kc.getContext(), R.raw.emoji_add_custom, this.kc.getContext().getResources().getColor(R.color.vm)));
            this.kc.setContentDescription(this.kc.getContext().getString(R.string.gof));
            AppMethodBeat.o(105671);
        } else {
            if (mVar.gYH == 1) {
                this.kc.setImageDrawable(ar.m(this.kc.getContext(), R.raw.emoji_add_capture, this.kc.getContext().getResources().getColor(R.color.vm)));
                this.kc.setContentDescription(this.kc.getContext().getString(R.string.an4));
            }
            AppMethodBeat.o(105671);
        }
    }
}
