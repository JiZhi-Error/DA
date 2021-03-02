package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class y extends q<h> {
    private final EmojiStatusView hbs;
    public boolean hbt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(View view, boolean z, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105684);
        this.hbt = z;
        View findViewById = view.findViewById(R.id.ur);
        p.g(findViewById, "itemView.findViewById(R.id.art_emoji_icon_iv)");
        this.hbs = (EmojiStatusView) findViewById;
        AppMethodBeat.o(105684);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        h hVar;
        AppMethodBeat.i(105683);
        p.h(acVar, "item");
        super.a(acVar);
        View findViewById = this.aus.findViewById(R.id.az);
        p.g(findViewById, "itemView.findViewById<View>(R.id.about_divider)");
        findViewById.setVisibility(this.hbt ? 0 : 8);
        if (this.hbs.getEmojiInfo() != null || (hVar = (h) this.hbh) == null) {
            AppMethodBeat.o(105683);
            return;
        }
        this.hbs.setEmojiInfo(hVar.gWm);
        AppMethodBeat.o(105683);
    }
}
