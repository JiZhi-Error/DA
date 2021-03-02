package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiFullPageViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showId", "", "(Landroid/view/View;I)V", "getShowId", "()I", "setShowId", "(I)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class x extends q<h> {
    private int hbo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(View view, int i2) {
        super(view, null);
        p.h(view, "itemView");
        AppMethodBeat.i(105682);
        this.hbo = i2;
        AppMethodBeat.o(105682);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(105681);
        p.h(acVar, "item");
        super.a(acVar);
        View view = this.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(105681);
            throw tVar;
        }
        Iterator it = j.mY(0, ((ViewGroup) view).getChildCount()).iterator();
        while (it.hasNext()) {
            View childAt = ((ViewGroup) this.aus).getChildAt(((ab) it).nextInt());
            p.g(childAt, "itemView.getChildAt(it)");
            childAt.setVisibility(8);
        }
        View findViewById = this.aus.findViewById(this.hbo);
        p.g(findViewById, "itemView.findViewById<View>(showId)");
        findViewById.setVisibility(0);
        AppMethodBeat.o(105681);
    }
}
