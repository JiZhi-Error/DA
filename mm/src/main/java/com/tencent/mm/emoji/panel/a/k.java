package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public class k extends q<h> {
    private final TextView hbb;
    private final ImageView kc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105670);
        View findViewById = view.findViewById(R.id.ur);
        p.g(findViewById, "itemView.findViewById(R.id.art_emoji_icon_iv)");
        this.kc = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.us);
        p.g(findViewById2, "itemView.findViewById(R.id.art_emoji_icon_text)");
        this.hbb = (TextView) findViewById2;
        AppMethodBeat.o(105670);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public void a(ac acVar) {
        AppMethodBeat.i(105669);
        p.h(acVar, "item");
        super.a(acVar);
        h hVar = (h) this.hbh;
        if (hVar != null) {
            e eVar = e.gVM;
            e.a(hVar.gWm, this.kc);
            if (hVar.gYc == 2) {
                this.hbb.setVisibility(0);
                a ah = g.ah(d.class);
                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                this.hbb.setText(((d) ah).getProvider().amp(hVar.gWm.getMd5()));
                AppMethodBeat.o(105669);
                return;
            }
            if (p.j(hVar.gWm.getName(), "dice")) {
                ImageView imageView = this.kc;
                View view = this.aus;
                p.g(view, "itemView");
                imageView.setContentDescription(view.getContext().getString(R.string.bsa));
            } else if (p.j(hVar.gWm.getName(), "jsb")) {
                ImageView imageView2 = this.kc;
                View view2 = this.aus;
                p.g(view2, "itemView");
                imageView2.setContentDescription(view2.getContext().getString(R.string.bsk));
            }
            this.hbb.setVisibility(8);
            AppMethodBeat.o(105669);
            return;
        }
        AppMethodBeat.o(105669);
    }
}
