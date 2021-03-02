package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "I", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getOnClick", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setOnClick", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "panelItem", "getPanelItem", "()Lcom/tencent/mm/emoji/model/panel/PanelItem;", "setPanelItem", "(Lcom/tencent/mm/emoji/model/panel/PanelItem;)V", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onBind", "", "item", "plugin-emojisdk_release"})
public class q<I extends ac> extends RecyclerView.v {
    protected I hbh;
    n hbi;

    public /* synthetic */ q(View view) {
        this(view, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(View view, n nVar) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(105679);
        this.hbi = nVar;
        view.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.emoji.panel.a.q.AnonymousClass1 */
            final /* synthetic */ q hbj;

            {
                this.hbj = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(105677);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/emoji/panel/adapter/PanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n nVar = this.hbj.hbi;
                if (nVar != null) {
                    p.g(view, LocaleUtil.ITALIAN);
                    Context context = view.getContext();
                    p.g(context, "it.context");
                    nVar.a(view, context, this.hbj.lR(), this.hbj.hbh);
                }
                a.a(this, "com/tencent/mm/emoji/panel/adapter/PanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(105677);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.tencent.mm.emoji.panel.a.q.AnonymousClass2 */
            final /* synthetic */ q hbj;

            {
                this.hbj = r1;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(199969);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/emoji/panel/adapter/PanelViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                n nVar = this.hbj.hbi;
                if (nVar != null) {
                    p.g(view, LocaleUtil.ITALIAN);
                    Context context = view.getContext();
                    p.g(context, "it.context");
                    nVar.a(view, context, this.hbj.lR());
                }
                a.a(true, (Object) this, "com/tencent/mm/emoji/panel/adapter/PanelViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(199969);
                return true;
            }
        });
        AppMethodBeat.o(105679);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.emoji.b.b.ac */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ac acVar) {
        AppMethodBeat.i(105678);
        p.h(acVar, "item");
        this.hbh = acVar;
        AppMethodBeat.o(105678);
    }
}
