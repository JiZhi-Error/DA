package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0019\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/view/View;", "plugin-emojisdk_release"})
public final class a extends q<t> {
    private final View hax;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105627);
        this.hax = view.findViewById(R.id.aja);
        view.setOnClickListener(null);
        this.hax.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.emoji.panel.a.a.AnonymousClass1 */
            final /* synthetic */ a hay;

            {
                this.hay = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(105626);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n nVar = this.hay.hbi;
                if (nVar != null) {
                    p.g(view, LocaleUtil.ITALIAN);
                    Context context = view.getContext();
                    p.g(context, "it.context");
                    nVar.a(view, context, this.hay.lR(), this.hay.hbh);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(105626);
            }
        });
        View view2 = this.hax;
        p.g(view2, "icon");
        View view3 = this.hax;
        p.g(view3, "icon");
        view2.setContentDescription(view3.getContext().getString(R.string.an4));
        AppMethodBeat.o(105627);
    }
}
