package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0019\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "searchMore", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/view/View;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class s extends q<h> {
    private final View hbk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(199973);
        this.hbk = view.findViewById(R.id.heo);
        AppMethodBeat.o(199973);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(199972);
        p.h(acVar, "item");
        super.a(acVar);
        View view = this.hbk;
        p.g(view, "searchMore");
        view.setVisibility(0);
        this.hbk.setOnClickListener(new a(this));
        AppMethodBeat.o(199972);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ s hbl;

        a(s sVar) {
            this.hbl = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(199971);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            n nVar = this.hbl.hbi;
            if (nVar != null) {
                p.g(view, LocaleUtil.ITALIAN);
                Context context = view.getContext();
                p.g(context, "it.context");
                nVar.a(view, context, this.hbl.lR(), this.hbl.hbh);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199971);
        }
    }
}
