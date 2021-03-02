package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiLoadingViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class t extends q<h> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(View view) {
        super(view, null);
        p.h(view, "itemView");
        AppMethodBeat.i(199975);
        AppMethodBeat.o(199975);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(199974);
        p.h(acVar, "item");
        super.a(acVar);
        View view = this.aus;
        if (view == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(199974);
            throw tVar;
        }
        Iterator it = j.mY(0, ((ViewGroup) view).getChildCount()).iterator();
        while (it.hasNext()) {
            View childAt = ((ViewGroup) this.aus).getChildAt(((ab) it).nextInt());
            p.g(childAt, "itemView.getChildAt(it)");
            childAt.setVisibility(8);
        }
        View findViewById = this.aus.findViewById(R.id.ep4);
        p.g(findViewById, "itemView.findViewById<Pr…sBar>(R.id.load_progress)");
        ((ProgressBar) findViewById).setVisibility(0);
        AppMethodBeat.o(199974);
    }
}
