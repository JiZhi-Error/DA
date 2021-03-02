package com.tencent.mm.plugin.vlog.model.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.p;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getItemViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "getItemViewType", "", "plugin-vlog_release"})
public final class h implements p {
    private final n haK;

    public h(n nVar) {
        kotlin.g.b.p.h(nVar, "clickListener");
        AppMethodBeat.i(190800);
        this.haK = nVar;
        AppMethodBeat.o(190800);
    }

    @Override // com.tencent.mm.emoji.b.b.p
    public final int lU() {
        AppMethodBeat.i(190798);
        int fCc = b.fCc();
        AppMethodBeat.o(190798);
        return fCc;
    }

    @Override // com.tencent.mm.emoji.b.b.p
    public final q<?> d(ViewGroup viewGroup) {
        AppMethodBeat.i(190799);
        kotlin.g.b.p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.axb, viewGroup, false);
        kotlin.g.b.p.g(inflate, "itemView");
        g gVar = new g(inflate, this.haK);
        AppMethodBeat.o(190799);
        return gVar;
    }
}
